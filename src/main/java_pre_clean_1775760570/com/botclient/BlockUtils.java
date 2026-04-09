package com.botclient;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

// This file should ONLY contain BlockUtils class
// BlockRenderEvent was accidentally copied here - it belongs in BlockRenderEvent.java

public class BlockUtils {
    
    public static float getDistance(PBot bot, double targetX, double targetY, double targetZ) {
        if (bot.player == null) return Float.MAX_VALUE;
        return (float) bot.player.getPos().distanceTo(
            new net.minecraft.util.math.Vec3d(targetX, targetY, targetZ)
        );
    }
    
    public static double getDistance(double px1, double py1, double pz1, 
                                     double px2, double py2, double pz2) {
        double dx = px2 - px1;
        double dy = py2 - py1;
        double dz = pz2 - pz1;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
    
    public static float normalizeYaw(float yaw) {
        yaw %= 360f;
        if (yaw > 180f) yaw -= 360f;
        if (yaw < -180f) yaw += 360f;
        return yaw;
    }
    
    public static float normalizePitch(float pitch) {
        return Math.max(-90f, Math.min(90f, pitch));
    }
    
    public static int findItem(PBot bot, net.minecraft.item.Item item) {
        if (bot.player == null || bot.player.getInventory() == null) return -1;
        for (int i = 0; i < bot.player.getInventory().size(); i++) {
            var stack = bot.player.getInventory().getStack(i);
            if (!stack.isEmpty() && stack.isOf(item)) {
                return i;
            }
        }
        return -1;
    }
    
    public static int getSword(PBot bot) {
        if (bot.player == null || bot.player.getInventory() == null) return -1;
        for (int i = 0; i < bot.player.getInventory().size(); i++) {
            var stack = bot.player.getInventory().getStack(i);
            if (!stack.isEmpty() && stack.getItem() instanceof net.minecraft.item.SwordItem) {
                return i;
            }
        }
        return -1;
    }
    
    public static boolean hasSword(PBot bot) {
        return getSword(bot) != -1;
    }
    
    // Removed BlockRenderEvent class - it belongs in BlockRenderEvent.java
}
