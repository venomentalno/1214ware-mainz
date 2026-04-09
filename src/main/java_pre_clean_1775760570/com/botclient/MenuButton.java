/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.AnimationUtils
 *  neo.deobf.TextRendererEx
 *  neo.deobf.FontRegistry
 *  neo.deobf.RoundedUtils
 */
package com.botclient;

import java.awt.Color;
import com.botclient.AnimationUtils;
import com.botclient.TextRendererEx;
import com.botclient.FontRegistry;
import com.botclient.RoundedUtils;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class MenuButton {
    public final String text;
    public float sizeAnimation;
    public final int height;
    public final int width;
    public float colorAnimation;
    public final int id;
    public final int y;
    public final int x;

    public MenuButton(int id, int x, int y, int width, int height, String text) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void render(int mouseX, int mouseY) {
        this.colorAnimation = AnimationUtils.animation((float)MenuButton.getColorAnimation3(this), (float)(this.isHovered(mouseX, mouseY) ? 230 : 180), (float)5.50000004E-06f);
        this.sizeAnimation = AnimationUtils.animation((float)MenuButton.getSizeAnimation2(this), (float)(this.isHovered(mouseX, mouseY) ? 2 : 0), (float)5.50000004E-06f);
        RoundedUtils.drawGradientRound((float)((float)((this.x) - (this.width) / (2)) - (this.sizeAnimation)), (float)((this.y) - (this.height) / (2)), (float)((float)(this.width) + (this.sizeAnimation) * 2.0f), (float)(this.height), (float)4.0f, (Color)new Color(30, 30, 30, 255), (Color)new Color(30, 30, 30, 255), (Color)new Color(155, 155, 155, 255), (Color)new Color(30, 30, 30, 255));
        (FontRegistry.mnstb_15).drawCenteredString((this.text), (float)(this.x), (float)((this.y) - (2)), new Color((int)(this.colorAnimation), (int)(this.colorAnimation), (int)(this.colorAnimation)).getRGB());
    }

    private static float getSizeAnimation2(MenuButton instance) {
        return instance.sizeAnimation;
    }

    private static float getColorAnimation3(MenuButton instance) {
        return instance.colorAnimation;
    }

    private static int getId(MenuButton instance) {
        return instance.id;
    }

    public int getId() {
        return (this.id);
    }

    public boolean isHovered(int mouseX, int mouseY) {
        return (mouseX >= (this.x) - (this.width) / (2) && mouseX <= (this.x) - (this.width) / (2) + (this.width) && mouseY >= (this.y) - (this.height) / (2) && mouseY <= (this.y) - (this.height) / (2) + (this.height) ? 1 : 0) != 0;
    }

}

