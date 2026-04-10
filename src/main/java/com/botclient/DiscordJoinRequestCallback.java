/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Callback
 *  neo.deobf.DiscordUser
 */
package neo.deobf;

import com.sun.jna.Callback;
import neo.deobf.DiscordUser;

public interface DiscordJoinRequestCallback
extends Callback {
    public void apply(DiscordUser var1);
}



