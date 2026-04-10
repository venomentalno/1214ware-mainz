/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.TextSetting
 *  neo.deobf.ThemeSetting
 *  neo.deobf.Setting
 *  neo.deobf.Client
 *  neo.deobf.ModuleManager
 *  neo.deobf.ModuleCategory
 *  neo.deobf.SnowflakeParticle
 *  neo.deobf.BooleanSetting
 *  neo.deobf.ColorSetting
 *  neo.deobf.InfoSetting
 *  neo.deobf.ModeSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.Module
 *  neo.deobf.ClickGuiModule
 *  neo.deobf.AnimationUtils
 *  neo.deobf.BackendApi
 *  neo.deobf.Theme
 *  neo.deobf.FontRendererEx
 *  neo.deobf.FontRegistry
 *  neo.deobf.MillisTimer
 *  neo.deobf.ColorUtils
 *  neo.deobf.GlowUtils
 *  neo.deobf.DrawUtils
 *  neo.deobf.RoundedUtils
 *  neo.deobf.StencilUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.util.ChatAllowedCharacters
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.MathHelper
 *  org.json.JSONArray
 *  org.json.JSONObject
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package neo.deobf;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import neo.deobf.TextSetting;
import neo.deobf.ThemeSetting;
import neo.deobf.Setting;
import neo.deobf.Client;
import neo.deobf.ModuleManager;
import neo.deobf.ModuleCategory;
import neo.deobf.SnowflakeParticle;
import neo.deobf.BooleanSetting;
import neo.deobf.ColorSetting;
import neo.deobf.InfoSetting;
import neo.deobf.ModeSetting;
import neo.deobf.NumberSetting;
import neo.deobf.Module;
import neo.deobf.ClickGuiModule;
import neo.deobf.AnimationUtils;
import neo.deobf.BackendApi;
import neo.deobf.Theme;
import neo.deobf.FontRendererEx;
import neo.deobf.FontRegistry;
import neo.deobf.MillisTimer;
import neo.deobf.ColorUtils;
import neo.deobf.GlowUtils;
import neo.deobf.DrawUtils;
import neo.deobf.RoundedUtils;
import neo.deobf.StencilUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ClickGuiScreen
extends GuiScreen {
    public static float prevY;
    public float scroll = 0.0f;
    public final ArrayList<SnowflakeParticle> effectList;
    public boolean chatTyping;
    public final MillisTimer timer;
    public float openedCategoryAnim;
    public Module components;
    public static float width;
    public static float y;
    public boolean dragging;
    public static float x;
    public int mousex;
    public static Theme currentTheme;
    public String currentMessage;
    public static float prevX;
    public static ModuleCategory selectedCategory;
    public float animScroll = 0.0f;
    public int mousey;
    public static BufferedImage colorpicker;
    public boolean cursor;
    public static float height;

    private void renderModules(int mouseX, int mouseY, float x, float y) {
        ArrayList allModules = (Client.getInstance().moduleManager).getModulesForCategory((selectedCategory));
        int modulesSize = allModules.size();
        ArrayList modulesl = new ArrayList();
        modulesl.add(new ArrayList((Client.getInstance().moduleManager).getModulesForCategory((selectedCategory)).subList(0, modulesSize / (2))));
        modulesl.add(new ArrayList((Client.getInstance().moduleManager).getModulesForCategory((selectedCategory)).subList(modulesSize / (2), modulesSize)));
        int modulesline = 0;
        for (ArrayList arrayList : modulesl) {
            if (++modulesline == (2)) {
                x += 120.0f;
            }
            int offset = 0;
            int offset1 = 0;
            for (Module m : arrayList) {
                ModeSetting modeSetting;
                float modeHeight = 35.0f;
                if ((m.opened)) {
                    for (Setting s : m.getSetting()) {
                        if (!s.isVisible()) continue;
                        if (s instanceof BooleanSetting) {
                            modeHeight += 14.0f;
                            continue;
                        }
                        if (s instanceof ColorSetting) {
                            modeHeight += 39.0f;
                            continue;
                        }
                        if (s instanceof NumberSetting) {
                            modeHeight += 28.0f;
                            continue;
                        }
                        if (s instanceof TextSetting) {
                            modeHeight += 15.0f;
                            continue;
                        }
                        if ((ClickGuiScreen.getWiki2().value) && s instanceof InfoSetting) {
                            modeHeight += (float)(((InfoSetting)s).getLines().length * (10));
                            continue;
                        }
                        if (s instanceof ThemeSetting) {
                            modeHeight += 30.0f;
                            continue;
                        }
                        if (!(s instanceof ModeSetting)) continue;
                        modeSetting = (ModeSetting)s;
                        modeHeight = (float)((double)modeHeight + (18.0 + ((modeSetting.opened) ? 9.1999999999999993 * (double)(modeSetting.modes).size() + 10.0 : 0.0)));
                    }
                }
                RoundedUtils.drawRoundOutline((float)(x + 105.0f), (float)(y + 26.0f + (float)offset + (this.animScroll)), (float)115.0f, (float)modeHeight, (float)3.0f, (float)-0.5f, (Color)new Color(10, 10, 10, 158), (Color)ClickGuiScreen.getC(750));
                if (m.isModuleState()) {
                    int[] nArray = new int[4];
                    nArray[0] = ClickGuiScreen.getC(0).getRGB();
                    nArray[1] = ClickGuiScreen.getC(250).getRGB();
                    nArray[2] = ClickGuiScreen.getC(750).getRGB();
                    nArray[3] = ClickGuiScreen.getC(1000).getRGB();
                    (FontRegistry.mnstb_16).drawGradientString(m.getModuleName().toUpperCase(), (double)(x + 110.0f), (double)(y + 35.0f + (float)offset + (this.animScroll)), nArray, true);
                } else {
                    (FontRegistry.mnstb_16).drawString(m.getModuleName().toUpperCase(), x + 110.0f, y + 35.0f + (float)offset + (this.animScroll), new Color(255, 255, 255).getRGB());
                }
                if ((m.opened)) {
                    for (Setting setting : m.getSetting()) {
                        if (!setting.isVisible()) continue;
                        if (setting instanceof BooleanSetting) {
                            BooleanSetting booleanSetting = (BooleanSetting)setting;
                            (FontRegistry.mnstb_14).drawString((booleanSetting.name), x + 110.0f, y + 60.0f + (float)offset1 + (float)offset + (this.animScroll), new Color(136, 154, 167, 255).getRGB());
                            RoundedUtils.drawRound((float)(x + 193.0f), (float)(y + 57.0f + (float)offset1 + (float)offset + (this.animScroll)), (float)18.0f, (float)10.0f, (float)2.0f, (Color)new Color(18, 23, 43, 255));
                            if ((booleanSetting.value)) {
                                RoundedUtils.drawRound((float)(x + 202.0f), (float)(y + 58.0f + (float)offset1 + (float)offset + (this.animScroll)), (float)8.0f, (float)8.0f, (float)2.0f, (Color)ClickGuiScreen.getC(750));
                            } else {
                                RoundedUtils.drawRound((float)(x + 194.0f), (float)(y + 58.0f + (float)offset1 + (float)offset + (this.animScroll)), (float)8.0f, (float)8.0f, (float)2.0f, (Color)new Color(100, 100, 100));
                            }
                            offset += 14;
                            continue;
                        }
                        if (setting instanceof NumberSetting) {
                            NumberSetting sliderSetting = (NumberSetting)setting;
                            if ((sliderSetting.pressed)) {
                                sliderSetting.value = MathHelper.clamp((float)((float)((double)((float)(mouseX + (51) + (140)) - x - 377.0f) * (double)(ClickGuiScreen.getMax4(sliderSetting) - ClickGuiScreen.getMin(sliderSetting)) / 75.0 + (double)ClickGuiScreen.getMax3(sliderSetting))), (float)ClickGuiScreen.getMin4(sliderSetting), (float)ClickGuiScreen.getMax(sliderSetting));
                                sliderSetting.value = MathHelper.round((float)ClickGuiScreen.getValue7(sliderSetting), (float)ClickGuiScreen.getIncrement(sliderSetting));
                            }
                            (FontRegistry.mnstb_14).drawString((sliderSetting.name), x + 110.0f, y + 59.0f + (float)offset1 + (float)offset + (this.animScroll), new Color(153, 180, 189, 255).getRGB());
                            RoundedUtils.drawRound((float)(x + 110.0f), (float)(y + 60.0f + (float)offset1 + (float)offset + (this.animScroll) + 12.0f), (float)75.0f, (float)3.0f, (float)0.0f, (Color)ClickGuiScreen.getC(750));
                            double widthFormule = ((sliderSetting.value) - (sliderSetting.min)) / ((sliderSetting.max) - (sliderSetting.min)) * 75.0f;
                            sliderSetting.widthAnimated = MathHelper.lerp((double)ClickGuiScreen.getWidthAnimated(sliderSetting), (double)widthFormule, (double)0.14999999999999999);
                            sliderSetting.printAnimated = MathHelper.lerp((double)ClickGuiScreen.getPrintAnimated(sliderSetting), (double)ClickGuiScreen.getValue6(sliderSetting), (double)0.14999999999999999);
                            RoundedUtils.drawRound((float)(x + 110.0f + (sliderSetting.widthAnimated)), (float)(y + 59.0f + (float)offset1 + (float)offset + (this.animScroll) + 12.0f), (float)3.0f, (float)5.0f, (float)0.0f, (Color)new Color(255, 255, 255, 255));
                            sliderSetting.alphaText = (int)MathHelper.lerp((double)ClickGuiScreen.getAlphaText(sliderSetting), (double)(ClickGuiScreen.getPressed2(sliderSetting) ? 208.0 : 100.0), (double)0.050000000000000003);
                            (FontRegistry.sfbolt12).drawString(String.valueOf(MathHelper.round((float)(sliderSetting.printAnimated), (float)(sliderSetting.increment))), x + 80.0f + 110.0f, y + 60.0f + (float)offset1 + (float)offset + (this.animScroll) + 12.0f, new Color(255, 255, 255, 255).getRGB());
                            offset += 28;
                            continue;
                        }
                        if (setting instanceof ColorSetting) {
                            ColorSetting colorSetting = (ColorSetting)setting;
                            (FontRegistry.mnstb_14).drawString((colorSetting.name), x + 110.0f, y + 60.0f + (float)offset1 + (float)offset + (this.animScroll), new Color(153, 180, 189, 255).getRGB());
                            int pickerX = (int)((float)mouseX - (x + 110.0f));
                            int pickerY = (int)((float)mouseY - (y + 70.0f + (float)offset1 + (float)offset + (this.animScroll)));
                            DrawUtils.drawImage((ResourceLocation)new ResourceLocation("neoware/images/colorpicker.png"), (float)(x + 110.0f), (float)(y + 70.0f + (float)offset1 + (float)offset + (this.animScroll)), (float)75.0f, (float)10.0f, (Color)new Color(255, 255, 255));
                            DrawUtils.drawRect((float)(x + 195.0f), (float)(y + 70.0f + (float)offset1 + (float)offset + (this.animScroll)), (float)10.0f, (float)10.0f, (Color)colorSetting.getColorc());
                            if (Mouse.isButtonDown((int)(0)) && pickerX >= 0 && pickerY >= 0 && pickerX < (colorpicker).getWidth() && pickerY < (colorpicker).getHeight()) {
                                colorSetting.color = ClickGuiScreen.getColor((colorpicker), pickerX, pickerY).getRGB();
                                colorSetting.picker = pickerX;
                            }
                            DrawUtils.drawRect((float)(x + 110.0f + (float)(colorSetting.picker)), (float)(y + 69.0f + (float)offset1 + (float)offset + (this.animScroll)), (float)2.0f, (float)12.0f, (Color)new Color(255, 255, 255));
                            offset += 39;
                            continue;
                        }
                        if (setting instanceof TextSetting) {
                            TextSetting textSetting = (TextSetting)setting;
                            (FontRegistry.mnstb_14).drawString((textSetting.name), x + 110.0f, y + 60.0f + (float)offset1 + (float)offset + (this.animScroll), new Color(153, 180, 189, 255).getRGB());
                            RoundedUtils.drawRoundOutline((float)(x + 170.0f), (float)(y + 56.0f + (float)offset1 + (float)offset + (this.animScroll)), (float)47.0f, (float)13.0f, (float)2.0f, (float)-0.300000012f, (Color)new Color(5, 8, 15), (Color)new Color(18, 23, 43, 255));
                            String text = (textSetting.text);
                            int textLength = text.length();
                            (FontRegistry.mnstb_14).drawString(textLength <= (8) ? text : text.substring(textLength - (9), textLength) + ((textSetting.typing) && (this.cursor) ? "_" : ""), x + 143.0f + 30.0f, y + 60.0f + (float)offset1 + (float)offset + (this.animScroll), (textSetting.typing) ? ClickGuiScreen.getC(750).getRGB() : new Color(153, 180, 189, 255).getRGB());
                            offset += 15;
                            continue;
                        }
                        if (setting instanceof ThemeSetting) {
                            ThemeSetting themeSetting = (ThemeSetting)setting;
                            GlowUtils.drawGlowGradientFIX((float)(x + 115.0f), (float)(y + 60.0f + (float)offset1 + (float)offset + (this.animScroll)), (float)95.0f, (float)25.0f, (int)(2), (int)(themeSetting.oneColor).getRGB(), (int)(themeSetting.oneColor).getRGB(), (int)(themeSetting.twoColor).getRGB(), (int)(themeSetting.twoColor).getRGB());
                            offset += 30;
                            continue;
                        }
                        if (setting instanceof ModeSetting) {
                            modeSetting = (ModeSetting)setting;
                            if ((modeSetting.opened)) {
                                RoundedUtils.drawRoundOutline((float)(x + 143.0f - 20.0f + 30.0f), (float)(y + 60.0f + 5.0f + (float)offset1 + (float)offset + (this.animScroll)), (float)62.0f, (float)((float)(modeSetting.modes).size() * 9.19999981f + 18.0f), (float)1.0f, (float)-0.300000012f, (Color)new Color(5, 8, 15), (Color)new Color(18, 23, 43));
                                for (int i = 0; i < (modeSetting.modes).size(); ++i) {
                                    String mode1 = (String)(modeSetting.modes).get(i);
                                    if (i == (modeSetting.index)) {
                                        int[] nArray = new int[4];
                                        nArray[0] = ClickGuiScreen.getC(0).getRGB();
                                        nArray[1] = ClickGuiScreen.getC(250).getRGB();
                                        nArray[2] = ClickGuiScreen.getC(750).getRGB();
                                        nArray[3] = ClickGuiScreen.getC(1000).getRGB();
                                        (FontRegistry.mnstb_14).drawGradientString(mode1, (double)(x + 149.0f - 20.0f + 30.0f), (double)(y + 67.0f + 5.0f + 3.0f - 10.0f + 5.0f + (float)offset1 + (float)offset + (this.animScroll) + 2.0f + (float)(i * (10))), nArray, true);
                                        continue;
                                    }
                                    (FontRegistry.mnstb_14).drawString(mode1, x + 149.0f - 20.0f + 30.0f, y + 67.0f + 5.0f + 3.0f - 10.0f + 5.0f + (float)offset1 + (float)offset + (this.animScroll) + 2.0f + (float)(i * (10)), new Color(152, 175, 188).getRGB());
                                }
                            }
                            (FontRegistry.mnstb_14).drawString((modeSetting.name), x + 80.0f + 30.0f, y + 56.0f + 5.0f + (float)offset1 + (float)offset + (this.animScroll), new Color(153, 180, 189, 255).getRGB());
                            RoundedUtils.drawRoundOutline((float)(x + 143.0f - 20.0f + 30.0f), (float)(y + 52.0f + 5.0f + (float)offset1 + (float)offset + (this.animScroll)), (float)62.0f, (float)13.0f, (float)1.0f, (float)-0.300000012f, (Color)new Color(5, 8, 15), (Color)new Color(18, 23, 43, 255));
                            String mode = (String)(modeSetting.modes).get((modeSetting.index));
                            int[] nArray = new int[4];
                            nArray[0] = ClickGuiScreen.getC(0).getRGB();
                            nArray[1] = ClickGuiScreen.getC(250).getRGB();
                            nArray[2] = ClickGuiScreen.getC(750).getRGB();
                            nArray[3] = ClickGuiScreen.getC(1000).getRGB();
                            (FontRegistry.mnstb_14).drawGradientString(ClickGuiScreen.cutString(mode), (double)(x + 149.0f - 20.0f + 30.0f), (double)(y + 54.0f + 5.0f + (float)offset1 + (float)offset + (this.animScroll) + 2.0f), nArray, true);
                            int[] nArray2 = new int[4];
                            nArray2[0] = ClickGuiScreen.getC(0).getRGB();
                            nArray2[1] = ClickGuiScreen.getC(250).getRGB();
                            nArray2[2] = ClickGuiScreen.getC(750).getRGB();
                            nArray2[3] = ClickGuiScreen.getC(1000).getRGB();
                            (FontRegistry.mnstb_14).drawGradientString((modeSetting.opened) ? "v" : ">", (double)(x + 149.0f - 20.0f + 30.0f + 48.0f), (double)(y + 54.0f + 5.0f + (float)offset1 + (float)offset + (this.animScroll) + 2.0f), nArray2, true);
                            offset = (int)((double)offset + (18.0 + ((modeSetting.opened) ? 9.1999999999999993 * (double)(modeSetting.modes).size() + 10.0 : 0.0)));
                            continue;
                        }
                        if (!(ClickGuiScreen.getWiki3().value) || !(setting instanceof InfoSetting)) continue;
                        InfoSetting infoSetting = (InfoSetting)setting;
                        int offsetInfo = 0;
                        String[] stringArray = infoSetting.getLines();
                        int n = stringArray.length;
                        for (int i = 0; i < n; ++i) {
                            String line = stringArray[i];
                            (FontRegistry.mnstb_10).drawString(line, x + 80.0f + 30.0f, y + 56.0f + 2.0f + (float)offset1 + (float)offset + (float)offsetInfo + (this.animScroll), new Color(230, 230, 230, 255).getRGB());
                            offsetInfo += 10;
                        }
                        offset += ((InfoSetting)setting).getLines().length * (10);
                    }
                }
                offset += 50;
            }
        }
    }

    private static String ijkcbJQnpp(TextSetting instance) {
        return instance.text;
    }

    private static boolean getTyping(TextSetting instance) {
        return instance.typing;
    }

    private static boolean getValue3(BooleanSetting instance) {
        return instance.value;
    }

    private static String getCurrentMessage2(ClickGuiScreen instance) {
        return instance.currentMessage;
    }

    private static float getPrintAnimated(NumberSetting instance) {
        return instance.printAnimated;
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    private static String cutString(String str) {
        if (str.length() > (9)) {
            return str.substring(0, 9) + "..";
        }
        return str;
    }

    private static String getText(TextSetting instance) {
        return instance.text;
    }

    public ClickGuiScreen() {
        this.openedCategoryAnim = 380.0f;
        this.chatTyping = 0;
        this.currentMessage = "";
        this.effectList = new ArrayList();
        this.timer = new MillisTimer();
        if (ClickGuiModule.snow.value) {
            Random random = new Random();
            for (int i = 0; i < (60); ++i) {
                for (int y = 0; y < (3); ++y) {
                    SnowflakeParticle snow = new SnowflakeParticle((25) * i, y * (-50), random.nextInt(3) + (1), random.nextInt(2) + (1));
                    this.effectList.add(snow);
                }
            }
        }
    }

    private static boolean getCursor(ClickGuiScreen instance) {
        return instance.cursor;
    }

    private static BooleanSetting getWiki() {
        return ClickGuiModule.wiki;
    }

    private static boolean getOpened3(Module instance) {
        return instance.opened;
    }

    private static float getMax(NumberSetting instance) {
        return instance.max;
    }

    public boolean isHovered(int mouseX, int mouseY, double x, double y, double width, double height) {
        return ((double)mouseX >= x && (double)mouseX <= x + width && (double)mouseY >= y && (double)mouseY <= y + height ? 1 : 0) != 0;
    }

    public static Color getColor(BufferedImage img, int x, int y) {
        int clr = img.getRGB(x, y);
        int red = (clr & (16711680)) >> (16);
        int green = (clr & (65280)) >> (8);
        int blue = clr & (255);
        return new Color(red, green, blue);
    }

    public void handleMouseInput() throws IOException {
        if (Mouse.hasWheel() && this.isHovered((this.mousex), (this.mousey), (x) + 80.0f, (y), (width), (height))) {
            int mouse = Mouse.getDWheel();
            if (mouse > 0) {
                ClickGuiScreen br = this;
                br.scroll = ClickGuiScreen.getScroll2(br) + 50.0f;
            } else if (mouse < 0) {
                ClickGuiScreen br = this;
                br.scroll = ClickGuiScreen.getScroll4(br) - 50.0f;
            }
        }
        super.handleMouseInput();
    }

    private static int getAlphaText(NumberSetting instance) {
        return instance.alphaText;
    }

    private static float getIncrement(NumberSetting instance) {
        return instance.increment;
    }

    private static float getValue6(NumberSetting instance) {
        return instance.value;
    }

    private static String getText4(TextSetting instance) {
        return instance.text;
    }

    private static float getMin(NumberSetting instance) {
        return instance.min;
    }

    private static float getWidthAnimated(NumberSetting instance) {
        return instance.widthAnimated;
    }

    private static boolean jrabjbADyg(ModeSetting instance) {
        return instance.opened;
    }

    private static BooleanSetting getWiki2() {
        return ClickGuiModule.wiki;
    }

    private static float getScroll2(ClickGuiScreen instance) {
        return instance.scroll;
    }

    public static Color getC(int index) {
        return ColorUtils.TwoColorEffect((Color)(currentTheme).getOneColor(), (Color)(currentTheme).getTwoColor(), (double)5.0, (int)index);
    }

    private static float getMax3(NumberSetting instance) {
        return instance.max;
    }

    private static float getValue7(NumberSetting instance) {
        return instance.value;
    }

    private static float getScroll3(ClickGuiScreen instance) {
        return instance.scroll;
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        for (Module module : (Client.getInstance().moduleManager).getModulesForCategory((selectedCategory))) {
            for (Setting setting : module.getSetting()) {
                if (!setting.isVisible() || !(setting instanceof NumberSetting)) continue;
                NumberSetting sliderSetting = (NumberSetting)setting;
                sliderSetting.pressed = false;
            }
        }
    }

    private static String getText5(TextSetting instance) {
        return instance.text;
    }

    private static String getCurrentMessage7(ClickGuiScreen instance) {
        return instance.currentMessage;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.mousex = mouseX;
        this.mousey = mouseY;
        if ((this.scroll) >= 0.0f) {
            this.scroll = 0.0f;
        }
        this.animScroll = AnimationUtils.animation((float)ClickGuiScreen.getAnimScroll32(this), (float)ClickGuiScreen.getScroll3(this), (float)5.50000004E-06f);
        GlowUtils.drawGlowGradientFIX((float)((x) - 4.0f), (float)((y) - 4.0f), (float)((width) + 10.0f), (float)((height) + 10.0f), (int)(15), (int)ClickGuiScreen.getC(0).getRGB(), (int)ClickGuiScreen.getC(250).getRGB(), (int)ClickGuiScreen.getC(750).getRGB(), (int)ClickGuiScreen.getC(1000).getRGB());
        RoundedUtils.drawRound((float)((x) + 1.0f), (float)((y) + 2.0f), (float)(width), (float)(height), (float)2.0f, (Color)new Color(17, 17, 17, 255));
        StencilUtils.initStencilToWrite();
        StencilUtils.readStencilBuffer((int)(1));
        DrawUtils.drawBlurredShadow((float)((x) + 170.0f), (float)(y), (float)((width) - 160.0f), (float)(height), (int)(5), (Color)new Color(255, 0, 0, 255));
        DrawUtils.drawBlurredShadow((float)((x) + 175.0f), (float)(y), (float)1.0f, (float)(height), (int)(0), (Color)new Color(0, 60, 255, 255));
        DrawUtils.drawBlurredShadow((float)((x) + 34.0f), (float)((y) + 270.0f), (float)140.0f, (float)1.0f, (int)(0), (Color)new Color(239, 8, 255, 255));
        StencilUtils.initStencilToWrite();
        DrawUtils.drawFCircle((float)((x) + 19.0f), (float)((y) + 326.0f), (float)0.0f, (float)360.0f, (float)9.0f, true, (Color)new Color(26, 80, 67, 255));
        StencilUtils.readStencilBuffer((int)(1));
        DrawUtils.drawCircle((float)((x) + 43.0f), (float)((y) + 272.0f), (float)0.0f, (float)360.0f, (float)0.0f, (int)new Color(0, 0, 0, 255).getRGB(), (int)(2));
        StencilUtils.initStencilToWrite();
        RoundedUtils.drawRound((float)(x), (float)((y) + 2.0f), (float)(width), (float)(height), (float)0.0f, false, (Color)new Color(0, 0, 0, 255));
        StencilUtils.readStencilBuffer((int)(1));
        RoundedUtils.drawRound((float)((x) + 1.0f), (float)((y) + 2.0f), (float)25.0f, (float)(height), (float)2.0f, (Color)new Color(25, 25, 25, 255));
        RoundedUtils.drawRound((float)((x) + 10.0f), (float)((y) + 2.0f), (float)80.0f, (float)(height), (float)0.0f, (Color)new Color(25, 25, 25, 255));
        DrawUtils.drawImage((ResourceLocation)new ResourceLocation("neoware/images/neoware.png"), (float)((x) + 10.0f), (float)((y) + 10.0f), (float)20.0f, (float)20.0f, (Color)new Color(255, 255, 255));
        int[] nArray = new int[4];
        nArray[0] = ClickGuiScreen.getC(0).getRGB();
        nArray[1] = ClickGuiScreen.getC(250).getRGB();
        nArray[2] = ClickGuiScreen.getC(750).getRGB();
        nArray[3] = ClickGuiScreen.getC(1000).getRGB();
        (FontRegistry.mnstb_14).drawGradientString("NeoWare", (double)((x) + 36.0f), (double)((y) + 13.0f), nArray, true);
        (FontRegistry.mnstb_14).drawString("v" + (Client.VERSION_TYPE) + " recode", (x) + 36.0f, (y) + 23.0f, new Color(255, 255, 255, 255).getRGB());
        int offset1 = 0;
        ModuleCategory[] bVArray = ModuleCategory.values();
        int n = bVArray.length;
        for (int i = 0; i < n; ++i) {
            ModuleCategory category = bVArray[i];
            if ((selectedCategory) == category) {
                int[] nArray2 = new int[4];
                nArray2[0] = ClickGuiScreen.getC(0).getRGB();
                nArray2[1] = ClickGuiScreen.getC(250).getRGB();
                nArray2[2] = ClickGuiScreen.getC(750).getRGB();
                nArray2[3] = ClickGuiScreen.getC(1000).getRGB();
                (FontRegistry.mnstb_16).drawGradientString(category.name(), (double)((x) + 35.0f), (double)((y) + 67.0f + (float)offset1), nArray2, true);
            } else {
                (FontRegistry.mnstb_16).drawString(category.name(), (x) + 35.0f, (y) + 67.0f + (float)offset1, new Color(255, 255, 255, 255).getRGB());
            }
            (FontRegistry.icons22).drawString(category.getIcon(), (x) + 14.0f, (y) + 67.0f + (float)offset1, category.getColor().getRGB());
            offset1 += category.getOffset();
        }
        this.openedCategoryAnim = (float)AnimationUtils.Interpolate((double)ClickGuiScreen.getOpenedCategoryAnim(this), (double)0.0, (double)0.10000000149011612);
        this.renderModules(mouseX, mouseY, (x), (y));
        if ((selectedCategory) == (ModuleCategory.Chat)) {
            RoundedUtils.drawRound((float)((x) + 110.0f), (float)((y) + 10.0f), (float)260.0f, (float)230.0f, (float)0.0f, (Color)new Color(0, 0, 0, 255));
            RoundedUtils.drawRound((float)((x) + 110.0f), (float)((y) + 240.0f), (float)260.0f, (float)15.0f, (float)0.0f, (Color)new Color(25, 25, 25, 255));
            (FontRegistry.mnstb_16).drawString(((this.currentMessage).length() > (40) ? (this.currentMessage).substring((this.currentMessage).length() - (40)) : (this.currentMessage)) + ((this.chatTyping) ? ((this.cursor) ? "_" : "") : ""), (x) + 115.0f, (y) + 245.0f, new Color(255, 255, 255, 255).getRGB());
            int offset = 0;
            if (BackendApi.getResponse() != null) {
                JSONObject response = BackendApi.getResponse();
                if (response.getJSONArray("messages") != null) {
                    JSONArray messages = response.getJSONArray("messages");
                    for (int index = 0; index < messages.length(); ++index) {
                        JSONObject message = messages.getJSONObject(index);
                        (FontRegistry.mnstb_16).drawString(message.getString("nickname") + (message.getString("nickname").isEmpty() ? "" : ": ") + message.getString("message"), (x) + 115.0f, (y) + 15.0f + (float)offset, new Color(255, 255, 255, 255).getRGB());
                        offset += 8;
                    }
                }
            } else {
                (FontRegistry.mnstb_16).drawString("Сервера NeoWare недоступны. Попробуйте позже", (x) + 115.0f, (y) + 15.0f + (float)offset, new Color(255, 43, 43, 255).getRGB());
            }
            if ((this.timer).hasReached(800.0)) {
                (this.timer).reset();
                this.cursor = (!ClickGuiScreen.getCursor(this) ? 1 : 0) != 0;
            }
        }
        StencilUtils.uninitStencilBuffer();
        if ((this.dragging) && Mouse.isButtonDown((int)(0))) {
            x = (float)mouseX + (prevX);
            y = (float)mouseY + (prevY);
        } else {
            this.dragging = false;
        }
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        if ((ClickGuiScreen.getSnow().value) && !(this.effectList).isEmpty()) {
            (this.effectList).forEach(snow -> snow.update(sr));
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        int offset;
        if (!this.isHovered(mouseX, mouseY, (x), (y), (width), (height))) {
            return;
        }
        if (this.isHovered(mouseX, mouseY, (x), (y), 340.0, 25.0) && mouseButton == 0) {
            this.dragging = true;
            prevX = (x) - (float)mouseX;
            prevY = (y) - (float)mouseY;
        }
        if (this.isHovered(mouseX, mouseY, (x), (y), 340.0, 25.0) && mouseButton == 0) {
            this.dragging = true;
            prevX = (x) - (float)mouseX;
            prevY = (y) - (float)mouseY;
        }
        this.chatTyping = (this.isHovered(mouseX, mouseY, (x) + 110.0f, (y) + 240.0f, 260.0, 15.0) && mouseButton == 0 ? 1 : 0) != 0;
        ArrayList allModules = (Client.getInstance().moduleManager).getModulesForCategory((selectedCategory));
        int modulesSize = allModules.size();
        ArrayList modulesl = new ArrayList();
        modulesl.add(new ArrayList((Client.getInstance().moduleManager).getModulesForCategory((selectedCategory)).subList(0, modulesSize / (2))));
        modulesl.add(new ArrayList((Client.getInstance().moduleManager).getModulesForCategory((selectedCategory)).subList(modulesSize / (2), modulesSize)));
        int modulesline = 0;
        int offset1 = 0;
        for (ArrayList arrayList : modulesl) {
            if (++modulesline == (2)) {
                offset1 = 120;
            }
            offset = 0;
            for (Module module : arrayList) {
                if (this.isHovered(mouseX, mouseY, (x) + 105.0f + (float)offset1, (y) + 26.0f + (float)offset + (this.animScroll), 115.0, 25.0)) {
                    if (mouseButton == 0) {
                        module.toggle();
                    } else if (mouseButton == (1) && !module.getModuleCategory().equals((Object)(ModuleCategory.Themes))) {
                        module.opened = (!ClickGuiScreen.getOpened3(module) ? 1 : 0) != 0;
                    }
                }
                if ((module.opened)) {
                    for (Setting setting : module.getSetting()) {
                        if (!setting.isVisible()) continue;
                        if (setting instanceof BooleanSetting) {
                            BooleanSetting booleanSetting = (BooleanSetting)setting;
                            if (this.isHovered(mouseX, mouseY, (x) + 193.0f + (float)offset1, (y) + 57.0f + (float)offset + (this.animScroll), 18.0, 10.0)) {
                                booleanSetting.value = (!ClickGuiScreen.getValue3(booleanSetting) ? 1 : 0) != 0;
                            }
                            offset += 14;
                            continue;
                        }
                        if (setting instanceof NumberSetting) {
                            NumberSetting sliderSetting = (NumberSetting)setting;
                            if (this.isHovered(mouseX, mouseY, (x) + 110.0f + (float)offset1, (y) + 51.0f + (float)offset + (this.animScroll) + 12.0f, 75.0, 24.0)) {
                                sliderSetting.pressed = true;
                            }
                            offset += 28;
                            continue;
                        }
                        if (setting instanceof ColorSetting) {
                            offset += 39;
                            continue;
                        }
                        if (setting instanceof ThemeSetting) {
                            ThemeSetting themeSetting = (ThemeSetting)setting;
                            if (this.isHovered(mouseX, mouseY, (x) + 105.0f + (float)offset1, (y) + 26.0f + (float)offset + (this.animScroll), 115.0, 65.0) && mouseButton == 0) {
                                currentTheme = themeSetting.getTheme();
                            }
                            offset += 30;
                            continue;
                        }
                        if (setting instanceof TextSetting) {
                            TextSetting textSetting = (TextSetting)setting;
                            if (this.isHovered(mouseX, mouseY, (x) + 140.0f + (float)offset1, (y) + 60.0f + (float)offset + (this.animScroll), 85.0, 13.0)) {
                                textSetting.typing = (!ClickGuiScreen.getTyping(textSetting) ? 1 : 0) != 0;
                            } else {
                                textSetting.typing = false;
                            }
                            offset += 15;
                            continue;
                        }
                        if (setting instanceof ModeSetting) {
                            ModeSetting modeSetting = (ModeSetting)setting;
                            if (this.isHovered(mouseX, mouseY, (x) + 144.0f - 20.0f + (float)offset1 + 30.0f, (y) + 51.0f + 5.0f + 5.0f - 4.0f + (float)offset + (this.animScroll), 50.0, 12.0)) {
                                modeSetting.opened = (!ClickGuiScreen.jrabjbADyg(modeSetting) ? 1 : 0) != 0;
                            }
                            if ((modeSetting.opened)) {
                                for (int i = 0; i < (modeSetting.modes).size(); ++i) {
                                    if (!this.isHovered(mouseX, mouseY, (x) + 144.0f - 20.0f + (float)offset1 + 30.0f, (y) + 68.0f + 5.0f + 5.0f - 10.0f + (float)offset + (this.animScroll) + (float)(i * (10)), 50.0, 10.0)) continue;
                                    modeSetting.index = i;
                                }
                            }
                            offset = (int)((double)offset + (18.0 + ((modeSetting.opened) ? 9.1999999999999993 * (double)(modeSetting.modes).size() + 10.0 : 0.0)));
                            continue;
                        }
                        if (!(ClickGuiScreen.getWiki().value) || !(setting instanceof InfoSetting)) continue;
                        offset += ((InfoSetting)setting).getLines().length * (10);
                    }
                }
                offset += 50;
            }
        }
        offset = 0;
        ModuleCategory[] bVArray = ModuleCategory.values();
        int n = bVArray.length;
        for (int i = 0; i < n; ++i) {
            ModuleCategory category = bVArray[i];
            if (this.isHovered(mouseX, mouseY, (x) - 1.0f, (y) + 64.0f + (float)offset, 80.0, 17.0) && mouseButton == 0 && category != (selectedCategory)) {
                selectedCategory = category;
                if (category == (ModuleCategory.Chat)) {
                    BackendApi.runSync();
                }
                this.openedCategoryAnim = 380.0f;
                this.scroll = 0.0f;
                this.animScroll = 0.0f;
            }
            offset += category.getOffset();
        }
    }

    private static BooleanSetting getSnow() {
        return ClickGuiModule.snow;
    }

    private static String getCurrentMessage8(ClickGuiScreen instance) {
        return instance.currentMessage;
    }

    static {
        selectedCategory = ModuleCategory.Bots;
        x = 65.0f;
        y = 5.0f;
        width = 370.0f;
        height = 265.0f;
        try {
            colorpicker = ImageIO.read(Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("neoware/images/colorpicker.png")).getInputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BooleanSetting getWiki3() {
        return ClickGuiModule.wiki;
    }

    public void keyTyped(char c, int key) throws IOException {
        super.keyTyped(c, key);
        if ((this.chatTyping)) {
            if (ChatAllowedCharacters.isAllowedCharacter((char)c)) {
                ClickGuiScreen br = this;
                br.currentMessage = ClickGuiScreen.getCurrentMessage2(br) + c;
            }
            if (key == (14) && (this.currentMessage).length() > 0) {
                this.currentMessage = ClickGuiScreen.getCurrentMessage10(this).substring(0, ClickGuiScreen.getCurrentMessage8(this).length() - (1));
            }
            if (Keyboard.isKeyDown((int)(29)) && Keyboard.isKeyDown((int)(47))) {
                ClickGuiScreen br = this;
                br.currentMessage = ClickGuiScreen.getCurrentMessage7(br) + ClickGuiScreen.getClipboardString();
            }
            if (key == (28) && !(this.currentMessage).equals("")) {
                BackendApi.sendMessage((String)(this.currentMessage));
                this.currentMessage = "";
            }
        }
        for (Module module : (Client.getInstance().moduleManager).getModulesForCategory((selectedCategory))) {
            for (Setting setting : module.getSetting()) {
                if (!setting.isVisible() || !(setting instanceof TextSetting)) continue;
                TextSetting textSetting = (TextSetting)setting;
                if ((textSetting.typing)) {
                    Keyboard.enableRepeatEvents(true);
                    if (ChatAllowedCharacters.isAllowedCharacter((char)c)) {
                        TextSetting bA = (TextSetting)setting;
                        bA.text = ClickGuiScreen.getText(bA) + c;
                    }
                    if (key == (14) && ((TextSetting)setting.text).length() > 0) {
                        (TextSetting)setting.text = ClickGuiScreen.getText4((TextSetting)setting).substring(0, ClickGuiScreen.ijkcbJQnpp((TextSetting)setting).length() - (1));
                    }
                    if (Keyboard.isKeyDown((int)(29)) && Keyboard.isKeyDown((int)(47))) {
                        TextSetting bA = (TextSetting)setting;
                        bA.text = ClickGuiScreen.getText5(bA) + ClickGuiScreen.getClipboardString();
                    }
                }
                if (key != (1) && key != (28)) continue;
                textSetting.typing = false;
            }
        }
    }

    private static String getCurrentMessage10(ClickGuiScreen instance) {
        return instance.currentMessage;
    }

    private static float getOpenedCategoryAnim(ClickGuiScreen instance) {
        return instance.openedCategoryAnim;
    }

    private static boolean getPressed2(NumberSetting instance) {
        return instance.pressed;
    }

    private static float getMax4(NumberSetting instance) {
        return instance.max;
    }

    private static float getScroll4(ClickGuiScreen instance) {
        return instance.scroll;
    }

    private static float getAnimScroll32(ClickGuiScreen instance) {
        return instance.animScroll;
    }

    public void onGuiClosed() {
        this.openedCategoryAnim = 380.0f;
    }

    private static float getMin4(NumberSetting instance) {
        return instance.min;
    }

}

