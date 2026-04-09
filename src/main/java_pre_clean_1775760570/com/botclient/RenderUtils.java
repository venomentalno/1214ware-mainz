package com.botclient;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.*;
import net.minecraft.util.math.Matrix4f;

/**
 * Helper class for rendering operations in 1.21.4
 */
public class RenderUtils {
    
    /**
     * Get the current Minecraft client instance
     */
    public static MinecraftClient getMinecraft() {
        return MinecraftClient.getInstance();
    }
    
    /**
     * Begin drawing with Tessellator (1.21.4 style)
     */
    public static BufferBuilder beginDrawing() {
        return BufferRenderer.getAvailableRenderer().getBuffer();
    }
    
    /**
     * Draw a rectangle using modern rendering
     */
    public static void drawRect(DrawContext context, int x, int y, int width, int height, int color) {
        context.fill(x, y, x + width, y + height, color);
    }
}
