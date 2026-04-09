/*
 * Decompiled with CFR 0.152.
 */
package com.botclient;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class MillisTimer {
    public long ms = this.callCurrentTimeMillis();

    private long callCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public void reset() {
        this.ms = this.callCurrentTimeMillis();
    }

    public boolean hasReached(double milliseconds) {
        return ((double)(this.callCurrentTimeMillis() - (this.ms)) > milliseconds ? 1 : 0) != 0;
    }

    public long getTime() {
        return this.callCurrentTimeMillis() - (this.ms);
    }
}

