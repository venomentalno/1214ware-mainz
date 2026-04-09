/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.BotTask
 *  neo.deobf.BlockUtils
 *  neo.deobf.MillisTimer
 *  neo.deobf.ThreadUtils
 *  net.minecraft.entity.projectile.FishingBobberEntity
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemFishingRod
 */
package com.botclient;

import com.botclient.PBot;
import com.botclient.PBotPlayer;
import com.botclient.BotTask;
import com.botclient.BlockUtils;
import com.botclient.MillisTimer;
import com.botclient.ThreadUtils;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.registry.Registries;
import net.minecraft.item.Item;
import net.minecraft.item.FishingRodItem;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AutoFishTask
extends BotTask {
    public boolean isHooked;
    public MillisTimer timer;
    public float calibrate;

    public AutoFishTask(PBot bot) {
        super(bot, "AutoFish");
    }

    private static double getPosY(EntityFishHook entityFishHook) {
        return entityFishHook.posY;
    }

    private void setHooking() {
        this.isHooked = true;
        this.getMc().rightClickMouse();
        new Thread(() -> {
            ThreadUtils.sleep((long)100L);
            this.getMc().rightClickMouse();
            (this.timer).reset();
            this.isHooked = false;
        }).start();
    }

    public void init() {
        PBot bot = this.getBot();
        int rodSlot = BlockUtils.findItem((PBot)bot, (Item)(Items.FISHING_ROD));
        if (rodSlot == (-1)) {
            this.sendDebug("&5[&dBot-Baritone&5] &7Bot " + bot.getNickname() + " | FISHING_ROD not found!");
            this.getBaritone().setBotFunction(null);
            return;
        }
        bot.changeSlot(0);
        this.getMc().rightClickMouse();
        this.timer = new MillisTimer();
        bot.changeSlot(0);
        this.isHooked = false;
        this.sendDebug("&5[&dBot-Baritone&5] &7Bot " + bot.getNickname() + " | Starting AutoFisher...");
    }
private static PBotPlayer getPlayer(PBot instance) {
        return instance.player;
    }

    public void onUpdate() {
        EntityFishHook fishHook = (AutoFishTask.getPlayer(this.getBot()).fishEntity);
        if (fishHook == null) {
            return;
        }
        fishHook.onUpdate();
        if (!(this.timer).hasReached(4000.0)) {
            this.calibrate = (float)AutoFishTask.getPosY(fishHook);
            return;
        }
        if ((this.isHooked)) {
            return;
        }
        if ((this.timer).hasReached(90000.0)) {
            this.setHooking();
            return;
        }
        float f = (this.calibrate) - (float)(fishHook.posY);
        if (f > 0.200000003f) {
            this.sendDebug("&5[&dBot-Baritone&5] &7Bot " + this.getBot().getNickname() + " | fish hooked");
            this.setHooking();
        }
    }

    public void onFinish() {
        this.getMc().rightClickMouse();
        super.onFinish();
    }
}

