package neo.deobf;

import net.minecraft.client.multiplayer.ClientChunkCache;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CachedChunkProvider {
    public static ClientChunkCache cachedChunks;

    public static void createChunkProvider(Level world) {
        if (cachedChunks == null) {
            // ClientChunkCache constructor takes the client level and a view distance.
            // We default to 8 chunks; this matches typical bot usage.
            cachedChunks = new ClientChunkCache((net.minecraft.client.multiplayer.ClientLevel) world, 8);
        }
    }

    @NotNull
    public static ClientChunkCache getChunkProvider() {
        return cachedChunks;
    }
}
