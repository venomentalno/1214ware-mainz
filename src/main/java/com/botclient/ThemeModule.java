/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.ThemeSetting
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.Module
 */
package neo.deobf;

import java.awt.Color;
import neo.deobf.ThemeSetting;
import neo.deobf.Setting;
import neo.deobf.ModuleCategory;
import neo.deobf.Module;

public class ThemeModule
extends Module {
    public void onEnable() {
        this.toggle();
    }

    public ThemeModule(String name, Color one, Color two) {
        super(name, ModuleCategory.Themes);
        Setting[] settings = new Setting[1];
        settings[0] = new ThemeSetting(name, one, two);
        this.addSetting(settings);
        this.opened = 1;
    }
}





