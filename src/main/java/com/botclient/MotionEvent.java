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

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class MotionEvent
extends CancellableEvent
implements Event {
    private float yawDelta;
    public float pitch;
    public double posZ;
    public double posY;
    public float yaw;
    private float pitchDelta;
    public double posX;
    public boolean canceled;
    public boolean onGround;

    private static void setPosY(MotionEvent x, double d) {
        x.posY = d;
    }

    private static void setPosZ(MotionEvent x, double d) {
        x.posZ = d;
    }

    public boolean isCanceled() {
        return (this.canceled);
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public double getPosZ() {
        return (this.posZ);
    }

    public float getPitch() {
        return (this.pitch);
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    public boolean isOnGround() {
        return (this.onGround);
    }

    public MotionEvent(float yaw, float pitch, double posX, double posY, double posZ, boolean onGround) {
        this.yaw = yaw;
        this.pitch = pitch;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.onGround = onGround;
    }

    private static void setOnGround(MotionEvent x, boolean value) {
        x.onGround = value;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    private static void setYaw(MotionEvent x, float f) {
        x.yaw = f;
    }

    private static double getPosX(MotionEvent instance) {
        return instance.posX;
    }

    private static float getPitch(MotionEvent instance) {
        return instance.pitch;
    }

    private static void setPitch(MotionEvent x, float f) {
        x.pitch = f;
    }

    public float getYaw() {
        return (this.yaw);
    }

    private static void setPosX(MotionEvent x, double d) {
        x.posX = d;
    }

    private static void setCanceled(MotionEvent x, boolean value) {
        x.canceled = value;
    }

    private static double getPosY(MotionEvent instance) {
        return instance.posY;
    }

    public void setCanceled() {
        this.canceled = true;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public double getPosY() {
        return (this.posY);
    }

    private static double getPosZ(MotionEvent instance) {
        return instance.posZ;
    }

    private static float getYaw(MotionEvent instance) {
        return instance.yaw;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosX() {
        return (this.posX);
    }
}

