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

public class DiscordRPCModule
extends Module {
    public static BooleanSetting hideServer = new BooleanSetting("Hide IP", false);

    public void onEnable() {
        super.onEnable();
        this.toggle();
    }
public DiscordRPCModule() {
        super("DiscordRPC", ModuleCategory.Other);
        Setting[] settings = new Setting[1];
        settings[0] = hideServer;
        this.addSetting(settings);
    }
}





