/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  com.mojang.authlib.GameProfile
 *  io.netty.buffer.Unpooled
 *  neo.deobf.TextSetting
 *  neo.deobf.Client
 *  neo.deobf.PBotManager
 *  neo.deobf.ModuleManager
 *  neo.deobf.ActionRecorderModule
 *  neo.deobf.AutoRegisterModule
 *  neo.deobf.BooleanSetting
 *  neo.deobf.ModeSetting
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.PlayerListActionSwitchMap
 *  neo.deobf.PBotNetworkManager
 *  neo.deobf.PBotPlayerController
 *  neo.deobf.ActionReplayRunner
 *  neo.deobf.PBotWorldClient
 *  neo.deobf.BotDebugModule
 *  neo.deobf.BotSettingsModule
 *  neo.deobf.WebSolverModule
 *  neo.deobf.ScriptManager
 *  neo.deobf.SeleniumJob
 *  neo.deobf.SeleniumManager
 *  neo.deobf.ChatUtils
 *  net.minecraft.block.Block
 *  net.minecraft.client.ClientBrandRetriever
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.client.player.inventory.ContainerLocalMenu
 *  net.minecraft.client.player.inventory.LocalBlockIntercommunication
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAreaEffectCloud
 *  net.minecraft.entity.EntityLeashKnot
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EntityTracker
 *  net.minecraft.entity.IMerchant
 *  net.minecraft.entity.NpcMerchant
 *  net.minecraft.entity.ai.attributes.AbstractAttributeMap
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.ai.attributes.RangedAttribute
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityEnderEye
 *  net.minecraft.entity.item.EntityEnderPearl
 *  net.minecraft.entity.item.EntityExpBottle
 *  net.minecraft.entity.item.EntityFallingBlock
 *  net.minecraft.entity.item.EntityFireworkRocket
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityItemFrame
 *  net.minecraft.entity.item.EntityMinecart
 *  net.minecraft.entity.item.EntityMinecart$Type
 *  net.minecraft.entity.item.EntityPainting
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityDragonFireball
 *  net.minecraft.entity.projectile.EntityEgg
 *  net.minecraft.entity.projectile.EntityEvokerFangs
 *  net.minecraft.entity.projectile.EntityFishHook
 *  net.minecraft.entity.projectile.EntityLargeFireball
 *  net.minecraft.entity.projectile.EntityLlamaSpit
 *  net.minecraft.entity.projectile.EntityPotion
 *  net.minecraft.entity.projectile.EntityShulkerBullet
 *  net.minecraft.entity.projectile.EntitySmallFireball
 *  net.minecraft.entity.projectile.EntitySnowball
 *  net.minecraft.entity.projectile.EntitySpectralArrow
 *  net.minecraft.entity.projectile.EntityTippedArrow
 *  net.minecraft.entity.projectile.EntityWitherSkull
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.ContainerHorseChest
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryBasic
 *  net.minecraft.item.ItemMap
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.network.INetHandler
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.PacketThreadUtil
 *  net.minecraft.network.play.INetHandlerPlayClient
 *  net.minecraft.network.play.client.CPacketClientStatus
 *  net.minecraft.network.play.client.CPacketClientStatus$State
 *  net.minecraft.network.play.client.CPacketConfirmTeleport
 *  net.minecraft.network.play.client.CPacketConfirmTransaction
 *  net.minecraft.network.play.client.CPacketCustomPayload
 *  net.minecraft.network.play.client.CPacketKeepAlive
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketResourcePackStatus
 *  net.minecraft.network.play.client.CPacketResourcePackStatus$Action
 *  net.minecraft.network.play.client.CPacketVehicleMove
 *  net.minecraft.network.play.server.SPacketAdvancementInfo
 *  net.minecraft.network.play.server.SPacketAnimation
 *  net.minecraft.network.play.server.SPacketBlockAction
 *  net.minecraft.network.play.server.SPacketBlockBreakAnim
 *  net.minecraft.network.play.server.SPacketBlockChange
 *  net.minecraft.network.play.server.SPacketCamera
 *  net.minecraft.network.play.server.SPacketChangeGameState
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.network.play.server.SPacketChunkData
 *  net.minecraft.network.play.server.SPacketCloseWindow
 *  net.minecraft.network.play.server.SPacketCollectItem
 *  net.minecraft.network.play.server.SPacketCombatEvent
 *  net.minecraft.network.play.server.SPacketConfirmTransaction
 *  net.minecraft.network.play.server.SPacketCooldown
 *  net.minecraft.network.play.server.SPacketCustomPayload
 *  net.minecraft.network.play.server.SPacketCustomSound
 *  net.minecraft.network.play.server.SPacketDestroyEntities
 *  net.minecraft.network.play.server.SPacketDisconnect
 *  net.minecraft.network.play.server.SPacketDisplayObjective
 *  net.minecraft.network.play.server.SPacketEffect
 *  net.minecraft.network.play.server.SPacketEntity
 *  net.minecraft.network.play.server.SPacketEntityAttach
 *  net.minecraft.network.play.server.SPacketEntityEffect
 *  net.minecraft.network.play.server.SPacketEntityEquipment
 *  net.minecraft.network.play.server.SPacketEntityHeadLook
 *  net.minecraft.network.play.server.SPacketEntityMetadata
 *  net.minecraft.network.play.server.SPacketEntityProperties
 *  net.minecraft.network.play.server.SPacketEntityProperties$Snapshot
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.network.play.server.SPacketEntityTeleport
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.network.play.server.SPacketExplosion
 *  net.minecraft.network.play.server.SPacketHeldItemChange
 *  net.minecraft.network.play.server.SPacketJoinGame
 *  net.minecraft.network.play.server.SPacketKeepAlive
 *  net.minecraft.network.play.server.SPacketMaps
 *  net.minecraft.network.play.server.SPacketMoveVehicle
 *  net.minecraft.network.play.server.SPacketMultiBlockChange
 *  net.minecraft.network.play.server.SPacketMultiBlockChange$BlockUpdateData
 *  net.minecraft.network.play.server.SPacketOpenWindow
 *  net.minecraft.network.play.server.SPacketParticles
 *  net.minecraft.network.play.server.SPacketPlaceGhostRecipe
 *  net.minecraft.network.play.server.SPacketPlayerAbilities
 *  net.minecraft.network.play.server.SPacketPlayerListHeaderFooter
 *  net.minecraft.network.play.server.SPacketPlayerListItem
 *  net.minecraft.network.play.server.SPacketPlayerListItem$Action
 *  net.minecraft.network.play.server.SPacketPlayerListItem$AddPlayerData
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.network.play.server.SPacketPlayerPosLook$EnumFlags
 *  net.minecraft.network.play.server.SPacketRecipeBook
 *  net.minecraft.network.play.server.SPacketRemoveEntityEffect
 *  net.minecraft.network.play.server.SPacketResourcePackSend
 *  net.minecraft.network.play.server.SPacketRespawn
 *  net.minecraft.network.play.server.SPacketScoreboardObjective
 *  net.minecraft.network.play.server.SPacketSelectAdvancementsTab
 *  net.minecraft.network.play.server.SPacketServerDifficulty
 *  net.minecraft.network.play.server.SPacketSetExperience
 *  net.minecraft.network.play.server.SPacketSetPassengers
 *  net.minecraft.network.play.server.SPacketSetSlot
 *  net.minecraft.network.play.server.SPacketSignEditorOpen
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.network.play.server.SPacketSpawnExperienceOrb
 *  net.minecraft.network.play.server.SPacketSpawnGlobalEntity
 *  net.minecraft.network.play.server.SPacketSpawnMob
 *  net.minecraft.network.play.server.SPacketSpawnObject
 *  net.minecraft.network.play.server.SPacketSpawnPainting
 *  net.minecraft.network.play.server.SPacketSpawnPlayer
 *  net.minecraft.network.play.server.SPacketSpawnPosition
 *  net.minecraft.network.play.server.SPacketStatistics
 *  net.minecraft.network.play.server.SPacketTabComplete
 *  net.minecraft.network.play.server.SPacketTeams
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  net.minecraft.network.play.server.SPacketTitle
 *  net.minecraft.network.play.server.SPacketTitle$Type
 *  net.minecraft.network.play.server.SPacketUnloadChunk
 *  net.minecraft.network.play.server.SPacketUpdateBossInfo
 *  net.minecraft.network.play.server.SPacketUpdateHealth
 *  net.minecraft.network.play.server.SPacketUpdateScore
 *  net.minecraft.network.play.server.SPacketUpdateScore$Action
 *  net.minecraft.network.play.server.SPacketUpdateTileEntity
 *  net.minecraft.network.play.server.SPacketUseBed
 *  net.minecraft.network.play.server.SPacketWindowItems
 *  net.minecraft.network.play.server.SPacketWindowProperty
 *  net.minecraft.network.play.server.SPacketWorldBorder
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.profiler.Profiler
 *  net.minecraft.scoreboard.Score
 *  net.minecraft.scoreboard.ScoreObjective
 *  net.minecraft.scoreboard.ScorePlayerTeam
 *  net.minecraft.scoreboard.Scoreboard
 *  net.minecraft.scoreboard.Team$CollisionRule
 *  net.minecraft.scoreboard.Team$EnumVisible
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityBanner
 *  net.minecraft.tileentity.TileEntityBeacon
 *  net.minecraft.tileentity.TileEntityBed
 *  net.minecraft.tileentity.TileEntityCommandBlock
 *  net.minecraft.tileentity.TileEntityEndGateway
 *  net.minecraft.tileentity.TileEntityFlowerPot
 *  net.minecraft.tileentity.TileEntityMobSpawner
 *  net.minecraft.tileentity.TileEntityShulkerBox
 *  net.minecraft.tileentity.TileEntitySign
 *  net.minecraft.tileentity.TileEntitySkull
 *  net.minecraft.tileentity.TileEntityStructure
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.IThreadListener
 *  net.minecraft.util.StringUtils
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.text.ChatType
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentTranslation
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.GameType
 *  net.minecraft.world.IInteractionObject
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 *  net.minecraft.world.WorldProviderSurface
 *  net.minecraft.world.WorldSettings
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraft.world.storage.MapData
 *  net.minecraft.world.storage.WorldSavedData
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package neo.deobf;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import neo.deobf.TextSetting;
import neo.deobf.Client;
import neo.deobf.PBotManager;
import neo.deobf.ModuleManager;
import neo.deobf.ActionRecorderModule;
import neo.deobf.AutoRegisterModule;
import neo.deobf.BooleanSetting;
import neo.deobf.ModeSetting;
import neo.deobf.PBot;
import neo.deobf.PBotPlayer;
import neo.deobf.PBotMinecraft;
import neo.deobf.PlayerListActionSwitchMap;
import neo.deobf.PBotNetworkManager;
import neo.deobf.PBotPlayerController;
import neo.deobf.ActionReplayRunner;
import neo.deobf.PBotWorldClient;
import neo.deobf.BotDebugModule;
import neo.deobf.BotSettingsModule;
import neo.deobf.WebSolverModule;
import neo.deobf.ScriptManager;
import neo.deobf.SeleniumJob;
import neo.deobf.SeleniumManager;
import neo.deobf.ChatUtils;
import net.minecraft.block.Block;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.player.inventory.ContainerLocalMenu;
import net.minecraft.client.player.inventory.LocalBlockIntercommunication;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.NpcMerchant;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityDragonFireball;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityEvokerFangs;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityLlamaSpit;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerHorseChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.PacketThreadUtil;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.play.client.CPacketKeepAlive;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketResourcePackStatus;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketAdvancementInfo;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.network.play.server.SPacketBlockAction;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketCamera;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.network.play.server.SPacketCloseWindow;
import net.minecraft.network.play.server.SPacketCollectItem;
import net.minecraft.network.play.server.SPacketCombatEvent;
import net.minecraft.network.play.server.SPacketConfirmTransaction;
import net.minecraft.network.play.server.SPacketCooldown;
import net.minecraft.network.play.server.SPacketCustomPayload;
import net.minecraft.network.play.server.SPacketCustomSound;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.network.play.server.SPacketDisplayObjective;
import net.minecraft.network.play.server.SPacketEffect;
import net.minecraft.network.play.server.SPacketEntity;
import net.minecraft.network.play.server.SPacketEntityAttach;
import net.minecraft.network.play.server.SPacketEntityEffect;
import net.minecraft.network.play.server.SPacketEntityEquipment;
import net.minecraft.network.play.server.SPacketEntityHeadLook;
import net.minecraft.network.play.server.SPacketEntityMetadata;
import net.minecraft.network.play.server.SPacketEntityProperties;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketEntityTeleport;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketHeldItemChange;
import net.minecraft.network.play.server.SPacketJoinGame;
import net.minecraft.network.play.server.SPacketKeepAlive;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraft.network.play.server.SPacketMoveVehicle;
import net.minecraft.network.play.server.SPacketMultiBlockChange;
import net.minecraft.network.play.server.SPacketOpenWindow;
import net.minecraft.network.play.server.SPacketParticles;
import net.minecraft.network.play.server.SPacketPlaceGhostRecipe;
import net.minecraft.network.play.server.SPacketPlayerAbilities;
import net.minecraft.network.play.server.SPacketPlayerListHeaderFooter;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.network.play.server.SPacketRecipeBook;
import net.minecraft.network.play.server.SPacketRemoveEntityEffect;
import net.minecraft.network.play.server.SPacketResourcePackSend;
import net.minecraft.network.play.server.SPacketRespawn;
import net.minecraft.network.play.server.SPacketScoreboardObjective;
import net.minecraft.network.play.server.SPacketSelectAdvancementsTab;
import net.minecraft.network.play.server.SPacketServerDifficulty;
import net.minecraft.network.play.server.SPacketSetExperience;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.network.play.server.SPacketSignEditorOpen;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketSpawnExperienceOrb;
import net.minecraft.network.play.server.SPacketSpawnGlobalEntity;
import net.minecraft.network.play.server.SPacketSpawnMob;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.network.play.server.SPacketSpawnPainting;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import net.minecraft.network.play.server.SPacketSpawnPosition;
import net.minecraft.network.play.server.SPacketStatistics;
import net.minecraft.network.play.server.SPacketTabComplete;
import net.minecraft.network.play.server.SPacketTeams;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.network.play.server.SPacketUnloadChunk;
import net.minecraft.network.play.server.SPacketUpdateBossInfo;
import net.minecraft.network.play.server.SPacketUpdateHealth;
import net.minecraft.network.play.server.SPacketUpdateScore;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.network.play.server.SPacketUseBed;
import net.minecraft.network.play.server.SPacketWindowItems;
import net.minecraft.network.play.server.SPacketWindowProperty;
import net.minecraft.network.play.server.SPacketWorldBorder;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntityEndGateway;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameType;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.WorldSavedData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PBotNetHandlerPlayClient
implements INetHandlerPlayClient {
    public final GameProfile profile;
    public final PBot pbot;
    public final PBotNetworkManager netManager;
    public boolean doneLoadingTerrain;
    public int currentServerMaxPlayers;
    public final Map<UUID, NetworkPlayerInfo> playerInfoMap = Maps.newHashMap();
    public static final Logger LOGGER = LogManager.getLogger();

    private static double getMotionX(PBotPlayer instance) {
        return instance.motionX;
    }

    private static PBot getPbot2(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static Map getPlayerInfoMap(PBotNetHandlerPlayClient instance) {
        return instance.playerInfoMap;
    }

    private static PBot getPbot4(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleCamera(SPacketCamera packetIn) {
    }

    private static PBotPlayer getPlayer(PBot instance) {
        return instance.player;
    }

    private static PBotMinecraft getMc3(PBot instance) {
        return instance.mc;
    }

    private static PBot getPbot8(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static BooleanSetting getWebSkipper() {
        return BotSettingsModule.webSkipper;
    }

    private static PBot getPbot9(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleEffect(SPacketEffect packetIn) {
        Object[] objectArray = new Object[2];
        objectArray[0] = (this.pbot);
        objectArray[1] = packetIn;
        (Client.getInstance().pBotsScriptManager).invokeMethod("SPacketEffect", objectArray);
    }

    private static PBot getPbot10(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

private static PBot getPbot11(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void cleanup() {
        (this.pbot).setWorld(null);
    }

    private static PlayerCapabilities getCapabilities(EntityPlayer entityPlayer) {
        return entityPlayer.capabilities;
    }

    private static PBotMinecraft getMc7(PBot instance) {
        return instance.mc;
    }

    private static PBot getPbot16(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleUpdateHealth(SPacketUpdateHealth packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot122(this).mc));
        (PBotNetHandlerPlayClient.getPbot231(this).player).setPlayerSPHealth(packetIn.getHealth());
        (PBotNetHandlerPlayClient.getPbot30(this).player).getFoodStats().setFoodLevel(packetIn.getFoodLevel());
        (PBotNetHandlerPlayClient.getPbot241(this).player).getFoodStats().setFoodSaturationLevel(packetIn.getSaturationLevel());
    }

    public void handleRespawn(SPacketRespawn packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot83(this).mc));
        if (packetIn.getDimensionID() != (PBotNetHandlerPlayClient.getPlayer41(PBotNetHandlerPlayClient.getPbot42(this)).dimension)) {
            this.doneLoadingTerrain = false;
            Scoreboard scoreboard = (this.pbot).getWorld().getScoreboard();
            WorldSettings ws = new WorldSettings(GenericCancelableEventB, packetIn.getGameType(), false, (this.pbot).getWorld().getWorldInfo().isHardcoreModeEnabled(), packetIn.getWorldType());
            (PBotNetHandlerPlayClient.getPbot101(this).mc).loadWorld(new PBotWorldClient((this.pbot), this, ws, packetIn.getDimensionID(), packetIn.getDifficulty(), (PBotNetHandlerPlayClient.getMc3(PBotNetHandlerPlayClient.getPbot80(this)).profiler)));
            (this.pbot).getWorld().setWorldScoreboard(scoreboard);
            PBotNetHandlerPlayClient.getPlayer16(PBotNetHandlerPlayClient.getPbot22(this)).dimension = packetIn.getDimensionID();
        }
        (PBotNetHandlerPlayClient.getPbot181(this).mc).setDimensionAndSpawnPlayer(packetIn.getDimensionID());
        (PBotNetHandlerPlayClient.getMc47(PBotNetHandlerPlayClient.getPbot177(this)).playerController).setGameType(packetIn.getGameType());
    }

    private static Container getOpenContainer(PBotPlayer instance) {
        return instance.openContainer;
    }

    private static PBotPlayer getPlayer4(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot22(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleBlockBreakAnim(SPacketBlockBreakAnim packetIn) {
    }

    private static PBot getPbot24(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot ynhemomnaj(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static BooleanSetting getDisconnect() {
        return BotDebugModule.disconnect;
    }

    private static PBot getPbot26(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot27(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handlePlayerListHeaderFooter(SPacketPlayerListHeaderFooter packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot56(this).mc));
        PBotNetHandlerPlayClient.getPbot164(this).tabHeader = packetIn.getHeader().getUnformattedText();
        PBotNetHandlerPlayClient.getPbot133(this).tabFooter = packetIn.getFooter().getUnformattedText();
        Object[] objectArray = new Object[3];
        objectArray[0] = (this.pbot);
        objectArray[1] = (PBotNetHandlerPlayClient.getPbot116(this).tabHeader);
        objectArray[2] = (PBotNetHandlerPlayClient.getPbot182(this).tabFooter);
        (Client.getInstance().pBotsScriptManager).invokeMethod("SPacketPlayerListHeaderFooter", objectArray);
        if ((BotSettingsModule.antibot).is("TabCaptcha")) {
            String[] stringArray = PBot.stripColor((String)(PBotNetHandlerPlayClient.getPbot37(this).tabHeader)).split("\\\\n");
            int n = stringArray.length;
            for (int i = 0; i < n; ++i) {
                String line = stringArray[i];
                if (!line.toLowerCase().contains("капча") || line.toLowerCase().contains("пройдена")) continue;
                (this.pbot).sendMessage(line.split(": ")[1]);
            }
        }
    }

    private static PBot getPbot29(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot30(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static BooleanSetting getConnecting() {
        return BotDebugModule.connecting;
    }

    public Collection<NetworkPlayerInfo> getPlayerInfoMap() {
        return (this.playerInfoMap).values();
    }

    private static double getPosX2(PBotPlayer instance) {
        return instance.posX;
    }

    private static PBotPlayer getPlayer7(PBot instance) {
        return instance.player;
    }

    public void handleConfirmTransaction(SPacketConfirmTransaction packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot220(this).mc));
        Container container = null;
        PBotPlayer entityplayer = (PBotNetHandlerPlayClient.ynhemomnaj(this).player);
        if (packetIn.getWindowId() == 0) {
            container = ((EntityPlayer)entityplayer.inventoryContainer);
        } else if (packetIn.getWindowId() == (PBotNetHandlerPlayClient.getOpenContainer2((EntityPlayer)entityplayer).windowId)) {
            container = ((EntityPlayer)entityplayer.openContainer);
        }
        if (container != null && !packetIn.wasAccepted()) {
            this.sendPacket((Packet<?>)new CPacketConfirmTransaction(packetIn.getWindowId(), packetIn.getActionNumber(), true));
        }
    }

    public void handleWorldBorder(SPacketWorldBorder packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot89(this).mc));
        packetIn.apply((this.pbot).getWorld().getWorldBorder());
    }

    private static PBot getPbot32(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot33(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot34(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer10(PBot instance) {
        return instance.player;
    }

    private static Container getOpenContainer2(EntityPlayer entityPlayer) {
        return entityPlayer.openContainer;
    }

    private static PBot getPbot37(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleMultiBlockChange(SPacketMultiBlockChange packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot104(this).mc));
        SPacketMultiBlockChange.BlockUpdateData[] blockUpdateDataArray = packetIn.getChangedBlocks();
        int n = blockUpdateDataArray.length;
        for (int i = 0; i < n; ++i) {
            SPacketMultiBlockChange.BlockUpdateData spacketmultiblockchange$blockupdatedata = blockUpdateDataArray[i];
            (this.pbot).getWorld().invalidateRegionAndSetBlock(spacketmultiblockchange$blockupdatedata.getPos(), spacketmultiblockchange$blockupdatedata.getBlockState());
        }
    }

    private static long getServerPosZ(Entity entity) {
        return entity.serverPosZ;
    }

    public void handleChangeGameState(SPacketChangeGameState packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot95(this).mc));
        PBotPlayer entityplayer = (PBotNetHandlerPlayClient.getPbot99(this).player);
        int i = packetIn.getGameState();
        float f = packetIn.getValue();
        int j = MathHelper.floor((float)(f + 0.5f));
        if (i >= 0 && i < (SPacketChangeGameState.MESSAGE_NAMES).length && (SPacketChangeGameState.MESSAGE_NAMES)[i] != null) {
            entityplayer.sendStatusMessage((ITextComponent)new TextComponentTranslation((SPacketChangeGameState.MESSAGE_NAMES)[i], new Object[0]), false);
        }
        if (i == (1)) {
            (this.pbot).getWorld().getWorldInfo().setRaining(true);
            (this.pbot).getWorld().setRainStrength(0.0f);
        } else if (i == (2)) {
            (this.pbot).getWorld().getWorldInfo().setRaining(false);
            (this.pbot).getWorld().setRainStrength(1.0f);
        } else if (i == (3)) {
            (PBotNetHandlerPlayClient.getMc67(PBotNetHandlerPlayClient.getPbot234(this)).playerController).setGameType(GameType.getByID((int)j));
        } else if (i == (4)) {
            if (j == 0) {
                (PBotNetHandlerPlayClient.getPlayer(PBotNetHandlerPlayClient.getPbot203(this)).connection).sendPacket((Packet<?>)new CPacketClientStatus((CPacketClientStatus.State.PERFORM_RESPAWN)));
            }
        } else if (i == (7)) {
            (this.pbot).getWorld().setRainStrength(f);
        } else if (i == (8)) {
            (this.pbot).getWorld().setThunderStrength(f);
        }
    }

    public void handleUpdateTileEntity(SPacketUpdateTileEntity packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot219(this).mc));
        if ((this.pbot).getWorld().isBlockLoaded(packetIn.getPos())) {
            int flag;
            TileEntity tileentity = (this.pbot).getWorld().getTileEntity(packetIn.getPos());
            int i = packetIn.getTileEntityType();
            int n = flag = i == (2) && tileentity instanceof TileEntityCommandBlock ? 1 : 0;
            if (i == (1) && tileentity instanceof TileEntityMobSpawner || flag != 0 || i == (3) && tileentity instanceof TileEntityBeacon || i == (4) && tileentity instanceof TileEntitySkull || i == (5) && tileentity instanceof TileEntityFlowerPot || i == (6) && tileentity instanceof TileEntityBanner || i == (7) && tileentity instanceof TileEntityStructure || i == (8) && tileentity instanceof TileEntityEndGateway || i == (9) && tileentity instanceof TileEntitySign || i == (10) && tileentity instanceof TileEntityShulkerBox || i == (11) && tileentity instanceof TileEntityBed) {
                tileentity.readFromNBT(packetIn.getNbtCompound());
            }
        }
    }

    private static PBot getPbot42(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot44(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleUpdateScore(SPacketUpdateScore packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot247(this).mc));
        Scoreboard scoreboard = (this.pbot).getWorld().getScoreboard();
        ScoreObjective scoreobjective = scoreboard.getObjective(packetIn.getObjectiveName());
        if (packetIn.getScoreAction() == (SPacketUpdateScore.Action.CHANGE)) {
            Score score = scoreboard.getOrCreateScore(packetIn.getPlayerName(), scoreobjective);
            score.setScorePoints(packetIn.getScoreValue());
        } else if (packetIn.getScoreAction() == (SPacketUpdateScore.Action.REMOVE)) {
            if (StringUtils.isNullOrEmpty((String)packetIn.getObjectiveName())) {
                scoreboard.removeObjectiveFromEntity(packetIn.getPlayerName(), (ScoreObjective)null);
            } else if (scoreobjective != null) {
                scoreboard.removeObjectiveFromEntity(packetIn.getPlayerName(), scoreobjective);
            }
        }
    }

    private static long getServerPosX(Entity entity) {
        return entity.serverPosX;
    }

    private static PlayerCapabilities getCapabilities2(EntityPlayer entityPlayer) {
        return entityPlayer.capabilities;
    }

    public void handleCloseWindow(SPacketCloseWindow packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot24(this).mc));
        (PBotNetHandlerPlayClient.getPbot141(this).player).closeScreenAndDropStack();
    }

    private static long getServerPosY(Entity entity) {
        return entity.serverPosY;
    }

    private static PBotPlayer getPlayer15(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot55(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PlayerCapabilities getCapabilities3(EntityPlayer entityPlayer) {
        return entityPlayer.capabilities;
    }

    private static PBot getPbot56(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot58(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public GameProfile getGameProfile() {
        return (this.profile);
    }

    private static PBot getPbot59(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot60(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot63(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot66(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static Container getOpenContainer3(PBotPlayer instance) {
        return instance.openContainer;
    }

    private static PBot getPbot68(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleStatistics(SPacketStatistics packetIn) {
    }

    private static PBot getPbot69(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot71(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleEntityHeadLook(SPacketEntityHeadLook packetIn) {
    }

    private static PBot getPbot73(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleExplosion(SPacketExplosion packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot69(this).mc));
        Explosion explosion = new Explosion((World)(this.pbot).getWorld(), null, packetIn.getX(), packetIn.getY(), packetIn.getZ(), packetIn.getStrength(), packetIn.getAffectedBlockPositions());
        explosion.doExplosionB(true);
        PBotPlayer cD = (PBotNetHandlerPlayClient.getPbot9(this).player);
        cD.motionX = PBotNetHandlerPlayClient.getMotionX(cD) + (double)packetIn.getMotionX();
        PBotPlayer cD2 = (PBotNetHandlerPlayClient.getPbot147(this).player);
        cD2.motionY = PBotNetHandlerPlayClient.getMotionY(cD2) + (double)packetIn.getMotionY();
        PBotPlayer cD3 = (PBotNetHandlerPlayClient.getPbot180(this).player);
        cD3.motionZ = PBotNetHandlerPlayClient.getMotionZ(cD3) + (double)packetIn.getMotionZ();
    }

    private static PBot getPbot77(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleSpawnPainting(SPacketSpawnPainting packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot66(this).mc));
        EntityPainting entitypainting = new EntityPainting((World)(this.pbot).getWorld(), packetIn.getPosition(), packetIn.getFacing(), packetIn.getTitle());
        entitypainting.setUniqueId(packetIn.getUniqueId());
        (this.pbot).getWorld().addEntityToWorld(packetIn.getEntityID(), (Entity)entitypainting);
    }

    private static Container getOpenContainer4(PBotPlayer instance) {
        return instance.openContainer;
    }

    public void handleEntityAttach(SPacketEntityAttach packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot185(this).mc));
        Entity entity = (this.pbot).getWorld().getEntityByID(packetIn.getEntityId());
        Entity entity1 = (this.pbot).getWorld().getEntityByID(packetIn.getVehicleEntityId());
        if (entity instanceof EntityLiving) {
            if (entity1 != null) {
                ((EntityLiving)entity).setLeashHolder(entity1, false);
            } else {
                ((EntityLiving)entity).clearLeashed(false, false);
            }
        }
    }

    private static PBot getPbot80(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot82(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot83(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot85(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleChat(SPacketChat packetIn) {
        String number;
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot161(this).mc));
        if (packetIn.getType() == (ChatType.GAME_INFO)) {
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = (this.pbot);
        objectArray[1] = packetIn;
        (Client.getInstance().pBotsScriptManager).invokeMethod("SPacketChat", objectArray);
        String message = packetIn.getChatComponent().getFormattedText();
        if ((PBotNetHandlerPlayClient.getChat().value)) {
            ChatUtils.formatMsg((String)("Чат &d&l" + (this.pbot).getNickname() + "&f&l &r" + message));
        }
        String cleanedMessage = PBot.stripColor((String)message);
        (this.pbot).setParameter("lastmessage", (Object)cleanedMessage);
        if (cleanedMessage.contains((PBotNetHandlerPlayClient.getMessage().text))) {
            ActionReplayRunner.trigger((PBot)(this.pbot), (String)"onMessage");
        }
        if ((Client.getInstance().moduleManager).getModule(AutoRegisterModule.class).isModuleState() && !(this.pbot).getBooleanParameter("authorization") && (cleanedMessage.contains("/reg") || cleanedMessage.contains("зарегестр") || cleanedMessage.contains("/l") || cleanedMessage.contains("авторизир") && !cleanedMessage.contains("уже"))) {
            (this.pbot).auth();
        }
        if ((PBotNetHandlerPlayClient.getWebSkipper().value) && cleanedMessage.toLowerCase().contains("http")) {
            if (cleanedMessage.toLowerCase().contains("antibot") || cleanedMessage.toLowerCase().contains("id=") || cleanedMessage.toLowerCase().contains("captcha") || cleanedMessage.toLowerCase().contains("t=")) {
                PBotManager.getInstance().getProxyManager().removeProxy((this.pbot).getProxy());
                ChatUtils.formatMsg((String)("Отключение &d&l" + (this.pbot).getNickname() + "&f&l Web Skipper enabled"));
                (this.pbot).stopBot();
            }
        } else if ((Client.getInstance().moduleManager).getModule(WebSolverModule.class).isModuleState() && !(this.pbot).getBooleanParameter("webdetected") && cleanedMessage.contains("http") && (cleanedMessage.contains("antibot") || cleanedMessage.contains("captcha") || cleanedMessage.contains("id=") || cleanedMessage.toLowerCase().contains("t="))) {
            String s1 = cleanedMessage.split("://")[1];
            String url = "https://" + s1.split(" ")[0];
            (this.pbot).setParameter("webdetected", (Object)(true));
            ChatUtils.formatMsg((String)("Detected WebCaptchaURL | BOT: &d&l" + (this.pbot).getNickname() + "&f&l: URL: " + url + " &f&lProxy: &d&l" + (this.pbot).getProxy().getType().name().toLowerCase() + "://" + (this.pbot).getProxy().getProxy()));
            (Client.getInstance().seleniumManager).addQueue(new SeleniumJob(url, (this.pbot).getProxy(), (this.pbot).getNickname()));
        }
        if ((cleanedMessage.toLowerCase().contains("проверка") || cleanedMessage.toLowerCase().contains("код") || cleanedMessage.toLowerCase().contains("капча") || cleanedMessage.toLowerCase().contains("captcha") || cleanedMessage.toLowerCase().contains("filter") || cleanedMessage.toLowerCase().contains("с картинки") || cleanedMessage.toLowerCase().contains("вы ввели") || cleanedMessage.toLowerCase().contains("у вас")) && (cleanedMessage.toLowerCase().contains("неверно") || cleanedMessage.toLowerCase().contains("неправильно") || cleanedMessage.toLowerCase().contains("еще раз"))) {
            (this.pbot).setParameter("captchadetected", (Object)(false));
        }
        if ((BotSettingsModule.antibot).is("KeyboardClick") && cleanedMessage.contains("нажми на") && cleanedMessage.contains("цифру") && cleanedMessage.contains("клавиатур") && (number = cleanedMessage.replaceAll("[^0-9]", "")).length() > 0) {
            (this.pbot).changeSlot(Integer.parseInt(number) - (1));
            (this.pbot).useItem();
        }
        if ((BotSettingsModule.antibot).is("MathClick") && cleanedMessage.contains("Варианты ответов:")) {
            String answer = message.split("  ")[1];
            (this.pbot).sendMessage("." + answer);
        }
    }

    private static PBotPlayer getPlayer16(PBot instance) {
        return instance.player;
    }

    public void processChunkUnload(SPacketUnloadChunk packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot222(this).mc));
        (this.pbot).getWorld().doPreChunk(packetIn.getX(), packetIn.getZ(), false);
    }

    public void handleSetExperience(SPacketSetExperience packetIn) {
        (PBotNetHandlerPlayClient.getPbot142(this).player).setXPStats(packetIn.getExperienceBar(), packetIn.getTotalExperience(), packetIn.getLevel());
    }

    private static PBot getPbot87(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleEntityMovement(SPacketEntity packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot121(this).mc));
        Entity entity = packetIn.getEntity((World)(this.pbot).getWorld());
        if (entity != null) {
            Entity entity2 = entity;
            entity2.serverPosX = PBotNetHandlerPlayClient.getServerPosX(entity2) + (long)packetIn.getX();
            Entity entity3 = entity;
            entity3.serverPosY = PBotNetHandlerPlayClient.getServerPosY(entity3) + (long)packetIn.getY();
            Entity entity4 = entity;
            entity4.serverPosZ = PBotNetHandlerPlayClient.getServerPosZ(entity4) + (long)packetIn.getZ();
            double d0 = (double)(entity.serverPosX) / 4096.0;
            double d1 = (double)(entity.serverPosY) / 4096.0;
            double d2 = (double)(entity.serverPosZ) / 4096.0;
            if (!entity.canPassengerSteer()) {
                float f = packetIn.isRotating() ? (float)(packetIn.getYaw() * (360)) / 256.0f : (entity.rotationYaw);
                float f1 = packetIn.isRotating() ? (float)(packetIn.getPitch() * (360)) / 256.0f : (entity.rotationPitch);
                entity.setPositionAndRotation(d0, d1, d2, f, f1);
                entity.onGround = packetIn.getOnGround();
            }
        }
    }

    private static PBot getPbot89(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleDestroyEntities(SPacketDestroyEntities packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot27(this).mc));
        for (int i = 0; i < packetIn.getEntityIDs().length; ++i) {
            (this.pbot).getWorld().removeEntityFromWorld(packetIn.getEntityIDs()[i]);
        }
    }

    private static PBot getPbot91(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot93(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleKeepAlive(SPacketKeepAlive packetIn) {
        this.sendPacket((Packet<?>)new CPacketKeepAlive(packetIn.getId()));
        (this.pbot).botTick();
    }

    public void handleCooldown(SPacketCooldown packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot114(this).mc));
        if (packetIn.getTicks() == 0) {
            (PBotNetHandlerPlayClient.getPbot10(this).player).getCooldownTracker().removeCooldown(packetIn.getItem());
        } else {
            (PBotNetHandlerPlayClient.getPbot100(this).player).getCooldownTracker().setCooldown(packetIn.getItem(), packetIn.getTicks());
        }
    }

    public void handleBlockAction(SPacketBlockAction packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot237(this).mc));
        (this.pbot).getWorld().addBlockEvent(packetIn.getBlockPosition(), packetIn.getBlockType(), packetIn.getData1(), packetIn.getData2());
    }

    private static PBot getPbot95(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot96(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleChunkData(SPacketChunkData packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot244(this).mc));
        if (packetIn.isFullChunk()) {
            (this.pbot).getWorld().doPreChunk(packetIn.getChunkX(), packetIn.getChunkZ(), true);
        }
        Chunk chunk = (this.pbot).getWorld().getChunk(packetIn.getChunkX(), packetIn.getChunkZ());
        chunk.read(packetIn.getReadBuffer(), packetIn.getExtractedSize(), packetIn.isFullChunk());
        (this.pbot).getWorld().markBlockRangeForRenderUpdate(packetIn.getChunkX() << (4), 0, packetIn.getChunkZ() << (4), (packetIn.getChunkX() << (4)) + (15), 256, (packetIn.getChunkZ() << (4)) + (15));
        if (!packetIn.isFullChunk() || !((PBotNetHandlerPlayClient.getPbot160(this).getWorld().provider) instanceof WorldProviderSurface)) {
            chunk.resetRelightChecks();
        }
        for (NBTTagCompound nbttagcompound : packetIn.getTileEntityTags()) {
            BlockPos blockpos = new BlockPos(nbttagcompound.getInteger("x"), nbttagcompound.getInteger("y"), nbttagcompound.getInteger("z"));
            TileEntity tileentity = (this.pbot).getWorld().getTileEntity(blockpos);
            if (tileentity == null) continue;
            tileentity.readFromNBT(nbttagcompound);
        }
    }

    private static PBot getPbot99(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static Container getOpenContainer5(EntityPlayer entityPlayer) {
        return entityPlayer.openContainer;
    }

    private static PBotPlayer getPlayer20(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot100(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot101(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleJoinGame(SPacketJoinGame packetIn) {
        PBotManager.getInstance().getCaptchaManager().removeCaptcha((this.pbot));
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot201(this).mc));
        PBotNetHandlerPlayClient.getMc7(PBotNetHandlerPlayClient.getPbot55(this)).playerController = new PBotPlayerController(PBotNetHandlerPlayClient.getPbot192(this));
        WorldSettings ws = new WorldSettings(GenericCancelableEventB, packetIn.getGameType(), false, packetIn.isHardcoreMode(), packetIn.getWorldType());
        (PBotNetHandlerPlayClient.getPbot170(this).mc).loadWorld(new PBotWorldClient((this.pbot), this, ws, packetIn.getDimension(), packetIn.getDifficulty(), (PBotNetHandlerPlayClient.getMc52(PBotNetHandlerPlayClient.getPbot96(this)).profiler)));
        PBotNetHandlerPlayClient.getPlayer7(PBotNetHandlerPlayClient.getPbot73(this)).dimension = packetIn.getDimension();
        (PBotNetHandlerPlayClient.getPbot233(this).player).setEntityId(packetIn.getPlayerId());
        this.currentServerMaxPlayers = packetIn.getMaxPlayers();
        (PBotNetHandlerPlayClient.getPbot190(this).player).setReducedDebug(packetIn.isReducedDebugInfo());
        (PBotNetHandlerPlayClient.getMc63(PBotNetHandlerPlayClient.getPbot115(this)).playerController).setGameType(packetIn.getGameType());
        (PBotNetHandlerPlayClient.getPbot211(this).player).sendSettingsToServer();
        (this.netManager).sendPacket((Packet)new CPacketCustomPayload("MC|Brand", new PacketBuffer(Unpooled.buffer()).writeString(ClientBrandRetriever.getClientModName())));
        Object[] objectArray = new Object[2];
        objectArray[0] = (this.pbot);
        objectArray[1] = packetIn;
        (Client.getInstance().pBotsScriptManager).invokeMethod("SPacketJoinGame", objectArray);
        if ((PBotNetHandlerPlayClient.getConnecting().value)) {
            ChatUtils.formatMsg((String)("Бот &d&l" + (this.pbot).getNickname() + "&f&l Подключился к серверу!"));
        }
        ActionReplayRunner.trigger((PBot)(this.pbot), (String)"onJoin");
    }

    public void handleEntityProperties(SPacketEntityProperties packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot126(this).mc));
        Entity entity = (this.pbot).getWorld().getEntityByID(packetIn.getEntityId());
        if (entity != null) {
            if (!(entity instanceof EntityLivingBase)) {
                throw new IllegalStateException("Server tried to update attributes of a non-living entity (actually: " + entity + ")");
            }
            AbstractAttributeMap abstractattributemap = ((EntityLivingBase)entity).getAttributeMap();
            for (SPacketEntityProperties.Snapshot spacketentityproperties$snapshot : packetIn.getSnapshots()) {
                IAttributeInstance iattributeinstance = abstractattributemap.getAttributeInstanceByName(spacketentityproperties$snapshot.getName());
                if (iattributeinstance == null) {
                    iattributeinstance = abstractattributemap.registerAttribute((IAttribute)new RangedAttribute((IAttribute)null, spacketentityproperties$snapshot.getName(), 2.2250738585072014E-308, 2.2250738585072014E-308, 1.7976931348623157E+308));
                }
                iattributeinstance.setBaseValue(spacketentityproperties$snapshot.getBaseValue());
                iattributeinstance.removeAllModifiers();
                for (AttributeModifier attributemodifier : spacketentityproperties$snapshot.getModifiers()) {
                    iattributeinstance.applyModifier(attributemodifier);
                }
            }
        }
    }

    private static PBot getPbot104(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleSpawnGlobalEntity(SPacketSpawnGlobalEntity packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot184(this).mc));
        double d0 = packetIn.getX();
        double d1 = packetIn.getY();
        double d2 = packetIn.getZ();
        EntityLightningBolt entity = null;
        if (packetIn.getType() == (1)) {
            entity = new EntityLightningBolt((World)(this.pbot).getWorld(), d0, d1, d2, false);
        }
        if (entity != null) {
            (Entity)entity.rotationYaw = 0.0f;
            (Entity)entity.rotationPitch = 0.0f;
            entity.setEntityId(packetIn.getEntityId());
            (this.pbot).getWorld().addWeatherEffect((Entity)entity);
        }
    }

    public void handleRemoveEntityEffect(SPacketRemoveEntityEffect packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot2(this).mc));
        Entity entity = packetIn.getEntity((World)(this.pbot).getWorld());
        if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase)entity).removeActivePotionEffect(packetIn.getPotion());
        }
    }

    private static PBot getPbot113(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleTeams(SPacketTeams packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot221(this).mc));
        Scoreboard scoreboard = (this.pbot).getWorld().getScoreboard();
        ScorePlayerTeam scoreplayerteam = scoreboard.getTeam(packetIn.getName());
        if (packetIn.getAction() == 0 && scoreplayerteam == null) {
            scoreplayerteam = scoreboard.createTeam(packetIn.getName());
        }
        if (scoreplayerteam != null) {
            Team.CollisionRule team$collisionrule;
            scoreplayerteam.setDisplayName(packetIn.getDisplayName());
            scoreplayerteam.setPrefix(packetIn.getPrefix());
            scoreplayerteam.setSuffix(packetIn.getSuffix());
            scoreplayerteam.setColor(TextFormatting.fromColorIndex((int)packetIn.getColor()));
            scoreplayerteam.setFriendlyFlags(packetIn.getFriendlyFlags());
            Team.EnumVisible team$enumvisible = Team.EnumVisible.getByName((String)packetIn.getNameTagVisibility());
            if (team$enumvisible != null) {
                scoreplayerteam.setNameTagVisibility(team$enumvisible);
            }
            if ((team$collisionrule = Team.CollisionRule.getByName((String)packetIn.getCollisionRule())) != null) {
                scoreplayerteam.setCollisionRule(team$collisionrule);
            }
        }
        if (packetIn.getAction() == 0 || packetIn.getAction() == (3)) {
            for (String s : packetIn.getPlayers()) {
                scoreboard.addPlayerToTeam(s, packetIn.getName());
            }
        }
        if (packetIn.getAction() == (4)) {
            for (String s1 : packetIn.getPlayers()) {
                if (scoreplayerteam == null || scoreboard.getPlayersTeam(s1) != scoreplayerteam) continue;
                scoreboard.removePlayerFromTeam(s1, scoreplayerteam);
            }
        }
    }

    private static PBot getPbot114(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot115(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot116(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot117(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleServerDifficulty(SPacketServerDifficulty packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot33(this).mc));
        (this.pbot).getWorld().getWorldInfo().setDifficulty(packetIn.getDifficulty());
        (this.pbot).getWorld().getWorldInfo().setDifficultyLocked(packetIn.isDifficultyLocked());
    }

    private static PBot getPbot121(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot122(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void sendPacket(Packet<?> packet) {
        (this.netManager).sendPacket(packet);
    }

    private static PBot getPbot126(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleAdvancementInfo(SPacketAdvancementInfo packetIn) {
    }

    private static PBot getPbot128(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot130(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static Container getOpenContainer6(PBotPlayer instance) {
        return instance.openContainer;
    }

    private static PBot getPbot131(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void onDisconnect(ITextComponent reason) {
        (PBotNetHandlerPlayClient.getPbot157(this).mc).loadWorld(null);
        (this.pbot).disconnect();
    }

    public void handleEntityStatus(SPacketEntityStatus packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot199(this).mc));
        Entity entity = packetIn.getEntity((World)(this.pbot).getWorld());
        if (entity != null && packetIn.getOpCode() != (21)) {
            if (packetIn.getOpCode() == (35)) {
                if (entity == (PBotNetHandlerPlayClient.getPbot167(this).player)) {
                    // empty if block
                }
            } else {
                entity.handleStatusUpdate(packetIn.getOpCode());
            }
        }
    }

    private static PBot getPbot132(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot133(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot134(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBotMinecraft getMc47(PBot instance) {
        return instance.mc;
    }

    private static double getMotionZ(PBotPlayer instance) {
        return instance.motionZ;
    }

    public void handleSpawnPosition(SPacketSpawnPosition packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot149(this).mc));
        (PBotNetHandlerPlayClient.getPbot117(this).player).setSpawnPoint(packetIn.getSpawnPos(), true);
        (this.pbot).getWorld().getWorldInfo().setSpawn(packetIn.getSpawnPos());
    }

    public void handleMoveVehicle(SPacketMoveVehicle packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot59(this).mc));
        Entity entity = (PBotNetHandlerPlayClient.getPbot227(this).player).getLowestRidingEntity();
        if (entity != (PBotNetHandlerPlayClient.getPbot163(this).player) && entity.canPassengerSteer()) {
            entity.setPositionAndRotation(packetIn.getX(), packetIn.getY(), packetIn.getZ(), packetIn.getYaw(), packetIn.getPitch());
            (this.netManager).sendPacket((Packet)new CPacketVehicleMove(entity));
        }
    }

    private static PBotPlayer getPlayer26(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot141(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot142(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer28(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot145(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot147(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleHeldItemChange(SPacketHeldItemChange packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot32(this).mc));
        if (InventoryPlayer.isHotbar((int)packetIn.getHeldItemHotbarIndex())) {
            PBotNetHandlerPlayClient.getInventory3(PBotNetHandlerPlayClient.getPlayer20(PBotNetHandlerPlayClient.getPbot11(this))).currentItem = packetIn.getHeldItemHotbarIndex();
        }
    }

    private static PBot getPbot149(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleEntityEffect(SPacketEntityEffect packetIn) {
        Potion potion;
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot131(this).mc));
        Entity entity = (this.pbot).getWorld().getEntityByID(packetIn.getEntityId());
        if (entity instanceof EntityLivingBase && (potion = Potion.getPotionById((int)packetIn.getEffectId())) != null) {
            PotionEffect potioneffect = new PotionEffect(potion, packetIn.getDuration(), (int)packetIn.getAmplifier(), packetIn.getIsAmbient(), packetIn.doesShowParticles());
            potioneffect.setPotionDurationMax(packetIn.isMaxDuration());
            ((EntityLivingBase)entity).addPotionEffect(potioneffect);
        }
    }

    public void handleDisplayObjective(SPacketDisplayObjective packetIn) {
    }

    private static PBot getPbot151(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot154(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handlePlayerAbilities(SPacketPlayerAbilities packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot8(this).mc));
        PBotPlayer entityplayer1 = (PBotNetHandlerPlayClient.getPbot4(this).player);
        PBotNetHandlerPlayClient.getCapabilities((EntityPlayer)entityplayer1).isFlying = packetIn.isFlying();
        PBotNetHandlerPlayClient.getCapabilities5((EntityPlayer)entityplayer1).isCreativeMode = packetIn.isCreativeMode();
        PBotNetHandlerPlayClient.getCapabilities3((EntityPlayer)entityplayer1).disableDamage = packetIn.isInvulnerable();
        PBotNetHandlerPlayClient.getCapabilities2((EntityPlayer)entityplayer1).allowFlying = packetIn.isAllowFlying();
        ((EntityPlayer)entityplayer1.capabilities).setFlySpeed(packetIn.getFlySpeed());
        ((EntityPlayer)entityplayer1.capabilities).setPlayerWalkSpeed(packetIn.getWalkSpeed());
    }

    private static PBot getPbot157(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBotMinecraft getMc52(PBot instance) {
        return instance.mc;
    }

    private static PBot getPbot160(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot161(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot162(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot163(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleEntityEquipment(SPacketEntityEquipment packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot71(this).mc));
        Entity entity = (this.pbot).getWorld().getEntityByID(packetIn.getEntityID());
        if (entity != null) {
            entity.setItemStackToSlot(packetIn.getEquipmentSlot(), packetIn.getItemStack());
        }
    }

    public void handleSoundEffect(SPacketSoundEffect packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot187(this).mc));
        Object[] objectArray = new Object[2];
        objectArray[0] = (this.pbot);
        objectArray[1] = packetIn;
        (Client.getInstance().pBotsScriptManager).invokeMethod("SPacketSoundEffect", objectArray);
    }

    private static PBot getPbot164(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleScoreboardObjective(SPacketScoreboardObjective packetIn) {
    }

    private static PBot getPbot165(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot167(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleWindowItems(SPacketWindowItems packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot130(this).mc));
        PBotPlayer entityplayer = (PBotNetHandlerPlayClient.getPbot85(this).player);
        if (packetIn.getWindowId() == 0) {
            ((EntityPlayer)entityplayer.inventoryContainer).setAll(packetIn.getItemStacks());
        } else if (packetIn.getWindowId() == (PBotNetHandlerPlayClient.getOpenContainer5((EntityPlayer)entityplayer).windowId)) {
            ((EntityPlayer)entityplayer.openContainer).setAll(packetIn.getItemStacks());
        }
    }

    public void handleParticles(SPacketParticles packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot223(this).mc));
        Object[] objectArray = new Object[2];
        objectArray[0] = (this.pbot);
        objectArray[1] = packetIn;
        (Client.getInstance().pBotsScriptManager).invokeMethod("SPacketParticles", objectArray);
    }

    private static PBot GafhjcwdgA(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot169(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleCustomSound(SPacketCustomSound packetIn) {
    }

    public void handleAnimation(SPacketAnimation packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot68(this).mc));
        Entity entity = (this.pbot).getWorld().getEntityByID(packetIn.getEntityID());
        if (entity != null) {
            if (packetIn.getAnimationType() == 0) {
                EntityLivingBase entitylivingbase = (EntityLivingBase)entity;
                entitylivingbase.swingArm((EnumHand.MAIN_HAND));
            } else if (packetIn.getAnimationType() == (3)) {
                EntityLivingBase entitylivingbase1 = (EntityLivingBase)entity;
                entitylivingbase1.swingArm((EnumHand.OFF_HAND));
            } else if (packetIn.getAnimationType() == (1)) {
                entity.performHurtAnimation();
            } else if (packetIn.getAnimationType() == (2)) {
                EntityPlayer entityplayer = (EntityPlayer)entity;
                entityplayer.wakeUpPlayer(false, false, false);
            } else if (packetIn.getAnimationType() == (4) || packetIn.getAnimationType() == (5)) {
                // empty if block
            }
        }
    }

    public void handleDisconnect(SPacketDisconnect packetIn) {
        PBotManager.getInstance().getCaptchaManager().removeCaptcha((this.pbot));
        if ((PBotNetHandlerPlayClient.getDisconnect().value)) {
            ChatUtils.formatMsg((String)("Отключение &d&l" + (this.pbot).getNickname() + "&f&l " + packetIn.getReason().getFormattedText()));
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = (this.pbot);
        objectArray[1] = packetIn;
        (Client.getInstance().pBotsScriptManager).invokeMethod("SPacketDisconnect", objectArray);
        (this.netManager).closeChannel(packetIn.getReason());
        (this.pbot).reconnect(false);
    }

    private static PBot getPbot170(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot173(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot174(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleCustomPayload(SPacketCustomPayload packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot82(this).mc));
    }

    private static PBot getPbot177(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer31(PBot instance) {
        return instance.player;
    }

    public void handleSpawnPlayer(SPacketSpawnPlayer packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot174(this).mc));
        try {
            double d0 = packetIn.getX();
            double d1 = packetIn.getY();
            double d2 = packetIn.getZ();
            float f = (float)(packetIn.getYaw() * (360)) / 256.0f;
            float f1 = (float)(packetIn.getPitch() * (360)) / 256.0f;
            NetworkPlayerInfo netInfo = this.getPlayerInfo(packetIn.getUniqueId());
            EntityOtherPlayerMP entityotherplayermp = new EntityOtherPlayerMP((World)(this.pbot).getWorld(), netInfo.getGameProfile());
            entityotherplayermp.prevPosX = d0;
            entityotherplayermp.lastTickPosX = d0;
            entityotherplayermp.prevPosY = d1;
            entityotherplayermp.lastTickPosY = d1;
            entityotherplayermp.prevPosZ = d2;
            entityotherplayermp.lastTickPosZ = d2;
            EntityTracker.updateServerPosition((Entity)entityotherplayermp, (double)d0, (double)d1, (double)d2);
            entityotherplayermp.setPositionAndRotation(d0, d1, d2, f, f1);
            (this.pbot).getWorld().addEntityToWorld(packetIn.getEntityID(), (Entity)entityotherplayermp);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static PBot getPbot180(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot181(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleUpdateBossInfo(SPacketUpdateBossInfo packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot154(this).mc));
        Object[] objectArray = new Object[2];
        objectArray[0] = (this.pbot);
        objectArray[1] = packetIn;
        (Client.getInstance().pBotsScriptManager).invokeMethod("SPacketUpdateBossInfo", objectArray);
    }

    private static PBot getPbot182(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot184(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleResourcePack(SPacketResourcePackSend packetIn) {
        Object[] objectArray = new Object[2];
        objectArray[0] = (this.pbot);
        objectArray[1] = packetIn;
        (Client.getInstance().pBotsScriptManager).invokeMethod("SPacketResourcePackSend", objectArray);
        if ((PBotNetHandlerPlayClient.getRPskip().value)) {
            (PBotNetHandlerPlayClient.getPlayer39(PBotNetHandlerPlayClient.getPbot246(this)).connection).sendPacket((Packet<?>)new CPacketResourcePackStatus((CPacketResourcePackStatus.Action.ACCEPTED)));
            (PBotNetHandlerPlayClient.getPlayer10(PBotNetHandlerPlayClient.getPbot193(this)).connection).sendPacket((Packet<?>)new CPacketResourcePackStatus((CPacketResourcePackStatus.Action.SUCCESSFULLY_LOADED)));
        }
    }

    private static PBot getPbot185(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot187(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static Container getOpenContainer9(EntityPlayer entityPlayer) {
        return entityPlayer.openContainer;
    }

    private static PBot getPbot188(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void func_194307_a(SPacketPlaceGhostRecipe p_194307_1_) {
    }

    private static PBot getPbot190(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot192(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot193(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleCollectItem(SPacketCollectItem packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot132(this).mc));
        Entity entity = (this.pbot).getWorld().getEntityByID(packetIn.getCollectedItemEntityID());
        EntityLivingBase entitylivingbase = (EntityLivingBase)(this.pbot).getWorld().getEntityByID(packetIn.getEntityID());
        if (entitylivingbase == null) {
            entitylivingbase = (PBotNetHandlerPlayClient.getPbot145(this).player);
        }
        if (entity != null) {
            if (entity instanceof EntityItem) {
                ((EntityItem)entity).getItem().setCount(packetIn.getAmount());
            }
            (this.pbot).getWorld().removeEntityFromWorld(packetIn.getCollectedItemEntityID());
        }
    }

    public void handleTabComplete(SPacketTabComplete packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot188(this).mc));
        Object[] objectArray = new Object[2];
        objectArray[0] = (this.pbot);
        objectArray[1] = packetIn;
        (Client.getInstance().pBotsScriptManager).invokeMethod("SPacketTabComplete", objectArray);
    }

    private static PBot getPbot197(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot199(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot200(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public NetworkPlayerInfo getPlayerInfo(UUID uniqueId) {
        return (NetworkPlayerInfo)(this.playerInfoMap).get(uniqueId);
    }

    private static PlayerCapabilities getCapabilities5(EntityPlayer entityPlayer) {
        return entityPlayer.capabilities;
    }

    private static PBot getPbot201(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot202(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot203(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static double getMotionY(PBotPlayer instance) {
        return instance.motionY;
    }

    public void handleSpawnExperienceOrb(SPacketSpawnExperienceOrb packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot77(this).mc));
        double d0 = packetIn.getX();
        double d1 = packetIn.getY();
        double d2 = packetIn.getZ();
        EntityXPOrb entity = new EntityXPOrb((World)(this.pbot).getWorld(), d0, d1, d2, packetIn.getXPValue());
        (Entity)entity.rotationYaw = 0.0f;
        (Entity)entity.rotationPitch = 0.0f;
        entity.setEntityId(packetIn.getEntityID());
        (this.pbot).getWorld().addEntityToWorld(packetIn.getEntityID(), (Entity)entity);
    }

    public void handleTitle(SPacketTitle packetIn) {
        String text;
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot218(this).mc));
        if (packetIn.message != null && packetIn.getType().equals((Object)(SPacketTitle.Type.SUBTITLE)) && (text = PBot.stripColor((String)packetIn.message.getUnformattedText())).equalsIgnoreCase("Вы прошли проверку!")) {
            (this.pbot).setParameter("gameguardcheck", (Object)(true));
            ActionReplayRunner.trigger((PBot)(this.pbot), (String)"onGameGuard");
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = (this.pbot);
        objectArray[1] = packetIn;
        (Client.getInstance().pBotsScriptManager).invokeMethod("SPacketTitle", objectArray);
    }

    public void handleSetPassengers(SPacketSetPassengers packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot60(this).mc));
        Entity entity = (this.pbot).getWorld().getEntityByID(packetIn.getEntityId());
        if (entity != null) {
            entity.removePassengers();
            int[] nArray = packetIn.getPassengerIds();
            int n = nArray.length;
            for (int i = 0; i < n; ++i) {
                int i2 = nArray[i];
                Entity entity1 = (this.pbot).getWorld().getEntityByID(i2);
                if (entity1 == null) continue;
                entity1.startRiding(entity, true);
            }
        }
    }

    public void handleBlockChange(SPacketBlockChange packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot16(this).mc));
        (this.pbot).getWorld().invalidateRegionAndSetBlock(packetIn.getBlockPosition(), packetIn.getBlockState());
    }

    private static BooleanSetting getChat() {
        return BotDebugModule.chat;
    }

    private static PBot getPbot211(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer37(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot216(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot218(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot219(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleSignEditorOpen(SPacketSignEditorOpen packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot173(this).mc));
        TileEntity tileentity = (this.pbot).getWorld().getTileEntity(packetIn.getSignPosition());
        if (!(tileentity instanceof TileEntitySign)) {
            tileentity = new TileEntitySign();
            tileentity.setWorld((World)(this.pbot).getWorld());
            tileentity.setPos(packetIn.getSignPosition());
        }
        (PBotNetHandlerPlayClient.getPbot58(this).player).openEditSign((TileEntitySign)tileentity);
    }

    private static PBot getPbot220(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleSpawnMob(SPacketSpawnMob packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot251(this).mc));
        double d0 = packetIn.getX();
        double d1 = packetIn.getY();
        double d2 = packetIn.getZ();
        float f = (float)(packetIn.getYaw() * (360)) / 256.0f;
        float f1 = (float)(packetIn.getPitch() * (360)) / 256.0f;
        EntityLivingBase entitylivingbase = (EntityLivingBase)EntityList.createEntityByID((int)packetIn.getEntityType(), (World)(this.pbot).getWorld());
        if (entitylivingbase != null) {
            EntityTracker.updateServerPosition((Entity)entitylivingbase, (double)d0, (double)d1, (double)d2);
            entitylivingbase.renderYawOffset = (float)(packetIn.getHeadPitch() * (360)) / 256.0f;
            entitylivingbase.rotationYawHead = (float)(packetIn.getHeadPitch() * (360)) / 256.0f;
            Entity[] aentity = entitylivingbase.getParts();
            if (aentity != null) {
                int i = packetIn.getEntityID() - entitylivingbase.getEntityId();
                Entity[] entityArray = aentity;
                int n = entityArray.length;
                for (int j = 0; j < n; ++j) {
                    Entity entity = entityArray[j];
                    entity.setEntityId(entity.getEntityId() + i);
                }
            }
            entitylivingbase.setEntityId(packetIn.getEntityID());
            entitylivingbase.setUniqueId(packetIn.getUniqueId());
            entitylivingbase.setPositionAndRotation(d0, d1, d2, f, f1);
            entitylivingbase.motionX = (float)packetIn.getVelocityX() / 8000.0f;
            entitylivingbase.motionY = (float)packetIn.getVelocityY() / 8000.0f;
            entitylivingbase.motionZ = (float)packetIn.getVelocityZ() / 8000.0f;
            (this.pbot).getWorld().addEntityToWorld(packetIn.getEntityID(), (Entity)entitylivingbase);
            List list = packetIn.getDataManagerEntries();
            if (list != null) {
                entitylivingbase.getDataManager().setEntryValues(list);
            }
        } else {
            (LOGGER).warn("Skipping Entity with id {}", (Object)packetIn.getEntityType());
        }
    }

    public PBotNetworkManager getNetworkManager() {
        return (this.netManager);
    }

    private static PBot getPbot221(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot222(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleSelectAdvancementsTab(SPacketSelectAdvancementsTab packetIn) {
    }

    public void handlePlayerPosLook(SPacketPlayerPosLook packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot44(this).mc));
        PBotPlayer entityplayer = (PBotNetHandlerPlayClient.getPbot232(this).player);
        double d0 = packetIn.getX();
        double d1 = packetIn.getY();
        double d2 = packetIn.getZ();
        float f = packetIn.getYaw();
        float f1 = packetIn.getPitch();
        if (packetIn.getFlags().contains((SPacketPlayerPosLook.EnumFlags.X))) {
            d0 += ((EntityPlayer)entityplayer.posX);
        } else {
            (EntityPlayer)entityplayer.motionX = 0.0;
        }
        if (packetIn.getFlags().contains((SPacketPlayerPosLook.EnumFlags.Y))) {
            d1 += ((EntityPlayer)entityplayer.posY);
        } else {
            (EntityPlayer)entityplayer.motionY = 0.0;
        }
        if (packetIn.getFlags().contains((SPacketPlayerPosLook.EnumFlags.Z))) {
            d2 += ((EntityPlayer)entityplayer.posZ);
        } else {
            (EntityPlayer)entityplayer.motionZ = 0.0;
        }
        if (packetIn.getFlags().contains((SPacketPlayerPosLook.EnumFlags.X_ROT))) {
            f1 += ((EntityPlayer)entityplayer.rotationPitch);
        }
        if (packetIn.getFlags().contains((SPacketPlayerPosLook.EnumFlags.Y_ROT))) {
            f += ((EntityPlayer)entityplayer.rotationYaw);
        }
        entityplayer.setPositionAndRotation(d0, d1, d2, f, f1);
        (this.netManager).sendPacket((Packet)new CPacketConfirmTeleport(packetIn.getTeleportId()));
        (this.netManager).sendPacket((Packet)new CPacketPlayer.PositionRotation(((EntityPlayer)entityplayer.posX), (entityplayer.getEntityBoundingBox().minY), ((EntityPlayer)entityplayer.posZ), ((EntityPlayer)entityplayer.rotationYaw), ((EntityPlayer)entityplayer.rotationPitch), false));
        if (!(this.doneLoadingTerrain)) {
            PBotNetHandlerPlayClient.getPlayer4(PBotNetHandlerPlayClient.getPbot202(this)).prevPosX = PBotNetHandlerPlayClient.getPosX2(PBotNetHandlerPlayClient.getPlayer31(PBotNetHandlerPlayClient.getPbot245(this)));
            PBotNetHandlerPlayClient.getPlayer37(PBotNetHandlerPlayClient.getPbot239(this)).prevPosY = PBotNetHandlerPlayClient.getPosY4(PBotNetHandlerPlayClient.getPlayer28(PBotNetHandlerPlayClient.getPbot151(this)));
            PBotNetHandlerPlayClient.getPlayer15(PBotNetHandlerPlayClient.GafhjcwdgA(this)).prevPosZ = PBotNetHandlerPlayClient.getPosZ5(PBotNetHandlerPlayClient.getPlayer26(PBotNetHandlerPlayClient.getPbot128(this)));
            this.doneLoadingTerrain = true;
        }
    }

    private static Container getOpenContainer10(PBotPlayer instance) {
        return instance.openContainer;
    }

    private static BooleanSetting getRPskip() {
        return BotSettingsModule.RPskip;
    }

    private static double getPosZ5(PBotPlayer instance) {
        return instance.posZ;
    }

    private static PBot getPbot223(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleUseBed(SPacketUseBed packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot87(this).mc));
        try {
            (PBotNetHandlerPlayClient.getPbot224(this).player).trySleep(packetIn.getBedPosition());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static PBotPlayer getPlayer39(PBot instance) {
        return instance.player;
    }

    public void handleMaps(SPacketMaps packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot29(this).mc));
        try {
            MapData mapData = ItemMap.loadMapData((int)packetIn.getMapId(), (World)(this.pbot).getWorld());
            if (mapData == null) {
                String object = "map_" + packetIn.getMapId();
                mapData = new MapData(object);
                (this.pbot).getWorld().setData(object, (WorldSavedData)mapData);
            }
            packetIn.setMapdataTo(mapData);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static PBot getPbot224(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot226(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot227(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBotMinecraft getMc63(PBot instance) {
        return instance.mc;
    }

    private static PBot getPbot231(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static InventoryPlayer getInventory3(PBotPlayer instance) {
        return instance.inventory;
    }

    private static PBot getPbot232(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleCombatEvent(SPacketCombatEvent packetIn) {
    }

    public void handleTimeUpdate(SPacketTimeUpdate packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot197(this).mc));
        (this.pbot).getWorld().setTotalWorldTime(packetIn.getTotalWorldTime());
        (this.pbot).getWorld().setWorldTime(packetIn.getWorldTime());
    }

    private static PBot getPbot233(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static double getPosY4(PBotPlayer instance) {
        return instance.posY;
    }

    private static PBot getPbot234(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleEntityTeleport(SPacketEntityTeleport packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot165(this).mc));
        Entity entity = (this.pbot).getWorld().getEntityByID(packetIn.getEntityId());
        if (entity != null) {
            double d0 = packetIn.getX();
            double d1 = packetIn.getY();
            double d2 = packetIn.getZ();
            EntityTracker.updateServerPosition((Entity)entity, (double)d0, (double)d1, (double)d2);
            if (!entity.canPassengerSteer()) {
                float f = (float)(packetIn.getYaw() * (360)) / 256.0f;
                float f1 = (float)(packetIn.getPitch() * (360)) / 256.0f;
                if (Math.abs((entity.posX) - d0) < 0.03125 && Math.abs((entity.posY) - d1) < 0.015625 && Math.abs((entity.posZ) - d2) < 0.03125) {
                    entity.setPositionAndRotationDirect((entity.posX), (entity.posY), (entity.posZ), f, f1, 0, true);
                } else {
                    entity.setPositionAndRotationDirect(d0, d1, d2, f, f1, 3, true);
                }
                entity.onGround = packetIn.getOnGround();
            }
        }
    }

    public void handleOpenWindow(SPacketOpenWindow packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot169(this).mc));
        PBotPlayer entityplayersp = (PBotNetHandlerPlayClient.getPbot93(this).player);
        if (packetIn.getWindowTitle() != null) {
            PBotNetHandlerPlayClient.getPbot91(this).windowTitle = packetIn.getWindowTitle().getFormattedText();
        } else {
            PBotNetHandlerPlayClient.getPbot134(this).windowTitle = "";
        }
        if ("minecraft:container".equals(packetIn.getGuiId())) {
            entityplayersp.displayGUIChest((IInventory)new InventoryBasic(packetIn.getWindowTitle(), packetIn.getSlotCount()));
            PBotNetHandlerPlayClient.getOpenContainer(entityplayersp).windowId = packetIn.getWindowId();
        } else if ("minecraft:villager".equals(packetIn.getGuiId())) {
            entityplayersp.displayVillagerTradeGui((IMerchant)new NpcMerchant((EntityPlayer)entityplayersp, packetIn.getWindowTitle()));
            PBotNetHandlerPlayClient.getOpenContainer6(entityplayersp).windowId = packetIn.getWindowId();
        } else if ("EntityHorse".equals(packetIn.getGuiId())) {
            Entity entity = (this.pbot).getWorld().getEntityByID(packetIn.getEntityId());
            if (entity instanceof AbstractHorse) {
                entityplayersp.openGuiHorseInventory((AbstractHorse)entity, (IInventory)new ContainerHorseChest(packetIn.getWindowTitle(), packetIn.getSlotCount()));
                PBotNetHandlerPlayClient.getOpenContainer3(entityplayersp).windowId = packetIn.getWindowId();
            }
        } else if (!packetIn.hasSlots()) {
            entityplayersp.displayGui((IInteractionObject)new LocalBlockIntercommunication(packetIn.getGuiId(), packetIn.getWindowTitle()));
            PBotNetHandlerPlayClient.getOpenContainer10(entityplayersp).windowId = packetIn.getWindowId();
        } else {
            ContainerLocalMenu iinventory = new ContainerLocalMenu(packetIn.getGuiId(), packetIn.getWindowTitle(), packetIn.getSlotCount());
            entityplayersp.displayGUIChest((IInventory)iinventory);
            PBotNetHandlerPlayClient.getOpenContainer4(entityplayersp).windowId = packetIn.getWindowId();
        }
    }

    private static PBot getPbot237(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot239(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handlePlayerListItem(SPacketPlayerListItem packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot226(this).mc));
        for (SPacketPlayerListItem.AddPlayerData spacketplayerlistitem$addplayerdata : packetIn.getEntries()) {
            if (packetIn.getAction() == (SPacketPlayerListItem.Action.REMOVE_PLAYER)) {
                (this.playerInfoMap).remove(spacketplayerlistitem$addplayerdata.getProfile().getId());
                continue;
            }
            NetworkPlayerInfo networkplayerinfo = (NetworkPlayerInfo)(this.playerInfoMap).get(spacketplayerlistitem$addplayerdata.getProfile().getId());
            if (packetIn.getAction() == (SPacketPlayerListItem.Action.ADD_PLAYER)) {
                networkplayerinfo = new NetworkPlayerInfo(spacketplayerlistitem$addplayerdata);
                (this.playerInfoMap).put(networkplayerinfo.getGameProfile().getId(), networkplayerinfo);
            }
            if (networkplayerinfo == null) continue;
            switch ((PlayerListActionSwitchMap.$SwitchMap$net$minecraft$network$play$server$SPacketPlayerListItem$Action)[packetIn.getAction().ordinal()]) {
                case 1: {
                    networkplayerinfo.setGameType(spacketplayerlistitem$addplayerdata.getGameMode());
                    networkplayerinfo.setResponseTime(spacketplayerlistitem$addplayerdata.getPing());
                    break;
                }
                case 2: {
                    networkplayerinfo.setGameType(spacketplayerlistitem$addplayerdata.getGameMode());
                    break;
                }
                case 3: {
                    networkplayerinfo.setResponseTime(spacketplayerlistitem$addplayerdata.getPing());
                    break;
                }
            }
        }
    }

    public void handleSetSlot(SPacketSetSlot packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot34(this).mc));
        PBotPlayer entityplayer = (PBotNetHandlerPlayClient.getPbot63(this).player);
        ItemStack itemstack = packetIn.getStack();
        int i = packetIn.getSlot();
        if (packetIn.getWindowId() == (-1)) {
            ((EntityPlayer)entityplayer.inventory).setItemStack(itemstack);
        } else if (packetIn.getWindowId() == (-2)) {
            ((EntityPlayer)entityplayer.inventory).setInventorySlotContents(i, itemstack);
        } else {
            int flag = 0;
            if (packetIn.getWindowId() == 0 && packetIn.getSlot() >= (36) && i < (45)) {
                ItemStack itemstack1;
                if (!itemstack.isEmpty() && ((itemstack1 = ((EntityPlayer)entityplayer.inventoryContainer).getSlot(i).getStack()).isEmpty() || itemstack1.getCount() < itemstack.getCount())) {
                    itemstack.setAnimationsToGo(5);
                }
                ((EntityPlayer)entityplayer.inventoryContainer).putStackInSlot(i, itemstack);
            } else if (packetIn.getWindowId() == (PBotNetHandlerPlayClient.getOpenContainer9((EntityPlayer)entityplayer).windowId) && (packetIn.getWindowId() != 0 || flag == 0)) {
                ((EntityPlayer)entityplayer.openContainer).putStackInSlot(i, itemstack);
            }
        }
    }

    private static PBot getPbot241(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleEntityVelocity(SPacketEntityVelocity packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot113(this).mc));
        if (packetIn.getEntityID() != (PBotNetHandlerPlayClient.getPbot26(this).player).getEntityId()) {
            return;
        }
        (PBotNetHandlerPlayClient.getPbot216(this).player).setVelocity((double)packetIn.getMotionX() / 8000.0, (double)packetIn.getMotionY() / 8000.0, (double)packetIn.getMotionZ() / 8000.0);
    }

    public void handleWindowProperty(SPacketWindowProperty packetIn) {
    }

    private static PBotPlayer getPlayer41(PBot instance) {
        return instance.player;
    }

    public void handleEntityMetadata(SPacketEntityMetadata packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot162(this).mc));
        Entity entity = (this.pbot).getWorld().getEntityByID(packetIn.getEntityId());
        if (entity != null && packetIn.getDataManagerEntries() != null) {
            entity.getDataManager().setEntryValues(packetIn.getDataManagerEntries());
        }
    }

    private static PBotMinecraft getMc67(PBot instance) {
        return instance.mc;
    }

    private static PBot getPbot244(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public PBotNetHandlerPlayClient(PBot bot) {
        this.currentServerMaxPlayers = 20;
        this.pbot = bot;
        this.netManager = this.pbot.getNetworkManager();
        this.profile = this.pbot.getSession().getProfile();
        this.pbot.setPlayHandler(this);
    }

    private static PBot getPbot245(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static TextSetting getMessage() {
        return ActionRecorderModule.message;
    }

    private static PBot getPbot246(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    public void handleSpawnObject(SPacketSpawnObject packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)(PBotNetHandlerPlayClient.getPbot200(this).mc));
        double d0 = packetIn.getX();
        double d2 = packetIn.getY();
        double d3 = packetIn.getZ();
        EntityMinecart entity = null;
        if (packetIn.getType() == (10)) {
            entity = EntityMinecart.create((World)(this.pbot).getWorld(), (double)d0, (double)d2, (double)d3, (EntityMinecart.Type)EntityMinecart.Type.getById((int)packetIn.getData()));
        } else if (packetIn.getType() == (90)) {
            Entity entity2 = (this.pbot).getWorld().getEntityByID(packetIn.getData());
            if (entity2 instanceof EntityPlayer) {
                entity = new EntityFishHook((World)(this.pbot).getWorld(), (EntityPlayer)entity2, d0, d2, d3);
            }
            packetIn.setData(0);
        } else if (packetIn.getType() == (60)) {
            entity = new EntityTippedArrow((World)(this.pbot).getWorld(), d0, d2, d3);
        } else if (packetIn.getType() == (91)) {
            entity = new EntitySpectralArrow((World)(this.pbot).getWorld(), d0, d2, d3);
        } else if (packetIn.getType() == (61)) {
            entity = new EntitySnowball((World)(this.pbot).getWorld(), d0, d2, d3);
        } else if (packetIn.getType() == (68)) {
            entity = new EntityLlamaSpit((World)(this.pbot).getWorld(), d0, d2, d3, (double)packetIn.getSpeedX() / 8000.0, (double)packetIn.getSpeedY() / 8000.0, (double)packetIn.getSpeedZ() / 8000.0);
        } else if (packetIn.getType() == (71)) {
            entity = new EntityItemFrame((World)(this.pbot).getWorld(), new BlockPos(d0, d2, d3), EnumFacing.byHorizontalIndex((int)packetIn.getData()));
            packetIn.setData(0);
        } else if (packetIn.getType() == (77)) {
            entity = new EntityLeashKnot((World)(this.pbot).getWorld(), new BlockPos(MathHelper.floor((double)d0), MathHelper.floor((double)d2), MathHelper.floor((double)d3)));
            packetIn.setData(0);
        } else if (packetIn.getType() == (65)) {
            entity = new EntityEnderPearl((World)(this.pbot).getWorld(), d0, d2, d3);
        } else if (packetIn.getType() == (72)) {
            entity = new EntityEnderEye((World)(this.pbot).getWorld(), d0, d2, d3);
        } else if (packetIn.getType() == (76)) {
            entity = new EntityFireworkRocket((World)(this.pbot).getWorld(), d0, d2, d3, (ItemStack.EMPTY));
        } else if (packetIn.getType() == (63)) {
            entity = new EntityLargeFireball((World)(this.pbot).getWorld(), d0, d2, d3, (double)packetIn.getSpeedX() / 8000.0, (double)packetIn.getSpeedY() / 8000.0, (double)packetIn.getSpeedZ() / 8000.0);
            packetIn.setData(0);
        } else if (packetIn.getType() == (93)) {
            entity = new EntityDragonFireball((World)(this.pbot).getWorld(), d0, d2, d3, (double)packetIn.getSpeedX() / 8000.0, (double)packetIn.getSpeedY() / 8000.0, (double)packetIn.getSpeedZ() / 8000.0);
            packetIn.setData(0);
        } else if (packetIn.getType() == (64)) {
            entity = new EntitySmallFireball((World)(this.pbot).getWorld(), d0, d2, d3, (double)packetIn.getSpeedX() / 8000.0, (double)packetIn.getSpeedY() / 8000.0, (double)packetIn.getSpeedZ() / 8000.0);
            packetIn.setData(0);
        } else if (packetIn.getType() == (66)) {
            entity = new EntityWitherSkull((World)(this.pbot).getWorld(), d0, d2, d3, (double)packetIn.getSpeedX() / 8000.0, (double)packetIn.getSpeedY() / 8000.0, (double)packetIn.getSpeedZ() / 8000.0);
            packetIn.setData(0);
        } else if (packetIn.getType() == (67)) {
            entity = new EntityShulkerBullet((World)(this.pbot).getWorld(), d0, d2, d3, (double)packetIn.getSpeedX() / 8000.0, (double)packetIn.getSpeedY() / 8000.0, (double)packetIn.getSpeedZ() / 8000.0);
            packetIn.setData(0);
        } else if (packetIn.getType() == (62)) {
            entity = new EntityEgg((World)(this.pbot).getWorld(), d0, d2, d3);
        } else if (packetIn.getType() == (79)) {
            entity = new EntityEvokerFangs((World)(this.pbot).getWorld(), d0, d2, d3, 0.0f, 0, (EntityLivingBase)null);
        } else if (packetIn.getType() == (73)) {
            entity = new EntityPotion((World)(this.pbot).getWorld(), d0, d2, d3, (ItemStack.EMPTY));
            packetIn.setData(0);
        } else if (packetIn.getType() == (75)) {
            entity = new EntityExpBottle((World)(this.pbot).getWorld(), d0, d2, d3);
            packetIn.setData(0);
        } else if (packetIn.getType() == (1)) {
            entity = new EntityBoat((World)(this.pbot).getWorld(), d0, d2, d3);
        } else if (packetIn.getType() == (50)) {
            entity = new EntityTNTPrimed((World)(this.pbot).getWorld(), d0, d2, d3, (EntityLivingBase)null);
        } else if (packetIn.getType() == (78)) {
            entity = new EntityArmorStand((World)(this.pbot).getWorld(), d0, d2, d3);
        } else if (packetIn.getType() == (51)) {
            entity = new EntityEnderCrystal((World)(this.pbot).getWorld(), d0, d2, d3);
        } else if (packetIn.getType() == (2)) {
            entity = new EntityItem((World)(this.pbot).getWorld(), d0, d2, d3);
        } else if (packetIn.getType() == (70)) {
            entity = new EntityFallingBlock((World)(this.pbot).getWorld(), d0, d2, d3, Block.getStateById((int)(packetIn.getData() & (65535))));
            packetIn.setData(0);
        } else if (packetIn.getType() == (3)) {
            entity = new EntityAreaEffectCloud((World)(this.pbot).getWorld(), d0, d2, d3);
        }
        if (entity != null) {
            EntityTracker.updateServerPosition((Entity)entity, (double)d0, (double)d2, (double)d3);
            (Entity)entity.rotationPitch = (float)(packetIn.getPitch() * (360)) / 256.0f;
            (Entity)entity.rotationYaw = (float)(packetIn.getYaw() * (360)) / 256.0f;
            Entity[] aentity = entity.getParts();
            if (aentity != null) {
                int i = packetIn.getEntityID() - entity.getEntityId();
                Entity[] array = aentity;
                int length = aentity.length;
                for (int j = 0; j < length; ++j) {
                    Entity entity3 = array[j];
                    entity3.setEntityId(entity3.getEntityId() + i);
                }
            }
            entity.setEntityId(packetIn.getEntityID());
            entity.setUniqueId(packetIn.getUniqueId());
            (this.pbot).getWorld().addEntityToWorld(packetIn.getEntityID(), (Entity)entity);
            if (packetIn.getData() > 0) {
                Entity entity4;
                if ((packetIn.getType() == (60) || packetIn.getType() == (91)) && (entity4 = (this.pbot).getWorld().getEntityByID(packetIn.getData() - (1))) instanceof EntityLivingBase && entity instanceof EntityArrow) {
                    (EntityArrow)entity4.shootingEntity = entity4;
                }
                entity.setVelocity((double)packetIn.getSpeedX() / 8000.0, (double)packetIn.getSpeedY() / 8000.0, (double)packetIn.getSpeedZ() / 8000.0);
            }
        }
    }

    public void handleRecipeBook(SPacketRecipeBook packetIn) {
    }

    private static PBot getPbot247(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

    private static PBot getPbot251(PBotNetHandlerPlayClient instance) {
        return instance.pbot;
    }

}

