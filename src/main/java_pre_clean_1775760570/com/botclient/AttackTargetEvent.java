/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  net.minecraft.entity.Entity
 */
package com.botclient;

import com.botclient.CancellableEvent;
import net.minecraft.entity.Entity;

public class AttackTargetEvent
extends CancellableEvent {
    public final Entity targetEntity;

    private static Entity getTargetEntity(AttackTargetEvent instance) {
        return instance.targetEntity;
    }

    public AttackTargetEvent(Entity targetEntity) {
        this.targetEntity = targetEntity;
    }

    public Entity getTargetEntity() {
        return (this.targetEntity);
    }
}

