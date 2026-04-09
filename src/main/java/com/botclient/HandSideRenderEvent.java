/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 *  net.minecraft.util.HandSide
 */
package com.botclient;

import com.botclient.Event;
import net.minecraft.util.HandSide;

public class HandSideRenderEvent
implements Event {
    public final HandSide enumHandSide;

    public HandSideRenderEvent(HandSide enumHandSide) {
        this.enumHandSide = enumHandSide;
    }

    public HandSide getHandSide() {
        return (this.enumHandSide);
    }

    private static HandSide getHandSide(HandSideRenderEvent instance) {
        return instance.enumHandSide;
    }
}

