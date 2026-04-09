/*
 * MovementUtils - Ported to Minecraft 1.21.4 Fabric
 */
package com.botclient;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;

public class MovementUtils {

    private static ClientPlayerEntity getPlayer() {
        return MinecraftClient.getInstance().player;
    }

    public static boolean isMoving() {
        ClientPlayerEntity player = getPlayer();
        if (player == null) return false;
        return player.movementInput.moveForward != 0 || player.movementInput.moveSideways != 0;
    }

    public static float getMoveDirection() {
        ClientPlayerEntity player = getPlayer();
        if (player == null) return 0f;
        double motionX = player.getVelocity().x;
        double motionZ = player.getVelocity().z;
        float direction = (float)(Math.atan2(motionX, motionZ) / Math.PI * 180.0);
        return -direction;
    }

    public static float getMotion() {
        ClientPlayerEntity player = getPlayer();
        if (player == null) return 0f;
        double motionX = player.getVelocity().x;
        double motionZ = player.getVelocity().z;
        return (float)Math.sqrt(motionX * motionX + motionZ * motionZ);
    }

    public static void setSpeed(double speed) {
        ClientPlayerEntity player = getPlayer();
        if (player == null) return;
        
        float yaw = player.getYaw();
        float moveForward = player.movementInput.moveForward;
        float moveSideways = player.movementInput.moveSideways;
        
        if (moveForward != 0 || moveSideways != 0) {
            if (moveForward < 0) {
                speed = -speed;
            }
            
            double x, z;
            if (moveSideways == 0) {
                x = speed * Math.sin(Math.toRadians(yaw));
                z = -speed * Math.cos(Math.toRadians(yaw));
            } else {
                float f = 1f / MathHelper.sqrt(moveForward * moveForward + moveSideways * moveSideways);
                moveForward *= f;
                moveSideways *= f;
                
                float sin = MathHelper.sin((float)Math.toRadians(yaw));
                float cos = MathHelper.cos((float)Math.toRadians(yaw));
                
                x = speed * (moveSideways * sin + moveForward * cos);
                z = speed * (moveForward * sin - moveSideways * cos);
            }
            
            player.setVelocity(x, player.getVelocity().y, z);
        }
    }

    public static double getBaseMoveSpeed() {
        return 0.2873;
    }

    public static void strafe(float strength) {
        ClientPlayerEntity player = getPlayer();
        if (player == null) return;
        if (!isMoving()) return;
        
        double[] dir = forward(1);
        player.setVelocity(
            player.getVelocity().x + dir[0] * strength,
            player.getVelocity().y,
            player.getVelocity().z + dir[1] * strength
        );
    }

    public static double[] forward(double length) {
        ClientPlayerEntity player = getPlayer();
        if (player == null) return new double[]{0, 0};
        
        float yaw = player.getYaw();
        return new double[]{
            -Math.sin(Math.toRadians(yaw)) * length,
            Math.cos(Math.toRadians(yaw)) * length
        };
    }

    public static boolean isOnGround() {
        ClientPlayerEntity player = getPlayer();
        return player != null && player.isOnGround();
    }

    public static float getYaw() {
        ClientPlayerEntity player = getPlayer();
        return player != null ? player.getYaw() : 0f;
    }

    public static void setYaw(float yaw) {
        ClientPlayerEntity player = getPlayer();
        if (player != null) {
            player.setYaw(yaw);
        }
    }

    public static float getPitch() {
        ClientPlayerEntity player = getPlayer();
        return player != null ? player.getPitch() : 0f;
    }

    public static void setPitch(float pitch) {
        ClientPlayerEntity player = getPlayer();
        if (player != null) {
            player.setPitch(pitch);
        }
    }
}
