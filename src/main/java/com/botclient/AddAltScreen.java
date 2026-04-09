/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.AddAltThread
 *  neo.deobf.NeoButton
 *  neo.deobf.AltManagerScreen
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
import com.botclient.AddAltThread;
import com.botclient.NeoButton;
import com.botclient.AltManagerScreen;
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
public class AddAltScreen
extends Screen {
    public String status;
    private Color gradientColor2;
    public final AltManagerScreen manager;
    private Color gradientColor3;
    public TextFieldWidget username;
    private Color gradientColor1 = Color.WHITE;
    private Color gradientColor4;
    public GuiPasswordField password;

    AddAltScreen(AltManagerScreen manager) {
        this.gradientColor2 = Color.WHITE;
        this.gradientColor3 = Color.WHITE;
        this.gradientColor4 = Color.WHITE;
        this.status = Formatting.GRAY + "Idle...";
        this.manager = manager;
    }

    private static TextRenderer getTextRenderer(Minecraft minecraft) {
        return minecraft.textRenderer;
    }

    private static Minecraft getMc2(AddAltScreen instance) {
        return instance.mc;
    }

    public void drawScreen(int i, int j, float f) {
        DrawUtils.drawRect((float)0.0f, (float)0.0f, (float)(AddAltScreen.getMc5(this).displayWidth), (float)(AddAltScreen.getMc2(this).displayHeight), (Color)new Color(17, 17, 17));
        (this.username).drawTextBox();
        (this.password).drawTextBox();
        (MinecraftClient.getInstance().textRenderer).drawCenteredString("Add Account", (double)((float)(this.width) / 2.0f), 15.0, -1);
        if ((this.username).getText().isEmpty() && !(this.username).isFocused()) {
            (MinecraftClient.getInstance().textRenderer).drawStringWithShadow("Username / E-Mail", (float)((this.width) / (2) - (96)), 66.0f, -7829368);
        }
        if ((this.password).getText().isEmpty() && !(this.password).isFocused()) {
            (MinecraftClient.getInstance().textRenderer).drawStringWithShadow("Password", (float)((this.width) / (2) - (96)), 106.0f, -7829368);
        }
        (MinecraftClient.getInstance().textRenderer).drawCenteredString((this.status), (double)((float)(this.width) / 2.0f), 30.0, -1);
        super.drawScreen(i, j, f);
    }

    protected void mouseClicked(int par1, int par2, int par3) {
        try {
            super.mouseClicked(par1, par2, par3);
        }
        catch (IOException var5) {
            var5.printStackTrace();
        }
        (this.username).mouseClicked(par1, par2, par3);
        (this.password).mouseClicked(par1, par2, par3);
    }

    protected void keyTyped(char par1, int par2) {
        (this.username).textboxKeyTyped(par1, par2);
        (this.password).textboxKeyTyped(par1, par2);
        if (par1 == (9) && ((this.username).isFocused() || (this.password).isFocused())) {
            (this.username).setFocused((!(this.username).isFocused() ? 1 : 0) != 0);
            (this.password).setFocused((!(this.password).isFocused() ? 1 : 0) != 0);
        }
        if (par1 == (13)) {
            this.actionPerformed((ButtonWidget)(this.buttonList).get(0));
        }
    }

    private static Minecraft getMc3(AddAltScreen instance) {
        return instance.mc;
    }

    protected void actionPerformed(ButtonWidget button) {
        switch ((button.id)) {
            case 0: {
                AddAltThread login = new AddAltThread(this, (this.username).getText(), (this.password).getText());
                login.start();
                break;
            }
            case 1: {
                (this.mc).setScreen((GuiScreen)(this.manager));
                break;
            }
            case 2: {
                String data;
                try {
                    data = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData((DataFlavor.stringFlavor));
                }
                catch (Exception var4) {
                    return;
                }
                if (!data.contains(":")) break;
                String[] credentials = data.split(":");
                (this.username).setText(credentials[0]);
                (this.password).setText(credentials[1]);
            }
        }
    }

    private static TextRenderer getTextRenderer5(Minecraft minecraft) {
        return minecraft.textRenderer;
    }

    private static int getWidth8(AddAltScreen instance) {
        return instance.width;
    }

    private static Minecraft getMc4(AddAltScreen instance) {
        return instance.mc;
    }

    private static void setStatus(AddAltScreen value, String string) {
        value.status = string;
    }

    private static void setStatus(AddAltScreen guiAddAlt, String status) {
        guiAddAlt.status = status;
    }

    private static int getWidth9(AddAltScreen instance) {
        return instance.width;
    }

    static void access$000(AddAltScreen x0, String x1) {
        x0.status = x1;
    }

    private static int getEventButton(AddAltScreen instance) {
        return instance.eventButton;
    }

public void initGui() {
        Keyboard.enableRepeatEvents(true);
        (this.buttonList).clear();
        (this.buttonList).add(new NeoButton(0, (this.width) / (2) - (100), (this.height) / (4) + (92) + (12), "Login"));
        (this.buttonList).add(new NeoButton(1, (this.width) / (2) - (100), (this.height) / (4) + (116) + (12), "Back"));
        (this.buttonList).add(new NeoButton(2, (this.width) / (2) - (100), (this.height) / (4) + (92) - (12), "Import User:Pass"));
        this.username = new TextFieldWidget(AddAltScreen.getEventButton(this), AddAltScreen.getTextRenderer(AddAltScreen.getMc4(this)), AddAltScreen.getWidth8(this) / (2) - (100), 60, 200, 20);
        this.password = new GuiPasswordField(AddAltScreen.getTextRenderer5(AddAltScreen.getMc3(this)), AddAltScreen.getWidth9(this) / (2) - (100), 100, 200, 20);
    }

    private static Minecraft getMc5(AddAltScreen instance) {
        return instance.mc;
    }
}

