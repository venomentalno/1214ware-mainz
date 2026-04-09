/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.joml.Vector3i
 *  neo.deobf.PathNode
 *  net.minecraft.entity.player.PlayerEntity
 */
package com.botclient;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.joml.Vector3i;
import com.botclient.PathNode;
import net.minecraft.entity.player.PlayerEntity;

public abstract class AbstractPathScanner {
    public boolean done;
    public CopyOnWriteArrayList<PathNode> unchecked = new CopyOnWriteArrayList();
    public CopyOnWriteArrayList<PathNode> checked = new CopyOnWriteArrayList();
    protected CopyOnWriteArrayList<PathNode> path;

    private static Vector3i getPos(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos2(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos3(PathNode instance) {
        return instance.pos;
    }

    public abstract void onFinished();

    public abstract List<PathNode> getPathList();

    private static Vector3i getPos4(PathNode instance) {
        return instance.pos;
    }

    public abstract boolean onUpdate(PlayerEntity var1);

    public abstract boolean isRunning();

    public abstract void stop();

    public abstract void scan();

    private static Vector3i getPos5(PathNode instance) {
        return instance.pos;
    }

    public boolean contains(CopyOnWriteArrayList<PathNode> list, PathNode find) {
        for (PathNode point : list) {
            if ((AbstractPathScanner.getPos6(point).x) != (AbstractPathScanner.getPos(find).x) || (AbstractPathScanner.getPos4(point).y) != (AbstractPathScanner.getPos2(find).y) || (AbstractPathScanner.getPos5(point).z) != (AbstractPathScanner.getPos3(find).z)) continue;
            return true;
        }
        return false;
    }

    private static Vector3i getPos6(PathNode instance) {
        return instance.pos;
    }
}

