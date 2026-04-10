package neo.deobf;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.connection.UserConnectionImpl;
import com.viaversion.viaversion.protocol.ProtocolPipelineImpl;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.proxy.HttpProxyHandler;
import io.netty.handler.proxy.Socks4ProxyHandler;
import io.netty.handler.proxy.Socks5ProxyHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import net.minecraft.network.*;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

// 1.21.4: packet direction enum is now PacketFlow (CLIENTBOUND/SERVERBOUND)
//         Codec classes: Varint21FrameDecoder, Varint21LengthFieldPrepender
//         ViaFabricPlus pipeline class replaces MCPVLBPipeline
public final class ProxyChannelInitializer extends ChannelInitializer<Channel> {
    private final ProxyInfo          proxy;
    private final PBotNetworkManager networkManager;

    public ProxyChannelInitializer(ProxyInfo proxy, PBotNetworkManager networkManager) {
        this.proxy          = proxy;
        this.networkManager = networkManager;
    }

    @Override
    protected void initChannel(Channel ch) {
        // Install proxy handler first if needed
        if (BotSettingsModule.useProxy.value && proxy != null
                && proxy.getType() != ProxyType.NO_PROXY) {
            SocketAddress addr = new InetSocketAddress(
                    proxy.getProxy().split(":")[0],
                    Integer.parseInt(proxy.getProxy().split(":")[1]));
            ChannelHandler proxyHandler;
            if (proxy.getType() == ProxyType.HTTP) {
                HttpProxyHandler h = new HttpProxyHandler(addr);
                h.setConnectTimeoutMillis(9500L);
                proxyHandler = h;
            } else if (proxy.getType() == ProxyType.SOCKS4) {
                Socks4ProxyHandler h = new Socks4ProxyHandler(addr);
                h.setConnectTimeoutMillis(9500L);
                proxyHandler = h;
            } else { // SOCKS5
                Socks5ProxyHandler h = proxy.isAuthenticated()
                        ? new Socks5ProxyHandler(addr, proxy.getUsername(), proxy.getPassword())
                        : new Socks5ProxyHandler(addr);
                h.setConnectTimeoutMillis(9500L);
                proxyHandler = h;
            }
            ch.pipeline().addLast(proxyHandler);
        }

        // 1.21.4 codec pipeline
        ch.pipeline()
            .addLast("timeout",   new ReadTimeoutHandler(30))
            .addLast("splitter",  new Varint21FrameDecoder(null))
            .addLast("decoder",   new PacketDecoder<>(PacketFlow.CLIENTBOUND))
            .addLast("prepender", new Varint21LengthFieldPrepender())
            .addLast("encoder",   new PacketEncoder<>(PacketFlow.SERVERBOUND))
            .addLast("packet_handler", networkManager);

        // ViaVersion multi-version support (ViaFabricPlus / ViaLoadingBase)
        try {
            int targetVer = ViaLoadingBase.getInstance().getTargetVersion().getVersion();
            // 766 = 1.21.4 native — skip if already native
            if (ch instanceof SocketChannel && targetVer != 766) {
                UserConnection user = new UserConnectionImpl(ch, true);
                new ProtocolPipelineImpl(user);
                // ViaFabricPlus replaces MCPVLBPipeline in modern builds.
                // If you use ViaLoadingBase standalone, swap this for your pipeline class:
                ch.pipeline().addLast(new de.florianmichael.vialoadingbase.netty.VLBPipeline(user));
            }
        } catch (Exception ignored) {
            // Via not present or not needed
        }
    }
}
