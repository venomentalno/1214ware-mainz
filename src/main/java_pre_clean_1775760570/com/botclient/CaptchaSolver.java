/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.TextSetting
 *  neo.deobf.BooleanSetting
 *  neo.deobf.ModeSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.PBot
 *  neo.deobf.CaptchaManagerModule
 *  neo.deobf.ChatUtils
 *  neo.deobf.BackendApi
 *  neo.deobf.CaptchaPacket
 *  neo.deobf.CaptchaSolverApi
 *  neo.deobf.ImageUtils
 *  neo.deobf.RandomUtils
 *  neo.deobf.ThreadUtils
 *  org.json.JSONArray
 *  org.json.JSONObject
 *  org.jsoup.Connection
 *  org.jsoup.Jsoup
 *  org.jsoup.nodes.Document
 */
package com.botclient;

import java.awt.image.BufferedImage;
import java.io.IOException;
import com.botclient.TextSetting;
import com.botclient.BooleanSetting;
import com.botclient.ModeSetting;
import com.botclient.NumberSetting;
import com.botclient.PBot;
import com.botclient.CaptchaManagerModule;
import com.botclient.ChatUtils;
import com.botclient.BackendApi;
import com.botclient.CaptchaPacket;
import com.botclient.CaptchaSolverApi;
import com.botclient.ImageUtils;
import com.botclient.RandomUtils;
import com.botclient.ThreadUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class CaptchaSolver
implements CaptchaSolverApi {

    public String sendNeoAPI(CaptchaPacket botCaptcha) {
        try {
            Connection connection = Jsoup.connect((String)"http://62.60.149.15:38550/in.php").data("body", ImageUtils.imageToBase64((BufferedImage)botCaptcha.getCaptcha())).data("server", botCaptcha.getPBot().getHost()).data("type", "1").data("session", BackendApi.userID());
            Document post = connection.post();
            for (int attempt = 0; attempt < (6); ++attempt) {
                try {
                    Document get = Jsoup.connect((String)("http://62.60.149.15:38550/res.php?id=" + post.text().split("\\\\\\\\|")[1])).get();
                    String[] response = get.text().split("\\\\\\\\|");
                    if (response[0].equals("OK")) {
                        return this.checkRequire(response[1]);
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                ThreadUtils.sleep((long)2000L);
            }
        }
        catch (IOException exception) {
            ChatUtils.formatMsg((String)"&c&lСервера NeoWare недоступны. Решение капчи невозможно!");
        }
        return "null";
    }

    private static NumberSetting getClickDelay() {
        return CaptchaManagerModule.clickDelay;
    }

    public String sendAPI(CaptchaPacket botCaptcha) throws IOException {
        String site = (CaptchaManagerModule.solver).is("RuCaptcha") ? "http://rucaptcha.com" : "http://api.cap.guru";
        Connection connection = Jsoup.connect((String)(site + "/in.php")).data("key", (CaptchaSolver.getApikey4().text)).data("method", "base64").data("body", ImageUtils.imageToBase64((BufferedImage)ImageUtils.resizeImage((BufferedImage)botCaptcha.getCaptcha(), (int)(550))));
        if (!(CaptchaManagerModule.solver).is("RuCaptcha")) {
            connection.data("vernet", (CaptchaSolver.getVernet2().text));
        }
        Document post = connection.post();
        for (int attempt = 0; attempt < (6); ++attempt) {
            try {
                Document get = Jsoup.connect((String)(site + "/res.php?key=" + (CaptchaSolver.getApikey().text) + "&action=get&id=" + post.text().split("\\\\\\\\|")[1])).get();
                String[] response = get.text().split("\\\\\\\\|");
                if (response[0].equals("OK")) {
                    return this.checkRequire(response[1]);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            ThreadUtils.sleep((long)2000L);
        }
        return "null";
    }

    private static TextSetting getVernet() {
        return CaptchaManagerModule.vernet;
    }

    private static BooleanSetting getNullcordRandom() {
        return CaptchaManagerModule.nullcordRandom;
    }

    private static TextSetting getApikey() {
        return CaptchaManagerModule.apikey;
    }

    public void solve(CaptchaPacket botCaptcha) {
        try {
            String solverName = (CaptchaManagerModule.solver).get();
            switch (solverName) {
                case "RuCaptcha":
                case "CapGuru":
                    botCaptcha.sendAnswer(this.sendAPI(botCaptcha));
                    break;
                case "SimpleOCR":
                    botCaptcha.sendAnswer(this.sendOCR(botCaptcha));
                    break;
                case "CustomAPI":
                    botCaptcha.sendAnswer(this.sendCustomAPI(botCaptcha));
                    break;
                case "NeoAPI":
                    botCaptcha.sendAnswer(this.sendNeoAPI(botCaptcha));
                    break;
                case "NullCordClicks":
                    this.solveClicks(botCaptcha);
                    break;
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
            botCaptcha.sendAnswer("error");
        }
    }

    private static TextSetting getApikey2() {
        return CaptchaManagerModule.apikey;
    }

    public String sendCustomAPI(CaptchaPacket botCaptcha) throws IOException {
        String site = (CaptchaSolver.getCustomSite().text);
        Connection connection = Jsoup.connect((String)(site + "/in.php")).data("key", (CaptchaSolver.getApikey3().text)).data("method", "base64").data("body", ImageUtils.imageToBase64((BufferedImage)botCaptcha.getCaptcha())).data("vernet", (CaptchaSolver.getVernet().text));
        Document post = connection.post();
        for (int attempt = 0; attempt < (6); ++attempt) {
            try {
                Document get = Jsoup.connect((String)(site + "/res.php?key=" + (CaptchaSolver.getApikey2().text) + "&action=get&id=" + post.text().split("\\\\\\\\|")[1])).get();
                String[] response = get.text().split("\\\\\\\\|");
                if (response[0].equals("OK")) {
                    return this.checkRequire(response[1]);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            ThreadUtils.sleep((long)2000L);
        }
        return "null";
    }

    private String checkRequire(String text) {
        String requireMode = (CaptchaManagerModule.require).get();
        switch (requireMode) {
            case "0-9":
                return text.replaceAll("[^0-9]", "");
            case "A-Z":
                return text.replaceAll("[^A-Za-z]", "");
            default:
                return text.replaceAll("[^A-Za-z0-9]", "");
        }
    }

    public String sendOCR(CaptchaPacket botCaptcha) throws IOException {
        Connection connection = Jsoup.connect((String)"https://api8.ocr.space/parse/image").ignoreContentType(true).header("referrer", "https://ocr.space/").data("apikey", "K85298838188957").data("base64Image", ImageUtils.convertToBase64((BufferedImage)botCaptcha.getCaptcha())).data("language", "eng").data("isOverlayRequired", "true").data("FileType", ".Auto").data("IsCreateSearchablePDF", "false").data("isSearchablePdfHideTextLayer", "false").data("detectOrientation", "false").data("isTable", "false").data("scale", "true").data("OCREngine", "5").data("detectCheckbox", "false").data("checkboxTemplate", "0");
        Document post = connection.post();
        return this.checkRequire(new JSONObject(post.text()).getJSONArray("ParsedResults").getJSONObject(0).getString("ParsedText"));
    }

    private static TextSetting getCustomSite() {
        return CaptchaManagerModule.customSite;
    }

    private static TextSetting getVernet2() {
        return CaptchaManagerModule.vernet;
    }

    private static TextSetting getApikey3() {
        return CaptchaManagerModule.apikey;
    }

    private static TextSetting getApikey4() {
        return CaptchaManagerModule.apikey;
    }

    private void solveClicks(CaptchaPacket botCaptcha) {
        PBot bot = botCaptcha.getPBot();
        if (bot.getStringParameter("lastmessage") == null) {
            botCaptcha.getPBot().setParameter("captchadetected", (Object)(false));
            return;
        }
        String message = bot.getStringParameter("lastmessage").toLowerCase();
        BufferedImage captcha = botCaptcha.getCaptcha();
        try {
            Connection connection = Jsoup.connect((String)"http://62.60.149.15:38550/in.php").data("body", ImageUtils.imageToBase64((BufferedImage)captcha)).data("server", botCaptcha.getPBot().getHost()).data("textinstruction", message).data("type", "2").data("session", BackendApi.userID());
            Document post = connection.post();
            for (int attempt = 0; attempt < (6); ++attempt) {
                block9: {
                    try {
                        Document get = Jsoup.connect((String)("http://62.60.149.15:38550/res.php?id=" + post.text().split("\\\\\\\\|")[1])).get();
                        String[] response = get.text().split("\\\\\\\\|");
                        if (!response[0].equals("OK")) break block9;
                        JSONObject json = new JSONObject(response[1]);
                        if (json.getJSONArray("rotates") != null) {
                            JSONArray messages = json.getJSONArray("rotates");
                            for (int index = 0; index < messages.length(); ++index) {
                                JSONObject frame = messages.getJSONObject(index);
                                int x = frame.getInt("x");
                                int y = frame.getInt("y");
                                botCaptcha.rotateFrame(x, y);
                                ThreadUtils.sleep((long)((long)((CaptchaSolver.getClickDelay().value) + (float)RandomUtils.intRandom((int)(-50), (int)(50)))));
                            }
                        }
                        if ((CaptchaSolver.getNullcordRandom().value)) {
                            ThreadUtils.sleep((long)RandomUtils.intRandom((int)(700), (int)(1400)));
                            botCaptcha.sendAnswer(RandomUtils.randomString((int)(4)));
                        }
                        break;
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                ThreadUtils.sleep((long)2000L);
            }
        }
        catch (IOException exception) {
            ChatUtils.formatMsg((String)"&c&lСервера NeoWare недоступны. Решение капчи невозможно!");
        }
    }
}

