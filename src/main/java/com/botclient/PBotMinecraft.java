package com.botclient;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.ClientConnection;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.util.concurrent.CompletableFuture;
import java.util.function.BooleanSupplier;

public class PBotMinecraft {
    public final PBot pbot;
    public BotKeyState gameSettings;
    public ClientPlayerWrapper player;
    public ClientWorld world;
    public PBotPlayerController playerController;
    public PBotNetHandlerPlayClient connection;
    private final MinecraftClient mc;

    public PBotMinecraft(PBot pbot) {
        this.pbot = pbot;
        this.mc = MinecraftClient.getInstance();
        this.gameSettings = new BotKeyState();
        this.playerController = new PBotPlayerController(pbot);
    }

    public MinecraftClient getMC() {
        return this.mc;
    }

    public void setWorld(ClientWorld world) {
        this.world = world;
    }

    public ClientWorld getWorld() {
        return this.world;
    }

    public void setPlayer(ClientPlayerWrapper player) {
        this.player = player;
    }

    public ClientPlayerWrapper getPlayer() {
        return this.player;
    }

    public void setConnection(PBotNetHandlerPlayClient connection) {
        this.connection = connection;
    }

    public PBotNetHandlerPlayClient getConnection() {
        return this.connection;
    }

    public PBotPlayerController getPlayerController() {
        return this.playerController;
    }

    public void runTick() {
        if (this.world != null) {
            this.world.tick();
        }
        if (this.player != null) {
            this.player.tick();
        }
        if (this.playerController != null) {
            this.playerController.update();
        }
    }

    public boolean isSingleplayer() {
        return false;
    }

    public Profiler getProfiler() {
        return this.mc.getProfiler();
    }

    public int getFPS() {
        return this.mc.getCurrentFps();
    }

    public boolean isInGame() {
        return this.world != null && this.player != null;
    }

    public static class ClientPlayerWrapper {
        private final net.minecraft.client.network.ClientPlayerEntity entity;
        
        public ClientPlayerWrapper(net.minecraft.client.network.ClientPlayerEntity entity) {
            this.entity = entity;
        }

        public void tick() {
            // Tick the player entity
        }

        public net.minecraft.client.network.ClientPlayerEntity getEntity() {
            return this.entity;
        }
    }
}
