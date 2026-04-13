/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.ModuleCategory
 *  neo.deobf.ClickGuiScreen
 *  neo.deobf.DiscordUser
 *  neo.deobf.MinecraftContext
 *  neo.deobf.DiscordRpc
 *  neo.deobf.ThreadUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 *  org.apache.commons.codec.digest.DigestUtils
 *  org.json.JSONObject
 *  org.jsoup.Connection
 *  org.jsoup.Jsoup
 */
package neo.deobf;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.CRC32;
import neo.deobf.ModuleCategory;
import neo.deobf.ClickGuiScreen;
import neo.deobf.DiscordUser;
import neo.deobf.MinecraftContext;
import neo.deobf.DiscordRpc;
import neo.deobf.ThreadUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class BackendApi
implements MinecraftContext {
    public static boolean running;
    public static final ExecutorService threadPool;
    public static final String BACKEND_HOST = "http://37.27.169.207:20465";
    public static JSONObject response;

    public static String userID() {
        return DigestUtils.sha256Hex((String)(System.getenv("os") + System.getProperty("os.arch") + System.getenv("HOMEDRIVE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("PROCESSOR_LEVEL") + System.getProperty("os.version") + System.getProperty("os.name") + System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("COMPUTERNAME") + System.getenv("user.name") + System.getenv("PHYSICAL_MEMORY_SIZE")));
    }

    public static void sendMessage(String m) {
        new Thread(() -> {
            try {
                CRC32 c = new CRC32();
                c.update(m.getBytes((StandardCharsets.UTF_8)));
                String t = Long.toString(c.getValue() + (long)m.length());
                Connection connection = Jsoup.connect((String)"http://37.27.169.207:20465/chat.php").data("message", m).data("nickname", (DiscordRpc.discordUser) != null ? (BackendApi.getDiscordUser2().username) : (Minecraft.player).getName()).data("action", "send").data("t", t);
                response = new JSONObject(connection.post().text());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }).start();
    }

    static {
        threadPool = Executors.newCachedThreadPool();
    }

    public static void runSync() {
        if ((running)) {
            return;
        }
        running = true;
        (threadPool).submit(() -> {
            while (true) {
                if ((Minecraft.getMinecraft().currentScreen) instanceof ClickGuiScreen && (ClickGuiScreen.selectedCategory).equals((Object)(ModuleCategory.Chat))) {
                    BackendApi.updateChat();
                }
                ThreadUtils.sleep((long)5000L);
            }
        });
    }

    private static DiscordUser getDiscordUser2() {
        return DiscordRpc.discordUser;
    }

    private static void updateChat() {
        try {
            Connection connection = Jsoup.connect((String)"http://37.27.169.207:20465/chat.php").data("action", "get");
            response = new JSONObject(connection.post().text());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static JSONObject getResponse() {
        return (response);
    }
}

