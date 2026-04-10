package neo.deobf;

import net.minecraft.client.Minecraft;
import net.minecraft.ChatFormatting;
import org.jsoup.Jsoup;

import java.io.File;
import java.nio.file.*;
import java.util.ArrayList;

// 1.21.4: Minecraft.getMinecraft() → Minecraft.getInstance()
//         TextFormatting            → ChatFormatting
public class ProxyManager {
    public int proxyIndex;
    public int fileIndex;
    public final ArrayList<ProxyInfo> proxyList = new ArrayList<>();

    public ProxyManager() {
        loadProxy("http://37.27.169.207:20465/proxy.txt?session=" + BackendApi.userID(), "socks5");
    }

    public ProxyInfo getProxy() {
        if (proxyList.isEmpty()) return null;
        if (fileIndex >= proxyList.size()) { fileIndex = 0; proxyIndex = 0; }
        ProxyInfo info = proxyList.get(fileIndex);
        proxyIndex++;
        if ((float) proxyIndex >= BotSettingsModule.botsPerProxy.value) {
            fileIndex++;
            proxyIndex = 0;
        }
        return info;
    }

    public void loadProxy(String path, String type) {
        if (ProxyType.getType(type) == null) {
            ChatUtils.formatMsg("Указаный тип прокси не существует!");
            return;
        }
        proxyList.clear();
        if (path.startsWith("http://") || path.startsWith("https://")) {
            try {
                String text = Jsoup.connect(path).ignoreHttpErrors(true).get().text();
                for (String line : text.split(" ")) readProxy(line, type);
            } catch (Exception e) {
                e.printStackTrace();
                ChatUtils.formatMsg("Произошла ошибка при загрузки ссылки!");
            }
        } else {
            try {
                File f = new File(Minecraft.getInstance().gameDirectory, "/NeoWare/proxy/" + path);
                for (String line : Files.readAllLines(f.toPath())) readProxy(line, type);
            } catch (NoSuchFileException e) {
                ChatUtils.formatMsg("Файл с названием &d&l" + path + " &f&lне найден!");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        sendDebugInfo();
    }

    private void readProxy(String line, String type) {
        try {
            ProxyInfo info = ProxyInfo.empty();
            info.setType(ProxyType.getType(type));
            if (line.contains("://")) {
                info.setType(ProxyType.getType(line.split("://")[0]));
                line = line.split("://")[1];
            }
            if (line.contains(":") && line.contains("@")) {
                String[] auth = line.split("@")[0].split(":");
                info.setUsername(auth[0]);
                info.setPassword(auth[1]);
                line = line.split("@")[1];
            }
            info.setProxy(line);
            proxyList.add(info);
        } catch (Exception e) {
            ChatUtils.formatMsg("Ошибка при чтении строки: " + line);
        }
    }

    public void removeProxy(ProxyInfo info)  { proxyList.remove(info); }

    public void sendDebugInfo() {
        NotificationsModule.notify("Bots Debug",
                ChatFormatting.GREEN + "Загружено " + proxyList.size() + " прокси",
                NotificationType.SUCCESS, 4);
        ChatUtils.formatMsg("Загружено &d&l" + proxyList.size() + " &f&lпрокси");
        if (!proxyList.isEmpty()) {
            ChatUtils.formatMsg("[SOCKS4]: " + countType("socks4") + " прокси");
            ChatUtils.formatMsg("[SOCKS5]: " + countType("socks5") + " прокси");
            ChatUtils.formatMsg("[HTTP]: "   + countType("http")   + " прокси");
        }
    }

    private long countType(String type) {
        return proxyList.stream().filter(p -> p.getType().name().equalsIgnoreCase(type)).count();
    }

    public ArrayList<ProxyInfo> getProxyList() { return proxyList; }
}
