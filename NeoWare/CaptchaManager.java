/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Render2DEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.Client
 *  neo.deobf.PBotManager
 *  neo.deobf.BooleanSetting
 *  neo.deobf.ModeSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.CommandChatListener
 *  neo.deobf.PBot
 *  neo.deobf.CaptchaManagerModule
 *  neo.deobf.NotificationType
 *  neo.deobf.NotificationsModule
 *  neo.deobf.ScriptManager
 *  neo.deobf.CaptchaPacket
 *  neo.deobf.CaptchaSolver
 *  neo.deobf.DrawUtils
 *  neo.deobf.EventBus
 *  neo.deobf.ChatMessageEvent
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.TextFormatting
 */
package neo.deobf;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import neo.deobf.Render2DEvent;
import neo.deobf.EventTarget;
import neo.deobf.Client;
import neo.deobf.PBotManager;
import neo.deobf.BooleanSetting;
import neo.deobf.ModeSetting;
import neo.deobf.NumberSetting;
import neo.deobf.CommandChatListener;
import neo.deobf.PBot;
import neo.deobf.CaptchaManagerModule;
import neo.deobf.NotificationType;
import neo.deobf.NotificationsModule;
import neo.deobf.ScriptManager;
import neo.deobf.CaptchaPacket;
import neo.deobf.CaptchaSolver;
import neo.deobf.DrawUtils;
import neo.deobf.EventBus;
import neo.deobf.ChatMessageEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextFormatting;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class CaptchaManager
extends CaptchaSolver {
    public final CopyOnWriteArrayList<CaptchaPacket> captchaList = new CopyOnWriteArrayList();
    public final HashMap<String, String> captchaHelper = new HashMap();

    private static NumberSetting getLocationY() {
        return CaptchaManagerModule.locationY;
    }

    public int getHelperSize() {
        return (this.captchaHelper).size();
    }

    private static NumberSetting getLocationY2() {
        return CaptchaManagerModule.locationY;
    }

    public CaptchaManager() {
        EventBus.register((Object)((Object)this));
        this.loadHelper();
    }

    private static NumberSetting getLocationX() {
        return CaptchaManagerModule.locationX;
    }

    @EventTarget
    public void onRender2D(Render2DEvent event) {
        CaptchaManager captchaManager = PBotManager.getInstance().getCaptchaManager();
        if (captchaManager.inQueue()) {
            BufferedImage captcha = captchaManager.getQueueCaptcha().getCaptcha();
            DrawUtils.renderImage((BufferedImage)captcha, (int)((int)(CaptchaManager.getLocationX2().value)), (int)((int)(CaptchaManager.getLocationY().value)), (int)(captcha.getWidth() / (2)), (int)(captcha.getHeight() / (2)));
        }
    }

    public CaptchaPacket getQueueCaptcha() {
        return (CaptchaPacket)(this.captchaList).get(0);
    }

    public void addCaptcha(CaptchaPacket botCaptcha) {
        botCaptcha.getPBot().setParameter("captchadetected", (Object)(true));
        String hash = botCaptcha.getHash();
        if ((CaptchaManager.getManualHelper().value) && (this.captchaHelper).containsKey(hash)) {
            String answer = (String)(this.captchaHelper).get(hash);
            botCaptcha.sendAnswer(answer);
            NotificationsModule.notify((String)"ManualHelper", (String)((TextFormatting.GREEN) + "Бот " + botCaptcha.getPBot().getNickname() + " Ответ " + answer), (NotificationType)(NotificationType.SUCCESS), (int)(4));
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = botCaptcha.getPBot();
        objectArray[1] = botCaptcha.getCaptcha();
        (Client.getInstance().pBotsScriptManager).invokeMethod("onCaptcha", objectArray);
        Object[] objectArray2 = new Object[2];
        objectArray2[0] = botCaptcha.getPBot();
        objectArray2[1] = botCaptcha;
        (Client.getInstance().pBotsScriptManager).invokeMethod("onBotCaptcha", objectArray2);
        if (!(CaptchaManagerModule.solver).is("ManualMap")) {
            new Thread(() -> this.solve(botCaptcha)).start();
            if (!(CaptchaManagerModule.solver).is("NullCordClicks")) {
                return;
            }
        }
        if (!(this.captchaList).contains(botCaptcha)) {
            (this.captchaList).add(botCaptcha);
        }
    }

    private static NumberSetting getLocationX2() {
        return CaptchaManagerModule.locationX;
    }

    private static BooleanSetting getManualHelper() {
        return CaptchaManagerModule.manualHelper;
    }

    public void onMouseClick(int mouseX, int mouseY) {
        if (this.inQueue()) {
            int frameMouseX = (int)((float)mouseX - (CaptchaManager.getLocationX().value));
            int frameMouseY = (int)((float)mouseY - (CaptchaManager.getLocationY2().value));
            CaptchaPacket captcha = this.getQueueCaptcha();
            int captchaWidth = captcha.getCaptcha().getWidth() / (2);
            int captchaHeight = captcha.getCaptcha().getHeight() / (2);
            if (frameMouseX >= 0 && frameMouseY >= 0 && frameMouseX < captchaWidth && frameMouseY < captchaHeight) {
                int frameX = frameMouseX / (64);
                int frameY = frameMouseY / (64);
                this.getQueueCaptcha().rotateFrame(frameX, frameY);
            }
        }
    }

    public void removeCaptcha(PBot pbot) {
        (this.captchaList).removeIf(botCaptcha -> botCaptcha.getPBot().equals(pbot));
    }

    public void sendAnswer(String message) {
        if (!this.inQueue()) {
            return;
        }
        (this.captchaHelper).put(this.getQueueCaptcha().getHash(), message);
        this.getQueueCaptcha().sendAnswer(message);
        (this.captchaList).remove(0);
        this.saveHelper();
    }

    public void saveHelper() {
        try {
            Files.createDirectories(Paths.get((Minecraft.getMinecraft().gameDir) + "/NeoWare/ManualHelper/saved", new String[0]), new FileAttribute[0]);
            try (PrintWriter pw = new PrintWriter(new FileWriter((Minecraft.getMinecraft().gameDir) + "/NeoWare/ManualHelper/data.txt"));){
                (this.captchaHelper).forEach((k, v) -> pw.println(k + ":" + v));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean inQueue() {
        return ((this.captchaList).size() > 0 ? 1 : 0) != 0;
    }

    public void loadHelper() {
        try {
            Files.createDirectories(Paths.get((Minecraft.getMinecraft().gameDir) + "/NeoWare/ManualHelper/saved", new String[0]), new FileAttribute[0]);
            try (BufferedReader br = new BufferedReader(new FileReader((Minecraft.getMinecraft().gameDir) + "/NeoWare/ManualHelper/data.txt"));){
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(":", 2);
                    if (parts.length != (2)) continue;
                    (this.captchaHelper).put(parts[0], parts[1]);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @EventTarget
    public void onMessage(ChatMessageEvent event) {
        String message = event.getMessage();
        if (this.inQueue() && !message.startsWith("/") && !message.startsWith((CommandChatListener.PREFIX))) {
            this.sendAnswer(message);
            event.setCancelled(true);
        }
    }

    public void clear() {
        (this.captchaList).clear();
    }

}

