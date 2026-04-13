/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Queues
 *  de.florianmichael.vialoadingbase.netty.event.CompressionReorderEvent
 *  io.netty.bootstrap.Bootstrap
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelFuture
 *  io.netty.channel.ChannelFutureListener
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelOption
 *  io.netty.channel.EventLoopGroup
 *  io.netty.channel.SimpleChannelInboundHandler
 *  io.netty.channel.epoll.Epoll
 *  io.netty.channel.epoll.EpollEventLoopGroup
 *  io.netty.channel.epoll.EpollSocketChannel
 *  io.netty.channel.local.LocalChannel
 *  io.netty.channel.local.LocalServerChannel
 *  io.netty.channel.nio.NioEventLoopGroup
 *  io.netty.channel.socket.nio.NioSocketChannel
 *  io.netty.handler.timeout.TimeoutException
 *  io.netty.util.AttributeKey
 *  io.netty.util.concurrent.GenericFutureListener
 *  javax.annotation.Nullable
 *  neo.deobf.BooleanSetting
 *  neo.deobf.PBot
 *  neo.deobf.QueuedPacketTask
 *  neo.deobf.ProxyChannelInitializer
 *  neo.deobf.OutboundPacketEntry
 *  neo.deobf.BotDebugModule
 *  neo.deobf.ChatUtils
 *  neo.deobf.ProxyInfo
 *  net.minecraft.network.EnumConnectionState
 *  net.minecraft.network.INetHandler
 *  net.minecraft.network.NettyCompressionDecoder
 *  net.minecraft.network.NettyCompressionEncoder
 *  net.minecraft.network.Packet
 *  net.minecraft.network.ThreadQuickExitException
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentTranslation
 *  org.apache.commons.lang3.Validate
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package neo.deobf;

import com.google.common.collect.Queues;
import de.florianmichael.vialoadingbase.netty.event.CompressionReorderEvent;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
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
import java.net.InetAddress;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
import neo.deobf.BooleanSetting;
import neo.deobf.PBot;
import neo.deobf.QueuedPacketTask;
import neo.deobf.ProxyChannelInitializer;
import neo.deobf.OutboundPacketEntry;
import neo.deobf.BotDebugModule;
import neo.deobf.ChatUtils;
import neo.deobf.ProxyInfo;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NettyCompressionDecoder;
import net.minecraft.network.NettyCompressionEncoder;
import net.minecraft.network.Packet;
import net.minecraft.network.ThreadQuickExitException;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PBotNetworkManager
extends SimpleChannelInboundHandler<Packet<?>> {
    public static final EventLoopGroup group;
    public INetHandler packetListener;
    public Channel channel;
    public final Queue<OutboundPacketEntry> outboundPacketsQueue = Queues.newConcurrentLinkedQueue();
    public static final Logger LOGGER;
    public static final AttributeKey<EnumConnectionState> PROTOCOL_ATTRIBUTE_KEY;
    public ITextComponent terminationReason;
    public final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public final PBot pbot;
    public static final Class<? extends Channel> channelClass;

    public ITextComponent getExitMessage() {
        return (this.terminationReason);
    }

    public static PBotNetworkManager createNetworkManagerAndConnect(InetAddress address, int serverPort, PBot pBot, ProxyInfo proxy) {
        PBotNetworkManager networkmanager = new PBotNetworkManager(pBot);
        ((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((group))).channel((channelClass))).option((ChannelOption.TCP_NODELAY), (Object)(true))).handler((ChannelHandler)new ProxyChannelInitializer(proxy, networkmanager))).connect(address, serverPort);
        return networkmanager;
    }

    public boolean isChannelOpen() {
        return ((this.channel) != null && (this.channel).isOpen() ? 1 : 0) != 0;
    }

    public void sendPacket(Packet<?> packetIn) {
        if (this.isChannelOpen()) {
            this.flushOutboundQueue();
            this.dispatchPacket(packetIn, null);
        } else {
            (this.readWriteLock).writeLock().lock();
            try {
                (this.outboundPacketsQueue).add(new OutboundPacketEntry(packetIn, new GenericFutureListener[0]));
                (this.readWriteLock).writeLock().unlock();
            }
            catch (Throwable throwable) {
                (this.readWriteLock).writeLock().unlock();
                throw throwable;
            }
        }
    }

    public void handleDisconnection() {
        if ((this.channel) != null && !(this.channel).isOpen()) {
            if (this.getExitMessage() != null) {
                this.getNetHandler().onDisconnect(this.getExitMessage());
            } else if (this.getNetHandler() != null) {
                this.getNetHandler().onDisconnect((ITextComponent)new TextComponentTranslation("multiplayer.disconnect.generic", new Object[0]));
            }
        }
    }

    public void processReceivedPackets() {
        this.flushOutboundQueue();
        if ((this.packetListener) instanceof ITickable) {
            ((ITickable)(this.packetListener)).update();
        }
        if ((this.channel) != null) {
            (this.channel).flush();
        }
    }

    public void channelInactive(ChannelHandlerContext p_channelInactive_1_) {
        this.closeChannel((ITextComponent)new TextComponentTranslation("disconnect.endOfStream", new Object[0]));
    }

    public void closeChannel(ITextComponent message) {
        if ((this.channel) != null && (this.channel).isOpen()) {
            (this.channel).close();
            this.terminationReason = message;
        }
    }

    public void channelActive(ChannelHandlerContext p_channelActive_1_) throws Exception {
        super.channelActive(p_channelActive_1_);
        this.p_channelActive_1_.channel() = p_channelActive_1_.channel();
        try {
            this.setConnectionState((EnumConnectionState.HANDSHAKING));
        }
        catch (Throwable throwable) {
            (LOGGER).fatal((Object)throwable);
        }
    }

    public void setConnectionState(EnumConnectionState newState) {
        (this.channel).attr((PROTOCOL_ATTRIBUTE_KEY)).set((Object)newState);
        (this.channel).config().setAutoRead(true);
        (LOGGER).debug("Enabled auto read");
    }

    public PBotNetworkManager(PBot pbot) {
        this.pbot = pbot;
    }

    static {
        LOGGER = LogManager.getLogger();
        PROTOCOL_ATTRIBUTE_KEY = AttributeKey.valueOf((String)"protocol");
        group = Epoll.isAvailable() ? new EpollEventLoopGroup(6) : new NioEventLoopGroup(6);
        channelClass = Epoll.isAvailable() ? EpollSocketChannel.class : NioSocketChannel.class;
    }

    public INetHandler getNetHandler() {
        return (this.packetListener);
    }

    public void setNetHandler(INetHandler handler) {
        Validate.notNull((Object)handler, (String)"packetListener", (Object[])new Object[0]);
        (LOGGER).debug("Set listener of {} to {}", (Object)this, (Object)handler);
        this.packetListener = handler;
    }

    protected void channelRead0(ChannelHandlerContext p_channelRead0_1_, Packet<?> p_channelRead0_2_) {
        if ((this.channel).isOpen()) {
            try {
                p_channelRead0_2_.processPacket((this.packetListener));
            }
            catch (ThreadQuickExitException threadQuickExitException) {
                // empty catch block
            }
        }
    }

    public boolean isLocalChannel() {
        return ((this.channel) instanceof LocalChannel || (this.channel) instanceof LocalServerChannel ? 1 : 0) != 0;
    }
private static BooleanSetting getInternalErrors() {
        return BotDebugModule.internalErrors;
    }

    private void dispatchPacket(Packet<?> inPacket, @Nullable GenericFutureListener[] futureListeners) {
        EnumConnectionState enumconnectionstate = EnumConnectionState.getFromPacket(inPacket);
        EnumConnectionState enumconnectionstate1 = (EnumConnectionState)(this.channel).attr((PROTOCOL_ATTRIBUTE_KEY)).get();
        if (enumconnectionstate1 != enumconnectionstate) {
            (LOGGER).debug("Disabled auto read");
            (this.channel).config().setAutoRead(false);
        }
        if ((this.channel).eventLoop().inEventLoop()) {
            if (enumconnectionstate != enumconnectionstate1) {
                this.setConnectionState(enumconnectionstate);
            }
            ChannelFuture channelfuture = (this.channel).writeAndFlush(inPacket);
            if (futureListeners != null) {
                channelfuture.addListeners(futureListeners);
            }
            channelfuture.addListener((GenericFutureListener)(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE));
        } else {
            (this.channel).eventLoop().execute((Runnable)new QueuedPacketTask(this, enumconnectionstate, enumconnectionstate1, inPacket, futureListeners));
        }
    }

    public void setCompressionThreshold(int threshold) {
        if (threshold >= 0) {
            if ((this.channel).pipeline().get("decompress") instanceof NettyCompressionDecoder) {
                ((NettyCompressionDecoder)(this.channel).pipeline().get("decompress")).setCompressionThreshold(threshold);
            } else {
                (this.channel).pipeline().addBefore("decoder", "decompress", (ChannelHandler)new NettyCompressionDecoder(threshold));
            }
            if ((this.channel).pipeline().get("compress") instanceof NettyCompressionEncoder) {
                ((NettyCompressionEncoder)(this.channel).pipeline().get("compress")).setCompressionThreshold(threshold);
            } else {
                (this.channel).pipeline().addBefore("encoder", "compress", (ChannelHandler)new NettyCompressionEncoder(threshold));
            }
        } else {
            if ((this.channel).pipeline().get("decompress") instanceof NettyCompressionDecoder) {
                (this.channel).pipeline().remove("decompress");
            }
            if ((this.channel).pipeline().get("compress") instanceof NettyCompressionEncoder) {
                (this.channel).pipeline().remove("compress");
            }
        }
        (this.channel).pipeline().fireUserEventTriggered((Object)new CompressionReorderEvent());
    }

    private void flushOutboundQueue() {
        if ((this.channel) != null && (this.channel).isOpen()) {
            (this.readWriteLock).readLock().lock();
            try {
                while (!(this.outboundPacketsQueue).isEmpty()) {
                    OutboundPacketEntry networkmanager$inboundhandlertuplepacketlistener = (OutboundPacketEntry)(this.outboundPacketsQueue).poll();
                    this.dispatchPacket(OutboundPacketEntry.access$000((OutboundPacketEntry)networkmanager$inboundhandlertuplepacketlistener), OutboundPacketEntry.access$100((OutboundPacketEntry)networkmanager$inboundhandlertuplepacketlistener));
                }
                (this.readWriteLock).readLock().unlock();
            }
            catch (Throwable throwable) {
                (this.readWriteLock).readLock().unlock();
                throw throwable;
            }
        }
    }

    public void exceptionCaught(ChannelHandlerContext p_exceptionCaught_1_, Throwable p_exceptionCaught_2_) {
        TextComponentTranslation textcomponenttranslation;
        if (!p_exceptionCaught_2_.toString().contains("netty.") && !p_exceptionCaught_2_.toString().contains("java.nio.channels.ClosedChannelException")) {
            if ((PBotNetworkManager.getInternalErrors().value)) {
                ChatUtils.formatMsg((String)("Отключение &d&l" + (this.pbot).getNickname() + " &c" + p_exceptionCaught_2_));
                StackTraceElement[] stackTraceElementArray = p_exceptionCaught_2_.getStackTrace();
                int n = stackTraceElementArray.length;
                for (int i = 0; i < n; ++i) {
                    StackTraceElement element = stackTraceElementArray[i];
                    ChatUtils.defaultMsg((String)("&c at &c" + element.toString()));
                }
            }
            (this.pbot).reconnect(false);
        }
        if (p_exceptionCaught_2_ instanceof TimeoutException) {
            textcomponenttranslation = new TextComponentTranslation("disconnect.timeout", new Object[0]);
        } else {
            Object[] objectArray = new Object[1];
            objectArray[0] = "Internal Exception: " + p_exceptionCaught_2_;
            textcomponenttranslation = new TextComponentTranslation("disconnect.genericReason", objectArray);
        }
        (LOGGER).debug(textcomponenttranslation.getUnformattedText(), p_exceptionCaught_2_);
        this.closeChannel((ITextComponent)textcomponenttranslation);
    }

}

