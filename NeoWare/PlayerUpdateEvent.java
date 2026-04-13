/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CancellableEvent
 *  net.minecraft.network.play.server.SPacketPlayerListItem$Action
 *  net.minecraft.network.play.server.SPacketPlayerListItem$AddPlayerData
 */
package neo.deobf;

import neo.deobf.CancellableEvent;
import net.minecraft.network.play.server.SPacketPlayerListItem;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PlayerUpdateEvent
extends CancellableEvent {
    public boolean onGround;
    public float yaw;
    public double x;
    public final boolean isPre;
    public float pitch;
    public double z;
    public double y;

    private static void setX(PlayerUpdateEvent e, double d) {
        e.x = d;
    }

    public PlayerUpdateEvent(double x, double y, double z, float yaw, float pitch, boolean onGround) {
        this.y = y;
        this.x = x;
        this.z = z;
        this.isPre = 1;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }

    private static void setZ(PlayerUpdateEvent e, double d) {
        e.z = d;
    }

    public SPacketPlayerListItem.Action getAction() {
        return null;
    }

    public void setX(double x) {
        this.x = x;
    }

    public PlayerUpdateEvent() {
        this.isPre = 0;
    }

    public boolean isPre() {
        return (this.isPre);
    }

    public boolean isPost() {
        return (!(this.isPre) ? 1 : 0) != 0;
    }

    private static void setYaw(PlayerUpdateEvent e, float f) {
        e.yaw = f;
    }

    public boolean isOnGround() {
        return (this.onGround);
    }

    public double getX() {
        return (this.x);
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    private static void setY(PlayerUpdateEvent e, double d) {
        e.y = d;
    }

    private static float getPitch(PlayerUpdateEvent instance) {
        return instance.pitch;
    }

    public float getPitch() {
        return (this.pitch);
    }

    private static double getZ(PlayerUpdateEvent instance) {
        return instance.z;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public double getZ() {
        return (this.z);
    }

    public void setZ(double z) {
        this.z = z;
    }

    public float getYaw() {
        return (this.yaw);
    }

    private static void setOnGround(PlayerUpdateEvent e, boolean value) {
        e.onGround = value;
    }

    private static void setPitch(PlayerUpdateEvent e, float f) {
        e.pitch = f;
    }

    private static double getX(PlayerUpdateEvent instance) {
        return instance.x;
    }

    public SPacketPlayerListItem.AddPlayerData getData() {
        return null;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    private static float getYaw(PlayerUpdateEvent instance) {
        return instance.yaw;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return (this.y);
    }
}

