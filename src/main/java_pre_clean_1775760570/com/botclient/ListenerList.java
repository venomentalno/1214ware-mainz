/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.ListenerData
 */
package com.botclient;

import java.util.concurrent.CopyOnWriteArrayList;
import com.botclient.ListenerData;

/*
 * Exception performing whole class analysis ignored.
 */
final class ListenerList
extends CopyOnWriteArrayList<ListenerData> {
    private static final long serialVersionUID = 666L;
    final ListenerData val$data;

    ListenerList(ListenerData l) {
        this.val$data = l;
        this.add(this.val$data);
    }
}



