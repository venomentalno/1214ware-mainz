/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.NumberSetting
 *  neo.deobf.Module
 */
package com.botclient;

import com.botclient.Setting;
import com.botclient.ModuleCategory;
import com.botclient.NumberSetting;
import com.botclient.Module;

public class AutoRejoinModule
extends Module {
    public static NumberSetting reconnecttime = new NumberSetting("Time(ms)", 1000.0f, 100.0f, 15000.0f, 10.0f);

    public AutoRejoinModule() {
        super("Auto Rejoin", ModuleCategory.Bots);
        Setting[] settings = new Setting[1];
        settings[0] = reconnecttime;
        this.addSetting(settings);
    }
}





