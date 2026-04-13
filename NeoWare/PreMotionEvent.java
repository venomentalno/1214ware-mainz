/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  neo.deobf.Event
 */
package neo.deobf;

import neo.deobf.CancellableEvent;
import neo.deobf.Event;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PreMotionEvent
extends CancellableEvent
implements Event {
    public boolean onGround;
    public double posZ;
    public float pitch;
    public double posY;
    public float yaw;
    public double posX;

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    private static double getPosY(PreMotionEvent instance) {
        return instance.posY;
    }

    private static float getPitch(PreMotionEvent instance) {
        return instance.pitch;
    }

    public float getYaw() {
        return (this.yaw);
    }

    private static float getYaw(PreMotionEvent instance) {
        return instance.yaw;
    }

    public double getPosZ() {
        return (this.posZ);
    }

    private static void setPitch(PreMotionEvent g, float f) {
        g.pitch = f;
    }

    public PreMotionEvent(float yaw, float pitch, double posX, double posY, double posZ, boolean onGround) {
        this.yaw = yaw;
        this.pitch = pitch;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.onGround = onGround;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    private static double getPosX(PreMotionEvent instance) {
        return instance.posX;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    private static void setYaw(PreMotionEvent g, float f) {
        g.yaw = f;
    }

    private static void setPosZ(PreMotionEvent g, double d) {
        g.posZ = d;
    }

    private static void setPosY(PreMotionEvent g, double d) {
        g.posY = d;
    }

    private static void setPosX(PreMotionEvent g, double d) {
        g.posX = d;
    }

    private static void setOnGround(PreMotionEvent g, boolean value) {
        g.onGround = value;
    }

    public double getPosX() {
        return (this.posX);
    }

    public float getPitch() {
        return (this.pitch);
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public boolean isOnGround() {
        return (this.onGround);
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public double getPosY() {
        return (this.posY);
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    private static double getPosZ(PreMotionEvent instance) {
        return instance.posZ;
    }
}

