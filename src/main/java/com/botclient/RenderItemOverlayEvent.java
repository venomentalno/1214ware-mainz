/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  net.minecraft.item.ItemStack
 */
package neo.deobf;

import neo.deobf.CancellableEvent;
import net.minecraft.item.ItemStack;

public class RenderItemOverlayEvent
extends CancellableEvent {
    public final int x;
    public final int y;
    public final ItemStack stack;

    public ItemStack getStack() {
        return (this.stack);
    }

    private static int getY(RenderItemOverlayEvent instance) {
        return instance.y;
    }

    public int getX() {
        return (this.x);
    }

    public int getY() {
        return (this.y);
    }

    public RenderItemOverlayEvent(ItemStack stack, int x, int y) {
        this.stack = stack;
        this.x = x;
        this.y = y;
    }

    private static ItemStack getStack(RenderItemOverlayEvent instance) {
        return instance.stack;
    }

    private static int getX(RenderItemOverlayEvent instance) {
        return instance.x;
    }
}

