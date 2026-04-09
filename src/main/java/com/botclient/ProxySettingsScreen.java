/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.MainMenuScreen
 *  neo.deobf.PBotManager
 *  neo.deobf.ProxyType
 *  neo.deobf.ProxyInfo
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.TextRenderer
 *  net.minecraft.client.gui.ButtonWidget
 *  net.minecraft.client.gui.GuiMultiplayer
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.TextFieldWidget
 *  net.minecraft.client.renderer.GlStateManager
 *  org.apache.commons.io.FileUtils
 *  org.json.JSONObject
 *  org.lwjgl.input.Keyboard
 */
package com.botclient;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import com.botclient.MainMenuScreen;
import com.botclient.PBotManager;
import com.botclient.ProxyType;
import com.botclient.ProxyInfo;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.render.RenderSystem;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import net.minecraft.client.util.InputUtil;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ProxySettingsScreen
extends Screen {
    public TextFieldWidget passwordField;
    private final int offset = 20;
    public static int type = 3;
    public TextFieldWidget proxyField;
    public static String username;
    public static String proxy;
    public final Minecraft mc = MinecraftClient.getInstance();
    public static String password;
    public TextFieldWidget usernameField;

    private static int getWidth(ProxySettingsScreen instance) {
        return instance.width;
    }

    private static TextFieldWidget getPasswordField(ProxySettingsScreen instance) {
        return instance.passwordField;
    }

    public static String keepNumbersAndColonOnly(String input) {
        return input.replaceAll("[^\\\\\\\\d:.]", "");
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
        if (keyCode == (28)) {
            this.actionPerformed((ButtonWidget)(this.buttonList).get(1));
        }
        (this.proxyField).textboxKeyTyped(typedChar, keyCode);
        (this.usernameField).textboxKeyTyped(typedChar, keyCode);
        (this.passwordField).textboxKeyTyped(typedChar, keyCode);
    }

    protected void actionPerformed(ButtonWidget button) throws IOException {
        ProxyInfo proxyInfo;
        if ((button.id) == 0) {
            String fieldText = ProxySettingsScreen.keepNumbersAndColonOnly((this.proxyField).getText());
            if (fieldText.contains(":") && fieldText.split(":").length == (2)) {
                if ((type) == (3)) {
                    type = 1;
                }
                proxy = fieldText;
                username = (this.usernameField).getText();
                password = ProxySettingsScreen.getPasswordField(this).getText();
            } else if ((type) != (3)) {
                type = 3;
                if ((this.proxyField).getText().length() != 0) {
                    proxy = "§cBad Proxy Formate";
                }
            }
            ProxySettingsScreen.saveConfig();
            (this.mc).setScreen((GuiScreen)new GuiMultiplayer((GuiScreen)new MainMenuScreen()));
        } else if ((button.id) == (1)) {
            (this.proxyField).setText("");
            proxy = "";
            username = "";
            password = "";
            type = 3;
        } else if ((button.id) == (3)) {
            type = (type) + (1);
            if ((type) > (2)) {
                type = 0;
            }
        } else if ((button.id) == (4) && (proxyInfo = PBotManager.getInstance().getProxyManager().getProxy()) != null) {
            type = ProxySettingsScreen.getIdByType(proxyInfo.getType());
            proxy = proxyInfo.getProxy();
            username = proxyInfo.getUsername();
            password = proxyInfo.getPassword();
            (this.proxyField).setText((proxy));
            (this.usernameField).setText(proxyInfo.getUsername());
            (this.passwordField).setText(proxyInfo.getPassword());
        }
    }

    private static int getHeight2(ProxySettingsScreen instance) {
        return instance.height;
    }

    public static ProxyType getTypeById(int id) {
        if (id == 0) {
            return (ProxyType.SOCKS4);
        }
        if (id == (1)) {
            return (ProxyType.SOCKS5);
        }
        if (id == (2)) {
            return (ProxyType.HTTP);
        }
        if (id == (3)) {
            return (ProxyType.NO_PROXY);
        }
        return (ProxyType.NO_PROXY);
    }

    private static TextRenderer getTextRenderer(ProxySettingsScreen instance) {
        return instance.textRenderer;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        RenderSystem.scale((float)1.0f, (float)1.0f, (float)1.0f);
        this.drawString((this.textRenderer), "§6Current Type: §6§l" + ProxySettingsScreen.getCurrentType() + " §8- §7IP:Port", (this.width) / (2) - (110), (this.height) / (2) - (20) - (10), -1);
        (this.proxyField).drawTextBox();
        if ((type) == (1)) {
            if (!(this.usernameField).getVisible()) {
                (this.usernameField).setVisible(true);
            }
            if (!(this.passwordField).getVisible()) {
                (this.passwordField).setVisible(true);
            }
            (this.usernameField).drawTextBox();
            (this.passwordField).drawTextBox();
            this.drawString((this.textRenderer), "§fUsername", (this.width) / (2) - (110), (this.height) / (2) + (10) + (40) - (20), -1);
            this.drawString((this.textRenderer), "§fPassword", (this.width) / (2) - (110), (this.height) / (2) + (10) + (80) - (20), -1);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        (this.buttonList).add(new ButtonWidget(0, (this.width) / (2) - (100), (this.height) - (50), 200, 20, "Done"));
        (this.buttonList).add(new ButtonWidget(1, (this.width) / (2) + (50), (this.height) / (2) + (10) - (20), 30, 20, "Reset"));
        (this.buttonList).add(new ButtonWidget(3, (this.width) / (2) + (80), (this.height) / (2) + (10) - (20), 30, 20, "Type"));
        (this.buttonList).add(new ButtonWidget(4, (this.width) / (2) + (50), (this.height) / (2) + (35) - (20), 63, 20, "Free Proxy"));
        this.proxyField = new TextFieldWidget(2, ProxySettingsScreen.getTextRenderer5(this), ProxySettingsScreen.getWidth4(this) / (2) - (110), ProxySettingsScreen.getHeight2(this) / (2) + (10) - (20), 220, 20);
        (this.proxyField).setMaxStringLength(22);
        (this.proxyField).setFocused(true);
        (this.proxyField).setText((proxy));
        this.usernameField = new TextFieldWidget(2, ProxySettingsScreen.getTextRenderer(this), ProxySettingsScreen.getWidth(this) / (2) - (110), ProxySettingsScreen.getHeight4(this) / (2) + (10) + (50) - (20), 220, 20);
        (this.usernameField).setMaxStringLength(22);
        (this.usernameField).setFocused(false);
        (this.usernameField).setText((username));
        (this.usernameField).setVisible(((type) == (1) ? 1 : 0) != 0);
        this.passwordField = new TextFieldWidget(2, ProxySettingsScreen.getTextRenderer2(this), ProxySettingsScreen.getWidth9(this) / (2) - (110), ProxySettingsScreen.getHeight9(this) / (2) + (10) + (90) - (20), 220, 20);
        (this.passwordField).setMaxStringLength(22);
        (this.passwordField).setFocused(false);
        (this.passwordField).setText((password));
        (this.passwordField).setVisible(((type) == (1) ? 1 : 0) != 0);
    }

    private static int getHeight4(ProxySettingsScreen instance) {
        return instance.height;
    }

    private static String readUsingFiles(File file) {
        try {
            return new String(Files.readAllBytes(file.toPath()));
        }
        catch (IOException e) {
            ProxySettingsScreen.saveConfig();
            return null;
        }
    }

    public static void loadConfig() {
        try {
            JSONObject config = new JSONObject(Objects.requireNonNull(ProxySettingsScreen.readUsingFiles(new File((MinecraftClient.getInstance().gameDir), "/NeoWare/mcproxy.json"))));
            type = ProxySettingsScreen.getIdByType(ProxyType.getType((String)config.getString("type")));
            proxy = config.getString("host");
            username = config.getString("username");
            password = config.getString("password");
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static int getWidth4(ProxySettingsScreen instance) {
        return instance.width;
    }

    private static TextRenderer getTextRenderer2(ProxySettingsScreen instance) {
        return instance.textRenderer;
    }

    public boolean doesGuiPauseGame() {
        return true;
    }

    public static int getIdByType(ProxyType type) {
        if (type.equals((Object)(ProxyType.HTTP))) {
            return 2;
        }
        if (type.equals((Object)(ProxyType.SOCKS5))) {
            return 1;
        }
        if (type.equals((Object)(ProxyType.SOCKS4))) {
            return 0;
        }
        if (type.equals((Object)(ProxyType.NO_PROXY))) {
            return 3;
        }
        return 3;
    }

    private static int getHeight9(ProxySettingsScreen instance) {
        return instance.height;
    }

    private static TextRenderer getTextRenderer5(ProxySettingsScreen instance) {
        return instance.textRenderer;
    }

    public static void saveConfig() {
        try {
            JSONObject proxySetting = new JSONObject();
            proxySetting.put("type", (Object)ProxySettingsScreen.getCurrentType().name());
            proxySetting.put("host", (Object)(proxy));
            proxySetting.put("username", (Object)(username));
            proxySetting.put("password", (Object)(password));
            FileUtils.writeByteArrayToFile((File)new File((MinecraftClient.getInstance().gameDir), "/NeoWare/mcproxy.json"), (byte[])proxySetting.toString().getBytes((StandardCharsets.UTF_8)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    private static int getWidth9(ProxySettingsScreen instance) {
        return instance.width;
    }

    static {
        proxy = "";
        username = "";
        password = "";
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        (this.proxyField).mouseClicked(mouseX, mouseY, mouseButton);
        (this.usernameField).mouseClicked(mouseX, mouseY, mouseButton);
        (this.passwordField).mouseClicked(mouseX, mouseY, mouseButton);
    }

    public void updateScreen() {
        (this.proxyField).updateCursorCounter();
        (this.usernameField).updateCursorCounter();
        (this.passwordField).updateCursorCounter();
        super.updateScreen();
    }

    public static ProxyType getCurrentType() {
        return ProxySettingsScreen.getTypeById((type));
    }

}

