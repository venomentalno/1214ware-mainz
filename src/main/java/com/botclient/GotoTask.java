/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.joml.Vector3i
 *  neo.deobf.PBot
 *  neo.deobf.BotTask
 */
package com.botclient;

import org.joml.Vector3i;
import com.botclient.PBot;
import com.botclient.BotTask;

public class GotoTask
extends BotTask {
    public final Vector3i location;

    public GotoTask(PBot bot, Vector3i location) {
        super(bot, "Goto");
        this.location = location;
        this.sendDebug("&5[&dBot-Baritone&5] &7Bot " + this.getBot().getNickname() + " | Goto location " + location.toString());
    }
public void onUpdate() {
    }

    public void onFinish() {
        this.getBaritone().getPathFinder().pathFindStop();
        super.onFinish();
    }

    public void init() {
        this.getBaritone().getPathFinder().pathFindStart((this.location));
        this.getBaritone().getPathFinder().unPause();
    }
}

