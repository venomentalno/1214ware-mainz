/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.UpdateEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.BooleanSetting
 *  neo.deobf.Module
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.init.MobEffects
 *  net.minecraft.potion.Potion
 */
package neo.deobf;

import java.util.List;
import neo.deobf.UpdateEvent;
import neo.deobf.EventTarget;
import neo.deobf.Setting;
import neo.deobf.ModuleCategory;
import neo.deobf.BooleanSetting;
import neo.deobf.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class NoRenderModule
extends Module {
    public static BooleanSetting cameraClip;
    public static BooleanSetting antiTotem;
    public static BooleanSetting noBossBar;
    public static BooleanSetting noHurtCam;
    public static BooleanSetting blindness;
    public static BooleanSetting noArmorStand;
    public static BooleanSetting rain;
    public static BooleanSetting noFire;

    public NoRenderModule() {
        super("NoRender", ModuleCategory.Render);
        Setting[] settings = new Setting[8];
        settings[0] = rain;
        settings[1] = noArmorStand;
        settings[2] = noHurtCam;
        settings[3] = antiTotem;
        settings[4] = noFire;
        settings[5] = blindness;
        settings[6] = noBossBar;
        settings[7] = cameraClip;
        this.addSetting(settings);
    }

    @EventTarget
    public void onUpdate(UpdateEvent event) {
        if (((rain).value) && ((mc).world).isRaining()) {
            ((mc).world).setRainStrength(0.0f);
            ((mc).world).setThunderStrength(0.0f);
        }
        if (((blindness).value) && (Minecraft.player).isPotionActive((MobEffects.BLINDNESS)) || (Minecraft.player).isPotionActive((MobEffects.NAUSEA))) {
            (Minecraft.player).removePotionEffect((MobEffects.NAUSEA));
            (Minecraft.player).removePotionEffect((MobEffects.BLINDNESS));
        }
        if (((noArmorStand).value)) {
            if ((Minecraft.player) == null || ((mc).world) == null) {
                return;
            }
            for (Entity entity : (NoRenderModule.getWorld4((mc)).loadedEntityList)) {
                if (entity == null || !(entity instanceof EntityArmorStand)) continue;
                ((mc).world).removeEntity(entity);
            }
        }
    }

    private static WorldClient getWorld4(Minecraft minecraft) {
        return minecraft.world;
    }

    static {
        rain = new BooleanSetting("Дождь", true);
        noHurtCam = new BooleanSetting("Сдвиги камеры", true);
        antiTotem = new BooleanSetting("Анимация тотема", false);
        noFire = new BooleanSetting("Откл. оверлей огня", false);
        noBossBar = new BooleanSetting("Откл. боссбар", false);
        noArmorStand = new BooleanSetting("Стенды для брони", false);
        blindness = new BooleanSetting("Слепота", true);
        cameraClip = new BooleanSetting("Физика камеры", true);
    }

}

