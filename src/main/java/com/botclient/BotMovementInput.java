package com.botclient;

import net.minecraft.client.input.Input;

public class BotMovementInput extends Input {
    public final BotKeyState gameSettings;
    
    public float forwardSpeed = 0f;
    public float sidewaysSpeed = 0f;
    public boolean jumping = false;
    public boolean sneaking = false;

    public BotMovementInput(BotKeyState gameSettingsIn) {
        this.gameSettings = gameSettingsIn;
    }

    @Override
    public void tick(boolean slowingDown) {
        this.jumping = false;
        this.sneaking = false;
        this.movementForward = 0.0f;
        this.movementSideways = 0.0f;
        this.forwardSpeed = 0f;
        this.sidewaysSpeed = 0f;

        if (this.gameSettings.forwardKeyDown) {
            this.movementForward += 1.0f;
            this.forwardSpeed += 1.0f;
        }
        if (this.gameSettings.backKeyDown) {
            this.movementForward -= 1.0f;
            this.forwardSpeed -= 1.0f;
        }
        if (this.gameSettings.leftKeyDown) {
            this.movementSideways += 1.0f;
            this.sidewaysSpeed += 1.0f;
        }
        if (this.gameSettings.rightKeyDown) {
            this.movementSideways -= 1.0f;
            this.sidewaysSpeed -= 1.0f;
        }
        if (this.gameSettings.jumpKeyDown) {
            this.jumping = true;
        }
        if (this.gameSettings.sneakKeyDown) {
            this.sneaking = true;
            this.movementSideways *= 0.3f;
            this.movementForward *= 0.3f;
            this.sidewaysSpeed *= 0.3f;
            this.forwardSpeed *= 0.3f;
        }
    }
    
    public net.minecraft.util.math.Vec2f getMoveVector() {
        return new net.minecraft.util.math.Vec2f(this.movementSideways, this.movementForward);
    }
    
    public void updatePlayerMoveState() {
        // Handled by tick method
    }
}
