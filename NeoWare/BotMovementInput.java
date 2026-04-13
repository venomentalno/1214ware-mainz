/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.BotKeyState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.util.MovementInput
 *  org.lwjgl.input.Keyboard
 */
package neo.deobf;

import neo.deobf.BotKeyState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.MovementInput;
import org.lwjgl.input.Keyboard;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class BotMovementInput
extends MovementInput {
    public final BotKeyState gameSettings;

    public BotMovementInput(BotKeyState gameSettingsIn) {
        this.gameSettings = gameSettingsIn;
    }

    private static float getMoveStrafe(BotMovementInput instance) {
        return instance.moveStrafe;
    }

    private static float getMoveStrafe2(BotMovementInput instance) {
        return instance.moveStrafe;
    }

    private static BotKeyState getGameSettings(BotMovementInput instance) {
        return instance.gameSettings;
    }

    private static float getMoveForward(BotMovementInput instance) {
        return instance.moveForward;
    }

    private static BotKeyState getGameSettings2(BotMovementInput instance) {
        return instance.gameSettings;
    }

    private static BotKeyState qvEzgvubjS(BotMovementInput instance) {
        return instance.gameSettings;
    }

    private static BotKeyState getGameSettings3(BotMovementInput instance) {
        return instance.gameSettings;
    }

    private static float getMoveStrafe3(BotMovementInput instance) {
        return instance.moveStrafe;
    }

    private static BotKeyState getGameSettings4(BotMovementInput instance) {
        return instance.gameSettings;
    }

    private static BotKeyState getGameSettings5(BotMovementInput instance) {
        return instance.gameSettings;
    }

    private static float getMoveForward2(BotMovementInput instance) {
        return instance.moveForward;
    }

    public void updatePlayerMoveState() {
        this.jump = false;
        this.sneak = false;
        this.moveStrafe = 0.0f;
        this.moveForward = 0.0f;
        if ((BotMovementInput.getGameSettings3(this).keyBindForward) || !((Minecraft.getMinecraft().currentScreen) instanceof GuiChat) && (Keyboard.isKeyDown((int)(72)) || Keyboard.isKeyDown((int)(200)))) {
            BotMovementInput cI = this;
            cI.moveForward = BotMovementInput.getMoveForward3(cI) + 1.0f;
            this.forwardKeyDown = true;
        } else {
            this.forwardKeyDown = false;
        }
        if ((BotMovementInput.getGameSettings2(this).keyBindBack) || !((Minecraft.getMinecraft().currentScreen) instanceof GuiChat) && (Keyboard.isKeyDown((int)(76)) || Keyboard.isKeyDown((int)(208)))) {
            BotMovementInput cI = this;
            cI.moveForward = BotMovementInput.getMoveForward2(cI) - 1.0f;
            this.backKeyDown = true;
        } else {
            this.backKeyDown = false;
        }
        if ((BotMovementInput.qvEzgvubjS(this).keyBindLeft) || !((Minecraft.getMinecraft().currentScreen) instanceof GuiChat) && (Keyboard.isKeyDown((int)(75)) || Keyboard.isKeyDown((int)(203)))) {
            BotMovementInput cI = this;
            cI.moveStrafe = BotMovementInput.getMoveStrafe3(cI) + 1.0f;
            this.leftKeyDown = true;
        } else {
            this.leftKeyDown = false;
        }
        if ((BotMovementInput.getGameSettings5(this).keyBindRight) || !((Minecraft.getMinecraft().currentScreen) instanceof GuiChat) && (Keyboard.isKeyDown((int)(77)) || Keyboard.isKeyDown((int)(205)))) {
            BotMovementInput cI = this;
            cI.moveStrafe = BotMovementInput.getMoveStrafe2(cI) - 1.0f;
            this.rightKeyDown = true;
        } else {
            this.rightKeyDown = false;
        }
        if ((BotMovementInput.getGameSettings(this).keyBindJump) || !((Minecraft.getMinecraft().currentScreen) instanceof GuiChat) && Keyboard.isKeyDown((int)(79))) {
            this.jump = true;
        }
        if ((BotMovementInput.getGameSettings4(this).keyBindSneak) || !((Minecraft.getMinecraft().currentScreen) instanceof GuiChat) && Keyboard.isKeyDown((int)(81))) {
            this.sneak = true;
            this.moveStrafe = (float)((double)BotMovementInput.getMoveStrafe(this) * 0.29999999999999999);
            this.moveForward = (float)((double)BotMovementInput.getMoveForward(this) * 0.29999999999999999);
        }
    }

    private static float getMoveForward3(BotMovementInput instance) {
        return instance.moveForward;
    }

}

