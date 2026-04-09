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

public class ItemScrollerModule
extends Module {
    public static NumberSetting scrollerDelay = new NumberSetting("Задержка", 80.0f, 0.0f, 100.0f, 1.0f);
public ItemScrollerModule() {
        super("ItemScroller", ModuleCategory.Other);
        Setting[] settings = new Setting[1];
        settings[0] = scrollerDelay;
        this.addSetting(settings);
    }
}





