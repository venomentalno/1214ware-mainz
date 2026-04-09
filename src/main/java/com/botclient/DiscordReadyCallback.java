/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Callback
 *  neo.deobf.DiscordUser
 */
package com.botclient;

import com.sun.jna.Callback;
import com.botclient.DiscordUser;

public interface DiscordReadyCallback
extends Callback {
    public void apply(DiscordUser var1);
}



