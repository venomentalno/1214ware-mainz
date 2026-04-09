/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.PBot
 *  neo.deobf.MinecraftContext
 *  neo.deobf.RandomUtils
 *  neo.deobf.RandomProvocationPool
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.PlayerListEntry
 */
package com.botclient;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import com.botclient.PBot;
import com.botclient.MinecraftContext;
import com.botclient.RandomUtils;
import com.botclient.RandomProvocationPool;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PlaceholderFormatter
implements MinecraftContext {
    public static String format(String message) {
        return message.replace("%players", PlaceholderFormatter.getRandomPlayer()).replace("%swear", RandomProvocationPool.getRandom()).replace("%s", RandomUtils.randomString((int)(6))).replace("%n", RandomUtils.randomNumber((int)(8))).replace("%china", RandomUtils.randomChineseString((int)(40))).replace("%ilil", RandomUtils.randomStringByPattern((int)(12), (String)"lI")).replace("%o0o0", RandomUtils.randomStringByPattern((int)(12), (String)"0oO"));
    }

    private static String getRandomPlayer() {
        try {
            ArrayList<String> players = new ArrayList<String>();
            for (NetworkPlayerInfo player : Objects.requireNonNull((mc).getConnection()).getPlayerInfoMap()) {
                String nickname = player.getGameProfile().getName();
                if (PBot.getBot((String)nickname) != null || player.getResponseTime() <= 0) continue;
                players.add(player.getGameProfile().getName());
            }
            return (String)players.get((random).nextInt(players.size()));
        }
        catch (Exception exception) {
            return "empty";
        }
    }

}

