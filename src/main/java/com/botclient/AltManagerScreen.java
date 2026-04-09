package com.botclient;

import com.botclient.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.session.Session;
import net.minecraft.client.util.Identifier;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.StringUtils;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.render.RenderSystem;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class AltManagerScreen extends Screen {
    public float offset;
    public Identifier skinIdentifier;
    public TextFieldWidget searchField;
    public String status = Formatting.DARK_GRAY + "(" + Formatting.GRAY + AltManager.registry.size() + Formatting.DARK_GRAY + ")";
    public AltLoginThread loginThread;
    public NeoButton remove;
    public NeoButton login;
    public static final AuthServiceSwitcher altService = new AuthServiceSwitcher();
    public AltAccount selectedAlt = null;

    public AltManagerScreen(Screen parent) {
        super(Text.of("Alt Manager"));
    }

    @Override
    protected void init() {
        this.searchField = new TextFieldWidget(this.textRenderer, this.width / 2 + 116, this.height - 22, 72, 16, Text.of("Search"));
        this.addDrawableChild(this.searchField);

        this.login = new NeoButton(1, this.width / 2 - 122, this.height - 48, 60, 20, Text.of("Login"), b -> this.onLogin());
        this.addDrawableChild(this.login);

        this.remove = new NeoButton(2, this.width / 2 + 4 + 77, this.height - 48, 40, 20, Text.of("Remove"), b -> this.onRemove());
        this.addDrawableChild(this.remove);

        this.addDrawableChild(new NeoButton(3, this.width / 2 + 4 - 60, this.height - 48, 65, 20, Text.of("Add Alt"), b -> this.client.setScreen(new AddAltScreen(this))));
        this.addDrawableChild(new NeoButton(5, this.width / 2 + 15, this.height - 48, 60, 20, Text.of("Random"), b -> this.onRandom()));
        this.addDrawableChild(new NeoButton(7, this.width / 2 - 122, this.height - 24, 245, 20, Text.of("Back"), b -> this.client.setScreen(null)));
        this.addDrawableChild(new NeoButton(8, this.width / 2 + 4 + 124, this.height - 25, 60, 20, Text.of("Clear All"), b -> this.onClear()));

        this.login.active = false;
        this.remove.active = false;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        DrawUtils.drawRect(0.0f, 0.0f, this.width, this.height, new Color(17, 17, 17));
        super.render(context, mouseX, mouseY, delta);

        String altName = "Name: " + this.client.getSession().getUsername();
        context.drawText(this.textRenderer, altName, this.width / 2 - this.textRenderer.getWidth(altName) / 2, 10, -1, false);

        RenderSystem.enableScissor(0, 0, this.width, this.height - 50);
        int y = 38;
        int number = 0;
        List<AltAccount> alts = this.getFilteredAlts();
        for (AltAccount alt : alts) {
            if ((float) y - this.offset > this.height - 50) break;
            ++number;

            String name = alt.getMask().isEmpty() ? alt.getUsername() : alt.getMask();
            if (name.equalsIgnoreCase(this.client.getSession().getUsername())) name = Formatting.GREEN + name;
            String prefix = alt.getStatus().equals(AltStatus.Banned) ? Formatting.RED + "" : (alt.getStatus().equals(AltStatus.NotWorking) ? Formatting.STRIKETHROUGH + "" : "");
            name = prefix + name + Formatting.RESET + " ";
            String pass = alt.getPassword().isEmpty() ? Formatting.RED + "Not License" : Formatting.GREEN + "License";

            RenderSystem.enableTexture();
            if (this.skinIdentifier == null || !StringUtils.stripControlCodes(name).equals(this.skinIdentifier.getPath())) {
                this.skinIdentifier = new Identifier("alt_skins/" + StringUtils.stripControlCodes(name));
                this.loadSkin(this.skinIdentifier, name);
            } else {
                this.client.getTextureManager().bindTexture(this.skinIdentifier);
                context.drawTexture(this.skinIdentifier, this.width / 2 - 110, y - (int) this.offset, 8, 8, 8, 8, 64, 64);
            }

            context.drawText(this.textRenderer, name, this.width / 2 - 80, y - (int) this.offset + 5, -1, false);
            context.drawText(this.textRenderer, (alt.getStatus().equals(AltStatus.NotWorking) ? Formatting.STRIKETHROUGH + "" : "") + pass, this.width / 2 - 80, y - (int) this.offset + 15, new Color(110, 110, 110).getRGB(), false);
            y += 40;
        }
        RenderSystem.disableScissor();

        if (this.selectedAlt == null) {
            this.login.active = false;
            this.remove.active = false;
        } else {
            this.login.active = true;
            this.remove.active = true;
        }

        if (GLFW.glfwGetKey(this.client.getWindow().getHandle(), GLFW.GLFW_KEY_UP) == GLFW.GLFW_PRESS) this.offset = Math.max(0, this.offset - 1.0f);
        if (GLFW.glfwGetKey(this.client.getWindow().getHandle(), GLFW.GLFW_KEY_DOWN) == GLFW.GLFW_PRESS) this.offset = Math.min(0, this.offset + 1.0f);
    }

    private void loadSkin(Identifier id, String username) {
        // Modern 1.21.4 skin loading is handled internally, but for custom URLs you'd use:
        // this.client.getTextureManager().registerTexture(id, new HttpTexture(...));
        // For now, we bind a placeholder or assume your custom texture manager handles it.
        // You can replace this with actual HttpTexture logic if needed.
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.searchField.mouseClicked(mouseX, mouseY, button);
        this.offset = Math.max(0, this.offset);

        double y = 38.0 - this.offset;
        for (AltAccount alt : this.getFilteredAlts()) {
            if (mouseX >= this.width / 2 - 125 && mouseX <= this.width / 1.5 && mouseY >= y - 4 && mouseY <= y + 20) {
                if (alt == this.selectedAlt) {
                    this.onLogin();
                    return true;
                }
                this.selectedAlt = alt;
            }
            y += 40.0;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.searchField.keyPressed(keyCode, scanCode, modifiers)) return true;
        if (keyCode == 9 || keyCode == 257) {
            this.searchField.setFocused(!this.searchField.isFocused());
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public void onLogin() {
        if (this.selectedAlt != null) {
            this.loginThread = new AltLoginThread(this.selectedAlt);
            this.loginThread.start();
        }
    }

    public void onRemove() {
        if (this.selectedAlt != null) {
            AltManager.removeAccount(this.selectedAlt);
            this.status = Formatting.GREEN + "Removed.";
            this.selectedAlt = null;
        }
    }

    public void onRandom() {
        String randomName = RandomUtils.randomString(RandomUtils.intRandom(5, 10));
        AltManager.addAccount(new AltAccount(randomName, ""));
        this.client.setSession(new Session(randomName, "", "", Session.AccountType.LEGACY.name()));
    }

    public void onClear() {
        AltManager.clearAccounts();
    }

    private List<AltAccount> getFilteredAlts() {
        ArrayList<AltAccount> altList = new ArrayList<>();
        String query = this.searchField.getText().toLowerCase();
        for (AltAccount alt : AltManager.registry) {
            if (!query.isEmpty() && !alt.getMask().toLowerCase().contains(query) && !alt.getUsername().toLowerCase().contains(query)) continue;
            altList.add(alt);
        }
        return altList;
    }

    @Override
    public boolean shouldPause() { return false; }
}
