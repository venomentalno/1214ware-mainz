package neo.deobf;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.protocol.Packet;

public class QueuedPacketTask implements Runnable {
    private final PBotNetworkManager manager;
    private final ConnectionProtocol newState;
    private final ConnectionProtocol oldState;
    private final Packet<?> packet;
    private final GenericFutureListener<?>[] listeners;

    public QueuedPacketTask(PBotNetworkManager manager,
                            ConnectionProtocol newState,
                            ConnectionProtocol oldState,
                            Packet<?> packet,
                            GenericFutureListener<?>[] listeners) {
        this.manager   = manager;
        this.newState  = newState;
        this.oldState  = oldState;
        this.packet    = packet;
        this.listeners = listeners;
    }

    @Override
    public void run() {
        if (newState != oldState) {
            manager.setConnectionState(newState);
        }
        ChannelFuture future = manager.channel.writeAndFlush(packet);
        if (listeners != null) future.addListeners(listeners);
        future.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
    }
}
