/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Render2DEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.Setting
 *  neo.deobf.Client
 *  neo.deobf.PBotManager
 *  neo.deobf.ModuleCategory
 *  neo.deobf.ActionRecorderModule
 *  neo.deobf.BooleanSetting
 *  neo.deobf.Module
 *  neo.deobf.PBot
 *  neo.deobf.TextRendererEx
 *  neo.deobf.FontRegistry
 *  neo.deobf.TickRateTracker
 *  neo.deobf.ColorUtils
 *  neo.deobf.DrawUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.PlayerEntitySP
 *  net.minecraft.client.gui.TextRenderer
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraft.util.ResourceLocation
 */
package com.botclient;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;
import com.botclient.Render2DEvent;
import com.botclient.EventTarget;
import com.botclient.Setting;
import com.botclient.Client;
import com.botclient.PBotManager;
import com.botclient.ModuleCategory;
import com.botclient.ActionRecorderModule;
import com.botclient.BooleanSetting;
import com.botclient.Module;
import com.botclient.PBot;
import com.botclient.TextRendererEx;
import com.botclient.FontRegistry;
import com.botclient.TickRateTracker;
import com.botclient.ColorUtils;
import com.botclient.DrawUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.Window;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.Identifier;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class HudModule
extends Module {
    public final BooleanSetting hideIP;
    public final BooleanSetting lagDetector;
    public final BooleanSetting board = new BooleanSetting("Board", true);

    private static BooleanSetting getLagDetector(HudModule instance) {
        return instance.lagDetector;
    }

    private static BooleanSetting IqeYgqypri(HudModule instance) {
        return instance.board;
    }

    @EventTarget
    public void onRender2D(Render2DEvent event) {
        try {
            ScaledResolution scaledresolution = event.getResolution();
            if ((HudModule.getBoard(this).value)) {
                Runtime runtime = Runtime.getRuntime();
                String lag = TickRateTracker.getLagFormatColor() + (TickRateTracker.getLagPackets() - 700L < GenericCancelableEventB ? GenericCancelableEventB : TickRateTracker.getLagPackets() - 700L);
                (MinecraftClient.getInstance().textRenderer).drawString("§d§lNeo§f§lWare " + (Client.VERSION_TYPE), 10, 100, -1);
                (MinecraftClient.getInstance().textRenderer).drawString("§f§lFps: §d§l" + MinecraftClient.getInstance().getCurrentFps(), 10, 110, -1);
                (MinecraftClient.getInstance().textRenderer).drawString("§f§lIP: §d§l" + ((HudModule.getHideIP(this).value) ? "Hidden" : ((mc).isSingleplayer() ? "Localhost" : (Objects.requireNonNull(MinecraftClient.getInstance().getCurrentServerData()).serverIP))), 10, 120, -1);
                Object[] objectArray = new Object[1];
                objectArray[0] = Float.valueOf(TickRateTracker.getTickRate());
                (MinecraftClient.getInstance().textRenderer).drawString("§f§lTPS: §d§l" + String.format("%.2f", objectArray), 10, 130, -1);
                (MinecraftClient.getInstance().textRenderer).drawString("§f§lBrand: §d§l" + ((Minecraft.player).getServerBrand() != null && (Minecraft.player).getServerBrand().split(" ").length >= (2) ? (Minecraft.player).getServerBrand().split(" ")[0] : (Minecraft.player).getServerBrand()), 10, 140, -1);
                (MinecraftClient.getInstance().textRenderer).drawString("§f§lLag Detector: " + ((mc).isSingleplayer() ? "§a§l0" : lag) + "ms", 10, 150, -1);
                (MinecraftClient.getInstance().textRenderer).drawString("§f§lLoaded Proxies: §d§l" + PBotManager.getInstance().getProxyManager().getProxyList().size(), 10, 160, -1);
                (MinecraftClient.getInstance().textRenderer).drawString("§f§lBots Connected: §d§l" + PBot.getOnline().size() + "/" + PBot.getBotList().size(), 10, 170, -1);
                (MinecraftClient.getInstance().textRenderer).drawString("§f§lRAM Usage: §d§l" + (runtime.totalMemory() - runtime.freeMemory()) / 0x100000L + "/" + runtime.totalMemory() / 0x100000L, 10, 180, -1);
                (MinecraftClient.getInstance().textRenderer).drawString("§f§lManualHelper: §d§l" + PBotManager.getInstance().getCaptchaManager().getHelperSize(), 10, 190, -1);
                (MinecraftClient.getInstance().textRenderer).drawString("§f§lRecorder: §d§l" + (ActionRecorderModule.records).size(), 10, 200, -1);
                (MinecraftClient.getInstance().textRenderer).drawString("§f§lThreads: §d§l" + Thread.activeCount(), 10, 210, -1);
            }
            if ((HudModule.getLagDetector(this).value) && !(mc).isSingleplayer() && TickRateTracker.getLagPackets() > 1500L) {
                DrawUtils.drawImage((ResourceLocation)new Identifier("neoware/images/lost_connection.png"), (float)(scaledresolution.getScaledWidth() / (2) - (64)), (float)(scaledresolution.getScaledHeight() / (2) - (200)), (float)128.0f, (float)128.0f, (Color)this.getColor());
                (FontRegistry.mnstb_15).drawCenteredString("§l  Потеряно соединение с сервером", (float)(scaledresolution.getScaledWidth() / (2)), (float)(scaledresolution.getScaledHeight() / (2) - (65)), this.getColor().getRGB());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public HudModule() {
        super("HUD", ModuleCategory.Render);
        this.hideIP = new BooleanSetting("Hide IP", false, () -> (HudModule.IqeYgqypri(this).value));
        this.lagDetector = new BooleanSetting("LagDetector", true);
        Setting[] settings = new Setting[3];
        settings[0] = this.board;
        settings[1] = this.hideIP;
        settings[2] = this.lagDetector;
        this.addSetting(settings);
    }

    private Color getColor() {
        return ColorUtils.TwoColorEffect((Color)new Color(255, 64, 64), (Color)new Color(255, 112, 112, 255), (double)5.0, (int)(0));
    }

    private static BooleanSetting getHideIP(HudModule instance) {
        return instance.hideIP;
    }

    private static BooleanSetting getBoard(HudModule instance) {
        return instance.board;
    }

}

