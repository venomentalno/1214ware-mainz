/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.BooleanSetting
 *  neo.deobf.Module
 */
package com.botclient;

import com.botclient.Setting;
import com.botclient.ModuleCategory;
import com.botclient.BooleanSetting;
import com.botclient.Module;

public class BotBaritoneModule
extends Module {
    public static BooleanSetting autoSwim;
    public static BooleanSetting autoJump;

    public BotBaritoneModule() {
        super("Bot-Baritone", ModuleCategory.Bots);
        Setting[] settings = new Setting[2];
        settings[0] = autoJump;
        settings[1] = autoSwim;
        this.addSetting(settings);
    }

    static {
        autoJump = new BooleanSetting("AutoJump", true);
        autoSwim = new BooleanSetting("AutoSwim", true);
    }
public void onEnable() {
        super.onEnable();
        this.toggle();
    }
}





