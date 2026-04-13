/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.PBotNetworkManager
 *  neo.deobf.ServerStatusPinger
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.Packet
 *  net.minecraft.network.status.INetHandlerStatusClient
 *  net.minecraft.network.status.client.CPacketPing
 *  net.minecraft.network.status.server.SPacketPong
 *  net.minecraft.network.status.server.SPacketServerInfo
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  org.jetbrains.annotations.NotNull
 */
package neo.deobf;

import neo.deobf.PBotNetworkManager;
import neo.deobf.ServerStatusPinger;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.status.INetHandlerStatusClient;
import net.minecraft.network.status.client.CPacketPing;
import net.minecraft.network.status.server.SPacketPong;
import net.minecraft.network.status.server.SPacketServerInfo;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Exception performing whole class analysis ignored.
 */
class StatusPingHandler
implements INetHandlerStatusClient {
    final ServerStatusPinger this$0;
    public final PBotNetworkManager val$networkmanager;

    public void handleServerInfo(@NotNull SPacketServerInfo packetIn) {
        this.val$networkmanager.sendPacket((Packet)new CPacketPing(Minecraft.getSystemTime()));
    }

    public void handlePong(@NotNull SPacketPong packetIn) {
        this.val$networkmanager.closeChannel((ITextComponent)new TextComponentString("Finished"));
    }

    public void onDisconnect(@NotNull ITextComponent reason) {
    }

    StatusPingHandler(ServerStatusPinger this$0, PBotNetworkManager cP) {
        this.this$0 = this$0;
        this.val$networkmanager = cP;
    }
}

