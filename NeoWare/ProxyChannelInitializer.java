package neo.deobf;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.connection.UserConnectionImpl;
import com.viaversion.viaversion.protocol.ProtocolPipelineImpl;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import de.florianmichael.viamcp.MCPVLBPipeline;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.proxy.HttpProxyHandler;
import io.netty.handler.proxy.Socks4ProxyHandler;
import io.netty.handler.proxy.Socks5ProxyHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NettyPacketDecoder;
import net.minecraft.network.NettyPacketEncoder;
import net.minecraft.network.NettyVarint21FrameDecoder;
import net.minecraft.network.NettyVarint21FrameEncoder;

public final class ProxyChannelInitializer extends ChannelInitializer<Channel> {
    public final ProxyInfo val$proxy;
    public final PBotNetworkManager val$networkmanager;

    public ProxyChannelInitializer(ProxyInfo proxy, PBotNetworkManager networkManager) {
        this.val$proxy = proxy;
        this.val$networkmanager = networkManager;
    }

    @Override
    protected void initChannel(Channel ctx) {
        if ((BotSettingsModule.useProxy).value) {
            if (this.val$proxy.getType().equals(ProxyType.HTTP)) {
                HttpProxyHandler http = new HttpProxyHandler((SocketAddress)new InetSocketAddress(this.val$proxy.getProxy().split(":")[0], Integer.parseInt(this.val$proxy.getProxy().split(":")[1])));
                http.setConnectTimeoutMillis(9500L);
                ctx.pipeline().addLast(new ChannelHandler[]{http});
            } else if (this.val$proxy.getType().equals(ProxyType.SOCKS4)) {
                Socks4ProxyHandler socks4 = new Socks4ProxyHandler((SocketAddress)new InetSocketAddress(this.val$proxy.getProxy().split(":")[0], Integer.parseInt(this.val$proxy.getProxy().split(":")[1])));
                socks4.setConnectTimeoutMillis(9500L);
                ctx.pipeline().addLast(new ChannelHandler[]{socks4});
            } else if (this.val$proxy.getType().equals(ProxyType.SOCKS5)) {
                Socks5ProxyHandler socks5;
                if (this.val$proxy.isAuthenticated()) {
                    socks5 = new Socks5ProxyHandler((SocketAddress)new InetSocketAddress(this.val$proxy.getProxy().split(":")[0], Integer.parseInt(this.val$proxy.getProxy().split(":")[1])), this.val$proxy.getUsername(), this.val$proxy.getPassword());
                } else {
                    socks5 = new Socks5ProxyHandler((SocketAddress)new InetSocketAddress(this.val$proxy.getProxy().split(":")[0], Integer.parseInt(this.val$proxy.getProxy().split(":")[1])));
                }
                socks5.setConnectTimeoutMillis(9500L);
                ctx.pipeline().addLast(new ChannelHandler[]{socks5});
            }
        }
        ctx.pipeline().addLast("timeout", new ReadTimeoutHandler(30))
            .addLast("splitter", new NettyVarint21FrameDecoder())
            .addLast("decoder", new NettyPacketDecoder(EnumPacketDirection.CLIENTBOUND))
            .addLast("prepender", new NettyVarint21FrameEncoder())
            .addLast("encoder", new NettyPacketEncoder(EnumPacketDirection.SERVERBOUND))
            .addLast("packet_handler", this.val$networkmanager);

        if (ctx instanceof SocketChannel && ViaLoadingBase.getInstance().getTargetVersion().getVersion() != 340) {
            UserConnectionImpl user = new UserConnectionImpl(ctx, true);
            new ProtocolPipelineImpl((UserConnection)user);
            ctx.pipeline().addLast(new ChannelHandler[]{new MCPVLBPipeline((UserConnection)user)});
        }
    }
}
