/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 */
package com.botclient;

import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;

public interface MinecraftContext {
    public static final Minecraft mc = MinecraftClient.getInstance();
    public static final Random random = new Random();
}



