/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 */
package com.botclient;

import com.botclient.CancellableEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ChatMessageSendEvent
extends CancellableEvent {
    public boolean cancelled;
    public String message;

    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    public String getMessage() {
        return (this.message);
    }

    public ChatMessageSendEvent(String chat) {
        this.message = chat;
    }

    private static String getMessage(ChatMessageSendEvent instance) {
        return instance.message;
    }

    private static void setCancelled(ChatMessageSendEvent h, boolean value) {
        h.cancelled = value;
    }
}

