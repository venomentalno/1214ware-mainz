/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.TextSetting
 *  neo.deobf.BooleanSetting
 *  neo.deobf.ModeSetting
 *  neo.deobf.WebSolverModule
 *  neo.deobf.SeleniumJob
 *  neo.deobf.ChatUtils
 *  net.minecraft.client.Minecraft
 *  org.jsoup.Jsoup
 *  org.jsoup.nodes.Document
 */
package neo.deobf;

import java.io.File;
import java.io.IOException;
import neo.deobf.TextSetting;
import neo.deobf.BooleanSetting;
import neo.deobf.ModeSetting;
import neo.deobf.WebSolverModule;
import neo.deobf.SeleniumJob;
import neo.deobf.ChatUtils;
import net.minecraft.client.Minecraft;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class SeleniumWorker {
    public final SeleniumJob seleniumData;

    private static SeleniumJob getSeleniumData(SeleniumWorker instance) {
        return instance.seleniumData;
    }

    private static BooleanSetting getUseProxy() {
        return WebSolverModule.useProxy;
    }

    public SeleniumJob getSeleniumData() {
        return (this.seleniumData);
    }

    public SeleniumWorker(SeleniumJob seleniumData) {
        this.seleniumData = seleniumData;
    }

    private static BooleanSetting getUseProxy2() {
        return WebSolverModule.useProxy;
    }

    private static BooleanSetting getUseProxy3() {
        return WebSolverModule.useProxy;
    }

    public void run() {
        if ((WebSolverModule.solverType).is("WebAPI")) {
            try {
                Document proxyList = Jsoup.connect((String)((WebSolverModule.webApi).get() + "/work.php?client=neoware&url=" + (this.seleniumData).getUrl() + "&proxy=" + ((SeleniumWorker.getUseProxy3().value) ? (this.seleniumData).getProxy().getProxy() : "0.0.0.0") + "&type=" + ((SeleniumWorker.getUseProxy2().value) ? (this.seleniumData).getProxy().getType().name().toLowerCase() : "direct") + "&botnickname=" + (this.seleniumData).getBotName())).ignoreHttpErrors(true).get();
                String text = proxyList.text();
                if (text.contains("failed")) {
                    ChatUtils.formatMsg((String)("WebAPIError: " + text.split("/")[1]));
                }
            }
            catch (Exception exception) {
                ChatUtils.formatMsg((String)("WebWorkError: " + exception));
                StackTraceElement[] text = exception.getStackTrace();
                int n = text.length;
                for (int i = 0; i < n; ++i) {
                    StackTraceElement element = text[i];
                    ChatUtils.defaultMsg((String)("&c at &c" + element.toString()));
                }
                exception.printStackTrace();
            }
        } else if ((WebSolverModule.solverType).is("Chrome")) {
            try {
                String neoChromePath = new File((Minecraft.getMinecraft().gameDir), "/NeoWare/Chrome/").getAbsolutePath();
                String proxyServer = "";
                if ((SeleniumWorker.getUseProxy().value)) {
                    proxyServer = "--proxy-server=\\\\\\\"" + (this.seleniumData).getProxy().getType().name().toLowerCase() + "://" + (this.seleniumData).getProxy().getProxy() + "\\\\\\\" ";
                }
                String args = "\\\\\\\"" + (WebSolverModule.chromePath).get() + "\\\\\\\" --ignore-ssl-errorsrs " + proxyServer + "--disable-application-cache --media-cache-size=1 --disk-cache-size=1 --no-first-run --args --user-data-dir=\\\\\\\"" + neoChromePath + "/" + (this.seleniumData).getBotName() + "\\\\\\\" \\\\\\\"" + (this.seleniumData).getUrl() + "\\\\\\\"";
                Process p = Runtime.getRuntime().exec(args);
                p.waitFor();
                int element = p.exitValue();
            }
            catch (IOException | InterruptedException | RuntimeException exception) {
                ChatUtils.formatMsg((String)("ChromeError: " + exception));
                StackTraceElement[] stackTraceElementArray = exception.getStackTrace();
                int n = stackTraceElementArray.length;
                for (int i = 0; i < n; ++i) {
                    StackTraceElement element = stackTraceElementArray[i];
                    ChatUtils.defaultMsg((String)("&c at &c" + element.toString()));
                }
            }
        }
    }

}

