/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  net.minecraft.entity.LivingEntity
 */
package com.botclient;

import com.botclient.CancellableEvent;
import net.minecraft.entity.LivingEntity;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class EntityNameRenderEvent
extends CancellableEvent {
    public String renderedName;
    public final LivingEntity entity;

    private static void setRenderedName(EntityNameRenderEvent u, String string) {
        u.renderedName = string;
    }

    private static LivingEntity getEntity(EntityNameRenderEvent instance) {
        return instance.entity;
    }

    public EntityNameRenderEvent(LivingEntity entity, String renderedName) {
        this.entity = entity;
        this.renderedName = renderedName;
    }

    public LivingEntity getEntity() {
        return (this.entity);
    }

    private static String getRenderedName(EntityNameRenderEvent instance) {
        return instance.renderedName;
    }

    public void setRenderedName(String renderedName) {
        this.renderedName = renderedName;
    }

    public String getRenderedName() {
        return (this.renderedName);
    }
}

