/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 *  net.minecraft.entity.player.PlayerEntity
 */
package com.botclient;

import com.botclient.Event;
import net.minecraft.entity.player.PlayerEntity;

public class NameTagRenderEvent
implements Event {
    public boolean canceled;
    public PlayerEntity player;
    public Runnable callback;

    public boolean isCanceled() {
        return (this.canceled);
    }

    private static void setCanceled(NameTagRenderEvent t, boolean value) {
        t.canceled = value;
    }

    public NameTagRenderEvent(PlayerEntity player, Runnable callback) {
        this.player = player;
        this.callback = callback;
    }

    public PlayerEntity getPlayer() {
        return (this.player);
    }

    private static PlayerEntity getPlayer(NameTagRenderEvent instance) {
        return instance.player;
    }

    public void setCanceled() {
        this.canceled = true;
    }

    public void draw() {
        (this.callback).run();
    }
}

