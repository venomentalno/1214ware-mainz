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
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiTextField
 *  net.minecraft.util.text.TextFormatting
 *  org.lwjgl.input.Keyboard
 */
package neo.deobf;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.util.List;
import neo.deobf.AltAccount;
import neo.deobf.AltLoginThread;
import neo.deobf.NeoButton;
import neo.deobf.GuiPasswordField;
import neo.deobf.DrawUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class AltLoginScreen
extends GuiScreen {
    public GuiTextField username;
    public GuiPasswordField password;
    public final GuiScreen previousScreen;
    public AltLoginThread thread;

    private static FontRenderer getFontRenderer(Minecraft minecraft) {
        return minecraft.fontRenderer;
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
            this.actionPerformed((GuiButton)(this.buttonList).get(0));
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
        this.username = new GuiTextField(height1, AltLoginScreen.getFontRenderer5(AltLoginScreen.getMc3(this)), AltLoginScreen.getWidth7(this) / (2) - (100), 60, 200, 20);
        this.password = new GuiPasswordField(AltLoginScreen.getFontRenderer(AltLoginScreen.getMc(this)), AltLoginScreen.getWidth6(this) / (2) - (100), 100, 200, 20);
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
        (Minecraft.getMinecraft().fontRenderer).drawStringWithShadow("Alt Login", (float)(this.width) / 2.0f - 10.0f, 20.0f, -1);
        (Minecraft.getMinecraft().fontRenderer).drawStringWithShadow((this.thread) == null ? (TextFormatting.GRAY) + "Alts..." : (this.thread).getStatus(), (float)(this.width) / 2.0f, 29.0f, -1);
        if ((this.username).getText().isEmpty() && !(this.username).isFocused()) {
            (Minecraft.getMinecraft().fontRenderer).drawStringWithShadow("Username / E-Mail", (float)((this.width) / (2) - (96)), 66.0f, -7829368);
        }
        if ((this.password).getText().isEmpty() && !(this.password).isFocused()) {
            (Minecraft.getMinecraft().fontRenderer).drawStringWithShadow("Password", (float)((this.width) / (2) - (96)), 106.0f, -7829368);
        }
        super.drawScreen(x, y, z);
    }

    private static int getWidth7(AltLoginScreen instance) {
        return instance.width;
    }

    protected void actionPerformed(GuiButton button) {
        try {
            switch ((button.id)) {
                case 0: {
                    AltLoginThread bc = new AltLoginThread(new AltAccount((this.username).getText(), (this.password).getText()));
                    this.thread = bc;
                    bc.start();
                    break;
                }
                case 1: {
                    (this.mc).displayGuiScreen((this.previousScreen));
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

    private static FontRenderer getFontRenderer5(Minecraft minecraft) {
        return minecraft.fontRenderer;
    }

    public AltLoginScreen(GuiScreen previousScreen) {
        this.previousScreen = previousScreen;
    }

    private static Minecraft getMc3(AltLoginScreen instance) {
        return instance.mc;
    }

}

