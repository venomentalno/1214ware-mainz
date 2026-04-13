/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.EventStage
 *  neo.deobf.CancellableEvent
 *  neo.deobf.Event
 *  net.minecraft.entity.Entity
 */
package neo.deobf;

import neo.deobf.EventStage;
import neo.deobf.CancellableEvent;
import neo.deobf.Event;
import net.minecraft.entity.Entity;

public class EntityEvent
extends CancellableEvent
implements Event {
    public boolean canceled;
    public Entity entity;
    public EventStage type;

    public void setCanceled() {
        this.canceled = true;
    }

    public EntityEvent(Entity entity, EventStage type) {
        this.entity = entity;
        this.type = type;
    }

    private static Entity getEntity(EntityEvent instance) {
        return instance.entity;
    }

    private static void setCanceled(EntityEvent j, boolean value) {
        j.canceled = value;
    }

    public boolean isCanceled() {
        return (this.canceled);
    }

    public EventStage getType() {
        return (this.type);
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return (this.entity);
    }

    private static void setEntity(EntityEvent j, Entity entity) {
        j.entity = entity;
    }

    private static EventStage getType(EntityEvent instance) {
        return instance.type;
    }
}

