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
package neo.deobf;

import javax.vecmath.Vector2f;
import neo.deobf.PBot;
import neo.deobf.PBotPlayer;
import neo.deobf.BotKeyState;
import neo.deobf.PBotMinecraft;
import neo.deobf.BotTask;
import neo.deobf.BlockUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class FollowTask
extends BotTask {
    public Entity targetEntity = null;

    private static Entity getTargetEntity(FollowTask instance) {
        return instance.targetEntity;
    }

    public void onFinish() {
        FollowTask.getGameSettings2(this.getMc()).keyBindForward = false;
        super.onFinish();
    }

    private static PBotPlayer getPlayer(PBot instance) {
        return instance.player;
    }
private static Entity getTargetEntity3(FollowTask instance) {
        return instance.targetEntity;
    }

    private static PBotPlayer getPlayer2(PBot instance) {
        return instance.player;
    }

    public void onUpdate() {
        if ((this.targetEntity) == null) {
            return;
        }
        Vector2f vector2f = BlockUtils.getBlockAngles((double)(FollowTask.getTargetEntity6(this).posX), (double)((FollowTask.getTargetEntity4(this).posY) + 0.5), (double)(FollowTask.getTargetEntity7(this).posZ), (double)(FollowTask.getPlayer3(this.getBot()).posX), (double)(FollowTask.getPlayer4(this.getBot()).posY), (double)(FollowTask.getPlayer5(this.getBot()).posZ));
        float distance = BlockUtils.getDistance((PBot)this.getBot(), (double)(FollowTask.getTargetEntity8(this).posX), (double)(FollowTask.getTargetEntity3(this).posY), (double)(FollowTask.getTargetEntity(this).posZ));
        float nY = BlockUtils.normalizeYaw((float)(vector2f.y));
        float nP = BlockUtils.normalizePitch((float)(vector2f.x));
        if (!Float.isNaN(nY) && !Float.isNaN(nP)) {
            FollowTask.getPlayer2(this.getBot()).rotationYaw = nY;
            FollowTask.getPlayer(this.getBot()).rotationPitch = nP;
        }
        FollowTask.getGameSettings(this.getMc()).keyBindForward = (distance > 2.0f ? 1 : 0) != 0;
    }

    public void init() {
        if ((this.targetEntity) == null) {
            this.sendDebug("&5[&dBot-Baritone&5] &7Bot " + this.getBot().getNickname() + " | Unknown target!");
            this.getBaritone().setBotFunction(null);
        }
    }

    private static PBotPlayer getPlayer3(PBot instance) {
        return instance.player;
    }

    private static Entity getTargetEntity4(FollowTask instance) {
        return instance.targetEntity;
    }

    private static PBotPlayer getPlayer4(PBot instance) {
        return instance.player;
    }

    private static BotKeyState getGameSettings(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static Entity getTargetEntity6(FollowTask instance) {
        return instance.targetEntity;
    }

    private static BotKeyState getGameSettings2(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    public FollowTask(PBot bot, String targetName) {
        super(bot, "Follow");
        if (targetName.equalsIgnoreCase(this.getBot().getNickname())) {
            this.sendDebug("&5[&dBot-Baritone&5] &7Bot " + bot.getNickname() + " | Invaild target entity!");
            this.getBaritone().setBotFunction(null);
            return;
        }
        this.targetEntity = targetName.equalsIgnoreCase("@me") ? Minecraft.player : BlockUtils.getByName((String)targetName);
    }

    private static Entity getTargetEntity7(FollowTask instance) {
        return instance.targetEntity;
    }

    private static Entity getTargetEntity8(FollowTask instance) {
        return instance.targetEntity;
    }

    private static PBotPlayer getPlayer5(PBot instance) {
        return instance.player;
    }

}

