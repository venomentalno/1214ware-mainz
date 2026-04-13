/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.MathUtils
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.math.MathHelper
 */
package neo.deobf;

import java.awt.Color;
import java.awt.image.BufferedImage;
import neo.deobf.MathUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;

public class ColorUtils {
    public static Color TwoColorEffect(Color cl1, Color cl2, double speed, int index) {
        int angle = (int)(((double)System.currentTimeMillis() / speed + (double)index) % 360.0);
        angle = (angle >= (180) ? (360) - angle : angle) * (2);
        return ColorUtils.interpolateColorC(cl1, cl2, (float)angle / 360.0f);
    }

    public static int rainbow(int delay, double speed) {
        double rainbow = Math.ceil((double)(System.currentTimeMillis() + (long)delay) / speed);
        return Color.getHSBColor((float)(-((rainbow %= 360.0) / 360.0)), 0.899999976f, 1.0f).getRGB();
    }

    public static Color fade(String s, String s1, String s2, String s3) {
        return null;
    }

    public static float[] rgbToHSL(Color rgb) {
        float red = (float)rgb.getRed() / 255.0f;
        float green = (float)rgb.getGreen() / 255.0f;
        float blue = (float)rgb.getBlue() / 255.0f;
        float max = Math.max(Math.max(red, green), blue);
        float min2 = Math.min(Math.min(red, green), blue);
        float c = (max + min2) / 2.0f;
        float[] fArray = new float[3];
        fArray[0] = c;
        fArray[1] = c;
        fArray[2] = c;
        float[] hsl = fArray;
        if (max == min2) {
            hsl[1] = 0.0f;
            hsl[0] = 0.0f;
        } else {
            float d = max - min2;
            float f = (double)hsl[2] > 0.5 ? d / (2.0f - max - min2) : d / (max + min2);
            hsl[1] = f;
            float f2 = f;
            if (max == red) {
                hsl[0] = (green - blue) / d + (float)(green < blue ? 6 : 0);
            } else if (max == blue) {
                hsl[0] = (blue - red) / d + 2.0f;
            } else if (max == green) {
                hsl[0] = (red - green) / d + 4.0f;
            }
            hsl[0] = hsl[0] / 6.0f;
        }
        return hsl;
    }

    public static Color TwoColorEffectStatic(Color cl1, Color cl2, int index) {
        int angle = index % (360);
        angle = (angle >= (180) ? (360) - angle : angle) * (2);
        return ColorUtils.interpolateColorC(cl1, cl2, (float)angle / 360.0f);
    }

    public static Color skyRainbow(int speed, int index, float saturation) {
        int n;
        int angle = (int)((System.currentTimeMillis() / (long)speed + (long)index) % 360L);
        float hue = (float)angle / 360.0f;
        angle = (int)((double)angle % 360.0);
        return Color.getHSBColor((double)((float)((double)n / 360.0)) < 0.5 ? -((float)((double)angle / 360.0)) : (float)((double)angle / 360.0), saturation, 1.0f);
    }

    public static int getColor(int red, int green, int blue, int alpha) {
        int color = 0;
        color |= alpha << (24);
        color |= red << (16);
        color |= green << (8);
        return color |= blue;
    }

    public static int applyOpacity(int rgb) {
        return 0;
    }

    public static void glColor(int hex, float alpha) {
        float red = (float)(hex >> (16) & (255)) / 255.0f;
        float green = (float)(hex >> (8) & (255)) / 255.0f;
        float blue = (float)(hex & (255)) / 255.0f;
        GlStateManager.color((float)red, (float)green, (float)blue, (float)(alpha / 255.0f));
    }

    public static int applyOpacity(int color, float opacity) {
        Color old = new Color(color);
        return ColorUtils.applyOpacity(old, opacity).getRGB();
    }

    public static Color fade(int speed, int index, Color color, float alpha) {
        float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        int angle = (int)((System.currentTimeMillis() / (long)speed + (long)index) % 360L);
        angle = (angle > (180) ? (360) - angle : angle) + (180);
        Color colorHSB = new Color(Color.HSBtoRGB(hsb[0], hsb[1], (float)angle / 360.0f));
        return new Color(colorHSB.getRed(), colorHSB.getGreen(), colorHSB.getBlue(), Math.max(0, Math.min(255, (int)(alpha * 255.0f))));
    }

    public static int setAlpha(int color, int alpha) {
        Color c = new Color(color);
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha).getRGB();
    }

    public static Color rainbow(int speed, int index, float saturation, float brightness, float opacity) {
        int angle = (int)((System.currentTimeMillis() / (long)speed + (long)index) % 360L);
        float hue = (float)angle / 360.0f;
        Color color = new Color(Color.HSBtoRGB(hue, saturation, brightness));
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.max(0, Math.min(255, (int)(opacity * 255.0f))));
    }

    public static Color TwoColorEffect(Color cl1, Color cl2, double speed) {
        double thing = speed / 4.0 % 1.0;
        float val = MathHelper.clamp((float)((float)Math.sin(18.849555921538759 * thing) / 2.0f + 0.5f), (float)0.0f, (float)1.0f);
        return new Color(MathUtils.lerp((double)((float)cl1.getRed() / 255.0f), (double)((float)cl2.getRed() / 255.0f), (double)val), MathUtils.lerp((double)((float)cl1.getGreen() / 255.0f), (double)((float)cl2.getGreen() / 255.0f), (double)val), MathUtils.lerp((double)((float)cl1.getBlue() / 255.0f), (double)((float)cl2.getBlue() / 255.0f), (double)val));
    }

    public static int getColor(int bright) {
        return ColorUtils.getColor(bright, bright, bright, 255);
    }

    public static void glColor(int hex) {
        float alpha = (float)(hex >> (24) & (255)) / 255.0f;
        float red = (float)(hex >> (16) & (255)) / 255.0f;
        float green = (float)(hex >> (8) & (255)) / 255.0f;
        float blue = (float)(hex & (255)) / 255.0f;
        GlStateManager.color((float)red, (float)green, (float)blue, (float)alpha);
    }

    public static int[] createColorArray(int color) {
        int[] nArray = new int[4];
        nArray[0] = (color >> 16 & (255));
        nArray[1] = (color >> 8 & (255));
        nArray[2] = (color >> 0 & (255));
        nArray[3] = (color >> 24 & (255));
        return nArray;
    }

    public static int getOppositeColor(int color) {
        int R = (color >> 0 & (255));
        int G = (color >> 8 & (255));
        int B = (color >> 16 & (255));
        int A2 = (color >> 24 & (255));
        R = (255) - R;
        G = (255) - G;
        B = (255) - B;
        return R + (G << (8)) + (B << (16)) + (A2 << (24));
    }

    public static Color astolfoRainbow(int offset) {
        float f;
        float hue;
        float speed = 3000.0f;
        for (hue = (float)(System.currentTimeMillis() % (long)((int)speed) + (long)offset); hue > speed; hue -= speed) {
        }
        hue /= speed;
        if ((double)f > 0.5) {
            hue = 0.5f - (hue - 0.5f);
        }
        return Color.getHSBColor(hue += 0.5f, 0.400000006f, 1.0f);
    }

    public static Color mixColors(Color color1, Color color2, double percent) {
        double inverse_percent = 1.0 - percent;
        int redPart = (int)((double)color1.getRed() * percent + (double)color2.getRed() * inverse_percent);
        int greenPart = (int)((double)color1.getGreen() * percent + (double)color2.getGreen() * inverse_percent);
        int bluePart = (int)((double)color1.getBlue() * percent + (double)color2.getBlue() * inverse_percent);
        return new Color(redPart, greenPart, bluePart);
    }

    public static Color fade2(int speed, int index, Color color, float alpha) {
        float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        int angle = (int)((System.currentTimeMillis() / (long)speed + (long)index) % 360L);
        angle = (angle > (180) ? (360) - angle : angle) + (180);
        Color colorHSB = new Color(Color.HSBtoRGB(hsb[0], hsb[1], (float)angle / 360.0f));
        return new Color(colorHSB.getRed(), colorHSB.getGreen(), colorHSB.getBlue(), Math.max(0, Math.min(255, (int)(alpha * 255.0f))));
    }

    public static Color darker(Color color, float FACTOR) {
        return new Color(Math.max((int)((float)color.getRed() * FACTOR), 0), Math.max((int)((float)color.getGreen() * FACTOR), 0), Math.max((int)((float)color.getBlue() * FACTOR), 0), color.getAlpha());
    }

    public static void glColor(Color color) {
        float red = (float)color.getRed() / 255.0f;
        float green = (float)color.getGreen() / 255.0f;
        float blue = (float)color.getBlue() / 255.0f;
        float alpha = (float)color.getAlpha() / 255.0f;
        GlStateManager.color((float)red, (float)green, (float)blue, (float)alpha);
    }

    public static Color applyOpacity(Color color, float opacity) {
        opacity = Math.min(1.0f, Math.max(0.0f, opacity));
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)((float)color.getAlpha() * opacity));
    }

    public static int fade(Color color, int delay) {
        float[] hsb = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
        float brightness = Math.abs((float)(System.currentTimeMillis() % 2000L + (long)delay) / 1000.0f % 2.0f - 1.0f);
        brightness = 0.5f + 0.5f * brightness;
        hsb[2] = brightness % 2.0f;
        return Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
    }

    public static Color TwoColoreffect(Color cl1, Color cl2, double speed) {
        double thing = speed / 4.0 % 1.0;
        float val = MathHelper.clamp((float)((float)Math.sin(18.849555921538759 * thing) / 2.0f + 0.5f), (float)0.0f, (float)1.0f);
        return new Color(MathUtils.lerp((double)((float)cl1.getRed() / 255.0f), (double)((float)cl2.getRed() / 255.0f), (double)val), MathUtils.lerp((double)((float)cl1.getGreen() / 255.0f), (double)((float)cl2.getGreen() / 255.0f), (double)val), MathUtils.lerp((double)((float)cl1.getBlue() / 255.0f), (double)((float)cl2.getBlue() / 255.0f), (double)val));
    }

    public static Color brighter(Color color, float FACTOR) {
        int r = color.getRed();
        int g2 = color.getGreen();
        int b = color.getBlue();
        int alpha = color.getAlpha();
        int i = (int)(1.0 / (1.0 - (double)FACTOR));
        if (r == 0 && g2 == 0 && b == 0) {
            return new Color(i, i, i, alpha);
        }
        if (r > 0 && r < i) {
            r = i;
        }
        if (g2 > 0 && g2 < i) {
            g2 = i;
        }
        if (b > 0 && b < i) {
            b = i;
        }
        return new Color(Math.min((int)((float)r / FACTOR), 255), Math.min((int)((float)g2 / FACTOR), 255), Math.min((int)((float)b / FACTOR), 255), alpha);
    }

    public static Color interpolateColorsBackAndForth(int speed, int index, Color start, Color end, boolean trueColor) {
        int angle = (int)((System.currentTimeMillis() / (long)speed + (long)index) % 360L);
        angle = (angle >= (180) ? (360) - angle : angle) * (2);
        return trueColor ? ColorUtils.interpolateColorHue(start, end, (float)angle / 360.0f) : ColorUtils.interpolateColorC(start, end, (float)angle / 360.0f);
    }

    public static Color hslToRGB(float[] hsl) {
        float red;
        float green;
        float blue;
        if (hsl[1] == 0.0f) {
            blue = 1.0f;
            green = 1.0f;
            red = 1.0f;
        } else {
            float q = (double)hsl[2] < 0.5 ? hsl[2] * (1.0f + hsl[1]) : hsl[2] + hsl[1] - hsl[2] * hsl[1];
            float p = 2.0f * hsl[2] - q;
            red = ColorUtils.hueToRGB(p, q, hsl[0] + 0.333333343f);
            green = ColorUtils.hueToRGB(p, q, hsl[0]);
            blue = ColorUtils.hueToRGB(p, q, hsl[0] - 0.333333343f);
        }
        return new Color((int)(red *= 255.0f), (int)(green *= 255.0f), (int)(blue *= 255.0f));
    }

    public static Color averageColor(BufferedImage bi, int width, int height, int pixelStep) {
        int[] color = new int[3];
        for (int x = 0; x < width; x += pixelStep) {
            for (int y = 0; y < height; y += pixelStep) {
                Color pixel = new Color(bi.getRGB(x, y));
                color[0] = color[0] + pixel.getRed();
                color[1] = color[1] + pixel.getGreen();
                color[2] = color[2] + pixel.getBlue();
            }
        }
        int num = width * height / (pixelStep * pixelStep);
        return new Color(color[0] / num, color[1] / num, color[2] / num);
    }

    public static Color[] getAnalogousColor(Color color) {
        Color[] colors = new Color[2];
        float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        float degree = 0.0833333358f;
        float newHueAdded = hsb[0] + degree;
        colors[0] = new Color(Color.HSBtoRGB(newHueAdded, hsb[1], hsb[2]));
        float newHueSubtracted = hsb[0] - degree;
        colors[1] = new Color(Color.HSBtoRGB(newHueSubtracted, hsb[1], hsb[2]));
        return colors;
    }

    public static Color interpolateColorHue(Color color1, Color color2, float amount) {
        amount = Math.min(1.0f, Math.max(0.0f, amount));
        float[] color1HSB = Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), null);
        float[] color2HSB = Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), null);
        Color resultColor = Color.getHSBColor(MathUtils.interpolateFloat((float)color1HSB[0], (float)color2HSB[0], (double)amount), MathUtils.interpolateFloat((float)color1HSB[1], (float)color2HSB[1], (double)amount), MathUtils.interpolateFloat((float)color1HSB[2], (float)color2HSB[2], (double)amount));
        return new Color(resultColor.getRed(), resultColor.getGreen(), resultColor.getBlue(), MathUtils.interpolateInt((int)color1.getAlpha(), (int)color2.getAlpha(), (double)amount));
    }

    public static Color interpolateColorC(Color color1, Color color2, float amount) {
        amount = Math.min(1.0f, Math.max(0.0f, amount));
        return new Color(MathUtils.interpolateInt((int)color1.getRed(), (int)color2.getRed(), (double)amount), MathUtils.interpolateInt((int)color1.getGreen(), (int)color2.getGreen(), (double)amount), MathUtils.interpolateInt((int)color1.getBlue(), (int)color2.getBlue(), (double)amount), MathUtils.interpolateInt((int)color1.getAlpha(), (int)color2.getAlpha(), (double)amount));
    }

    private static float getAnimationEquation(int index, int speed) {
        int angle = (int)((System.currentTimeMillis() / (long)speed + (long)index) % 360L);
        return (float)((angle > (180) ? (360) - angle : angle) + (180)) / 360.0f;
    }

    public static float hueToRGB(float p, float q, float t) {
        float newT = t;
        if (newT < 0.0f) {
            newT += 1.0f;
        }
        if (newT > 1.0f) {
            newT -= 1.0f;
        }
        if (newT < 0.166666672f) {
            return p + (q - p) * 6.0f * newT;
        }
        if (newT < 0.5f) {
            return q;
        }
        if (newT < 0.666666687f) {
            return p + (q - p) * (0.666666687f - newT) * 6.0f;
        }
        return p;
    }
}

