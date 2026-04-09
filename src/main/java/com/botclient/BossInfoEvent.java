/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 */
package com.botclient;

import com.botclient.Event;

public class BossInfoEvent
implements Event {
    public String bossName;

    public BossInfoEvent(String bossName) {
        this.bossName = bossName;
    }
}



