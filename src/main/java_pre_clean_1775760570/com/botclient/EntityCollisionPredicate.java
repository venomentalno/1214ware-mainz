/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  javax.annotation.Nullable
 *  neo.deobf.PBotMinecraft
 *  net.minecraft.entity.Entity
 */
package com.botclient;

import com.google.common.base.Predicate;
import javax.annotation.Nullable;
import com.botclient.PBotMinecraft;
import net.minecraft.entity.Entity;

/*
 * Exception performing whole class analysis ignored.
 */
class EntityCollisionPredicate
implements Predicate<Entity> {
    final PBotMinecraft this$0;

    public boolean apply(@Nullable Entity p_apply_1_) {
        return (p_apply_1_ != null && p_apply_1_.canBeCollidedWith() ? 1 : 0) != 0;
    }

    EntityCollisionPredicate(PBotMinecraft this$0) {
        this.this$0 = this$0;
    }
}





