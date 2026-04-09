package com.botclient;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameMode;

public class PBotPlayerController {
    private final PBot pbot;
    private GameMode currentGameMode = GameMode.SURVIVAL;
    private int blockBreakDelay = 0;

    public PBotPlayerController(PBot pbot) {
        this.pbot = pbot;
    }

    public void setGameMode(GameMode mode) {
        this.currentGameMode = mode;
        ClientPlayerEntity player = pbot.getPlayer();
        if (player != null) {
            PlayerAbilities abilities = player.getAbilities();
            abilities.creativeMode = mode == GameMode.CREATIVE;
            abilities.allowFlying = mode == GameMode.CREATIVE || mode == GameMode.SPECTATOR;
            abilities.flying = abilities.allowFlying && abilities.flying;
            abilities.invulnerable = mode == GameMode.SPECTATOR || mode == GameMode.CREATIVE;
            player.sendAbilitiesUpdate();
        }
    }

    public GameMode getGameMode() {
        return this.currentGameMode;
    }

    public boolean breakBlock(BlockPos pos) {
        ClientPlayerEntity player = pbot.getPlayer();
        ClientWorld world = pbot.getWorld();
        
        if (player == null || world == null) {
            return false;
        }

        if (blockBreakDelay > 0) {
            blockBreakDelay--;
            return false;
        }

        // Send block break action
        player.swingHand(net.minecraft.util.Hand.MAIN_HAND);
        blockBreakDelay = 5;
        return true;
    }

    public boolean processRightClickBlock(BlockPos pos, Direction direction, Vec3d hitVec) {
        ClientPlayerEntity player = pbot.getPlayer();
        ClientWorld world = pbot.getWorld();
        
        if (player == null || world == null) {
            return false;
        }

        BlockHitResult hitResult = new BlockHitResult(hitVec, direction, pos, false);
        player.interactionManager.interactBlock(player, net.minecraft.util.Hand.MAIN_HAND, hitResult);
        return true;
    }

    public boolean processRightClick() {
        ClientPlayerEntity player = pbot.getPlayer();
        ClientWorld world = pbot.getWorld();
        
        if (player == null || world == null) {
            return false;
        }

        HitResult hitResult = player.raycast(5.0, 1.0f, false);
        
        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
            Direction direction = ((BlockHitResult) hitResult).getSide();
            return processRightClickBlock(blockPos, direction, ((BlockHitResult) hitResult).getPos());
        }

        player.interactionManager.interactItem(player, net.minecraft.util.Hand.MAIN_HAND);
        return true;
    }

    public void update() {
        // Update controller state
    }

    public ScreenHandler currentScreenHandler() {
        ClientPlayerEntity player = pbot.getPlayer();
        return player != null ? player.currentScreenHandler : null;
    }

    public PlayerInventory getPlayerInventory() {
        ClientPlayerEntity player = pbot.getPlayer();
        return player != null ? player.getInventory() : null;
    }

    public ItemStack windowClick(int windowId, int slotId, int mouseButton, net.minecraft.screen.slot.SlotActionType actionType) {
        ClientPlayerEntity player = pbot.getPlayer();
        if (player == null) {
            return ItemStack.EMPTY;
        }

        ScreenHandler handler = player.currentScreenHandler;
        if (handler == null) {
            return ItemStack.EMPTY;
        }

        return handler.slotClick(slotId, mouseButton, actionType, player);
    }

    public void closeScreen() {
        ClientPlayerEntity player = pbot.getPlayer();
        if (player != null && player.currentScreenHandler != null) {
            player.closeHandledScreen();
        }
    }

    public boolean isSpectator() {
        return this.currentGameMode == GameMode.SPECTATOR;
    }

    public boolean isCreative() {
        return this.currentGameMode == GameMode.CREATIVE;
    }

    public boolean hasCreativeFlight() {
        ClientPlayerEntity player = pbot.getPlayer();
        return player != null && player.getAbilities().allowFlying;
    }
}
