/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CommandInfo
 *  neo.deobf.Command
 *  neo.deobf.CommandChatListener
 *  neo.deobf.ChatUtils
 */
package neo.deobf;

import neo.deobf.CommandInfo;
import neo.deobf.Command;
import neo.deobf.CommandChatListener;
import neo.deobf.ChatUtils;

@CommandInfo(name="setprefix", description="Установка префикса в командах")
public class SetPrefixCommand
extends Command {
    public void execute(String[] args) throws Exception {
        if (args.length == (1)) {
            CommandChatListener.PREFIX = args[0];
            ChatUtils.formatMsg((String)("Префикс команд сменен на " + (CommandChatListener.PREFIX)));
        } else {
            this.error();
        }
    }

    public void error() {
        ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "setprefix <префикс> - Установка префикса в командах."));
    }

}

