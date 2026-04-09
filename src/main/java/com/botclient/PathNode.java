/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.joml.Vector3i
 */
package com.botclient;

import net.minecraft.util.math.Vec3i;

public class PathNode {
    public PathNode prev;
    public int dist;
    public final Vec3i pos;

    public PathNode(Vec3i pos) {
        this.pos = pos;
        this.prev = null;
        this.dist = 0;
    }
}





