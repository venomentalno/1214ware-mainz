package com.botclient;

import io.netty.channel.Channel;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.packet.Packet;
import net.minecraft.text.Text;

public class PBotNetworkManager extends ClientConnection {
    private final PBot pbot;
    
    public PBotNetworkManager(PBot bot, NetworkSide side) {
        super(side);
        this.pbot = bot;
    }
    
    @Override
    protected void channelRead0(io.netty.channel.ChannelHandlerContext ctx, Packet<?> packet) throws Exception {
        // Intercept and handle packets
        super.channelRead0(ctx, packet);
    }
    
    public void send(Packet<?> packet) {
        if (this.channel != null && this.channel.isOpen()) {
            this.channel.writeAndFlush(packet);
        }
    }
    
    @Override
    public void disconnect(Text reason) {
        super.disconnect(reason);
        if (this.pbot != null) {
            this.pbot.disconnect();
        }
    }
    
    @Override
    public void handlePacket(Packet<?> packet) {
        // Custom packet handling
        super.handlePacket(packet);
    }
}