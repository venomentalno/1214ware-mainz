/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Render3DEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.BooleanSetting
 *  neo.deobf.ColorSetting
 *  neo.deobf.Module
 *  neo.deobf.DrawUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.PlayerEntitySP
 *  net.minecraft.client.multiplayer.ClientWorld
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package com.botclient;

import java.awt.Color;
import java.util.List;
import com.botclient.Render3DEvent;
import com.botclient.EventTarget;
import com.botclient.Setting;
import com.botclient.ModuleCategory;
import com.botclient.BooleanSetting;
import com.botclient.ColorSetting;
import com.botclient.Module;
import com.botclient.DrawUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.render.RenderSystem;
import net.minecraft.client.render.entity.RenderManager;
import net.minecraft.client.option.GameOptions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.render.RenderSystem;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class TracersModule
extends Module {
    public static ColorSetting color = new ColorSetting("Р¦РІРµС‚", Color.WHITE.getRGB());
    public BooleanSetting onlyplayers = new BooleanSetting("РўРѕР»СЊРєРѕ РёРіСЂРѕРєРё", true);

    private static PlayerEntitySP getPlayer2() {
        return Minecraft.player;
    }

    private static GameSettings getGameSettings() {
        return Minecraft.gameSettings;
    }

    private static ClientWorld getWorld(Minecraft minecraft) {
        return minecraft.world;
    }

    public TracersModule() {
        super("Tracers", ModuleCategory.Render);
        Setting[] settings = new Setting[2];
        settings[0] = this.onlyplayers;
        settings[1] = color;
        this.addSetting(settings);
    }

    @EventTarget
    public void onEvent3D(Render3DEvent event) {
        for (Entity entity : (TracersModule.getWorld((mc)).loadedEntityList)) {
            if (entity == (Minecraft.player) || (TracersModule.getOnlyplayers(this).value) && !(entity instanceof PlayerEntity)) continue;
            TracersModule.getGameSettings().viewBobbing = false;
            double d = (entity.lastTickPosX) + ((entity.posX) - (entity.lastTickPosX)) * (double)event.getPartialTicks();
            (mc).getRenderManager();
            double x = d - (RenderManager.renderPosX);
            double d2 = (entity.lastTickPosY) + ((entity.posY) - (entity.lastTickPosY)) * (double)event.getPartialTicks();
            (mc).getRenderManager();
            double y = d2 - (RenderManager.renderPosY) - 1.0;
            double d3 = (entity.lastTickPosZ) + ((entity.posZ) - (entity.lastTickPosZ)) * (double)event.getPartialTicks();
            (mc).getRenderManager();
            double z = d3 - (RenderManager.renderPosZ);
            RenderSystem.blendFunc((int)(770), (int)(771));
            RenderSystem.glEnable((int)(3042));
            RenderSystem.glEnable((int)(2848));
            RenderSystem.glLineWidth((float)1.0f);
            RenderSystem.glDisable((int)(3553));
            RenderSystem.glDisable((int)(2929));
            RenderSystem.depthMask(false);
            DrawUtils.glColor((Color)new Color(((color).color)));
            RenderSystem.glBegin((int)(3));
            Vec3d vec3d = new Vec3d(0.0, 0.0, 1.0);
            Vec3d vec3d2 = vec3d.rotatePitch((float)(-Math.toRadians((TracersModule.getPlayer2().rotationPitch))));
            Vec3d vec = vec3d2.rotateYaw((float)(-Math.toRadians((TracersModule.getPlayer3().rotationYaw))));
            float f = (float)(vec.x);
            RenderSystem.glVertex3f((float)f, (float)((float)((double)(Minecraft.player).getEyeHeight() + (vec.y))), (float)((float)(vec.z)));
            RenderSystem.glVertex3f((float)((float)x), (float)((float)(y + 1.1000000000000001)), (float)((float)z));
            RenderSystem.glEnd();
            RenderSystem.glEnable((int)(3553));
            RenderSystem.glDisable((int)(2848));
            RenderSystem.glEnable((int)(2929));
            RenderSystem.depthMask(true);
            RenderSystem.glEnable((int)(3042));
            RenderSystem.resetColor();
        }
    }

    private static PlayerEntitySP getPlayer3() {
        return Minecraft.player;
    }

    private static BooleanSetting getOnlyplayers(TracersModule instance) {
        return instance.onlyplayers;
    }

}


