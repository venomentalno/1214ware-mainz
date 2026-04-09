/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.AltAccount
 *  neo.deobf.AltLoginThread
 *  neo.deobf.NeoButton
 *  neo.deobf.GuiPasswordField
 *  neo.deobf.DrawUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.TextRenderer
 *  net.minecraft.client.gui.ButtonWidget
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.TextFieldWidget
 *  net.minecraft.util.text.Formatting
 *  org.lwjgl.input.Keyboard
 */
package com.botclient;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.util.List;
import com.botclient.AltAccount;
import com.botclient.AltLoginThread;
import com.botclient.NeoButton;
import com.botclient.GuiPasswordField;
import com.botclient.DrawUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.util.Formatting;
import net.minecraft.client.util.InputUtil;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class AltLoginScreen
extends Screen {
    public TextFieldWidget username;
    public GuiPasswordField password;
    public final GuiScreen previousScreen;
    public AltLoginThread thread;

    private static TextRenderer getTextRenderer(Minecraft minecraft) {
        return minecraft.textRenderer;
    }

    private static Minecraft getMc(AltLoginScreen instance) {
        return instance.mc;
    }

    public void updateScreen() {
        (this.username).updateCursorCounter();
        (this.password).updateCursorCounter();
    }

    protected void keyTyped(char character, int key) {
        try {
            super.keyTyped(character, key);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == (9)) {
            if (!(this.username).isFocused() && !(this.password).isFocused()) {
                (this.username).setFocused(true);
            } else {
                (this.username).setFocused((this.password).isFocused());
                (this.password).setFocused((!(this.username).isFocused() ? 1 : 0) != 0);
            }
        }
        if (character == (13)) {
            this.actionPerformed((ButtonWidget)(this.buttonList).get(0));
        }
        (this.username).textboxKeyTyped(character, key);
        (this.password).textboxKeyTyped(character, key);
    }

    protected void mouseClicked(int x, int y, int button) {
        try {
            super.mouseClicked(x, y, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        (this.username).mouseClicked(x, y, button);
        (this.password).mouseClicked(x, y, button);
    }

    private static int getWidth6(AltLoginScreen instance) {
        return instance.width;
    }

    public void initGui() {
        int height1 = (this.height) / (4) + (24);
        (this.buttonList).add(new NeoButton(0, (this.width) / (2) - (100), height1 + (72) + (12), "Login"));
        (this.buttonList).add(new NeoButton(1, (this.width) / (2) - (100), height1 + (72) + (12) + (24), "Back"));
        (this.buttonList).add(new NeoButton(2, (this.width) / (2) - (100), height1 + (72) + (12) - (24), "Import User:Pass"));
        this.username = new TextFieldWidget(height1, AltLoginScreen.getTextRenderer5(AltLoginScreen.getMc3(this)), AltLoginScreen.getWidth7(this) / (2) - (100), 60, 200, 20);
        this.password = new GuiPasswordField(AltLoginScreen.getTextRenderer(AltLoginScreen.getMc(this)), AltLoginScreen.getWidth6(this) / (2) - (100), 100, 200, 20);
        (this.username).setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    public void drawScreen(int x, int y, float z) {
        DrawUtils.drawRect((float)0.0f, (float)0.0f, (float)(this.width), (float)(this.height), (Color)new Color(22, 22, 22, 255));
        (this.username).drawTextBox();
        (this.password).drawTextBox();
        (MinecraftClient.getInstance().textRenderer).drawStringWithShadow("Alt Login", (float)(this.width) / 2.0f - 10.0f, 20.0f, -1);
        (MinecraftClient.getInstance().textRenderer).drawStringWithShadow((this.thread) == null ? (TextFormat.GRAY) + "Alts..." : (this.thread).getStatus(), (float)(this.width) / 2.0f, 29.0f, -1);
        if ((this.username).getText().isEmpty() && !(this.username).isFocused()) {
            (MinecraftClient.getInstance().textRenderer).drawStringWithShadow("Username / E-Mail", (float)((this.width) / (2) - (96)), 66.0f, -7829368);
        }
        if ((this.password).getText().isEmpty() && !(this.password).isFocused()) {
            (MinecraftClient.getInstance().textRenderer).drawStringWithShadow("Password", (float)((this.width) / (2) - (96)), 106.0f, -7829368);
        }
        super.drawScreen(x, y, z);
    }

    private static int getWidth7(AltLoginScreen instance) {
        return instance.width;
    }

    protected void actionPerformed(ButtonWidget button) {
        try {
            switch ((button.id)) {
                case 0: {
                    AltLoginThread bc = new AltLoginThread(new AltAccount((this.username).getText(), (this.password).getText()));
                    this.thread = bc;
                    bc.start();
                    break;
                }
                case 1: {
                    (this.mc).setScreen((this.previousScreen));
                    break;
                }
                case 2: {
                    String data = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData((DataFlavor.stringFlavor));
                    if (!data.contains(":")) break;
                    String[] credentials = data.split(":");
                    (this.username).setText(credentials[0]);
                    (this.password).setText(credentials[1]);
                }
            }
        }
        catch (Throwable e) {
            throw new RuntimeException();
        }
    }

    private static TextRenderer getTextRenderer5(Minecraft minecraft) {
        return minecraft.textRenderer;
    }

    public AltLoginScreen(GuiScreen previousScreen) {
        this.previousScreen = previousScreen;
    }

    private static Minecraft getMc3(AltLoginScreen instance) {
        return instance.mc;
    }

}

