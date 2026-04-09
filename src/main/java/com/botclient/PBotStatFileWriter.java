/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.BooleanSetting
 *  neo.deobf.PBot
 *  neo.deobf.PBotNetHandlerPlayClient
 *  neo.deobf.PBotNetworkManager
 *  neo.deobf.BotDebugModule
 *  neo.deobf.ChatUtils
 *  net.minecraft.network.EnumConnectionState
 *  net.minecraft.network.PacketListener
 *  net.minecraft.network.login.PacketListenerLoginClient
 *  net.minecraft.network.login.server.DisconnectS2CPacket
 *  net.minecraft.network.login.server.SPacketEnableCompression
 *  net.minecraft.network.login.server.SPacketEncryptionRequest
 *  net.minecraft.network.login.server.SPacketLoginSuccess
 *  net.minecraft.util.text.Text
 */
package com.botclient;

import com.botclient.BooleanSetting;
import com.botclient.PBot;
import com.botclient.PBotNetHandlerPlayClient;
import com.botclient.PBotNetworkManager;
import com.botclient.BotDebugModule;
import com.botclient.ChatUtils;
// Removed: EnumConnectionState not in 1.21.4
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.login.PacketListenerLoginClient;
import net.minecraft.network.login.server.DisconnectS2CPacket;
import net.minecraft.network.login.server.SPacketEnableCompression;
import net.minecraft.network.login.server.SPacketEncryptionRequest;
import net.minecraft.network.login.server.SPacketLoginSuccess;
import net.minecraft.text.Text;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PBotStatFileWriter
implements PacketListenerLoginClient {
    public final PBotNetworkManager networkManager;
    public final PBot pbot;

    public void handleLoginSuccess(SPacketLoginSuccess packetIn) {
        (this.networkManager).setConnectionState((EnumConnectionState.PLAY));
        (this.networkManager).setNetHandler((PacketListener)new PBotNetHandlerPlayClient((this.pbot)));
    }

public PBotStatFileWriter(PBotNetworkManager networkManagerIn, PBot pbot) {
        this.networkManager = networkManagerIn;
        this.pbot = pbot;
    }

    public void onDisconnect(Text reason) {
    }

    private static BooleanSetting getDisconnect() {
        return BotDebugModule.disconnect;
    }

    private static BooleanSetting getDisconnect2() {
        return BotDebugModule.disconnect;
    }

    public void handleEnableCompression(SPacketEnableCompression packetIn) {
        if (!(this.networkManager).isLocalChannel()) {
            (this.networkManager).setCompressionThreshold(packetIn.getCompressionThreshold());
        }
    }

    public void handleEncryptionRequest(SPacketEncryptionRequest packetIn) {
        if ((PBotStatFileWriter.getDisconnect().value)) {
            ChatUtils.formatMsg((String)("Отключение &d&l" + (this.pbot).getNickname() + "&f&l Invalid session (Try restarting your game and the launcher)"));
        }
    }

    public void handleDisconnect(DisconnectS2CPacket packetIn) {
        if ((PBotStatFileWriter.getDisconnect2().value)) {
            ChatUtils.formatMsg((String)("Отключение &d&l" + (this.pbot).getNickname() + "&f&l " + packetIn.getReason().getFormattedText()));
        }
        (this.networkManager).closeChannel(packetIn.getReason());
    }

}

