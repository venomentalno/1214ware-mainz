/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.BooleanSetting
 *  neo.deobf.Module
 */
package neo.deobf;

import neo.deobf.Setting;
import neo.deobf.ModuleCategory;
import neo.deobf.BooleanSetting;
import neo.deobf.Module;

public class BotDebugModule
extends Module {
    public static BooleanSetting connecting;
    public static BooleanSetting chat;
    public static BooleanSetting captcha;
    public static BooleanSetting internalErrors;
    public static BooleanSetting rejoin;
    public static BooleanSetting chunkCache;
    public static BooleanSetting baritoneDebug;
    public static BooleanSetting notifications;
    public static BooleanSetting mouseclicks;
    public static BooleanSetting scriptErrors;
    public static BooleanSetting disconnect;

    static {
        chat = new BooleanSetting("Chat", true);
        disconnect = new BooleanSetting("Disconnect", true);
        rejoin = new BooleanSetting("Rejoin", false);
        connecting = new BooleanSetting("Connecting", true);
        mouseclicks = new BooleanSetting("MouseClicks", true);
        notifications = new BooleanSetting("Notifications", true);
        scriptErrors = new BooleanSetting("ScriptErrors", true);
        internalErrors = new BooleanSetting("InternalErrors", false);
        chunkCache = new BooleanSetting("Chunk Cache", false);
        baritoneDebug = new BooleanSetting("Baritone Debug", false);
        captcha = new BooleanSetting("Captcha answers", true);
    }

    public BotDebugModule() {
        super("Bot Debug", ModuleCategory.Bots);
        Setting[] settings = new Setting[11];
        settings[0] = chat;
        settings[1] = connecting;
        settings[2] = disconnect;
        settings[3] = rejoin;
        settings[4] = mouseclicks;
        settings[5] = notifications;
        settings[6] = scriptErrors;
        settings[7] = internalErrors;
        settings[8] = chunkCache;
        settings[9] = baritoneDebug;
        settings[10] = captcha;
        this.addSetting(settings);
    }

    public void onEnable() {
        super.onEnable();
        this.toggle();
    }
}





