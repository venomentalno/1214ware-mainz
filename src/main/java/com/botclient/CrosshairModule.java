/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Render2DEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.ColorSetting
 *  neo.deobf.Module
 *  neo.deobf.MinecraftContext
 *  neo.deobf.MathUtils
 *  neo.deobf.DrawUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.PlayerEntitySP
 */
package com.botclient;

import java.awt.Color;
import com.botclient.Render2DEvent;
import com.botclient.EventTarget;
import com.botclient.Setting;
import com.botclient.ModuleCategory;
import com.botclient.ColorSetting;
import com.botclient.Module;
import com.botclient.MinecraftContext;
import com.botclient.MathUtils;
import com.botclient.DrawUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class CrosshairModule
extends Module {
    public float coldwnLast;
    public static ColorSetting color = new ColorSetting("Р¦РІРµС‚", new Color(111, 90, 253).getRGB());

    @EventTarget
    public void onRender2D(Render2DEvent event) {
        int crosshairColor = ((color).color);
        float screenWidth = event.getResolution().getScaledWidth();
        float screenHeight = event.getResolution().getScaledHeight();
        float width = screenWidth / 2.0f;
        float height = screenHeight / 2.0f;
        double cinc = (Minecraft.player).getCooledAttackStrength(0.0f) * 359.0f;
        this.coldwnLast = MathUtils.lerp((double)CrosshairModule.getColdwnLast(this), (double)((float)cinc), (double)0.30000001192092896);
        DrawUtils.drawCircle((float)width, (float)height, (float)1.0f, (float)360.0f, (float)4.0f, (int)new Color(52, 52, 52, 190).hashCode(), (int)(3));
        DrawUtils.drawCircle((float)width, (float)height, (float)1.0f, (float)(1.0f + (this.coldwnLast)), (float)4.0f, (int)crosshairColor, (int)(3));
    }

    public CrosshairModule() {
        super("Crosshair", ModuleCategory.Render);
        Setting[] settings = new Setting[1];
        settings[0] = color;
        this.addSetting(settings);
    }

    private static float getColdwnLast(CrosshairModule instance) {
        return instance.coldwnLast;
    }

}


