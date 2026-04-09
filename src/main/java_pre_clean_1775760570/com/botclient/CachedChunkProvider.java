/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.ChunkProviderClient
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package com.botclient;

import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class CachedChunkProvider {
    public static ChunkProviderClient cachedChunks;

    public static void createChunkProvider(World world) {
        if ((cachedChunks) == null) {
            cachedChunks = new ChunkProviderClient(world);
        }
    }

    @NotNull
    public static ChunkProviderClient getChunkProvider() {
        return (cachedChunks);
    }
}

