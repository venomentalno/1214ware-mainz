/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  javax.vecmath.Vector2f
 *  javax.vecmath.Vector3i
 *  neo.deobf.CommandInfo
 *  neo.deobf.Command
 *  neo.deobf.Client
 *  neo.deobf.PBotManager
 *  neo.deobf.BooleanSetting
 *  neo.deobf.ModeSetting
 *  neo.deobf.CommandChatListener
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.BotKeyState
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.PBotNetHandlerPlayClient
 *  neo.deobf.PBotNetworkManager
 *  neo.deobf.ActionReplayRunner
 *  neo.deobf.BotTask
 *  neo.deobf.AutoFishTask
 *  neo.deobf.FollowTask
 *  neo.deobf.FollowPosTask
 *  neo.deobf.BotSettingsModule
 *  neo.deobf.NotificationType
 *  neo.deobf.NotificationsModule
 *  neo.deobf.ScriptManager
 *  neo.deobf.ScriptRiskLevel
 *  neo.deobf.ScriptRiskAnalyzer
 *  neo.deobf.ChatUtils
 *  neo.deobf.GotoTask
 *  neo.deobf.SpinTask
 *  neo.deobf.FigurePatternRegistry
 *  neo.deobf.BotSpammer
 *  neo.deobf.BlockUtils
 *  neo.deobf.NickManager
 *  neo.deobf.ProxyManager
 *  neo.deobf.PlaceholderFormatter
 *  neo.deobf.FileReadUtils
 *  neo.deobf.ProxyType
 *  neo.deobf.ProxyInfo
 *  neo.deobf.ServerAddressUtils
 *  neo.deobf.ThreadUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.PlayerEntitySP
 *  net.minecraft.entity.Entity
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.PlayerInteractBlockC2SPacket
 *  net.minecraft.network.play.client.PlayerInteractEntityC2SPacket
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Formatting
 */
package com.botclient;

import io.netty.channel.Channel;
import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalTime;
import javax.script.ScriptEngine;
import org.joml.Vector2f;
import javax.vecmath.Vector3i;
import com.botclient.CommandInfo;
import com.botclient.Command;
import com.botclient.Client;
import com.botclient.PBotManager;
import com.botclient.BooleanSetting;
import com.botclient.ModeSetting;
import com.botclient.CommandChatListener;
import com.botclient.PBot;
import com.botclient.PBotPlayer;
import com.botclient.BotKeyState;
import com.botclient.PBotMinecraft;
import com.botclient.PBotNetHandlerPlayClient;
import com.botclient.PBotNetworkManager;
import com.botclient.ActionReplayRunner;
import com.botclient.BotTask;
import com.botclient.AutoFishTask;
import com.botclient.FollowTask;
import com.botclient.FollowPosTask;
import com.botclient.BotSettingsModule;
import com.botclient.NotificationType;
import com.botclient.NotificationsModule;
import com.botclient.ScriptManager;
import com.botclient.ScriptRiskLevel;
import com.botclient.ScriptRiskAnalyzer;
import com.botclient.ChatUtils;
import com.botclient.GotoTask;
import com.botclient.SpinTask;
import com.botclient.FigurePatternRegistry;
import com.botclient.BotSpammer;
import com.botclient.BlockUtils;
import com.botclient.NickManager;
import com.botclient.ProxyManager;
import com.botclient.PlaceholderFormatter;
import com.botclient.FileReadUtils;
import com.botclient.ProxyType;
import com.botclient.ProxyInfo;
import com.botclient.ServerAddressUtils;
import com.botclient.ThreadUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.util.math.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Formatting;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@CommandInfo(name="bots", description="Боты.")
public class BotsCommand
extends Command {
    public static int delay;
    public static boolean randommove;
    public static boolean attack;
    public static boolean mirror;
    public static boolean joinloop;
    public static final boolean $assertionsDisabled;
    public static String target;
    public static int npcId;

    private static PBotPlayer getPlayer(PBot instance) {
        return instance.player;
    }

    private static PBotMinecraft getMc(PBot instance) {
        return instance.mc;
    }

    public void execute(String[] args) throws Exception {
        new Thread(() -> {
            block160: {
                try {
                    if (args.length != 0) {
                        if (args[0].equalsIgnoreCase("connect") || args[0].equalsIgnoreCase("join")) {
                            if (args.length >= (3)) {
                                ProxyManager proxyManager = PBotManager.getInstance().getProxyManager();
                                NickManager nickManager = PBotManager.getInstance().getNickManager();
                                if ((BotsCommand.getUseProxy2().value) && proxyManager.getProxyList().size() == 0) {
                                    ChatUtils.formatMsg((String)"Прокси не загружены!");
                                    return;
                                }
                                if ((BotSettingsModule.nickstype).is("FromFile")) {
                                    nickManager.loadNicks();
                                }
                                if (!(BotsCommand.getUseProxy3().value)) {
                                    ChatUtils.formatMsg((String)"&6&lВыбран режим захода без прокси!");
                                    ChatUtils.formatMsg((String)"&6&lНе выставляйте слишком маленькую задержку на заходы");
                                    ChatUtils.formatMsg((String)"&6&lТак-же, Join Fixer не будет работать в этом режиме!");
                                }
                                String ip = null;
                                int port = 0;
                                if (args.length >= (4) && args[3].contains(":")) {
                                    ip = args[3].split(":")[0];
                                    port = Integer.parseInt(args[3].split(":")[1]);
                                }
                                ChatUtils.formatMsg((String)("Запуск &d&l" + args[1] + " &f&lботов."));
                                NotificationsModule.notify((String)"Bots Debug", (String)((TextFormat.GREEN) + "Запуск " + args[1] + " ботов..."), (NotificationType)(NotificationType.SUCCESS), (int)(4));
                                joinloop = true;
                                for (int bcount = 0; bcount < Integer.parseInt(args[1]); ++bcount) {
                                    if (!(joinloop)) continue;
                                    try {
                                        PBot.runBot((String)nickManager.getBotName(), (ProxyInfo)((BotsCommand.getUseProxy().value) ? proxyManager.getProxy() : new ProxyInfo("0.0.0.0:22", (ProxyType.NO_PROXY))), (String)(ip == null ? ServerAddressUtils.getIp() : ip), (int)(ip == null ? ServerAddressUtils.getPort() : port));
                                        ThreadUtils.sleep((long)Math.abs(Long.parseLong(args[2])));
                                        continue;
                                    }
                                    catch (Exception exception) {
                                        exception.printStackTrace();
                                    }
                                }
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots connect <кол-во> <задержка> - Запуск ботов на сервер."));
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("chat")) {
                            if (args.length > (1)) {
                                StringBuilder text = new StringBuilder();
                                for (int i = 1; i < args.length; ++i) {
                                    text.append(args[i]).append(i < args.length - (1) ? " " : "");
                                }
                                for (PBot bot2 : PBot.getOnline()) {
                                    try {
                                        String message = PlaceholderFormatter.format((String)text.toString());
                                        bot2.sendMessage(message);
                                    }
                                    catch (Exception message) {
                                        // empty catch block
                                    }
                                    ThreadUtils.sleep((long)(delay));
                                }
                                break block160;
                            }
                            ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots chat <сообщение> - Отправить сообщение от имени бота."));
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("hotbar")) {
                            if (args.length == (2)) {
                                for (PBot bot : PBot.getOnline()) {
                                    try {
                                        bot.changeSlot(Integer.parseInt(args[1]));
                                        bot.useItem();
                                    }
                                    catch (Exception bot2) {
                                        // empty catch block
                                    }
                                    ThreadUtils.sleep((long)(delay));
                                }
                                break block160;
                            }
                            ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots hotbar <слот> - Боты нажимают на слот в хотбаре."));
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("invclick")) {
                            if (args.length == (2)) {
                                for (PBot bot : PBot.getOnline()) {
                                    try {
                                        bot.windowClick(Integer.parseInt(args[1]), 0, (ClickType.PICKUP));
                                    }
                                    catch (Exception bot2) {
                                        // empty catch block
                                    }
                                    ThreadUtils.sleep((long)(delay));
                                }
                                break block160;
                            }
                            ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots invclick <слот> - Боты нажимают на слот в инвентаре."));
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("spin")) {
                            if (args.length == (3)) {
                                ChatUtils.formatMsg((String)("Боты начали ходить вокруг игрока " + args[1]));
                                for (PBot bot : PBot.getOnline()) {
                                    bot.getBaritone().setBotFunction((BotTask)new SpinTask(bot, args[1], BotsCommand.parseInt(args[2], 3)));
                                    ThreadUtils.sleep((long)(delay));
                                }
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots spin <name> <radius> - Боты начнут ходить вокруг игрока."));
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("mirror")) {
                            mirror = (!(mirror) ? 1 : 0) != 0;
                            String state = (mirror) ? "начали" : "перестали";
                            ChatUtils.formatMsg((String)("Все боты " + state + " повторять ваши действия."));
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("manual")) {
                            if (args.length == (2)) {
                                PBotManager.getInstance().getCaptchaManager().sendAnswer(args[1]);
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots manual <ответ> - Ручное решение капчи бота."));
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("disconnect")) {
                            ChatUtils.formatMsg((String)"Все боты отключены от сервера.");
                            joinloop = false;
                            for (PBot bot : PBot.getBotList()) {
                                try {
                                    bot.setDeleted(true);
                                    bot.stopAndRemove();
                                }
                                catch (Exception bot2) {}
                            }
                            PBotManager.getInstance().getCaptchaManager().clear();
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("clear")) {
                            ChatUtils.formatMsg((String)"Все боты отключены и очищены.");
                            for (PBot bot : PBot.getBotList()) {
                                try {
                                    bot.setDeleted(true);
                                    (bot.getNetworkManager().channel).close();
                                }
                                catch (Exception bot2) {
                                    // empty catch block
                                }
                                PBotManager.getInstance().getCaptchaManager().clear();
                            }
                            PBot.getBotList().clear();
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("loadproxy")) {
                            if (args.length == (3)) {
                                PBotManager.getInstance().getProxyManager().loadProxy(args[1], args[2]);
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots loadproxy <proxies.txt/URL> <socks4/socks5/http> - Загрузка прокси из файла или ссылки."));
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("randommove")) {
                            String state;
                            randommove = (!(randommove) ? 1 : 0) != 0;
                            String string = state = (randommove) ? "начали" : "перестали";
                            if (!(randommove)) {
                                for (PBot bot : PBot.getOnline()) {
                                    BotsCommand.WvtPpfzdtg(BotsCommand.getMc3(bot)).keyBindForward = false;
                                }
                            }
                            ChatUtils.formatMsg((String)("Все боты " + state + " рандомно ходить."));
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("invclear")) {
                            ChatUtils.formatMsg((String)"Все боты очистили инвентарь");
                            for (PBot bot : PBot.getOnline()) {
                                for (int o = 0; o < (46); ++o) {
                                    bot.windowClick(o, 1, (ClickType.THROW));
                                }
                                ThreadUtils.sleep((long)(delay));
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("spammer")) {
                            if (args.length == (2) && args[1].equalsIgnoreCase("off")) {
                                BotSpammer.setEnabled(false);
                                ChatUtils.formatMsg((String)"Спаммер остановлен!");
                            } else if (args.length >= (3)) {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (int i = 2; i < args.length; ++i) {
                                    stringBuilder.append(args[i]).append(i < args.length - (1) ? " " : "");
                                }
                                (System.out).println("spam text: " + stringBuilder + "<");
                                BotSpammer.setEnabled(true);
                                BotSpammer.setDelay((int)BotsCommand.parseInt(args[1], 1000));
                                BotSpammer.setText((String)stringBuilder.toString());
                                ChatUtils.formatMsg((String)("Спаммер запущен! Задержка: " + BotSpammer.getDelay() + " Текст: " + BotSpammer.getText()));
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots spammer <delay_ms/off> <text> - Боты начнут спамить указаным текстом."));
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("attack")) {
                            if (args.length == (2)) {
                                target = args[1];
                                attack = (!(attack) ? 1 : 0) != 0;
                                String state = (attack) ? "начали" : "перестали";
                                ChatUtils.formatMsg((String)("Все боты " + state + " атаковать игрока."));
                                if (!(attack)) {
                                    for (PBot bot : PBot.getOnline()) {
                                        BotsCommand.getGameSettings2(BotsCommand.getMc(bot)).keyBindForward = false;
                                    }
                                }
                            } else if ((attack)) {
                                attack = false;
                                ChatUtils.formatMsg((String)"Все боты перестали атаковать игрока.");
                                for (PBot bot : PBot.getOnline()) {
                                    BotsCommand.getGameSettings(BotsCommand.getMc2(bot)).keyBindForward = false;
                                }
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots attack <name> - Боты начнут атаковать игрока."));
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("setdelay")) {
                            if (args.length == (2)) {
                                try {
                                    delay = Integer.parseInt(args[1]);
                                    ChatUtils.formatMsg((String)("Установлена задержка между ботами на &d&l" + (delay) + " &f&lмс."));
                                }
                                catch (Exception exception) {
                                    ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots setdelay <miliseconds> - Задержка между ботами в invclick/hotbar/chat."));
                                }
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots setdelay <miliseconds> - Задержка между ботами в invclick/hotbar/chat."));
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("slotname")) {
                            if (args.length > (1)) {
                                StringBuilder slotname = new StringBuilder();
                                for (int i = 1; i < args.length; ++i) {
                                    slotname.append(args[i]).append(" ");
                                }
                                for (PBot bot : PBot.getOnline()) {
                                    try {
                                        int slot = 0;
                                        for (ItemStack stack : (BotsCommand.getPlayer17(bot).openContainer).getInventory()) {
                                            if (PBot.stripColor((String)stack.getDisplayName()).contains(slotname.substring(0, slotname.length() - (1)))) {
                                                bot.windowClick(slot, 0, (ClickType.PICKUP));
                                            }
                                            ++slot;
                                        }
                                    }
                                    catch (Exception slot) {
                                        // empty catch block
                                    }
                                    ThreadUtils.sleep((long)(delay));
                                }
                                break block160;
                            }
                            ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots slotname <name> - Клик по слоту в инвентаре используя название предмета."));
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("stopjoin")) {
                            ChatUtils.formatMsg((String)"Запуск ботов остановлен.");
                            joinloop = false;
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("look")) {
                            for (PBot bot : PBot.getOnline()) {
                                BotsCommand.getPlayer4(bot).rotationYaw = BlockUtils.normalizeYaw((float)Integer.parseInt(args[1]));
                                BotsCommand.getPlayer3(bot).rotationPitch = BlockUtils.normalizePitch((float)Integer.parseInt(args[2]));
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("setscript")) {
                            if (args.length >= (2)) {
                                if (args[1].equalsIgnoreCase("empty")) {
                                    ChatUtils.formatMsg((String)"Скрипт убран!");
                                    (BotsCommand.getPBotsScriptManager8(Client.getInstance()).engine).eval("");
                                    (Client.getInstance().pBotsScriptManager).setActive(false);
                                    return;
                                }
                                if (!new File((MinecraftClient.getInstance().gameDir), "/NeoWare/scripts/" + args[1] + ".js").exists()) {
                                    ChatUtils.formatMsg((String)("Скрипт " + args[1] + " не найден!"));
                                    (Client.getInstance().pBotsScriptManager).setActive(false);
                                } else {
                                    String src = FileReadUtils.readUsingFiles((File)new File((MinecraftClient.getInstance().gameDir), "/NeoWare/scripts/" + args[1] + ".js"));
                                    if (!($assertionsDisabled) && src == null) {
                                        throw new AssertionError();
                                    }
                                    if (ScriptRiskAnalyzer.check((String)src).equals((Object)(ScriptRiskLevel.WARNING)) && (args.length == (2) || !args[2].equals("--confirm" + (String.valueOf(Math.abs(String.valueOf(LocalTime.now().getHour()).hashCode() % (1000))))))) {
                                        ChatUtils.formatMsg((String)"&6&lПодозрительынй скрипт! Проверьте код на наличие опасных методов и т.д. Нико&6&lгда &6&lне &6&lза&6&lпус&6&lкайте неизвест&6&lные скрипты, не видя&6&l их реального к&6&lода! &6&lЕсли &6&lвы дей&6&lствительно хотите з&6&lагрузить скри&6&lпт, то&6&l введи&6&lте: ");
                                        ChatUtils.defaultMsg((String)("&6&l.bots " + BotsCommand.joinArrayElements(args) + " --confirm" + (String.valueOf(Math.abs(String.valueOf(LocalTime.now().getHour()).hashCode() % (1000))))));
                                        (Client.getInstance().pBotsScriptManager).setActive(false);
                                        return;
                                    }
                                    ChatUtils.formatMsg((String)("Скрипт " + args[1] + " загружен!"));
                                    (Client.getInstance().pBotsScriptManager).setActive(true);
                                    (Client.getInstance().pBotsScriptManager).loadScript(args[1]);
                                    ChatUtils.formatMsg((String)"?????????? ? ???????: ");
                                    ChatUtils.formatMsg((String)("Название: " + (Client.getInstance().pBotsScriptManager).invokeMethod0("getName", new Object[0])));
                                    ChatUtils.formatMsg((String)("Автор: " + (Client.getInstance().pBotsScriptManager).invokeMethod0("getAuthor", new Object[0])));
                                }
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots setscript <filename/empty> - Загрузить и запустить скрипт."));
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("auth")) {
                            for (PBot bot : PBot.getOnline()) {
                                if (!bot.getBooleanParameter("authorization")) {
                                    bot.auth();
                                }
                                ThreadUtils.sleep((long)(delay));
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("gc")) {
                            System.gc();
                            ChatUtils.formatMsg((String)"Память очищена!");
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("rejoinall")) {
                            for (PBot bot : PBot.getOnline()) {
                                try {
                                    bot.disconnect();
                                    bot.reconnect(true);
                                }
                                catch (Exception exception) {
                                    exception.printStackTrace();
                                }
                            }
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("clickblock")) {
                            if (args.length >= (4)) {
                                for (PBot bot : PBot.getOnline()) {
                                    try {
                                        BlockPos block = new BlockPos(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
                                        Vector2f vector2f = BlockUtils.getBlockAngles((double)block.getX(), (double)block.getY(), (double)block.getZ(), (double)((BotsCommand.getPlayer9(bot).posX) + 0.5), (double)(BotsCommand.getPlayer2(bot).posY), (double)(BotsCommand.getPlayer19(bot).posZ));
                                        BotsCommand.getPlayer8(bot).rotationYaw = BlockUtils.normalizeYaw((float)BotsCommand.getY(vector2f));
                                        BotsCommand.getPlayer20(bot).rotationPitch = BlockUtils.normalizePitch((float)BotsCommand.getX(vector2f));
                                        bot.sendPacket((Packet)new PlayerInteractBlockC2SPacket(new BlockPos(block.getX(), block.getY(), block.getZ()), (Direction.SOUTH), (Hand.MAIN_HAND), (float)block.getX(), (float)block.getY(), (float)block.getZ()));
                                    }
                                    catch (Exception exception) {
                                        exception.printStackTrace();
                                    }
                                    ThreadUtils.sleep((long)(delay));
                                }
                                break block160;
                            }
                            ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots clickblock <x> <y> <z> - Нажать на блок."));
                            break block160;
                        }
                        if (args[0].equalsIgnoreCase("npc")) {
                            if (args.length >= (2)) {
                                if (args[1].equalsIgnoreCase("rec")) {
                                    if ((npcId) == (-2)) {
                                        ChatUtils.formatMsg((String)"&cЗапись NPC уже идет!");
                                        return;
                                    }
                                    ChatUtils.formatMsg((String)"Запись началась, нажмите пкм на NPC.");
                                    npcId = -2;
                                } else if (args[1].equalsIgnoreCase("play")) {
                                    if ((npcId) < 0) {
                                        ChatUtils.formatMsg((String)"У вас нет записанного NPC.");
                                        return;
                                    }
                                    for (PBot bot : PBot.getOnline()) {
                                        Entity npc = bot.world.getEntityByID((npcId));
                                        if (npc != null) {
                                            if (!(BlockUtils.getDistance((PBot)bot, (double)(npc.posX), (double)(npc.posY), (double)(npc.posZ)) < 6.0f)) continue;
                                            Vector2f vector2f = BlockUtils.getBlockAngles((double)(npc.posX), (double)(npc.posY), (double)(npc.posZ), (double)(BotsCommand.getPlayer10(bot).posX), (double)((BotsCommand.getPlayer11(bot).posY) + 0.5), (double)(BotsCommand.getPlayer7(bot).posZ));
                                            BotsCommand.getPlayer13(bot).rotationYaw = BlockUtils.normalizeYaw((float)BotsCommand.getY2(vector2f));
                                            BotsCommand.getPlayer14(bot).rotationPitch = BlockUtils.normalizePitch((float)BotsCommand.getX2(vector2f));
                                            (BotsCommand.getPlayer5(bot).connection).sendPacket((Packet)new PlayerInteractEntityC2SPacket(npc, (Hand.MAIN_HAND)));
                                            continue;
                                        }
                                        ChatUtils.formatMsg((String)("Бот &d&l" + bot.getNickname() + "&6 Не найдено энтити с таким ID, отправляю обычный клик без ротации."));
                                        (BotsCommand.getPlayer(bot).connection).sendPacket((Packet)new PlayerInteractEntityC2SPacket((npcId), (Hand.MAIN_HAND)));
                                    }
                                } else if (args[1].equalsIgnoreCase("stop")) {
                                    npcId = -1;
                                    ChatUtils.formatMsg((String)"Запись клика по NPC остановлена.");
                                } else {
                                    ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots npc <rec/stop/play> - Запись и воспроизведение нажатия по NPC."));
                                }
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots npc <rec/stop/play> - Запись и воспроизведение нажатия по NPC."));
                            }
                        } else if (args[0].equalsIgnoreCase("dumpproxy")) {
                            try {
                                File file = new File((MinecraftClient.getInstance().gameDir), "/NeoWare/dumpproxy.txt");
                                PrintWriter dumpProxy = new PrintWriter(file);
                                for (PBot bot : PBot.getOnline()) {
                                    ProxyInfo proxyInfo = bot.getProxy();
                                    if (proxyInfo == null || proxyInfo.getType().equals((Object)(ProxyType.NO_PROXY)) || proxyInfo.getProxy().endsWith(":5501")) continue;
                                    dumpProxy.println(proxyInfo.getType().toString() + "://" + (proxyInfo.isAuthenticated() ? proxyInfo.getUsername() + ":" + proxyInfo.getPassword() : "") + proxyInfo.getProxy());
                                }
                                dumpProxy.flush();
                                dumpProxy.close();
                                ChatUtils.formatMsg((String)("Прокси сохранены в файл " + file.getAbsolutePath()));
                            }
                            catch (Exception file) {}
                        } else if (args[0].equalsIgnoreCase("goto")) {
                            if (args.length == (2) || args.length == (4)) {
                                Vector3i vector;
                                if (args.length == (2) && args[1].equalsIgnoreCase("@me")) {
                                    vector = new Vector3i((BotsCommand.getPlayer16().posX), (BotsCommand.getPlayer18().posY), (BotsCommand.getPlayer15().posZ));
                                } else if (args.length == (4)) {
                                    vector = new Vector3i(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
                                } else {
                                    ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots goto <x> <y> <z> - Боты начнут идти на координаты."));
                                    return;
                                }
                                for (PBot bot3 : PBot.getOnline()) {
                                    bot3.getBaritone().setBotFunction((BotTask)new GotoTask(bot3, vector));
                                    ThreadUtils.sleep((long)(delay));
                                }
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots goto <x> <y> <z> - Боты начнут идти на координаты."));
                            }
                        } else if (args[0].equalsIgnoreCase("autofish")) {
                            for (PBot bot : PBot.getOnline()) {
                                bot.getBaritone().setBotFunction((BotTask)new AutoFishTask(bot));
                                ThreadUtils.sleep((long)(delay));
                            }
                        } else if (args[0].equalsIgnoreCase("follow")) {
                            if (args.length == (2)) {
                                for (PBot bot : PBot.getOnline()) {
                                    bot.getBaritone().setBotFunction((BotTask)new FollowTask(bot, args[1]));
                                    ThreadUtils.sleep((long)(delay));
                                }
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots follow <name> - Боты начнут идти за игроком."));
                            }
                        } else if (args[0].equalsIgnoreCase("bstop")) {
                            ChatUtils.formatMsg((String)"Все боты перестали выполнять действие");
                            for (PBot bot : PBot.getOnline()) {
                                bot.getBaritone().setBotFunction(null);
                                ThreadUtils.sleep((long)(delay));
                            }
                        } else if (args[0].equalsIgnoreCase("repeat")) {
                            for (PBot bot : PBot.getOnline()) {
                                ActionReplayRunner.trigger((PBot)bot, (String)"repeatCommand");
                                ThreadUtils.sleep((long)(delay));
                            }
                        } else if (args[0].equalsIgnoreCase("figure")) {
                            if (args.length == (2)) {
                                if (args[1].equalsIgnoreCase("list")) {
                                    ChatUtils.formatMsg((String)"Список фигур:");
                                    String[] vector = new File((MinecraftClient.getInstance().gameDir), "/NeoWare/figures/").list();
                                    int bot = vector.length;
                                    for (int bot3 = 0; bot3 < bot; ++bot3) {
                                        String file = vector[bot3];
                                        ChatUtils.formatMsg((String)file.replace(".json", ""));
                                    }
                                    return;
                                }
                                BlockPos[] figure = FigurePatternRegistry.getFigureByName((String)args[1]);
                                if (figure == null) {
                                    ChatUtils.formatMsg((String)("Неизвестная фигура " + args[1]));
                                    return;
                                }
                                ChatUtils.formatMsg((String)("Боты начали построение фигурой " + args[1]));
                                int index = 0;
                                BlockPos playerPosition = (Minecraft.player).getPosition();
                                for (PBot bot : PBot.getOnline()) {
                                    BlockPos point = figure[index];
                                    BlockPos newPosition = new BlockPos((double)(playerPosition.getX() + point.getX()), (BotsCommand.getPlayer6(bot).posY), (double)(playerPosition.getZ() + point.getZ()));
                                    bot.getBaritone().setBotFunction((BotTask)new FollowPosTask(bot, newPosition));
                                    if (++index >= figure.length) {
                                        index = 0;
                                    }
                                    ThreadUtils.sleep((long)(delay));
                                }
                            } else {
                                ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "bots figure <square/triangle/largetriangle/circle/line/-line/rhomb> - Построение фигуры относительно вас."));
                            }
                        } else if (args[0].equalsIgnoreCase("pdump")) {
                            for (Thread thread : Thread.getAllStackTraces().keySet()) {
                                ChatUtils.formatMsg((String)(thread.getName() + " " + thread.getClass()));
                            }
                        } else {
                            if ((Client.getInstance().pBotsScriptManager).invokeCommand(args[0], args)) {
                                return;
                            }
                            this.error();
                        }
                        break block160;
                    }
                    this.error();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }).start();
    }

    private static PBotPlayer getPlayer2(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer3(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer4(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer5(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer6(PBot instance) {
        return instance.player;
    }

    private static float getX(Vector2f vector2f) {
        return vector2f.x;
    }

    private static PBotMinecraft getMc2(PBot instance) {
        return instance.mc;
    }

    static {
        $assertionsDisabled = !BotsCommand.class.desiredAssertionStatus() ? 1 : 0;
        delay = 100;
        target = "";
        npcId = -1;
    }

    private static PBotPlayer getPlayer7(PBot instance) {
        return instance.player;
    }

    private static BooleanSetting getUseProxy() {
        return BotSettingsModule.useProxy;
    }

    private static float getY(Vector2f vector2f) {
        return vector2f.y;
    }

    private static PBotPlayer getPlayer8(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer9(PBot instance) {
        return instance.player;
    }

    private static PBotMinecraft getMc3(PBot instance) {
        return instance.mc;
    }

    public void error() {
        ChatUtils.formatMsg((String)"Команды Ботов: ");
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots connect <кол-во> <задержка> - Запуск ботов на сервер."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots stopjoin - Остановить запуск ботов."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots chat <сообщение> - Отправить сообщение от имени бота."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots invclear - Боты выкинут все ресурсы из инвентаря."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots loadproxy <proxies.txt/URL> <socks4/socks5/http> - Загрузка прокси из файла или ссылки."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots disconnect - Отключить ботов от сервера."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots hotbar <слот> - Боты нажимают на слот в хотбаре."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots invclick <слот> - Боты нажимают на слот в инвентаре."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots manual <ответ> - Ручное решение капчи бота."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots follow <name> - Боты начнут идти за игроком/мобом."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots randommove - Боты начнут рандомно ходить и прыгать."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots spin <name> <radius> - Боты начнут ходить вокруг игрока."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots mirror - Боты начнут повторять ваши действия."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots spammer <delay_ms/off> <text> - Боты начнут спамить указаным текстом."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots clear - Принудительное отключение ботов и очистка их списка."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots attack <name> - Боты начнут атаковать игрока."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots look <yaw> <pitch> - Установить направления взгляда ботам."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots setdelay <miliseconds> - Задержка между ботами в invclick/hotbar/chat."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots slotname <name> - Клик по слоту в инвентаре используя название предмета."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots setscript <filename/empty> - Загрузить и запустить скрипт."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots auth - Регестрирует всех ботов."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots gc - Чистит озу, убирает лаги."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots rejoinall - Боты перезайдут на сервер."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots clickblock <x> <y> <z> - Нажать на блок."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots npc <rec/stop/play> - Запись и воспроизведение нажатия по NPC."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots bstop - Оставновить follow/goto/autofish."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots repeat - Воспроизведение записанного в ActionRecorder."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots autofish - Боты начнуть рыбачить."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots goto <x> <y> <z> - Боты начнут идти на координаты."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "bots figure <square/triangle/largetriangle/circle/line/-line/rhomb> - Построение фигуры относительно вас."));
    }

    private static PBotPlayer getPlayer10(PBot instance) {
        return instance.player;
    }

    private static float getX2(Vector2f vector2f) {
        return vector2f.x;
    }

    private static PBotPlayer getPlayer11(PBot instance) {
        return instance.player;
    }

    private static BooleanSetting getUseProxy2() {
        return BotSettingsModule.useProxy;
    }

    public static int parseInt(String s, int defaultVal) {
        return s.matches("-?\\\\\\\\\\\\\\\\d+") ? Integer.parseInt(s) : defaultVal;
    }

    private static ScriptManager getPBotsScriptManager8(Client instance) {
        return instance.pBotsScriptManager;
    }

    private static PBotPlayer getPlayer13(PBot instance) {
        return instance.player;
    }

    private static BooleanSetting getUseProxy3() {
        return BotSettingsModule.useProxy;
    }

    private static PBotPlayer getPlayer14(PBot instance) {
        return instance.player;
    }

    private static BotKeyState getGameSettings(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    public static String joinArrayElements(String[] arr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            result.append(arr[i]);
            if (i >= arr.length - (1)) continue;
            result.append(" ");
        }
        return result.toString();
    }

    private static BotKeyState getGameSettings2(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static PlayerEntitySP getPlayer15() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer16() {
        return Minecraft.player;
    }

    private static PBotPlayer getPlayer17(PBot instance) {
        return instance.player;
    }

    private static float getY2(Vector2f vector2f) {
        return vector2f.y;
    }

    private static PlayerEntitySP getPlayer18() {
        return Minecraft.player;
    }

    private static PBotPlayer getPlayer19(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer20(PBot instance) {
        return instance.player;
    }

    private static BotKeyState WvtPpfzdtg(PBotMinecraft instance) {
        return instance.gameSettings;
    }

}

