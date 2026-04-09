/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.DragState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.util.ResourceLocation
 */
package com.botclient;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import com.botclient.DragState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.texture.DynamicTexture;
import net.minecraft.util.Identifier;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class BaseTextRenderer {
    public DynamicTexture tex;
    public boolean fractionalMetrics;
    protected final Tessellator tessellator = BufferRenderer.getAvailableRenderer();
    public boolean antiAlias;
    private final int imageSize = 512;
    public final BufferBuilder bufferbuilder = this.tessellator.getBuffer();
    public int charOffset;
    public DragState[] charData;
    public int fontHeight;
    public Font font;

    public Font getFont() {
        return (this.font);
    }

    public void setAntiAlias(boolean antiAlias) {
        if ((this.antiAlias) != antiAlias) {
            this.antiAlias = antiAlias;
            this.tex = this.setupTexture(BaseTextRenderer.getFont2(this), antiAlias, BaseTextRenderer.getFractionalMetrics2(this), BaseTextRenderer.getCharData3(this));
        }
    }

    private static boolean getAntiAlias(BaseTextRenderer instance) {
        return instance.antiAlias;
    }

    public void setFractionalMetrics(boolean fractionalMetrics) {
        if ((this.fractionalMetrics) != fractionalMetrics) {
            this.fractionalMetrics = fractionalMetrics;
            this.tex = this.setupTexture(BaseTextRenderer.getFont(this), BaseTextRenderer.getAntiAlias2(this), fractionalMetrics, BaseTextRenderer.getCharData2(this));
        }
    }

    private static Font getFont(BaseTextRenderer instance) {
        return instance.font;
    }

    private static DragState[] getCharData(BaseTextRenderer instance) {
        return instance.charData;
    }

    private static boolean getFractionalMetrics2(BaseTextRenderer instance) {
        return instance.fractionalMetrics;
    }

    private static int getFontHeight(BaseTextRenderer instance) {
        return instance.fontHeight;
    }

    private static void setFractionalMetrics(BaseTextRenderer ef, boolean value) {
        ef.fractionalMetrics = value;
    }

    protected DynamicTexture setupTexture(Font font, boolean antiAlias, boolean fractionalMetrics, DragState[] chars) {
        BufferedImage img = this.generateFontImage(font, antiAlias, fractionalMetrics, chars);
        try {
            return new DynamicTexture(img);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static DragState[] getCharData2(BaseTextRenderer instance) {
        return instance.charData;
    }

    protected void drawQuad(float x, float y, float width, float height, float srcX, float srcY, float srcWidth, float srcHeight) {
        float renderSRCX = srcX / 512.0f;
        float renderSRCY = srcY / 512.0f;
        float renderSRCWidth = srcWidth / 512.0f;
        float renderSRCHeight = srcHeight / 512.0f;
        (this.bufferbuilder).pos((double)(x + width), (double)y, 0.0).tex((double)(renderSRCX + renderSRCWidth), (double)renderSRCY).endVertex();
        (this.bufferbuilder).pos((double)x, (double)y, 0.0).tex((double)renderSRCX, (double)renderSRCY).endVertex();
        (this.bufferbuilder).pos((double)x, (double)(y + height), 0.0).tex((double)renderSRCX, (double)(renderSRCY + renderSRCHeight)).endVertex();
        (this.bufferbuilder).pos((double)x, (double)(y + height), 0.0).tex((double)renderSRCX, (double)(renderSRCY + renderSRCHeight)).endVertex();
        (this.bufferbuilder).pos((double)(x + width), (double)(y + height), 0.0).tex((double)(renderSRCX + renderSRCWidth), (double)(renderSRCY + renderSRCHeight)).endVertex();
        (this.bufferbuilder).pos((double)(x + width), (double)y, 0.0).tex((double)(renderSRCX + renderSRCWidth), (double)renderSRCY).endVertex();
    }

    private static Font getFont2(BaseTextRenderer instance) {
        return instance.font;
    }

    public static Font readFontFromFile(String fontName, float size) {
        try {
            Font font = Font.createFont(0, MinecraftClient.getInstance().getResourceManager().getResource(new Identifier("neoware/fonts/" + fontName)).getInputStream());
            return font.deriveFont(size);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean getFractionalMetrics3(BaseTextRenderer instance) {
        return instance.fractionalMetrics;
    }

    public BaseTextRenderer(Font font, boolean antiAlias, boolean fractionalMetrics) {
        this.imageSize = 512;
        this.charData = new DragState[1110];
        this.fontHeight = -1;
        this.charOffset = 0;
        this.font = font;
        this.antiAlias = antiAlias;
        this.fractionalMetrics = fractionalMetrics;
        this.tex = this.setupTexture(font, antiAlias, fractionalMetrics, this.charData);
    }

    public int getStringWidth(String text) {
        int width = 0;
        char[] cArray = text.toCharArray();
        int n = cArray.length;
        for (int i = 0; i < n; ++i) {
            char c = cArray[i];
            if (c >= (this.charData).length) continue;
            width += (BaseTextRenderer.getCharData5(this)[c].width) - (8) + (this.charOffset);
        }
        return width / (2);
    }

    public void drawChar(DragState[] chars, char c, float x, float y) throws ArrayIndexOutOfBoundsException {
        try {
            this.drawQuad(x, y, (chars[c].width), (chars[c].height), (chars[c].storedX), (chars[c].storedY), (chars[c].width), (chars[c].height));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getHeight2(DragState instance) {
        return instance.height;
    }

    public int getStringHeight(String text) {
        return this.getFontHeight();
    }

    protected BufferedImage generateFontImage(Font font, boolean antiAlias, boolean fractionalMetrics, DragState[] chars) {
        int imgSize = 512;
        BufferedImage bufferedImage = new BufferedImage(imgSize, imgSize, 2);
        Graphics2D g = (Graphics2D)bufferedImage.getGraphics();
        g.setFont(font);
        g.setColor(new Color(255, 255, 255, 0));
        g.fillRect(0, 0, imgSize, imgSize);
        g.setColor((Color.WHITE));
        g.setRenderingHint((RenderingHints.KEY_FRACTIONALMETRICS), (RenderingHints.VALUE_FRACTIONALMETRICS_ON));
        g.setRenderingHint((RenderingHints.KEY_TEXT_ANTIALIASING), (RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        g.setRenderingHint((RenderingHints.KEY_ANTIALIASING), (RenderingHints.VALUE_ANTIALIAS_ON));
        FontMetrics fontMetrics = g.getFontMetrics();
        int charHeight = 0;
        int positionX = 0;
        int positionY = 1;
        for (int i = 0; i < chars.length; ++i) {
            char ch = (char)i;
            if (ch > (1038) || ch < (256)) {
                DragState charData = new DragState();
                Rectangle2D dimensions = fontMetrics.getStringBounds(String.valueOf(ch), g);
                charData.width = BaseTextRenderer.getWidth6(dimensions.getBounds()) + (8);
                charData.height = BaseTextRenderer.getHeight3(dimensions.getBounds());
                if (positionX + (charData.width) >= imgSize) {
                    positionX = 0;
                    positionY += charHeight;
                    charHeight = 0;
                }
                if ((charData.height) > charHeight) {
                    charHeight = (charData.height);
                }
                charData.storedX = positionX;
                charData.storedY = positionY;
                if ((charData.height) > (this.fontHeight)) {
                    this.fontHeight = BaseTextRenderer.getHeight2(charData);
                }
                chars[i] = charData;
                g.drawString(String.valueOf(ch), positionX + (2), positionY + fontMetrics.getAscent());
                positionX += (charData.width);
                continue;
            }
            chars[i] = null;
        }
        return bufferedImage;
    }

private static int getHeight3(Rectangle rectangle) {
        return rectangle.height;
    }

    private static void setAntiAlias(BaseTextRenderer ef, boolean value) {
        ef.antiAlias = value;
    }

    private static DragState[] getCharData3(BaseTextRenderer instance) {
        return instance.charData;
    }

    public int getFontHeight() {
        return ((this.fontHeight) - (8)) / (2);
    }

    public void setFont(Font font) {
        this.font = font;
        this.tex = this.setupTexture(font, BaseTextRenderer.getAntiAlias(this), BaseTextRenderer.getFractionalMetrics3(this), BaseTextRenderer.getCharData(this));
    }

    private static DragState[] getCharData5(BaseTextRenderer instance) {
        return instance.charData;
    }

    private static int getWidth6(Rectangle rectangle) {
        return rectangle.width;
    }

    private static void setFont(BaseTextRenderer ef, Font font) {
        ef.font = font;
    }

    private static boolean getAntiAlias2(BaseTextRenderer instance) {
        return instance.antiAlias;
    }

}

