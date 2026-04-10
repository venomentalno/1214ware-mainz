package neo.deobf;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractPathScanner {
    public boolean done;
    public CopyOnWriteArrayList<PathNode> unchecked = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<PathNode> checked   = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<PathNode> path;

    public abstract void onFinished();
    public abstract List<PathNode> getPathList();
    public abstract boolean onUpdate(Player player);
    public abstract boolean isRunning();
    public abstract void stop();
    public abstract void scan();

    public boolean contains(CopyOnWriteArrayList<PathNode> list, PathNode find) {
        for (PathNode point : list) {
            if (point.pos.getX() != find.pos.getX()
                    || point.pos.getY() != find.pos.getY()
                    || point.pos.getZ() != find.pos.getZ()) continue;
            return true;
        }
        return false;
    }
}
