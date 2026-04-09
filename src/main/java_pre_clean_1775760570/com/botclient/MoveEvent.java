/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 */
package com.botclient;

import com.botclient.CancellableEvent;

public class MoveEvent
extends CancellableEvent {
    public double z;
    public double y;
    public double x;

    public double getX() {
        return (this.x);
    }

    private static void setY(MoveEvent c, double d) {
        c.y = d;
    }

    private static void setZ(MoveEvent c, double d) {
        c.z = d;
    }

    private static void setX(MoveEvent c, double d) {
        c.x = d;
    }

    public MoveEvent(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    private static double getZ(MoveEvent instance) {
        return instance.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getY() {
        return (this.y);
    }

    public double getZ() {
        return (this.z);
    }

    private static double getY(MoveEvent instance) {
        return instance.y;
    }

    private static double getX(MoveEvent instance) {
        return instance.x;
    }
}

