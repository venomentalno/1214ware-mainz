/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 */
package neo.deobf;

import neo.deobf.Event;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class StoppableEvent
implements Event {
    public boolean stopped;

    public boolean isStopped() {
        return (this.stopped);
    }

    public void stop() {
        this.stopped = true;
    }
}

