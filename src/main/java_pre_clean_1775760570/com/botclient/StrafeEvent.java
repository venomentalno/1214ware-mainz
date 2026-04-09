/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 */
package com.botclient;

import com.botclient.Event;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class StrafeEvent
implements Event {
    public double moveStrafe;
    public double moveForward;

    public double getMoveStrafe() {
        return (this.moveStrafe);
    }

    public StrafeEvent(double moveForward, double moveStrafe) {
        this.moveForward = moveForward;
        this.moveStrafe = moveStrafe;
    }

    private static double getMoveForward(StrafeEvent instance) {
        return instance.moveForward;
    }

    public double getMoveForward() {
        return (this.moveForward);
    }

    private static double getMoveStrafe(StrafeEvent instance) {
        return instance.moveStrafe;
    }

    public void setMoveForward(double moveForward) {
        this.moveForward = moveForward;
    }

    private static void setMoveForward(StrafeEvent d, double d2) {
        d.moveForward = d2;
    }

    public void setMoveStrafe(double moveStrafe) {
        this.moveStrafe = moveStrafe;
    }

    private static void setMoveStrafe(StrafeEvent d, double d2) {
        d.moveStrafe = d2;
    }
}

