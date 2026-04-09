/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.BlockPos
 */
package com.botclient;

import com.botclient.CancellableEvent;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.BlockPos;

public class BlockClickEvent
extends CancellableEvent {
    public Direction face;
    public BlockPos pos;

    public BlockPos getPos() {
        return (this.pos);
    }

    public BlockClickEvent(BlockPos pos, Direction face) {
        this.pos = pos;
        this.face = face;
    }

    private static void setPos(BlockClickEvent w, BlockPos blockPos) {
        w.pos = blockPos;
    }

    private static BlockPos getPos(BlockClickEvent instance) {
        return instance.pos;
    }

    private static Direction getFace(BlockClickEvent instance) {
        return instance.face;
    }

    public void setFace(Direction face) {
        this.face = face;
    }

    private static void setFace(BlockClickEvent w, Direction enumFacing) {
        w.face = enumFacing;
    }

    public Direction getFace() {
        return (this.face);
    }

    public void setPos(BlockPos pos) {
        this.pos = pos;
    }
}

