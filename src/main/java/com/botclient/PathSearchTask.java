/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Vector3i
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.PathScanner
 *  neo.deobf.AbstractPathScanner
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.world.World
 */
package com.botclient;

import javax.vecmath.Vector3i;
import com.botclient.PBot;
import com.botclient.PBotPlayer;
import com.botclient.PathScanner;
import com.botclient.AbstractPathScanner;
import net.minecraft.entity.player.PlayerEntity;
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
            return (this.scanner).onUpdate((PlayerEntity)player);
        }
        return false;
    }

    public PathSearchTask(Vector3i startPos, Vector3i finalPos, PBot pbot) {
        this.startPos = startPos;
        this.finalPos = finalPos;
        this.scanner = new PathScanner(startPos, finalPos, (World)pbot.world);
        this.scanned = 0;
    }

}

