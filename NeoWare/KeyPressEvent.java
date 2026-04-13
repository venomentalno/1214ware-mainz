/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 */
package neo.deobf;

import neo.deobf.CancellableEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class KeyPressEvent
extends CancellableEvent {
    public int key;

    public KeyPressEvent(int key) {
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return (this.key);
    }

    private static void setKey(KeyPressEvent s, int n) {
        s.key = n;
    }

}

