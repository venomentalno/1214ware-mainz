/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Client
 *  neo.deobf.DiscordEventHandlersBuilder
 *  neo.deobf.DiscordEventHandlers
 *  neo.deobf.DiscordRichPresenceBuilder
 *  neo.deobf.DiscordRpcLibrary
 *  neo.deobf.DiscordUser
 *  neo.deobf.DiscordRpcThread
 *  neo.deobf.DiscordRpcButton
 */
package com.botclient;

import com.botclient.Client;
import com.botclient.DiscordEventHandlersBuilder;
import com.botclient.DiscordEventHandlers;
import com.botclient.DiscordRichPresenceBuilder;
import com.botclient.DiscordRpcLibrary;
import com.botclient.DiscordUser;
import com.botclient.DiscordRpcThread;
import com.botclient.DiscordRpcButton;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class DiscordRpc {
    public static long time;
    public static DiscordUser discordUser;
    public static final DiscordRpcThread discordDaemonThread;

    public static void init() {
        DiscordRichPresenceBuilder builder = new DiscordRichPresenceBuilder();
        DiscordEventHandlers handlers = new DiscordEventHandlersBuilder().ready(user -> DiscordRpc.setDiscordUser(user)).build();
        String id = "1210977923063087144";
        (DiscordRpcLibrary.INSTANCE).Discord_Initialize(id, handlers, true, null);
        time = System.currentTimeMillis() / 1000L;
        builder.setStartTimestamp((time));
        builder.setDetails("Version: " + (Client.VERSION_TYPE));
        builder.setLargeImage("neoware", "dsc.gg/neowareclient");
        try {
            builder.setButtons(DiscordRpcButton.create((String)"Discord", (String)"https://discord.com/invite/2rxyndXyUB"), DiscordRpcButton.create((String)"Site", (String)"https://krytickyt.github.io/NeoWare/"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        (DiscordRpcLibrary.INSTANCE).Discord_UpdatePresence(builder.build());
        (discordDaemonThread).start();
    }

    private static void setDiscordUser(DiscordUser user) {
        discordUser = user;
    }

    static {
        discordDaemonThread = new DiscordRpcThread(null);
    }

    public static void stopRPC() {
        (DiscordRpcLibrary.INSTANCE).Discord_Shutdown();
        (discordDaemonThread).interrupt();
    }

public static void update(String details, String state) {
        DiscordRichPresenceBuilder builder = new DiscordRichPresenceBuilder();
        builder.setLargeImage("neoware", "dsc.gg/neowareclient");
        builder.setDetails(details);
        builder.setState(state);
        builder.setStartTimestamp((time));
        try {
            builder.setButtons(DiscordRpcButton.create((String)"Discord", (String)"https://discord.com/invite/2rxyndXyUB"), DiscordRpcButton.create((String)"Site", (String)"https://krytickyt.github.io/NeoWare/"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        (DiscordRpcLibrary.INSTANCE).Discord_UpdatePresence(builder.build());
    }

}

