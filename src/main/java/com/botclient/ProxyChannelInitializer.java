package com.botclient;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.proxy.HttpProxyHandler;
import io.netty.handler.proxy.Socks4ProxyHandler;
import io.netty.handler.proxy.Socks5ProxyHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.net.InetSocketAddress;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.listener.ClientCommonPacketListener;

public final class ProxyChannelInitializer extends ChannelInitializer<Channel> {
    private final ProxyInfo proxy;
    private final PBotNetworkManager networkManager;

    public ProxyChannelInitializer(ProxyInfo proxy, PBotNetworkManager networkManager) {
        this.proxy = proxy;
        this.networkManager = networkManager;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        if (BotSettingsModule.useProxy != null && BotSettingsModule.useProxy.value && this.proxy != null) {
            String address = this.proxy.address;
            int port = this.proxy.port;
            
            switch (this.proxy.type) {
                case HTTP:
                    if (this.proxy.hasAuthentication()) {
                        channel.pipeline().addFirst("proxy", new HttpProxyHandler(
                            new InetSocketAddress(address, port),
                            this.proxy.username,
                            this.proxy.password
                        ));
                    } else {
                        channel.pipeline().addFirst("proxy", new HttpProxyHandler(
                            new InetSocketAddress(address, port)
                        ));
                    }
                    break;
                case SOCKS4:
                    channel.pipeline().addFirst("proxy", new Socks4ProxyHandler(
                        new InetSocketAddress(address, port)
                    ));
                    break;
                case SOCKS5:
                    if (this.proxy.hasAuthentication()) {
                        channel.pipeline().addFirst("proxy", new Socks5ProxyHandler(
                            new InetSocketAddress(address, port),
                            this.proxy.username,
                            this.proxy.password
                        ));
                    } else {
                        channel.pipeline().addFirst("proxy", new Socks5ProxyHandler(
                            new InetSocketAddress(address, port)
                        ));
                    }
                    break;
                default:
                    break;
            }
        }
        
        // Add timeout handler
        channel.pipeline().addLast("timeout", new ReadTimeoutHandler(30));
        
        // The network manager will handle packet encoding/decoding
        channel.pipeline().addLast("packet_handler", this.networkManager);
    }
}
