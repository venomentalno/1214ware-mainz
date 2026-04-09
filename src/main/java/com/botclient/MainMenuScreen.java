/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.MenuButton
 *  neo.deobf.Client
 *  neo.deobf.AltManagerScreen
 *  neo.deobf.ClickGuiScreen
 *  neo.deobf.TextRendererEx
 *  neo.deobf.FontRegistry
 *  neo.deobf.ShaderProgram
 *  neo.deobf.RoundedUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiMultiplayer
 *  net.minecraft.client.gui.GuiOptions
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiWorldSelection
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.settings.GameOptions
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 */
package com.botclient;

import java.awt.Color;
import java.net.URI;
import java.util.ArrayList;
import com.botclient.MenuButton;
import com.botclient.Client;
import com.botclient.AltManagerScreen;
import com.botclient.ClickGuiScreen;
import com.botclient.TextRendererEx;
import com.botclient.FontRegistry;
import com.botclient.ShaderProgram;
import com.botclient.RoundedUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraft.client.util.Window;
import net.minecraft.client.render.RenderSystem;
import net.minecraft.client.option.GameOptions;
import org.lwjgl.opengl.GL20;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class MainMenuScreen
extends Screen {
    public static final long time = System.currentTimeMillis();
    public static ShaderProgram backgroundShader = new ShaderProgram("/assets/minecraft/neoware/shaders/background.fsh");
    public ArrayList<MenuButton> buttons;

    private void openWebLink(URI url) {
        try {
            Class<?> oclass = Class.forName("java.awt.Desktop");
            Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            Class[] classArray = new Class[1];
            classArray[0] = URI.class;
            Object[] objectArray = new Object[1];
            objectArray[0] = url;
            oclass.getMethod("browse", classArray).invoke(object, objectArray);
        }
        catch (Throwable throwable1) {
            throwable1.printStackTrace();
        }
    }

    public void initGui() {
        Window window = MinecraftClient.getInstance().getWindow();
        this.buttons = new ArrayList();
        (this.buttons).add(new MenuButton(1, window.getScaledWidth() / (2), window.getScaledHeight() / (2) - (45), 100, 16, "Одиночная игра"));
        (this.buttons).add(new MenuButton(2, window.getScaledWidth() / (2), window.getScaledHeight() / (2) - (45) + (20), 100, 16, "Сетевая игра"));
        (this.buttons).add(new MenuButton(3, window.getScaledWidth() / (2), window.getScaledHeight() / (2) - (45) + (40), 100, 16, "Аккаунты"));
        (this.buttons).add(new MenuButton(4, window.getScaledWidth() / (2), window.getScaledHeight() / (2) - (45) + (60), 100, 16, "Настройки"));
        (this.buttons).add(new MenuButton(5, window.getScaledWidth() / (2), window.getScaledHeight() / (2) - (45) + (80), 100, 16, "Мониторинг"));
        (this.buttons).add(new MenuButton(6, window.getScaledWidth() / (2), window.getScaledHeight() / (2) - (45) + (108), 100, 16, "Discord"));
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Window window = MinecraftClient.getInstance().getWindow();
        this.backgroundShader.useShader(window.getScaledWidth(), window.getScaledHeight(), (float)mouseX, (float)mouseY, (float)(System.currentTimeMillis() - this.time) / 1500.0f);
        RenderSystem.glBegin((int)(7));
        RenderSystem.glVertex2f((float)-1.00000024f, (float)-1.0f);
        RenderSystem.glVertex2f((float)-1.0f, (float)1.0f);
        RenderSystem.glVertex2f((float)1.0f, (float)1.0f);
        RenderSystem.glVertex2f((float)1.0f, (float)-1.0f);
        RenderSystem.glEnd();
        GL20.glUseProgram((int)(0));
        RenderSystem.disableCull();
        RenderSystem.pushMatrix();
        RoundedUtils.drawGradientRound((float)(sr.getScaledWidth() / (2) - (65)), (float)(sr.getScaledHeight() / (2) - (80)), (float)130.0f, (float)160.0f, (float)8.0f, (Color)ClickGuiScreen.getC((int)(0)), (Color)ClickGuiScreen.getC((int)(250)), (Color)ClickGuiScreen.getC((int)(750)), (Color)ClickGuiScreen.getC((int)(1000)));
        RoundedUtils.drawRound((float)(sr.getScaledWidth() / (2) - (65) + (2)), (float)(sr.getScaledHeight() / (2) - (80) + (2)), (float)126.0f, (float)156.0f, (float)8.0f, (Color)new Color(17, 17, 17, 240));
        (FontRegistry.mnstb_16).drawCenteredGradientThemeString("NeoWare Client", (float)(sr.getScaledWidth() / (2)), (float)(sr.getScaledHeight() / (2) - (70)));
        (FontRegistry.mnstb_12).drawString("v" + (Client.VERSION_TYPE), (float)(sr.getScaledWidth() / (2) + (32)), (float)(sr.getScaledHeight() / (2) - (73)), new Color(180, 180, 180).getRGB());
        (this.buttons).forEach(mainButton -> mainButton.render(mouseX, mouseY));
        RenderSystem.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        for (MenuButton button : (this.buttons)) {
            if (!button.isHovered(mouseX, mouseY)) continue;
            switch (button.getId()) {
                case 1: {
                    (this.mc).setScreen((GuiScreen)new GuiWorldSelection((GuiScreen)this));
                    break;
                }
                case 2: {
                    (this.mc).setScreen((GuiScreen)new GuiMultiplayer((GuiScreen)this));
                    break;
                }
                case 3: {
                    (this.mc).setScreen((GuiScreen)new AltManagerScreen());
                    break;
                }
                case 4: {
                    (this.mc).setScreen((GuiScreen)new GuiOptions((GuiScreen)this, (Minecraft.gameSettings)));
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                    this.openWebLink(URI.create("https://discord.gg/64nHUmgmCD"));
                }
            }
        }
    }

}

