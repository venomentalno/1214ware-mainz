/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.PBot
 *  neo.deobf.ThreadUtils
 */
package neo.deobf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import neo.deobf.PBot;
import neo.deobf.ThreadUtils;

public class BotTickExecutor {
    public static final ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void create() {
        (threadPool).submit(() -> {
            while (true) {
                for (PBot bot : PBot.getOnline()) {
                    bot.tick();
                }
                ThreadUtils.sleep((long)50L);
            }
        });
    }

}

