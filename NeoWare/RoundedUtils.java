/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.MinecraftContext
 *  neo.deobf.DrawUtils
 *  neo.deobf.ShaderUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 */
package neo.deobf;

import java.awt.Color;
import neo.deobf.MinecraftContext;
import neo.deobf.DrawUtils;
import neo.deobf.ShaderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class RoundedUtils {
    public static ShaderUtils roundedShader = new ShaderUtils("roundedRect");
    public static ShaderUtils roundedOutlineShader = new ShaderUtils("roundedOutlineRect");
    public static final ShaderUtils roundedTexturedShader = new ShaderUtils("neoware/shaders/round.frag");
    public static final ShaderUtils roundedGradientShader = new ShaderUtils("roundedRectGradient");

    public static void drawRound(float x, float y, float width, float height, float radius, Color color) {
        RoundedUtils.drawRound(x, y, width, height, radius, false, color);
    }

    private static Minecraft getMc() {
        return MinecraftContext.mc;
    }

    public static void drawRound(float x, float y, float width, float height, float radius, boolean blur, Color color) {
        DrawUtils.resetColor();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc((int)(770), (int)(771));
        (roundedShader).init();
        RoundedUtils.callGetMinecraft(x, y, width, height, radius, (roundedShader));
        int[] nArray = new int[1];
        nArray[0] = blur ? 1 : 0;
        (roundedShader).setUniformi("blur", nArray);
        float[] fArray = new float[4];
        fArray[0] = (float)color.getRed() / 255.0f;
        fArray[1] = (float)color.getGreen() / 255.0f;
        fArray[2] = (float)color.getBlue() / 255.0f;
        fArray[3] = (float)color.getAlpha() / 255.0f;
        (roundedShader).setUniformf("color", fArray);
        ShaderUtils.drawQuads((float)(x - 1.0f), (float)(y - 1.0f), (float)(width + 2.0f), (float)(height + 2.0f));
        (roundedShader).unload();
        GlStateManager.disableBlend();
    }

    public static void drawRoundCircleOut(float x, float y, float radius, float thikness, Color color, Color sidecolor) {
        RoundedUtils.drawRoundOutline(x - radius / 2.0f, y - radius / 2.0f, radius, radius, radius / 2.0f - 0.5f, thikness, color, sidecolor);
    }

    public static void drawGradientVertical(float x, float y, float width, float height, float radius, Color top, Color bottom) {
        RoundedUtils.drawGradientRound(x, y, width, height, radius, bottom, top, bottom, top);
    }

    public static void drawGradientRound(float x, float y, float width, float height, float radius, Color bottomLeft, Color topLeft, Color bottomRight, Color topRight) {
        DrawUtils.resetColor();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc((int)(770), (int)(771));
        (roundedGradientShader).init();
        RoundedUtils.callGetMinecraft(x, y, width, height, radius, (roundedGradientShader));
        float[] fArray = new float[4];
        fArray[0] = (float)bottomLeft.getRed() / 255.0f;
        fArray[1] = (float)bottomLeft.getGreen() / 255.0f;
        fArray[2] = (float)bottomLeft.getBlue() / 255.0f;
        fArray[3] = 0.313725501f;
        (roundedGradientShader).setUniformf("color1", fArray);
        float[] fArray2 = new float[4];
        fArray2[0] = (float)topLeft.getRed() / 255.0f;
        fArray2[1] = (float)topLeft.getGreen() / 255.0f;
        fArray2[2] = (float)topLeft.getBlue() / 255.0f;
        fArray2[3] = 0.313725501f;
        (roundedGradientShader).setUniformf("color2", fArray2);
        float[] fArray3 = new float[4];
        fArray3[0] = (float)bottomRight.getRed() / 255.0f;
        fArray3[1] = (float)bottomRight.getGreen() / 255.0f;
        fArray3[2] = (float)bottomRight.getBlue() / 255.0f;
        fArray3[3] = 0.313725501f;
        (roundedGradientShader).setUniformf("color3", fArray3);
        float[] fArray4 = new float[4];
        fArray4[0] = (float)topRight.getRed() / 255.0f;
        fArray4[1] = (float)topRight.getGreen() / 255.0f;
        fArray4[2] = (float)topRight.getBlue() / 255.0f;
        fArray4[3] = 0.313725501f;
        (roundedGradientShader).setUniformf("color4", fArray4);
        ShaderUtils.drawQuads((float)(x - 1.0f), (float)(y - 1.0f), (float)(width + 2.0f), (float)(height + 2.0f));
        (roundedGradientShader).unload();
        GlStateManager.disableBlend();
    }

    private static void callGetMinecraft(float x, float y, float width, float height, float radius, ShaderUtils roundedTexturedShader) {
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        float[] fArray = new float[2];
        fArray[0] = x * (float)sr.getScaleFactor();
        fArray[1] = (float)(Minecraft.getMinecraft().displayHeight) - height * (float)sr.getScaleFactor() - y * (float)sr.getScaleFactor();
        roundedTexturedShader.setUniformf("location", fArray);
        float[] fArray2 = new float[2];
        fArray2[0] = width * (float)sr.getScaleFactor();
        fArray2[1] = height * (float)sr.getScaleFactor();
        roundedTexturedShader.setUniformf("rectSize", fArray2);
        float[] fArray3 = new float[1];
        fArray3[0] = radius * (float)sr.getScaleFactor();
        roundedTexturedShader.setUniformf("radius", fArray3);
    }

    public static void drawRoundTextured(float x, float y, float width, float height, float radius, float alpha) {
        DrawUtils.resetColor();
        (roundedTexturedShader).init();
        int[] nArray = new int[1];
        nArray[0] = 0;
        (roundedTexturedShader).setUniformi("textureIn", nArray);
        RoundedUtils.callGetMinecraft(x, y, width, height, radius, (roundedTexturedShader));
        float[] fArray = new float[1];
        fArray[0] = alpha;
        (roundedTexturedShader).setUniformf("alpha", fArray);
        ShaderUtils.drawQuads((float)(x - 1.0f), (float)(y - 1.0f), (float)(width + 2.0f), (float)(height + 2.0f));
        (roundedTexturedShader).unload();
        GlStateManager.disableBlend();
    }

    public static void drawRoundOutline(float x, float y, float width, float height, float radius, float thickness, Color insideColor, Color outlineColor) {
        ScaledResolution sr = new ScaledResolution((MinecraftContext.mc));
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc((int)(770), (int)(771));
        (roundedOutlineShader).init();
        float[] fArray = new float[2];
        fArray[0] = x * (float)sr.getScaleFactor();
        fArray[1] = (float)(RoundedUtils.getMc().displayHeight) - height * (float)sr.getScaleFactor() - y * (float)sr.getScaleFactor();
        (roundedOutlineShader).setUniformf("location", fArray);
        float[] fArray2 = new float[2];
        fArray2[0] = width * (float)sr.getScaleFactor();
        fArray2[1] = height * (float)sr.getScaleFactor();
        (roundedOutlineShader).setUniformf("size", fArray2);
        float[] fArray3 = new float[1];
        fArray3[0] = radius * (float)sr.getScaleFactor();
        (roundedOutlineShader).setUniformf("radius", fArray3);
        float[] fArray4 = new float[1];
        fArray4[0] = thickness * (float)sr.getScaleFactor();
        (roundedOutlineShader).setUniformf("thickness", fArray4);
        float[] fArray5 = new float[4];
        fArray5[0] = (float)insideColor.getRed() / 255.0f;
        fArray5[1] = (float)insideColor.getGreen() / 255.0f;
        fArray5[2] = (float)insideColor.getBlue() / 255.0f;
        fArray5[3] = (float)insideColor.getAlpha() / 255.0f;
        (roundedOutlineShader).setUniformf("color", fArray5);
        float[] fArray6 = new float[4];
        fArray6[0] = (float)outlineColor.getRed() / 255.0f;
        fArray6[1] = (float)outlineColor.getGreen() / 255.0f;
        fArray6[2] = (float)outlineColor.getBlue() / 255.0f;
        fArray6[3] = (float)outlineColor.getAlpha() / 255.0f;
        (roundedOutlineShader).setUniformf("outlineColor", fArray6);
        ShaderUtils.drawQuads((float)(x - (2.0f + thickness)), (float)(y - (2.0f + thickness)), (float)(width + (4.0f + thickness * 2.0f)), (float)(height + (4.0f + thickness * 2.0f)));
        (roundedOutlineShader).unload();
        GlStateManager.enableAlpha();
    }

    public static void drawRoundScale(float x, float y, float width, float height, float radius, Color color, float scale) {
        RoundedUtils.drawRound(x + width - width * scale, y + height / 2.0f - height / 2.0f * scale, width * scale, height * scale, radius, false, color);
    }

    public static void drawGradientHorizontal(float x, float y, float width, float height, float radius, Color left, Color right) {
        RoundedUtils.drawGradientRound(x, y, width, height, radius, left, left, right, right);
    }

    public static void drawRoundCircle(float x, float y, float radius, Color color) {
        RoundedUtils.drawRound(x - radius / 2.0f, y - radius / 2.0f, radius, radius, radius / 2.0f - 0.5f, color);
    }

}

