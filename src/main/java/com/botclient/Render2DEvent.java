/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 *  net.minecraft.client.gui.ScaledResolution
 */
package com.botclient;

import com.botclient.Event;
import net.minecraft.client.util.Window;

public class Render2DEvent
implements Event {
    public final ScaledResolution resolution;

    private static ScaledResolution getResolution(Render2DEvent instance) {
        return instance.resolution;
    }

    public Render2DEvent(ScaledResolution resolution) {
        this.resolution = resolution;
    }

    public ScaledResolution getResolution() {
        return (this.resolution);
    }
}

