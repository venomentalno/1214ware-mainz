package neo.deobf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BotTickExecutor {
    public static final ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void create() {
        threadPool.submit(() -> {
            while (true) {
                for (PBot bot : PBot.getOnline()) {
                    bot.tick();
                }
                ThreadUtils.sleep(50L);
            }
        });
    }
}
