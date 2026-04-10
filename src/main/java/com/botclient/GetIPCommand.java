/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CommandInfo
 *  neo.deobf.Command
 *  neo.deobf.CommandChatListener
 *  neo.deobf.ChatUtils
 *  neo.deobf.ServerAddressUtils
 *  net.minecraft.client.Minecraft
 */
package neo.deobf;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.InetSocketAddress;
import neo.deobf.CommandInfo;
import neo.deobf.Command;
import neo.deobf.CommandChatListener;
import neo.deobf.ChatUtils;
import neo.deobf.ServerAddressUtils;
import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@CommandInfo(name="getip", description="Получить айпи сервера.")
public class GetIPCommand
extends Command {
    public void error() {
        ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "getip - Получить айпи сервера."));
    }

    public void execute(String[] args) throws Exception {
        String serverAddress = "";
        serverAddress = !(mc).isSingleplayer() ? new InetSocketAddress(ServerAddressUtils.getIp(), ServerAddressUtils.getPort()).toString() : "Localhost";
        ChatUtils.formatMsg((String)("Айпи сервера: " + serverAddress));
        StringSelection selection = new StringSelection(serverAddress);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

}

