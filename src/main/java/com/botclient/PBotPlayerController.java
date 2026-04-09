/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.PBotNetHandlerPlayClient
 *  neo.deobf.PBotClientWorld
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockCommandBlock
 *  net.minecraft.block.BlockStructure
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.HorseEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.client.CreativeInventoryActionC2SPacket
 *  net.minecraft.network.play.client.CustomPayloadC2SPacket
 *  net.minecraft.network.play.client.CPacketEnchantItem
 *  net.minecraft.network.play.client.SelectedSlotChangeC2SPacket
 *  net.minecraft.network.play.client.PlayerActionC2SPacket
 *  net.minecraft.network.play.client.PlayerActionC2SPacket$Action
 *  net.minecraft.network.play.client.PlayerMoveC2SPacketTryUseItem
 *  net.minecraft.network.play.client.PlayerInteractBlockC2SPacket
 *  net.minecraft.network.play.client.PlayerInteractEntityC2SPacket
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.GameType
 *  net.minecraft.world.World
 */
package com.botclient;

import io.netty.buffer.Unpooled;
import com.botclient.PBot;
import com.botclient.PBotPlayer;
import com.botclient.PBotMinecraft;
import com.botclient.PBotNetHandlerPlayClient;
import com.botclient.PBotClientWorld;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.BlockStructure;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
// Removed: PlayerCapabilities replaced
import net.minecraft.registry.Registries;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacketTryUseItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PBotPlayerController {
    public boolean isHittingBlock;
    public ItemStack currentItemHittingBlock;
    public float stepSoundTickCounter;
    public GameType currentGameType;
    public final PBotNetHandlerPlayClient connection;
    private final PBotMinecraft mc;
    public int blockHitDelay;
    public final PBot pbot;
    public float curBlockDamageMP;
    public int currentPlayerItem;
    public BlockPos currentBlock = new BlockPos(-1, -1, -1);

    private static GameType getCurrentGameType(PBotPlayerController instance) {
        return instance.currentGameType;
    }

    public ItemStack windowClick(int windowId, int slotId, int mouseButton, ClickType type, PlayerEntity player) {
        try {
            short short1 = (player.openContainer).getNextTransactionID((player.inventory));
            ItemStack itemstack = (player.openContainer).slotClick(slotId, mouseButton, type, player);
            (this.connection).sendPacket((Packet)new CPacketClickWindow(windowId, slotId, mouseButton, type, itemstack, short1));
            return itemstack;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean shouldDrawHUD() {
        return (this.currentGameType).isSurvivalOrAdventure();
    }

    public boolean gameIsSurvivalOrAdventure() {
        return (this.currentGameType).isSurvivalOrAdventure();
    }

    private static float getCurBlockDamageMP(PBotPlayerController instance) {
        return instance.curBlockDamageMP;
    }

    public void updateController() {
        this.callGetCurrentItem();
        if ((this.connection).getNetworkManager().isChannelOpen()) {
            (this.connection).getNetworkManager().processReceivedPackets();
        } else {
            (this.connection).getNetworkManager().handleDisconnection();
        }
    }

    private static PBot getPbot(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static PBot getPbot2(PBotPlayerController instance) {
        return instance.pbot;
    }

    public void pickItem(int index) {
        (this.connection).sendPacket((Packet)new CustomPayloadC2SPacket("MC|PickItem", new PacketBuffer(Unpooled.buffer()).writeVarInt(index)));
    }

    public void attackEntity(PlayerEntity playerIn, Entity targetEntity) {
        this.callGetCurrentItem();
        (this.connection).sendPacket((Packet)new PlayerInteractEntityC2SPacket(targetEntity));
        if ((this.currentGameType) != (GameType.SPECTATOR)) {
            playerIn.attackTargetEntityWithCurrentItem(targetEntity);
            playerIn.resetCooldown();
        }
    }

    private static PBot getPbot3(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static PBot getPbot4(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static boolean getIsHittingBlock(PBotPlayerController instance) {
        return instance.isHittingBlock;
    }

    private void callGetCurrentItem() {
        int i = (PBotPlayerController.getInventory(PBotPlayerController.getPlayer21(PBotPlayerController.getPbot39(this))).currentItem);
        if (i != (this.currentPlayerItem)) {
            this.currentPlayerItem = i;
            (this.connection).sendPacket((Packet)new SelectedSlotChangeC2SPacket((this.currentPlayerItem)));
        }
    }

    public EnumActionResult processRightClickBlock(PBotPlayer player, World worldIn, BlockPos pos, Direction direction, Vec3d vec, Hand hand) {
        this.callGetCurrentItem();
        ItemStack itemstack = player.getHeldItem(hand);
        float f = (float)((vec.x) - (double)pos.getX());
        float f1 = (float)((vec.y) - (double)pos.getY());
        float f2 = (float)((vec.z) - (double)pos.getZ());
        int flag = 0;
        if (!(this.pbot).world.getWorldBorder().contains(pos)) {
            return (ActionResult.FAIL);
        }
        if ((this.currentGameType) != (GameType.SPECTATOR)) {
            ItemBlock itemblock;
            BlockState iblockstate = worldIn.getBlockState(pos);
            if ((!player.isSneaking() || player.getHeldItemMainhand().isEmpty() && player.getHeldItemOffhand().isEmpty()) && iblockstate.getBlock().onBlockActivated(worldIn, pos, iblockstate, (PlayerEntity)player, hand, direction, f, f1, f2)) {
                flag = 1;
            }
            if (flag == 0 && itemstack.getItem() instanceof ItemBlock && !(itemblock = (ItemBlock)itemstack.getItem()).canPlaceBlockOnSide(worldIn, pos, direction, (PlayerEntity)player, itemstack)) {
                return (ActionResult.FAIL);
            }
        }
        (this.connection).sendPacket((Packet)new PlayerInteractBlockC2SPacket(pos, direction, hand, f, f1, f2));
        if (flag == 0 && (this.currentGameType) != (GameType.SPECTATOR)) {
            Block block;
            if (itemstack.isEmpty()) {
                return (ActionResult.PASS);
            }
            if (player.getCooldownTracker().hasCooldown(itemstack.getItem())) {
                return (ActionResult.PASS);
            }
            if (itemstack.getItem() instanceof ItemBlock && !player.canUseCommandBlock() && ((block = ((ItemBlock)itemstack.getItem()).getBlock()) instanceof BlockCommandBlock || block instanceof BlockStructure)) {
                return (ActionResult.FAIL);
            }
            if ((this.currentGameType).isCreative()) {
                int i = itemstack.getMetadata();
                int j = itemstack.getCount();
                EnumActionResult enumactionresult = itemstack.onItemUse((PlayerEntity)player, worldIn, pos, hand, direction, f, f1, f2);
                itemstack.setItemDamage(i);
                itemstack.setCount(j);
                return enumactionresult;
            }
            return itemstack.onItemUse((PlayerEntity)player, worldIn, pos, hand, direction, f, f1, f2);
        }
        return (ActionResult.SUCCESS);
    }

    private static PBot getPbot6(PBotPlayerController instance) {
        return instance.pbot;
    }

    public void onStoppedUsingItem(PlayerEntity playerIn) {
        this.callGetCurrentItem();
        (this.connection).sendPacket((Packet)new PlayerActionC2SPacket((PlayerActionC2SPacket.Action.RELEASE_USE_ITEM), (BlockPos.ORIGIN), (Direction.DOWN)));
        playerIn.stopActiveHand();
    }

    private static PBotPlayer getPlayer4(PBot instance) {
        return instance.player;
    }

    public PBotPlayerController(PBot pbot) {
        this.currentItemHittingBlock = ItemStack.EMPTY;
        this.currentGameType = GameType.SURVIVAL;
        this.pbot = pbot;
        this.mc = pbot.mc;
        this.connection = pbot.getPlayHandler();
    }

    public boolean isSpectator() {
        return ((this.currentGameType) == (GameType.SPECTATOR) ? 1 : 0) != 0;
    }

    private static PBot getPbot8(PBotPlayerController instance) {
        return instance.pbot;
    }

    public void sendEnchantPacket(int windowID, int button) {
        (this.connection).sendPacket((Packet)new CPacketEnchantItem(windowID, button));
    }

    private static PBot getPbot10(PBotPlayerController instance) {
        return instance.pbot;
    }

    public EnumActionResult processRightClick(PlayerEntity player, World worldIn, Hand hand) {
        if ((this.currentGameType) == (GameType.SPECTATOR)) {
            return (ActionResult.PASS);
        }
        this.callGetCurrentItem();
        (this.connection).sendPacket((Packet)new PlayerMoveC2SPacketTryUseItem(hand));
        ItemStack itemstack = player.getHeldItem(hand);
        if (player.getCooldownTracker().hasCooldown(itemstack.getItem())) {
            return (ActionResult.PASS);
        }
        int i = itemstack.getCount();
        ActionResult actionresult = itemstack.useItemRightClick(worldIn, player, hand);
        ItemStack itemstack1 = (ItemStack)actionresult.getResult();
        if (itemstack1 != itemstack || itemstack1.getCount() != i) {
            player.setHeldItem(hand, itemstack1);
        }
        return actionresult.getType();
    }

    private static PBot getPbot11(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static InventoryPlayer getInventory(PBotPlayer instance) {
        return instance.inventory;
    }

    public boolean extendedReach() {
        return (this.currentGameType).isCreative();
    }

    public void sendSlotPacket(ItemStack itemStackIn, int slotId) {
        if ((this.currentGameType).isCreative()) {
            (this.connection).sendPacket((Packet)new CreativeInventoryActionC2SPacket(slotId, itemStackIn));
        }
    }

    private static float getStepSoundTickCounter(PBotPlayerController instance) {
        return instance.stepSoundTickCounter;
    }

    private static Vec3d getHitVec(HitResult rayTraceResult) {
        return rayTraceResult.hitVec;
    }

    private static PBot getPbot13(PBotPlayerController instance) {
        return instance.pbot;
    }

    public EnumActionResult interactWithEntity(PlayerEntity player, Entity target, Hand hand) {
        if (target == null) {
            return (ActionResult.FAIL);
        }
        this.callGetCurrentItem();
        (this.connection).sendPacket((Packet)new PlayerInteractEntityC2SPacket(target, hand));
        return (this.currentGameType) == (GameType.SPECTATOR) ? (ActionResult.PASS) : player.interactOn(target, hand);
    }

    private static PBot getPbot14(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static PBot getPbot15(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static PBot getPbot16(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static PBotPlayer JqPqglreez(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot17(PBotPlayerController instance) {
        return instance.pbot;
    }

    public boolean isNotCreative() {
        return (!(this.currentGameType).isCreative() ? 1 : 0) != 0;
    }

    private static PBot getPbot18(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static PBot getPbot19(PBotPlayerController instance) {
        return instance.pbot;
    }

    public float getBlockReachDistance() {
        return (this.currentGameType).isCreative() ? 5.0f : 4.5f;
    }

    private static PBotPlayer getPlayer9(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot20(PBotPlayerController instance) {
        return instance.pbot;
    }

    public boolean isInCreativeMode() {
        return (this.currentGameType).isCreative();
    }

    public boolean isSpectatorMode() {
        return ((this.currentGameType) == (GameType.SPECTATOR) ? 1 : 0) != 0;
    }

    private static Vec3d getHitVec2(HitResult rayTraceResult) {
        return rayTraceResult.hitVec;
    }

    public void sendPacketDropItem(ItemStack itemStackIn) {
        if ((this.currentGameType).isCreative() && !itemStackIn.isEmpty()) {
            (this.connection).sendPacket((Packet)new CreativeInventoryActionC2SPacket(-1, itemStackIn));
        }
    }

    public GameType getCurrentGameType() {
        return (this.currentGameType);
    }

    private static PBotPlayer getPlayer15(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot24(PBotPlayerController instance) {
        return instance.pbot;
    }

    public boolean isRidingHorse() {
        return ((PBotPlayerController.getPbot13(this).player).isRiding() && (PBotPlayerController.getPbot4(this).player).getRidingEntity() instanceof AbstractHorse ? 1 : 0) != 0;
    }

    public boolean onPlayerDestroyBlock(BlockPos pos) {
        ItemStack itemstack1;
        if ((this.currentGameType).equals((Object)(GameType.ADVENTURE))) {
            if ((this.currentGameType) == (GameType.SPECTATOR)) {
                return false;
            }
            if (!(PBotPlayerController.getPbot15(this).player).isAllowEdit()) {
                ItemStack itemstack = (PBotPlayerController.getPbot16(this).player).getHeldItemMainhand();
                if (itemstack.isEmpty()) {
                    return false;
                }
                if (!itemstack.canDestroy((this.pbot).world.getBlockState(pos).getBlock())) {
                    return false;
                }
            }
        }
        if ((this.currentGameType).isCreative() && !(PBotPlayerController.getPbot31(this).player).getHeldItemMainhand().isEmpty() && (PBotPlayerController.getPbot30(this).player).getHeldItemMainhand().getItem() instanceof ItemSword) {
            return false;
        }
        PBotClientWorld world = (this.pbot).world;
        BlockState iblockstate = world.getBlockState(pos);
        Block block = iblockstate.getBlock();
        if ((block instanceof BlockCommandBlock || block instanceof BlockStructure) && !(PBotPlayerController.getPbot18(this).player).canUseCommandBlock()) {
            return false;
        }
        if (iblockstate.getMaterial() == (Material.AIR)) {
            return false;
        }
        world.playEvent(2001, pos, Block.getStateId((BlockState)iblockstate));
        block.onBlockHarvested((World)world, pos, iblockstate, (PlayerEntity)(PBotPlayerController.getPbot25(this).player));
        boolean flag = world.setBlockState(pos, (Blocks.AIR).getDefaultState(), 11);
        if (flag) {
            block.onPlayerDestroy((World)world, pos, iblockstate);
        }
        this.currentBlock = new BlockPos(PBotPlayerController.getCurrentBlock8(this).getX(), -1, PBotPlayerController.getCurrentBlock5(this).getZ());
        if (!(this.currentGameType).isCreative() && !(itemstack1 = (PBotPlayerController.getPbot24(this).player).getHeldItemMainhand()).isEmpty()) {
            itemstack1.onBlockDestroyed((World)world, iblockstate, pos, (PlayerEntity)(PBotPlayerController.getPbot(this).player));
            if (itemstack1.isEmpty()) {
                (PBotPlayerController.getPbot2(this).player).setHeldItem((Hand.MAIN_HAND), (ItemStack.EMPTY));
            }
        }
        return flag;
    }

    private static PBot getPbot25(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static PBot getPbot26(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static PBot getPbot27(PBotPlayerController instance) {
        return instance.pbot;
    }

    private boolean isHittingPosition(BlockPos pos) {
        int flag;
        ItemStack itemstack = (PBotPlayerController.getPbot33(this).player).getHeldItemMainhand();
        int n = flag = (this.currentItemHittingBlock).isEmpty() && itemstack.isEmpty() ? 1 : 0;
        if (!(this.currentItemHittingBlock).isEmpty() && !itemstack.isEmpty()) {
            flag = itemstack.getItem() == (this.currentItemHittingBlock).getItem() && ItemStack.areItemStackTagsEqual((ItemStack)itemstack, (ItemStack)(this.currentItemHittingBlock)) && (itemstack.isItemStackDamageable() || itemstack.getMetadata() == (this.currentItemHittingBlock).getMetadata()) ? 1 : 0;
        }
        return (pos.equals((Object)(this.currentBlock)) && flag != 0 ? 1 : 0) != 0;
    }

    public void clickBlockCreative(PBotPlayerController playerController, BlockPos pos, Direction facing) {
        if (!(this.pbot).world.extinguishFire((PlayerEntity)(PBotPlayerController.getPbot3(this).player), pos, facing)) {
            playerController.onPlayerDestroyBlock(pos);
        }
    }

    private static PBot getPbot30(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static PBot getPbot31(PBotPlayerController instance) {
        return instance.pbot;
    }

    public boolean getIsHittingBlock() {
        return (this.isHittingBlock);
    }

    private static Vec3d getHitVec3(HitResult rayTraceResult) {
        return rayTraceResult.hitVec;
    }

    private static BlockPos getCurrentBlock5(PBotPlayerController instance) {
        return instance.currentBlock;
    }

    public boolean clickBlock(BlockPos loc, Direction face) {
        if ((this.currentGameType).equals((Object)(GameType.ADVENTURE))) {
            if ((this.currentGameType) == (GameType.SPECTATOR)) {
                return false;
            }
            if (!(PBotPlayerController.getPbot8(this).player).isAllowEdit()) {
                ItemStack itemstack = (PBotPlayerController.getPbot34(this).player).getHeldItemMainhand();
                if (itemstack.isEmpty()) {
                    return false;
                }
                if (!itemstack.canDestroy((this.pbot).world.getBlockState(loc).getBlock())) {
                    return false;
                }
            }
        }
        if (!(this.pbot).world.getWorldBorder().contains(loc)) {
            return false;
        }
        if ((this.currentGameType).isCreative()) {
            (this.connection).sendPacket((Packet)new PlayerActionC2SPacket((PlayerActionC2SPacket.Action.START_DESTROY_BLOCK), loc, face));
            this.clickBlockCreative(this, loc, face);
            this.blockHitDelay = 5;
        } else if (!(this.isHittingBlock) || !this.isHittingPosition(loc)) {
            int flag;
            if ((this.isHittingBlock)) {
                (this.connection).sendPacket((Packet)new PlayerActionC2SPacket((PlayerActionC2SPacket.Action.ABORT_DESTROY_BLOCK), (this.currentBlock), face));
            }
            BlockState iblockstate = (this.pbot).world.getBlockState(loc);
            (this.connection).sendPacket((Packet)new PlayerActionC2SPacket((PlayerActionC2SPacket.Action.START_DESTROY_BLOCK), loc, face));
            int n = flag = iblockstate.getMaterial() != (Material.AIR) ? 1 : 0;
            if (flag != 0 && (this.curBlockDamageMP) == 0.0f) {
                iblockstate.getBlock().onBlockClicked((World)(this.pbot).world, loc, (PlayerEntity)(PBotPlayerController.getPbot26(this).player));
            }
            if (flag != 0 && iblockstate.getPlayerRelativeBlockHardness((PlayerEntity)(PBotPlayerController.getPbot6(this).player), (PBotPlayerController.getPlayer9(PBotPlayerController.getPbot38(this)).world), loc) >= 1.0f) {
                this.onPlayerDestroyBlock(loc);
            } else {
                this.isHittingBlock = true;
                this.currentBlock = loc;
                this.currentItemHittingBlock = PBotPlayerController.getPlayer26(PBotPlayerController.getPbot19(this)).getHeldItemMainhand();
                this.curBlockDamageMP = 0.0f;
                this.stepSoundTickCounter = 0.0f;
                (this.pbot).world.sendBlockBreakProgress((PBotPlayerController.getPbot11(this).player).getEntityId(), (this.currentBlock), (int)((this.curBlockDamageMP) * 10.0f) - (1));
            }
        }
        return true;
    }

    private static int getBlockHitDelay2(PBotPlayerController instance) {
        return instance.blockHitDelay;
    }

    private static PBot getPbot33(PBotPlayerController instance) {
        return instance.pbot;
    }

private static PBot getPbot34(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static PBot getPbot36(PBotPlayerController instance) {
        return instance.pbot;
    }

    public void resetBlockRemoving() {
        if ((this.isHittingBlock)) {
            (this.connection).sendPacket((Packet)new PlayerActionC2SPacket((PlayerActionC2SPacket.Action.ABORT_DESTROY_BLOCK), (this.currentBlock), (Direction.DOWN)));
            this.isHittingBlock = false;
            this.curBlockDamageMP = 0.0f;
            (this.pbot).world.sendBlockBreakProgress((PBotPlayerController.getPbot14(this).player).getEntityId(), (this.currentBlock), -1);
            (PBotPlayerController.getPbot10(this).player).resetCooldown();
        }
    }

    private static World getWorld2(PBotPlayer instance) {
        return instance.world;
    }

    public void flipPlayer(PlayerEntity playerIn) {
        playerIn.rotationYaw = -180.0f;
    }

    public EnumActionResult interactWithEntity(PlayerEntity player, Entity target, HitResult ray, Hand hand) {
        if (target == null) {
            return (ActionResult.FAIL);
        }
        this.callGetCurrentItem();
        Vec3d vec3d = new Vec3d((PBotPlayerController.getHitVec2(ray).x) - (target.posX), (PBotPlayerController.getHitVec3(ray).y) - (target.posY), (PBotPlayerController.getHitVec(ray).z) - (target.posZ));
        (this.connection).sendPacket((Packet)new PlayerInteractEntityC2SPacket(target, hand, vec3d));
        return (this.currentGameType) == (GameType.SPECTATOR) ? (ActionResult.PASS) : target.applyPlayerInteraction(player, vec3d, hand);
    }

    public boolean onPlayerDamageBlock(BlockPos posBlock, Direction directionFacing) {
        this.callGetCurrentItem();
        if ((this.blockHitDelay) > 0) {
            PBotPlayerController cQ = this;
            cQ.blockHitDelay = PBotPlayerController.getBlockHitDelay2(cQ) - (1);
            return true;
        }
        if ((this.currentGameType).isCreative() && (this.pbot).world.getWorldBorder().contains(posBlock)) {
            this.blockHitDelay = 5;
            (this.connection).sendPacket((Packet)new PlayerActionC2SPacket((PlayerActionC2SPacket.Action.START_DESTROY_BLOCK), posBlock, directionFacing));
            this.clickBlockCreative(this, posBlock, directionFacing);
            return true;
        }
        if (this.isHittingPosition(posBlock)) {
            BlockState iblockstate = (this.pbot).world.getBlockState(posBlock);
            Block block = iblockstate.getBlock();
            if (iblockstate.getMaterial() == (Material.AIR)) {
                this.isHittingBlock = false;
                return false;
            }
            PBotPlayerController cQ = this;
            cQ.curBlockDamageMP = PBotPlayerController.getCurBlockDamageMP(cQ) + iblockstate.getPlayerRelativeBlockHardness((PlayerEntity)PBotPlayerController.getPlayer4(PBotPlayerController.getPbot27(this)), PBotPlayerController.getWorld2(PBotPlayerController.getPlayer15(PBotPlayerController.getPbot36(this))), posBlock);
            if ((this.stepSoundTickCounter) % 4.0f == 0.0f) {
                block.getSoundType();
            }
            PBotPlayerController cQ2 = this;
            cQ2.stepSoundTickCounter = PBotPlayerController.getStepSoundTickCounter(cQ2) + 1.0f;
            if ((this.curBlockDamageMP) >= 1.0f) {
                this.isHittingBlock = false;
                (this.connection).sendPacket((Packet)new PlayerActionC2SPacket((PlayerActionC2SPacket.Action.STOP_DESTROY_BLOCK), posBlock, directionFacing));
                this.onPlayerDestroyBlock(posBlock);
                this.curBlockDamageMP = 0.0f;
                this.stepSoundTickCounter = 0.0f;
                this.blockHitDelay = 5;
            }
            (this.pbot).world.sendBlockBreakProgress((PBotPlayerController.getPbot20(this).player).getEntityId(), (this.currentBlock), (int)((this.curBlockDamageMP) * 10.0f) - (1));
            return true;
        }
        return this.clickBlock(posBlock, directionFacing);
    }

    private static PBotPlayer getPlayer21(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot38(PBotPlayerController instance) {
        return instance.pbot;
    }

    public void setPlayerCapabilities(PlayerEntity player) {
        (this.currentGameType).configurePlayerCapabilities((player.capabilities));
    }

    private static PBot getPbot39(PBotPlayerController instance) {
        return instance.pbot;
    }

    private static BlockPos getCurrentBlock8(PBotPlayerController instance) {
        return instance.currentBlock;
    }

    public void setGameType(GameType type) {
        this.currentGameType = type;
        (this.currentGameType).configurePlayerCapabilities((PBotPlayerController.JqPqglreez(PBotPlayerController.getPbot17(this)).capabilities));
    }

    private static PBotPlayer getPlayer26(PBot instance) {
        return instance.player;
    }

}

