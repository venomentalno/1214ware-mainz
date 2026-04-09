/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.PBotNetworkManager
 *  neo.deobf.ServerStatusPinger
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.Packet
 *  net.minecraft.network.status.PacketListenerStatusClient
 *  net.minecraft.network.status.client.CPacketPing
 *  net.minecraft.network.status.server.SPacketPong
 *  net.minecraft.network.status.server.SPacketServerInfo
 *  net.minecraft.util.text.Text
 *  net.minecraft.util.text.LiteralTextContent
 *  org.jetbrains.annotations.NotNull
 */
package com.botclient;

import com.botclient.PBotNetworkManager;
import com.botclient.ServerStatusPinger;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.status.PacketListenerStatusClient;
import net.minecraft.network.status.server.SPacketPong;
import net.minecraft.network.status.server.SPacketServerInfo;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Exception performing whole class analysis ignored.
 */
class StatusPingHandler
implements PacketListenerStatusClient {
    final ServerStatusPinger this$0;
    public final PBotNetworkManager val$networkmanager;

    public void handleServerInfo(@NotNull SPacketServerInfo packetIn) {
        this.val$networkmanager.sendPacket((Packet)new CPacketPing(Minecraft.getSystemTime()));
    }

    public void handlePong(@NotNull SPacketPong packetIn) {
        this.val$networkmanager.closeChannel((Text)new LiteralTextContent("Finished"));
    }

    public void onDisconnect(@NotNull Text reason) {
    }

    StatusPingHandler(ServerStatusPinger this$0, PBotNetworkManager cP) {
        this.this$0 = this$0;
        this.val$networkmanager = cP;
    }
}

