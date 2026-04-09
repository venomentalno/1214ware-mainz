/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.EventTarget
 *  neo.deobf.CommandManager
 *  neo.deobf.PBot
 *  neo.deobf.BotsCommand
 *  neo.deobf.ChatMessageEvent
 */
package com.botclient;

import com.botclient.EventTarget;
import com.botclient.CommandManager;
import com.botclient.PBot;
import com.botclient.BotsCommand;
import com.botclient.ChatMessageEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class CommandChatListener {
    public CommandManager commandManager;
    public static String PREFIX = ".";

    @EventTarget
    public void onMessage(ChatMessageEvent event) {
        String msg = event.getMessage();
        if (msg.length() > 0 && msg.startsWith((PREFIX))) {
            (this.commandManager).execute(msg);
            event.setCancelled(true);
        } else if ((BotsCommand.mirror)) {
            for (PBot bot : PBot.getOnline()) {
                try {
                    bot.sendMessage(msg);
                }
                catch (Exception exception) {}
            }
        }
    }

    public CommandChatListener(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

}

