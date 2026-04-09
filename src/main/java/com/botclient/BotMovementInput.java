package com.botclient;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.util.InputUtil;

public class BotMovementInput extends Input {
    public final BotKeyState gameSettings;

    public BotMovementInput(BotKeyState gameSettingsIn) {
        this.gameSettings = gameSettingsIn;
    }

    @Override
    public void tick(boolean isPlayerMovingSlowly, float strafeSpeed) {
        this.jumping = false;
        this.sneaking = false;
        this.movementForward = 0.0f;
        this.movementSideways = 0.0f;

        // Forward
        if (this.gameSettings.keyBindForward || 
           (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 87) || 
            InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 200))) {
            this.movementForward += 1.0f;
        }
        // Back
        if (this.gameSettings.keyBindBack || 
           (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 83) || 
            InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 208))) {
            this.movementForward -= 1.0f;
        }
        // Left
        if (this.gameSettings.keyBindLeft || 
           (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 65) || 
            InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 203))) {
            this.movementSideways += 1.0f;
        }
        // Right
        if (this.gameSettings.keyBindRight || 
           (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 68) || 
            InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 205))) {
            this.movementSideways -= 1.0f;
        }
        // Jump
        if (this.gameSettings.keyBindJump || 
            InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 32)) {
            this.jumping = true;
        }
        // Sneak
        if (this.gameSettings.keyBindSneak || 
            InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 340)) { // Shift
            this.sneaking = true;
            this.movementSideways *= 0.3f;
            this.movementForward *= 0.3f;
        }
    }
}
