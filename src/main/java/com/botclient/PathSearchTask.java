/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Vector3i
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.PathScanner
 *  neo.deobf.AbstractPathScanner
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.world.World
 */
package neo.deobf;

import javax.vecmath.Vector3i;
import neo.deobf.PBot;
import neo.deobf.PBotPlayer;
import neo.deobf.PathScanner;
import neo.deobf.AbstractPathScanner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PathSearchTask {
    public AbstractPathScanner scanner;
    public Vector3i startPos;
    public Vector3i finalPos;
    public boolean scanned;

    public void scan() {
        (this.scanner).scan();
        this.scanned = true;
    }

    public boolean onUpdate(PBotPlayer player) {
        if ((this.scanner) != null && player != null) {
            return (this.scanner).onUpdate((EntityPlayer)player);
        }
        return false;
    }

    public PathSearchTask(Vector3i startPos, Vector3i finalPos, PBot pbot) {
        this.startPos = startPos;
        this.finalPos = finalPos;
        this.scanner = new PathScanner(startPos, finalPos, (World)pbot.getWorld());
        this.scanned = 0;
    }

}

