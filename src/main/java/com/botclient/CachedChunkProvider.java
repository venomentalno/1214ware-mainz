/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.ClientChunkManager
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package com.botclient;

import net.minecraft.client.world.ClientChunkManager;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class CachedChunkProvider {
    public static ClientChunkManager cachedChunks;

    public static void createChunkProvider(World world) {
        if ((cachedChunks) == null) {
            cachedChunks = new ClientChunkManager(world);
        }
    }

    @NotNull
    public static ClientChunkManager getChunkProvider() {
        return (cachedChunks);
    }
}

