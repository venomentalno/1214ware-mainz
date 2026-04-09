/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Library
 *  com.sun.jna.Native
 *  neo.deobf.DiscordEventHandlers
 *  neo.deobf.DiscordRichPresence
 */
package com.botclient;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.botclient.DiscordEventHandlers;
import com.botclient.DiscordRichPresence;

public interface DiscordRpcLibrary
extends Library {
    public static final DiscordRpcLibrary INSTANCE = (DiscordRpcLibrary)Native.loadLibrary((String)"discord-rpc", DiscordRpcLibrary.class);

    public void Discord_Register(String var1, String var2);

    public void Discord_RunCallbacks();

    public void Discord_ClearPresence();

    public void Discord_UpdateHandlers(DiscordEventHandlers var1);

    public void Discord_Initialize(String var1, DiscordEventHandlers var2, boolean var3, String var4);

    public void Discord_UpdateConnection();

    public void Discord_RegisterSteamGame(String var1, String var2);

    public void Discord_Shutdown();

    public void Discord_UpdatePresence(DiscordRichPresence var1);

    public void Discord_Respond(String var1, int var2);
}



