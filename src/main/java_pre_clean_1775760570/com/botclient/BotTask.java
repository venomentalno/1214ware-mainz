/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.BooleanSetting
 *  neo.deobf.PBot
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.BotController
 *  neo.deobf.BotDebugModule
 *  neo.deobf.ChatUtils
 */
package com.botclient;

import com.botclient.BooleanSetting;
import com.botclient.PBot;
import com.botclient.PBotMinecraft;
import com.botclient.BotController;
import com.botclient.BotDebugModule;
import com.botclient.ChatUtils;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class BotTask {
    public final String name;
    public final PBot bot;
    public final BotController baritone;
    public final PBotMinecraft mc;

    public void sendDebug(String message) {
        if ((BotTask.getBaritoneDebug().value)) {
            ChatUtils.defaultMsg((String)message);
        }
    }

    public PBot getBot() {
        return (this.bot);
    }

    private static PBotMinecraft getMc(BotTask instance) {
        return instance.mc;
    }

    public String getName() {
        return (this.name);
    }

    private static BotController getBaritone(BotTask instance) {
        return instance.baritone;
    }
public void onFinish() {
        this.sendDebug("&5[&dBot-Baritone&5] &7Bot " + this.getBot().getNickname() + " | ok canceled");
    }

    private static BooleanSetting getBaritoneDebug() {
        return BotDebugModule.baritoneDebug;
    }

    private static PBot getBot(BotTask instance) {
        return instance.bot;
    }

    public PBotMinecraft getMc() {
        return (this.mc);
    }

    private static String getName(BotTask instance) {
        return instance.name;
    }

    public BotController getBaritone() {
        return (this.baritone);
    }

    public BotTask(PBot bot, String name) {
        this.bot = bot;
        this.name = name;
        this.mc = bot.mc;
        this.baritone = bot.getBaritone();
    }

    public abstract void onUpdate();

    public abstract void init();
}

