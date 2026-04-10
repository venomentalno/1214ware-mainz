package neo.deobf;

import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.protocol.Packet;

public class OutboundPacketEntry {
    private final Packet<?> packet;
    private final GenericFutureListener<?>[] listeners;

    public OutboundPacketEntry(Packet<?> packet, GenericFutureListener<?>[] listeners) {
        this.packet    = packet;
        this.listeners = listeners;
    }

    public Packet<?> getPacket()                    { return packet;    }
    public GenericFutureListener<?>[] getListeners() { return listeners; }

    // legacy CFR-generated accessor stubs kept for source compatibility
    public static Packet<?> access$000(OutboundPacketEntry e) { return e.packet;    }
    public static GenericFutureListener<?>[] access$100(OutboundPacketEntry e) { return e.listeners; }
}
