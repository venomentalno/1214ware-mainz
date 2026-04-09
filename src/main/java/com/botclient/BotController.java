/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.BooleanSetting
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.BotKeyState
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.BotTask
 *  neo.deobf.BotBaritoneModule
 *  neo.deobf.PathFinder
 */
package com.botclient;

import com.botclient.BooleanSetting;
import com.botclient.PBot;
import com.botclient.PBotPlayer;
import com.botclient.BotKeyState;
import com.botclient.PBotMinecraft;
import com.botclient.BotTask;
import com.botclient.BotBaritoneModule;
import com.botclient.PathFinder;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class BotController {
    public final PBot pbot;
    public final PathFinder pathFinder;
    public BotTask botFunction;

    private static void setBotFunction(BotController instance, BotTask instance2) {
        instance.botFunction = instance2;
    }

    private static PBot getPbot(BotController instance) {
        return instance.pbot;
    }

    private static PBot getPbot2(BotController instance) {
        return instance.pbot;
    }

    public void onUpdate() {
        if (!(this.pbot).isOnline()) {
            return;
        }
        BotController.getGameSettings(BotController.getMc(BotController.getPbot5(this))).keyBindJump = (BotController.getPlayer(BotController.getPbot6(this)).isInWater() && BotController.getValue2(BotController.getAutoSwim()) ? 1 : 0) != 0;
        if ((BotController.getAutoJump().value) && (BotController.getPlayer2(BotController.getPbot(this)).collidedHorizontally) && (BotController.getGameSettings2(BotController.getMc2(BotController.getPbot2(this))).keyBindForward)) {
            (this.pbot).jump();
        }
        if ((this.botFunction) != null) {
            (this.botFunction).onUpdate();
        }
        if (this.getPathFinder() != null) {
            try {
                this.getPathFinder().pathFindWalk();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private static PBotPlayer getPlayer(PBot instance) {
        return instance.player;
    }

    private static PathFinder getPathFinder(BotController instance) {
        return instance.pathFinder;
    }

    private static BooleanSetting getAutoJump() {
        return BotBaritoneModule.autoJump;
    }

    private static PBotMinecraft getMc(PBot instance) {
        return instance.mc;
    }

    private static PBot getPbot5(BotController instance) {
        return instance.pbot;
    }

    public PathFinder getPathFinder() {
        return (this.pathFinder);
    }

    private static boolean getValue2(BooleanSetting instance) {
        return instance.value;
    }

    private static BotKeyState getGameSettings(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotPlayer getPlayer2(PBot instance) {
        return instance.player;
    }

    private static PBotMinecraft getMc2(PBot instance) {
        return instance.mc;
    }

    public void setBotFunction(BotTask botFunction) {
        if (botFunction == null && (this.botFunction) != null) {
            (this.botFunction).onFinish();
        }
        if (botFunction != null && (this.botFunction) != null) {
            (this.botFunction).onFinish();
        }
        this.botFunction = botFunction;
        if (botFunction != null) {
            (this.botFunction).init();
        }
    }

    public BotController(PBot pbot) {
        this.pbot = pbot;
        this.pathFinder = new PathFinder(pbot);
    }

    private static BooleanSetting getAutoSwim() {
        return BotBaritoneModule.autoSwim;
    }

    private static BotKeyState getGameSettings2(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBot getPbot6(BotController instance) {
        return instance.pbot;
    }
}

