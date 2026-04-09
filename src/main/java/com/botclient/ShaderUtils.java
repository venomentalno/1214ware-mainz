/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.MinecraftContext
 *  neo.deobf.DrawUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.shader.Framebuffer
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 */
package com.botclient;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import com.botclient.MinecraftContext;
import com.botclient.DrawUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import net.minecraft.client.render.RenderSystem;
import net.minecraft.client.render.OpenGlHelper;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.Identifier;
import org.lwjgl.opengl.GL20;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ShaderUtils {
    private final String roundedRectGradient = "#version 120\\\\n\\\\nuniform vec2 location, rectSize;\\\\nuniform vec4 color1, color2, color3, color4;\\\\nuniform float radius;\\\\n\\\\n#define NOISE .5/255.0\\\\n\\\\nfloat roundSDF(vec2 p, vec2 b, float r) {\\\\n    return length(max(abs(p) - b , 0.0)) - r;\\\\n}\\\\n\\\\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\\\\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\\\\n    //Dithering the color\\\\n    // from https://shader-tutorial.dev/advanced/color-banding-dithering/\\\\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\\\\n    return color;\\\\n}\\\\n\\\\nvoid main() {\\\\n    vec2 st = gl_TexCoord[0].st;\\\\n    vec2 halfSize = rectSize * .5;\\\\n    \\\\n    float smoothedAlpha =  (1.0-smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius))) * color1.a;\\\\n    gl_FragColor = vec4(createGradient(st, color1.rgb, color2.rgb, color3.rgb, color4.rgb), smoothedAlpha);\\\\n}";
    public final int programID;
    private final String roundedOutlinedRect = "#version 120\\\\n\\\\nuniform vec2 location, size;\\\\nuniform vec4 color, outlineColor;\\\\nuniform float radius, thickness;\\\\n\\\\nfloat rounded(vec2 centerPos, vec2 size, float radius) {\\\\n    return length(max(abs(centerPos) - size + radius, 0.0)) - radius;\\\\n}\\\\n\\\\nvoid main()\\\\n{\\\\n    float rSDF = rounded(gl_FragCoord.xy - location - (size/2), (size/2) + (thickness/2) - 1.0, radius);\\\\n\\\\n    float blendAmount = smoothstep(0.0, 2.0, abs(rSDF) - (thickness/2));\\\\n\\\\n    vec4 insideColor = (rSDF < 0.0) ? color : vec4(outlineColor.rgb,  0.0);\\\\n\\\\n    gl_FragColor = mix(outlineColor, insideColor, blendAmount);\\\\n}";
    public static Framebuffer framebuffer;
    public static ShaderUtils shader;
    private String roundedRect;

    private int createShader(InputStream inputStream, int shaderType) {
        int shader = GL20.glCreateShader((int)shaderType);
        GL20.glShaderSource((int)shader, (CharSequence)ShaderUtils.readInputStream(inputStream));
        GL20.glCompileShader((int)shader);
        if (GL20.glGetShaderi((int)shader, (int)(35713)) == 0) {
            (System.out).println(GL20.glGetShaderInfoLog((int)shader, (int)(4096)));
            Object[] objectArray = new Object[1];
            objectArray[0] = shaderType;
            throw new IllegalStateException(String.format("Shader (%s) failed to compile!", objectArray));
        }
        return shader;
    }

    public int getUniform(String name) {
        return GL20.glGetUniformLocation((int)(this.programID), (CharSequence)name);
    }

    private static Minecraft getMc2() {
        return MinecraftContext.mc;
    }

    public static void renderColor(float force) {
        RenderSystem.enableBlend();
        RenderSystem.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        OpenGlHelper.glBlendFunc((int)(770), (int)(771), (int)(1), (int)(0));
        framebuffer = DrawUtils.createFrameBuffer((Framebuffer)(framebuffer));
        (framebuffer).framebufferClear();
        (framebuffer).bindFramebuffer(true);
        (shader).init();
        ShaderUtils.setupUniforms2(force);
        DrawUtils.bindTexture((int)(ShaderUtils.getMc2().getFramebuffer().framebufferTexture));
        ShaderUtils.drawQuads();
        (framebuffer).unbindFramebuffer();
        (shader).unload();
        (MinecraftContext.mc).getFramebuffer().bindFramebuffer(true);
        (shader).init();
        ShaderUtils.setupUniforms2(force);
        DrawUtils.bindTexture((int)((framebuffer).framebufferTexture));
        ShaderUtils.drawQuads();
        (shader).unload();
        RenderSystem.resetColor();
        RenderSystem.bindTexture((int)(0));
    }

    public void setUniformf(String name, float ... args) {
        int loc = GL20.glGetUniformLocation((int)(this.programID), (CharSequence)name);
        switch (args.length) {
            case 1: {
                GL20.glUniform1f((int)loc, (float)args[0]);
                break;
            }
            case 2: {
                GL20.glUniform2f((int)loc, (float)args[0], (float)args[1]);
                break;
            }
            case 3: {
                GL20.glUniform3f((int)loc, (float)args[0], (float)args[1], (float)args[2]);
                break;
            }
            case 4: {
                GL20.glUniform4f((int)loc, (float)args[0], (float)args[1], (float)args[2], (float)args[3]);
            }
        }
    }

    public void setUniformi(String name, int ... args) {
        int loc = GL20.glGetUniformLocation((int)(this.programID), (CharSequence)name);
        if (args.length > (1)) {
            GL20.glUniform2i((int)loc, (int)args[0], (int)args[1]);
        } else {
            GL20.glUniform1i((int)loc, (int)args[0]);
        }
    }

    public void init() {
        GL20.glUseProgram((int)(this.programID));
    }

    public static void drawQuads() {
        float width = (float)mc.getWindow().getScaledWidth();
        float height = (float)mc.getWindow().getScaledHeight();
        RenderSystem.glBegin((int)(7));
        RenderSystem.glTexCoord2f((float)0.0f, (float)1.0f);
        RenderSystem.glVertex2f((float)0.0f, (float)0.0f);
        RenderSystem.glTexCoord2f((float)0.0f, (float)0.0f);
        RenderSystem.glVertex2f((float)0.0f, (float)height);
        RenderSystem.glTexCoord2f((float)1.0f, (float)0.0f);
        RenderSystem.glVertex2f((float)width, (float)height);
        RenderSystem.glTexCoord2f((float)1.0f, (float)1.0f);
        RenderSystem.glVertex2f((float)width, (float)0.0f);
        RenderSystem.glEnd();
    }

    public static String readInputStream(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append((char)(10));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public ShaderUtils(String fragmentShaderLoc) {
        this(fragmentShaderLoc, "neoware/shaders/vertex.vsh");
    }

    static {
        shader = new ShaderUtils("neoware/shaders/white.frag");
        framebuffer = new Framebuffer(1, 1, false);
    }

    public static void drawQuads(float x, float y, float width, float height) {
        RenderSystem.glBegin((int)(7));
        RenderSystem.glTexCoord2f((float)0.0f, (float)0.0f);
        RenderSystem.glVertex2f((float)x, (float)y);
        RenderSystem.glTexCoord2f((float)0.0f, (float)1.0f);
        RenderSystem.glVertex2f((float)x, (float)(y + height));
        RenderSystem.glTexCoord2f((float)1.0f, (float)1.0f);
        RenderSystem.glVertex2f((float)(x + width), (float)(y + height));
        RenderSystem.glTexCoord2f((float)1.0f, (float)0.0f);
        RenderSystem.glVertex2f((float)(x + width), (float)y);
        RenderSystem.glEnd();
    }

public void unload() {
        GL20.glUseProgram((int)(0));
    }

    public static void setupUniforms2(float force) {
        int[] nArray = new int[1];
        nArray[0] = 0;
        (shader).setUniformi("textureIn", nArray);
        float[] fArray = new float[1];
        fArray[0] = force;
        (shader).setUniformf("force", fArray);
    }

    public ShaderUtils(String fragmentShaderLoc, String vertexShaderLoc) {
        this.roundedRect = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color;\nuniform float radius;\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvoid main() {\n    vec2 rectHalf = rectSize * .5;\n    float smoothedAlpha = (1.0 - smoothstep(0.0, 2.0, roundSDF(rectHalf - (gl_TexCoord[0].st * rectSize), rectHalf - radius - 1.0, radius))) * color.a;\n    gl_FragColor = vec4(color.rgb, smoothedAlpha);\n}";
        int program = GL20.glCreateProgram();
        try {
            int fragmentShaderID;
            switch (fragmentShaderLoc) {
                case "roundedRect":
                    fragmentShaderID = this.createShader(new ByteArrayInputStream(this.roundedRect.getBytes()), 35632);
                    break;
                case "roundedOutline":
                    fragmentShaderID = this.createShader(new ByteArrayInputStream(this.roundedOutlinedRect.getBytes()), 35632);
                    break;
                case "roundedRectGradient":
                    fragmentShaderID = this.createShader(new ByteArrayInputStream(this.roundedRectGradient.getBytes()), 35632);
                    break;
                default:
                    fragmentShaderID = this.createShader(MinecraftContext.mc.getResourceManager().getResource(new Identifier(fragmentShaderLoc)).getInputStream(), 35632);
                    break;
            }
            GL20.glAttachShader(program, fragmentShaderID);
            int vertexShaderID = this.createShader(MinecraftContext.mc.getResourceManager().getResource(new Identifier(vertexShaderLoc)).getInputStream(), 35633);
            GL20.glAttachShader(program, vertexShaderID);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        GL20.glLinkProgram(program);
        int status = GL20.glGetProgrami(program, 35714);
        if (status == 0) {
            throw new IllegalStateException("Shader failed to link");
        }
        this.programID = program;
    }

}

