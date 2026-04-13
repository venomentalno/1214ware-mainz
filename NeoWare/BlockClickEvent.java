/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 */
package neo.deobf;

import neo.deobf.CancellableEvent;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class BlockClickEvent
extends CancellableEvent {
    public EnumFacing face;
    public BlockPos pos;

    public BlockPos getPos() {
        return (this.pos);
    }

    public BlockClickEvent(BlockPos pos, EnumFacing face) {
        this.pos = pos;
        this.face = face;
    }

    private static void setPos(BlockClickEvent w, BlockPos blockPos) {
        w.pos = blockPos;
    }

    private static BlockPos getPos(BlockClickEvent instance) {
        return instance.pos;
    }

    private static EnumFacing getFace(BlockClickEvent instance) {
        return instance.face;
    }

    public void setFace(EnumFacing face) {
        this.face = face;
    }

    private static void setFace(BlockClickEvent w, EnumFacing enumFacing) {
        w.face = enumFacing;
    }

    public EnumFacing getFace() {
        return (this.face);
    }

    public void setPos(BlockPos pos) {
        this.pos = pos;
    }
}

