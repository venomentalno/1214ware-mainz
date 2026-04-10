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
package neo.deobf;

import java.net.InetAddress;
import java.net.UnknownHostException;
import neo.deobf.PBot;
import neo.deobf.PBotNetworkManager;
import neo.deobf.StatusPingHandler;
import neo.deobf.ProxyInfo;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.status.client.CPacketServerQuery;

public class ServerStatusPinger {

    public void ping(PBot pbot) throws UnknownHostException {
        InetAddress serveraddress = InetAddress.getByName(pbot.getHost());
        PBotNetworkManager networkmanager = PBotNetworkManager.createNetworkManagerAndConnect((InetAddress)serveraddress, (int)pbot.getPort(), (PBot)pbot, (ProxyInfo)pbot.getProxy());
        networkmanager.setNetHandler((INetHandler)new StatusPingHandler(this, networkmanager));
        try {
            networkmanager.sendPacket((Packet)new C00Handshake(pbot.getHost(), pbot.getPort(), (EnumConnectionState.STATUS)));
            networkmanager.sendPacket((Packet)new CPacketServerQuery());
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

