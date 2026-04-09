package com.botclient;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class BlockRenderEvent implements Event {
    public final BlockState state;
    public final BufferBuilder bufferBuilder;
    public final BlockPos pos;
    public final BlockView access;
    
    public BlockRenderEvent(BlockState state, BlockPos pos, BlockView access, BufferBuilder bufferBuilder) {
        this.state = state;
        this.pos = pos;
        this.access = access;
        this.bufferBuilder = bufferBuilder;
    }
    
    public BlockPos getPos() { return pos; }
    public BlockState getState() { return state; }
    public BufferBuilder getBufferBuilder() { return bufferBuilder; }
    public BlockView getAccess() { return access; }
}
