/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.shader.Framebuffer
 *  org.lwjgl.opengl.EXTFramebufferObject
 *  org.lwjgl.opengl.GL11
 */
package com.botclient;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.EXTFramebufferObject;
import net.minecraft.client.render.RenderSystem;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class StencilUtils {
    public static Minecraft mc = MinecraftClient.getInstance();

    public static void setupFBO(Framebuffer framebuffer) {
        EXTFramebufferObject.glDeleteRenderbuffersEXT((int)(framebuffer.depthBuffer));
        int stencilDepthBufferID = EXTFramebufferObject.glGenRenderbuffersEXT();
        EXTFramebufferObject.glBindRenderbufferEXT((int)(36161), (int)stencilDepthBufferID);
        EXTFramebufferObject.glRenderbufferStorageEXT((int)(36161), (int)(34041), (int)((mc).displayWidth), (int)((mc).displayHeight));
        EXTFramebufferObject.glFramebufferRenderbufferEXT((int)(36160), (int)(36128), (int)(36161), (int)stencilDepthBufferID);
        EXTFramebufferObject.glFramebufferRenderbufferEXT((int)(36160), (int)(36096), (int)(36161), (int)stencilDepthBufferID);
    }

    public static void initStencilToWrite() {
        (mc).getFramebuffer().bindFramebuffer(false);
        StencilUtils.checkSetupFBO((mc).getFramebuffer());
        RenderSystem.glClear((int)(1024));
        RenderSystem.glEnable((int)(2960));
        RenderSystem.glStencilFunc((int)(519), (int)(1), (int)(1));
        RenderSystem.glStencilOp((int)(7681), (int)(7681), (int)(7681));
        RenderSystem.glColorMask(false, false, false, false);
    }

    public static void checkSetupFBO(Framebuffer framebuffer) {
        if (framebuffer != null && (framebuffer.depthBuffer) > (-1)) {
            StencilUtils.setupFBO(framebuffer);
            framebuffer.depthBuffer = -1;
        }
    }

    public static void uninitStencilBuffer() {
        RenderSystem.glDisable((int)(2960));
    }

    public static void readStencilBuffer(int ref) {
        RenderSystem.glColorMask(true, true, true, true);
        RenderSystem.glStencilFunc((int)(514), (int)ref, (int)(1));
        RenderSystem.glStencilOp((int)(7680), (int)(7680), (int)(7680));
    }
}

