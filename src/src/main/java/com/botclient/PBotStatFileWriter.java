package neo.deobf;

import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.PacketListener;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.login.*;

/**
 * 1.21.4 port of PBotStatFileWriter (login handler).
 *
 * Key changes:
 *  - INetHandlerLoginClient   → ClientLoginPacketListener
 *  - SPacketLoginSuccess       → ClientboundLoginFinishedPacket
 *  - SPacketEncryptionRequest  → ClientboundHelloPacket
 *  - SPacketEnableCompression  → ClientboundLoginCompressionPacket
 *  - SPacketDisconnect (login) → ClientboundLoginDisconnectPacket
 *  - ITextComponent            → Component
 *  - EnumConnectionState.PLAY  → ConnectionProtocol.PLAY
 */
public class PBotStatFileWriter implements ClientLoginPacketListener {
    public final PBotNetworkManager networkManager;
    public final PBot               pbot;

    public PBotStatFileWriter(PBotNetworkManager networkManager, PBot pbot) {
        this.networkManager = networkManager;
        this.pbot           = pbot;
    }

    @Override
    public void handleLoginFinished(ClientboundLoginFinishedPacket packet) {
        networkManager.setConnectionState(ConnectionProtocol.PLAY);
        networkManager.setNetHandler(new PBotNetHandlerPlayClient(pbot));
    }

    @Override
    public void handleHello(ClientboundHelloPacket packet) {
        // Encryption request — offline bots simply disconnect on premium servers
        if (BotDebugModule.disconnect.value) {
            ChatUtils.formatMsg("Disconnecting &d&l" + pbot.getNickname()
                    + "&f&l Invalid session (Try restarting your game and the launcher)");
        }
    }

    @Override
    public void handleLoginCompression(ClientboundLoginCompressionPacket packet) {
        if (!networkManager.isLocalChannel()) {
            networkManager.setCompressionThreshold(packet.getCompressionThreshold());
        }
    }

    @Override
    public void handleDisconnect(ClientboundLoginDisconnectPacket packet) {
        if (BotDebugModule.disconnect.value) {
            ChatUtils.formatMsg("Disconnecting &d&l" + pbot.getNickname()
                    + "&f&l " + packet.getReason().getString());
        }
        networkManager.closeChannel(packet.getReason());
    }

    @Override
    public void onDisconnect(Component reason) { /* no-op */ }

    @Override
    public boolean isAcceptingMessages() { return networkManager.isChannelOpen(); }

    // 1.21.4: PacketListener requires this
    @Override
    public net.minecraft.network.ConnectionProtocol protocol() {
        return ConnectionProtocol.LOGIN;
    }
}
