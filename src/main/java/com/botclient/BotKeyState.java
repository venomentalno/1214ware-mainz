package com.botclient;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.GameOptions;

public class BotKeyState {
    public KeyBinding keyBindForward;
    public KeyBinding keyBindBack;
    public KeyBinding keyBindLeft;
    public KeyBinding keyBindRight;
    public KeyBinding keyBindJump;
    public KeyBinding keyBindSneak;
    public KeyBinding keyBindSprint;
    
    public boolean sneakKeyDown;
    public boolean forwardKeyDown;
    public boolean backKeyDown;
    public boolean leftKeyDown;
    public boolean rightKeyDown;
    public boolean jumpKeyDown;
    public boolean sprintKeyDown;
    
    public BotKeyState() {
        // Initialize with default values
        this.sneakKeyDown = false;
        this.forwardKeyDown = false;
        this.backKeyDown = false;
        this.leftKeyDown = false;
        this.rightKeyDown = false;
        this.jumpKeyDown = false;
        this.sprintKeyDown = false;
    }
    
    public void copyFrom(GameOptions options) {
        // Copy keybindings from game options if needed
    }
}