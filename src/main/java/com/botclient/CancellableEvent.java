/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Cancellable
 *  neo.deobf.Event
 */
package com.botclient;

import com.botclient.Cancellable;
import com.botclient.Event;

public abstract class CancellableEvent
implements Event,
Cancellable {
    public boolean cancelled;

    public boolean isCancelled() {
        return (this.cancelled);
    }

    public void setCancelled(boolean state) {
        this.cancelled = state;
    }

    private static void setCancelled(CancellableEvent n, boolean value) {
        n.cancelled = value;
    }
}

