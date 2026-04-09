/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  net.minecraft.client.renderer.chunk.RenderChunk
 */
package com.botclient;

import com.botclient.CancellableEvent;
import net.minecraft.client.render.chunk.RenderChunk;

public class RenderChunkEvent
extends CancellableEvent {
    public RenderChunk renderChunk;

    public RenderChunkEvent(RenderChunk renderChunk) {
        this.renderChunk = renderChunk;
    }

    private static RenderChunk getRenderChunk(RenderChunkEvent instance) {
        return instance.renderChunk;
    }

    private static void setRenderChunk(RenderChunkEvent s, RenderChunk renderChunk) {
        s.renderChunk = renderChunk;
    }

    public void setRenderChunk(RenderChunk renderChunk) {
        this.renderChunk = renderChunk;
    }

    public RenderChunk getRenderChunk() {
        return (this.renderChunk);
    }
}

