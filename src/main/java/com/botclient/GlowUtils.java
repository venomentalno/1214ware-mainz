/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jhlabs.image.GaussianFilter
 *  neo.deobf.ColorUtils
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.texture.TextureUtil
 *  org.lwjgl.opengl.GL11
 */
package neo.deobf;

import com.jhlabs.image.GaussianFilter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Objects;
import neo.deobf.ColorUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class GlowUtils {
    public static final HashMap<Integer, Integer> shadowCache = new HashMap();

    public static void drawGlow(float x, float y, float width, float height, int glowRadius, Color color) {
        BufferedImage original = null;
        GaussianFilter op = null;
        GL11.glPushMatrix();
        GlStateManager.alphaFunc((int)(516), (float)0.00999999978f);
        float _X = (x -= (float)glowRadius) - 0.25f;
        float _Y = (y -= (float)glowRadius) + 0.25f;
        int identifier = String.valueOf((width += (float)(glowRadius * (2))) * (height += (float)(glowRadius * (2))) + width + (float)((1000000000) * glowRadius) + (float)glowRadius).hashCode();
        GL11.glEnable((int)(3553));
        GL11.glDisable((int)(2884));
        GL11.glEnable((int)(3008));
        GlStateManager.enableBlend();
        int texId = -1;
        if ((shadowCache).containsKey(identifier)) {
            texId = (Integer)(shadowCache).get(identifier);
            GlStateManager.bindTexture((int)texId);
        } else {
            if (width <= 0.0f) {
                width = 1.0f;
            }
            if (height <= 0.0f) {
                height = 1.0f;
            }
            original = new BufferedImage((int)width, (int)height, 3);
            Graphics g = original.getGraphics();
            g.setColor((Color.white));
            g.fillRect(glowRadius, glowRadius, (int)(width - (float)(glowRadius * (2))), (int)(height - (float)(glowRadius * (2))));
            g.dispose();
            op = new GaussianFilter((float)glowRadius);
            BufferedImage blurred = op.filter(original, null);
            texId = TextureUtil.uploadTextureImageAllocate((int)TextureUtil.glGenTextures(), (BufferedImage)blurred, true, false);
            (shadowCache).put(identifier, texId);
        }
        ColorUtils.glColor((Color)color);
        GL11.glBegin((int)(7));
        GL11.glTexCoord2f((float)0.0f, (float)0.0f);
        GL11.glVertex2f((float)_X, (float)_Y);
        GL11.glTexCoord2f((float)0.0f, (float)1.0f);
        GL11.glVertex2f((float)_X, (float)(_Y + height));
        GL11.glTexCoord2f((float)1.0f, (float)1.0f);
        GL11.glVertex2f((float)(_X + width), (float)(_Y + height));
        GL11.glTexCoord2f((float)1.0f, (float)0.0f);
        GL11.glVertex2f((float)(_X + width), (float)_Y);
        GL11.glEnd();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.resetColor();
        GL11.glEnable((int)(2884));
        GL11.glPopMatrix();
    }

    public static void drawGlowGradientFIX(float x, float y, float width, float height, int glowRadius, int color1, int color2, int color3, int color4) {
        BufferedImage original = null;
        GaussianFilter op = null;
        GL11.glPushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)(GlStateManager.SourceFactor.SRC_ALPHA), (GlStateManager.DestFactor)(GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA), (GlStateManager.SourceFactor)(GlStateManager.SourceFactor.ONE), (GlStateManager.DestFactor)(GlStateManager.DestFactor.ZERO));
        GlStateManager.shadeModel((int)(7425));
        GlStateManager.alphaFunc((int)(516), (float)0.00999999978f);
        float _X = (x -= (float)glowRadius) - 0.25f;
        float _Y = (y -= (float)glowRadius) + 0.25f;
        int identifier = String.valueOf((double)((width += (float)(glowRadius * (2))) * (height += (float)(glowRadius * (2))) + width) + Math.sin((float)glowRadius / width * height) * (double)glowRadius + (double)glowRadius).hashCode();
        GL11.glEnable((int)(3553));
        GL11.glDisable((int)(2884));
        GL11.glEnable((int)(3008));
        GlStateManager.enableBlend();
        int texId = -1;
        if ((shadowCache).containsKey(identifier)) {
            texId = (Integer)(shadowCache).get(identifier);
            GlStateManager.bindTexture((int)texId);
        } else {
            if (width <= 0.0f) {
                width = 1.0f;
            }
            if (height <= 0.0f) {
                height = 1.0f;
            }
            original = new BufferedImage((int)width, (int)height, 3);
            Graphics g = original.getGraphics();
            g.setColor((Color.white));
            g.fillRect(glowRadius, glowRadius, (int)width - glowRadius * (2), (int)height - glowRadius * (2));
            g.dispose();
            op = new GaussianFilter((float)glowRadius);
            BufferedImage blurred = op.filter(original, null);
            texId = TextureUtil.uploadTextureImageAllocate((int)TextureUtil.glGenTextures(), (BufferedImage)blurred, true, false);
            (shadowCache).put(identifier, texId);
        }
        GL11.glBegin((int)(7));
        ColorUtils.glColor((int)color1);
        GL11.glTexCoord2f((float)0.0f, (float)0.0f);
        GL11.glVertex2f((float)_X, (float)_Y);
        ColorUtils.glColor((int)color2);
        GL11.glTexCoord2f((float)0.0f, (float)1.0f);
        GL11.glVertex2f((float)_X, (float)(_Y + height));
        ColorUtils.glColor((int)color4);
        GL11.glTexCoord2f((float)1.0f, (float)1.0f);
        GL11.glVertex2f((float)(_X + width), (float)(_Y + height));
        ColorUtils.glColor((int)color3);
        GL11.glTexCoord2f((float)1.0f, (float)0.0f);
        GL11.glVertex2f((float)(_X + width), (float)_Y);
        GL11.glEnd();
        GlStateManager.enableTexture2D();
        GlStateManager.shadeModel((int)(7424));
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.resetColor();
        GL11.glEnable((int)(2884));
        GL11.glPopMatrix();
    }

    public static void drawGlowHorizontal(float x, float y, float width, float height, int glowRadius, int color1, int color2) {
        BufferedImage original = null;
        GaussianFilter op = null;
        GL11.glPushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)(GlStateManager.SourceFactor.SRC_ALPHA), (GlStateManager.DestFactor)(GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA), (GlStateManager.SourceFactor)(GlStateManager.SourceFactor.ONE), (GlStateManager.DestFactor)(GlStateManager.DestFactor.ZERO));
        GlStateManager.shadeModel((int)(7425));
        GlStateManager.alphaFunc((int)(516), (float)0.00999999978f);
        float _X = (x -= (float)glowRadius) - 0.25f;
        float _Y = (y -= (float)glowRadius) + 0.25f;
        Object[] objectArray = new Object[3];
        objectArray[0] = Float.valueOf(width += (float)(glowRadius * (2)));
        objectArray[1] = Float.valueOf(height += (float)(glowRadius * (2)));
        objectArray[2] = glowRadius;
        int identifier = Objects.hash(objectArray);
        GL11.glEnable((int)(3553));
        GL11.glDisable((int)(2884));
        GL11.glEnable((int)(3008));
        GlStateManager.enableBlend();
        int texId = -1;
        if ((shadowCache).containsKey(identifier)) {
            texId = (Integer)(shadowCache).get(identifier);
            GlStateManager.bindTexture((int)texId);
        } else {
            if (width <= 0.0f) {
                width = 1.0f;
            }
            if (height <= 0.0f) {
                height = 1.0f;
            }
            original = new BufferedImage((int)width, (int)height, 3);
            Graphics g = original.getGraphics();
            g.setColor((Color.white));
            g.fillRect(glowRadius, glowRadius, (int)width - glowRadius * (2), (int)height - glowRadius * (2));
            g.dispose();
            op = new GaussianFilter((float)glowRadius);
            BufferedImage blurred = op.filter(original, null);
            texId = TextureUtil.uploadTextureImageAllocate((int)TextureUtil.glGenTextures(), (BufferedImage)blurred, true, false);
            (shadowCache).put(identifier, texId);
        }
        GL11.glBegin((int)(7));
        ColorUtils.glColor((int)color1);
        GL11.glTexCoord2f((float)0.0f, (float)0.0f);
        GL11.glVertex2f((float)_X, (float)_Y);
        GL11.glTexCoord2f((float)0.0f, (float)1.0f);
        GL11.glVertex2f((float)_X, (float)(_Y + height));
        ColorUtils.glColor((int)color2);
        GL11.glTexCoord2f((float)1.0f, (float)1.0f);
        GL11.glVertex2f((float)(_X + width), (float)(_Y + height));
        GL11.glTexCoord2f((float)1.0f, (float)0.0f);
        GL11.glVertex2f((float)(_X + width), (float)_Y);
        GL11.glEnd();
        GlStateManager.enableTexture2D();
        GlStateManager.shadeModel((int)(7424));
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.resetColor();
        GL11.glEnable((int)(2884));
        GL11.glPopMatrix();
    }

}

