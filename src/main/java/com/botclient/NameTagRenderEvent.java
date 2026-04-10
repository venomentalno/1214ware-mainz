/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 *  net.minecraft.entity.player.EntityPlayer
 */
package neo.deobf;

import neo.deobf.Event;
import net.minecraft.entity.player.EntityPlayer;

public class NameTagRenderEvent
implements Event {
    public boolean canceled;
    public EntityPlayer player;
    public Runnable callback;

    public boolean isCanceled() {
        return (this.canceled);
    }

    private static void setCanceled(NameTagRenderEvent t, boolean value) {
        t.canceled = value;
    }

    public NameTagRenderEvent(EntityPlayer player, Runnable callback) {
        this.player = player;
        this.callback = callback;
    }

    public EntityPlayer getPlayer() {
        return (this.player);
    }

    private static EntityPlayer getPlayer(NameTagRenderEvent instance) {
        return instance.player;
    }

    public void setCanceled() {
        this.canceled = true;
    }

    public void draw() {
        (this.callback).run();
    }
}

