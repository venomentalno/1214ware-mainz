/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.UpdateEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.BooleanSetting
 *  neo.deobf.ColorSetting
 *  neo.deobf.ModeSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.Module
 *  neo.deobf.MinecraftContext
 *  neo.deobf.PacketReceiveEvent
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientWorld
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 */
package com.botclient;

import java.awt.Color;
import com.botclient.UpdateEvent;
import com.botclient.EventTarget;
import com.botclient.Setting;
import com.botclient.ModuleCategory;
import com.botclient.BooleanSetting;
import com.botclient.ColorSetting;
import com.botclient.ModeSetting;
import com.botclient.NumberSetting;
import com.botclient.Module;
import com.botclient.MinecraftContext;
import com.botclient.PacketReceiveEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.s2c.play.SPacketTimeUpdate;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class WorldModule
extends Module {
    public static BooleanSetting snow = new BooleanSetting("Снег", true);
    public static BooleanSetting worldColor;
    public ModeSetting ambienceMode;
    public NumberSetting ambienceSpeed;
    public long spinTime = GenericCancelableEventB;
    public BooleanSetting ambience = new BooleanSetting("Время суток", false);
    public static ColorSetting weatherColor;
    public static ColorSetting worldColors;

    @EventTarget
    public void onPacket(PacketReceiveEvent event) {
        if ((WorldModule.getAmbience2(this).value) && event.getPacket() instanceof SPacketTimeUpdate) {
            event.setCancelled(true);
        }
    }

    public WorldModule() {
        super("World", ModuleCategory.Render);
        String[] stringArray = new String[4];
        stringArray[0] = "Night";
        stringArray[1] = "Morning";
        stringArray[2] = "Sunset";
        stringArray[3] = "Spin";
        this.ambienceMode = new ModeSetting("???", "Day", stringArray);
        this.ambienceSpeed = new NumberSetting("Скорость", 20.0f, 0.100000001f, 1000.0f, 1.0f);
        Setting[] settings = new Setting[7];
        settings[0] = snow;
        settings[1] = weatherColor;
        settings[2] = worldColor;
        settings[3] = worldColors;
        settings[4] = this.ambience;
        settings[5] = this.ambienceMode;
        settings[6] = this.ambienceSpeed;
        this.addSetting(settings);
    }

    private static long getSpinTime(WorldModule instance) {
        return instance.spinTime;
    }

    private static Minecraft getMc() {
        return MinecraftContext.mc;
    }

    private static float getValue2(NumberSetting instance) {
        return instance.value;
    }

    @EventTarget
    public void onUpdate(UpdateEvent event) {
        if ((WorldModule.getAmbience(this).value)) {
            if ((this.ambienceMode).is("Spin")) {
                (WorldModule.getMc().world).setWorldTime((this.spinTime));
                this.spinTime = (long)((float)WorldModule.getSpinTime(this) + WorldModule.getValue2(WorldModule.getAmbienceSpeed(this)));
            } else if ((this.ambienceMode).is("Day")) {
                (WorldModule.getMc4().world).setWorldTime(5000L);
            } else if ((this.ambienceMode).is("Night")) {
                (WorldModule.getMc3().world).setWorldTime(17000L);
            } else if ((this.ambienceMode).is("Morning")) {
                (WorldModule.getMc2().world).setWorldTime(GenericCancelableEventB);
            } else if ((this.ambienceMode).is("Sunset")) {
                (WorldModule.getMc5().world).setWorldTime(13000L);
            }
        }
    }

    static {
        weatherColor = new ColorSetting("Цвет погоды", new Color(16777215).getRGB());
        worldColor = new BooleanSetting("Кастом цвет мира", false);
        worldColors = new ColorSetting("Цвет мира", new Color(16777215).getRGB());
    }

    private static Minecraft getMc2() {
        return MinecraftContext.mc;
    }

    private static Minecraft getMc3() {
        return MinecraftContext.mc;
    }

    private static Minecraft getMc4() {
        return MinecraftContext.mc;
    }

    private static BooleanSetting getAmbience(WorldModule instance) {
        return instance.ambience;
    }

    private static BooleanSetting getAmbience2(WorldModule instance) {
        return instance.ambience;
    }

    private static Minecraft getMc5() {
        return MinecraftContext.mc;
    }

    private static NumberSetting getAmbienceSpeed(WorldModule instance) {
        return instance.ambienceSpeed;
    }
}

