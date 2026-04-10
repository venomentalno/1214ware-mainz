/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 */
package neo.deobf;

import neo.deobf.CancellableEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class BlockLiquidCollisionEvent
extends CancellableEvent {
    public final BlockPos pos;
    public AxisAlignedBB collision;
    public final BlockLiquid blockLiquid;

    public AxisAlignedBB getCollision() {
        return (this.collision);
    }

    public BlockPos getPos() {
        return (this.pos);
    }

    private static void setCollision(BlockLiquidCollisionEvent b, AxisAlignedBB axisAlignedBB) {
        b.collision = axisAlignedBB;
    }

    public BlockLiquid getBlock() {
        return (this.blockLiquid);
    }

    public BlockLiquidCollisionEvent(BlockLiquid blockLiquid, BlockPos pos) {
        this.blockLiquid = blockLiquid;
        this.pos = pos;
        this.collision = Block.NULL_AABB;
    }

    private static AxisAlignedBB getCollision(BlockLiquidCollisionEvent instance) {
        return instance.collision;
    }

    private static BlockPos getPos(BlockLiquidCollisionEvent instance) {
        return instance.pos;
    }

    public void setCollision(AxisAlignedBB collision) {
        this.collision = collision;
    }
}

