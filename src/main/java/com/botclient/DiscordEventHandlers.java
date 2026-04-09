/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Structure
 *  neo.deobf.DiscordDisconnectedCallback
 *  neo.deobf.DiscordErroredCallback
 *  neo.deobf.DiscordJoinGameCallback
 *  neo.deobf.DiscordJoinRequestCallback
 *  neo.deobf.DiscordReadyCallback
 *  neo.deobf.DiscordSpectateGameCallback
 */
package com.botclient;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import com.botclient.DiscordDisconnectedCallback;
import com.botclient.DiscordErroredCallback;
import com.botclient.DiscordJoinGameCallback;
import com.botclient.DiscordJoinRequestCallback;
import com.botclient.DiscordReadyCallback;
import com.botclient.DiscordSpectateGameCallback;

public class DiscordEventHandlers
extends Structure {
    public DiscordReadyCallback ready;
    public DiscordJoinRequestCallback joinRequest;
    public DiscordSpectateGameCallback spectateGame;
    public DiscordDisconnectedCallback disconnected;
    public DiscordErroredCallback errored;
    public DiscordJoinGameCallback joinGame;
protected List<String> getFieldOrder() {
        String[] stringArray = new String[6];
        stringArray[0] = "ready";
        stringArray[1] = "disconnected";
        stringArray[2] = "errored";
        stringArray[3] = "joinGame";
        stringArray[4] = "spectateGame";
        stringArray[5] = "joinRequest";
        return Arrays.asList(stringArray);
    }
}



