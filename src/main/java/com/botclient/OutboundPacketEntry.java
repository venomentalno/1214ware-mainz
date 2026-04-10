/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.concurrent.Future
 *  io.netty.util.concurrent.GenericFutureListener
 *  net.minecraft.network.Packet
 */
package neo.deobf;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.Packet;

/*
 * Exception performing whole class analysis ignored.
 */
class OutboundPacketEntry {
    public final Packet<?> packet;
    public final GenericFutureListener<? extends Future<? super Void>>[] futureListeners;

    static GenericFutureListener[] access$100(OutboundPacketEntry x0) {
        return x0.futureListeners;
    }

    static Packet access$000(OutboundPacketEntry x0) {
        return x0.packet;
    }

    public OutboundPacketEntry(Packet<?> inPacket, GenericFutureListener<? extends Future<? super Void>> ... inFutureListeners) {
        this.packet = inPacket;
        this.futureListeners = inFutureListeners;
    }
}

