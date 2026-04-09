/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.RoundedUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.TextRenderer
 *  net.minecraft.client.gui.ButtonWidget
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.ResourceLocation
 */
package com.botclient;

import java.awt.Color;
import com.botclient.RoundedUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.RenderSystem;
import net.minecraft.util.Identifier;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class NeoButton
extends ButtonWidget {
    public int opacity = 40;

    private static int getOpacity2(NeoButton instance) {
        return instance.opacity;
    }

    private static int getY(NeoButton instance) {
        return instance.y;
    }

    private static int getX3(NeoButton instance) {
        return instance.x;
    }

    private static int getOpacity6(NeoButton instance) {
        return instance.opacity;
    }

    private static int getX5(NeoButton instance) {
        return instance.x;
    }

    private static int getWidth(NeoButton instance) {
        return instance.width;
    }

    private static int getY4(NeoButton instance) {
        return instance.y;
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY, float mouseButton) {
        if ((this.visible)) {
            mc.getTextureManager().bindTexture((BUTTON_TEXTURES));
            RenderSystem.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.hovered = (mouseX >= NeoButton.getX5(this) && mouseY >= NeoButton.getY(this) && mouseX < NeoButton.getX3(this) + NeoButton.getWidth(this) && mouseY < NeoButton.getY4(this) + NeoButton.getHeight3(this) ? 1 : 0) != 0;
            if ((this.hovered)) {
                if ((this.opacity) < (40)) {
                    NeoButton bm = this;
                    bm.opacity = NeoButton.getOpacity2(bm) + (2);
                }
            } else if ((this.opacity) > (22)) {
                NeoButton bm = this;
                bm.opacity = NeoButton.getOpacity6(bm) - (2);
            }
            int flag = mouseX >= (this.x) && mouseY >= (this.y) && mouseX < (this.x) + (this.width) && mouseY < (this.y) + (this.height) ? 1 : 0;
            Color color = new Color(30, 30, 30, 240);
            RenderSystem.enableBlend();
            RenderSystem.tryBlendFuncSeparate((int)(770), (int)(771), (int)(1), (int)(0));
            RenderSystem.blendFunc((int)(770), (int)(771));
            RoundedUtils.drawRound((float)(this.x), (float)(this.y), (float)(this.width), (float)(this.height), (float)3.0f, (Color)new Color((this.opacity), (this.opacity), (this.opacity), 88));
            (MinecraftClient.getInstance().fontRenderer).drawCenteredString((this.displayString), (double)((this.x) + (this.width) / (2)), (double)((this.y) + ((this.height) - (2)) / (3)), -1);
            this.mouseDragged(mc, mouseX, mouseY);
        }
    }

    public NeoButton(int buttonId, int x, int y, String buttonText) {
        this(buttonId, x, y, 200, 20, buttonText);
    }

    private static int getHeight3(NeoButton instance) {
        return instance.height;
    }

    public NeoButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
    }

}

