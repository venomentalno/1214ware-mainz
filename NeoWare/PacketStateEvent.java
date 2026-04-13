/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.PacketEventState
 *  neo.deobf.Event
 */
package neo.deobf;

import neo.deobf.PacketEventState;
import neo.deobf.Event;

public class PacketStateEvent
implements Event {
    public PacketEventState state;

    public boolean isPre() {
        return ((this.state) == (PacketEventState.PRE) ? 1 : 0) != 0;
    }

    public void setState(PacketEventState state) {
        this.state = state;
    }

    private static PacketEventState getState(PacketStateEvent instance) {
        return instance.state;
    }

    private static void setState(PacketStateEvent v, PacketEventState y) {
        v.state = y;
    }

    public PacketStateEvent(PacketEventState state) {
        this.state = state;
    }

    public PacketEventState getState() {
        return (this.state);
    }
}

