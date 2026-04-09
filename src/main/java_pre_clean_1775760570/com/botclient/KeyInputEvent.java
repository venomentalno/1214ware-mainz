/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 */
package com.botclient;

import com.botclient.Event;

public class KeyInputEvent
implements Event {
    public int key;

    private static int getKey(KeyInputEvent instance) {
        return instance.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public KeyInputEvent(int key) {
        this.key = key;
    }

    private static void setKey(KeyInputEvent r, int n) {
        r.key = n;
    }

    public int getKey() {
        return (this.key);
    }
}

