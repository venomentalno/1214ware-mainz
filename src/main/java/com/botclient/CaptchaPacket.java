package com.botclient;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

public class CaptchaPacket {
    public BufferedImage captcha;
    public final List<GifFrameInfo> frames;
    public final String hash;
    public final PBot pbot;

    public CaptchaPacket(String hash, BufferedImage captcha, List<GifFrameInfo> frames, PBot pbot) {
        this.hash = hash;
        this.captcha = captcha;
        this.frames = frames;
        this.pbot = pbot;
    }

    public String getHash() { return this.hash; }
    public BufferedImage getCaptcha() { return this.captcha; }
    public void setCaptcha(BufferedImage captcha) { this.captcha = captcha; }
    public PBot getPBot() { return this.pbot; }
    public List<GifFrameInfo> getFrames() { return this.frames; }

    public GifFrameInfo getFrame(int x, int y) {
        return this.frames.stream().filter(f -> f.getX() == x && f.getY() == y).findFirst().orElse(null);
    }

    public boolean isMap() { return this.frames.isEmpty(); }

    public void sendAnswer(String text) {
        if (CaptchaManagerModule.saveCaptcha.value) {
            ImageUtils.saveImage(this.captcha, new File(MinecraftClient.getInstance().runDirectory, "/NeoWare/ManualHelper/saved/" + text + ".png"));
        }
        if (this.pbot.isOnline()) {
            this.pbot.sendMessage(text);
            if (BotDebugModule.notifications.value) {
                NotificationsModule.notify("Captcha", "Bot " + this.pbot.getNickname() + " Answer " + text, NotificationType.SUCCESS, 4);
            }
            if (BotDebugModule.captcha.value) {
                ChatUtils.formatMsg("Bot " + this.pbot.getNickname() + " Answered: " + text);
            }
        }
    }

    public void rotateFrame(int x, int y) {
        ImageUtils.rotateFrame(this.captcha, x, y);
        if (!this.isMap() && this.pbot.isOnline()) {
            GifFrameInfo frame = this.getFrame(x, y);
            if (frame != null && this.pbot.player != null) {
                Packet<?> packet = PlayerInteractEntityC2SPacket.interact(this.pbot.player.getEntityWorld(), frame.getId(), Hand.MAIN_HAND);
                this.pbot.player.networkHandler.sendPacket(packet);
            }
        }
    }
}
