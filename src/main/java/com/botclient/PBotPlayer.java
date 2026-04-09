/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  com.google.common.collect.Sets
 *  javax.annotation.Nullable
 *  neo.deobf.Client
 *  neo.deobf.PBot
 *  neo.deobf.BotKeyState
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.PBotNetHandlerPlayClient
 *  neo.deobf.PBotPlayerController
 *  neo.deobf.ScriptManager
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.network.PlayerListEntry
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.// IJumpingMount removed
 *  net.minecraft.village.Merchant
 *  net.minecraft.entity.MovementType
 *  net.minecraft.entity.BoatEntity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.HorseEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.PlayerEntity$EnumChatVisibility
 *  net.minecraft.entity.player.PlayerModelPart
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.entity.player.// PlayerCapabilities removed - use GameMode
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.BeaconScreenHandler
 *  net.minecraft.screen.BrewingStandScreenHandler
 *  net.minecraft.screen.GenericScreenHandlerScreenHandler
 *  net.minecraft.screen.DispenserScreenHandler
 *  net.minecraft.screen.EnchantmentScreenHandler
 *  net.minecraft.screen.FurnaceScreenHandler
 *  net.minecraft.screen.HopperScreenHandler
 *  net.minecraft.screen.HorseScreenHandler
 *  net.minecraft.screen.MerchantScreenHandler
 *  net.minecraft.screen.ScreenHandlerRepair
 *  net.minecraft.screen.ShulkerBoxScreenHandler
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ElytraItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.Recipe
 *  net.minecraft.network.Packet
 *  net.minecraft.network.datasync.TrackedData
 *  net.minecraft.network.datasync.DataTracker
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.ChatMessageC2SPacket
 *  net.minecraft.network.play.client.CPacketClientSettings
 *  net.minecraft.network.play.client.CPacketClientStatus
 *  net.minecraft.network.play.client.CPacketClientStatus$State
 *  net.minecraft.network.play.client.CloseHandledScreenC2SPacket
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketInput
 *  net.minecraft.network.play.client.PlayerMoveC2SPacket
 *  net.minecraft.network.play.client.PlayerMoveC2SPacket$Position
 *  net.minecraft.network.play.client.PlayerMoveC2SPacket$PositionRotation
 *  net.minecraft.network.play.client.PlayerMoveC2SPacket$Rotation
 *  net.minecraft.network.play.client.PlayerAbilitiesC2SPacket
 *  net.minecraft.network.play.client.PlayerActionC2SPacket
 *  net.minecraft.network.play.client.PlayerActionC2SPacket$Action
 *  net.minecraft.network.play.client.CPacketRecipeInfo
 *  net.minecraft.network.play.client.CPacketVehicleMove
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.stats.RecipeBook
 *  net.minecraft.stats.Statistic
 *  net.minecraft.stats.StatHandler
 *  net.minecraft.tileentity.CommandBlockBaseLogic
 *  net.minecraft.tileentity.TileEntityCommandBlock
 *  net.minecraft.tileentity.TileEntitySign
 *  net.minecraft.tileentity.TileEntityStructure
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.Hand
 *  net.minecraft.util.Arm
 *  net.minecraft.util.// MovementInput removed - use Input
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec2f
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.text.Text
 *  net.minecraft.world.GameMode
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.NamedScreenHandlerFactory
 *  net.minecraft.world.World
 */
package com.botclient;

import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import com.botclient.Client;
import com.botclient.PBot;
import com.botclient.BotKeyState;
import com.botclient.PBotMinecraft;
import com.botclient.PBotNetHandlerPlayClient;
import com.botclient.PBotPlayerController;
import com.botclient.ScriptManager;
import net.minecraft.block.BlockState;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.Entity;
// Removed
import net.minecraft.village.Merchant;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerEntity.PlayerModelPart;
import net.minecraft.entity.player.PlayerInventory;
// Removed: // PlayerCapabilities removed - use GameMode replaced
import net.minecraft.registry.Registries;
import net.minecraft.item.Items;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.BeaconScreenHandler;
import net.minecraft.screen.BrewingStandScreenHandler;
import net.minecraft.screen.GenericScreenHandlerScreenHandler;
import net.minecraft.screen.DispenserScreenHandler;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.HopperScreenHandler;
import net.minecraft.screen.HorseScreenHandler;
import net.minecraft.screen.MerchantScreenHandler;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.ShulkerBoxScreenHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.network.packet.Packet;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.network.packet.c2s.play.PlayerAbilitiesC2SPacket;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.recipe.book.RecipeBook;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
// Removed: CommandBlockBaseLogic changed in 1.21.4
// Removed: TileEntity not used directly in 1.21.4
// Removed: TileEntity not used directly in 1.21.4
// Removed: TileEntity not used directly in 1.21.4
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Arm;
// Use Keyboard/Input
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import net.minecraft.world.BlockView;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PBotPlayer
extends PlayerEntity {
    public float prevTimeInPortal;
    public double lastReportedPosZ;
    public float renderArmYaw;
    public int permissionLevel;
    public boolean rowingBoat;
    public boolean serverSprintState;
    public float prevRenderArmYaw;
    public float horseJumpPower;
    public String serverBrand;
    public int sprintingTicksLeft;
    public final PBotMinecraft mc;
    public final PBot pbot;
    public final PBotNetHandlerPlayClient connection;
    public float prevRenderArmPitch;
    public boolean autoJumpEnabled;
    public int sprintToggleTimer;
    public int horseJumpPowerCounter;
    public Hand activeHand;
    public final Set<PlayerModelPart> setModelParts = Sets.newHashSet((Object[])PlayerModelPart.values());
    public final RecipeBook recipeBook;
    public int autoJumpTime;
    public float lastReportedYaw;
    public boolean handActive;
    public final StatHandler statWriter;
    public float lastReportedPitch;
    public double lastReportedPosY;
    public boolean hasValidHealth;
    public float timeInPortal;
    public boolean wasFallFlying;
    public boolean prevOnGround;
    public int positionUpdateTicks;
    public double lastReportedPosX;
    public float renderArmPitch;
    public // MovementInput removed - use Input movementInput;
    public boolean serverSneakState;

    public int getPermissionLevel() {
        return (this.permissionLevel);
    }

    private static boolean getLeftKeyDown(// MovementInput removed - use Input movementInput) {
        return movementInput.leftKeyDown;
    }

    private static int getMaxHurtResistantTime(PBotPlayer instance) {
        return instance.maxHurtResistantTime;
    }

    private static double getMinY(AxisAlignedBB axisAlignedBB) {
        return axisAlignedBB.minY;
    }

    private static BotKeyState getGameOptions(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    public void setPermissionLevel(int p_184839_1_) {
        this.permissionLevel = p_184839_1_;
    }

    private static // PlayerCapabilities removed - use GameMode getCapabilities(PBotPlayer instance) {
        return instance.capabilities;
    }

    public float getHorseJumpPower() {
        return (this.horseJumpPower);
    }

    public void respawnPlayer() {
        (this.connection).sendPacket((Packet)new CPacketClientStatus((CPacketClientStatus.State.PERFORM_RESPAWN)));
    }

    private static boolean getBackKeyDown(// MovementInput removed - use Input movementInput) {
        return movementInput.backKeyDown;
    }

    private static int getPositionUpdateTicks(PBotPlayer instance) {
        return instance.positionUpdateTicks;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static boolean getForwardKeyDown(// MovementInput removed - use Input movementInput) {
        return movementInput.forwardKeyDown;
    }

    public boolean isHandActive() {
        return (this.handActive);
    }

    public boolean isRowingBoat() {
        return (this.rowingBoat);
    }

    private static double getMotionY(PBotPlayer instance) {
        return instance.motionY;
    }

    private static PlayerInventory getInventory(PBotPlayer instance) {
        return instance.inventory;
    }

    private static double getPosX2(PBotPlayer instance) {
        return instance.posX;
    }

    private static // PlayerCapabilities removed - use GameMode getCapabilities3(PBotPlayer instance) {
        return instance.capabilities;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input2(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static boolean getJump(// MovementInput removed - use Input movementInput) {
        return movementInput.jump;
    }

    private static int getPermissionLevel(PBotPlayer instance) {
        return instance.permissionLevel;
    }

    public void removeRecipeHighlight(Recipe p_193103_1_) {
        if ((this.recipeBook).isNew(p_193103_1_)) {
            (this.recipeBook).markSeen(p_193103_1_);
            (this.connection).sendPacket((Packet)new CPacketRecipeInfo(p_193103_1_));
        }
    }

    public void openGuiHorseInventory(AbstractHorse horse, IInventory inventoryIn) {
        this.openScreenHandler = (ScreenHandler)new ScreenHandlerHorseInventory((IInventory)PBotPlayer.getInventory10(this), inventoryIn, horse, (PlayerEntity)this);
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input3(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input4(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static float getRenderArmPitch(PBotPlayer instance) {
        return instance.renderArmPitch;
    }

    public void updateRidden() {
        super.updateRidden();
        this.rowingBoat = false;
        if (this.getRidingEntity() instanceof EntityBoat) {
            EntityBoat entityboat = (EntityBoat)this.getRidingEntity();
            entityboat.updateInputs((PBotPlayer.get// MovementInput removed - use Input3(this).leftKeyDown), (PBotPlayer.get// MovementInput removed - use Input16(this).rightKeyDown), (PBotPlayer.get// MovementInput removed - use Input17(this).forwardKeyDown), (PBotPlayer.get// MovementInput removed - use Input11(this).backKeyDown));
            PBotPlayer cD = this;
            cD.rowingBoat = (PBotPlayer.getRowingBoat2(cD) | (PBotPlayer.getLeftKeyDown(PBotPlayer.get// MovementInput removed - use Input10(this)) || PBotPlayer.getRightKeyDown2(PBotPlayer.get// MovementInput removed - use Input15(this)) || PBotPlayer.getForwardKeyDown(PBotPlayer.get// MovementInput removed - use Input2(this)) || PBotPlayer.getBackKeyDown(PBotPlayer.get// MovementInput removed - use Input13(this)) ? 1 : 0)) != 0;
        }
    }

    private static float getMoveStrafe(// MovementInput removed - use Input movementInput) {
        return movementInput.moveStrafe;
    }

    public String getServerBrand() {
        return (this.serverBrand);
    }

    public void heal(float healAmount) {
    }

    public void sendSettingsToServer() {
        if ((PBotPlayer.getPbot2(this).player) != null) {
            int i = 0;
            for (PlayerModelPart enumplayermodelparts : (this.setModelParts)) {
                i |= enumplayermodelparts.getPartMask();
            }
            (this.pbot).sendPacket((Packet)new CPacketClientSettings("en_us", 4, (PlayerEntity.EnumChatVisibility.FULL), true, i, (Arm.RIGHT)));
        }
    }

    protected void updateAutoJump(float p_189810_1_, float p_189810_2_) {
        Vec2f vec2f;
        if (this.isAutoJumpEnabled() && (this.autoJumpTime) <= 0 && (this.onGround) && !this.isSneaking() && !this.isRiding() && ((vec2f = PBotPlayer.get// MovementInput removed - use Input23(this).getMoveVector().x) != 0.0f || (vec2f.y) != 0.0f)) {
            Vec3d vec3d = new Vec3d((this.posX), (this.getEntityBoundingBox().minY), (this.posZ));
            double d0 = (this.posX) + (double)p_189810_1_;
            double d1 = (this.posZ) + (double)p_189810_2_;
            Vec3d vec3d1 = new Vec3d(d0, (this.getEntityBoundingBox().minY), d1);
            Vec3d vec3d2 = new Vec3d((double)p_189810_1_, 0.0, (double)p_189810_2_);
            float f = this.getAIMoveSpeed();
            float f1 = (float)vec3d2.lengthSquared();
            if (f1 <= 0.00100000005f) {
                float f2 = f * (vec2f.x);
                float f3 = f * (vec2f.y);
                float f4 = MathHelper.sin((float)((this.rotationYaw) * 0.0174532924f));
                float f5 = MathHelper.cos((float)((this.rotationYaw) * 0.0174532924f));
                vec3d2 = new Vec3d((double)(f2 * f5 - f3 * f4), (vec3d2.y), (double)(f3 * f5 + f2 * f4));
                f1 = (float)vec3d2.lengthSquared();
                if (f1 <= 0.00100000005f) {
                    return;
                }
            }
            float f12 = (float)MathHelper.fastInvSqrt((double)f1);
            Vec3d vec3d12 = vec3d2.scale((double)f12);
            Vec3d vec3d13 = this.getForward();
            float f13 = (float)((vec3d13.x) * (vec3d12.x) + (vec3d13.z) * (vec3d12.z));
            if (f13 >= -0.150000036f) {
                BlockPos blockpos = new BlockPos((this.posX), (this.getEntityBoundingBox().maxY), (this.posZ));
                BlockState iblockstate = (this.world).getBlockState(blockpos);
                if (iblockstate.getCollisionBoundingBox((IBlockAccess)(this.world), blockpos) == null) {
                    blockpos = blockpos.up();
                    BlockState iblockstate1 = (this.world).getBlockState(blockpos);
                    if (iblockstate1.getCollisionBoundingBox((IBlockAccess)(this.world), blockpos) == null) {
                        float f14;
                        float f7 = 1.20000005f;
                        if (this.isPotionActive((MobEffects.JUMP_BOOST))) {
                            f7 += (float)(this.getActivePotionEffect((MobEffects.JUMP_BOOST)).getAmplifier() + (1)) * 0.75f;
                        }
                        float f8 = Math.max(f * 7.0f, 1.0f / f12);
                        Vec3d vec3d4 = vec3d1.add(vec3d12.scale((double)f8));
                        float f9 = (this.width);
                        float f10 = (this.height);
                        AxisAlignedBB axisalignedbb = new AxisAlignedBB(vec3d, vec3d4.add(0.0, (double)f10, 0.0)).grow((double)f9, 0.0, (double)f9);
                        Vec3d lvt_19_1_ = vec3d.add(0.0, 0.50999999046325684, 0.0);
                        vec3d4 = vec3d4.add(0.0, 0.50999999046325684, 0.0);
                        Vec3d vec3d5 = vec3d12.crossProduct(new Vec3d(0.0, 1.0, 0.0));
                        Vec3d vec3d6 = vec3d5.scale((double)(f9 * 0.5f));
                        Vec3d vec3d7 = lvt_19_1_.subtract(vec3d6);
                        Vec3d vec3d8 = vec3d4.subtract(vec3d6);
                        Vec3d vec3d9 = lvt_19_1_.add(vec3d6);
                        Vec3d vec3d10 = vec3d4.add(vec3d6);
                        List list = (this.world).getCollisionBoxes((Entity)this, axisalignedbb);
                        if (!list.isEmpty()) {
                            // empty if block
                        }
                        float f11 = 1.40129846E-45f;
                        for (AxisAlignedBB axisalignedbb2 : list) {
                            if (!axisalignedbb2.intersects(vec3d7, vec3d8) && !axisalignedbb2.intersects(vec3d9, vec3d10)) continue;
                            f11 = (float)(axisalignedbb2.maxY);
                            Vec3d vec3d11 = axisalignedbb2.getCenter();
                            BlockPos blockpos1 = new BlockPos(vec3d11);
                            int i = 1;
                            while (!((float)i >= f7)) {
                                BlockPos blockpos2 = blockpos1.up(i);
                                BlockState iblockstate2 = (this.world).getBlockState(blockpos2);
                                AxisAlignedBB axisalignedbb1 = iblockstate2.getCollisionBoundingBox((IBlockAccess)(this.world), blockpos2);
                                if (axisalignedbb1 != null && (double)(f11 = (float)(axisalignedbb1.maxY) + (float)blockpos2.getY()) - (this.getEntityBoundingBox().minY) > (double)f7) {
                                    return;
                                }
                                if (i > (1)) {
                                    blockpos = blockpos.up();
                                    BlockState iblockstate3 = (this.world).getBlockState(blockpos);
                                    if (iblockstate3.getCollisionBoundingBox((IBlockAccess)(this.world), blockpos) != null) {
                                        return;
                                    }
                                }
                                ++i;
                            }
                            break block0;
                        }
                        if (f11 != 1.40129846E-45f && (f14 = (float)((double)f11 - (this.getEntityBoundingBox().minY))) > 0.5f && f14 <= f7) {
                            this.autoJumpTime = 1;
                        }
                    }
                }
            }
        }
    }

    private static int getHorseJumpPowerCounter2(PBotPlayer instance) {
        return instance.horseJumpPowerCounter;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input5(PBotPlayer instance) {
        return instance.movementInput;
    }

    public void setXPStats(float currentXP, int maxXP, int level) {
        this.experience = currentXP;
        this.experienceTotal = maxXP;
        this.experienceLevel = level;
    }

    private static void setPermissionLevel(PBotPlayer instance, int n) {
        instance.permissionLevel = n;
    }

    public void playSound(SoundEvent soundIn, float volume, float pitch) {
    }

    public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
        this.posX = MathHelper.clamp((double)x, (double)-30000000.0, (double)30000000.0);
        this.posY = y;
        this.posZ = MathHelper.clamp((double)z, (double)-30000000.0, (double)30000000.0);
        this.prevPosX = PBotPlayer.getPosX2(this);
        this.prevPosY = PBotPlayer.getPosY4(this);
        this.prevPosZ = PBotPlayer.getPosZ3(this);
        pitch = MathHelper.clamp((float)pitch, (float)-90.0000305f, (float)90.0f);
        this.rotationYaw = yaw;
        this.rotationPitch = pitch;
        this.prevRotationYaw = PBotPlayer.getRotationYaw13(this);
        this.prevRotationPitch = PBotPlayer.getRotationPitch6(this);
        double d0 = (this.prevRotationYaw) - yaw;
        if (d0 < -180.0) {
            PBotPlayer cD = this;
            cD.prevRotationYaw = PBotPlayer.getPrevRotationYaw2(cD) + 360.0f;
        }
        if (d0 >= 180.0) {
            PBotPlayer cD = this;
            cD.prevRotationYaw = PBotPlayer.getPrevRotationYaw(cD) - 360.0f;
        }
        this.setPosition((this.posX), (this.posY), (this.posZ));
        this.setRotation(yaw, pitch);
    }

    private static int getMaxHurtResistantTime2(PBotPlayer instance) {
        return instance.maxHurtResistantTime;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input7(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static float getMoveForward(// MovementInput removed - use Input movementInput) {
        return movementInput.moveForward;
    }

    private static int getHorseJumpPowerCounter3(PBotPlayer instance) {
        return instance.horseJumpPowerCounter;
    }

    public void displayGuiEditCommandCart(CommandBlockBaseLogic commandBlock) {
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input8(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static boolean getOnGround3(PBotPlayer instance) {
        return instance.onGround;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input9(PBotPlayer instance) {
        return instance.movementInput;
    }

    public void addStat(Statistic stat, int amount) {
        if (stat != null && (stat.isIndependent)) {
            super.addStat(stat, amount);
        }
    }

    private static double getPosZ(PBotPlayer instance) {
        return instance.posZ;
    }

    private static RecipeBook getRecipeBook(PBotPlayer instance) {
        return instance.recipeBook;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input10(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input11(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static // PlayerCapabilities removed - use GameMode getCapabilities4(PBotPlayer instance) {
        return instance.capabilities;
    }

    private static double getPosY4(PBotPlayer instance) {
        return instance.posY;
    }

    private static int getTimeUntilPortal2(PBotPlayer instance) {
        return instance.timeUntilPortal;
    }

    protected ItemStack dropItemAndGetStack(EntityItem p_184816_1_) {
        return (ItemStack.EMPTY);
    }

    private static float getRenderArmPitch2(PBotPlayer instance) {
        return instance.renderArmPitch;
    }

    public void closeScreen() {
        (this.connection).sendPacket((Packet)new CloseHandledScreenC2SPacket((PBotPlayer.getOpenScreenHandler(this).windowId)));
        this.closeScreenAndDropStack();
    }

    private static PlayerInventory getInventory2(PBotPlayer instance) {
        return instance.inventory;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input13(PBotPlayer instance) {
        return instance.movementInput;
    }

    private boolean callGetWorld2(BlockPos pos) {
        return (!(this.world).getBlockState(pos).isNormalCube() && !(this.world).getBlockState(pos.up()).isNormalCube() ? 1 : 0) != 0;
    }

    @Nullable
    public EntityItem dropItem(boolean dropAll) {
        PlayerActionC2SPacket.Action cpacketplayerdigging$action = dropAll ? (PlayerActionC2SPacket.Action.DROP_ALL_ITEMS) : (PlayerActionC2SPacket.Action.DROP_ITEM);
        (this.connection).sendPacket((Packet)new PlayerActionC2SPacket(cpacketplayerdigging$action, (BlockPos.ORIGIN), (Direction.DOWN)));
        return null;
    }

    private static int getAutoJumpTime(PBotPlayer instance) {
        return instance.autoJumpTime;
    }

    private static float getPrevRotationYaw(PBotPlayer instance) {
        return instance.prevRotationYaw;
    }

    public void onUpdate() {
        if ((this.world).isBlockLoaded(new BlockPos((this.posX), 0.0, (this.posZ)))) {
            super.onUpdate();
            if (this.isRiding()) {
                (this.connection).sendPacket((Packet)new PlayerMoveC2SPacket.Rotation((this.rotationYaw), (this.rotationPitch), (this.onGround)));
                (this.connection).sendPacket((Packet)new CPacketInput((this.moveStrafing), (this.moveVertical), (PBotPlayer.get// MovementInput removed - use Input(this).jump), (PBotPlayer.get// MovementInput removed - use Input35(this).sneak)));
                Entity entity = this.getLowestRidingEntity();
                if (entity != this && entity.canPassengerSteer()) {
                    (this.connection).sendPacket((Packet)new CPacketVehicleMove(entity));
                }
            } else {
                this.callIsSprinting();
            }
        }
    }

    private static // PlayerCapabilities removed - use GameMode getCapabilities5(PBotPlayer instance) {
        return instance.capabilities;
    }

    private static double getPosZ3(PBotPlayer instance) {
        return instance.posZ;
    }

    public void sendChatMessage(String message) {
        (this.connection).sendPacket((Packet)new ChatMessageC2SPacket(message));
    }

    public boolean isAutoJumpEnabled() {
        return (this.autoJumpEnabled);
    }

    private static float getMoveStrafe2(// MovementInput removed - use Input movementInput) {
        return movementInput.moveStrafe;
    }

    private static PBotMinecraft getMc(PBotPlayer instance) {
        return instance.mc;
    }

    public void setRotation(float yaw, float pitch) {
        this.rotationYaw = yaw % 360.0f;
        this.rotationPitch = pitch % 360.0f;
    }

    private static boolean getRowingBoat2(PBotPlayer instance) {
        return instance.rowingBoat;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input14(PBotPlayer instance) {
        return instance.movementInput;
    }

    protected boolean pushOutOfBlocks(double x, double y, double z) {
        if ((this.noClip)) {
            return false;
        }
        BlockPos blockpos = new BlockPos(x, y, z);
        double d0 = x - (double)blockpos.getX();
        double d1 = z - (double)blockpos.getZ();
        if (!this.callGetWorld2(blockpos)) {
            int i = -1;
            double d2 = 9999.0;
            if (this.callGetWorld2(blockpos.west()) && d0 < d2) {
                d2 = d0;
                i = 0;
            }
            if (this.callGetWorld2(blockpos.east()) && 1.0 - d0 < d2) {
                d2 = 1.0 - d0;
                i = 1;
            }
            if (this.callGetWorld2(blockpos.north()) && d1 < d2) {
                d2 = d1;
                i = 4;
            }
            if (this.callGetWorld2(blockpos.south()) && 1.0 - d1 < d2) {
                d2 = 1.0 - d1;
                i = 5;
            }
            if (i == 0) {
                this.motionX = -0.10000000149011612;
            }
            if (i == (1)) {
                this.motionX = 0.10000000149011612;
            }
            if (i == (4)) {
                this.motionZ = -0.10000000149011612;
            }
            if (i == (5)) {
                this.motionZ = 0.10000000149011612;
            }
        }
        return false;
    }

    private static float getMoveForward3(// MovementInput removed - use Input movementInput) {
        return movementInput.moveForward;
    }

    public boolean isSneaking() {
        int flag = (this.movementInput) != null && (PBotPlayer.get// MovementInput removed - use Input25(this).sneak) ? 1 : 0;
        return (flag != 0 && !(this.sleeping) ? 1 : 0) != 0;
    }

    private static World getWorld6(PBotPlayer instance) {
        return instance.world;
    }

    private static boolean getRightKeyDown2(// MovementInput removed - use Input movementInput) {
        return movementInput.rightKeyDown;
    }

    private static int getHorseJumpPowerCounter4(PBotPlayer instance) {
        return instance.horseJumpPowerCounter;
    }

    private static PBot getPbot2(PBotPlayer instance) {
        return instance.pbot;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input15(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input16(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static PlayerInventory getInventory3(PBotPlayer instance) {
        return instance.inventory;
    }

    private static void setActiveHand(PBotPlayer instance, Hand enumHand) {
        instance.activeHand = enumHand;
    }

    private static PlayerInventory getInventory4(PBotPlayer instance) {
        return instance.inventory;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input17(PBotPlayer instance) {
        return instance.movementInput;
    }

    public boolean canUseCommand(int permLevel, String commandName) {
        return (permLevel <= this.getPermissionLevel() ? 1 : 0) != 0;
    }

    private static PlayerInventory getInventory5(PBotPlayer instance) {
        return instance.inventory;
    }

    private static PlayerInventory getInventory6(PBotPlayer instance) {
        return instance.inventory;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input18(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static float getRenderArmPitch3(PBotPlayer instance) {
        return instance.renderArmPitch;
    }

    private static float getTimeInPortal3(PBotPlayer instance) {
        return instance.timeInPortal;
    }

    public void swingArm(Hand hand) {
        super.swingArm(hand);
        (this.connection).sendPacket((Packet)new CPacketAnimation(hand));
    }

    private static // PlayerCapabilities removed - use GameMode getCapabilities6(PBotPlayer instance) {
        return instance.capabilities;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input19(PBotPlayer instance) {
        return instance.movementInput;
    }

    public void onLivingUpdate() {
        ItemStack itemstack;
        int flag4;
        PBotPlayer cD = this;
        cD.sprintingTicksLeft = PBotPlayer.getSprintingTicksLeft(cD) + (1);
        if ((this.sprintToggleTimer) > 0) {
            PBotPlayer cD2 = this;
            cD2.sprintToggleTimer = PBotPlayer.getSprintToggleTimer3(cD2) - (1);
        }
        this.prevTimeInPortal = PBotPlayer.getTimeInPortal3(this);
        if ((this.inPortal)) {
            PBotPlayer cD3 = this;
            cD3.timeInPortal = PBotPlayer.getTimeInPortal6(cD3) + 0.0125000002f;
            if ((this.timeInPortal) >= 1.0f) {
                this.timeInPortal = 1.0f;
            }
            this.inPortal = false;
        } else if (this.isPotionActive((MobEffects.NAUSEA)) && this.getActivePotionEffect((MobEffects.NAUSEA)).getDuration() > (60)) {
            PBotPlayer cD4 = this;
            cD4.timeInPortal = PBotPlayer.getTimeInPortal5(cD4) + 0.00666666683f;
            if ((this.timeInPortal) > 1.0f) {
                this.timeInPortal = 1.0f;
            }
        } else {
            if ((this.timeInPortal) > 0.0f) {
                PBotPlayer cD5 = this;
                cD5.timeInPortal = PBotPlayer.getTimeInPortal7(cD5) - 0.0500000007f;
            }
            if ((this.timeInPortal) < 0.0f) {
                this.timeInPortal = 0.0f;
            }
        }
        if ((this.timeUntilPortal) > 0) {
            PBotPlayer cD6 = this;
            cD6.timeUntilPortal = PBotPlayer.getTimeUntilPortal2(cD6) - (1);
        }
        boolean flag = (PBotPlayer.get// MovementInput removed - use Input21(this).jump);
        boolean flag1 = (PBotPlayer.get// MovementInput removed - use Input34(this).sneak);
        int flag2 = (PBotPlayer.get// MovementInput removed - use Input20(this).moveForward) >= 0.800000012f ? 1 : 0;
        (this.movementInput).updatePlayerMoveState();
        if (this.isHandActive() && !this.isRiding()) {
            // MovementInput removed - use Input movementInput = (this.movementInput);
            movementInput.moveStrafe = PBotPlayer.getMoveStrafe3(movementInput) * 0.200000003f;
            // MovementInput removed - use Input movementInput2 = (this.movementInput);
            movementInput2.moveForward = PBotPlayer.getMoveForward4(movementInput2) * 0.200000003f;
            this.sprintToggleTimer = 0;
        }
        if ((this.autoJumpTime) > 0) {
            PBotPlayer cD7 = this;
            cD7.autoJumpTime = PBotPlayer.getAutoJumpTime(cD7) - (1);
            PBotPlayer.get// MovementInput removed - use Input24(this).jump = true;
        }
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        this.pushOutOfBlocks((this.posX) - (double)(this.width) * 0.34999999999999998, (axisalignedbb.minY) + 0.5, (this.posZ) + (double)(this.width) * 0.34999999999999998);
        this.pushOutOfBlocks((this.posX) - (double)(this.width) * 0.34999999999999998, (axisalignedbb.minY) + 0.5, (this.posZ) - (double)(this.width) * 0.34999999999999998);
        this.pushOutOfBlocks((this.posX) + (double)(this.width) * 0.34999999999999998, (axisalignedbb.minY) + 0.5, (this.posZ) - (double)(this.width) * 0.34999999999999998);
        this.pushOutOfBlocks((this.posX) + (double)(this.width) * 0.34999999999999998, (axisalignedbb.minY) + 0.5, (this.posZ) + (double)(this.width) * 0.34999999999999998);
        int n = flag4 = (float)this.getFoodStats().getFoodLevel() > 6.0f || (PBotPlayer.getCapabilities6(this).allowFlying) ? 1 : 0;
        if ((this.onGround) && !flag1 && flag2 == 0 && (PBotPlayer.get// MovementInput removed - use Input29(this).moveForward) >= 0.800000012f && !this.isSprinting() && flag4 != 0 && !this.isHandActive() && !this.isPotionActive((MobEffects.BLINDNESS))) {
            if ((this.sprintToggleTimer) <= 0 && !(PBotPlayer.getGameOptions(PBotPlayer.getMc(this)).keyBindSprint)) {
                this.sprintToggleTimer = 7;
            } else {
                this.setSprinting(true);
            }
        }
        if (!this.isSprinting() && (PBotPlayer.get// MovementInput removed - use Input32(this).moveForward) >= 0.800000012f && flag4 != 0 && !this.isHandActive() && !this.isPotionActive((MobEffects.BLINDNESS)) && (PBotPlayer.getGameOptions2(PBotPlayer.getMc3(this)).keyBindSprint)) {
            this.setSprinting(true);
        }
        if (this.isSprinting() && ((PBotPlayer.get// MovementInput removed - use Input4(this).moveForward) < 0.800000012f || (this.collidedHorizontally) || flag4 == 0)) {
            this.setSprinting(false);
        }
        if (!(!(PBotPlayer.get// MovementInput removed - use Input22(this).jump) || flag || (this.onGround) || !((this.motionY) < 0.0) || this.isElytraFlying() || (PBotPlayer.getCapabilities(this).isFlying) || (itemstack = this.getItemStackFromSlot((EntityEquipmentSlot.CHEST))).getItem() != (Items.ELYTRA) || ElytraItem.isUsable((ItemStack)itemstack))) {
            (this.connection).sendPacket((Packet)new CPacketEntityAction((Entity)this, (CPacketEntityAction.Action.START_FALL_FLYING)));
        }
        this.wasFallFlying = this.isElytraFlying();
        if ((PBotPlayer.getCapabilities7(this).isFlying) && this.isCurrentViewEntity()) {
            if ((PBotPlayer.get// MovementInput removed - use Input27(this).sneak)) {
                PBotPlayer.get// MovementInput removed - use Input33(this).moveStrafe = (float)((double)PBotPlayer.getMoveStrafe2(PBotPlayer.get// MovementInput removed - use Input9(this)) / 0.29999999999999999);
                PBotPlayer.get// MovementInput removed - use Input5(this).moveForward = (float)((double)PBotPlayer.getMoveForward3(PBotPlayer.get// MovementInput removed - use Input26(this)) / 0.29999999999999999);
                PBotPlayer cD8 = this;
                cD8.motionY = PBotPlayer.getMotionY3(cD8) - (double)(PBotPlayer.getCapabilities3(this).getFlySpeed() * 3.0f);
            }
            if ((PBotPlayer.get// MovementInput removed - use Input14(this).jump)) {
                PBotPlayer cD9 = this;
                cD9.motionY = PBotPlayer.getMotionY(cD9) + (double)(PBotPlayer.getCapabilities8(this).getFlySpeed() * 3.0f);
            }
        }
        if (this.isRidingHorse()) {
            // IJumpingMount removed ijumpingmount = (// IJumpingMount removed)this.getRidingEntity();
            if ((this.horseJumpPowerCounter) < 0) {
                PBotPlayer cD10 = this;
                cD10.horseJumpPowerCounter = PBotPlayer.getHorseJumpPowerCounter2(cD10) + (1);
                if ((this.horseJumpPowerCounter) == 0) {
                    this.horseJumpPower = 0.0f;
                }
            }
            if (flag && !(PBotPlayer.get// MovementInput removed - use Input18(this).jump)) {
                this.horseJumpPowerCounter = -10;
                ijumpingmount.setJumpPower(MathHelper.floor((float)(this.getHorseJumpPower() * 100.0f)));
                this.sendHorseJump();
            } else if (!flag && (PBotPlayer.get// MovementInput removed - use Input31(this).jump)) {
                this.horseJumpPowerCounter = 0;
                this.horseJumpPower = 0.0f;
            } else if (flag) {
                PBotPlayer cD11 = this;
                cD11.horseJumpPowerCounter = PBotPlayer.getHorseJumpPowerCounter3(cD11) + (1);
                if ((this.horseJumpPowerCounter) < (10)) {
                    this.horseJumpPower = (float)PBotPlayer.getHorseJumpPowerCounter6(this) * 0.100000001f;
                } else {
                    this.horseJumpPower = 0.800000012f + 2.0f / (float)(PBotPlayer.getHorseJumpPowerCounter4(this) - (9)) * 0.100000001f;
                }
            }
        } else {
            this.horseJumpPower = 0.0f;
        }
        super.onLivingUpdate();
        if ((this.onGround) && (PBotPlayer.getCapabilities5(this).isFlying) && !(PBotPlayer.getMc2(this).playerController).isSpectatorMode()) {
            PBotPlayer.getCapabilities4(this).isFlying = false;
            this.sendPlayerAbilities();
            this.jump();
            PBotPlayer.getCapabilities9(this).isFlying = true;
            this.sendPlayerAbilities();
        }
    }

    private static float getHorseJumpPower(PBotPlayer instance) {
        return instance.horseJumpPower;
    }

    public void resetActiveHand() {
        super.resetActiveHand();
        this.handActive = false;
    }

    private static float getMoveStrafe3(// MovementInput removed - use Input movementInput) {
        return movementInput.moveStrafe;
    }

    private static PBotMinecraft getMc2(PBotPlayer instance) {
        return instance.mc;
    }

    public void updateEntityActionState() {
        super.updateEntityActionState();
        if (this.isCurrentViewEntity()) {
            this.moveStrafing = PBotPlayer.getMoveStrafe(PBotPlayer.get// MovementInput removed - use Input19(this));
            this.moveForward = PBotPlayer.getMoveForward(PBotPlayer.get// MovementInput removed - use Input7(this));
            this.isJumping = PBotPlayer.getJump(PBotPlayer.get// MovementInput removed - use Input8(this));
            this.prevRenderArmYaw = PBotPlayer.getRenderArmYaw(this);
            this.prevRenderArmPitch = PBotPlayer.getRenderArmPitch3(this);
            this.renderArmPitch = (float)((double)PBotPlayer.getRenderArmPitch2(this) + (double)(PBotPlayer.getRotationPitch8(this) - PBotPlayer.getRenderArmPitch(this)) * 0.5);
            this.renderArmYaw = (float)((double)PBotPlayer.getRenderArmYaw2(this) + (double)(PBotPlayer.getRotationYaw8(this) - PBotPlayer.getRenderArmYaw3(this)) * 0.5);
        }
    }

    public void sendPlayerAbilities() {
        (this.connection).sendPacket((Packet)new PlayerAbilitiesC2SPacket((this.capabilities)));
    }

    public void sendHorseInventory() {
        (this.connection).sendPacket((Packet)new CPacketEntityAction((Entity)this, (CPacketEntityAction.Action.OPEN_INVENTORY)));
    }

    private static Hand getActiveHand(PBotPlayer instance) {
        return instance.activeHand;
    }

    public Vec3d getLook(float partialTicks) {
        return PBotPlayer.getVectorForRotation((float)(this.rotationPitch), (float)(this.rotationYaw));
    }

    private static int getSprintingTicksLeft(PBotPlayer instance) {
        return instance.sprintingTicksLeft;
    }

    private static float getMoveForward4(// MovementInput removed - use Input movementInput) {
        return movementInput.moveForward;
    }

    private static BotKeyState getGameOptions2(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static float getTimeInPortal5(PBotPlayer instance) {
        return instance.timeInPortal;
    }

    public boolean isSpectator() {
        NetworkPlayerInfo networkplayerinfo = (this.connection).getPlayerInfo(this.getGameProfile().getId());
        return (networkplayerinfo != null && networkplayerinfo.getGameMode() == (GameMode.SPECTATOR) ? 1 : 0) != 0;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input20(PBotPlayer instance) {
        return instance.movementInput;
    }

    public PBotPlayer(PBot pbot) {
        super((World)pbot.world, pbot.getPlayHandler().getGameProfile());
        this.permissionLevel = 0;
        this.autoJumpEnabled = 1;
        this.pbot = pbot;
        this.connection = pbot.getPlayHandler();
        this.statWriter = new StatHandler();
        this.recipeBook = new RecipeBook();
        this.mc = pbot.mc;
        this.dimension = 0;
        this.pbot.player = this;
    }

    private static float getTimeInPortal6(PBotPlayer instance) {
        return instance.timeInPortal;
    }

    private static int getHorseJumpPowerCounter6(PBotPlayer instance) {
        return instance.horseJumpPowerCounter;
    }

    protected boolean isCurrentViewEntity() {
        return true;
    }

    private static PlayerInventory getInventory7(PBotPlayer instance) {
        return instance.inventory;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input21(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static // PlayerCapabilities removed - use GameMode getCapabilities7(PBotPlayer instance) {
        return instance.capabilities;
    }

    @Nullable
    public PotionEffect removeActivePotionEffect(@Nullable Potion potioneffectin) {
        if (potioneffectin == (MobEffects.NAUSEA)) {
            this.prevTimeInPortal = 0.0f;
            this.timeInPortal = 0.0f;
        }
        return super.removeActivePotionEffect(potioneffectin);
    }

    private static float getRotationYaw7(Entity entity) {
        return entity.rotationYaw;
    }

    public void setPlayerSPHealth(float health) {
        if ((this.hasValidHealth)) {
            float f = this.getHealth() - health;
            if (f <= 0.0f) {
                this.setHealth(health);
                if (f < 0.0f) {
                    this.hurtResistantTime = PBotPlayer.getMaxHurtResistantTime(this) / (2);
                }
            } else {
                this.lastDamage = f;
                this.setHealth(this.getHealth());
                this.hurtResistantTime = PBotPlayer.getMaxHurtResistantTime2(this);
                this.damageEntity((DamageSource.GENERIC), f);
                this.maxHurtTime = 10;
                this.hurtTime = PBotPlayer.getMaxHurtTime(this);
            }
        } else {
            this.setHealth(health);
            this.hasValidHealth = true;
        }
    }

    private static float getRenderArmYaw(PBotPlayer instance) {
        return instance.renderArmYaw;
    }

    private static World getWorld11(PBotPlayer instance) {
        return instance.world;
    }

    public BlockPos getPosition() {
        return new BlockPos((this.posX) + 0.5, (this.posY) + 0.5, (this.posZ) + 0.5);
    }

    private static float getPrevRotationYaw2(PBotPlayer instance) {
        return instance.prevRotationYaw;
    }

    private static float getRotationYaw8(PBotPlayer instance) {
        return instance.rotationYaw;
    }

    private static float getRotationPitch6(PBotPlayer instance) {
        return instance.rotationPitch;
    }

    public void setActiveHand(Hand hand) {
        ItemStack itemstack = this.getHeldItem(hand);
        if (!itemstack.isEmpty() && !this.isHandActive()) {
            super.setActiveHand(hand);
            this.handActive = true;
            this.activeHand = hand;
        }
    }

    private static // PlayerCapabilities removed - use GameMode getCapabilities8(PBotPlayer instance) {
        return instance.capabilities;
    }

    public void sendStatusMessage(Text chatComponent, boolean actionBar) {
        if (actionBar) {
            // empty if block
        }
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input22(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static double getPosX13(PBotPlayer instance) {
        return instance.posX;
    }

    private static // PlayerCapabilities removed - use GameMode getCapabilities9(PBotPlayer instance) {
        return instance.capabilities;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input23(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input24(PBotPlayer instance) {
        return instance.movementInput;
    }

    public void onEnchantmentCritical(Entity entityHit) {
    }

    public void openBook(ItemStack stack, Hand hand) {
        Item item = stack.getItem();
        if (item == (Items.WRITABLE_BOOK)) {
            // empty if block
        }
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input25(PBotPlayer instance) {
        return instance.movementInput;
    }

    public void sendMessage(Text component) {
    }

    private static PBotMinecraft getMc3(PBotPlayer instance) {
        return instance.mc;
    }

    private static PlayerInventory getInventory9(PBotPlayer instance) {
        return instance.inventory;
    }

    public boolean startRiding(Entity entityIn, boolean force) {
        if (!super.startRiding(entityIn, force)) {
            return false;
        }
        if (entityIn instanceof EntityBoat) {
            this.prevRotationYaw = PBotPlayer.getRotationYaw9(entityIn);
            this.rotationYaw = PBotPlayer.getRotationYaw7(entityIn);
            this.setRotationYawHead((entityIn.rotationYaw));
        }
        return true;
    }

    private static PlayerInventory getInventory10(PBotPlayer instance) {
        return instance.inventory;
    }

    public void setSprinting(boolean sprinting) {
        super.setSprinting(sprinting);
        this.sprintingTicksLeft = 0;
    }

    public boolean isServerWorld() {
        return true;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input26(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static float getRenderArmYaw2(PBotPlayer instance) {
        return instance.renderArmYaw;
    }

    public void displayGui(NamedScreenHandlerFactory guiOwner) {
        String s = guiOwner.getGuiID();
        if (!"minecraft:crafting_table".equals(s)) {
            if ("minecraft:enchanting_table".equals(s)) {
                this.openScreenHandler = (ScreenHandler)new ScreenHandlerEnchantment(PBotPlayer.getInventory11(this), PBotPlayer.getWorld15(this));
            } else if ("minecraft:anvil".equals(s)) {
                this.openScreenHandler = (ScreenHandler)new ScreenHandlerRepair(PBotPlayer.getInventory(this), PBotPlayer.getWorld11(this), (PlayerEntity)this);
            }
        }
    }

    public boolean isRidingHorse() {
        Entity entity = this.getRidingEntity();
        return (this.isRiding() && entity instanceof // IJumpingMount removed && ((// IJumpingMount removed)entity).canJump() ? 1 : 0) != 0;
    }

    private static float getRotationYaw9(Entity entity) {
        return entity.rotationYaw;
    }

    private static ScreenHandler getOpenScreenHandler(PBotPlayer instance) {
        return instance.openScreenHandler;
    }

    private static String getServerBrand(PBotPlayer instance) {
        return instance.serverBrand;
    }

    private static int getSprintToggleTimer3(PBotPlayer instance) {
        return instance.sprintToggleTimer;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input27(PBotPlayer instance) {
        return instance.movementInput;
    }

    public void openEditSign(TileEntitySign signTile) {
        Object[] objectArray = new Object[2];
        objectArray[0] = (this.pbot);
        objectArray[1] = signTile;
        (Client.getInstance().pBotsScriptManager).invokeMethod("onOpenEditSign", objectArray);
    }

    public void handleStatusUpdate(byte id) {
        if (id >= (24) && id <= (28)) {
            this.setPermissionLevel(id - (24));
        } else {
            super.handleStatusUpdate(id);
        }
    }

    private static float getRenderArmYaw3(PBotPlayer instance) {
        return instance.renderArmYaw;
    }

    public void displayGUIChest(IInventory chestInventory) {
        String s;
        String string = s = chestInventory instanceof NamedScreenHandlerFactory ? ((NamedScreenHandlerFactory)chestInventory).getGuiID() : "minecraft:container";
        if ("minecraft:chest".equals(s)) {
            this.openScreenHandler = (ScreenHandler)new ScreenHandlerChest((IInventory)PBotPlayer.getInventory12(this), chestInventory, (PlayerEntity)this);
        } else if ("minecraft:hopper".equals(s)) {
            this.openScreenHandler = (ScreenHandler)new ScreenHandlerHopper(PBotPlayer.getInventory4(this), chestInventory, (PlayerEntity)this);
        } else if ("minecraft:furnace".equals(s)) {
            this.openScreenHandler = (ScreenHandler)new ScreenHandlerFurnace(PBotPlayer.getInventory6(this), chestInventory);
        } else if ("minecraft:brewing_stand".equals(s)) {
            this.openScreenHandler = (ScreenHandler)new ScreenHandlerBrewingStand(PBotPlayer.getInventory9(this), chestInventory);
        } else if ("minecraft:beacon".equals(s)) {
            this.openScreenHandler = (ScreenHandler)new ScreenHandlerBeacon((IInventory)PBotPlayer.getInventory2(this), chestInventory);
        } else if (!"minecraft:dispenser".equals(s) && !"minecraft:dropper".equals(s)) {
            if ("minecraft:shulker_box".equals(s)) {
                this.openScreenHandler = (ScreenHandler)new ScreenHandlerShulkerBox(PBotPlayer.getInventory3(this), chestInventory, (PlayerEntity)this);
            } else {
                this.openScreenHandler = (ScreenHandler)new ScreenHandlerChest((IInventory)PBotPlayer.getInventory13(this), chestInventory, (PlayerEntity)this);
            }
        } else {
            this.openScreenHandler = (ScreenHandler)new ScreenHandlerDispenser((IInventory)PBotPlayer.getInventory5(this), chestInventory);
        }
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input29(PBotPlayer instance) {
        return instance.movementInput;
    }

    public StatHandler getStatFileWriter() {
        return (this.statWriter);
    }

    public void openEditStructure(TileEntityStructure structure) {
    }

    private static PlayerInventory getInventory11(PBotPlayer instance) {
        return instance.inventory;
    }

    private static int getMaxHurtTime(PBotPlayer instance) {
        return instance.maxHurtTime;
    }

    public boolean isUser() {
        return true;
    }

    private static void setServerBrand(PBotPlayer instance, String string) {
        instance.serverBrand = string;
    }

    public void displayVillagerTradeGui(IMerchant villager) {
        this.openScreenHandler = (ScreenHandler)new ScreenHandlerMerchant(PBotPlayer.getInventory7(this), villager, PBotPlayer.getWorld6(this));
    }

    private static PlayerInventory getInventory12(PBotPlayer instance) {
        return instance.inventory;
    }

    protected void sendHorseJump() {
        (this.connection).sendPacket((Packet)new CPacketEntityAction((Entity)this, (CPacketEntityAction.Action.START_RIDING_JUMP), MathHelper.floor((float)(this.getHorseJumpPower() * 100.0f))));
    }

    public void closeScreenAndDropStack() {
        (this.inventory).setItemStack((ItemStack.EMPTY));
        super.closeScreen();
    }

    private static float getTimeInPortal7(PBotPlayer instance) {
        return instance.timeInPortal;
    }

    public RecipeBook getRecipeBook() {
        return (this.recipeBook);
    }

    public void moveEntity(MovementType type, double x, double y, double z) {
        double d0 = (this.posX);
        double d1 = (this.posZ);
        super.move(type, x, y, z);
        this.updateAutoJump((float)((this.posX) - d0), (float)((this.posZ) - d1));
    }

    public boolean isCreative() {
        NetworkPlayerInfo networkplayerinfo = (this.connection).getPlayerInfo(this.getGameProfile().getId());
        return (networkplayerinfo != null && networkplayerinfo.getGameMode() == (GameMode.CREATIVE) ? 1 : 0) != 0;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input31(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static float getRotationPitch8(PBotPlayer instance) {
        return instance.rotationPitch;
    }

    public void onCriticalHit(Entity entityHit) {
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input32(PBotPlayer instance) {
        return instance.movementInput;
    }

    public void setServerBrand(String brand) {
        this.serverBrand = brand;
    }

    public Hand getActiveHand() {
        return (this.activeHand);
    }

    protected void damageEntity(DamageSource damageSrc, float damageAmount) {
        if (!this.isEntityInvulnerable(damageSrc)) {
            this.setHealth(this.getHealth() - damageAmount);
        }
    }

    public void setPosition(double x, double y, double z) {
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        float f = (this.width) / 2.0f;
        float f1 = (this.height);
        this.setEntityBoundingBox(new AxisAlignedBB(x - (double)f, y, z - (double)f, x + (double)f, y + (double)f1, z + (double)f));
    }

    private void callIsSprinting() {
        boolean flag1;
        boolean flag = this.isSprinting();
        if (flag != (this.serverSprintState)) {
            if (flag) {
                (this.connection).sendPacket((Packet)new CPacketEntityAction((Entity)this, (CPacketEntityAction.Action.START_SPRINTING)));
            } else {
                (this.connection).sendPacket((Packet)new CPacketEntityAction((Entity)this, (CPacketEntityAction.Action.STOP_SPRINTING)));
            }
            this.serverSprintState = flag;
        }
        if ((flag1 = this.isSneaking()) != (this.serverSneakState)) {
            if (flag1) {
                (this.connection).sendPacket((Packet)new CPacketEntityAction((Entity)this, (CPacketEntityAction.Action.START_SNEAKING)));
            } else {
                (this.connection).sendPacket((Packet)new CPacketEntityAction((Entity)this, (CPacketEntityAction.Action.STOP_SNEAKING)));
            }
            this.serverSneakState = flag1;
        }
        if (this.isCurrentViewEntity()) {
            int flag3;
            AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
            double d0 = (this.posX) - (this.lastReportedPosX);
            double d1 = (axisalignedbb.minY) - (this.lastReportedPosY);
            double d2 = (this.posZ) - (this.lastReportedPosZ);
            float yaw = (this.rotationYaw);
            float pitch = (this.rotationPitch);
            double d3 = yaw - (this.lastReportedYaw);
            double d4 = pitch - (this.lastReportedPitch);
            PBotPlayer cD = this;
            cD.positionUpdateTicks = PBotPlayer.getPositionUpdateTicks(cD) + (1);
            int flag2 = d0 * d0 + d1 * d1 + d2 * d2 > 0.00089999999999999998 || (this.positionUpdateTicks) >= (20) ? 1 : 0;
            int n = flag3 = d3 != 0.0 || d4 != 0.0 ? 1 : 0;
            if (this.isRiding()) {
                (this.connection).sendPacket((Packet)new PlayerMoveC2SPacket.PositionRotation((this.motionX), -999.0, (this.motionZ), (this.rotationYaw), (this.rotationPitch), (this.onGround)));
                flag2 = 0;
            } else if (flag2 != 0 && flag3 != 0) {
                (this.connection).sendPacket((Packet)new PlayerMoveC2SPacket.PositionRotation((this.posX), (this.posY), (this.posZ), (this.rotationYaw), (this.rotationPitch), (this.onGround)));
            } else if (flag2 != 0) {
                (this.connection).sendPacket((Packet)new PlayerMoveC2SPacket.Position((this.posX), (this.posY), (this.posZ), (this.onGround)));
            } else if (flag3 != 0) {
                (this.connection).sendPacket((Packet)new PlayerMoveC2SPacket.Rotation((this.rotationYaw), (this.rotationPitch), (this.onGround)));
            } else if ((this.prevOnGround) != (this.onGround)) {
                (this.connection).sendPacket((Packet)new PlayerMoveC2SPacket((this.onGround)));
            }
            if (flag2 != 0) {
                this.lastReportedPosX = PBotPlayer.getPosX13(this);
                this.lastReportedPosY = PBotPlayer.getMinY(axisalignedbb);
                this.lastReportedPosZ = PBotPlayer.getPosZ(this);
                this.positionUpdateTicks = 0;
            }
            if (flag3 != 0) {
                this.lastReportedYaw = yaw;
                this.lastReportedPitch = pitch;
            }
            this.prevOnGround = PBotPlayer.getOnGround3(this);
            this.autoJumpEnabled = true;
        }
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input33(PBotPlayer instance) {
        return instance.movementInput;
    }

    public void notifyDataManagerChange(TrackedData<?> key) {
        super.notifyDataManagerChange(key);
        if ((HAND_STATES).equals(key)) {
            Hand enumhand;
            int flag = ((Byte)(this.dataManager).get((HAND_STATES)) & (1)) > 0 ? 1 : 0;
            Hand enumHand = enumhand = ((Byte)(this.dataManager).get((HAND_STATES)) & (2)) > 0 ? (Hand.OFF_HAND) : (Hand.MAIN_HAND);
            if (flag != 0 && !(this.handActive)) {
                this.setActiveHand(enumhand);
            } else if (flag == 0 && (this.handActive)) {
                this.resetActiveHand();
            }
        }
        if (!((FLAGS).equals(key) && this.isElytraFlying() && (this.wasFallFlying))) {
            // empty if block
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    private static double getMotionY3(PBotPlayer instance) {
        return instance.motionY;
    }

    public void dismountRidingEntity() {
        super.dismountRidingEntity();
        this.rowingBoat = false;
    }

    private static World getWorld15(PBotPlayer instance) {
        return instance.world;
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input34(PBotPlayer instance) {
        return instance.movementInput;
    }

    public void displayGuiCommandBlock(TileEntityCommandBlock commandBlock) {
    }

    private static // MovementInput removed - use Input get// MovementInput removed - use Input35(PBotPlayer instance) {
        return instance.movementInput;
    }

    private static PlayerInventory getInventory13(PBotPlayer instance) {
        return instance.inventory;
    }

    private static float getRotationYaw13(PBotPlayer instance) {
        return instance.rotationYaw;
    }

}
