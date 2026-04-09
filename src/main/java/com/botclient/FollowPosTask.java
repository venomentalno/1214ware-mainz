/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.joml.Vector2f
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.BotKeyState
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.BotTask
 *  neo.deobf.BlockUtils
 *  net.minecraft.util.math.BlockPos
 */
package com.botclient;

import org.joml.Vector2f;
import com.botclient.PBot;
import com.botclient.PBotPlayer;
import com.botclient.BotKeyState;
import com.botclient.PBotMinecraft;
import com.botclient.BotTask;
import com.botclient.BlockUtils;
import net.minecraft.util.math.BlockPos;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class FollowPosTask
extends BotTask {
    public final BlockPos postiton;

    private static PBotPlayer getPlayer(PBot instance) {
        return instance.player;
    }

    public void onUpdate() {
        if ((this.postiton) == null) {
            return;
        }
        Vector2f vector2f = BlockUtils.getBlockAngles((double)(this.postiton).getX(), (double)((this.postiton).getY() + (1)), (double)(this.postiton).getZ(), (double)(FollowPosTask.getPlayer3(this.getBot()).posX), (double)(FollowPosTask.getPlayer5(this.getBot()).posY), (double)(FollowPosTask.getPlayer2(this.getBot()).posZ));
        float distance = BlockUtils.get2dDistance((PBot)this.getBot(), (double)(this.postiton).getX(), (double)(this.postiton).getZ());
        float nY = BlockUtils.normalizeYaw((float)(vector2f.y));
        float nP = BlockUtils.normalizePitch((float)(vector2f.x));
        if (!Float.isNaN(nY) && !Float.isNaN(nP)) {
            FollowPosTask.getPlayer4(this.getBot()).rotationYaw = nY;
            FollowPosTask.getPlayer(this.getBot()).rotationPitch = nP;
        }
        FollowPosTask.getGameOptions2(this.getMc()).keyBindForward = true;
        if ((double)distance < 0.20000000000000001) {
            this.getBaritone().setBotFunction(null);
        }
    }

    private static BotKeyState getGameOptions(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    public void onFinish() {
        FollowPosTask.getGameOptions(this.getMc()).keyBindForward = false;
        super.onFinish();
    }

    private static PBotPlayer getPlayer2(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer3(PBot instance) {
        return instance.player;
    }

    public FollowPosTask(PBot bot, BlockPos postiton) {
        super(bot, "FollowPos");
        this.postiton = postiton;
    }

    public void init() {
        if ((this.postiton) == null) {
            this.sendDebug("&5[&dBot-Baritone&5] &7Bot " + this.getBot().getNickname() + " | Unknown position!");
            this.getBaritone().setBotFunction(null);
        }
    }

    private static BotKeyState getGameOptions2(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotPlayer getPlayer4(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer5(PBot instance) {
        return instance.player;
    }

}

