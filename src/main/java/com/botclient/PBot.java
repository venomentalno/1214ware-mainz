/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  io.netty.channel.Channel
 *  javax.vecmath.Vector2f
 *  neo.deobf.TextSetting
 *  neo.deobf.Client
 *  neo.deobf.PBotManager
 *  neo.deobf.ModuleManager
 *  neo.deobf.AutoRegisterModule
 *  neo.deobf.BooleanSetting
 *  neo.deobf.ModeSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.PBotPlayer
 *  neo.deobf.BotKeyState
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.PBotStatFileWriter
 *  neo.deobf.PBotNetHandlerPlayClient
 *  neo.deobf.PBotNetworkManager
 *  neo.deobf.PBotPlayerController
 *  neo.deobf.ServerStatusPinger
 *  neo.deobf.PBotClientWorld
 *  neo.deobf.BotController
 *  neo.deobf.AutoRejoinModule
 *  neo.deobf.BotDebugModule
 *  neo.deobf.BotSettingsModule
 *  neo.deobf.CaptchaManagerModule
 *  neo.deobf.BotsCommand
 *  neo.deobf.ScriptManager
 *  neo.deobf.ChatUtils
 *  neo.deobf.BotSpammer
 *  neo.deobf.BlockUtils
 *  neo.deobf.CaptchaPacket
 *  neo.deobf.CaptchaDetector
 *  neo.deobf.PlaceholderFormatter
 *  neo.deobf.RandomUtils
 *  neo.deobf.MillisTimer
 *  neo.deobf.ProxyInfo
 *  neo.deobf.ThreadUtils
 *  net.minecraft.block.BlockColored
 *  net.minecraft.block.properties.IProperty
 *  net.minecraft.block.properties.PropertyEnum
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.PlayerEntitySP
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.screen.ScreenHandlerRepair
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.EnumDyeColor
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemMap
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.EnumConnectionState
 *  net.minecraft.network.INetHandler
 *  net.minecraft.network.Packet
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.handshake.client.C00Handshake
 *  net.minecraft.network.login.client.CPacketLoginStart
 *  net.minecraft.network.play.client.ChatMessageC2SPacket
 *  net.minecraft.network.play.client.CloseHandledScreenC2SPacket
 *  net.minecraft.network.play.client.CustomPayloadC2SPacket
 *  net.minecraft.network.play.client.SelectedSlotChangeC2SPacket
 *  net.minecraft.network.play.client.PlayerActionC2SPacket
 *  net.minecraft.network.play.client.PlayerActionC2SPacket$Action
 *  net.minecraft.network.play.client.PlayerInteractBlockC2SPacket
 *  net.minecraft.network.play.client.PlayerInteractEntityC2SPacket
 *  net.minecraft.potion.PotionUtils
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.Hand
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.Session
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package com.botclient;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.joml.Vector2f;
import com.botclient.TextSetting;
import com.botclient.Client;
import com.botclient.PBotManager;
import com.botclient.ModuleManager;
import com.botclient.AutoRegisterModule;
import com.botclient.BooleanSetting;
import com.botclient.ModeSetting;
import com.botclient.NumberSetting;
import com.botclient.PBotPlayer;
import com.botclient.BotKeyState;
import com.botclient.PBotMinecraft;
import com.botclient.PBotStatFileWriter;
import com.botclient.PBotNetHandlerPlayClient;
import com.botclient.PBotNetworkManager;
import com.botclient.PBotPlayerController;
import com.botclient.ServerStatusPinger;
import com.botclient.PBotClientWorld;
import com.botclient.BotController;
import com.botclient.AutoRejoinModule;
import com.botclient.BotDebugModule;
import com.botclient.BotSettingsModule;
import com.botclient.CaptchaManagerModule;
import com.botclient.BotsCommand;
import com.botclient.ScriptManager;
import com.botclient.ChatUtils;
import com.botclient.BotSpammer;
import com.botclient.BlockUtils;
import com.botclient.CaptchaPacket;
import com.botclient.CaptchaDetector;
import com.botclient.PlaceholderFormatter;
import com.botclient.RandomUtils;
import com.botclient.MillisTimer;
import com.botclient.ProxyInfo;
import com.botclient.ThreadUtils;
// Removed: BlockColored not in 1.21.4
// Removed: IProperty not in 1.21.4
// Removed: PropertyEnum not in 1.21.4
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
// Removed: PlayerCapabilities replaced
import net.minecraft.registry.Registries;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
// Removed: EnumConnectionState not in 1.21.4
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.handshake.HandshakeC2SPacket;
import net.minecraft.network.packet.c2s.login.LoginQueryResponseC2SPacket;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import net.minecraft.network.packet.c2s.play.SelectedSlotChangeC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.util.math.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.client.session.Session;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PBot {
    public net.minecraft.client.session.Session session;
    public final ServerStatusPinger serverPinger;
    public boolean deleted;
    public String nickname;
    public PBotNetHandlerPlayClient netHandler;
    public String tabFooter;
    public static CopyOnWriteArrayList<PBot> bots = new CopyOnWriteArrayList();
    public String host;
    public final BotController botBaritone;
    public PBotClientWorld world;
    public MillisTimer captchaDetector;
    public List<BufferedImage> gifExemplars;
    public PBotNetworkManager networkManager;
    public PBotPlayer player;
    public String windowTitle;
    public MillisTimer c;
    public MillisTimer gameGuardCheck;
    public boolean needAutoRespawn;
    public MillisTimer stimer2;
    public boolean recorderActive;
    public final MillisTimer timeAutoRespawn = new MillisTimer();
    public String tabHeader;
    public static final Pattern COLOR_PATTERN = Pattern.compile("(?i)§[0-9A-FK-OR]");
    public MillisTimer spammer;
    public final HashMap<String, Object> parameters;
    public int port;
    public ProxyInfo proxy;
    public PBotMinecraft mc;
    public MillisTimer stimer1;
    public MillisTimer stimer3;
    public int worldId;

    private static void setProxy(PBot instance, ProxyInfo eq) {
        instance.proxy = eq;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    private static BotKeyState getGameSettings(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotMinecraft getMc(PBot instance) {
        return instance.mc;
    }

    private static NumberSetting getJoinFixerDelay() {
        return BotSettingsModule.joinFixerDelay;
    }

    private static PBotMinecraft getMc2(PBot instance) {
        return instance.mc;
    }

    private static PBotPlayer getPlayer2(PBot instance) {
        return instance.player;
    }

    public void reconnect(boolean force) {
        if (!force && this.isDeleted()) {
            return;
        }
        if (force || (Client.getInstance().moduleManager).getModule(AutoRejoinModule.class).isModuleState()) {
            ThreadUtils.sleep((long)((long)(PBot.getReconnecttime().value)));
            if ((PBot.getRejoin().value)) {
                ChatUtils.formatMsg((String)("Бот &d&l" + this.getNickname() + " &f&lПереподключение бота..."));
            }
            this.resetParameters();
            if (this.isOnline()) {
                this.disconnect();
                this.stopBot();
                this.connect();
            } else {
                this.startBot();
            }
        } else {
            this.stopAndRemove();
        }
    }

    public int getIntegerParameter(String key) {
        return (Integer)this.getParameters().get(key);
    }

    private static Container getOpenContainer(PBotPlayer instance) {
        return instance.openContainer;
    }

    private static PBotMinecraft getMc3(PBot instance) {
        return instance.mc;
    }

    public void setPlayHandler(PBotNetHandlerPlayClient netHandler) {
        this.netHandler = netHandler;
    }

    private static PBotPlayer getPlayer3(PBot instance) {
        return instance.player;
    }

    public void setProxy(ProxyInfo proxy) {
        this.proxy = proxy;
    }

    private static float getX(Vector2f vector2f) {
        return vector2f.x;
    }

    private static PBotPlayer getPlayer4(PBot instance) {
        return instance.player;
    }

    public static String stripColor(String input) {
        return (COLOR_PATTERN).matcher(input).replaceAll("");
    }

    private static KeyBinding getKeyBindForward(GameSettings gameSettings) {
        return gameSettings.keyBindForward;
    }

    public void setFlying(boolean value) {
        if (this.isOnline()) {
            PBot.getCapabilities(PBot.getPlayer8(this)).isFlying = value;
        }
    }

    public Session getSession() {
        return (this.session);
    }

    private static void setHost(PBot instance, String string) {
        instance.host = string;
    }

    public static void removeBot(PBot pbot) {
        (bots).remove(pbot);
    }

    private static boolean getPressed(KeyBinding keyBinding) {
        return keyBinding.pressed;
    }

    private static PBotPlayer getPlayer6(PBot instance) {
        return instance.player;
    }

    private static void setWorld(PBotPlayer instance, World world) {
        instance.world = world;
    }

    private static GameSettings getGameSettings2() {
        return Minecraft.gameSettings;
    }

    public void swapHands() {
        if (this.isOnline()) {
            this.sendPacket((Packet)new PlayerActionC2SPacket((PlayerActionC2SPacket.Action.SWAP_HELD_ITEMS), (BlockPos.ORIGIN), (Direction.DOWN)));
        }
    }

    private static float getY(Vector2f vector2f) {
        return vector2f.y;
    }

    public static void runBot(String nickname, ProxyInfo proxy, String host, int port) {
        PBot pbot = new PBot(nickname, proxy, host, port);
        pbot.startBot();
    }

    private static PBotPlayer getPlayer7(PBot instance) {
        return instance.player;
    }

    public String getHost() {
        return (this.host);
    }

    private static PBotPlayer getPlayer8(PBot instance) {
        return instance.player;
    }

    private static BotKeyState getGameSettings3(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static boolean getPressed2(KeyBinding keyBinding) {
        return keyBinding.pressed;
    }

    public void rclickStop() {
        if (this.isOnline()) {
            (PBot.getMc13(this).playerController).onStoppedUsingItem((PlayerEntity)(this.player));
        }
    }

    public void useItem() {
        if (this.isOnline()) {
            (PBot.getMc3(this).playerController).processRightClick((PlayerEntity)(this.player), (World)this.world, (Hand.MAIN_HAND));
        }
    }

    private static PBotPlayer getPlayer9(PBot instance) {
        return instance.player;
    }

    private static InventoryPlayer getInventory(PBotPlayer instance) {
        return instance.inventory;
    }

    public final PBotClientWorld getWorld() {
        return (this.world);
    }

    private static HashMap getParameters(PBot instance) {
        return instance.parameters;
    }

    private static PBotPlayer getPlayer10(PBot instance) {
        return instance.player;
    }

    private static void setDeleted(PBot instance, boolean value) {
        instance.deleted = value;
    }

    private static PBotMinecraft getMc4(PBot instance) {
        return instance.mc;
    }

    private static PBotPlayer getPlayer11(PBot instance) {
        return instance.player;
    }

    private static World getWorld(PBotPlayer instance) {
        return instance.world;
    }

    private static BooleanSetting getGameguard() {
        return BotSettingsModule.gameguard;
    }

    private static PBotMinecraft getMc5(PBot instance) {
        return instance.mc;
    }

    private static float getRotationYaw(PBotPlayer instance) {
        return instance.rotationYaw;
    }

    private static PBotPlayer getPlayer12(PBot instance) {
        return instance.player;
    }

    private static PlayerEntitySP getPlayer13() {
        return Minecraft.player;
    }

    public HashMap<String, Object> getParameters() {
        return (this.parameters);
    }

    private static float getX2(Vector2f vector2f) {
        return vector2f.x;
    }

    private static KeyBinding getKeyBindSneak(GameSettings gameSettings) {
        return gameSettings.keyBindSneak;
    }

    private static PBotPlayer getPlayer14(PBot instance) {
        return instance.player;
    }

    private static NumberSetting getReconnecttime() {
        return AutoRejoinModule.reconnecttime;
    }

    private static PBotNetworkManager getNetworkManager(PBot instance) {
        return instance.networkManager;
    }

    private static BotKeyState getGameSettings4(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotPlayer getPlayer16(PBot instance) {
        return instance.player;
    }

    private static BotKeyState getGameSettings5(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static float getY2(Vector2f vector2f) {
        return vector2f.y;
    }

    private static PBotPlayer getPlayer17(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer18(PBot instance) {
        return instance.player;
    }

    public void sendPacket(Packet packet) {
        if (this.getPlayHandler() != null) {
            this.getPlayHandler().sendPacket(packet);
        }
    }

    private static ProxyInfo getProxy(PBot instance) {
        return instance.proxy;
    }

    private static GameSettings getGameSettings6() {
        return Minecraft.gameSettings;
    }

    public void leftClick() {
        (this.mc).clickMouse();
    }

    private static PBotPlayer getPlayer19(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer20(PBot instance) {
        return instance.player;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private static Container getOpenContainer4(PBotPlayer instance) {
        return instance.openContainer;
    }

    private static PBotPlayer getPlayer21(PBot instance) {
        return instance.player;
    }

    private static int getPort(PBot instance) {
        return instance.port;
    }

    private static PBotPlayer getPlayer23(PBot instance) {
        return instance.player;
    }

    private static PBotMinecraft getMc7(PBot instance) {
        return instance.mc;
    }

    public void setWorld(PBotClientWorld newWorld) {
        if ((this.player) != null) {
            PBot.getPlayer41(this).world = (World)newWorld;
        }
        this.world = newWorld;
    }

    private static PBotMinecraft getMc8(PBot instance) {
        return instance.mc;
    }

    public String getTabFooter() {
        return (this.tabFooter);
    }

    public void connect() {
        this.resetParameters();
        try {
            if ((PBot.getPingServer().value)) {
                (this.serverPinger).ping(this);
                ThreadUtils.sleep((long)4000L);
            }
            InetAddress inetaddress = InetAddress.getByName(this.getHost());
            this.networkManager = PBotNetworkManager.createNetworkManagerAndConnect((InetAddress)inetaddress, (int)this.getPort(), (PBot)this, (ProxyInfo)PBot.getProxy4(this));
            (this.networkManager).setNetHandler((INetHandler)new PBotStatFileWriter(this.getNetworkManager(), this));
            (this.networkManager).sendPacket((Packet)new C00Handshake(this.getHost(), this.getPort(), (EnumConnectionState.LOGIN)));
            ThreadUtils.sleep((long)200L);
            (this.networkManager).sendPacket((Packet)new CPacketLoginStart(this.getSession().getProfile()));
            if ((PBot.getUseProxy().value) && !(this.networkManager).isChannelOpen()) {
                if ((PBot.getRemovebadproxy().value) && (this.proxy) != null) {
                    PBotManager.getInstance().getProxyManager().removeProxy((this.proxy));
                }
                if ((PBot.getJoinFixer().value) && (BotsCommand.joinloop)) {
                    this.setProxy(PBotManager.getInstance().getProxyManager().getProxy());
                    ThreadUtils.sleep((long)((long)(PBot.getJoinFixerDelay().value)));
                    this.reconnect(true);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void clickEntity(int id, boolean visual) {
        if (visual) {
            Entity entity = this.world.getEntityByID(id);
            if (entity != null && BlockUtils.getDistance((PBot)this, (double)(entity.posX), (double)(entity.posY), (double)(entity.posZ)) < 6.0f) {
                Vector2f vector2f = BlockUtils.getBlockAngles((double)(entity.posX), (double)(entity.posY), (double)(entity.posZ), (double)(PBot.getPlayer2(this).posX), (double)(PBot.getPlayer7(this).posY), (double)(PBot.getPlayer31(this).posZ));
                PBot.getPlayer9(this).rotationYaw = BlockUtils.normalizeYaw((float)PBot.getY(vector2f));
                PBot.getPlayer64(this).rotationPitch = BlockUtils.normalizePitch((float)PBot.getX3(vector2f));
                (PBot.getPlayer4(this).connection).sendPacket((Packet)new PlayerInteractEntityC2SPacket(entity, (Hand.MAIN_HAND)));
            }
        } else {
            ChatUtils.formatMsg((String)("Бот &d&l" + this.getNickname() + "&6 Не указан энтити с таким ID, отправляю обычный клик без ротации."));
            (PBot.getPlayer14(this).connection).sendPacket((Packet)new PlayerInteractEntityC2SPacket(id, (Hand.MAIN_HAND)));
        }
    }

    private static PBotMinecraft getMc9(PBot instance) {
        return instance.mc;
    }

    private static PBotPlayer getPlayer27(PBot instance) {
        return instance.player;
    }

    private static PBotMinecraft getMc10(PBot instance) {
        return instance.mc;
    }

    public void sendMessage(String msg) {
        if (this.isOnline()) {
            this.sendPacket((Packet)new ChatMessageC2SPacket(msg));
        }
    }

    public static PBot getBot(String name) {
        for (PBot bot : PBot.getBotList()) {
            if (!(bot.nickname).equalsIgnoreCase(name)) continue;
            return bot;
        }
        return null;
    }

    private static float getRotationPitch(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.rotationPitch;
    }

    private static PBotPlayer getPlayer28(PBot instance) {
        return instance.player;
    }

    private static PBotMinecraft getMc12(PBot instance) {
        return instance.mc;
    }

    private static Container getOpenContainer5(PBotPlayer instance) {
        return instance.openContainer;
    }

    public void closeWindow() {
        if (this.isOnline()) {
            (this.player).closeScreenAndDropStack();
            this.sendPacket((Packet)new CloseHandledScreenC2SPacket((PBot.getOpenContainer(PBot.getPlayer17(this)).windowId)));
            PBot.getOpenContainer4(PBot.getPlayer16(this)).windowId = 0;
        }
    }

    private static BotKeyState getGameSettings7(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static GameSettings getGameSettings8() {
        return Minecraft.gameSettings;
    }

    private static PBotPlayer getPlayer29(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer30(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer31(PBot instance) {
        return instance.player;
    }

    public void changeSlot(int slot) {
        if (this.isOnline() && (PBot.getInventory(PBot.getPlayer51(this)).currentItem) != slot) {
            PBot.getInventory4(PBot.getPlayer61(this)).currentItem = slot;
            this.sendPacket((Packet)new SelectedSlotChangeC2SPacket(slot));
        }
    }

    public boolean haveCreative() {
        return (this.isOnline() && (PBot.getMc(this).playerController).isInCreativeMode() ? 1 : 0) != 0;
    }

    private static KeyBinding getKeyBindBack(GameSettings gameSettings) {
        return gameSettings.keyBindBack;
    }

    public long getLongParameter(String key) {
        return (Long)this.getParameters().get(key);
    }

    private static BooleanSetting getGifCaptchaFix() {
        return CaptchaManagerModule.gifCaptchaFix;
    }

    private static PBotPlayer getPlayer33(PBot instance) {
        return instance.player;
    }

    public static List<PBot> getBotList() {
        return (bots);
    }

    public void stopAndRemove() {
        this.stopBot();
        PBot.removeBot(this);
    }

    private static BooleanSetting getUseProxy() {
        return BotSettingsModule.useProxy;
    }

    private static Session getSession(PBot instance) {
        return instance.session;
    }

    private static BooleanSetting getPingServer() {
        return BotSettingsModule.pingServer;
    }

    public void tick() {
        try {
            if ((this.player).isRiding()) {
                this.world.updateEntities();
            } else {
                (this.player).onUpdate();
            }
            (PBot.getMc12(this).playerController).updateController();
            if ((this.player) != null && (this.mc) != null) {
                (this.mc).execTasks();
                this.autoRespawn();
            }
            Object[] objectArray = new Object[1];
            objectArray[0] = this;
            (Client.getInstance().pBotsScriptManager).invokeMethod("onUpdate", objectArray);
            this.getBaritone().onUpdate();
            if (BotSpammer.isEnabled() && (this.spammer).hasReached((double)BotSpammer.getDelay())) {
                (this.spammer).reset();
                this.sendMessage(PlaceholderFormatter.format((String)BotSpammer.getText()));
            }
            if ((BotsCommand.mirror)) {
                PBot.getPlayer36(this).rotationYaw = PBot.getRotationYaw2(PBot.getPlayer62());
                PBot.getPlayer37(this).rotationPitch = PBot.getRotationPitch(PBot.getPlayer13());
                PBot.getGameSettings(PBot.getMc4(this)).keyBindForward = PBot.getPressed2(PBot.getKeyBindForward(PBot.getGameSettings17()));
                PBot.getGameSettings12(PBot.getMc24(this)).keyBindBack = PBot.getPressed7(PBot.getKeyBindBack(PBot.rHqqtYyfop()));
                PBot.getGameSettings16(PBot.getMc19(this)).keyBindLeft = PBot.getPressed(PBot.getKeyBindLeft(PBot.getGameSettings14()));
                PBot.getGameSettings3(PBot.getMc8(this)).keyBindRight = PBot.getPressed6(PBot.mfbGWusihm(PBot.getGameSettings9()));
                PBot.getGameSettings5(PBot.getMc23(this)).keyBindSprint = PBot.getPressed4(PBot.getKeyBindSprint(PBot.getGameSettings8()));
                PBot.getGameSettings13(PBot.getMc22(this)).keyBindSneak = PBot.getPressed5(PBot.getKeyBindSneak(PBot.getGameSettings6()));
                PBot.getGameSettings4(PBot.getMc20(this)).keyBindJump = PBot.getPressed3(PBot.getKeyBindJump(PBot.getGameSettings2()));
            }
            if ((BotsCommand.randommove)) {
                PBotPlayer cD = (this.player);
                cD.rotationYaw = PBot.getRotationYaw(cD) + BlockUtils.normalizeYaw((float)RandomUtils.intRandom((int)(-25), (int)(25)));
                this.jump();
                PBot.getGameSettings11(PBot.getMc5(this)).keyBindForward = true;
            }
            if ((BotsCommand.attack)) {
                try {
                    Entity e;
                    ItemArmor item;
                    Object stack;
                    if (BlockUtils.hasSword((PBot)this)) {
                        PBot.getInventory3(PBot.getPlayer43(this)).currentItem = BlockUtils.getSword((PBot)this);
                    }
                    InventoryPlayer inventory = (PBot.getPlayer23(this).inventory);
                    int[] ArmorSlots = new int[4];
                    int[] ArmorValues = new int[4];
                    for (int type = 0; type < (4); ++type) {
                        ArmorSlots[type] = -1;
                        stack = inventory.armorItemInSlot(type);
                        if (BlockUtils.isNullOrEmpty((ItemStack)stack) || !(stack.getItem() instanceof ItemArmor)) continue;
                        item = (ItemArmor)stack.getItem();
                        ArmorValues[type] = BlockUtils.getArmorValue((ItemArmor)item, (ItemStack)stack, (PBot)this);
                    }
                    for (int slot = 0; slot < (36); ++slot) {
                        stack = inventory.getStackInSlot(slot);
                        if (BlockUtils.isNullOrEmpty((ItemStack)stack) || !(stack.getItem() instanceof ItemArmor)) continue;
                        item = (ItemArmor)stack.getItem();
                        int armorType = (item.armorType).getIndex();
                        int armorValue = BlockUtils.getArmorValue((ItemArmor)item, (ItemStack)stack, (PBot)this);
                        if (armorValue <= ArmorValues[armorType]) continue;
                        ArmorSlots[armorType] = slot;
                        ArmorValues[armorType] = armorValue;
                    }
                    Integer[] integerArray = new Integer[4];
                    integerArray[0] = 0;
                    integerArray[1] = 1;
                    integerArray[2] = 2;
                    integerArray[3] = 3;
                    ArrayList<Integer> types = new ArrayList<Integer>(Arrays.asList(integerArray));
                    Collections.shuffle(types);
                    stack = types.iterator();
                    while (stack.hasNext()) {
                        ItemStack oldArmor;
                        int i1 = (Integer)stack.next();
                        int j = ArmorSlots[i1];
                        if (j == (-1) || !BlockUtils.isNullOrEmpty((ItemStack)(oldArmor = inventory.armorItemInSlot(i1))) && inventory.getFirstEmptyStack() == (-1)) continue;
                        if (j < (9)) {
                            j += 36;
                        }
                        if (!(this.c).hasReached(200.0)) break;
                        if (!BlockUtils.isNullOrEmpty((ItemStack)oldArmor)) {
                            this.windowClick((8) - i1, 0, (ClickType.QUICK_MOVE));
                        }
                        this.windowClick(j, 0, (ClickType.QUICK_MOVE));
                        (this.c).reset();
                        break;
                    }
                    if ((e = BlockUtils.getByName((String)(BotsCommand.target))) != null && e != (this.player)) {
                        Vector2f vector2f = BlockUtils.getBlockAngles((double)(e.posX), (double)((e.posY) + 0.5), (double)(e.posZ), (double)(PBot.getPlayer20(this).posX), (double)(PBot.getPlayer39(this).posY), (double)(PBot.getPlayer47(this).posZ));
                        PBot.getPlayer48(this).rotationYaw = BlockUtils.normalizeYaw((float)PBot.getY2(vector2f)) + (float)RandomUtils.intRandom((int)(-3), (int)(3));
                        PBot.getPlayer12(this).rotationPitch = BlockUtils.normalizePitch((float)PBot.getX(vector2f)) + (float)RandomUtils.intRandom((int)(-1), (int)(1));
                        PBot.getGameSettings7(PBot.getMc2(this)).keyBindForward = (!(PBot.MvztlqeHew(this).getDistance(e) <= 2.0f) && !PBot.getIsDead(e) ? 1 : 0) != 0;
                        if ((double)(this.player).getDistance(e) <= 3.0) {
                            if ((double)(this.player).getCooledAttackStrength(1.0f) >= 0.93000000000000005 && (this.c).hasReached((double)((2300) + RandomUtils.intRandom((int)(0), (int)(100))))) {
                                (this.c).reset();
                                (PBot.getMc10(this).playerController).attackEntity((PlayerEntity)(this.player), e);
                                (this.player).swingArm((Hand.MAIN_HAND));
                                (this.player).resetCooldown();
                            }
                            this.jump();
                        }
                    }
                }
                catch (Exception inventory) {
                    // empty catch block
                }
            }
            if (!this.getBooleanParameter("captchadetected") && !this.getBooleanParameter("authorization") && (this.captchaDetector).hasReached((double)((PBot.getGifCaptchaFix().value) ? 900 : 2000))) {
                (this.captchaDetector).reset();
                CaptchaPacket captcha = CaptchaDetector.getCaptcha((PBot)this);
                if (captcha != null) {
                    PBotManager.getInstance().getCaptchaManager().addCaptcha(captcha);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static boolean getPressed3(KeyBinding keyBinding) {
        return keyBinding.pressed;
    }

    public void setHost(String host) {
        this.host = host;
    }

    private static PBotMinecraft getMc13(PBot instance) {
        return instance.mc;
    }

    public void windowClick(int slot, int mouseButton, ClickType type) {
        (PBot.getMc18(this).playerController).windowClick((PBot.getOpenContainer5(PBot.getPlayer18(this)).windowId), slot, mouseButton, type, (PlayerEntity)(this.player));
    }

    private static KeyBinding mfbGWusihm(GameSettings gameSettings) {
        return gameSettings.keyBindRight;
    }

    public String getStringParameter(String key) {
        return (String)this.getParameters().get(key);
    }

    private static Container getOpenContainer6(PBotPlayer instance) {
        return instance.openContainer;
    }

    private static PBotPlayer getPlayer36(PBot instance) {
        return instance.player;
    }

    public String getNickname() {
        return (this.nickname);
    }

    private PBot(String nickname2, ProxyInfo proxy, String host, int port) {
        this.recorderActive = 0;
        this.gifExemplars = new ArrayList<BufferedImage>();
        this.proxy = proxy;
        this.host = host;
        this.port = port;
        this.nickname = nickname2;
        this.captchaDetector = new MillisTimer();
        this.gameGuardCheck = new MillisTimer();
        this.stimer1 = new MillisTimer();
        this.stimer2 = new MillisTimer();
        this.stimer3 = new MillisTimer();
        this.spammer = new MillisTimer();
        this.c = new MillisTimer();
        this.needAutoRespawn = 0;
        this.parameters = new HashMap();
        this.resetParameters();
        this.session = new Session(this.nickname, "", "", "mojang");
        this.botBaritone = new BotController(this);
        this.serverPinger = new ServerStatusPinger();
        PBot.addBot(this);
    }

    private static PBotPlayer getPlayer37(PBot instance) {
        return instance.player;
    }

    private static GameSettings getGameSettings9() {
        return Minecraft.gameSettings;
    }

    public int getPort() {
        return (this.port);
    }

    public void resetParameters() {
        this.setParameter("authorization", false);
        this.setParameter("webdetected", false);
        this.setParameter("gameguardcheck", false);
        this.setParameter("captchadetected", false);
        this.setParameter("anvilbypass", false);
    }

    public int getMapSlot() {
        if ((this.player).getHeldItemOffhand().getItem().equals((Items.FILLED_MAP))) {
            return 45;
        }
        int slot = 0;
        for (ItemStack stack : (PBot.getInventory5(PBot.getPlayer6(this)).mainInventory)) {
            if (stack.getItem().equals((Items.FILLED_MAP))) {
                return slot;
            }
            ++slot;
        }
        return -1;
    }

    private static PBotPlayer getPlayer39(PBot instance) {
        return instance.player;
    }

    private static String getNickname(PBot instance) {
        return instance.nickname;
    }

    private static String getTabFooter(PBot instance) {
        return instance.tabFooter;
    }

    private static InventoryPlayer getInventory3(PBotPlayer instance) {
        return instance.inventory;
    }

    private static PBotPlayer getPlayer41(PBot instance) {
        return instance.player;
    }

    private static String getHost(PBot instance) {
        return instance.host;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    private static boolean getPressed4(KeyBinding keyBinding) {
        return keyBinding.pressed;
    }

    public final PBotNetworkManager getNetworkManager() {
        return (this.networkManager);
    }

    private static void addBot(PBot pbot) {
        (bots).add(pbot);
    }

    public void clickBlock(int x, int y, int z, String enumFace) {
        BlockPos blockPos = new BlockPos(x, y, z);
        this.sendPacket((Packet)new PlayerInteractBlockC2SPacket(new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ()), Direction.byName((String)enumFace), (Hand.MAIN_HAND), (float)blockPos.getX(), (float)blockPos.getY(), (float)blockPos.getZ()));
    }

    private static PBotPlayer getPlayer42(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer43(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer44(PBot instance) {
        return instance.player;
    }

    public int currentWindowID() {
        if (this.isOnline()) {
            return (PBot.getOpenContainer7(PBot.getPlayer42(this)).windowId);
        }
        return 0;
    }

    public void botTick() {
        if (this.isOnline()) {
            try {
                if ((PBot.getGameguard().value) && (this.gameGuardCheck).hasReached(2000.0) && !this.getBooleanParameter("gameguardcheck")) {
                    (this.gameGuardCheck).reset();
                    for (BlockPos blockPos : BlockUtils.getAllInBox((BlockPos)new BlockPos(9, 51, -1), (BlockPos)new BlockPos(9, 53, 1))) {
                        if ((PBot.getPlayer10(this).world).getBlockState(blockPos).getProperties().size() == 0 || !(PBot.getPlayer65(this).world).getBlockState(blockPos).getBlock().getTranslationKey().equalsIgnoreCase("tile.cloth") || !((EnumDyeColor)(PBot.getPlayer29(this).world).getBlockState(blockPos).getValue((IProperty)PBot.getCOLOR())).toString().equalsIgnoreCase((BotSettingsModule.gameguardBlock).get())) continue;
                        if (BlockUtils.getDistance((PBot)this, (double)9.0, (double)52.0, (double)0.0) < 4.0f) {
                            PBot.getGameSettings10(PBot.getMc21(this)).keyBindForward = false;
                            this.sendPacket((Packet)new PlayerInteractBlockC2SPacket(new BlockPos(blockPos.getX() - (1), blockPos.getY(), blockPos.getZ()), (Direction.SOUTH), (Hand.MAIN_HAND), (float)blockPos.getX(), (float)blockPos.getY(), (float)blockPos.getZ()));
                        } else {
                            PBot.getGameSettings15(PBot.getMc9(this)).keyBindForward = true;
                        }
                        Iterator vector2f = BlockUtils.getBlockAngles((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(), (double)((PBot.getPlayer11(this).posX) + 0.5), (double)(PBot.getPlayer28(this).posY), (double)(PBot.getPlayer3(this).posZ));
                        PBot.getPlayer30(this).rotationYaw = BlockUtils.normalizeYaw((float)PBot.getY3((Vector2f)vector2f));
                        PBot.getPlayer58(this).rotationPitch = BlockUtils.normalizePitch((float)PBot.getX2((Vector2f)vector2f));
                    }
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            try {
                if ((BotSettingsModule.antibot).is("MultyBypass")) {
                    if ((this.windowTitle) != null) {
                        String containerName = (this.windowTitle).toLowerCase().replace("k", "Рє").replace("x", "С…").replace("p", "р").replace("a", "а").replace("y", "у").replace("t", "С‚").replace("c", "с").replace("o", "о").replace("e", "е").replace("b", "РІ").replace("h", "н").replace("m", "м");
                        int slot = 0;
                        for (ItemStack stack : (PBot.getPlayer33(this).openContainer).getInventory()) {
                            if (stack.getTranslationKey().equals("tile.thinStainedGlass.lime") && (this.c).hasReached(400.0)) {
                                this.windowClick(slot, 0, (ClickType.PICKUP));
                                (this.c).reset();
                            }
                            if (containerName.contains("зелье") && PotionUtils.getColor((ItemStack)stack) == (255) && (this.c).hasReached(400.0)) {
                                this.windowClick(slot, 0, (ClickType.PICKUP));
                                (this.c).reset();
                            }
                            ++slot;
                        }
                    }
                } else if ((BotSettingsModule.antibot).is("AnvilRename") && !this.getBooleanParameter("anvilbypass") && (this.c).hasReached(2000.0)) {
                    ContainerRepair containerrepair;
                    ItemStack paper;
                    (this.c).reset();
                    if ((PBot.getPlayer60(this).openContainer) instanceof ContainerRepair && (paper = (ItemStack)(containerrepair = (ContainerRepair)(PBot.getPlayer27(this).openContainer)).getInventory().get(0)).getItem().equals((Items.PAPER))) {
                        if (paper.getDisplayName().contains("Введите число")) {
                            String s = paper.getDisplayName().replace("В№", "1").replace("ВІ", "2").replace("Ві", "3").replace("⁴", "4").replace("⁵", "5").replace("⁶", "6").replace("⁷", "7").replace("⁸", "8").replace("⁹", "9").replace("⁰", "0");
                            String number = s.split("число ")[1];
                            containerrepair.updateItemName(number);
                            this.sendPacket((Packet)new CustomPayloadC2SPacket("MC|ItemName", new PacketBuffer(Unpooled.buffer()).writeString(number)));
                            this.windowClick(2, 0, (ClickType.PICKUP));
                            this.setParameter("anvilbypass", true);
                        } else {
                            this.windowClick(0, 0, (ClickType.PICKUP));
                        }
                    }
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public boolean isOnline() {
        return (this.getNetworkManager() != null && (this.mc) != null && (this.player) != null && (PBot.getMc17(this).playerController) != null ? 1 : 0) != 0;
    }

    public void startBot() {
        Thread botThread = new Thread(() -> {
            this.connect();
            this.mc = new PBotMinecraft(this);
        });
        botThread.setName("PBotConnector-" + (this.nickname) + "-" + RandomUtils.randomNumber((int)(3)));
        botThread.start();
    }

    public void dropItem(int slot) {
        if (this.isOnline()) {
            (PBot.getMc7(this).playerController).windowClick((PBot.getOpenContainer6(PBot.getPlayer19(this)).windowId), slot, 1, (ClickType.THROW), (PlayerEntity)(this.player));
        }
    }

    private static float getX3(Vector2f vector2f) {
        return vector2f.x;
    }

    private static KeyBinding getKeyBindLeft(GameSettings gameSettings) {
        return gameSettings.keyBindLeft;
    }

    private static BotKeyState getGameSettings10(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static InventoryPlayer getInventory4(PBotPlayer instance) {
        return instance.inventory;
    }

    private static BotKeyState getGameSettings11(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotPlayer getPlayer47(PBot instance) {
        return instance.player;
    }

    public String getTabHeader() {
        return (this.tabHeader);
    }

    private static BotKeyState getGameSettings12(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotPlayer getPlayer48(PBot instance) {
        return instance.player;
    }

    public void stopBot() {
        this.resetParameters();
        this.disconnect();
        this.networkManager = null;
        this.setWorld(null);
        this.player = null;
        this.mc = null;
    }

    private static boolean getIsDead(Entity entity) {
        return entity.isDead;
    }

    private static float getY3(Vector2f vector2f) {
        return vector2f.y;
    }

    private static PBotMinecraft getMc17(PBot instance) {
        return instance.mc;
    }

    private void autoRespawn() {
        if ((this.player) != null) {
            if ((this.player).getHealth() <= 0.0f && (this.timeAutoRespawn).getTime() > 3000L && (this.needAutoRespawn)) {
                (this.player).respawnPlayer();
                this.needAutoRespawn = false;
            }
            if ((this.player).getHealth() <= 0.0f && !(this.needAutoRespawn)) {
                this.needAutoRespawn = true;
                (this.timeAutoRespawn).reset();
            }
        }
    }

    private static PBotPlayer getPlayer51(PBot instance) {
        return instance.player;
    }

    private static BooleanSetting getRejoin() {
        return BotDebugModule.rejoin;
    }

    private static BotKeyState getGameSettings13(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    public void rightClick(boolean hold) {
        (this.mc).rightClickMouse();
        if (!hold) {
            this.rclickStop();
        }
    }

    private static BooleanSetting getRemovebadproxy() {
        return BotSettingsModule.removebadproxy;
    }

    public boolean isDeleted() {
        return (this.deleted);
    }

    private static KeyBinding getKeyBindJump(GameSettings gameSettings) {
        return gameSettings.keyBindJump;
    }

    public void setParameter(String key, Object value) {
        this.getParameters().put(key, value);
    }

    public void auth() {
        String password;
        this.setParameter("authorization", true);
        String mode = (AutoRegisterModule.passwordGenerator).get();
        switch (mode) {
            case "random":
                password = RandomUtils.randomString((int)(10));
                break;
            case "custom":
                password = (AutoRegisterModule.customPassword).get();
                break;
            case "nickToPass":
                password = this.getNickname().toLowerCase().substring(0, 3) + Math.abs(this.getNickname().toLowerCase().hashCode());
                break;
            default:
                password = RandomUtils.randomString((int)(3));
                break;
        }
        this.sendMessage((AutoRegisterModule.registerCommand).get().replace("%pass", password));
        if ((AutoRegisterModule.needLogin).value) {
            this.sendMessage((AutoRegisterModule.authCommand).get().replace("%pass", password));
        }
        ChatUtils.formatMsg((String)("Бот &d&l" + this.getNickname() + "&f&l прошёл авторизацию."));
        ActionReplayRunner.trigger((PBot)this, (String)"onAuth");
        Object[] args = new Object[2];
        args[0] = this;
        args[1] = password;
        (Client.getInstance().pBotsScriptManager).invokeMethod("onAuth", args);
    }

    public void disconnect() {
        this.resetParameters();
        if (this.world != null && this.getNetworkManager() != null && (this.getNetworkManager().channel) != null) {
            this.world.sendQuittingDisconnectingPacket();
        }
    }

    private static GameSettings getGameSettings14() {
        return Minecraft.gameSettings;
    }

    public Object getParameter(String key) {
        return this.getParameters().get(key);
    }

    private static boolean getPressed5(KeyBinding keyBinding) {
        return keyBinding.pressed;
    }

    private static Container getOpenContainer7(PBotPlayer instance) {
        return instance.openContainer;
    }

    private static ProxyInfo getProxy4(PBot instance) {
        return instance.proxy;
    }

    public void jump() {
        if ((PBot.getPlayer44(this).onGround)) {
            (this.player).jump();
        }
    }

    private static PlayerCapabilities getCapabilities(PBotPlayer instance) {
        return instance.capabilities;
    }

    private static BotKeyState getGameSettings15(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotMinecraft getMc18(PBot instance) {
        return instance.mc;
    }

    private static String getTabHeader(PBot instance) {
        return instance.tabHeader;
    }

    private static void setPort(PBot instance, int n) {
        instance.port = n;
    }

    public static List<PBot> getOnline() {
        return (bots).stream().filter(PBot::isOnline).collect(Collectors.toList());
    }

    private static PBotPlayer getPlayer58(PBot instance) {
        return instance.player;
    }

    public void addParameter(String key, Object value) {
        this.getParameters().put(key, value);
    }

    private static boolean getPressed6(KeyBinding keyBinding) {
        return keyBinding.pressed;
    }

    private static PBotMinecraft getMc19(PBot instance) {
        return instance.mc;
    }

    private static BotKeyState getGameSettings16(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PBotMinecraft getMc20(PBot instance) {
        return instance.mc;
    }

    private static float getRotationYaw2(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.rotationYaw;
    }

    private static PBotMinecraft getMc21(PBot instance) {
        return instance.mc;
    }

    private static BooleanSetting getJoinFixer() {
        return BotSettingsModule.joinFixer;
    }

    public void strafe(float yaw, double speed, double forward, double direction) {
        if (forward != 0.0) {
            if (direction > 0.0) {
                yaw += (float)(forward > 0.0 ? -45 : 45);
            } else if (direction < 0.0) {
                yaw += (float)(forward > 0.0 ? 45 : -45);
            }
            direction = 0.0;
            if (forward > 0.0) {
                forward = 1.0;
            } else if (forward < 0.0) {
                forward = -1.0;
            }
        }
        double cos = Math.cos(Math.toRadians(yaw + 90.0f));
        double sin = Math.sin(Math.toRadians(yaw + 90.0f));
        double x = forward * speed * cos + direction * speed * sin;
        double z = forward * speed * sin - direction * speed * cos;
        PBot.getPlayer63(this).motionX = x;
        PBot.getPlayer21(this).motionZ = z;
    }

    private static GameSettings getGameSettings17() {
        return Minecraft.gameSettings;
    }

    private static PBotMinecraft getMc22(PBot instance) {
        return instance.mc;
    }

    private static PBotMinecraft getMc23(PBot instance) {
        return instance.mc;
    }

    private static PBotPlayer MvztlqeHew(PBot instance) {
        return instance.player;
    }

    public ProxyInfo getProxy() {
        return (this.proxy);
    }

    public BotController getBaritone() {
        return (this.botBaritone);
    }

    private static PBotPlayer getPlayer60(PBot instance) {
        return instance.player;
    }

    private static PropertyEnum getCOLOR() {
        return BlockColored.COLOR;
    }

    private static PBotPlayer getPlayer61(PBot instance) {
        return instance.player;
    }

    public boolean getBooleanParameter(String key) {
        return (Boolean)this.getParameters().get(key);
    }

    private static PlayerEntitySP getPlayer62() {
        return Minecraft.player;
    }

    private static PBotPlayer getPlayer63(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer64(PBot instance) {
        return instance.player;
    }

    private static InventoryPlayer getInventory5(PBotPlayer instance) {
        return instance.inventory;
    }

    private static KeyBinding getKeyBindSprint(GameSettings gameSettings) {
        return gameSettings.keyBindSprint;
    }

    private static PBotPlayer getPlayer65(PBot instance) {
        return instance.player;
    }

    private static GameSettings rHqqtYyfop() {
        return Minecraft.gameSettings;
    }

    public final PBotNetHandlerPlayClient getPlayHandler() {
        return (this.netHandler);
    }

    private static boolean getPressed7(KeyBinding keyBinding) {
        return keyBinding.pressed;
    }

    private static PBotMinecraft getMc24(PBot instance) {
        return instance.mc;
    }

}
