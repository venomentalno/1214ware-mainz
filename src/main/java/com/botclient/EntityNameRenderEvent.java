/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  net.minecraft.entity.EntityLivingBase
 */
package neo.deobf;

import neo.deobf.CancellableEvent;
import net.minecraft.entity.EntityLivingBase;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class EntityNameRenderEvent
extends CancellableEvent {
    public String renderedName;
    public final EntityLivingBase entity;

    private static void setRenderedName(EntityNameRenderEvent u, String string) {
        u.renderedName = string;
    }

    private static EntityLivingBase getEntity(EntityNameRenderEvent instance) {
        return instance.entity;
    }

    public EntityNameRenderEvent(EntityLivingBase entity, String renderedName) {
        this.entity = entity;
        this.renderedName = renderedName;
    }

    public EntityLivingBase getEntity() {
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

