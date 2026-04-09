/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketPlayerListItem$Action
 */
package com.botclient;

import net.minecraft.network.packet.s2c.play.SPacketPlayerListItem;

/*
 * Exception performing whole class analysis ignored.
 */
class PlayerListActionSwitchMap {
    public static final int[] $SwitchMap$net$minecraft$network$play$server$SPacketPlayerListItem$Action;

    static {
        $SwitchMap$net$minecraft$network$play$server$SPacketPlayerListItem$Action = new int[SPacketPlayerListItem.Action.values().length];
        try {
            PlayerListActionSwitchMap.$SwitchMap$net$minecraft$network$play$server$SPacketPlayerListItem$Action[SPacketPlayerListItem.Action.ADD_PLAYER.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            PlayerListActionSwitchMap.$SwitchMap$net$minecraft$network$play$server$SPacketPlayerListItem$Action[SPacketPlayerListItem.Action.UPDATE_GAME_MODE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            PlayerListActionSwitchMap.$SwitchMap$net$minecraft$network$play$server$SPacketPlayerListItem$Action[SPacketPlayerListItem.Action.UPDATE_LATENCY.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            PlayerListActionSwitchMap.$SwitchMap$net$minecraft$network$play$server$SPacketPlayerListItem$Action[SPacketPlayerListItem.Action.UPDATE_DISPLAY_NAME.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}





