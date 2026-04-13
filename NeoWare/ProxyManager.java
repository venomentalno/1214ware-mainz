/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.NumberSetting
 *  neo.deobf.BotSettingsModule
 *  neo.deobf.NotificationType
 *  neo.deobf.NotificationsModule
 *  neo.deobf.ChatUtils
 *  neo.deobf.BackendApi
 *  neo.deobf.ProxyType
 *  neo.deobf.ProxyInfo
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.TextFormatting
 *  org.jsoup.Jsoup
 *  org.jsoup.nodes.Document
 */
package neo.deobf;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import neo.deobf.NumberSetting;
import neo.deobf.BotSettingsModule;
import neo.deobf.NotificationType;
import neo.deobf.NotificationsModule;
import neo.deobf.ChatUtils;
import neo.deobf.BackendApi;
import neo.deobf.ProxyType;
import neo.deobf.ProxyInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextFormatting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ProxyManager {
    public int proxyIndex;
    public int fileIndex;
    public final ArrayList<ProxyInfo> proxyList = new ArrayList();
private static ArrayList getProxyList(ProxyManager instance) {
        return instance.proxyList;
    }

    private static int getProxyIndex(ProxyManager instance) {
        return instance.proxyIndex;
    }

    public ProxyManager() {
        this.loadProxy("http://37.27.169.207:20465/proxy.txt?session=" + BackendApi.userID(), "socks5");
    }

    public ProxyInfo getProxy() {
        if ((this.proxyList).size() == 0) {
            return null;
        }
        if ((this.fileIndex) >= (this.proxyList).size()) {
            this.fileIndex = 0;
            this.proxyIndex = 0;
        }
        ProxyInfo proxyInfo = (ProxyInfo)(this.proxyList).get((this.fileIndex));
        ProxyManager dx = this;
        dx.proxyIndex = ProxyManager.getProxyIndex(dx) + (1);
        if ((float)(this.proxyIndex) >= (ProxyManager.getBotsPerProxy().value)) {
            ProxyManager dx2 = this;
            dx2.fileIndex = ProxyManager.getFileIndex2(dx2) + (1);
            this.proxyIndex = 0;
        }
        return proxyInfo;
    }

    public void loadProxy(String path, String type) {
        if (ProxyType.getType((String)type) == null) {
            ChatUtils.formatMsg((String)"Указаный тип прокси не существует!");
            return;
        }
        (this.proxyList).clear();
        if (path.startsWith("https://") || path.startsWith("http://")) {
            try {
                Document proxyList = Jsoup.connect((String)path).ignoreHttpErrors(true).get();
                String text = proxyList.text();
                String[] stringArray = text.split(" ");
                int n = stringArray.length;
                for (int i = 0; i < n; ++i) {
                    String proxyLine = stringArray[i];
                    this.readProxy(proxyLine, type);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
                ChatUtils.formatMsg((String)"Произошла ошибка при загрузки ссылки, проверьте правильность ввода!");
            }
        } else {
            try {
                for (String proxyLine : Files.readAllLines(new File((Minecraft.getMinecraft().gameDir), "/NeoWare/proxy/" + path).toPath())) {
                    this.readProxy(proxyLine, type);
                }
            }
            catch (Exception exception) {
                if (exception instanceof NoSuchFileException) {
                    ChatUtils.formatMsg((String)("Файл с названием &d&l" + path + " &f&lне найден!"));
                }
                exception.printStackTrace();
                return;
            }
        }
        this.sendDebugInfo();
    }

    private static NumberSetting getBotsPerProxy() {
        return BotSettingsModule.botsPerProxy;
    }

    private void readProxy(String proxyLine, String type) {
        try {
            ProxyInfo proxyInfo = ProxyInfo.empty();
            proxyInfo.setType(ProxyType.getType((String)type));
            if (proxyLine.contains("://")) {
                proxyInfo.setType(ProxyType.getType((String)proxyLine.split("://")[0]));
                proxyLine = proxyLine.split("://")[1];
            }
            if (proxyLine.contains(":") && proxyLine.contains("@")) {
                proxyInfo.setUsername(proxyLine.split("@")[0].split(":")[0]);
                proxyInfo.setPassword(proxyLine.split("@")[0].split(":")[1]);
                proxyLine = proxyLine.split("@")[1];
            }
            proxyInfo.setProxy(proxyLine);
            (this.proxyList).add(proxyInfo);
        }
        catch (Exception exception) {
            ChatUtils.formatMsg((String)("Ошибка при чтении строки: " + proxyLine));
            exception.printStackTrace();
        }
    }

    public void removeProxy(ProxyInfo proxyInfo) {
        (this.proxyList).remove(proxyInfo);
    }

    public void sendDebugInfo() {
        NotificationsModule.notify((String)"Bots Debug", (String)((TextFormatting.GREEN) + "Загружено " + (this.proxyList).size() + " прокси"), (NotificationType)(NotificationType.SUCCESS), (int)(4));
        ChatUtils.formatMsg((String)("Загружено &d&l" + (this.proxyList).size() + " &f&lпрокси"));
        if ((this.proxyList).size() > 0) {
            ChatUtils.formatMsg((String)("[SOCKS4]: " + this.callGetType("socks4") + " прокси"));
            ChatUtils.formatMsg((String)("[SOCKS5]: " + this.callGetType("socks5") + " прокси"));
            ChatUtils.formatMsg((String)("[HTTP]: " + this.callGetType("http") + " прокси"));
        }
    }

    private static int getFileIndex2(ProxyManager instance) {
        return instance.fileIndex;
    }

    private int callGetType(String type) {
        if (ProxyType.getType((String)type) == null) {
            return 0;
        }
        return (int)(this.proxyList).stream().filter(proxyUtility -> proxyUtility.getType().name().equalsIgnoreCase(type)).count();
    }

    public ArrayList<ProxyInfo> getProxyList() {
        return (this.proxyList);
    }
}

