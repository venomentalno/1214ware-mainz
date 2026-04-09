/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelFuture
 *  io.netty.channel.ChannelFutureListener
 *  io.netty.util.concurrent.GenericFutureListener
 *  neo.deobf.PBotNetworkManager
 *  net.minecraft.network.EnumConnectionState
 *  net.minecraft.network.Packet
 */
package com.botclient;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import com.botclient.PBotNetworkManager;
import net.minecraft.network.packet.Packet;

/*
 * Exception performing whole class analysis ignored.
 */
class QueuedPacketTask
implements Runnable {
    public final Packet val$inPacket;
    public final Integer val$enumconnectionstate1;
    public final GenericFutureListener<? extends Future<? super Void>>[] val$futureListeners;
    public final PBotNetworkManager this$0;
    public final Integer val$enumconnectionstate;

    QueuedPacketTask(PBotNetworkManager this$0, Integer enumConnectionState, Integer enumConnectionState2, Packet packet, GenericFutureListener<? extends Future<? super Void>>[] genericFutureListenerArray) {
        this.this$0 = this$0;
        this.val$enumconnectionstate = enumConnectionState;
        this.val$enumconnectionstate1 = enumConnectionState2;
        this.val$inPacket = packet;
        this.val$futureListeners = genericFutureListenerArray;
    }

    @Override
    public void run() {
        if (this.val$enumconnectionstate != this.val$enumconnectionstate1) {
            this.this$0.setConnectionState(this.val$enumconnectionstate);
        }
        ChannelFuture channelfuture1 = this.this$0.channel.writeAndFlush((Object)this.val$inPacket);
        if (this.val$futureListeners != null) {
            channelfuture1.addListeners(this.val$futureListeners);
        }
        channelfuture1.addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
    }

}

