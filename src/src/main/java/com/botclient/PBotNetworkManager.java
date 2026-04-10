package neo.deobf;

import com.google.common.collect.Queues;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.TimeoutException;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.*;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.chat.Component;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.net.InetAddress;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 1.21.4 port of PBotNetworkManager.
 *
 * Key changes vs 1.12.2:
 *  - EnumConnectionState      → ConnectionProtocol
 *  - INetHandler               → PacketListener
 *  - NettyCompressionDecoder/Encoder → same class names, different package
 *  - ITextComponent            → Component
 *  - TextComponentTranslation  → Component.translatable(...)
 *  - ITickable                 → TickablePacketListener (interface on the handler)
 *  - ThreadQuickExitException  → SkipPacketException
 */
public class PBotNetworkManager extends SimpleChannelInboundHandler<Packet<?>> {

    public static final Logger  LOGGER;
    public static final AttributeKey<ConnectionProtocol> PROTOCOL_ATTRIBUTE_KEY;
    public static final EventLoopGroup                   group;
    public static final Class<? extends Channel>         channelClass;

    static {
        LOGGER               = LogManager.getLogger();
        PROTOCOL_ATTRIBUTE_KEY = AttributeKey.valueOf("protocol");
        group       = Epoll.isAvailable() ? new EpollEventLoopGroup(6) : new NioEventLoopGroup(6);
        channelClass = Epoll.isAvailable() ? EpollSocketChannel.class  : NioSocketChannel.class;
    }

    public Channel               channel;
    public PacketListener        packetListener;
    public Component             terminationReason;
    public final Queue<OutboundPacketEntry> outboundPacketsQueue = Queues.newConcurrentLinkedQueue();
    public final ReentrantReadWriteLock     readWriteLock        = new ReentrantReadWriteLock();
    public final PBot pbot;

    public PBotNetworkManager(PBot pbot) {
        this.pbot = pbot;
    }

    // ── factory ──────────────────────────────────────────────────────────────
    public static PBotNetworkManager createNetworkManagerAndConnect(
            InetAddress address, int port, PBot pbot, ProxyInfo proxy) {
        PBotNetworkManager manager = new PBotNetworkManager(pbot);
        new Bootstrap()
            .group(group)
            .channel(channelClass)
            .option(ChannelOption.TCP_NODELAY, true)
            .handler(new ProxyChannelInitializer(proxy, manager))
            .connect(address, port);
        return manager;
    }

    // ── Netty lifecycle ───────────────────────────────────────────────────────
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        this.channel = ctx.channel();
        try {
            setConnectionState(ConnectionProtocol.HANDSHAKING);
        } catch (Throwable t) {
            LOGGER.fatal(t);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        closeChannel(Component.translatable("disconnect.endOfStream"));
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet<?> packet) {
        if (channel.isOpen()) {
            try {
                //noinspection unchecked,rawtypes
                ((Packet) packet).handle(packetListener);
            } catch (Exception ignored) {
                // SkipPacketException equivalent – silently skip
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        String msg = cause.toString();
        if (!msg.contains("netty.") && !msg.contains("ClosedChannelException")) {
            if (BotDebugModule.internalErrors.value) {
                ChatUtils.formatMsg("Disconnection &d&l" + pbot.getNickname() + " &c" + cause);
                for (StackTraceElement e : cause.getStackTrace())
                    ChatUtils.defaultMsg("&c at &c" + e);
            }
            pbot.reconnect(false);
        }
        Component reason = (cause instanceof TimeoutException)
                ? Component.translatable("disconnect.timeout")
                : Component.translatable("disconnect.genericReason",
                        "Internal Exception: " + cause);
        LOGGER.debug(reason.getString(), cause);
        closeChannel(reason);
    }

    // ── state & compression ───────────────────────────────────────────────────
    public void setConnectionState(ConnectionProtocol state) {
        channel.attr(PROTOCOL_ATTRIBUTE_KEY).set(state);
        channel.config().setAutoRead(true);
    }

    public void setCompressionThreshold(int threshold) {
        if (threshold >= 0) {
            if (channel.pipeline().get("decompress") instanceof CompressionDecoder d)
                d.setThreshold(threshold, false);
            else
                channel.pipeline().addBefore("decoder", "decompress", new CompressionDecoder(threshold, false));

            if (channel.pipeline().get("compress") instanceof CompressionEncoder e)
                e.setThreshold(threshold);
            else
                channel.pipeline().addBefore("encoder", "compress", new CompressionEncoder(threshold));
        } else {
            if (channel.pipeline().get("decompress") instanceof CompressionDecoder)
                channel.pipeline().remove("decompress");
            if (channel.pipeline().get("compress") instanceof CompressionEncoder)
                channel.pipeline().remove("compress");
        }
    }

    // ── packet send ───────────────────────────────────────────────────────────
    public void sendPacket(Packet<?> packet) {
        if (isChannelOpen()) {
            flushOutboundQueue();
            dispatchPacket(packet, null);
        } else {
            readWriteLock.writeLock().lock();
            try {
                outboundPacketsQueue.add(new OutboundPacketEntry(packet, new GenericFutureListener[0]));
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }
    }

    private void dispatchPacket(Packet<?> packet, @Nullable GenericFutureListener<?>[] listeners) {
        ConnectionProtocol state  = ConnectionProtocol.getProtocolForPacket(packet);
        ConnectionProtocol current= channel.attr(PROTOCOL_ATTRIBUTE_KEY).get();
        if (current != state) channel.config().setAutoRead(false);

        if (channel.eventLoop().inEventLoop()) {
            if (state != current) setConnectionState(state);
            ChannelFuture f = channel.writeAndFlush(packet);
            if (listeners != null) f.addListeners(listeners);
            f.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        } else {
            channel.eventLoop().execute(
                new QueuedPacketTask(this, state, current, packet, listeners));
        }
    }

    private void flushOutboundQueue() {
        if (channel == null || !channel.isOpen()) return;
        readWriteLock.readLock().lock();
        try {
            while (!outboundPacketsQueue.isEmpty()) {
                OutboundPacketEntry e = outboundPacketsQueue.poll();
                dispatchPacket(e.getPacket(), e.getListeners());
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    // ── lifecycle helpers ─────────────────────────────────────────────────────
    public void processReceivedPackets() {
        flushOutboundQueue();
        // 1.21.4: TickablePacketListener replaces ITickable
        if (packetListener instanceof TickablePacketListener t) t.tick();
        if (channel != null) channel.flush();
    }

    public void handleDisconnection() {
        if (channel != null && !channel.isOpen()) {
            if (terminationReason != null) packetListener.onDisconnect(terminationReason);
            else if (packetListener != null)
                packetListener.onDisconnect(Component.translatable("multiplayer.disconnect.generic"));
        }
    }

    public void closeChannel(Component message) {
        if (channel != null && channel.isOpen()) {
            channel.close();
            terminationReason = message;
        }
    }

    public boolean isChannelOpen()  { return channel != null && channel.isOpen(); }
    public boolean isLocalChannel() { return channel instanceof LocalChannel || channel instanceof LocalServerChannel; }

    public PacketListener getNetHandler()          { return packetListener; }
    public void setNetHandler(PacketListener h)    {
        Validate.notNull(h, "packetListener");
        this.packetListener = h;
    }
    public Component getExitMessage()              { return terminationReason; }
}
