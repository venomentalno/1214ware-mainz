/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ServerAddress
 *  net.minecraft.client.multiplayer.ServerData
 */
package com.botclient;

import java.util.Objects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.multiplayer.ServerData;

public class ServerAddressUtils {

    public static int getPort() {
        return ServerAddress.fromString((String)(Objects.requireNonNull(MinecraftClient.getInstance().getCurrentServerData()).serverIP)).getPort();
    }

    public static String getIp() {
        return ServerAddress.fromString((String)(Objects.requireNonNull(MinecraftClient.getInstance().getCurrentServerData()).serverIP)).getIP();
    }
}

