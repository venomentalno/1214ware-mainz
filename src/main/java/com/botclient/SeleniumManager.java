/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.NumberSetting
 *  neo.deobf.WebSolverModule
 *  neo.deobf.SeleniumJob
 *  neo.deobf.SeleniumWorker
 *  neo.deobf.RandomUtils
 *  neo.deobf.ThreadUtils
 *  net.minecraft.client.Minecraft
 *  org.apache.commons.io.FileUtils
 */
package com.botclient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.botclient.NumberSetting;
import com.botclient.WebSolverModule;
import com.botclient.SeleniumJob;
import com.botclient.SeleniumWorker;
import com.botclient.RandomUtils;
import com.botclient.ThreadUtils;
import net.minecraft.client.MinecraftClient;
import org.apache.commons.io.FileUtils;

public class SeleniumManager {
    public final ArrayList<SeleniumJob> queue = new ArrayList();

    public void clearCache() {
        try {
            File path = new File((MinecraftClient.getInstance().gameDir), "/NeoWare/Chrome/");
            FileUtils.deleteDirectory((File)path);
            if (!path.exists()) {
                path.mkdirs();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addQueue(SeleniumJob seleniumData) {
        (this.queue).add(seleniumData);
    }

    public boolean isHaveWork() {
        return ((this.queue).size() > 0 ? 1 : 0) != 0;
    }

private static NumberSetting ujeawNtrrS() {
        return WebSolverModule.openDelay;
    }

    private void newThread(Runnable task, String name) {
        new Thread(task, name).start();
    }

    public SeleniumJob getWork() {
        if (this.isHaveWork()) {
            return (SeleniumJob)(this.queue).get(0);
        }
        return null;
    }

    public void init() {
        this.newThread(() -> {
            while (true) {
                try {
                    while (true) {
                        ThreadUtils.sleep((long)((long)(SeleniumManager.ujeawNtrrS().value)));
                        if (!this.isHaveWork()) continue;
                        SeleniumJob data = new SeleniumJob(this.getWork().getUrl(), this.getWork().getProxy(), this.getWork().getBotName());
                        (this.queue).remove(0);
                        this.newThread(() -> new SeleniumWorker(data).run(), "Selenium Thread #" + data.getBotName() + RandomUtils.randomNumber((int)(6)));
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                break;
            }
        }, "Selenium Queue Thread");
        this.clearCache();
    }

}

