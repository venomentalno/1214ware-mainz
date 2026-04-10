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
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package neo.deobf;

import java.awt.Color;
import java.util.List;
import neo.deobf.Render3DEvent;
import neo.deobf.EventTarget;
import neo.deobf.Setting;
import neo.deobf.ModuleCategory;
import neo.deobf.BooleanSetting;
import neo.deobf.ColorSetting;
import neo.deobf.Module;
import neo.deobf.DrawUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class TracersModule
extends Module {
    public static ColorSetting color = new ColorSetting("Р¦РІРµС‚", Color.WHITE.getRGB());
    public BooleanSetting onlyplayers = new BooleanSetting("РўРѕР»СЊРєРѕ РёРіСЂРѕРєРё", true);

    private static EntityPlayerSP getPlayer2() {
        return Minecraft.player;
    }

    private static GameSettings getGameSettings() {
        return Minecraft.gameSettings;
    }

    private static WorldClient getWorld(Minecraft minecraft) {
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
            if (entity == (Minecraft.player) || (TracersModule.getOnlyplayers(this).value) && !(entity instanceof EntityPlayer)) continue;
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
            GlStateManager.blendFunc((int)(770), (int)(771));
            GL11.glEnable((int)(3042));
            GL11.glEnable((int)(2848));
            GlStateManager.glLineWidth((float)1.0f);
            GL11.glDisable((int)(3553));
            GL11.glDisable((int)(2929));
            GlStateManager.depthMask(false);
            DrawUtils.glColor((Color)new Color(((color).color)));
            GlStateManager.glBegin((int)(3));
            Vec3d vec3d = new Vec3d(0.0, 0.0, 1.0);
            Vec3d vec3d2 = vec3d.rotatePitch((float)(-Math.toRadians((TracersModule.getPlayer2().rotationPitch))));
            Vec3d vec = vec3d2.rotateYaw((float)(-Math.toRadians((TracersModule.getPlayer3().rotationYaw))));
            float f = (float)(vec.x);
            GlStateManager.glVertex3f((float)f, (float)((float)((double)(Minecraft.player).getEyeHeight() + (vec.y))), (float)((float)(vec.z)));
            GlStateManager.glVertex3f((float)((float)x), (float)((float)(y + 1.1000000000000001)), (float)((float)z));
            GlStateManager.glEnd();
            GL11.glEnable((int)(3553));
            GL11.glDisable((int)(2848));
            GL11.glEnable((int)(2929));
            GlStateManager.depthMask(true);
            GL11.glEnable((int)(3042));
            GlStateManager.resetColor();
        }
    }

    private static EntityPlayerSP getPlayer3() {
        return Minecraft.player;
    }

    private static BooleanSetting getOnlyplayers(TracersModule instance) {
        return instance.onlyplayers;
    }

}


