/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.PBot
 *  neo.deobf.PBotNetworkManager
 *  neo.deobf.StatusPingHandler
 *  neo.deobf.ProxyInfo
 *  net.minecraft.network.EnumConnectionState
 *  net.minecraft.network.INetHandler
 *  net.minecraft.network.Packet
 *  net.minecraft.network.handshake.client.C00Handshake
 *  net.minecraft.network.status.client.CPacketServerQuery
 */
package com.botclient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import com.botclient.PBot;
import com.botclient.PBotNetworkManager;
import com.botclient.StatusPingHandler;
import com.botclient.ProxyInfo;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.handshake.HandshakeC2SPacket;
import net.minecraft.network.packet.status.client.StatusQueryC2SPacket;

public class ServerStatusPinger {

    public void ping(PBot pbot) throws UnknownHostException {
        InetAddress serveraddress = InetAddress.getByName(pbot.getHost());
        PBotNetworkManager networkmanager = PBotNetworkManager.createNetworkManagerAndConnect((InetAddress)serveraddress, (int)pbot.getPort(), (PBot)pbot, (ProxyInfo)pbot.getProxy());
        networkmanager.setNetHandler((PacketListener)new StatusPingHandler(this, networkmanager));
        try {
            networkmanager.sendPacket((Packet)new HandshakeC2SPacket(pbot.getHost(), pbot.getPort(), 1)); // 1 = STATUS state ID
            networkmanager.sendPacket((Packet)new StatusQueryC2SPacket());
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

