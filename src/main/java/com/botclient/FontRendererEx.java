/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.ClickGuiScreen
 *  neo.deobf.DragState
 *  neo.deobf.BaseTextRenderer
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.client.renderer.vertex.VertexFormat
 *  org.lwjgl.opengl.GL11
 */
package com.botclient;

import java.awt.Color;
import java.awt.Font;
import com.botclient.ClickGuiScreen;
import com.botclient.DragState;
import com.botclient.BaseTextRenderer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.RenderSystem;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.texture.DynamicTexture;
import net.minecraft.client.render.vertex.DefaultVertexFormats;
import net.minecraft.client.render.vertex.VertexFormat;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class TextRendererEx
extends BaseTextRenderer {
    public float[] charWidthFloat;
    protected DragState[] boldItalicChars;
    protected DragState[] boldChars;
    protected DragState[] italicChars;
    public final byte[] glyphWidth;
    public final int[] colorCode = new int[32];

    public void drawStringWithOutline(String text, double x, double y, int color) {
        this.drawString(text, x - 0.5, y, (Color.BLACK).getRGB(), false);
        this.drawString(text, x + 0.5, y, (Color.BLACK).getRGB(), false);
        this.drawString(text, x, y - 0.5, (Color.BLACK).getRGB(), false);
        this.drawString(text, x, y + 0.5, (Color.BLACK).getRGB(), false);
        this.drawString(text, x, y, color, false);
    }

    public float drawGradientString(String text, double x, double y, int[] gradientColors, boolean shadow) {
        try {
            if (text == null) {
                return 0.0f;
            }
            x -= 1.0;
            text = this.fixStr(text);
            RenderSystem.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            RenderSystem.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            RenderSystem.glEnable((int)(3042));
            if (text == null) {
                return 0.0f;
            }
            float alpha = (float)(gradientColors[0] >> (24) & (255)) / 255.0f;
            x *= 2.0;
            y = (y - 3.0) * 2.0;
            RenderSystem.glPushMatrix();
            RenderSystem.scale((float)0.5f, (float)0.5f, (float)0.5f);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc((int)(770), (int)(771));
            RenderSystem.enableTexture2D();
            RenderSystem.bindTexture((int)(this.tex).getGlTextureId());
            RenderSystem.glBindTexture((int)(3553), (int)(this.tex).getGlTextureId());
            (this.bufferbuilder).begin(4, (VertexFormats.POSITION_TEXTURE));
            for (int i = 0; i < text.length(); ++i) {
                char character = text.charAt(i);
                if (String.valueOf(character).equals("§")) {
                    char next = text.charAt(i + (1));
                    int colorIndex = "0123456789abcdefklmnor".indexOf(next);
                    if (next == (114)) {
                        RenderSystem.color((float)((float)(gradientColors[0] >> (16) & (255)) / 255.0f), (float)((float)(gradientColors[0] >> (8) & (255)) / 255.0f), (float)((float)(gradientColors[0] & (255)) / 255.0f), (float)alpha);
                    } else if (colorIndex < (16)) {
                        RenderSystem.bindTexture((int)(this.tex).getGlTextureId());
                        if (colorIndex < 0) {
                            colorIndex = 15;
                        }
                        if (shadow) {
                            colorIndex += 16;
                        }
                        int colorcode = (this.colorCode)[colorIndex];
                        RenderSystem.color((float)((float)(colorcode >> (16) & (255)) / 255.0f), (float)((float)(colorcode >> (8) & (255)) / 255.0f), (float)((float)(colorcode & (255)) / 255.0f), (float)alpha);
                    }
                    ++i;
                    continue;
                }
                if (character >= (this.charData).length) continue;
                int colorIndex = Math.min(i, gradientColors.length - (1));
                int color = gradientColors[colorIndex];
                float charAlpha = (float)(color >> (24) & (255)) / 255.0f;
                RenderSystem.color((float)((float)(color >> (16) & (255)) / 255.0f), (float)((float)(color >> (8) & (255)) / 255.0f), (float)((float)(color & (255)) / 255.0f), (float)charAlpha);
                this.drawChar((this.charData), character, (float)x, (float)y);
                x += (double)((TextRendererEx.getCharData6(this)[character].width) - (8) + (this.charOffset));
            }
            (this.tessellator).draw();
            RenderSystem.glHint((int)(3155), (int)(4352));
            RenderSystem.glPopMatrix();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return (float)x / 2.0f;
    }

    public float drawString(String text, float x, float y, int color) {
        return this.drawString(text, x, y, color, false);
    }

    public float drawString(String text, double x, double y, int color, boolean shadow) {
        try {
            if (text == null) {
                return 0.0f;
            }
            x -= 1.0;
            text = this.fixStr(text);
            RenderSystem.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            RenderSystem.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            RenderSystem.glEnable((int)(3042));
            if (text == null) {
                return 0.0f;
            }
            if (color == (553648127)) {
                color = 16777215;
            }
            if ((color & (-67108864)) == 0) {
                color |= -16777216;
            }
            if (shadow) {
                color = (color & (16579836)) >> (2) | color & new Color(20, 20, 20, 200).getRGB();
            }
            float alpha = (float)(color >> (24) & (255)) / 255.0f;
            x *= 2.0;
            y = (y - 3.0) * 2.0;
            RenderSystem.glPushMatrix();
            RenderSystem.scale((float)0.5f, (float)0.5f, (float)0.5f);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc((int)(770), (int)(771));
            RenderSystem.color((float)((float)(color >> (16) & (255)) / 255.0f), (float)((float)(color >> (8) & (255)) / 255.0f), (float)((float)(color & (255)) / 255.0f), (float)alpha);
            RenderSystem.enableTexture2D();
            RenderSystem.bindTexture((int)(this.tex).getGlTextureId());
            RenderSystem.glBindTexture((int)(3553), (int)(this.tex).getGlTextureId());
            (this.bufferbuilder).begin(4, (VertexFormats.POSITION_TEXTURE));
            for (int i = 0; i < text.length(); ++i) {
                char character = text.charAt(i);
                if (String.valueOf(character).equals("§")) {
                    char next = text.charAt(i + (1));
                    int colorIndex = "0123456789abcdefklmnor".indexOf(next);
                    if (next == (114)) {
                        RenderSystem.color((float)((float)(color >> (16) & (255)) / 255.0f), (float)((float)(color >> (8) & (255)) / 255.0f), (float)((float)(color & (255)) / 255.0f), (float)alpha);
                    } else if (colorIndex < (16)) {
                        RenderSystem.bindTexture((int)(this.tex).getGlTextureId());
                        if (colorIndex < 0) {
                            colorIndex = 15;
                        }
                        if (shadow) {
                            colorIndex += 16;
                        }
                        int colorcode = (this.colorCode)[colorIndex];
                        RenderSystem.color((float)((float)(colorcode >> (16) & (255)) / 255.0f), (float)((float)(colorcode >> (8) & (255)) / 255.0f), (float)((float)(colorcode & (255)) / 255.0f), (float)alpha);
                    }
                    ++i;
                    continue;
                }
                if (character >= (this.charData).length) continue;
                this.drawChar((this.charData), character, (float)x, (float)y);
                x += (double)((TextRendererEx.getCharData4(this)[character].width) - (8) + (this.charOffset));
            }
            (this.tessellator).draw();
            RenderSystem.glHint((int)(3155), (int)(4352));
            RenderSystem.glPopMatrix();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return (float)x / 2.0f;
    }

    public void setFractionalMetrics(boolean fractionalMetrics) {
        super.setFractionalMetrics(fractionalMetrics);
    }

    public TextRendererEx(Font font, boolean antiAlias, boolean fractionalMetrics) {
        super(font, antiAlias, fractionalMetrics);
        this.boldChars = new DragState[1110];
        this.italicChars = new DragState[1110];
        this.boldItalicChars = new DragState[1110];
        this.glyphWidth = new byte[65536];
        this.charWidthFloat = new float[256];
        for (int index = 0; index < (32); ++index) {
            int noClue = (index >> (3) & (1)) * (85);
            int red = (index >> (2) & (1)) * (170) + noClue;
            int green = (index >> (1) & (1)) * (170) + noClue;
            int blue = (index & (1)) * (170) + noClue;
            if (index == (6)) {
                red += 85;
            }
            if (index >= (16)) {
                red /= 4;
                green /= 4;
                blue /= 4;
            }
            this.colorCode[index] = (red & (255)) << (16) | (green & (255)) << (8) | blue & (255);
        }
    }

    public float drawCenteredStringWithShadow(String text, float x, float y, int color) {
        return this.drawStringWithShadow(text, x - (float)this.getStringWidth(text) / 2.0f, y, color);
    }

    public void setFont(Font font) {
        super.setFont(font);
    }

    public String fixStr(String input) {
        char[] buffer;
        StringBuilder builder = new StringBuilder();
        char[] cArray = buffer = input.toCharArray();
        int n = cArray.length;
        for (int i = 0; i < n; ++i) {
            char c = cArray[i];
            if (c >= (this.charData).length || (this.charData)[c] == null) continue;
            builder.append(c);
        }
        return builder.toString();
    }

    public float drawStringWithShadow(String text, double x, double y, int color) {
        float shadowWidth = this.drawString(text, x + 0.5, y + 0.5, color, true);
        return Math.max(shadowWidth, this.drawString(text, x, y, color, false));
    }

    public void setAntiAlias(boolean antiAlias) {
        super.setAntiAlias(antiAlias);
    }

    public static void drawStringWithOutline(TextRendererEx fontRenderer, String text, float x, float y, int color) {
        fontRenderer.drawString(text, x - 0.800000012f, y, (Color.BLACK).getRGB());
        fontRenderer.drawString(text, x + 0.800000012f, y, (Color.BLACK).getRGB());
        fontRenderer.drawString(text, x, y - 0.800000012f, (Color.BLACK).getRGB());
        fontRenderer.drawString(text, x, y + 0.800000012f, (Color.BLACK).getRGB());
        fontRenderer.drawString(text, x, y, color);
    }

    private static DragState[] getCharData4(TextRendererEx instance) {
        return instance.charData;
    }

    public float drawCenteredString(String text, float x, float y, int color, boolean shadow) {
        return this.drawString(text, x - (float)this.getStringWidth(text) / 2.0f, y, color, shadow);
    }

    private static DragState[] getCharData6(TextRendererEx instance) {
        return instance.charData;
    }

    public String trimStringToWidth(String text, int width) {
        return this.trimStringToWidth(text, width, false);
    }

    public float drawCenteredString(String text, float x, float y, int color) {
        return this.drawString(text, x - (float)this.getStringWidth(text) / 2.0f, y, color);
    }

    public void drawCenteredStringWithOutline(String text, float x, float y, int color) {
        this.drawCenteredString(text, x - 0.5f, y, (Color.BLACK).getRGB());
        this.drawCenteredString(text, x + 0.5f, y, (Color.BLACK).getRGB());
        this.drawCenteredString(text, x, y - 0.5f, (Color.BLACK).getRGB());
        this.drawCenteredString(text, x, y + 0.5f, (Color.BLACK).getRGB());
        this.drawCenteredString(text, x, y, color);
    }

    public void drawGradientThemeString(String text, float x, float y) {
        int offset = 0;
        char[] cArray = text.toCharArray();
        int n = cArray.length;
        for (int i = 0; i < n; ++i) {
            char char1 = cArray[i];
            this.drawString(String.valueOf(char1), x + (float)offset, y, ClickGuiScreen.getC((int)offset).getRGB());
            offset += this.getStringWidth(String.valueOf(char1));
        }
    }

    private float callIntBitsToFloat(char p_getCharWidthFloat_1_) {
        if (p_getCharWidthFloat_1_ == (167)) {
            return -1.0f;
        }
        if (p_getCharWidthFloat_1_ != (32) && p_getCharWidthFloat_1_ != (160)) {
            int i = "ГЂГЃГ‚Г€ГЉГ‹ГЌГ“Г”Г•ГљГџГЈГµДџД°Д±Е’Е“ЕћЕџЕґЕµЕѕИ‡        !\\\\\\\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ Г‡ГјГ©ГўГ¤Г ГҐГ§ГЄГ«ГЁГЇГ®Г¬Г„Г…Г‰Г¦Г†ГґГ¶ГІГ»Г№ГїГ–ГњГёВЈГГ—Ж’ГЎГ­ГіГєГ±Г‘ВЄВєВїВ®В¬ВЅВјВЎВ«В»в–‘в–’в–“в”‚в”¤в•Ўв•ўв•–в••в•Јв•‘в•—в•ќв•њв•›в”ђв””в”ґв”¬в”њв”Ђв”јв•ћв•џв•љв•”в•©в•¦в• в•ђв•¬в•§в•Ёв•¤в•Ґв•™в•в•’в•“в•«в•Єв”в”Њв–€в–„в–Њв–ђв–ЂО±ОІО“ПЂОЈПѓОјП„О¦ОО©Оґв€ћв€…в€€в€©в‰ЎВ±в‰Ґв‰¤вЊ вЊЎГ·в‰€В°в€™В·в€љвЃїВІв–  ".indexOf(p_getCharWidthFloat_1_);
            if (p_getCharWidthFloat_1_ > '\u0000' && i != (-1)) {
                return (this.charWidthFloat)[i];
            }
            if ((this.glyphWidth)[p_getCharWidthFloat_1_] != 0) {
                int j = (this.glyphWidth)[p_getCharWidthFloat_1_] & (255);
                int k = j >>> (4);
                int l = j & (15);
                return (++l - k) / (2) + (1);
            }
            return 0.0f;
        }
        return (this.charWidthFloat)[32];
    }

    public void drawCenteredGradientThemeString(String text, float x, float y) {
        this.drawGradientThemeString(text, x - (float)this.getStringWidth(text) / 2.0f, y);
    }

    private static DragState[] getCharData10(TextRendererEx instance) {
        return instance.charData;
    }

    public String trimStringToWidth(String text, int width, boolean reverse) {
        StringBuilder stringbuilder = new StringBuilder();
        float f = 0.0f;
        int i = reverse ? text.length() - (1) : 0;
        int j = reverse ? -1 : 1;
        int flag = 0;
        int flag1 = 0;
        for (int k = i; k >= 0 && k < text.length() && f < (float)width; k += j) {
            char c0 = text.charAt(k);
            float f1 = this.callIntBitsToFloat(c0);
            if (flag != 0) {
                flag = 0;
                if (c0 != (108) && c0 != (76)) {
                    if (c0 == (114) || c0 == (82)) {
                        flag1 = 0;
                    }
                } else {
                    flag1 = 1;
                }
            } else if (f1 < 0.0f) {
                flag = 1;
            } else {
                f += f1;
                if (flag1 != 0) {
                    f += 1.0f;
                }
            }
            if (f > (float)width) break;
            if (reverse) {
                stringbuilder.insert(0, c0);
                continue;
            }
            stringbuilder.append(c0);
        }
        return stringbuilder.toString();
    }

    public void drawCenteredStringWithOutline(TextRendererEx fontRenderer, String text, float x, float y, int color) {
        this.drawCenteredString(text, x - 1.0f, y, (Color.BLACK).getRGB());
        this.drawCenteredString(text, x + 1.0f, y, (Color.BLACK).getRGB());
        this.drawCenteredString(text, x, y - 1.0f, (Color.BLACK).getRGB());
        this.drawCenteredString(text, x, y + 1.0f, (Color.BLACK).getRGB());
        this.drawCenteredString(text, x, y, color);
    }

    private void drawLine(double x, double y, double x1, double y1, float width) {
        RenderSystem.glDisable((int)(3553));
        RenderSystem.glLineWidth((float)width);
        RenderSystem.glBegin((int)(1));
        RenderSystem.glVertex2d((double)x, (double)y);
        RenderSystem.glVertex2d((double)x1, (double)y1);
        RenderSystem.glEnd();
        RenderSystem.glEnable((int)(3553));
    }

    public int getStringWidth(String text) {
        int x = 0;
        if (text == null) {
            return 0;
        }
        text = this.fixStr(text);
        for (int i = 0; i < text.length(); ++i) {
            char character = text.charAt(i);
            if (character == (167)) {
                ++i;
                continue;
            }
            if (character >= (this.charData).length) continue;
            x += (TextRendererEx.getCharData10(this)[character].width) - (8) + (this.charOffset);
        }
        return x / (2);
    }
}

