/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.viaversion.viaversion.api.protocol.version.ProtocolVersion
 *  de.florianmichael.viamcp.gui.GuiProtocolSelector
 *  neo.deobf.MainMenuScreen
 *  neo.deobf.ServerParser
 *  neo.deobf.ClickGuiScreen
 *  neo.deobf.PBot
 *  neo.deobf.FontRendererEx
 *  neo.deobf.FontRegistry
 *  neo.deobf.ShaderProgram
 *  neo.deobf.DrawUtils
 *  neo.deobf.RoundedUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraft.client.network.ServerPinger
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 */
package neo.deobf;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.viamcp.gui.GuiProtocolSelector;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import neo.deobf.MainMenuScreen;
import neo.deobf.ServerParser;
import neo.deobf.ClickGuiScreen;
import neo.deobf.PBot;
import neo.deobf.FontRendererEx;
import neo.deobf.FontRegistry;
import neo.deobf.ShaderProgram;
import neo.deobf.DrawUtils;
import neo.deobf.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.ServerPinger;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ServerMonitorScreen
extends GuiScreen {
    public final GuiScreen parentScreen;

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        (ServerParser.serverPinger).clearPendingNetworks();
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        if ((button.id) == 0) {
            (this.mc).displayGuiScreen((this.parentScreen));
        } else if ((button.id) == (1)) {
            ServerParser.init();
        } else if ((button.id) == (10)) {
            (this.mc).displayGuiScreen((GuiScreen)new GuiProtocolSelector((GuiScreen)this));
        }
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        (MainMenuScreen.backgroundShader).useShader(sr.getScaledWidth(), sr.getScaledHeight(), (float)mouseX, (float)mouseY, (float)(System.currentTimeMillis() - (MainMenuScreen.time)) / 1500.0f);
        GL11.glBegin((int)(7));
        GL11.glVertex2f((float)-1.00000048f, (float)-1.0f);
        GL11.glVertex2f((float)-1.00000024f, (float)1.0f);
        GL11.glVertex2f((float)1.0f, (float)1.0f);
        GL11.glVertex2f((float)1.0f, (float)-1.00000024f);
        GL11.glEnd();
        GL20.glUseProgram((int)(0));
        GlStateManager.disableCull();
        GlStateManager.pushMatrix();
        float panelWidth = 440.0f;
        float panelHeight = 280.0f;
        RoundedUtils.drawGradientRound((float)((float)(sr.getScaledWidth() / (2)) - panelWidth / 2.0f), (float)((float)(sr.getScaledHeight() / (2)) - panelHeight / 2.0f), (float)panelWidth, (float)panelHeight, (float)8.0f, (Color)ClickGuiScreen.getC((int)(0)), (Color)ClickGuiScreen.getC((int)(250)), (Color)ClickGuiScreen.getC((int)(750)), (Color)ClickGuiScreen.getC((int)(1000)));
        RoundedUtils.drawRound((float)((float)(sr.getScaledWidth() / (2)) - panelWidth / 2.0f + 2.0f), (float)((float)(sr.getScaledHeight() / (2)) - panelHeight / 2.0f + 2.0f), (float)(panelWidth - 4.0f), (float)(panelHeight - 4.0f), (float)8.0f, (Color)new Color(17, 17, 17, 240));
        (FontRegistry.mnstb_16).drawCenteredGradientThemeString("Мониторинг серверов", (float)(sr.getScaledWidth() / (2)), (float)(sr.getScaledHeight() / (2)) - panelHeight / 2.0f + 15.0f);
        int offsetX = 0;
        int offsetY = 0;
        for (ServerData serverData : ServerParser.getServers()) {
            float elementX = (float)(sr.getScaledWidth() / (2)) - panelWidth / 2.0f + (float)offsetX + 5.0f;
            float elementY = (float)(sr.getScaledHeight() / (2)) - panelHeight / 2.0f + (float)offsetY + 55.0f;
            RoundedUtils.drawRound((float)elementX, (float)elementY, (float)100.0f, (float)40.0f, (float)8.0f, (Color)new Color(40, 40, 40));
            (FontRegistry.mnstb_12).drawCenteredGradientThemeString((serverData.serverIP), elementX + 50.0f, elementY + 4.0f);
            (FontRegistry.mnstb_12).drawString("Онлайн: " + PBot.stripColor((String)(serverData.populationInfo)), elementX + 30.0f, elementY + 16.0f, new Color(200, 200, 200).getRGB());
            String version = ProtocolVersion.getProtocol((int)(serverData.version)).getName();
            (FontRegistry.mnstb_12).drawString("Версия: " + (version.contains("Unknown") ? "Unknown" : version), elementX + 30.0f, elementY + 23.0f, new Color(200, 200, 200).getRGB());
            (FontRegistry.mnstb_12).drawString("Пинг: " + (serverData.pingToServer), elementX + 30.0f, elementY + 30.0f, new Color(200, 200, 200).getRGB());
            if ((serverData.iconRender) != null) {
                DrawUtils.renderImage((BufferedImage)(serverData.iconRender), (int)((int)(elementX + 5.0f)), (int)((int)(elementY + 12.0f)), (int)(20), (int)(20));
            } else {
                DrawUtils.drawImage((ResourceLocation)new ResourceLocation("textures/misc/unknown_server.png"), (float)((int)(elementX + 5.0f)), (float)((int)(elementY + 12.0f)), (float)20.0f, (float)20.0f, (Color)new Color(255, 255, 255));
            }
            if ((offsetX += 110) > (330)) {
                offsetX = 0;
                offsetY += 50;
            }
            if (offsetY < (200)) continue;
            break;
        }
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void confirmClicked(boolean result, int id) {
    }

    public void updateScreen() {
        super.updateScreen();
        (ServerParser.serverPinger).pingPendingNetworks();
    }

    public ServerMonitorScreen(GuiScreen parentScreen) {
        this.parentScreen = parentScreen;
    }

    public void initGui() {
        (this.buttonList).clear();
        ServerParser.init();
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (keyCode == (1)) {
            (this.mc).displayGuiScreen((this.parentScreen));
        }
        super.keyTyped(typedChar, keyCode);
    }

    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
    }
}

