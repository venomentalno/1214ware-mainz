/*
 * FreeCamModule - Ported to Minecraft 1.21.4 Fabric
 */
package com.botclient;

import com.botclient.UpdateEvent;
import com.botclient.Render2DEvent;
import com.botclient.EventTarget;
import com.botclient.ModuleCategory;
import com.botclient.NumberSetting;
import com.botclient.Module;
import com.botclient.MovementUtils;
import com.botclient.PacketReceiveEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.Vec3d;

public class FreeCamModule extends Module {
    public double x, y, z;
    public OtherClientPlayerEntity fakePlayer = null;
    public final NumberSetting speed = new NumberSetting("Flight Speed", 0.5, 0.1, 1.0, 0.1);

    public FreeCamModule() {
        super("FreeCam", ModuleCategory.Player);
        this.addSetting(this.speed);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null || player.isDead()) {
            this.toggle();
            return;
        }
        
        this.x = player.getX();
        this.y = player.getY();
        this.z = player.getZ();
        
        ClientWorld world = MinecraftClient.getInstance().world;
        if (world != null) {
            fakePlayer = new OtherClientPlayerEntity(world, player.getGameProfile());
            fakePlayer.inventory = player.inventory;
            fakePlayer.setHealth(player.getHealth());
            fakePlayer.setPosition(this.x, this.y, this.z);
            fakePlayer.setYaw(player.getYaw());
            fakePlayer.setPitch(player.getPitch());
            fakePlayer.rotationYawHead = player.getYaw();
            world.addEntity(fakePlayer.getId(), fakePlayer);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        ClientWorld world = MinecraftClient.getInstance().world;
        
        if (fakePlayer != null && world != null) {
            world.removeEntity(fakePlayer.getId(), Entity.RemovalReason.DISCARDED);
            fakePlayer = null;
        }
        
        if (player != null) {
            player.setPosition(this.x, this.y, this.z);
        }
    }

    @EventTarget
    public void onUpdate(UpdateEvent e) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null || MinecraftClient.getInstance().world == null) {
            return;
        }
        
        player.setVelocity(0, 0, 0);
        
        float speed = (float)this.speed.getValue();
        Vec3d forward = player.getRotationVector();
        
        boolean jump = MinecraftClient.getInstance().options.jumpKey.isPressed();
        boolean sneak = MinecraftClient.getInstance().options.sneakKey.isPressed();
        
        if (jump) {
            player.setVelocity(0, speed, 0);
        } else if (sneak) {
            player.setVelocity(0, -speed, 0);
        } else {
            double moveForward = 0;
            double moveSideways = 0;
            
            if (MinecraftClient.getInstance().options.forwardKey.isPressed()) moveForward += 1;
            if (MinecraftClient.getInstance().options.backKey.isPressed()) moveForward -= 1;
            if (MinecraftClient.getInstance().options.leftKey.isPressed()) moveSideways += 1;
            if (MinecraftClient.getInstance().options.rightKey.isPressed()) moveSideways -= 1;
            
            if (moveForward != 0 || moveSideways != 0) {
                Vec3d direction = new Vec3d(moveSideways, 0, moveForward).rotateY(-(float)Math.toRadians(player.getYaw())).normalize().multiply(speed);
                player.setVelocity(direction.x, 0, direction.z);
            }
        }
        
        player.prevX = player.getX();
        player.prevY = player.getY();
        player.prevZ = player.getZ();
        player.setPosition(player.getX() + player.getVelocity().x, player.getY() + player.getVelocity().y, player.getZ() + player.getVelocity().z);
    }

    @EventTarget
    public void onPacket(PacketReceiveEvent event) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.isDead()) {
            this.toggle();
        }
    }

    @EventTarget
    public void onScreen(Render2DEvent e) {
        // No-op
    }
}
