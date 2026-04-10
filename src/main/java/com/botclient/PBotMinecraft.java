/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  com.google.common.base.Predicates
 *  com.google.common.collect.Queues
 *  com.google.common.util.concurrent.Futures
 *  com.google.common.util.concurrent.ListenableFuture
 *  com.google.common.util.concurrent.ListenableFutureTask
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.BotKeyState
 *  neo.deobf.EntityCollisionPredicate
 *  neo.deobf.RayTraceTypeSwitchMap
 *  neo.deobf.BotMovementInput
 *  neo.deobf.PBotNetHandlerPlayClient
 *  neo.deobf.PBotPlayerController
 *  neo.deobf.PBotWorldClient
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketTabComplete
 *  net.minecraft.profiler.ISnooperInfo
 *  net.minecraft.profiler.Profiler
 *  net.minecraft.profiler.Snooper
 *  net.minecraft.util.EntitySelectors
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.IThreadListener
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.Util
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.apache.commons.lang3.Validate
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package neo.deobf;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import neo.deobf.PBot;
import neo.deobf.PBotPlayer;
import neo.deobf.BotKeyState;
import neo.deobf.EntityCollisionPredicate;
import neo.deobf.RayTraceTypeSwitchMap;
import neo.deobf.BotMovementInput;
import neo.deobf.PBotNetHandlerPlayClient;
import neo.deobf.PBotPlayerController;
import neo.deobf.PBotWorldClient;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketTabComplete;
import net.minecraft.profiler.ISnooperInfo;
import net.minecraft.profiler.Profiler;
import net.minecraft.profiler.Snooper;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.MovementInput;
import net.minecraft.util.Util;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PBotMinecraft
implements IThreadListener,
ISnooperInfo {
    public final PBot pbot;
    public BotKeyState gameSettings;
    public PBotPlayerController playerController;
    public RayTraceResult objectMouseOver;
    public final Queue<FutureTask<?>> scheduledTasks;
    public final Profiler profiler = new Profiler();
    public final Logger LOGGER = LogManager.getLogger();
    public int worldId;

    private static PBot getPbot(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static BotKeyState getGameSettings(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBot getPbot2(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot3(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot4(PBotMinecraft instance) {
        return instance.pbot;
    }

    public void clickMouse() {
        if ((this.objectMouseOver) != null && !(PBotMinecraft.getPbot25(this).player).isRowingBoat()) {
            switch ((RayTraceTypeSwitchMap.$SwitchMap$net$minecraft$util$math$RayTraceResult$Type)[(PBotMinecraft.getObjectMouseOver17(this).typeOfHit).ordinal()]) {
                case 1: {
                    (this.playerController).attackEntity((EntityPlayer)(PBotMinecraft.getPbot34(this).player), (PBotMinecraft.getObjectMouseOver22(this).entityHit));
                    break;
                }
                case 2: {
                    BlockPos blockpos = (this.objectMouseOver).getBlockPos();
                    if ((this.pbot).getWorld().getBlockState(blockpos).getMaterial() != (Material.AIR)) {
                        (this.playerController).clickBlock(blockpos, (PBotMinecraft.getObjectMouseOver6(this).sideHit));
                        break;
                    }
                }
                case 3: {
                    (PBotMinecraft.getPbot32(this).player).resetCooldown();
                }
            }
            (PBotMinecraft.getPbot49(this).player).swingArm((EnumHand.MAIN_HAND));
        }
    }

    private static BotKeyState getGameSettings2(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static RayTraceResult getObjectMouseOver2(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    private static PBot getPbot6(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot7(PBotMinecraft instance) {
        return instance.pbot;
    }

    public void addServerStatsToSnooper(Snooper playerSnooper) {
    }

    private static PBot getPbot8(PBotMinecraft instance) {
        return instance.pbot;
    }

    public void addServerTypeToSnooper(Snooper playerSnooper) {
    }

    private static RayTraceResult getObjectMouseOver3(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    private static RayTraceResult getObjectMouseOver6(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    private static PBotMinecraft getMc(PBot instance) {
        return instance.mc;
    }

    private static PBot getPbot11(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot13(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot14(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer10(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer12(PBot instance) {
        return instance.player;
    }

    private static RayTraceResult getObjectMouseOver8(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    public void setDimensionAndSpawnPlayer(int dimension) {
        (this.pbot).getWorld().setInitialSpawnLocation();
        (this.pbot).getWorld().removeAllEntities();
        int i = 0;
        String s = null;
        if ((PBotMinecraft.getPbot30(this).player) != null) {
            i = (PBotMinecraft.getPbot27(this).player).getEntityId();
            (this.pbot).getWorld().removeEntity((Entity)(PBotMinecraft.getPbot44(this).player));
            s = (PBotMinecraft.getPbot26(this).player).getServerBrand();
        }
        PBotMinecraft.getPbot38(this).player = new PBotPlayer(PBotMinecraft.getPbot47(this));
        (PBotMinecraft.getPbot17(this).player).getDataManager().setEntryValues((PBotMinecraft.getPbot46(this).player).getDataManager().getAll());
        PBotMinecraft.getPlayer10(PBotMinecraft.getPbot55(this)).dimension = dimension;
        (PBotMinecraft.getPbot7(this).player).preparePlayerToSpawn();
        (PBotMinecraft.getPbot29(this).player).setServerBrand(s);
        (this.pbot).getWorld().spawnEntity((Entity)(PBotMinecraft.getPbot35(this).player));
        (this.playerController).flipPlayer((EntityPlayer)(PBotMinecraft.getPbot13(this).player));
        PBotMinecraft.getPlayer33(PBotMinecraft.getPbot60(this)).movementInput = (MovementInput)new BotMovementInput(PBotMinecraft.getGameSettings(this));
        (PBotMinecraft.getPbot63(this).player).setEntityId(i);
        (this.playerController).setPlayerCapabilities((EntityPlayer)(PBotMinecraft.getPbot40(this).player));
        (PBotMinecraft.getPbot2(this).player).setReducedDebug((PBotMinecraft.getPbot51(this).player).hasReducedDebug());
    }

    private static PBot getPbot15(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer17(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot16(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot17(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot18(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static RayTraceResult getObjectMouseOver10(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    private static PBot getPbot21(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static RayTraceResult getObjectMouseOver11(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    private static RayTraceResult getObjectMouseOver12(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    public void requestCompletions(String prefix) {
        if (prefix.length() >= (1)) {
            (PBotMinecraft.getPlayer12(PBotMinecraft.getPbot15(this)).connection).sendPacket((Packet)new CPacketTabComplete(prefix, this.getTargetBlockPos(), false));
        }
    }

    private static PBot getPbot23(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot24(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static RayTraceResult getObjectMouseOver13(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    private static PBotMinecraft getMc2(PBot instance) {
        return instance.mc;
    }

    private static PBot getPbot25(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot26(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot27(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot28(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot29(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static BotKeyState getGameSettings3(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBot getPbot30(PBotMinecraft instance) {
        return instance.pbot;
    }

    public void runTickKeyboard() {
        this.callGetPlayer20((PBotMinecraft.getGameSettings3(this).keyBindAttack));
    }

    public void getMouseOver() {
        float partialTicks = 1.0f;
        if ((this.pbot).getWorld() != null) {
            double d0 = (this.playerController).getBlockReachDistance();
            this.objectMouseOver = PBotMinecraft.getPlayer17(PBotMinecraft.getPbot3(this)).rayTrace(d0, partialTicks);
            Vec3d vec3d = (PBotMinecraft.getPbot4(this).player).getPositionEyes(partialTicks);
            int flag = 0;
            double d1 = d0;
            if ((this.playerController).extendedReach()) {
                d0 = d1 = 6.0;
            } else if (d0 > 3.0) {
                flag = 1;
            }
            if ((this.objectMouseOver) != null) {
                d1 = (PBotMinecraft.getObjectMouseOver13(this).hitVec).distanceTo(vec3d);
            }
            Vec3d vec3d1 = (PBotMinecraft.getPbot23(this).player).getLook(1.0f);
            Vec3d vec3d2 = vec3d.add((vec3d1.x) * d0, (vec3d1.y) * d0, (vec3d1.z) * d0);
            Entity pointedEntity = null;
            Vec3d vec3d3 = null;
            List list = (this.pbot).getWorld().getEntitiesInAABBexcluding((Entity)(PBotMinecraft.getPbot42(this).player), (PBotMinecraft.getPbot33(this).player).getEntityBoundingBox().grow((vec3d1.x) * d0, (vec3d1.y) * d0, (vec3d1.z) * d0).grow(1.0, 1.0, 1.0), Predicates.and((Predicate)(EntitySelectors.NOT_SPECTATING), (Predicate)new EntityCollisionPredicate(this)));
            double d2 = d1;
            for (Entity entity1 : list) {
                double d3;
                AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow((double)entity1.getCollisionBorderSize());
                RayTraceResult raytraceresult = axisalignedbb.calculateIntercept(vec3d, vec3d2);
                if (axisalignedbb.contains(vec3d)) {
                    if (!(d2 >= 0.0)) continue;
                    pointedEntity = entity1;
                    vec3d3 = raytraceresult == null ? vec3d : (raytraceresult.hitVec);
                    d2 = 0.0;
                    continue;
                }
                if (raytraceresult == null || !((d3 = vec3d.distanceTo((raytraceresult.hitVec))) < d2) && d2 != 0.0) continue;
                if (entity1.getLowestRidingEntity() == (PBotMinecraft.getPbot31(this).player).getLowestRidingEntity()) {
                    if (d2 != 0.0) continue;
                    pointedEntity = entity1;
                    vec3d3 = (raytraceresult.hitVec);
                    continue;
                }
                pointedEntity = entity1;
                vec3d3 = (raytraceresult.hitVec);
                d2 = d3;
            }
            if (pointedEntity != null && flag != 0 && vec3d.distanceTo(vec3d3) > 3.0) {
                pointedEntity = null;
                this.objectMouseOver = new RayTraceResult((RayTraceResult.Type.MISS), vec3d3, (EnumFacing)null, new BlockPos(vec3d3));
            }
            if (pointedEntity != null && (d2 < d1 || (this.objectMouseOver) == null)) {
                this.objectMouseOver = new RayTraceResult(pointedEntity, vec3d3);
            }
        }
    }

    private static PBot getPbot31(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot32(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot33(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot34(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot35(PBotMinecraft instance) {
        return instance.pbot;
    }

    public <V> ListenableFuture<V> addScheduledTask(Callable<V> callableToSchedule) {
        Validate.notNull(callableToSchedule);
        if (this.isCallingFromMinecraftThread()) {
            try {
                return Futures.immediateFuture(callableToSchedule.call());
            }
            catch (Exception exception) {
                return Futures.immediateFailedCheckedFuture((Exception)exception);
            }
        }
        ListenableFutureTask listenablefuturetask = ListenableFutureTask.create(callableToSchedule);
        (this.scheduledTasks).add(listenablefuturetask);
        return listenablefuturetask;
    }

    private static PBot getPbot36(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot37(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot38(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot40(PBotMinecraft instance) {
        return instance.pbot;
    }

    public BlockPos getTargetBlockPos() {
        BlockPos blockpos = null;
        if ((this.objectMouseOver) != null && (PBotMinecraft.getObjectMouseOver12(this).typeOfHit) == (RayTraceResult.Type.BLOCK)) {
            blockpos = (this.objectMouseOver).getBlockPos();
        }
        return blockpos;
    }

    private static RayTraceResult getObjectMouseOver16(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    private void callGetPlayer20(boolean leftClick) {
        if (!(PBotMinecraft.getPbot62(this).player).isHandActive()) {
            if (leftClick && (this.objectMouseOver) != null && (PBotMinecraft.getObjectMouseOver11(this).typeOfHit) == (RayTraceResult.Type.BLOCK)) {
                BlockPos blockpos = (this.objectMouseOver).getBlockPos();
                if ((this.pbot).getWorld().getBlockState(blockpos).getMaterial() != (Material.AIR) && (this.playerController).onPlayerDamageBlock(blockpos, (PBotMinecraft.getObjectMouseOver8(this).sideHit))) {
                    (PBotMinecraft.getPbot48(this).player).swingArm((EnumHand.MAIN_HAND));
                }
            } else {
                (this.playerController).resetBlockRemoving();
            }
        }
    }

    private static RayTraceResult getObjectMouseOver17(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    private static PBot getPbot41(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot42(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static RayTraceResult getObjectMouseOver18(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    public boolean isSnooperEnabled() {
        return false;
    }

    private static PBot getPbot44(PBotMinecraft instance) {
        return instance.pbot;
    }

    public PBotMinecraft(PBot pbot) {
        this.scheduledTasks = Queues.newArrayDeque();
        this.gameSettings = new BotKeyState();
        this.pbot = pbot;
    }

    private static PBot getPbot46(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot47(PBotMinecraft instance) {
        return instance.pbot;
    }

    public void rightClickMouse() {
        if (!(this.playerController).getIsHittingBlock() && !(PBotMinecraft.getPbot16(this).player).isRowingBoat()) {
            EnumHand[] enumHandArray = EnumHand.values();
            int n = enumHandArray.length;
            for (int i = 0; i < n; ++i) {
                EnumHand enumhand = enumHandArray[i];
                ItemStack itemstack = (PBotMinecraft.getPbot41(this).player).getHeldItem(enumhand);
                if ((this.objectMouseOver) != null) {
                    switch ((RayTraceTypeSwitchMap.$SwitchMap$net$minecraft$util$math$RayTraceResult$Type)[(PBotMinecraft.getObjectMouseOver16(this).typeOfHit).ordinal()]) {
                        case 1: {
                            if ((this.playerController).interactWithEntity((EntityPlayer)(PBotMinecraft.getPbot18(this).player), (PBotMinecraft.getObjectMouseOver10(this).entityHit), (this.objectMouseOver), enumhand) == (EnumActionResult.SUCCESS)) {
                                return;
                            }
                            if ((this.playerController).interactWithEntity((EntityPlayer)(PBotMinecraft.getPbot59(this).player), (PBotMinecraft.getObjectMouseOver2(this).entityHit), enumhand) != (EnumActionResult.SUCCESS)) break;
                            return;
                        }
                        case 2: {
                            BlockPos blockpos = (this.objectMouseOver).getBlockPos();
                            if ((this.pbot).getWorld().getBlockState(blockpos).getMaterial() == (Material.AIR)) break;
                            int i2 = itemstack.getCount();
                            EnumActionResult enumactionresult = (this.playerController).processRightClickBlock((PBotMinecraft.getPbot53(this).player), (World)(this.pbot).getWorld(), blockpos, (PBotMinecraft.getObjectMouseOver3(this).sideHit), (PBotMinecraft.getObjectMouseOver18(this).hitVec), enumhand);
                            if (enumactionresult != (EnumActionResult.SUCCESS)) break;
                            (PBotMinecraft.getPbot37(this).player).swingArm(enumhand);
                            return;
                        }
                    }
                }
                if (itemstack.isEmpty() || (this.playerController).processRightClick((EntityPlayer)(PBotMinecraft.getPbot36(this).player), (World)(this.pbot).getWorld(), enumhand) != (EnumActionResult.SUCCESS)) continue;
                return;
            }
        }
    }

    private static PBot getPbot48(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer33(PBot instance) {
        return instance.player;
    }

    private static RayTraceResult getObjectMouseOver22(PBotMinecraft instance) {
        return instance.objectMouseOver;
    }

    private static PBot getPbot49(PBotMinecraft instance) {
        return instance.pbot;
    }

    public boolean isCallingFromMinecraftThread() {
        return true;
    }

    private static PBot getPbot50(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot51(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer35(PBot instance) {
        return instance.player;
    }

    public void loadWorld(PBotWorldClient world) {
        if (world == null) {
            PBotNetHandlerPlayClient net = (this.pbot).getPlayHandler();
            if (net != null) {
                net.cleanup();
            }
            this.playerController = null;
        }
        (this.pbot).setWorld(world);
        if ((PBotMinecraft.getPbot56(this).player) == null) {
            PBotMinecraft.getPbot24(this).player = new PBotPlayer(PBotMinecraft.getPbot50(this));
            (PBotMinecraft.getMc3(PBotMinecraft.getPbot28(this)).playerController).flipPlayer((EntityPlayer)(PBotMinecraft.getPbot11(this).player));
        }
        if (world != null) {
            (PBotMinecraft.getPbot6(this).player).preparePlayerToSpawn();
            (this.pbot).getWorld().spawnEntity((Entity)(PBotMinecraft.getPbot8(this).player));
            PBotMinecraft.getPlayer35(PBotMinecraft.getPbot14(this)).movementInput = (MovementInput)new BotMovementInput(PBotMinecraft.getGameSettings2(PBotMinecraft.getMc(PBotMinecraft.getPbot57(this))));
            (PBotMinecraft.getMc2(PBotMinecraft.getPbot(this)).playerController).setPlayerCapabilities((EntityPlayer)(PBotMinecraft.getPbot21(this).player));
        }
    }

    private static PBot getPbot53(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot55(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot56(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot57(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot59(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot60(PBotMinecraft instance) {
        return instance.pbot;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void execTasks() {
        Queue queue = (this.scheduledTasks);
        synchronized (queue) {
            while (!(this.scheduledTasks).isEmpty()) {
                Util.runTask((FutureTask)((FutureTask)(this.scheduledTasks).poll()), (Logger)(this.LOGGER));
            }
        }
    }

    private static PBot getPbot62(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBot getPbot63(PBotMinecraft instance) {
        return instance.pbot;
    }

    private static PBotMinecraft getMc3(PBot instance) {
        return instance.mc;
    }

    public ListenableFuture<Object> addScheduledTask(Runnable runnableToSchedule) {
        Validate.notNull((Object)runnableToSchedule);
        return this.addScheduledTask(Executors.callable(runnableToSchedule));
    }

}

