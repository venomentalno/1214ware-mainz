package com.botclient;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import com.mojang.authlib.GameProfile;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.listener.ClientCommonPacketListener;

public class PBotNetHandlerPlayClient extends ClientPlayNetworkHandler {
    private final PBot pbot;
    private final ClientConnection netManager;
    private final GameProfile profile;

    public PBotNetHandlerPlayClient(PBot bot, ClientConnection connection, MinecraftClient client) {
        super(client, null, connection, null, false);
        this.pbot = bot;
        this.netManager = connection;
        this.profile = bot.getSession().getProfile();
        this.pbot.setPlayHandler(this);
    }

    public PBot getPbot() {
        return this.pbot;
    }

    public ClientConnection getConnection() {
        return this.netManager;
    }

    public GameProfile getProfile() {
        return this.profile;
    }

    // Override key packets for custom handling
    @Override
    public void onGameJoin(GameJoinS2CPacket packet) {
        super.onGameJoin(packet);
    }

    @Override
    public void onPlayerPositionLook(PlayerPositionLookS2CPacket packet) {
        super.onPlayerPositionLook(packet);
    }

    @Override
    public void onChatMessage(ChatMessageS2CPacket packet) {
        super.onChatMessage(packet);
    }

    @Override
    public void onPlayerList(PlayerListS2CPacket packet) {
        super.onPlayerList(packet);
    }

    @Override
    public void onEntitySpawn(AddEntityS2CPacket packet) {
        super.onEntitySpawn(packet);
    }

    @Override
    public void onChunkData(ChunkDataS2CPacket packet) {
        super.onChunkData(packet);
    }

    @Override
    public void onUnloadChunk(UnloadChunkS2CPacket packet) {
        super.onUnloadChunk(packet);
    }

    @Override
    public void onWorldBorder(WorldBorderS2CPacket packet) {
        super.onWorldBorder(packet);
    }

    @Override
    public void onKeepAlive(KeepAliveS2CPacket packet) {
        super.onKeepAlive(packet);
    }

    @Override
    public void onHealthUpdate(HealthUpdateS2CPacket packet) {
        super.onHealthUpdate(packet);
    }

    @Override
    public void onEntityVelocity(EntityVelocityUpdateS2CPacket packet) {
        super.onEntityVelocity(packet);
    }

    @Override
    public void onEntityDestroy(EntityRemoveS2CPacket packet) {
        super.onEntityDestroy(packet);
    }

    @Override
    public void onEntityEquipment(EntityEquipmentUpdateS2CPacket packet) {
        super.onEntityEquipment(packet);
    }

    @Override
    public void onEntityStatus(EntityStatusS2CPacket packet) {
        super.onEntityStatus(packet);
    }

    @Override
    public void onExplosion(ExplosionS2CPacket packet) {
        super.onExplosion(packet);
    }

    @Override
    public void onBlockUpdate(BlockUpdateS2CPacket packet) {
        super.onBlockUpdate(packet);
    }

    @Override
    public void onBlockEntityUpdate(BlockEntityUpdateS2CPacket packet) {
        super.onBlockEntityUpdate(packet);
    }

    @Override
    public void onOpenScreen(OpenScreenS2CPacket packet) {
        super.onOpenScreen(packet);
    }

    @Override
    public void onScreenHandlerSlotUpdate(ScreenHandlerSlotUpdateS2CPacket packet) {
        super.onScreenHandlerSlotUpdate(packet);
    }

    @Override
    public void onScreenHandlerProperty(ScreenHandlerPropertyUpdateS2CPacket packet) {
        super.onScreenHandlerProperty(packet);
    }

    @Override
    public void onCloseScreen(CloseScreenS2CPacket packet) {
        super.onCloseScreen(packet);
    }

    @Override
    public void onScoreboardDisplay(ScoreboardDisplayS2CPacket packet) {
        super.onScoreboardDisplay(packet);
    }

    @Override
    public void onScoreboardObjective(ScoreboardObjectiveUpdateS2CPacket packet) {
        super.onScoreboardObjective(packet);
    }

    @Override
    public void onScoreboardPlayerUpdate(ScoreboardPlayerUpdateS2CPacket packet) {
        super.onScoreboardPlayerUpdate(packet);
    }

    @Override
    public void onTeam(TeamS2CPacket packet) {
        super.onTeam(packet);
    }

    @Override
    public void onCustomPayload(CustomPayloadS2CPacket packet) {
        super.onCustomPayload(packet);
    }

    @Override
    public void onResourcePackSend(ResourcePackSendS2CPacket packet) {
        super.onResourcePackSend(packet);
    }

    @Override
    public void onBossBar(BossBarS2CPacket packet) {
        super.onBossBar(packet);
    }

    @Override
    public void onPlayerAbilitiesSet(PlayerAbilitiesSetS2CPacket packet) {
        super.onPlayerAbilitiesSet(packet);
    }

    @Override
    public void onEntityTrackerUpdate(EntityTrackerUpdateS2CPacket packet) {
        super.onEntityTrackerUpdate(packet);
    }

    @Override
    public void onPlayerRespawn(PlayerRespawnS2CPacket packet) {
        super.onPlayerRespawn(packet);
    }

    @Override
    public void onGameStateChange(GameStateChangeS2CPacket packet) {
        super.onGameStateChange(packet);
    }

    @Override
    public void onWorldTimeUpdate(WorldTimeUpdateS2CPacket packet) {
        super.onWorldTimeUpdate(packet);
    }

    @Override
    public void onParticle(ParticleS2CPacket packet) {
        super.onParticle(packet);
    }

    @Override
    public void onPlaySound(PlaySoundS2CPacket packet) {
        super.onPlaySound(packet);
    }

    @Override
    public void onMapData(MapDataS2CPacket packet) {
        super.onMapData(packet);
    }

    @Override
    public void onEntityAnimation(EntityAnimationS2CPacket packet) {
        super.onEntityAnimation(packet);
    }

    @Override
    public void onEntityAttributes(EntityAttributesS2CPacket packet) {
        super.onEntityAttributes(packet);
    }

    @Override
    public void onEntityEffect(EntityStatusEffectS2CPacket packet) {
        super.onEntityEffect(packet);
    }

    @Override
    public void onRemoveEntityStatusEffect(RemoveEntityStatusEffectS2CPacket packet) {
        super.onRemoveEntityStatusEffect(packet);
    }

    @Override
    public void onPlayerRemove(PlayerRemoveS2CPacket packet) {
        super.onPlayerRemove(packet);
    }

    @Override
    public void onOverlayMessage(OverlayMessageS2CPacket packet) {
        super.onOverlayMessage(packet);
    }

    @Override
    public void onSystemMessage(SystemMessageS2CPacket packet) {
        super.onSystemMessage(packet);
    }

    @Override
    public void onClearTitle(ClearTitleS2CPacket packet) {
        super.onClearTitle(packet);
    }

    @Override
    public void onTitle(TitleS2CPacket packet) {
        super.onTitle(packet);
    }

    @Override
    public void onSubtitle(SubtitleS2CPacket packet) {
        super.onSubtitle(packet);
    }

    @Override
    public void onLightUpdate(LightUpdateS2CPacket packet) {
        super.onLightUpdate(packet);
    }

    @Override
    public void onCombatEvent(CombatEventS2CPacket packet) {
        super.onCombatEvent(packet);
    }

    @Override
    public void onDeath(DeathMessageS2CPacket packet) {
        super.onDeath(packet);
    }

    @Override
    public void onCooldownUpdate(CooldownUpdateS2CPacket packet) {
        super.onCooldownUpdate(packet);
    }

    @Override
    public void onBlockBreakingProgress(BlockBreakingProgressS2CPacket packet) {
        super.onBlockBreakingProgress(packet);
    }

    @Override
    public void onEntityPassengersSet(EntityPassengersSetS2CPacket packet) {
        super.onEntityPassengersSet(packet);
    }

    @Override
    public void onAdvancementUpdate(AdvancementUpdateS2CPacket packet) {
        super.onAdvancementUpdate(packet);
    }

    @Override
    public void onCommandTree(CommandTreeS2CPacket packet) {
        super.onCommandTree(packet);
    }

    @Override
    public void onUnlockRecipes(UnlockRecipesS2CPacket packet) {
        super.onUnlockRecipes(packet);
    }

    @Override
    public void onRecipeBookData(RecipeBookDataS2CPacket packet) {
        super.onRecipeBookData(packet);
    }

    @Override
    public void onTagsUpdate(TagsUpdateS2CPacket packet) {
        super.onTagsUpdate(packet);
    }

    @Override
    public void onStatistics(StatisticsUpdateS2CPacket packet) {
        super.onStatistics(packet);
    }

    @Override
    public void onSetTradeOffers(SetTradeOffersS2CPacket packet) {
        super.onSetTradeOffers(packet);
    }

    @Override
    public void onNbtQueryResponse(NbtQueryResponseS2CPacket packet) {
        super.onNbtQueryResponse(packet);
    }

    @Override
    public void onPlayerActionResponse(PlayerActionResponseS2CPacket packet) {
        super.onPlayerActionResponse(packet);
    }

    @Override
    public void onHurtAnimation(HurtAnimationS2CPacket packet) {
        super.onHurtAnimation(packet);
    }

    @Override
    public void onLookAt(LookAtS2CPacket packet) {
        super.onLookAt(packet);
    }

    @Override
    public void onRotateHead(RotateHeadS2CPacket packet) {
        super.onRotateHead(packet);
    }

    @Override
    public void onCenterChunk(CenterChunkS2CPacket packet) {
        super.onCenterChunk(packet);
    }

    @Override
    public void onCollectItem(ItemPickupAnimationS2CPacket packet) {
        super.onCollectItem(packet);
    }

    @Override
    public void onDamageTilt(DamageTiltS2CPacket packet) {
        super.onDamageTilt(packet);
    }

    @Override
    public void onEndCombat(EndCombatS2CPacket packet) {
        super.onEndCombat(packet);
    }

    @Override
    public void onEnterCombat(EnterCombatS2CPacket packet) {
        super.onEnterCombat(packet);
    }

    @Override
    public void onEntityPositionSync(EntityPositionSyncS2CPacket packet) {
        super.onEntityPositionSync(packet);
    }

    @Override
    public void onGameMessage(GameMessageS2CPacket packet) {
        super.onGameMessage(packet);
    }

    @Override
    public void onInventoryChanged(InventoryChangedS2CPacket packet) {
        super.onInventoryChanged(packet);
    }

    @Override
    public void onLightning(LightningStrikeS2CPacket packet) {
        super.onLightning(packet);
    }

    @Override
    public void onMouseClickResponse(MouseClickResponseS2CPacket packet) {
        super.onMouseClickResponse(packet);
    }

    @Override
    public void onMoveRelative(MoveRelativeS2CPacket packet) {
        super.onMoveRelative(packet);
    }

    @Override
    public void onMoveAbsolute(MoveAbsoluteS2CPacket packet) {
        super.onMoveAbsolute(packet);
    }

    @Override
    public void onOpenWrittenBook(OpenWrittenBookS2CPacket packet) {
        super.onOpenWrittenBook(packet);
    }

    @Override
    public void onPlayerInfoUpdate(PlayerInfoUpdateS2CPacket packet) {
        super.onPlayerInfoUpdate(packet);
    }

    @Override
    public void onPlayerLookAt(PlayerLookAtS2CPacket packet) {
        super.onPlayerLookAt(packet);
    }

    @Override
    public void onRemoveMessage(RemoveMessageS2CPacket packet) {
        super.onRemoveMessage(packet);
    }

    @Override
    public void onRemoveResourcePack(RemoveResourcePackS2CPacket packet) {
        super.onRemoveResourcePack(packet);
    }

    @Override
    public void onResetTitle(ResetTitleS2CPacket packet) {
        super.onResetTitle(packet);
    }

    @Override
    public void onSelectAdvancementTab(SelectAdvancementTabS2CPacket packet) {
        super.onSelectAdvancementTab(packet);
    }

    @Override
    public void onServerMetadata(ServerMetadataS2CPacket packet) {
        super.onServerMetadata(packet);
    }

    @Override
    public void onSetCompression(SetCompressionS2CPacket packet) {
        super.onSetCompression(packet);
    }

    @Override
    public void onSetDefaultSpawnPosition(SetDefaultSpawnPositionS2CPacket packet) {
        super.onSetDefaultSpawnPosition(packet);
    }

    @Override
    public void onSetRenderDistance(SetRenderDistanceS2CPacket packet) {
        super.onSetRenderDistance(packet);
    }

    @Override
    public void onSetTitleAnimationTimes(SetTitleAnimationTimesS2CPacket packet) {
        super.onSetTitleAnimationTimes(packet);
    }

    @Override
    public void onSimulationDistanceSet(SimulationDistanceSetS2CPacket packet) {
        super.onSimulationDistanceSet(packet);
    }

    @Override
    public void onSoundPlay(SoundPlayS2CPacket packet) {
        super.onPlaySound(packet);
    }

    @Override
    public void onStopSound(StopSoundS2CPacket packet) {
        super.onStopSound(packet);
    }

    @Override
    public void onTeleportConfirm(TeleportConfirmS2CPacket packet) {
        super.onTeleportConfirm(packet);
    }

    @Override
    public void onUnloadedChunks(UnloadedChunksS2CPacket packet) {
        super.onUnloadedChunks(packet);
    }

    @Override
    public void onVehicleMove(VehicleMoveS2CPacket packet) {
        super.onVehicleMove(packet);
    }

    @Override
    public void onWorldBorderInitialize(WorldBorderInitializeS2CPacket packet) {
        super.onWorldBorderInitialize(packet);
    }

    @Override
    public void onWorldBorderInterpolateSize(WorldBorderInterpolateSizeS2CPacket packet) {
        super.onWorldBorderInterpolateSize(packet);
    }

    @Override
    public void onWorldBorderMove(WorldBorderMoveS2CPacket packet) {
        super.onWorldBorderMove(packet);
    }

    @Override
    public void onWorldBorderSize(WorldBorderSizeS2CPacket packet) {
        super.onWorldBorderSize(packet);
    }

    @Override
    public void onWorldBorderWarningTime(WorldBorderWarningTimeS2CPacket packet) {
        super.onWorldBorderWarningTime(packet);
    }

    @Override
    public void onWorldBorderWarningBlocks(WorldBorderWarningBlocksS2CPacket packet) {
        super.onWorldBorderWarningBlocks(packet);
    }

    @Override
    public void onWorldChunkLoad(WorldChunkLoadS2CPacket packet) {
        super.onWorldChunkLoad(packet);
    }

    @Override
    public void onWorldEvent(WorldEventS2CPacket packet) {
        super.onWorldEvent(packet);
    }

    @Override
    public void onWorldParticles(WorldParticlesS2CPacket packet) {
        super.onWorldParticles(packet);
    }

    @Override
    public void onWriteBook(WriteBookS2CPacket packet) {
        super.onWriteBook(packet);
    }
}
