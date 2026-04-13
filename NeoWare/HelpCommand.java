/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  neo.deobf.CommandInfo
 *  neo.deobf.Command
 *  neo.deobf.Client
 *  neo.deobf.CommandManager
 *  neo.deobf.CommandChatListener
 */
package neo.deobf;

import com.mojang.realmsclient.gui.ChatFormatting;
import neo.deobf.CommandInfo;
import neo.deobf.Command;
import neo.deobf.Client;
import neo.deobf.CommandManager;
import neo.deobf.CommandChatListener;

@CommandInfo(name="help", description="Help")
public class HelpCommand
extends Command {
    public void execute(String[] args) throws Exception {
        for (Command command : (Client.getInstance().commandManager).getCommands()) {
            if (command instanceof HelpCommand) continue;
            this.sendMessage((ChatFormatting.WHITE) + (CommandChatListener.PREFIX) + (command.name) + (ChatFormatting.GRAY) + " (" + (ChatFormatting.WHITE) + (command.description) + (ChatFormatting.GRAY) + ")");
        }
    }

    public void error() {
        this.sendMessage((ChatFormatting.RED) + "Help");
    }

}

