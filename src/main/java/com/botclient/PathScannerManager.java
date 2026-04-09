/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.joml.Vector3i
 *  neo.deobf.PBot
 *  neo.deobf.PathSearchTask
 *  neo.deobf.ThreadUtils
 */
package com.botclient;

import java.util.concurrent.CopyOnWriteArrayList;
import org.joml.Vector3i;
import com.botclient.PBot;
import com.botclient.PathSearchTask;
import com.botclient.ThreadUtils;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PathScannerManager {
    public static boolean isRunning;
    public static final CopyOnWriteArrayList<PathSearchTask> dataList;

    public static void clearPathData() {
        (dataList).clear();
    }

    public static void startThread() {
        isRunning = true;
        new Thread(() -> {
            while ((isRunning)) {
                for (PathSearchTask data : (dataList)) {
                    if (!(isRunning)) {
                        return;
                    }
                    if ((data.scanned)) continue;
                    try {
                        data.scan();
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                ThreadUtils.sleep((long)1000L);
            }
        }).start();
    }

    private static void addPathData(PathSearchTask data) {
        (dataList).add(data);
    }

    private PathScannerManager() {
        PathScannerManager.startThread();
    }

    public static PathSearchTask getPathData(Vector3i pos1, Vector3i pos2) {
        for (PathSearchTask data : (dataList)) {
            if (data == null || (data.startPos) == null || (data.finalPos) == null || pos1 == null || pos2 == null || !(data.startPos).equals(pos1) || !(data.finalPos).equals(pos2)) continue;
            return data;
        }
        return null;
    }

    public static void scanPath(PBot bot, Vector3i startPos, Vector3i finalPos) {
        PathSearchTask data;
        if (!(isRunning)) {
            PathScannerManager.startThread();
        }
        if ((data = PathScannerManager.getPathData(startPos, finalPos)) == null) {
            PathScannerManager.addPathData(new PathSearchTask(startPos, finalPos, bot));
        }
    }

    static {
        dataList = new CopyOnWriteArrayList();
        isRunning = 0;
    }

}

