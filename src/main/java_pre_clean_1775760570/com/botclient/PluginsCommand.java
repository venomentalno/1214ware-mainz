/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CommandInfo
 *  neo.deobf.Command
 *  neo.deobf.CommandChatListener
 *  neo.deobf.ChatUtils
 *  neo.deobf.ThreadUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.PlayerEntitySP
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketTabComplete
 *  org.apache.commons.lang3.StringUtils
 */
package com.botclient;

import java.util.Objects;
import com.botclient.CommandInfo;
import com.botclient.Command;
import com.botclient.CommandChatListener;
import com.botclient.ChatUtils;
import com.botclient.ThreadUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.CPacketTabComplete;
import org.apache.commons.lang3.StringUtils;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@CommandInfo(name="plugins", description="Получить список плагинов сервера.")
public class PluginsCommand
extends Command {
    public static boolean inprogress;
    public static StringBuilder cores;
    public final char[] alphabet;
    public static StringBuilder plugins;

    private static PlayerEntitySP getPlayer2() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer3() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer4() {
        return Minecraft.player;
    }

    public void execute(String[] args) throws Exception {
        if ((inprogress)) {
            ChatUtils.formatMsg((String)"&cУже запущен поиск плагинов!");
            return;
        }
        new Thread(() -> {
            try {
                inprogress = true;
                plugins = new StringBuilder();
                cores = new StringBuilder();
                (PluginsCommand.getPlayer3().connection).sendPacket((Packet)new CPacketTabComplete("/es", (Minecraft.player).getPosition(), false));
                ThreadUtils.sleep((long)200L);
                (PluginsCommand.getPlayer13().connection).sendPacket((Packet)new CPacketTabComplete("/ess", (Minecraft.player).getPosition(), false));
                ThreadUtils.sleep((long)200L);
                (PluginsCommand.getPlayer7().connection).sendPacket((Packet)new CPacketTabComplete("/viaversion:v", (Minecraft.player).getPosition(), false));
                ThreadUtils.sleep((long)200L);
                (PluginsCommand.getPlayer14().connection).sendPacket((Packet)new CPacketTabComplete("/bo", (Minecraft.player).getPosition(), false));
                ThreadUtils.sleep((long)200L);
                char[] cArray = (this.alphabet);
                int n = cArray.length;
                for (int i = 0; i < n; ++i) {
                    char s = cArray[i];
                    (PluginsCommand.getPlayer4().connection).sendPacket((Packet)new CPacketTabComplete("/" + s, (Minecraft.player).getPosition(), false));
                    if (s == (114) && (Objects.requireNonNull(MinecraftClient.getInstance().getCurrentServerData()).serverIP).toLowerCase().contains("reallyworld")) {
                        ThreadUtils.sleep((long)200L);
                        (PluginsCommand.getPlayer2().connection).sendPacket((Packet)new CPacketTabComplete("/rw", (Minecraft.player).getPosition(), false));
                        ThreadUtils.sleep((long)200L);
                        (PluginsCommand.getPlayer11().connection).sendPacket((Packet)new CPacketTabComplete("/really", (Minecraft.player).getPosition(), false));
                        ThreadUtils.sleep((long)200L);
                        (PluginsCommand.getPlayer10().connection).sendPacket((Packet)new CPacketTabComplete("/kondr-", (Minecraft.player).getPosition(), false));
                    }
                    ThreadUtils.sleep((long)200L);
                }
                if ((plugins).toString().contains(",")) {
                    ChatUtils.formatMsg((String)("&fPlugins (" + StringUtils.countMatches((CharSequence)(plugins).toString(), (CharSequence)",") + "): " + (plugins).substring(0, (plugins).toString().length() - (1))));
                } else {
                    ChatUtils.formatMsg((String)"&cПлагины не найдены.");
                }
                if ((cores).toString().contains(",")) {
                    ChatUtils.formatMsg((String)("&fServer cores: " + (cores).substring(0, (cores).toString().length() - (1))));
                } else {
                    ChatUtils.formatMsg((String)"&cЯдра не найдены.");
                }
                inprogress = false;
            }
            catch (Exception exception) {
                inprogress = false;
            }
        }).start();
    }

    private static PlayerEntitySP getPlayer7() {
        return Minecraft.player;
    }

    public static void onTabComplete(String[] completions) {
        String[] stringArray = completions;
        int n = stringArray.length;
        for (int i = 0; i < n; ++i) {
            String compleation = stringArray[i];
            if (!compleation.contains(":")) continue;
            String alias = compleation.split(":")[0].replace("/", "").toLowerCase();
            String formate = StringUtils.capitalize((String)compleation.split(":")[0].replace("/", ""));
            if (alias.contains("velocity") || alias.contains("spigot") || alias.contains("bungeecord") || alias.contains("paper") || alias.contains("magma") || alias.contains("forge") || alias.contains("pupur") || alias.contains("bukkit")) {
                if ((cores).toString().contains(" " + formate + ",")) continue;
                (cores).append(" ").append(formate).append(",");
                continue;
            }
            if ((plugins).toString().contains(" " + formate + ",")) continue;
            (plugins).append(" ").append(formate).append(",");
        }
    }

    public PluginsCommand() {
        char[] cArray = new char[26];
        cArray[0] = 97;
        cArray[1] = 98;
        cArray[2] = 99;
        cArray[3] = 100;
        cArray[4] = 101;
        cArray[5] = 102;
        cArray[6] = 103;
        cArray[7] = 104;
        cArray[8] = 105;
        cArray[9] = 106;
        cArray[10] = 107;
        cArray[11] = 108;
        cArray[12] = 109;
        cArray[13] = 110;
        cArray[14] = 111;
        cArray[15] = 112;
        cArray[16] = 113;
        cArray[17] = 114;
        cArray[18] = 115;
        cArray[19] = 116;
        cArray[20] = 117;
        cArray[21] = 118;
        cArray[22] = 119;
        cArray[23] = 120;
        cArray[24] = 121;
        cArray[25] = 122;
        this.alphabet = cArray;
    }

    private static PlayerEntitySP getPlayer10() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer11() {
        return Minecraft.player;
    }

    public void error() {
        ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "plugins - Получить список плагинов сервера."));
    }

    private static PlayerEntitySP getPlayer13() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer14() {
        return Minecraft.player;
    }

}

