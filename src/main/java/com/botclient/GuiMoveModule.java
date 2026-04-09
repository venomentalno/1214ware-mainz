/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.UpdateEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.ModuleCategory
 *  neo.deobf.Module
 *  neo.deobf.MinecraftContext
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.settings.GameOptions
 *  net.minecraft.client.settings.KeyBinding
 *  org.lwjgl.input.Keyboard
 */
package com.botclient;

import com.botclient.UpdateEvent;
import com.botclient.EventTarget;
import com.botclient.ModuleCategory;
import com.botclient.Module;
import com.botclient.MinecraftContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class GuiMoveModule
extends Module {

    private static GameOptions getGameOptions() {
        return Minecraft.gameSettings;
    }

    private static GameOptions getGameOptions2() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindJump(GameOptions gameSettings) {
        return gameSettings.keyBindJump;
    }

    public void onDisable() {
        GuiMoveModule.getKeyBindJump2(GuiMoveModule.getGameOptions10()).pressed = false;
        GuiMoveModule.getKeyBindForward2(GuiMoveModule.getGameOptions17()).pressed = false;
        GuiMoveModule.getKeyBindBack2(GuiMoveModule.getGameOptions2()).pressed = false;
        GuiMoveModule.getKeyBindLeft2(GuiMoveModule.getGameOptions16()).pressed = false;
        GuiMoveModule.getKeyBindRight2(GuiMoveModule.getGameOptions11()).pressed = false;
        GuiMoveModule.getKeyBindSprint2(GuiMoveModule.getGameOptions9()).pressed = false;
        super.onDisable();
    }

    @EventTarget
    public void onUpdate(UpdateEvent event) {
        if (!(((mc).currentScreen) instanceof GuiChat)) {
            KeyBinding keyBinding = (GuiMoveModule.getGameOptions6().keyBindJump);
            keyBinding.pressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), (int)GuiMoveModule.getKeyBindJump(GuiMoveModule.getGameOptions3()).getKeyCode());
            KeyBinding keyBinding2 = (GuiMoveModule.getGameOptions5().keyBindForward);
            keyBinding2.pressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), (int)GuiMoveModule.getKeyBindForward(GuiMoveModule.getGameOptions4()).getKeyCode());
            KeyBinding keyBinding3 = (GuiMoveModule.getGameOptions14().keyBindBack);
            keyBinding3.pressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), (int)GuiMoveModule.getKeyBindBack3(GuiMoveModule.getGameOptions8()).getKeyCode());
            KeyBinding keyBinding4 = (GuiMoveModule.getGameOptions12().keyBindLeft);
            keyBinding4.pressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), (int)GuiMoveModule.getKeyBindLeft(GuiMoveModule.getGameOptions()).getKeyCode());
            KeyBinding keyBinding5 = (GuiMoveModule.getGameOptions20().keyBindRight);
            keyBinding5.pressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), (int)GuiMoveModule.getKeyBindRight(GuiMoveModule.getGameOptions7()).getKeyCode());
            KeyBinding keyBinding6 = (GuiMoveModule.getGameOptions13().keyBindSprint);
            keyBinding6.pressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), (int)GuiMoveModule.getKeyBindSprint(GuiMoveModule.getGameOptions19()).getKeyCode());
            KeyBinding keyBinding7 = (GuiMoveModule.getGameOptions18().keyBindSneak);
            keyBinding7.pressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), (int)GuiMoveModule.getKeyBindSneak(GuiMoveModule.getGameOptions15()).getKeyCode());
        }
    }

    private static GameOptions getGameOptions3() {
        return Minecraft.gameSettings;
    }

    private static GameOptions getGameOptions4() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindLeft(GameOptions gameSettings) {
        return gameSettings.keyBindLeft;
    }

    private static GameOptions getGameOptions5() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindSneak(GameOptions gameSettings) {
        return gameSettings.keyBindSneak;
    }

    private static KeyBinding getKeyBindForward(GameOptions gameSettings) {
        return gameSettings.keyBindForward;
    }

    private static KeyBinding getKeyBindLeft2(GameOptions gameSettings) {
        return gameSettings.keyBindLeft;
    }

    public void onEnable() {
        super.onEnable();
    }

    private static GameOptions getGameOptions6() {
        return Minecraft.gameSettings;
    }

    private static GameOptions getGameOptions7() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindSprint(GameOptions gameSettings) {
        return gameSettings.keyBindSprint;
    }

    private static GameOptions getGameOptions8() {
        return Minecraft.gameSettings;
    }

    private static GameOptions getGameOptions9() {
        return Minecraft.gameSettings;
    }

    private static GameOptions getGameOptions10() {
        return Minecraft.gameSettings;
    }

    public GuiMoveModule() {
        super("GuiMove", ModuleCategory.Other);
    }

    private static GameOptions getGameOptions11() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindRight(GameOptions gameSettings) {
        return gameSettings.keyBindRight;
    }

    private static KeyBinding getKeyBindBack2(GameOptions gameSettings) {
        return gameSettings.keyBindBack;
    }

    private static KeyBinding getKeyBindSprint2(GameOptions gameSettings) {
        return gameSettings.keyBindSprint;
    }

    private static KeyBinding getKeyBindRight2(GameOptions gameSettings) {
        return gameSettings.keyBindRight;
    }

    private static KeyBinding getKeyBindBack3(GameOptions gameSettings) {
        return gameSettings.keyBindBack;
    }

    private static GameOptions getGameOptions12() {
        return Minecraft.gameSettings;
    }

    private static GameOptions getGameOptions13() {
        return Minecraft.gameSettings;
    }

    private static GameOptions getGameOptions14() {
        return Minecraft.gameSettings;
    }

    private static GameOptions getGameOptions15() {
        return Minecraft.gameSettings;
    }
private static GameOptions getGameOptions16() {
        return Minecraft.gameSettings;
    }

    private static GameOptions getGameOptions17() {
        return Minecraft.gameSettings;
    }

    private static GameOptions getGameOptions18() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindForward2(GameOptions gameSettings) {
        return gameSettings.keyBindForward;
    }

    private static GameOptions getGameOptions19() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindJump2(GameOptions gameSettings) {
        return gameSettings.keyBindJump;
    }

    private static GameOptions getGameOptions20() {
        return Minecraft.gameSettings;
    }

}


