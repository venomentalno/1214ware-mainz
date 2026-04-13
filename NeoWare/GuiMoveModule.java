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
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.KeyBinding
 *  org.lwjgl.input.Keyboard
 */
package neo.deobf;

import neo.deobf.UpdateEvent;
import neo.deobf.EventTarget;
import neo.deobf.ModuleCategory;
import neo.deobf.Module;
import neo.deobf.MinecraftContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class GuiMoveModule
extends Module {

    private static GameSettings getGameSettings() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings2() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindJump(GameSettings gameSettings) {
        return gameSettings.keyBindJump;
    }

    public void onDisable() {
        GuiMoveModule.getKeyBindJump2(GuiMoveModule.getGameSettings10()).pressed = false;
        GuiMoveModule.getKeyBindForward2(GuiMoveModule.getGameSettings17()).pressed = false;
        GuiMoveModule.getKeyBindBack2(GuiMoveModule.getGameSettings2()).pressed = false;
        GuiMoveModule.getKeyBindLeft2(GuiMoveModule.getGameSettings16()).pressed = false;
        GuiMoveModule.getKeyBindRight2(GuiMoveModule.getGameSettings11()).pressed = false;
        GuiMoveModule.getKeyBindSprint2(GuiMoveModule.getGameSettings9()).pressed = false;
        super.onDisable();
    }

    @EventTarget
    public void onUpdate(UpdateEvent event) {
        if (!(((mc).currentScreen) instanceof GuiChat)) {
            KeyBinding keyBinding = (GuiMoveModule.getGameSettings6().keyBindJump);
            keyBinding.pressed = Keyboard.isKeyDown((int)GuiMoveModule.getKeyBindJump(GuiMoveModule.getGameSettings3()).getKeyCode());
            KeyBinding keyBinding2 = (GuiMoveModule.getGameSettings5().keyBindForward);
            keyBinding2.pressed = Keyboard.isKeyDown((int)GuiMoveModule.getKeyBindForward(GuiMoveModule.getGameSettings4()).getKeyCode());
            KeyBinding keyBinding3 = (GuiMoveModule.getGameSettings14().keyBindBack);
            keyBinding3.pressed = Keyboard.isKeyDown((int)GuiMoveModule.getKeyBindBack3(GuiMoveModule.getGameSettings8()).getKeyCode());
            KeyBinding keyBinding4 = (GuiMoveModule.getGameSettings12().keyBindLeft);
            keyBinding4.pressed = Keyboard.isKeyDown((int)GuiMoveModule.getKeyBindLeft(GuiMoveModule.getGameSettings()).getKeyCode());
            KeyBinding keyBinding5 = (GuiMoveModule.getGameSettings20().keyBindRight);
            keyBinding5.pressed = Keyboard.isKeyDown((int)GuiMoveModule.getKeyBindRight(GuiMoveModule.getGameSettings7()).getKeyCode());
            KeyBinding keyBinding6 = (GuiMoveModule.getGameSettings13().keyBindSprint);
            keyBinding6.pressed = Keyboard.isKeyDown((int)GuiMoveModule.getKeyBindSprint(GuiMoveModule.getGameSettings19()).getKeyCode());
            KeyBinding keyBinding7 = (GuiMoveModule.getGameSettings18().keyBindSneak);
            keyBinding7.pressed = Keyboard.isKeyDown((int)GuiMoveModule.getKeyBindSneak(GuiMoveModule.getGameSettings15()).getKeyCode());
        }
    }

    private static GameSettings getGameSettings3() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings4() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindLeft(GameSettings gameSettings) {
        return gameSettings.keyBindLeft;
    }

    private static GameSettings getGameSettings5() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindSneak(GameSettings gameSettings) {
        return gameSettings.keyBindSneak;
    }

    private static KeyBinding getKeyBindForward(GameSettings gameSettings) {
        return gameSettings.keyBindForward;
    }

    private static KeyBinding getKeyBindLeft2(GameSettings gameSettings) {
        return gameSettings.keyBindLeft;
    }

    public void onEnable() {
        super.onEnable();
    }

    private static GameSettings getGameSettings6() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings7() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindSprint(GameSettings gameSettings) {
        return gameSettings.keyBindSprint;
    }

    private static GameSettings getGameSettings8() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings9() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings10() {
        return Minecraft.gameSettings;
    }

    public GuiMoveModule() {
        super("GuiMove", ModuleCategory.Other);
    }

    private static GameSettings getGameSettings11() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindRight(GameSettings gameSettings) {
        return gameSettings.keyBindRight;
    }

    private static KeyBinding getKeyBindBack2(GameSettings gameSettings) {
        return gameSettings.keyBindBack;
    }

    private static KeyBinding getKeyBindSprint2(GameSettings gameSettings) {
        return gameSettings.keyBindSprint;
    }

    private static KeyBinding getKeyBindRight2(GameSettings gameSettings) {
        return gameSettings.keyBindRight;
    }

    private static KeyBinding getKeyBindBack3(GameSettings gameSettings) {
        return gameSettings.keyBindBack;
    }

    private static GameSettings getGameSettings12() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings13() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings14() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings15() {
        return Minecraft.gameSettings;
    }
private static GameSettings getGameSettings16() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings17() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings18() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindForward2(GameSettings gameSettings) {
        return gameSettings.keyBindForward;
    }

    private static GameSettings getGameSettings19() {
        return Minecraft.gameSettings;
    }

    private static KeyBinding getKeyBindJump2(GameSettings gameSettings) {
        return gameSettings.keyBindJump;
    }

    private static GameSettings getGameSettings20() {
        return Minecraft.gameSettings;
    }

}


