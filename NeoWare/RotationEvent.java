/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 */
package neo.deobf;

import neo.deobf.CancellableEvent;

public class RotationEvent
extends CancellableEvent {
    public float yaw;
    public float pitch;

    private static void setPitch(RotationEvent f, float f2) {
        f.pitch = f2;
    }

    private static void setYaw(RotationEvent f, float f2) {
        f.yaw = f2;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return (this.pitch);
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getYaw() {
        return (this.yaw);
    }

    public RotationEvent(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    private static float getYaw(RotationEvent instance) {
        return instance.yaw;
    }

    private static float getPitch(RotationEvent instance) {
        return instance.pitch;
    }
}

