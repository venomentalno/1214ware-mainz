/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.AltAccount
 *  neo.deobf.NeoButton
 *  neo.deobf.AltManagerScreen
 *  neo.deobf.GuiPasswordField
 *  neo.deobf.DrawUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.TextRenderer
 *  net.minecraft.client.gui.ButtonWidget
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.TextFieldWidget
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.util.text.Formatting
 */
package com.botclient;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import com.botclient.AltAccount;
import com.botclient.NeoButton;
import com.botclient.AltManagerScreen;
import com.botclient.GuiPasswordField;
import com.botclient.DrawUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.util.Window;
import net.minecraft.util.Formatting;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class EditAltScreen
extends Screen {
    public String status = TextFormat.GRAY + "Waiting...";
    public final AltManagerScreen manager;
    public TextFieldWidget nameField;
    public GuiPasswordField pwField;

    private static Minecraft getMc(EditAltScreen instance) {
        return instance.mc;
    }

    private static Minecraft getMc2(EditAltScreen instance) {
        return instance.mc;
    }

    public EditAltScreen(AltManagerScreen manager) {
        this.manager = manager;
    }

    private static Minecraft getMc3(EditAltScreen instance) {
        return instance.mc;
    }

    private static int getWidth(EditAltScreen instance) {
        return instance.width;
    }

    private static AltManagerScreen getManager(EditAltScreen instance) {
        return instance.manager;
    }

    protected void mouseClicked(int par1, int par2, int par3) {
        try {
            super.mouseClicked(par1, par2, par3);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        (this.nameField).mouseClicked(par1, par2, par3);
        (this.pwField).mouseClicked(par1, par2, par3);
    }

    private static Minecraft getMc5(EditAltScreen instance) {
        return instance.mc;
    }

    private static int getWidth3(EditAltScreen instance) {
        return instance.width;
    }

    public void actionPerformed(ButtonWidget button) {
        switch ((button.id)) {
            case 0: {
                (EditAltScreen.getManager(this).selectedAlt).setMask((this.nameField).getText());
                (EditAltScreen.getManager2(this).selectedAlt).setPassword((this.pwField).getText());
                this.status = "Edited!";
                break;
            }
            case 1: {
                (this.mc).setScreen((GuiScreen)(this.manager));
            }
        }
    }

    private static Minecraft getMc6(EditAltScreen instance) {
        return instance.mc;
    }

    private static AltManagerScreen getManager2(EditAltScreen instance) {
        return instance.manager;
    }

    private static Minecraft getMc7(EditAltScreen instance) {
        return instance.mc;
    }

    private static TextRenderer getTextRenderer(Minecraft minecraft) {
        return minecraft.textRenderer;
    }

    public void drawScreen(int par1, int par2, float par3) {
        Window window = this.mc.getWindow();
        DrawUtils.drawRect((float)0.0f, (float)0.0f, (float)(this.width), (float)(this.height), (Color)new Color(17, 17, 17, 255));
        (EditAltScreen.getMc6(this).textRenderer).drawStringWithShadow("Edit Alt", (float)(this.width) / 2.0f, 10.0f, -1);
        (EditAltScreen.getMc7(this).textRenderer).drawStringWithShadow((this.status), (float)(this.width) / 2.0f, 20.0f, -1);
        (this.nameField).drawTextBox();
        (this.pwField).drawTextBox();
        if ((this.nameField).getText().isEmpty() && !(this.nameField).isFocused()) {
            this.drawString((EditAltScreen.getMc2(this).textRenderer), "Name", (this.width) / (2) - (96), 66, -7829368);
        }
        if ((this.pwField).getText().isEmpty() && !(this.pwField).isFocused()) {
            this.drawString((EditAltScreen.getMc3(this).textRenderer), "Password", (this.width) / (2) - (96), 106, -7829368);
        }
        super.drawScreen(par1, par2, par3);
    }

    public void initGui() {
        (this.buttonList).add(new NeoButton(0, (this.width) / (2) - (100), (this.height) / (4) + (92) + (12), "Edit"));
        (this.buttonList).add(new NeoButton(1, (this.width) / (2) - (100), (this.height) / (4) + (116) + (12), "Cancel"));
        this.nameField = new TextFieldWidget(EditAltScreen.getEventButton(this), EditAltScreen.getTextRenderer6(EditAltScreen.getMc(this)), EditAltScreen.getWidth(this) / (2) - (100), 60, 200, 20);
        this.pwField = new GuiPasswordField(EditAltScreen.getTextRenderer(EditAltScreen.getMc5(this)), EditAltScreen.getWidth3(this) / (2) - (100), 100, 200, 20);
    }

protected void keyTyped(char par1, int par2) {
        (this.nameField).textboxKeyTyped(par1, par2);
        (this.pwField).textboxKeyTyped(par1, par2);
        if (par1 == (9) && ((this.nameField).isFocused() || (this.pwField).isFocused())) {
            (this.nameField).setFocused((!(this.nameField).isFocused() ? 1 : 0) != 0);
            (this.pwField).setFocused((!(this.pwField).isFocused() ? 1 : 0) != 0);
        }
        if (par1 == (13)) {
            this.actionPerformed((ButtonWidget)(this.buttonList).get(0));
        }
    }

    private static TextRenderer getTextRenderer6(Minecraft minecraft) {
        return minecraft.textRenderer;
    }

    private static int getEventButton(EditAltScreen instance) {
        return instance.eventButton;
    }
}

