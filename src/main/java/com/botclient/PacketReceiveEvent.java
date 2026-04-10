/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  neo.deobf.Event
 *  net.minecraft.network.Packet
 */
package neo.deobf;

import neo.deobf.CancellableEvent;
import neo.deobf.Event;
import net.minecraft.network.Packet;

public class PacketReceiveEvent
extends CancellableEvent
implements Event {
    public Packet packet;

    public PacketReceiveEvent(Packet packet) {
        this.packet = packet;
    }

    private static Packet getPacket(PacketReceiveEvent instance) {
        return instance.packet;
    }

    public Packet getPacket() {
        return (this.packet);
    }
}

