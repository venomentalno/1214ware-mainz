/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  neo.deobf.Event
 */
package com.botclient;

import com.botclient.CancellableEvent;
import com.botclient.Event;

public class ChatMessageEvent
extends CancellableEvent
implements Event {
    public String message;

    public String getMessage() {
        return (this.message);
    }

    private static String getMessage(ChatMessageEvent instance) {
        return instance.message;
    }

    public ChatMessageEvent(String message) {
        this.message = message;
    }
}

