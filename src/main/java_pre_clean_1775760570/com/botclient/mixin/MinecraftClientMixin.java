package com.botclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.font.TextRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MinecraftClient.class)
public interface MinecraftClientMixin {
    
    @Accessor("player")
    ClientPlayerEntity getPlayer();
    
    @Accessor("world")
    ClientWorld getWorld();
    
    @Accessor("networkHandler")
    ClientPlayNetworkHandler getNetworkHandler();
    
    @Accessor("cameraEntity")
    Entity getCameraEntity();
    
    @Accessor("crosshairTarget")
    HitResult getCrosshairTarget();
    
    @Accessor("options")
    GameOptions getOptions();
    
    @Accessor("textRenderer")
    TextRenderer getTextRenderer();
    
    @Accessor("tickDelta")
    float getTickDelta();
}
