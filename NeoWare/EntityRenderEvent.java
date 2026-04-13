/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 *  net.minecraft.entity.Entity
 */
package neo.deobf;

import neo.deobf.Event;
import net.minecraft.entity.Entity;

public class EntityRenderEvent
implements Event {
    public boolean canceled;
    public Entity entity;

    public boolean isCanceled() {
        return (this.canceled);
    }

    private static Entity getEntity(EntityRenderEvent instance) {
        return instance.entity;
    }

    private static void setCanceled(EntityRenderEvent z, boolean value) {
        z.canceled = value;
    }

    public void setCanceled() {
        this.canceled = true;
    }

    public Entity getEntity() {
        return (this.entity);
    }

    public EntityRenderEvent(Entity entity) {
        this.entity = entity;
    }
}

