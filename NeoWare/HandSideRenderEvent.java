/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 *  net.minecraft.util.EnumHandSide
 */
package neo.deobf;

import neo.deobf.Event;
import net.minecraft.util.EnumHandSide;

public class HandSideRenderEvent
implements Event {
    public final EnumHandSide enumHandSide;

    public HandSideRenderEvent(EnumHandSide enumHandSide) {
        this.enumHandSide = enumHandSide;
    }

    public EnumHandSide getEnumHandSide() {
        return (this.enumHandSide);
    }

    private static EnumHandSide getEnumHandSide(HandSideRenderEvent instance) {
        return instance.enumHandSide;
    }
}

