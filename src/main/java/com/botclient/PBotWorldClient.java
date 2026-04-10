/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Sets
 *  javax.annotation.Nullable
 *  neo.deobf.BooleanSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.PBotNetHandlerPlayClient
 *  neo.deobf.BotDebugModule
 *  neo.deobf.BotSettingsModule
 *  neo.deobf.ChatUtils
 *  neo.deobf.CachedChunkProvider
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.multiplayer.ChunkProviderClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.profiler.Profiler
 *  net.minecraft.scoreboard.Scoreboard
 *  net.minecraft.util.IntHashMap
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldSettings
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraft.world.chunk.IChunkProvider
 *  net.minecraft.world.storage.ISaveHandler
 *  net.minecraft.world.storage.SaveDataMemoryStorage
 *  net.minecraft.world.storage.SaveHandlerMP
 *  net.minecraft.world.storage.WorldInfo
 *  org.jetbrains.annotations.NotNull
 */
package neo.deobf;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import neo.deobf.BooleanSetting;
import neo.deobf.NumberSetting;
import neo.deobf.PBot;
import neo.deobf.PBotPlayer;
import neo.deobf.PBotNetHandlerPlayClient;
import neo.deobf.BotDebugModule;
import neo.deobf.BotSettingsModule;
import neo.deobf.ChatUtils;
import neo.deobf.CachedChunkProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.DimensionType;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveDataMemoryStorage;
import net.minecraft.world.storage.SaveHandlerMP;
import net.minecraft.world.storage.WorldInfo;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PBotWorldClient
extends World {
    public final Set<Entity> entitySpawnQueue;
    public static ChunkProviderClient clientChunkProvider;
    public final Set<Entity> entityList = Sets.newHashSet();
    public final PBotNetHandlerPlayClient connection;
    public final PBot pbot;

    public void doPreChunk(int chunkX, int chunkZ, boolean loadChunk) {
        if (loadChunk) {
            (clientChunkProvider).loadChunk(chunkX, chunkZ);
        } else {
            (clientChunkProvider).unloadChunk(chunkX, chunkZ);
            this.markBlockRangeForRenderUpdate(chunkX * (16), 0, chunkZ * (16), chunkX * (16) + (15), 256, chunkZ * (16) + (15));
        }
    }

    public PBotWorldClient(PBot bot, PBotNetHandlerPlayClient netHandler, WorldSettings settings, int dimension, EnumDifficulty difficulty, Profiler profilerIn) {
        super((ISaveHandler)new SaveHandlerMP(), new WorldInfo(settings, "MpServer"), DimensionType.getById((int)dimension).createDimension(), profilerIn, true);
        this.entitySpawnQueue = Sets.newHashSet();
        this.pbot = bot;
        this.pbot.worldId += 1;
        this.connection = netHandler;
        this.getWorldInfo().setDifficulty(difficulty);
        this.setSpawnPoint(new BlockPos(8, 64, 8));
        this.provider.setWorld((World)this);
        this.chunkProvider = this.createChunkProvider();
        this.mapStorage = new SaveDataMemoryStorage();
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
    }

    public void removeAllEntities() {
        (this.loadedEntityList).removeAll((this.unloadedEntityList));
        for (Entity entity : (this.unloadedEntityList)) {
            int j = (entity.chunkCoordX);
            int k = (entity.chunkCoordZ);
            if (!(entity.addedToChunk) || !this.isChunkLoaded(j, k, true)) continue;
            this.getChunk(j, k).removeEntity(entity);
        }
        for (Entity entity : (this.unloadedEntityList)) {
            this.onEntityRemoved(entity);
        }
        (this.unloadedEntityList).clear();
        for (int j1 = 0; j1 < (this.loadedEntityList).size(); ++j1) {
            Entity entity1 = (Entity)(this.loadedEntityList).get(j1);
            Entity entity2 = entity1.getRidingEntity();
            if (entity2 != null) {
                if (!(entity2.isDead) && entity2.isPassenger(entity1)) continue;
                entity1.dismountRidingEntity();
            }
            if (!(entity1.isDead)) continue;
            int k1 = (entity1.chunkCoordX);
            int l = (entity1.chunkCoordZ);
            if ((entity1.addedToChunk) && this.isChunkLoaded(k1, l, true)) {
                this.getChunk(k1, l).removeEntity(entity1);
            }
            (this.loadedEntityList).remove(j1--);
            this.onEntityRemoved(entity1);
        }
    }

    public List<Entity> getEntitiesInAABBexcluding(@Nullable Entity entityIn, AxisAlignedBB boundingBox, @Nullable Predicate<? super Entity> predicate) {
        ArrayList list = Lists.newArrayList();
        int j2 = MathHelper.floor((double)(((boundingBox.minX) - 2.0) / 16.0));
        int k2 = MathHelper.floor((double)(((boundingBox.maxX) + 2.0) / 16.0));
        int l2 = MathHelper.floor((double)(((boundingBox.minZ) - 2.0) / 16.0));
        int i3 = MathHelper.floor((double)(((boundingBox.maxZ) + 2.0) / 16.0));
        for (int j3 = j2; j3 <= k2; ++j3) {
            for (int k3 = l2; k3 <= i3; ++k3) {
                if (!this.isChunkLoaded(j3, k3, true)) continue;
                try {
                    this.getChunk(j3, k3).getEntitiesWithinAABBForEntity(entityIn, boundingBox, (List)list, predicate);
                    continue;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        return list;
    }

    @NotNull
    public ChunkProviderClient getChunkProvider() {
        return (ChunkProviderClient)super.getChunkProvider();
    }

    @NotNull
    public Chunk getChunk(int chunkX, int chunkZ) {
        Chunk chunk = (clientChunkProvider).provideChunk(chunkX, chunkZ);
        chunk.setWorld((World)(this.pbot).getWorld());
        chunk.resetRelightChecks();
        return chunk;
    }

    protected boolean isChunkLoaded(int x, int z, boolean allowEmpty) {
        return (allowEmpty || !this.getChunkProvider().provideChunk(x, z).isEmpty() ? 1 : 0) != 0;
    }

    private static NumberSetting getCacheAfter() {
        return BotSettingsModule.cacheAfter;
    }

    @NotNull
    protected IChunkProvider createChunkProvider() {
        CachedChunkProvider.createChunkProvider((World)this);
        if ((float)(PBotWorldClient.getPbot4(this).worldId) > (PBotWorldClient.getCacheAfter2().value) && (PBotWorldClient.getChunkCache().value)) {
            ChatUtils.formatMsg((String)("??? &d&l" + (this.pbot).getNickname() + " &f&l??????????? ???????????? ???."));
        }
        if ((clientChunkProvider) == null) {
            clientChunkProvider = (float)(PBotWorldClient.getPbot5(this).worldId) > (PBotWorldClient.getCacheAfter().value) ? CachedChunkProvider.getChunkProvider() : new ChunkProviderClient((World)this);
        }
        return (clientChunkProvider);
    }

    public boolean spawnEntity(@NotNull Entity entityIn) {
        boolean flag = super.spawnEntity(entityIn);
        (this.entityList).add(entityIn);
        if (!flag) {
            (this.entitySpawnQueue).add(entityIn);
        }
        return flag;
    }

    public void removeEntityFromWorld(int entityID) {
        Entity entity = (Entity)(this.entitiesById).removeObject(entityID);
        if (entity != null) {
            (this.entityList).remove(entity);
            this.removeEntity(entity);
        }
    }

    public void sendPacketToServer(@NotNull Packet packetIn) {
        (this.connection).sendPacket(packetIn);
    }

    private static BooleanSetting getChunkCache() {
        return BotDebugModule.chunkCache;
    }

    public void setWorldScoreboard(Scoreboard scoreboardIn) {
        this.worldScoreboard = scoreboardIn;
    }

    public void removeEntity(@NotNull Entity entityIn) {
        super.removeEntity(entityIn);
        (this.entityList).remove(entityIn);
    }

    protected void updateWeather() {
    }

    public void invalidateRegionAndSetBlock(BlockPos pos, IBlockState state) {
        super.setBlockState(pos, state, 3);
    }

    private static PBot getPbot4(PBotWorldClient instance) {
        return instance.pbot;
    }

    public void tick() {
        super.tick();
        this.setTotalWorldTime(this.getTotalWorldTime() + 1L);
        if (this.getGameRules().getBoolean("doDaylightCycle")) {
            this.setWorldTime(this.getWorldTime() + 1L);
        }
        for (int i = 0; i < (10) && !(this.entitySpawnQueue).isEmpty(); ++i) {
            Entity entity = (Entity)(this.entitySpawnQueue).iterator().next();
            (this.entitySpawnQueue).remove(entity);
            if ((this.loadedEntityList).contains(entity)) continue;
            this.spawnEntity(entity);
        }
        this.updateBlocks();
    }

    @Nullable
    public Entity getEntityByID(int id) {
        if ((this.pbot).isOnline() && (PBotWorldClient.getPbot6(this).player).getEntityId() == id) {
            return (PBotWorldClient.getPbot7(this).player);
        }
        return super.getEntityByID(id);
    }

    public void sendQuittingDisconnectingPacket() {
        (this.connection).getNetworkManager().closeChannel((ITextComponent)new TextComponentString("Quitting"));
    }

    private static PBot getPbot5(PBotWorldClient instance) {
        return instance.pbot;
    }

    public void setWorldTime(long time) {
        if (time < GenericCancelableEventB) {
            time = -time;
            this.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
        } else {
            this.getGameRules().setOrCreateGameRule("doDaylightCycle", "true");
        }
        super.setWorldTime(time);
    }

    public void addEntityToWorld(int entityID, Entity entityToSpawn) {
        Entity entity = this.getEntityByID(entityID);
        if (entity != null) {
            this.removeEntity(entity);
        }
        (this.entityList).add(entityToSpawn);
        entityToSpawn.setEntityId(entityID);
        if (!this.spawnEntity(entityToSpawn)) {
            (this.entitySpawnQueue).add(entityToSpawn);
        }
        (this.entitiesById).addKey(entityID, (Object)entityToSpawn);
    }

    private static PBot getPbot6(PBotWorldClient instance) {
        return instance.pbot;
    }

    protected void onEntityAdded(@NotNull Entity entityIn) {
        super.onEntityAdded(entityIn);
        (this.entitySpawnQueue).remove(entityIn);
    }

    private static NumberSetting getCacheAfter2() {
        return BotSettingsModule.cacheAfter;
    }

    private static void setWorldScoreboard(PBotWorldClient instance, Scoreboard scoreboard) {
        instance.worldScoreboard = scoreboard;
    }

    protected void onEntityRemoved(@NotNull Entity entityIn) {
        super.onEntityRemoved(entityIn);
        if ((this.entityList).contains(entityIn)) {
            if (entityIn.isEntityAlive()) {
                (this.entitySpawnQueue).add(entityIn);
            } else {
                (this.entityList).remove(entityIn);
            }
        }
    }

    private static PBot getPbot7(PBotWorldClient instance) {
        return instance.pbot;
    }
}

