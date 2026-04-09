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

public class ItemPhysicsModule
extends Module {
    public static NumberSetting physicsSpeed = new NumberSetting("Скорость", 0.5f, 0.100000001f, 5.0f, 0.5f);
public ItemPhysicsModule() {
        super("ItemPhysics", ModuleCategory.Render);
        Setting[] settings = new Setting[1];
        settings[0] = physicsSpeed;
        this.addSetting(settings);
    }
}





