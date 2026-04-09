/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.DiscordDisconnectedCallback
 *  neo.deobf.DiscordErroredCallback
 *  neo.deobf.DiscordJoinGameCallback
 *  neo.deobf.DiscordJoinRequestCallback
 *  neo.deobf.DiscordReadyCallback
 *  neo.deobf.DiscordSpectateGameCallback
 *  neo.deobf.DiscordEventHandlers
 */
package com.botclient;

import com.botclient.DiscordDisconnectedCallback;
import com.botclient.DiscordErroredCallback;
import com.botclient.DiscordJoinGameCallback;
import com.botclient.DiscordJoinRequestCallback;
import com.botclient.DiscordReadyCallback;
import com.botclient.DiscordSpectateGameCallback;
import com.botclient.DiscordEventHandlers;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Exception performing whole class analysis ignored.
 */
public class DiscordEventHandlersBuilder {
    public final DiscordEventHandlers handlers = new DiscordEventHandlers();

    public DiscordEventHandlersBuilder errored(DiscordErroredCallback errored) {
        DiscordEventHandlersBuilder.DiscordEventHandlersBuilder.getHandlers6(this).errored = errored;
        return this;
    }

    public DiscordEventHandlersBuilder ready(DiscordReadyCallback ready) {
        DiscordEventHandlersBuilder.DiscordEventHandlersBuilder.getHandlers5(this).ready = ready;
        return this;
    }

    public DiscordEventHandlersBuilder joinGame(DiscordJoinGameCallback joinGame) {
        DiscordEventHandlersBuilder.DiscordEventHandlersBuilder.getHandlers3(this).joinGame = joinGame;
        return this;
    }

    public DiscordEventHandlersBuilder spectateGame(DiscordSpectateGameCallback spectateGame) {
        DiscordEventHandlersBuilder.DiscordEventHandlersBuilder.getHandlers7(this).spectateGame = spectateGame;
        return this;
    }

    public DiscordEventHandlersBuilder disconnected(DiscordDisconnectedCallback disconnected) {
        DiscordEventHandlersBuilder.DiscordEventHandlersBuilder.getHandlers(this).disconnected = disconnected;
        return this;
    }

    public DiscordEventHandlersBuilder joinRequest(DiscordJoinRequestCallback joinRequest) {
        DiscordEventHandlersBuilder.DiscordEventHandlersBuilder.getHandlers2(this).joinRequest = joinRequest;
        return this;
    }

    public DiscordEventHandlers build() {
        return this.handlers;
    }
}

