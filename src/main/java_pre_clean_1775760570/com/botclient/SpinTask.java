/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Vector2f
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.BotKeyState
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.BotTask
 *  neo.deobf.BlockUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 */
package com.botclient;

import org.joml.Vector2f;
import com.botclient.PBot;
import com.botclient.PBotPlayer;
import com.botclient.BotKeyState;
import com.botclient.PBotMinecraft;
import com.botclient.BotTask;
import com.botclient.BlockUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class SpinTask
extends BotTask {
    public Entity targetEntity = null;
    public int radius;

    private static PBotPlayer getPlayer(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer2(PBot instance) {
        return instance.player;
    }

    public void init() {
        if ((this.targetEntity) == null) {
            this.sendDebug("&5[&dBot-Baritone&5] &7Bot " + this.getBot().getNickname() + " | Unknown target!");
            this.getBaritone().setBotFunction(null);
        }
    }

    private static BotKeyState getGameSettings(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static Entity getTargetEntity2(SpinTask instance) {
        return instance.targetEntity;
    }

    public void onFinish() {
        SpinTask.getGameSettings4(this.getMc()).keyBindForward = false;
        SpinTask.getGameSettings2(this.getMc()).keyBindLeft = false;
        super.onFinish();
    }

    public SpinTask(PBot bot, String targetName, int radius) {
        super(bot, "Spin");
        if (targetName.equalsIgnoreCase(this.getBot().getNickname())) {
            this.sendDebug("&5[&dBot-Baritone&5] &7Bot " + bot.getNickname() + " | Invaild target entity!");
            this.getBaritone().setBotFunction(null);
            return;
        }
        this.radius = radius;
        this.targetEntity = targetName.equalsIgnoreCase("@me") ? Minecraft.player : BlockUtils.getByName((String)targetName);
    }

    private static Entity getTargetEntity4(SpinTask instance) {
        return instance.targetEntity;
    }

    private static PBotPlayer getPlayer3(PBot instance) {
        return instance.player;
    }

    private static Entity getTargetEntity5(SpinTask instance) {
        return instance.targetEntity;
    }

    private static BotKeyState getGameSettings2(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static BotKeyState getGameSettings3(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotPlayer getPlayer4(PBot instance) {
        return instance.player;
    }

    private static Entity getTargetEntity6(SpinTask instance) {
        return instance.targetEntity;
    }

    private static BotKeyState getGameSettings4(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static BotKeyState getGameSettings5(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static BotKeyState getGameSettings6(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    public void onUpdate() {
        if ((this.targetEntity) == null) {
            return;
        }
        float distance = BlockUtils.get2Distance((PBot)this.getBot(), (double)(SpinTask.getTargetEntity2(this).posX), (double)(SpinTask.getTargetEntity8(this).posY), (double)(SpinTask.getTargetEntity7(this).posZ));
        Vector2f vector2f = BlockUtils.getBlockAngles((double)(SpinTask.getTargetEntity5(this).posX), (double)((SpinTask.getTargetEntity6(this).posY) + 0.5), (double)(SpinTask.getTargetEntity4(this).posZ), (double)(SpinTask.getPlayer4(this.getBot()).posX), (double)(SpinTask.getPlayer2(this.getBot()).posY), (double)(SpinTask.getPlayer5(this.getBot()).posZ));
        float nY = BlockUtils.normalizeYaw((float)(vector2f.y));
        float nP = BlockUtils.normalizePitch((float)(vector2f.x));
        if (!Float.isNaN(nY) && !Float.isNaN(nP)) {
            SpinTask.getPlayer(this.getBot()).rotationYaw = nY;
            SpinTask.getPlayer3(this.getBot()).rotationPitch = nP;
        }
        if (distance > (float)(this.radius)) {
            SpinTask.getGameSettings6(this.getMc()).keyBindForward = true;
            SpinTask.getGameSettings(this.getMc()).keyBindLeft = false;
        } else {
            SpinTask.getGameSettings5(this.getMc()).keyBindForward = false;
            SpinTask.getGameSettings3(this.getMc()).keyBindLeft = true;
        }
    }

    private static Entity getTargetEntity7(SpinTask instance) {
        return instance.targetEntity;
    }

    private static PBotPlayer getPlayer5(PBot instance) {
        return instance.player;
    }

    private static Entity getTargetEntity8(SpinTask instance) {
        return instance.targetEntity;
    }
}

