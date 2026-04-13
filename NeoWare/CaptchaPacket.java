/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.BooleanSetting
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.PBotNetHandlerPlayClient
 *  neo.deobf.BotDebugModule
 *  neo.deobf.CaptchaManagerModule
 *  neo.deobf.NotificationType
 *  neo.deobf.NotificationsModule
 *  neo.deobf.ChatUtils
 *  neo.deobf.GifFrameInfo
 *  neo.deobf.ImageUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.text.TextFormatting
 */
package neo.deobf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Optional;
import neo.deobf.BooleanSetting;
import neo.deobf.PBot;
import neo.deobf.PBotPlayer;
import neo.deobf.PBotNetHandlerPlayClient;
import neo.deobf.BotDebugModule;
import neo.deobf.CaptchaManagerModule;
import neo.deobf.NotificationType;
import neo.deobf.NotificationsModule;
import neo.deobf.ChatUtils;
import neo.deobf.GifFrameInfo;
import neo.deobf.ImageUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class CaptchaPacket {
    public BufferedImage captcha;
    public final List<GifFrameInfo> frames;
    public final String hash;
    public final PBot pbot;

    private static List getFrames(CaptchaPacket instance) {
        return instance.frames;
    }

    public String getHash() {
        return (this.hash);
    }

    public void sendAnswer(String text) {
        if ((CaptchaPacket.getSaveCaptcha().value)) {
            ImageUtils.saveImage((BufferedImage)this.captcha, (File)new File((Minecraft.getMinecraft().gameDir), "/NeoWare/ManualHelper/saved/" + text + ".png"));
        }
        if ((this.pbot).isOnline()) {
            (this.pbot).sendMessage(text);
            if ((CaptchaPacket.getNotifications().value)) {
                NotificationsModule.notify((String)((TextFormatting.GREEN) + "Captcha"), (String)("Р‘РѕС‚ " + (this.pbot).getNickname() + " РћС‚РІРµС‚ " + text), (NotificationType)(NotificationType.SUCCESS), (int)(4));
            }
            if ((CaptchaPacket.getCaptcha().value)) {
                ChatUtils.formatMsg((String)("РљР°РїС‡Р° РґР»СЏ " + (this.pbot).getNickname() + " СЂРµС€РµРЅР°! РћС‚РІРµС‚ " + text));
            }
        }
    }

    public CaptchaPacket(String hash, BufferedImage captcha, List<GifFrameInfo> frames, PBot pbot) {
        this.hash = hash;
        this.captcha = captcha;
        this.frames = frames;
        this.pbot = pbot;
    }

    private static BooleanSetting getCaptcha() {
        return BotDebugModule.captcha;
    }

    public BufferedImage getCaptcha() {
        return (this.captcha);
    }

    private static PBot getPbot2(CaptchaPacket instance) {
        return instance.pbot;
    }

    private static BooleanSetting getNotifications() {
        return BotDebugModule.notifications;
    }

    public GifFrameInfo getFrame(int x, int y) {
        Optional<GifFrameInfo> frameOptional = (this.frames).stream().filter(frame -> (frame.getX() == x && frame.getY() == y ? 1 : 0) != 0).findFirst();
        return frameOptional.orElse(null);
    }

    public PBot getPBot() {
        return (this.pbot);
    }

    public boolean isMap() {
        return ((this.frames).size() == 0 ? 1 : 0) != 0;
    }

    public void rotateFrame(int x, int y) {
        ImageUtils.rotateFrame((BufferedImage)this.captcha, (int)x, (int)y);
        if (!this.isMap() && (this.pbot).isOnline()) {
            (CaptchaPacket.getPlayer(CaptchaPacket.getPbot2(this)).connection).sendPacket((Packet)new CPacketUseEntity(this.getFrame(x, y).getId(), (EnumHand.MAIN_HAND)));
        }
    }

    private static String getHash(CaptchaPacket instance) {
        return instance.hash;
    }

    public void setCaptcha(BufferedImage captcha) {
        this.captcha = captcha;
    }

    private static void setCaptcha(CaptchaPacket dn, BufferedImage bufferedImage) {
        dn.captcha = bufferedImage;
    }

    private static BooleanSetting getSaveCaptcha() {
        return CaptchaManagerModule.saveCaptcha;
    }

    public List<GifFrameInfo> getFrames() {
        return (this.frames);
    }

    private static PBotPlayer getPlayer(PBot instance) {
        return instance.player;
    }

}



