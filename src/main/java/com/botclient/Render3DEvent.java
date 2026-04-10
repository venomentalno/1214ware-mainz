/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 */
package neo.deobf;

import neo.deobf.Event;

public class Render3DEvent
implements Event {
    public final float partialTicks;

    public Render3DEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return (this.partialTicks);
    }

    private static float getPartialTicks(Render3DEvent instance) {
        return instance.partialTicks;
    }
}

