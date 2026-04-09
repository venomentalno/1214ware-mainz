/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.MinecraftContext
 *  neo.deobf.TextRendererEx
 *  neo.deobf.FontRegistry
 *  neo.deobf.DrawUtils
 *  neo.deobf.RoundedUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.shader.Framebuffer
 */
package com.botclient;

import java.awt.Color;
import com.botclient.MinecraftContext;
import com.botclient.TextRendererEx;
import com.botclient.FontRegistry;
import com.botclient.DrawUtils;
import com.botclient.RoundedUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import net.minecraft.client.render.RenderSystem;
import net.minecraft.client.shader.Framebuffer;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class SplashProgressRenderer
implements MinecraftContext {
    public static int p;

    public static void setProgress(int progress) {
        p = progress;
        SplashProgressRenderer.drawSplash();
    }

    private static void drawProgress() {
        float percent = (float)(p) / 12.0f * 100.0f;
        RenderSystem.resetColor();
        DrawUtils.drawRect((float)0.0f, (float)0.0f, (float)(mc.getWindow().getScaledWidth()), (float)(mc.getWindow().getScaledHeight()), (Color)new Color(30, 30, 30));
        (FontRegistry.mnstb_16).drawCenteredStringWithOutline("NeoWare запускается... ", (float)((mc.getWindow().getScaledWidth()) / (2)), (float)(mc.getWindow().getScaledHeight()) / 2.5f, -1);
        Object[] objectArray = new Object[1];
        objectArray[0] = Float.valueOf(percent);
        (FontRegistry.mnstb_16).drawCenteredStringWithOutline(String.format("%.0f", objectArray) + "%", (float)((mc.getWindow().getScaledWidth()) / (2)), (float)(mc.getWindow().getScaledHeight()) / 2.5f + 15.0f, -1);
        RoundedUtils.drawRound((float)((mc.getWindow().getScaledWidth()) / (2) - (50)), (float)((float)(mc.getWindow().getScaledHeight()) / 2.5f + 30.0f), (float)((p) * (8)), (float)8.0f, (float)4.0f, false, (Color)new Color(255, 127, 39));
    }

    public static void drawSplash() {
        int scaleFactor = (mc.getWindow()).getScaleFactor();
        Framebuffer framebuffer = new Framebuffer((mc.getWindow().getScaledWidth()) * scaleFactor, (mc.getWindow().getScaledHeight()) * scaleFactor, true);
        framebuffer.bindFramebuffer(false);
        RenderSystem.matrixMode((int)(5889));
        RenderSystem.loadIdentity();
        RenderSystem.ortho((double)0.0, (double)(mc.getWindow().getScaledWidth()), (double)(mc.getWindow().getScaledHeight()), (double)0.0, (double)1000.0, (double)3000.0);
        RenderSystem.matrixMode((int)(5888));
        RenderSystem.loadIdentity();
        RenderSystem.translate((float)0.0f, (float)0.0f, (float)-2000.00024f);
        RenderSystem.disableLighting();
        RenderSystem.disableFog();
        RenderSystem.disableDepth();
        RenderSystem.enableTexture2D();
        RenderSystem.resetColor();
        SplashProgressRenderer.drawProgress();
        framebuffer.unbindFramebuffer();
        framebuffer.framebufferRender((mc.getWindow().getScaledWidth()) * scaleFactor, (mc.getWindow().getScaledHeight()) * scaleFactor);
        RenderSystem.enableAlpha();
        RenderSystem.alphaFunc((int)(516), (float)0.100000001f);
        (mc).updateDisplay();
    }
}

