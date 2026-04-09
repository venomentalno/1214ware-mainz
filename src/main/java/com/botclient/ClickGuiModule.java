/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.ClickGuiScreen
 *  neo.deobf.BooleanSetting
 *  neo.deobf.Module
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 */
package com.botclient;

import com.botclient.Setting;
import com.botclient.ModuleCategory;
import com.botclient.ClickGuiScreen;
import com.botclient.BooleanSetting;
import com.botclient.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ClickGuiModule
extends Module {
    public static BooleanSetting wiki;
    public static BooleanSetting snow;
public void onEnable() {
        super.onEnable();
        (mc).displayGuiScreen((GuiScreen)new ClickGuiScreen());
        this.toggle();
    }

    static {
        snow = new BooleanSetting("Снег", false);
        wiki = new BooleanSetting("Подсказки", true);
    }

    public ClickGuiModule() {
        super("ClickGui", ModuleCategory.Other);
        this.moduleKey = 54;
        Setting[] settings = new Setting[2];
        settings[0] = snow;
        settings[1] = wiki;
        this.addSetting(settings);
    }
}

