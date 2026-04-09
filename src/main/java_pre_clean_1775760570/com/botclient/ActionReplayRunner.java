/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Client
 *  neo.deobf.ModuleManager
 *  neo.deobf.ReplayAction
 *  neo.deobf.ReplayActionType
 *  neo.deobf.ActionRecorderModule
 *  neo.deobf.ModeSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.BotKeyState
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.RandomUtils
 *  neo.deobf.ThreadUtils
 *  net.minecraft.inventory.ClickType
 */
package com.botclient;

import java.util.ArrayList;
import com.botclient.Client;
import com.botclient.ModuleManager;
import com.botclient.ReplayAction;
import com.botclient.ReplayActionType;
import com.botclient.ActionRecorderModule;
import com.botclient.ModeSetting;
import com.botclient.NumberSetting;
import com.botclient.PBot;
import com.botclient.PBotPlayer;
import com.botclient.BotKeyState;
import com.botclient.PBotMinecraft;
import com.botclient.RandomUtils;
import com.botclient.ThreadUtils;
import net.minecraft.screen.slot.SlotActionType;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ActionReplayRunner {
    private static PBotMinecraft getMc(PBot instance) {
        return instance.mc;
    }

    private static PBotMinecraft getMc2(PBot instance) {
        return instance.mc;
    }

    private static BotKeyState getGameSettings(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotMinecraft getMc3(PBot instance) {
        return instance.mc;
    }

    private static boolean getForwardKeyDown(ReplayAction instance) {
        return instance.forwardKeyDown;
    }

    private static BotKeyState getGameSettings2(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static BotKeyState getGameSettings3(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static BotKeyState getGameSettings4(PBotMinecraft instance) {
        return instance.gameSettings;
    }

private static boolean getKeyBindSprint(ReplayAction instance) {
        return instance.keyBindSprint;
    }

    private static NumberSetting getRunDelay() {
        return ActionRecorderModule.runDelay;
    }

    private static PBotMinecraft getMc4(PBot instance) {
        return instance.mc;
    }

    private static boolean getKeyBindSneak(ReplayAction instance) {
        return instance.keyBindSneak;
    }

    private static float getPitch(ReplayAction instance) {
        return instance.pitch;
    }

    private static BotKeyState getGameSettings5(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static BotKeyState getGameSettings6(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotMinecraft getMc5(PBot instance) {
        return instance.mc;
    }

    private static boolean getKeyBindJump(ReplayAction instance) {
        return instance.keyBindJump;
    }

    private static BotKeyState getGameSettings7(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    public static void trigger(PBot pBot, String trtype) {
        if ((Client.getInstance().moduleManager).getModule(ActionRecorderModule.class).isModuleState()) {
            return;
        }
        if (trtype.equals((ActionRecorderModule.trigger).get()) || trtype.equals("repeatCommand")) {
            Thread botThread = new Thread(() -> {
                if (!(pBot.recorderActive)) {
                    pBot.recorderActive = true;
                    ThreadUtils.sleep((long)((long)(ActionReplayRunner.getRunDelay().value)));
                    for (ReplayAction action : (ActionRecorderModule.records)) {
                        if ((action.actionType).equals((Object)(ReplayActionType.CHAT))) {
                            pBot.sendMessage((action.message));
                        } else if ((action.actionType).equals((Object)(ReplayActionType.INVCLICK))) {
                            pBot.windowClick((action.integer), 0, (ClickType.PICKUP));
                        } else if ((action.actionType).equals((Object)(ReplayActionType.HOTBARCLICK))) {
                            pBot.changeSlot((action.integer));
                            pBot.useItem();
                        } else if ((action.actionType).equals((Object)(ReplayActionType.KEYBOARD))) {
                            ActionReplayRunner.getGameSettings12(ActionReplayRunner.getMc13(pBot)).keyBindForward = ActionReplayRunner.getForwardKeyDown(action);
                            ActionReplayRunner.getGameSettings8(ActionReplayRunner.getMc12(pBot)).keyBindBack = ActionReplayRunner.getBackKeyDown(action);
                            ActionReplayRunner.getGameSettings3(ActionReplayRunner.getMc3(pBot)).keyBindLeft = ActionReplayRunner.getLeftKeyDown(action);
                            ActionReplayRunner.getGameSettings5(ActionReplayRunner.getMc10(pBot)).keyBindRight = ActionReplayRunner.getRightKeyDown(action);
                            ActionReplayRunner.getGameSettings13(ActionReplayRunner.getMc7(pBot)).keyBindSprint = ActionReplayRunner.getKeyBindSprint(action);
                            ActionReplayRunner.getGameSettings9(ActionReplayRunner.getMc2(pBot)).keyBindSneak = ActionReplayRunner.getKeyBindSneak(action);
                            ActionReplayRunner.getGameSettings7(ActionReplayRunner.getMc6(pBot)).keyBindJump = ActionReplayRunner.getKeyBindJump(action);
                            ActionReplayRunner.getPlayer(pBot).rotationYaw = ActionReplayRunner.getYaw(action);
                            ActionReplayRunner.getPlayer2(pBot).rotationPitch = ActionReplayRunner.getPitch(action);
                        } else if ((action.actionType).equals((Object)(ReplayActionType.ENTITY))) {
                            pBot.clickEntity((action.integer), true);
                        }
                        ThreadUtils.sleep((long)50L);
                    }
                    ActionReplayRunner.getGameSettings10(ActionReplayRunner.getMc8(pBot)).keyBindForward = false;
                    ActionReplayRunner.getGameSettings6(ActionReplayRunner.getMc(pBot)).keyBindBack = false;
                    ActionReplayRunner.getGameSettings11(ActionReplayRunner.getMc4(pBot)).keyBindLeft = false;
                    ActionReplayRunner.getGameSettings(ActionReplayRunner.getMc11(pBot)).keyBindRight = false;
                    ActionReplayRunner.getGameSettings4(ActionReplayRunner.getMc9(pBot)).keyBindSprint = false;
                    ActionReplayRunner.getGameSettings2(ActionReplayRunner.getMc14(pBot)).keyBindSneak = false;
                    ActionReplayRunner.getGameSettings14(ActionReplayRunner.getMc5(pBot)).keyBindJump = false;
                    pBot.recorderActive = false;
                }
            });
            botThread.setName("PBotRecorder-" + pBot.getNickname() + "-" + RandomUtils.randomNumber((int)(5)));
            botThread.start();
        }
    }

    private static boolean getRightKeyDown(ReplayAction instance) {
        return instance.rightKeyDown;
    }

    private static PBotMinecraft getMc6(PBot instance) {
        return instance.mc;
    }

    private static float getYaw(ReplayAction instance) {
        return instance.yaw;
    }

    private static BotKeyState getGameSettings8(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static BotKeyState getGameSettings9(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotMinecraft getMc7(PBot instance) {
        return instance.mc;
    }

    private static BotKeyState getGameSettings10(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotMinecraft getMc8(PBot instance) {
        return instance.mc;
    }

    private static BotKeyState getGameSettings11(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotMinecraft getMc9(PBot instance) {
        return instance.mc;
    }

    private static PBotMinecraft getMc10(PBot instance) {
        return instance.mc;
    }

    private static boolean getLeftKeyDown(ReplayAction instance) {
        return instance.leftKeyDown;
    }

    private static PBotMinecraft getMc11(PBot instance) {
        return instance.mc;
    }

    private static BotKeyState getGameSettings12(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotMinecraft getMc12(PBot instance) {
        return instance.mc;
    }

    private static PBotPlayer getPlayer(PBot instance) {
        return instance.player;
    }

    private static BotKeyState getGameSettings13(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotPlayer getPlayer2(PBot instance) {
        return instance.player;
    }

    private static PBotMinecraft getMc13(PBot instance) {
        return instance.mc;
    }

    private static boolean getBackKeyDown(ReplayAction instance) {
        return instance.backKeyDown;
    }

    private static PBotMinecraft getMc14(PBot instance) {
        return instance.mc;
    }

    private static BotKeyState getGameSettings14(PBotMinecraft instance) {
        return instance.gameSettings;
    }

}

