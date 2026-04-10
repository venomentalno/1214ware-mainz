/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 */
package neo.deobf;

import neo.deobf.Event;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockRenderEvent
implements Event {
    public final IBlockState state;
    public final BufferBuilder bufferBuilder;
    public final BlockPos pos;
    public final IBlockAccess access;

    public BlockPos getPos() {
        return (this.pos);
    }

    private static IBlockAccess getAccess(BlockRenderEvent instance) {
        return instance.access;
    }

    private static BufferBuilder getBufferBuilder(BlockRenderEvent instance) {
        return instance.bufferBuilder;
    }

    private static BlockPos getPos(BlockRenderEvent instance) {
        return instance.pos;
    }

    public IBlockState getState() {
        return (this.state);
    }

    public BufferBuilder getBufferBuilder() {
        return (this.bufferBuilder);
    }

    public BlockRenderEvent(IBlockState state, BlockPos pos, IBlockAccess access, BufferBuilder bufferBuilder) {
        this.state = state;
        this.pos = pos;
        this.access = access;
        this.bufferBuilder = bufferBuilder;
    }

    private static IBlockState getState(BlockRenderEvent instance) {
        return instance.state;
    }

    public IBlockAccess getAccess() {
        return (this.access);
    }
}


