/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  neo.deobf.Event
 *  net.minecraft.block.Block
 */
package com.botclient;

import com.botclient.CancellableEvent;
import com.botclient.Event;
import net.minecraft.block.Block;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class BlockEvent
extends CancellableEvent
implements Event {
    public Block block;
    public boolean canceled;

    public void setBlock(Block block) {
        this.block = block;
    }

    private static void setBlock(BlockEvent y, Block block) {
        y.block = block;
    }

    public BlockEvent(Block block) {
        this.block = block;
    }

    public boolean isCanceled() {
        return (this.canceled);
    }

    public void setCanceled() {
        this.canceled = true;
    }

    public Block getBlock() {
        return (this.block);
    }

    private static void setCanceled(BlockEvent y, boolean value) {
        y.canceled = value;
    }

    private static Block getBlock(BlockEvent instance) {
        return instance.block;
    }
}

