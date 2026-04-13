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
 *  net.minecraft.network.INetHandler
 *  net.minecraft.network.login.INetHandlerLoginClient
 *  net.minecraft.network.login.server.SPacketDisconnect
 *  net.minecraft.network.login.server.SPacketEnableCompression
 *  net.minecraft.network.login.server.SPacketEncryptionRequest
 *  net.minecraft.network.login.server.SPacketLoginSuccess
 *  net.minecraft.util.text.ITextComponent
 */
package neo.deobf;

import neo.deobf.BooleanSetting;
import neo.deobf.PBot;
import neo.deobf.PBotNetHandlerPlayClient;
import neo.deobf.PBotNetworkManager;
import neo.deobf.BotDebugModule;
import neo.deobf.ChatUtils;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.INetHandler;
import net.minecraft.network.login.INetHandlerLoginClient;
import net.minecraft.network.login.server.SPacketDisconnect;
import net.minecraft.network.login.server.SPacketEnableCompression;
import net.minecraft.network.login.server.SPacketEncryptionRequest;
import net.minecraft.network.login.server.SPacketLoginSuccess;
import net.minecraft.util.text.ITextComponent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PBotStatFileWriter
implements INetHandlerLoginClient {
    public final PBotNetworkManager networkManager;
    public final PBot pbot;

    public void handleLoginSuccess(SPacketLoginSuccess packetIn) {
        (this.networkManager).setConnectionState((EnumConnectionState.PLAY));
        (this.networkManager).setNetHandler((INetHandler)new PBotNetHandlerPlayClient((this.pbot)));
    }

public PBotStatFileWriter(PBotNetworkManager networkManagerIn, PBot pbot) {
        this.networkManager = networkManagerIn;
        this.pbot = pbot;
    }

    public void onDisconnect(ITextComponent reason) {
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

    public void handleDisconnect(SPacketDisconnect packetIn) {
        if ((PBotStatFileWriter.getDisconnect2().value)) {
            ChatUtils.formatMsg((String)("Отключение &d&l" + (this.pbot).getNickname() + "&f&l " + packetIn.getReason().getFormattedText()));
        }
        (this.networkManager).closeChannel(packetIn.getReason());
    }

}

