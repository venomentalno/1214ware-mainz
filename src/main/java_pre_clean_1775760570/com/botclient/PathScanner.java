/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Vector3i
 *  neo.deobf.AbstractPathScanner
 *  neo.deobf.PathBlockUtils
 *  neo.deobf.PathNode
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.world.World
 */
package com.botclient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.vecmath.Vector3i;
import com.botclient.AbstractPathScanner;
import com.botclient.PathBlockUtils;
import com.botclient.PathNode;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PathScanner
extends AbstractPathScanner {
    public final Vector3i from;
    public final Vector3i to;
    public boolean running;
    public World world;

    private static Vector3i getPos(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos2(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos3(PathNode instance) {
        return instance.pos;
    }

    private List<PathNode> getNear(PathNode point) {
        ArrayList<PathNode> list = new ArrayList<PathNode>();
        if ((point.dist) >= (128)) {
            return list;
        }
        Vector3i posFrom = new Vector3i((PathScanner.getPos6(point).x), (PathScanner.getPos12(point).y), (PathScanner.getPos(point).z));
        for (int yoffset = -8; yoffset < (2); ++yoffset) {
            PathNode near;
            Vector3i temp_pos = new Vector3i((PathScanner.getPos30(point).x) - (1), (PathScanner.getPos15(point).y) + yoffset, (PathScanner.getPos2(point).z));
            if (PathBlockUtils.canMoveTo((Vector3i)posFrom, (Vector3i)temp_pos, (World)(this.world))) {
                near = new PathNode(temp_pos);
                near.prev = point;
                near.dist = PathScanner.getDist8(point) + (1);
                list.add(near);
            }
            if (PathBlockUtils.canMoveTo((Vector3i)posFrom, (Vector3i)(temp_pos = new Vector3i((PathScanner.getPos11(point).x) + (1), (PathScanner.getPos8(point).y) + yoffset, (PathScanner.getPos35(point).z))), (World)(this.world))) {
                near = new PathNode(temp_pos);
                near.prev = point;
                near.dist = PathScanner.getDist2(point) + (1);
                list.add(near);
            }
            if (PathBlockUtils.canMoveTo((Vector3i)posFrom, (Vector3i)(temp_pos = new Vector3i((PathScanner.getPos37(point).x), (PathScanner.getPos21(point).y) + yoffset, (PathScanner.getPos22(point).z) - (1))), (World)(this.world))) {
                near = new PathNode(temp_pos);
                near.prev = point;
                near.dist = PathScanner.zGqWrnddmd(point) + (1);
                list.add(near);
            }
            if (PathBlockUtils.canMoveTo((Vector3i)posFrom, (Vector3i)(temp_pos = new Vector3i((PathScanner.getPos39(point).x), (PathScanner.getPos3(point).y) + yoffset, (PathScanner.getPos9(point).z) + (1))), (World)(this.world))) {
                near = new PathNode(temp_pos);
                near.prev = point;
                near.dist = PathScanner.getDist(point) + (1);
                list.add(near);
            }
            temp_pos = new Vector3i((PathScanner.getPos18(point).x) - (1), (PathScanner.getPos17(point).y) + yoffset, (PathScanner.getPos16(point).z) - (1));
            if (PathBlockUtils.canMoveToDiagonal((Vector3i)(point.pos), (Vector3i)temp_pos, (World)(this.world))) {
                near = new PathNode(temp_pos);
                near.prev = point;
                near.dist = PathScanner.getDist3(point) + (1);
                list.add(near);
            }
            temp_pos = new Vector3i((PathScanner.getPos32(point).x) + (1), (PathScanner.getPos13(point).y) + yoffset, (PathScanner.getPos5(point).z) - (1));
            if (PathBlockUtils.canMoveToDiagonal((Vector3i)(point.pos), (Vector3i)temp_pos, (World)(this.world))) {
                near = new PathNode(temp_pos);
                near.prev = point;
                near.dist = PathScanner.getDist7(point) + (1);
                list.add(near);
            }
            temp_pos = new Vector3i((PathScanner.getPos19(point).x) + (1), (PathScanner.getPos33(point).y) + yoffset, (PathScanner.getPos27(point).z) + (1));
            if (PathBlockUtils.canMoveToDiagonal((Vector3i)(point.pos), (Vector3i)temp_pos, (World)(this.world))) {
                near = new PathNode(temp_pos);
                near.prev = point;
                near.dist = PathScanner.getDist4(point) + (1);
                list.add(near);
            }
            temp_pos = new Vector3i((PathScanner.getPos14(point).x) - (1), (PathScanner.getPos29(point).y) + yoffset, (PathScanner.getPos31(point).z) + (1));
            if (!PathBlockUtils.canMoveToDiagonal((Vector3i)(point.pos), (Vector3i)temp_pos, (World)(this.world))) continue;
            near = new PathNode(temp_pos);
            near.prev = point;
            near.dist = PathScanner.getDist6(point) + (1);
            list.add(near);
        }
        return list;
    }

    private static Vector3i getPos4(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos5(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos6(PathNode instance) {
        return instance.pos;
    }

    public boolean isRunning() {
        return (!(this.done) && (this.running) ? 1 : 0) != 0;
    }

    private static int getDist(PathNode instance) {
        return instance.dist;
    }

    private static int getDist2(PathNode instance) {
        return instance.dist;
    }

    public void stop() {
        this.running = false;
    }

    private static Vector3i getTo(PathScanner instance) {
        return instance.to;
    }

    private static Vector3i getPos8(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos9(PathNode instance) {
        return instance.pos;
    }

    private static int getDist3(PathNode instance) {
        return instance.dist;
    }

    private static Vector3i getTo2(PathScanner instance) {
        return instance.to;
    }

    private static Vector3i getPos11(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos12(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos13(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos14(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos15(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos16(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos17(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos18(PathNode instance) {
        return instance.pos;
    }

    private static CopyOnWriteArrayList getPath3(PathScanner instance) {
        return instance.path;
    }

    private static Vector3i getPos19(PathNode instance) {
        return instance.pos;
    }

    public void scan() {
        this.done = false;
        this.running = true;
        (this.unchecked).clear();
        (this.checked).clear();
        PathNode start = new PathNode((this.from));
        start.dist = 0;
        (this.unchecked).add(start);
        int allowedLoops = 65536;
        int loop = 0;
        PathNode end = null;
        block0: while (!(this.unchecked).isEmpty() && this.isRunning()) {
            for (PathNode point : (this.unchecked)) {
                if (loop > allowedLoops) {
                    (this.unchecked).clear();
                    continue block0;
                }
                List<PathNode> nearlist = this.getNear(point);
                (this.unchecked).remove(point);
                (this.checked).add(point);
                if ((PathScanner.getPos4(point).x) == (PathScanner.getTo2(this).x) && (PathScanner.getPos38(point).y) == (PathScanner.getTo3(this).y) && (PathScanner.getPos34(point).z) == (PathScanner.getTo(this).z)) {
                    (this.unchecked).clear();
                    end = point;
                    continue block0;
                }
                for (PathNode near : nearlist) {
                    if (this.contains((this.unchecked), near) || this.contains((this.checked), near)) continue;
                    (this.unchecked).add(near);
                }
                ++loop;
            }
        }
        (this.path).clear();
        if (end == null) {
            return;
        }
        PathNode Next = (end.prev);
        (this.path).add(end);
        while (Next != null) {
            (this.path).add(Next);
            Next = (Next.prev);
        }
        this.path = PathScanner.reverseList(PathScanner.getPath3(this));
        this.done = true;
    }

    private static Vector3i getPos20(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos21(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos22(PathNode instance) {
        return instance.pos;
    }

    private static int getDist4(PathNode instance) {
        return instance.dist;
    }

    private static Vector3i getPos24(PathNode instance) {
        return instance.pos;
    }

    private static int getDist6(PathNode instance) {
        return instance.dist;
    }

    private static Vector3i getTo3(PathScanner instance) {
        return instance.to;
    }

    private static Vector3i getPos25(PathNode instance) {
        return instance.pos;
    }

    public boolean onUpdate(PlayerEntity player) {
        return false;
    }

    public PathScanner(Vector3i from, Vector3i to, World world) {
        this.path = new CopyOnWriteArrayList();
        this.from = from;
        this.to = to;
        this.world = world;
        this.done = 0;
    }

    private static Vector3i getPos26(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos27(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos28(PathNode instance) {
        return instance.pos;
    }

    public List<PathNode> getPathList() {
        return (this.path);
    }

    private static Vector3i getPos29(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos30(PathNode instance) {
        return instance.pos;
    }

    public static <T> CopyOnWriteArrayList<T> reverseList(List<T> list) {
        CopyOnWriteArrayList<T> reverse = new CopyOnWriteArrayList<T>(list);
        Collections.reverse(reverse);
        return reverse;
    }

    private static Vector3i getPos31(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos32(PathNode instance) {
        return instance.pos;
    }

    public void onFinished() {
        (this.path).clear();
        (this.checked).clear();
        (this.unchecked).clear();
                this.stop();
    }

    private static Vector3i getPos33(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos34(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos35(PathNode instance) {
        return instance.pos;
    }

    public boolean contains(CopyOnWriteArrayList<PathNode> list, PathNode find) {
        for (PathNode point : list) {
            if ((PathScanner.getPos25(point).x) != (PathScanner.getPos20(find).x) || (PathScanner.getPos36(point).y) != (PathScanner.getPos28(find).y) || (PathScanner.getPos24(point).z) != (PathScanner.getPos26(find).z)) continue;
            return true;
        }
        return false;
    }

    private static Vector3i getPos36(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos37(PathNode instance) {
        return instance.pos;
    }

    private static int zGqWrnddmd(PathNode instance) {
        return instance.dist;
    }

    private static Vector3i getPos38(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos39(PathNode instance) {
        return instance.pos;
    }

    private static int getDist7(PathNode instance) {
        return instance.dist;
    }

    private static int getDist8(PathNode instance) {
        return instance.dist;
    }

}

