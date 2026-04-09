package com.botclient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import net.minecraft.network.packet.c2s.handshake.HandshakeC2SPacket;
import net.minecraft.network.packet.c2s.query.QueryRequestC2SPacket;

public class ServerStatusPinger {

    public void ping(PBot pbot) throws UnknownHostException {
        InetAddress serveraddress = InetAddress.getByName(pbot.getHost());
        PBotNetworkManager networkmanager = PBotNetworkManager.createNetworkManagerAndConnect(
            serveraddress, 
            pbot.getPort(), 
            pbot, 
            pbot.getProxy()
        );
        
        StatusPingHandler handler = new StatusPingHandler(this, networkmanager);
        networkmanager.setNetHandler(handler);
        
        try {
            networkmanager.sendPacket(new HandshakeC2SPacket(pbot.getHost(), pbot.getPort(), net.minecraft.network.NetworkState.STATUS));
            networkmanager.sendPacket(new QueryRequestC2SPacket());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
