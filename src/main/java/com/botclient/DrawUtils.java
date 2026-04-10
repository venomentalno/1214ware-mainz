/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jhlabs.image.GaussianFilter
 *  neo.deobf.MinecraftContext
 *  neo.deobf.ShaderUtils
 *  neo.deobf.StencilUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.client.renderer.texture.TextureUtil
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.client.renderer.vertex.VertexFormat
 *  net.minecraft.client.shader.Framebuffer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.Timer
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.lwjgl.opengl.GL11
 */
package neo.deobf;

import com.jhlabs.image.GaussianFilter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import neo.deobf.MinecraftContext;
import neo.deobf.ShaderUtils;
import neo.deobf.StencilUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Timer;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class DrawUtils
implements MinecraftContext {
    public static final HashMap<Double, Integer> shadowCache = new HashMap();

    public static void color(int color) {
        DrawUtils.color(color, (float)(color >> (24) & (255)) / 255.0f);
    }

    public static void horizontalGradient(double x1, double y1, double x2, double y2, int startColor, int endColor) {
        x2 += x1;
        y2 += y1;
        float f = (float)(startColor >> (24) & (255)) / 255.0f;
        float f1 = (float)(startColor >> (16) & (255)) / 255.0f;
        float f2 = (float)(startColor >> (8) & (255)) / 255.0f;
        float f3 = (float)(startColor & (255)) / 255.0f;
        float f4 = (float)(endColor >> (24) & (255)) / 255.0f;
        float f5 = (float)(endColor >> (16) & (255)) / 255.0f;
        float f6 = (float)(endColor >> (8) & (255)) / 255.0f;
        float f7 = (float)(endColor & (255)) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)(GlStateManager.SourceFactor.SRC_ALPHA), (GlStateManager.DestFactor)(GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA), (GlStateManager.SourceFactor)(GlStateManager.SourceFactor.ONE), (GlStateManager.DestFactor)(GlStateManager.DestFactor.ZERO));
        GlStateManager.shadeModel((int)(7425));
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, (DefaultVertexFormats.POSITION_COLOR));
        bufferbuilder.pos(x1, y1, 0.0).color(f1, f2, f3, f).endVertex();
        bufferbuilder.pos(x1, y2, 0.0).color(f1, f2, f3, f).endVertex();
        bufferbuilder.pos(x2, y2, 0.0).color(f5, f6, f7, f4).endVertex();
        bufferbuilder.pos(x2, y1, 0.0).color(f5, f6, f7, f4).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)(7424));
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void glHexColor(int hex, int alpha) {
        float red = (float)(hex >> (16) & (255)) / 255.0f;
        float green = (float)(hex >> (8) & (255)) / 255.0f;
        float blue = (float)(hex & (255)) / 255.0f;
        GlStateManager.color((float)red, (float)green, (float)blue, (float)((float)alpha / 255.0f));
    }

    public static void drawRect(float x, float y, float width, float height, Color color) {
        int colorRGB = color.getRGB();
        width += x;
        height += y;
        float f = (float)(colorRGB >> (24) & (255)) / 255.0f;
        float f1 = (float)(colorRGB >> (16) & (255)) / 255.0f;
        float f2 = (float)(colorRGB >> (8) & (255)) / 255.0f;
        float f3 = (float)(colorRGB & (255)) / 255.0f;
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)(770), (int)(771), (int)(1), (int)(0));
        DrawUtils.color(f1, f2, f3, f);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder worldrenderer = tessellator.getBuffer();
        worldrenderer.begin(7, (DefaultVertexFormats.POSITION));
        worldrenderer.pos((double)x, (double)height, 0.0).endVertex();
        worldrenderer.pos((double)width, (double)height, 0.0).endVertex();
        worldrenderer.pos((double)width, (double)y, 0.0).endVertex();
        worldrenderer.pos((double)x, (double)y, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void scissorRect(float x, float y, float width, double height) {
        ScaledResolution sr = new ScaledResolution((mc));
        int factor = sr.getScaleFactor();
        GL11.glScissor((int)((int)(x * (float)factor)), (int)((int)(((double)sr.getScaledHeight() - height) * (double)factor)), (int)((int)((width - x) * (float)factor)), (int)((int)((height - (double)y) * (double)factor)));
    }

    public static Framebuffer createFrameBuffer(Framebuffer framebuffer) {
        if (framebuffer == null || (framebuffer.framebufferWidth) != ((mc).displayWidth) || (framebuffer.framebufferHeight) != ((mc).displayHeight)) {
            if (framebuffer != null) {
                framebuffer.deleteFramebuffer();
            }
            return new Framebuffer(((mc).displayWidth), ((mc).displayHeight), true);
        }
        return framebuffer;
    }

    public static void setColor(int color) {
        GL11.glColor4ub((byte)((byte)(color >> (16) & (255))), (byte)((byte)(color >> (8) & (255))), (byte)((byte)(color & (255))), (byte)((byte)(color >> (24) & (255))));
    }

    public static void verticalGradient(double x1, double y1, double x2, double y2, int startColor, int endColor) {
        x2 += x1;
        y2 += y1;
        float f = (float)(startColor >> (24) & (255)) / 255.0f;
        float f1 = (float)(startColor >> (16) & (255)) / 255.0f;
        float f2 = (float)(startColor >> (8) & (255)) / 255.0f;
        float f3 = (float)(startColor & (255)) / 255.0f;
        float f4 = (float)(endColor >> (24) & (255)) / 255.0f;
        float f5 = (float)(endColor >> (16) & (255)) / 255.0f;
        float f6 = (float)(endColor >> (8) & (255)) / 255.0f;
        float f7 = (float)(endColor & (255)) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)(GlStateManager.SourceFactor.SRC_ALPHA), (GlStateManager.DestFactor)(GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA), (GlStateManager.SourceFactor)(GlStateManager.SourceFactor.ONE), (GlStateManager.DestFactor)(GlStateManager.DestFactor.ZERO));
        GlStateManager.shadeModel((int)(7425));
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, (DefaultVertexFormats.POSITION_COLOR));
        bufferbuilder.pos(x1, y1, 0.0).color(f1, f2, f3, f).endVertex();
        bufferbuilder.pos(x1, y2, 0.0).color(f5, f6, f7, f4).endVertex();
        bufferbuilder.pos(x2, y2, 0.0).color(f5, f6, f7, f4).endVertex();
        bufferbuilder.pos(x2, y1, 0.0).color(f1, f2, f3, f).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)(7424));
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void disableSmoothLine() {
        GL11.glEnable((int)(3553));
        GL11.glEnable((int)(2929));
        GL11.glDisable((int)(3042));
        GL11.glEnable((int)(3008));
        GL11.glDepthMask(true);
        GL11.glCullFace((int)(1029));
        GL11.glDisable((int)(2848));
        GL11.glHint((int)(3154), (int)(4352));
        GL11.glHint((int)(3155), (int)(4352));
    }

    public static void drawGrayFilterNoBlur(Runnable data) {
        StencilUtils.initStencilToWrite();
        data.run();
        StencilUtils.readStencilBuffer((int)(1));
        ShaderUtils.renderColor((float)4.0f);
        StencilUtils.uninitStencilBuffer();
    }

    public static void color(int color, float alpha) {
        float r = (float)(color >> (16) & (255)) / 255.0f;
        float g = (float)(color >> (8) & (255)) / 255.0f;
        float b = (float)(color & (255)) / 255.0f;
        GlStateManager.color((float)r, (float)g, (float)b, (float)alpha);
    }

    private static Timer getTimer(Minecraft minecraft) {
        return minecraft.timer;
    }

    public static void renderImage(BufferedImage image, int x, int y, int width, int height) {
        Minecraft minecraft = Minecraft.getMinecraft();
        ResourceLocation resourceLocation = minecraft.getTextureManager().getDynamicTextureLocation("rendered_image", new DynamicTexture(image));
        minecraft.getTextureManager().bindTexture(resourceLocation);
        GlStateManager.pushMatrix();
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        Gui.drawModalRectWithCustomSizedTexture((int)x, (int)y, (float)0.0f, (float)0.0f, (int)width, (int)height, (float)width, (float)height);
        GlStateManager.popMatrix();
        Minecraft.getMinecraft().getTextureManager().deleteTexture(resourceLocation);
    }

    public static void color(double red, double green, double blue, double alpha) {
        GL11.glColor4d((double)red, (double)green, (double)blue, (double)alpha);
    }

    public static void drawBlurredShadowOval(float x, float y, float width, float height, int blurRadius, Color color) {
        GL11.glPushMatrix();
        GlStateManager.alphaFunc((int)(516), (float)0.00999999978f);
        float _X = (x -= (float)blurRadius) - 0.25f;
        float _Y = (y -= (float)blurRadius) + 0.25f;
        double identifier = (int)((double)((width += (float)(blurRadius * (2))) * (height += (float)(blurRadius * (2))) * 13212.0f) / Math.sin(blurRadius));
        GL11.glEnable((int)(3553));
        GL11.glDisable((int)(2884));
        GL11.glEnable((int)(3008));
        GlStateManager.enableBlend();
        int texId = -1;
        if ((shadowCache).containsKey(identifier)) {
            texId = (Integer)(shadowCache).get(identifier);
            GlStateManager.bindTexture((int)texId);
        } else {
            BufferedImage original = new BufferedImage((int)width, (int)height, 2);
            Graphics g = original.getGraphics();
            g.setColor((Color.WHITE));
            g.fillOval(blurRadius, blurRadius, (int)(width - (float)(blurRadius * (2))), (int)(height - (float)(blurRadius * (2))));
            g.dispose();
            GaussianFilter op = new GaussianFilter((float)blurRadius);
            BufferedImage blurred = op.filter(original, null);
            texId = TextureUtil.uploadTextureImageAllocate((int)TextureUtil.glGenTextures(), (BufferedImage)blurred, true, false);
            (shadowCache).put(identifier, texId);
        }
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
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
        GL11.glEnable((int)(2884));
        GlStateManager.resetColor();
        GL11.glPopMatrix();
    }

    public static void drawGradientRect(float f, float sY, double width, double height, int colour1, int colour2) {
        Gui.drawGradientRect1((float)f, (float)sY, (double)((double)f + width), (double)((double)sY + height), (int)colour1, (int)colour2);
    }

    public static void bindTexture(int texture) {
        GL11.glBindTexture((int)(3553), (int)texture);
    }

    private static Timer getTimer2(Minecraft minecraft) {
        return minecraft.timer;
    }

    public static void drawColorBox(AxisAlignedBB axisalignedbb, float red, float green, float blue, float alpha) {
        Tessellator ts = Tessellator.getInstance();
        BufferBuilder buffer = ts.getBuffer();
        buffer.begin(7, (DefaultVertexFormats.POSITION_TEX));
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        ts.draw();
        buffer.begin(7, (DefaultVertexFormats.POSITION_TEX));
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        ts.draw();
        buffer.begin(7, (DefaultVertexFormats.POSITION_TEX));
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        ts.draw();
        buffer.begin(7, (DefaultVertexFormats.POSITION_TEX));
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        ts.draw();
        buffer.begin(7, (DefaultVertexFormats.POSITION_TEX));
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        ts.draw();
        buffer.begin(7, (DefaultVertexFormats.POSITION_TEX));
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.minX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.minZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.maxY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        buffer.pos((axisalignedbb.maxX), (axisalignedbb.minY), (axisalignedbb.maxZ)).color(red, green, blue, alpha).endVertex();
        ts.draw();
    }

    public static void color(Color color) {
        if (color == null) {
            color = (Color.white);
        }
        DrawUtils.color((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
    }

    public static void glColor(Color color) {
        float red = (float)color.getRed() / 255.0f;
        float green = (float)color.getGreen() / 255.0f;
        float blue = (float)color.getBlue() / 255.0f;
        float alpha = (float)color.getAlpha() / 255.0f;
        GlStateManager.color((float)red, (float)green, (float)blue, (float)alpha);
    }

    public static void drawCircle(float x, float y, float start, float end, float radius, int color, int linewidth) {
        GlStateManager.color((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
        if (start > end) {
            float endOffset = end;
            end = start;
            start = endOffset;
        }
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        DrawUtils.enableSmoothLine(linewidth);
        GlStateManager.tryBlendFuncSeparate((int)(770), (int)(771), (int)(1), (int)(0));
        GL11.glBegin((int)(3));
        for (float i = end; i >= start; i -= 4.0f) {
            DrawUtils.glHexColor(color, 255);
            float cos = (float)(Math.cos((double)i * 3.1415926535897931 / 180.0) * (double)radius * 1.0);
            float sin = (float)(Math.sin((double)i * 3.1415926535897931 / 180.0) * (double)radius * 1.0);
            GL11.glVertex2f((float)(x + cos), (float)(y + sin));
        }
        GL11.glEnd();
        DrawUtils.disableSmoothLine();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawOutlinedBoundingBox(AxisAlignedBB aa) {
        GL11.glEnable((int)(3042));
        GL11.glDisable((int)(3553));
        GL11.glBlendFunc((int)(770), (int)(771));
        GL11.glDisable((int)(2896));
        GL11.glPolygonMode((int)(1032), (int)(6913));
        GL11.glDisable((int)(2884));
        GL11.glBegin((int)(7));
        float f = (float)(aa.minX);
        float f1 = (float)(aa.maxX);
        float f2 = (float)(aa.minY);
        float f3 = (float)(aa.maxY);
        float f4 = (float)(aa.minZ);
        float f5 = (float)(aa.maxZ);
        GL11.glVertex3d((double)f, (double)f3, (double)f4);
        GL11.glVertex3d((double)f, (double)f3, (double)f5);
        GL11.glVertex3d((double)f, (double)f2, (double)f5);
        GL11.glVertex3d((double)f, (double)f2, (double)f4);
        GL11.glVertex3d((double)f1, (double)f3, (double)f4);
        GL11.glVertex3d((double)f1, (double)f3, (double)f5);
        GL11.glVertex3d((double)f1, (double)f2, (double)f5);
        GL11.glVertex3d((double)f1, (double)f2, (double)f4);
        GL11.glVertex3d((double)f1, (double)f3, (double)f4);
        GL11.glVertex3d((double)f1, (double)f3, (double)f5);
        GL11.glVertex3d((double)f, (double)f3, (double)f5);
        GL11.glVertex3d((double)f, (double)f3, (double)f4);
        GL11.glVertex3d((double)f1, (double)f2, (double)f4);
        GL11.glVertex3d((double)f1, (double)f2, (double)f5);
        GL11.glVertex3d((double)f, (double)f2, (double)f5);
        GL11.glVertex3d((double)f, (double)f2, (double)f4);
        GL11.glEnd();
        GL11.glPolygonMode((int)(1032), (int)(6914));
        GL11.glEnable((int)(2884));
        GL11.glEnable((int)(3553));
        GL11.glDisable((int)(3042));
    }

    private static Timer getTimer3(Minecraft minecraft) {
        return minecraft.timer;
    }

    public static void drawImage(ResourceLocation resourceLocation, float x, float y, float width, float height, Color color) {
        GL11.glDisable((int)(2929));
        GL11.glEnable((int)(3042));
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc((int)(770), (int)(771), (int)(1), (int)(0));
        DrawUtils.setColor(color.getRGB());
        Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation);
        Gui.drawModalRectWithCustomSizedTexture((int)((int)x), (int)((int)y), (float)0.0f, (float)0.0f, (int)((int)width), (int)((int)height), (float)width, (float)height);
        GL11.glDepthMask(true);
        GL11.glDisable((int)(3042));
        GL11.glEnable((int)(2929));
        GlStateManager.disableBlend();
    }

    public static void resetColor() {
        DrawUtils.color(1.0, 1.0, 1.0, 1.0);
    }

    public static void drawFCircle(float x, float y, float start, float end, float radius, boolean filled, Color color) {
        float sin;
        float cos;
        float i;
        DrawUtils.color(0.0, 0.0, 0.0, 0.0);
        if (start > end) {
            float endOffset = end;
            end = start;
            start = endOffset;
        }
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)(770), (int)(771), (int)(1), (int)(0));
        DrawUtils.setColor(color.getRGB());
        GL11.glEnable((int)(2848));
        GL11.glLineWidth((float)2.0f);
        GL11.glBegin((int)(3));
        for (i = end; i >= start; i -= 4.0f) {
            cos = (float)(Math.cos((double)i * 3.1415926535897931 / 180.0) * (double)radius * 1.0);
            sin = (float)(Math.sin((double)i * 3.1415926535897931 / 180.0) * (double)radius * 1.0);
            GL11.glVertex2f((float)(x + cos), (float)(y + sin));
        }
        GL11.glEnd();
        GL11.glDisable((int)(2848));
        GL11.glEnable((int)(2848));
        GL11.glBegin((int)(filled ? 6 : 3));
        for (i = end; i >= start; i -= 4.0f) {
            cos = (float)Math.cos((double)i * 3.1415926535897931 / 180.0) * radius;
            sin = (float)Math.sin((double)i * 3.1415926535897931 / 180.0) * radius;
            GL11.glVertex2f((float)(x + cos), (float)(y + sin));
        }
        GL11.glEnd();
        GL11.glDisable((int)(2848));
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawSelectionBoundingBox(AxisAlignedBB boundingBox) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder builder = tessellator.getBuffer();
        builder.begin(3, (DefaultVertexFormats.POSITION));
        builder.pos((boundingBox.minX), (boundingBox.minY), (boundingBox.minZ)).endVertex();
        builder.pos((boundingBox.maxX), (boundingBox.minY), (boundingBox.minZ)).endVertex();
        builder.pos((boundingBox.maxX), (boundingBox.minY), (boundingBox.maxZ)).endVertex();
        builder.pos((boundingBox.minX), (boundingBox.minY), (boundingBox.maxZ)).endVertex();
        builder.pos((boundingBox.minX), (boundingBox.minY), (boundingBox.minZ)).endVertex();
        tessellator.draw();
        builder.begin(3, (DefaultVertexFormats.POSITION));
        builder.pos((boundingBox.minX), (boundingBox.maxY), (boundingBox.minZ)).endVertex();
        builder.pos((boundingBox.maxX), (boundingBox.maxY), (boundingBox.minZ)).endVertex();
        builder.pos((boundingBox.maxX), (boundingBox.maxY), (boundingBox.maxZ)).endVertex();
        builder.pos((boundingBox.minX), (boundingBox.maxY), (boundingBox.maxZ)).endVertex();
        builder.pos((boundingBox.minX), (boundingBox.maxY), (boundingBox.minZ)).endVertex();
        tessellator.draw();
        builder.begin(1, (DefaultVertexFormats.POSITION));
        builder.pos((boundingBox.minX), (boundingBox.minY), (boundingBox.minZ)).endVertex();
        builder.pos((boundingBox.minX), (boundingBox.maxY), (boundingBox.minZ)).endVertex();
        builder.pos((boundingBox.maxX), (boundingBox.minY), (boundingBox.minZ)).endVertex();
        builder.pos((boundingBox.maxX), (boundingBox.maxY), (boundingBox.minZ)).endVertex();
        builder.pos((boundingBox.maxX), (boundingBox.minY), (boundingBox.maxZ)).endVertex();
        builder.pos((boundingBox.maxX), (boundingBox.maxY), (boundingBox.maxZ)).endVertex();
        builder.pos((boundingBox.minX), (boundingBox.minY), (boundingBox.maxZ)).endVertex();
        builder.pos((boundingBox.minX), (boundingBox.maxY), (boundingBox.maxZ)).endVertex();
        tessellator.draw();
    }

    public static void drawGradientRect(double d, double e, double e2, double g, int startColor, int endColor) {
        float f = (float)(startColor >> (24) & (255)) / 255.0f;
        float f1 = (float)(startColor >> (16) & (255)) / 255.0f;
        float f2 = (float)(startColor >> (8) & (255)) / 255.0f;
        float f3 = (float)(startColor & (255)) / 255.0f;
        float f4 = (float)(endColor >> (24) & (255)) / 255.0f;
        float f5 = (float)(endColor >> (16) & (255)) / 255.0f;
        float f6 = (float)(endColor >> (8) & (255)) / 255.0f;
        float f7 = (float)(endColor & (255)) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)(GlStateManager.SourceFactor.SRC_ALPHA), (GlStateManager.DestFactor)(GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA), (GlStateManager.SourceFactor)(GlStateManager.SourceFactor.ONE), (GlStateManager.DestFactor)(GlStateManager.DestFactor.ZERO));
        GlStateManager.shadeModel((int)(7425));
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, (DefaultVertexFormats.POSITION_COLOR));
        bufferbuilder.pos(e2, e, 0.0).color(f1, f2, f3, f).endVertex();
        bufferbuilder.pos(d, e, 0.0).color(f1, f2, f3, f).endVertex();
        bufferbuilder.pos(d, g, 0.0).color(f5, f6, f7, f4).endVertex();
        bufferbuilder.pos(e2, g, 0.0).color(f5, f6, f7, f4).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)(7424));
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void drawHLine(double x, double y, double x1, double y1, float width, int color) {
        float alpha = (float)(color >> (24) & (255)) / 255.0f;
        float red = (float)(color >> (16) & (255)) / 255.0f;
        float green = (float)(color >> (8) & (255)) / 255.0f;
        float blue = (float)(color & (255)) / 255.0f;
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)(770), (int)(771), (int)(1), (int)(0));
        GlStateManager.color((float)red, (float)green, (float)blue, (float)alpha);
        GL11.glPushMatrix();
        GL11.glLineWidth((float)width);
        GL11.glBegin((int)(3));
        GL11.glVertex2d((double)x, (double)y);
        GL11.glVertex2d((double)x1, (double)y1);
        GL11.glEnd();
        GL11.glLineWidth((float)1.0f);
        GL11.glPopMatrix();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void drawEntityBox(Entity entity, Color color, boolean fullBox, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.blendFunc((int)(770), (int)(771));
        GL11.glEnable((int)(3042));
        GlStateManager.glLineWidth((float)1.0f);
        GlStateManager.disableTexture2D();
        GL11.glDisable((int)(2929));
        GlStateManager.depthMask(false);
        double d = (entity.lastTickPosX) + ((entity.posX) - (entity.lastTickPosX)) * (double)(DrawUtils.getTimer2((mc)).renderPartialTicks);
        (mc).getRenderManager();
        double x = d - (RenderManager.renderPosX);
        double d2 = (entity.lastTickPosY) + ((entity.posY) - (entity.lastTickPosY)) * (double)(DrawUtils.getTimer3((mc)).renderPartialTicks);
        (mc).getRenderManager();
        double y = d2 - (RenderManager.renderPosY);
        double d3 = (entity.lastTickPosZ) + ((entity.posZ) - (entity.lastTickPosZ)) * (double)(DrawUtils.getTimer((mc)).renderPartialTicks);
        (mc).getRenderManager();
        double z = d3 - (RenderManager.renderPosZ);
        AxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox();
        AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB((axisAlignedBB.minX) - (entity.posX) + x - 0.050000000000000003, (axisAlignedBB.minY) - (entity.posY) + y, (axisAlignedBB.minZ) - (entity.posZ) + z - 0.050000000000000003, (axisAlignedBB.maxX) - (entity.posX) + x + 0.050000000000000003, (axisAlignedBB.maxY) - (entity.posY) + y + 0.14999999999999999, (axisAlignedBB.maxZ) - (entity.posZ) + z + 0.050000000000000003);
        GlStateManager.glLineWidth((float)1.0f);
        GL11.glEnable((int)(2848));
        GlStateManager.color((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)alpha);
        DrawUtils.drawSelectionBoundingBox(axisAlignedBB2);
        GlStateManager.glLineWidth((float)1.0f);
        GlStateManager.enableTexture2D();
        GL11.glEnable((int)(2929));
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawRegionESP(double x, double y, double z, double xx, double yy, double zz, float red, float green, float blue, float alpha, float lineRed, float lineGreen, float lineBlue, float lineAlpha, float lineWidth) {
        GL11.glPushMatrix();
        GL11.glEnable((int)(3042));
        GL11.glBlendFunc((int)(770), (int)(771));
        GL11.glDisable((int)(3553));
        GL11.glEnable((int)(2848));
        GL11.glEnable((int)(2929));
        GL11.glColor4f((float)red, (float)green, (float)blue, (float)alpha);
        GL11.glLineWidth((float)lineWidth);
        GL11.glColor4f((float)lineRed, (float)lineGreen, (float)lineBlue, (float)lineAlpha);
        DrawUtils.drawOutlinedBoundingBox(new AxisAlignedBB(x, y, z, xx, yy, zz));
        GL11.glDisable((int)(2848));
        GL11.glEnable((int)(3553));
        GL11.glEnable((int)(2929));
        GL11.glDisable((int)(3042));
        GL11.glPopMatrix();
    }

    public static void enableSmoothLine(float width) {
        GL11.glDisable((int)(3008));
        GL11.glEnable((int)(3042));
        GL11.glBlendFunc((int)(770), (int)(771));
        GL11.glDisable((int)(3553));
        GL11.glDisable((int)(2929));
        GL11.glDepthMask(false);
        GL11.glEnable((int)(2884));
        GL11.glEnable((int)(2848));
        GL11.glHint((int)(3154), (int)(4354));
        GL11.glHint((int)(3155), (int)(4354));
        GL11.glLineWidth((float)width);
    }

    public static void drawBlurredShadow(float x, float y, float width, float height, int blurRadius, Color color) {
        GL11.glPushMatrix();
        GlStateManager.alphaFunc((int)(516), (float)0.00999999978f);
        float _X = (x -= (float)blurRadius) - 0.25f;
        float _Y = (y -= (float)blurRadius) + 0.25f;
        double identifier = (int)((double)((width += (float)(blurRadius * (2))) * (height += (float)(blurRadius * (2))) * 13212.0f) / Math.sin(blurRadius));
        GL11.glEnable((int)(3553));
        GL11.glDisable((int)(2884));
        GL11.glEnable((int)(3008));
        GlStateManager.enableBlend();
        int texId = -1;
        if ((shadowCache).containsKey(identifier)) {
            texId = (Integer)(shadowCache).get(identifier);
            GlStateManager.bindTexture((int)texId);
        } else {
            BufferedImage original = new BufferedImage((int)width, (int)height, 2);
            Graphics g = original.getGraphics();
            g.setColor((Color.WHITE));
            g.fillRect(blurRadius, blurRadius, (int)(width - (float)(blurRadius * (2))), (int)(height - (float)(blurRadius * (2))));
            g.dispose();
            GaussianFilter op = new GaussianFilter((float)blurRadius);
            BufferedImage blurred = op.filter(original, null);
            texId = TextureUtil.uploadTextureImageAllocate((int)TextureUtil.glGenTextures(), (BufferedImage)blurred, true, false);
            (shadowCache).put(identifier, texId);
        }
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
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
        GL11.glEnable((int)(2884));
        GlStateManager.resetColor();
        GL11.glPopMatrix();
    }

}

