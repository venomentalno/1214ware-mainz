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

public class NoPushModule
extends Module {
    public static BooleanSetting blocks;
    public static BooleanSetting water;
    public static BooleanSetting players;
static {
        water = new BooleanSetting("Вода", true);
        players = new BooleanSetting("Существа", true);
        blocks = new BooleanSetting("Блоки", true);
    }

    public NoPushModule() {
        super("NoPush", ModuleCategory.Player);
        Setting[] settings = new Setting[3];
        settings[0] = players;
        settings[1] = water;
        settings[2] = blocks;
        this.addSetting(settings);
    }
}





