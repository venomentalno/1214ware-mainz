package com.botclient;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.dimension.DimensionType;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

public class PBotWorldClient extends ClientWorld {
    private final PBot pbot;
    private final Set<Entity> entitySpawnQueue = new HashSet<>();
    
    public PBotWorldClient(PBot pbot, ClientWorld.Properties properties, RegistryKey<World> dimension, 
                          DimensionType dimensionType, int viewDistance, int simulationDistance,
                          BooleanSupplier profiler) {
        super(pbot.getMinecraft().getMC(), properties, dimension, dimensionType, viewDistance, 
              simulationDistance, profiler, null, null);
        this.pbot = pbot;
    }
    
    @Override
    public void tick() {
        super.tick();
        
        // Process entity spawn queue
        for (Entity entity : new ArrayList<>(entitySpawnQueue)) {
            if (entity.getWorld() == null) {
                addEntity(entity);
            }
            entitySpawnQueue.remove(entity);
        }
    }
    
    @Override
    public void addEntity(Entity entity) {
        if (entity.getWorld() == null) {
            entity.setWorld(this);
        }
        super.addEntity(entity);
    }
    
    public void queueEntitySpawn(Entity entity) {
        entitySpawnQueue.add(entity);
    }
    
    @Override
    public PlayerEntity getPlayerByUuid(UUID uuid) {
        return super.getPlayerByUuid(uuid);
    }
    
    @Override
    public Chunk getChunk(int x, int z) {
        return super.getChunk(x, z);
    }
    
    @Override
    public FluidState getFluidState(BlockPos pos) {
        return super.getFluidState(pos);
    }
    
    @Override
    public boolean setBlockState(BlockPos pos, net.minecraft.block.BlockState state, int flags) {
        return super.setBlockState(pos, state, flags);
    }
    
    @Override
    public net.minecraft.block.BlockState getBlockState(BlockPos pos) {
        return super.getBlockState(pos);
    }
    
    @Override
    public List<? extends PlayerEntity> getPlayers() {
        return super.getPlayers();
    }
    
    @Override
    public Entity getEntityById(int id) {
        return super.getEntityById(id);
    }
    
    @Override
    public <T extends Entity> Collection<T> getEntitiesByType(Predicate<? super T> predicate) {
        return super.getEntitiesByType(predicate);
    }
    
    @Override
    public Profiler getProfiler() {
        return super.getProfiler();
    }
    
    @Override
    public long getTime() {
        return super.getTime();
    }
    
    @Override
    public long getTimeOfDay() {
        return super.getTimeOfDay();
    }
    
    @Override
    public float getSkyAngle(float tickDelta) {
        return super.getSkyAngle(tickDelta);
    }
    
    @Override
    public int getSkyDarknessHeight(float tickDelta) {
        return super.getSkyDarknessHeight(tickDelta);
    }
    
    @Override
    public Vec3d getSkyColor(Vec3d cameraPos, float tickDelta) {
        return super.getSkyColor(cameraPos, tickDelta);
    }
    
    @Override
    public Vec3d getCloudColor(float tickDelta) {
        return super.getCloudColor(tickDelta);
    }
    
    @Override
    public int getAmbientDarkness() {
        return super.getAmbientDarkness();
    }
    
    @Override
    public boolean isDay() {
        return super.isDay();
    }
    
    @Override
    public boolean isRaining() {
        return super.isRaining();
    }
    
    @Override
    public boolean isThundering() {
        return super.isThundering();
    }
    
    @Override
    public float getRainGradient(float tickDelta) {
        return super.getRainGradient(tickDelta);
    }
    
    @Override
    public float getThunderGradient(float tickDelta) {
        return super.getThunderGradient(tickDelta);
    }
}
