package com.botclient;

import net.minecraft.client.MinecraftClient;

/**
 * Helper class to provide Minecraft instance access for 1.21.4
 * In 1.21.4, use MinecraftClient.getInstance() instead of MinecraftClient.getInstance()
 */
public class MinecraftInstance {
    
    public static MinecraftClient getInstance() {
        return MinecraftClient.getInstance();
    }
}
