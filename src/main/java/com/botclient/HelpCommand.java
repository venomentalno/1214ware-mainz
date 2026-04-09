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
package com.botclient;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.botclient.CommandInfo;
import com.botclient.Command;
import com.botclient.Client;
import com.botclient.CommandManager;
import com.botclient.CommandChatListener;

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

