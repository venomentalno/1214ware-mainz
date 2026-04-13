/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.PBotNetHandlerPlayClient
 *  neo.deobf.PBotWorldClient
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockCommandBlock
 *  net.minecraft.block.BlockStructure
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.Container
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.client.CPacketCreativeInventoryAction
 *  net.minecraft.network.play.client.CPacketCustomPayload
 *  net.minecraft.network.play.client.CPacketEnchantItem
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.GameType
 *  net.minecraft.world.World
 */
package neo.deobf;

import io.netty.buffer.Unpooled;
import neo.deobf.PBot;
import neo.deobf.PBotPlayer;
import neo.deobf.PBotMinecraft;
import neo.deobf.PBotNetHandlerPlayClient;
import neo.deobf.PBotWorldClient;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.BlockStructure;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketCreativeInventoryAction;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.play.client.CPacketEnchantItem;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
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

    public ItemStack windowClick(int windowId, int slotId, int mouseButton, ClickType type, EntityPlayer player) {
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
        (this.connection).sendPacket((Packet)new CPacketCustomPayload("MC|PickItem", new PacketBuffer(Unpooled.buffer()).writeVarInt(index)));
    }

    public void attackEntity(EntityPlayer playerIn, Entity targetEntity) {
        this.callGetCurrentItem();
        (this.connection).sendPacket((Packet)new CPacketUseEntity(targetEntity));
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
            (this.connection).sendPacket((Packet)new CPacketHeldItemChange((this.currentPlayerItem)));
        }
    }

    public EnumActionResult processRightClickBlock(PBotPlayer player, World worldIn, BlockPos pos, EnumFacing direction, Vec3d vec, EnumHand hand) {
        this.callGetCurrentItem();
        ItemStack itemstack = player.getHeldItem(hand);
        float f = (float)((vec.x) - (double)pos.getX());
        float f1 = (float)((vec.y) - (double)pos.getY());
        float f2 = (float)((vec.z) - (double)pos.getZ());
        int flag = 0;
        if (!(this.pbot).getWorld().getWorldBorder().contains(pos)) {
            return (EnumActionResult.FAIL);
        }
        if ((this.currentGameType) != (GameType.SPECTATOR)) {
            ItemBlock itemblock;
            IBlockState iblockstate = worldIn.getBlockState(pos);
            if ((!player.isSneaking() || player.getHeldItemMainhand().isEmpty() && player.getHeldItemOffhand().isEmpty()) && iblockstate.getBlock().onBlockActivated(worldIn, pos, iblockstate, (EntityPlayer)player, hand, direction, f, f1, f2)) {
                flag = 1;
            }
            if (flag == 0 && itemstack.getItem() instanceof ItemBlock && !(itemblock = (ItemBlock)itemstack.getItem()).canPlaceBlockOnSide(worldIn, pos, direction, (EntityPlayer)player, itemstack)) {
                return (EnumActionResult.FAIL);
            }
        }
        (this.connection).sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(pos, direction, hand, f, f1, f2));
        if (flag == 0 && (this.currentGameType) != (GameType.SPECTATOR)) {
            Block block;
            if (itemstack.isEmpty()) {
                return (EnumActionResult.PASS);
            }
            if (player.getCooldownTracker().hasCooldown(itemstack.getItem())) {
                return (EnumActionResult.PASS);
            }
            if (itemstack.getItem() instanceof ItemBlock && !player.canUseCommandBlock() && ((block = ((ItemBlock)itemstack.getItem()).getBlock()) instanceof BlockCommandBlock || block instanceof BlockStructure)) {
                return (EnumActionResult.FAIL);
            }
            if ((this.currentGameType).isCreative()) {
                int i = itemstack.getMetadata();
                int j = itemstack.getCount();
                EnumActionResult enumactionresult = itemstack.onItemUse((EntityPlayer)player, worldIn, pos, hand, direction, f, f1, f2);
                itemstack.setItemDamage(i);
                itemstack.setCount(j);
                return enumactionresult;
            }
            return itemstack.onItemUse((EntityPlayer)player, worldIn, pos, hand, direction, f, f1, f2);
        }
        return (EnumActionResult.SUCCESS);
    }

    private static PBot getPbot6(PBotPlayerController instance) {
        return instance.pbot;
    }

    public void onStoppedUsingItem(EntityPlayer playerIn) {
        this.callGetCurrentItem();
        (this.connection).sendPacket((Packet)new CPacketPlayerDigging((CPacketPlayerDigging.Action.RELEASE_USE_ITEM), (BlockPos.ORIGIN), (EnumFacing.DOWN)));
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

    public EnumActionResult processRightClick(EntityPlayer player, World worldIn, EnumHand hand) {
        if ((this.currentGameType) == (GameType.SPECTATOR)) {
            return (EnumActionResult.PASS);
        }
        this.callGetCurrentItem();
        (this.connection).sendPacket((Packet)new CPacketPlayerTryUseItem(hand));
        ItemStack itemstack = player.getHeldItem(hand);
        if (player.getCooldownTracker().hasCooldown(itemstack.getItem())) {
            return (EnumActionResult.PASS);
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
            (this.connection).sendPacket((Packet)new CPacketCreativeInventoryAction(slotId, itemStackIn));
        }
    }

    private static float getStepSoundTickCounter(PBotPlayerController instance) {
        return instance.stepSoundTickCounter;
    }

    private static Vec3d getHitVec(RayTraceResult rayTraceResult) {
        return rayTraceResult.hitVec;
    }

    private static PBot getPbot13(PBotPlayerController instance) {
        return instance.pbot;
    }

    public EnumActionResult interactWithEntity(EntityPlayer player, Entity target, EnumHand hand) {
        if (target == null) {
            return (EnumActionResult.FAIL);
        }
        this.callGetCurrentItem();
        (this.connection).sendPacket((Packet)new CPacketUseEntity(target, hand));
        return (this.currentGameType) == (GameType.SPECTATOR) ? (EnumActionResult.PASS) : player.interactOn(target, hand);
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

    private static Vec3d getHitVec2(RayTraceResult rayTraceResult) {
        return rayTraceResult.hitVec;
    }

    public void sendPacketDropItem(ItemStack itemStackIn) {
        if ((this.currentGameType).isCreative() && !itemStackIn.isEmpty()) {
            (this.connection).sendPacket((Packet)new CPacketCreativeInventoryAction(-1, itemStackIn));
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
                if (!itemstack.canDestroy((this.pbot).getWorld().getBlockState(pos).getBlock())) {
                    return false;
                }
            }
        }
        if ((this.currentGameType).isCreative() && !(PBotPlayerController.getPbot31(this).player).getHeldItemMainhand().isEmpty() && (PBotPlayerController.getPbot30(this).player).getHeldItemMainhand().getItem() instanceof ItemSword) {
            return false;
        }
        PBotWorldClient world = (this.pbot).getWorld();
        IBlockState iblockstate = world.getBlockState(pos);
        Block block = iblockstate.getBlock();
        if ((block instanceof BlockCommandBlock || block instanceof BlockStructure) && !(PBotPlayerController.getPbot18(this).player).canUseCommandBlock()) {
            return false;
        }
        if (iblockstate.getMaterial() == (Material.AIR)) {
            return false;
        }
        world.playEvent(2001, pos, Block.getStateId((IBlockState)iblockstate));
        block.onBlockHarvested((World)world, pos, iblockstate, (EntityPlayer)(PBotPlayerController.getPbot25(this).player));
        boolean flag = world.setBlockState(pos, (Blocks.AIR).getDefaultState(), 11);
        if (flag) {
            block.onPlayerDestroy((World)world, pos, iblockstate);
        }
        this.currentBlock = new BlockPos(PBotPlayerController.getCurrentBlock8(this).getX(), -1, PBotPlayerController.getCurrentBlock5(this).getZ());
        if (!(this.currentGameType).isCreative() && !(itemstack1 = (PBotPlayerController.getPbot24(this).player).getHeldItemMainhand()).isEmpty()) {
            itemstack1.onBlockDestroyed((World)world, iblockstate, pos, (EntityPlayer)(PBotPlayerController.getPbot(this).player));
            if (itemstack1.isEmpty()) {
                (PBotPlayerController.getPbot2(this).player).setHeldItem((EnumHand.MAIN_HAND), (ItemStack.EMPTY));
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

    public void clickBlockCreative(PBotPlayerController playerController, BlockPos pos, EnumFacing facing) {
        if (!(this.pbot).getWorld().extinguishFire((EntityPlayer)(PBotPlayerController.getPbot3(this).player), pos, facing)) {
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

    private static Vec3d getHitVec3(RayTraceResult rayTraceResult) {
        return rayTraceResult.hitVec;
    }

    private static BlockPos getCurrentBlock5(PBotPlayerController instance) {
        return instance.currentBlock;
    }

    public boolean clickBlock(BlockPos loc, EnumFacing face) {
        if ((this.currentGameType).equals((Object)(GameType.ADVENTURE))) {
            if ((this.currentGameType) == (GameType.SPECTATOR)) {
                return false;
            }
            if (!(PBotPlayerController.getPbot8(this).player).isAllowEdit()) {
                ItemStack itemstack = (PBotPlayerController.getPbot34(this).player).getHeldItemMainhand();
                if (itemstack.isEmpty()) {
                    return false;
                }
                if (!itemstack.canDestroy((this.pbot).getWorld().getBlockState(loc).getBlock())) {
                    return false;
                }
            }
        }
        if (!(this.pbot).getWorld().getWorldBorder().contains(loc)) {
            return false;
        }
        if ((this.currentGameType).isCreative()) {
            (this.connection).sendPacket((Packet)new CPacketPlayerDigging((CPacketPlayerDigging.Action.START_DESTROY_BLOCK), loc, face));
            this.clickBlockCreative(this, loc, face);
            this.blockHitDelay = 5;
        } else if (!(this.isHittingBlock) || !this.isHittingPosition(loc)) {
            int flag;
            if ((this.isHittingBlock)) {
                (this.connection).sendPacket((Packet)new CPacketPlayerDigging((CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK), (this.currentBlock), face));
            }
            IBlockState iblockstate = (this.pbot).getWorld().getBlockState(loc);
            (this.connection).sendPacket((Packet)new CPacketPlayerDigging((CPacketPlayerDigging.Action.START_DESTROY_BLOCK), loc, face));
            int n = flag = iblockstate.getMaterial() != (Material.AIR) ? 1 : 0;
            if (flag != 0 && (this.curBlockDamageMP) == 0.0f) {
                iblockstate.getBlock().onBlockClicked((World)(this.pbot).getWorld(), loc, (EntityPlayer)(PBotPlayerController.getPbot26(this).player));
            }
            if (flag != 0 && iblockstate.getPlayerRelativeBlockHardness((EntityPlayer)(PBotPlayerController.getPbot6(this).player), (PBotPlayerController.getPlayer9(PBotPlayerController.getPbot38(this)).world), loc) >= 1.0f) {
                this.onPlayerDestroyBlock(loc);
            } else {
                this.isHittingBlock = true;
                this.currentBlock = loc;
                this.currentItemHittingBlock = PBotPlayerController.getPlayer26(PBotPlayerController.getPbot19(this)).getHeldItemMainhand();
                this.curBlockDamageMP = 0.0f;
                this.stepSoundTickCounter = 0.0f;
                (this.pbot).getWorld().sendBlockBreakProgress((PBotPlayerController.getPbot11(this).player).getEntityId(), (this.currentBlock), (int)((this.curBlockDamageMP) * 10.0f) - (1));
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
            (this.connection).sendPacket((Packet)new CPacketPlayerDigging((CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK), (this.currentBlock), (EnumFacing.DOWN)));
            this.isHittingBlock = false;
            this.curBlockDamageMP = 0.0f;
            (this.pbot).getWorld().sendBlockBreakProgress((PBotPlayerController.getPbot14(this).player).getEntityId(), (this.currentBlock), -1);
            (PBotPlayerController.getPbot10(this).player).resetCooldown();
        }
    }

    private static World getWorld2(PBotPlayer instance) {
        return instance.world;
    }

    public void flipPlayer(EntityPlayer playerIn) {
        playerIn.rotationYaw = -180.0f;
    }

    public EnumActionResult interactWithEntity(EntityPlayer player, Entity target, RayTraceResult ray, EnumHand hand) {
        if (target == null) {
            return (EnumActionResult.FAIL);
        }
        this.callGetCurrentItem();
        Vec3d vec3d = new Vec3d((PBotPlayerController.getHitVec2(ray).x) - (target.posX), (PBotPlayerController.getHitVec3(ray).y) - (target.posY), (PBotPlayerController.getHitVec(ray).z) - (target.posZ));
        (this.connection).sendPacket((Packet)new CPacketUseEntity(target, hand, vec3d));
        return (this.currentGameType) == (GameType.SPECTATOR) ? (EnumActionResult.PASS) : target.applyPlayerInteraction(player, vec3d, hand);
    }

    public boolean onPlayerDamageBlock(BlockPos posBlock, EnumFacing directionFacing) {
        this.callGetCurrentItem();
        if ((this.blockHitDelay) > 0) {
            PBotPlayerController cQ = this;
            cQ.blockHitDelay = PBotPlayerController.getBlockHitDelay2(cQ) - (1);
            return true;
        }
        if ((this.currentGameType).isCreative() && (this.pbot).getWorld().getWorldBorder().contains(posBlock)) {
            this.blockHitDelay = 5;
            (this.connection).sendPacket((Packet)new CPacketPlayerDigging((CPacketPlayerDigging.Action.START_DESTROY_BLOCK), posBlock, directionFacing));
            this.clickBlockCreative(this, posBlock, directionFacing);
            return true;
        }
        if (this.isHittingPosition(posBlock)) {
            IBlockState iblockstate = (this.pbot).getWorld().getBlockState(posBlock);
            Block block = iblockstate.getBlock();
            if (iblockstate.getMaterial() == (Material.AIR)) {
                this.isHittingBlock = false;
                return false;
            }
            PBotPlayerController cQ = this;
            cQ.curBlockDamageMP = PBotPlayerController.getCurBlockDamageMP(cQ) + iblockstate.getPlayerRelativeBlockHardness((EntityPlayer)PBotPlayerController.getPlayer4(PBotPlayerController.getPbot27(this)), PBotPlayerController.getWorld2(PBotPlayerController.getPlayer15(PBotPlayerController.getPbot36(this))), posBlock);
            if ((this.stepSoundTickCounter) % 4.0f == 0.0f) {
                block.getSoundType();
            }
            PBotPlayerController cQ2 = this;
            cQ2.stepSoundTickCounter = PBotPlayerController.getStepSoundTickCounter(cQ2) + 1.0f;
            if ((this.curBlockDamageMP) >= 1.0f) {
                this.isHittingBlock = false;
                (this.connection).sendPacket((Packet)new CPacketPlayerDigging((CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK), posBlock, directionFacing));
                this.onPlayerDestroyBlock(posBlock);
                this.curBlockDamageMP = 0.0f;
                this.stepSoundTickCounter = 0.0f;
                this.blockHitDelay = 5;
            }
            (this.pbot).getWorld().sendBlockBreakProgress((PBotPlayerController.getPbot20(this).player).getEntityId(), (this.currentBlock), (int)((this.curBlockDamageMP) * 10.0f) - (1));
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

    public void setPlayerCapabilities(EntityPlayer player) {
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

