/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Vector2f
 *  javax.vecmath.Vector3i
 *  neo.deobf.BooleanSetting
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.BotKeyState
 *  neo.deobf.PBotMinecraft
 *  neo.deobf.BotDebugModule
 *  neo.deobf.ChatUtils
 *  neo.deobf.AbstractPathScanner
 *  neo.deobf.PathNode
 *  neo.deobf.PathScannerManager
 *  neo.deobf.PathSearchTask
 *  neo.deobf.BlockUtils
 *  net.minecraft.entity.Entity
 */
package neo.deobf;

import java.util.ArrayList;
import java.util.List;
import javax.vecmath.Vector2f;
import javax.vecmath.Vector3i;
import neo.deobf.BooleanSetting;
import neo.deobf.PBot;
import neo.deobf.PBotPlayer;
import neo.deobf.BotKeyState;
import neo.deobf.PBotMinecraft;
import neo.deobf.BotDebugModule;
import neo.deobf.ChatUtils;
import neo.deobf.AbstractPathScanner;
import neo.deobf.PathNode;
import neo.deobf.PathScannerManager;
import neo.deobf.PathSearchTask;
import neo.deobf.BlockUtils;
import net.minecraft.entity.Entity;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PathFinder {
    public int index;
    public boolean pause;
    public Vector3i finalPos;
    public final PBot pbot;
    public List<PathNode> path;
    public Vector3i startPos;
    public boolean isRunning;

    private static PBotPlayer getPlayer(PBot instance) {
        return instance.player;
    }

    public void pause() {
        this.pause = true;
    }

    private static PBotPlayer getPlayer2(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot(PathFinder instance) {
        return instance.pbot;
    }

    private static PBotMinecraft getMc(PBot instance) {
        return instance.mc;
    }

    private static Vector3i getPos(PathNode instance) {
        return instance.pos;
    }

    private static PBotPlayer getPlayer3(PBot instance) {
        return instance.player;
    }

    private static BotKeyState getGameSettings(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    public void pathFindStop() {
        if ((this.isRunning) && (PathFinder.getPbot17(this).mc) != null) {
            PathFinder.getGameSettings(PathFinder.getMc(PathFinder.getPbot9(this))).keyBindForward = false;
            PathFinder.getGameSettings2(PathFinder.getMc2(PathFinder.getPbot10(this))).keyBindJump = false;
        }
        this.isRunning = false;
        this.pause();
        this.index = 0;
    }

    private static Vector3i getPos2(PathNode instance) {
        return instance.pos;
    }

    private static PBot getPbot2(PathFinder instance) {
        return instance.pbot;
    }

    private static double getPosY(PBotPlayer instance) {
        return instance.posY;
    }

    private static Vector3i getPos3(PathNode instance) {
        return instance.pos;
    }

    private static PBot getPbot3(PathFinder instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer4(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot4(PathFinder instance) {
        return instance.pbot;
    }

    private static PBot getPbot6(PathFinder instance) {
        return instance.pbot;
    }

    private static PBot getPbot7(PathFinder instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer5(PBot instance) {
        return instance.player;
    }

    public boolean isRunning() {
        return (this.isRunning);
    }

    private static PBotMinecraft getMc2(PBot instance) {
        return instance.mc;
    }

    private static PBot getPbot8(PathFinder instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer6(PBot instance) {
        return instance.player;
    }

    private static Vector3i getPos4(PathNode instance) {
        return instance.pos;
    }

    private static PBot getPbot9(PathFinder instance) {
        return instance.pbot;
    }

    private static Vector3i getPos5(PathNode instance) {
        return instance.pos;
    }

    private static Vector3i getPos6(PathNode instance) {
        return instance.pos;
    }

    private static PBot getPbot10(PathFinder instance) {
        return instance.pbot;
    }

    private static PBotPlayer getPlayer7(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot11(PathFinder instance) {
        return instance.pbot;
    }

    private static BooleanSetting getBaritoneDebug() {
        return BotDebugModule.baritoneDebug;
    }

    public PathFinder(PBot pbot) {
        this.pbot = pbot;
        this.path = new ArrayList<PathNode>();
        this.index = 0;
        this.isRunning = 0;
        this.pause = 1;
        this.startPos = null;
        this.finalPos = null;
    }

    private static PBotMinecraft getMc3(PBot instance) {
        return instance.mc;
    }

    private static int getIndex(PathFinder instance) {
        return instance.index;
    }

    private static PBot getPbot12(PathFinder instance) {
        return instance.pbot;
    }

    private static PBot getPbot13(PathFinder instance) {
        return instance.pbot;
    }

    private static BotKeyState getGameSettings2(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static Vector3i getPos7(PathNode instance) {
        return instance.pos;
    }

    private static PBot getPbot14(PathFinder instance) {
        return instance.pbot;
    }

    private static double getPosZ(PBotPlayer instance) {
        return instance.posZ;
    }

    private static BotKeyState getGameSettings3(PBotMinecraft instance) {
        return instance.gameSettings;
    }

    private static Vector3i getPos8(PathNode instance) {
        return instance.pos;
    }

    private static PBotPlayer getPlayer9(PBot instance) {
        return instance.player;
    }

    public boolean shouldWalk() {
        if (!(this.isRunning)) {
            return false;
        }
        if ((this.pause)) {
            return false;
        }
        return true;
    }

    private static Vector3i getPos9(PathNode instance) {
        return instance.pos;
    }

    private static PBot getPbot16(PathFinder instance) {
        return instance.pbot;
    }

    public void pathFindStart(Vector3i pos) {
        this.pathFindStop();
        this.startPos = new Vector3i(PathFinder.getPosX4(PathFinder.getPlayer(PathFinder.getPbot8(this))), PathFinder.getPosY(PathFinder.getPlayer12(PathFinder.getPbot4(this))), PathFinder.getPosZ(PathFinder.getPlayer5(PathFinder.getPbot11(this))));
        this.finalPos = pos;
        PathScannerManager.scanPath((PBot)(this.pbot), (Vector3i)(this.startPos), (Vector3i)(this.finalPos));
    }

    public void unPause() {
        this.pause = false;
    }

    public void pathFindWalk() {
        PathSearchTask data = PathScannerManager.getPathData((Vector3i)(this.startPos), (Vector3i)(this.finalPos));
        if (data == null) {
            this.pathFindStop();
            return;
        }
        if (data.onUpdate((PathFinder.getPbot12(this).player))) {
            this.index = 0;
        }
        this.copyList((data.scanner).getPathList());
        if ((this.path) == null) {
            return;
        }
        if ((this.path).isEmpty()) {
            this.isRunning = false;
            if ((data.scanned)) {
                this.isRunning = true;
                this.index = 0;
            }
        } else {
            this.isRunning = true;
        }
        if (!this.shouldWalk()) {
            return;
        }
        if ((this.path).isEmpty()) {
            return;
        }
        if ((this.index) >= (this.path).size()) {
            return;
        }
        try {
            PathNode point = (PathNode)(this.path).get((this.index));
            if (point != null) {
                int inside;
                double offset = 0.5;
                Vector2f angles = BlockUtils.getBlockAngles((double)((double)(PathFinder.getPos7(point).x) + offset), (double)(PathFinder.getPos9(point).y), (double)((double)(PathFinder.getPos8(point).z) + offset), (double)(PathFinder.getPlayer3(PathFinder.getPbot13(this)).posX), (double)(PathFinder.getPlayer2(PathFinder.getPbot2(this)).posY), (double)(PathFinder.getPlayer7(PathFinder.getPbot3(this)).posZ));
                float nY = BlockUtils.normalizeYaw((float)(angles.y));
                float nP = BlockUtils.normalizePitch((float)(angles.x));
                if (!Float.isNaN(nY) && !Float.isNaN(nP)) {
                    PathFinder.getPlayer4(PathFinder.getPbot6(this)).rotationYaw = nY;
                    PathFinder.getPlayer9(PathFinder.getPbot18(this)).rotationPitch = nP;
                }
                PathFinder.getGameSettings3(PathFinder.getMc3(PathFinder.getPbot7(this))).keyBindForward = true;
                PBotPlayer ent = (PathFinder.getPbot(this).player);
                int n = inside = (double)(PathFinder.getPos5(point).x) <= ((Entity)ent.posX) && (double)((PathFinder.getPos6(point).x) + (1)) >= ((Entity)ent.posX) && (double)((PathFinder.getPos(point).y) - (1)) <= ((Entity)ent.posY) && (double)((PathFinder.getPos3(point).y) + (1)) >= ((Entity)ent.posY) && (double)(PathFinder.getPos4(point).z) <= ((Entity)ent.posZ) && (double)((PathFinder.getPos2(point).z) + (1)) >= ((Entity)ent.posZ) ? 1 : 0;
                if (inside != 0) {
                    if ((this.index) < (this.path).size() - (1)) {
                        if ((PathFinder.getPlayer6(PathFinder.getPbot14(this)).onGround) || (PathFinder.getPbot16(this).player).isInWater()) {
                            PathFinder dh = this;
                            dh.index = PathFinder.getIndex(dh) + (1);
                        }
                    } else {
                        this.pathFindStop();
                        if ((PathFinder.getBaritoneDebug().value)) {
                            ChatUtils.defaultMsg((String)("&5[&dBot-Baritone&5] &7Bot " + (this.pbot).getNickname() + " | finished"));
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            this.pathFindStop();
        }
    }

    private static double getPosX4(PBotPlayer instance) {
        return instance.posX;
    }

    private static PBot getPbot17(PathFinder instance) {
        return instance.pbot;
    }

    private void copyList(List<PathNode> listToCopy) {
        (this.path).clear();
        if (listToCopy.isEmpty()) {
            return;
        }
        this.path = new ArrayList<PathNode>(listToCopy);
    }

    private static PBotPlayer getPlayer12(PBot instance) {
        return instance.player;
    }

    private static PBot getPbot18(PathFinder instance) {
        return instance.pbot;
    }

}

