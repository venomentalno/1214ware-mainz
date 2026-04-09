package com.botclient;

import com.botclient.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.util.Identifier;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.lwjgl.glfw.GLFW;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;

public class ClickGuiScreen extends Screen {
    public static float prevY;
    public float scroll = 0.0f;
    public final ArrayList<SnowflakeParticle> effectList = new ArrayList<>();
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

    public ClickGuiScreen() {
        super(Text.of("ClickGui"));
        this.openedCategoryAnim = 380.0f;
        this.chatTyping = false;
        this.currentMessage = "";
        this.timer = new MillisTimer();

        if (ClickGuiModule.snow.value) {
            Random random = new Random();
            for (int i = 0; i < 60; ++i) {
                for (int j = 0; j < 3; ++j) {
                    this.effectList.add(new SnowflakeParticle(25 * i, j * -50, random.nextInt(3) + 1, random.nextInt(2) + 1));
                }
            }
        }
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.mousex = mouseX;
        this.mousey = mouseY;

        if (this.scroll >= 0.0f) this.scroll = 0.0f;
        this.animScroll = AnimationUtils.animation(this.animScroll, this.scroll, 5.5e-06f);

        // Background & Borders (Assuming DrawUtils/RoundedUtils are updated to DrawContext)
        GlowUtils.drawGlowGradientFIX(x - 4.0f, y - 4.0f, width + 10.0f, height + 10.0f, 15,
                getC(0).getRGB(), getC(250).getRGB(), getC(750).getRGB(), getC(1000).getRGB());
        RoundedUtils.drawRound(x + 1.0f, y + 2.0f, width, height, 2.0f, new Color(17, 17, 17, 255));

        StencilUtils.initStencilToWrite();
        StencilUtils.readStencilBuffer(1);
        DrawUtils.drawBlurredShadow(x + 170.0f, y, width - 160.0f, height, 5, new Color(255, 0, 0, 255));
        DrawUtils.drawBlurredShadow(x + 175.0f, y, 1.0f, height, 0, new Color(0, 60, 255, 255));
        DrawUtils.drawBlurredShadow(x + 34.0f, y + 270.0f, 140.0f, 1.0f, 0, new Color(239, 8, 255, 255));

        StencilUtils.initStencilToWrite();
        DrawUtils.drawFCircle(x + 19.0f, y + 326.0f, 0.0f, 360.0f, 9.0f, true, new Color(26, 80, 67, 255));
        StencilUtils.readStencilBuffer(1);
        DrawUtils.drawCircle(x + 43.0f, y + 272.0f, 0.0f, 360.0f, 0.0f, new Color(0, 0, 0, 255).getRGB(), 2);

        StencilUtils.initStencilToWrite();
        RoundedUtils.drawRound(x, y + 2.0f, width, height, 0.0f, false, new Color(0, 0, 0, 255));
        StencilUtils.readStencilBuffer(1);
        RoundedUtils.drawRound(x + 1.0f, y + 2.0f, 25.0f, height, 2.0f, new Color(25, 25, 25, 255));
        RoundedUtils.drawRound(x + 10.0f, y + 2.0f, 80.0f, height, 0.0f, new Color(25, 25, 25, 255));

        DrawUtils.drawImage(new Identifier("neoware/images/neoware.png"), x + 10.0f, y + 10.0f, 20.0f, 20.0f, new Color(255, 255, 255));

        int[] gradientColors = new int[]{getC(0).getRGB(), getC(250).getRGB(), getC(750).getRGB(), getC(1000).getRGB()};
        FontRegistry.mnstb_14.drawGradientString("NeoWare", x + 36.0f, y + 13.0f, gradientColors, true);
        FontRegistry.mnstb_14.drawString("v" + Client.VERSION_TYPE + " recode", x + 36.0f, y + 23.0f, new Color(255, 255, 255, 255).getRGB());

        int offset1 = 0;
        for (ModuleCategory category : ModuleCategory.values()) {
            if (selectedCategory == category) {
                FontRegistry.mnstb_16.drawGradientString(category.name(), x + 35.0f, y + 67.0f + offset1, gradientColors, true);
            } else {
                FontRegistry.mnstb_16.drawString(category.name(), x + 35.0f, y + 67.0f + offset1, new Color(255, 255, 255, 255).getRGB());
            }
            FontRegistry.icons22.drawString(category.getIcon(), x + 14.0f, y + 67.0f + offset1, category.getColor().getRGB());
            offset1 += category.getOffset();
        }

        this.openedCategoryAnim = AnimationUtils.animation(this.openedCategoryAnim, 0.0f, 0.10000000149011612f);
        this.renderModules(mouseX, mouseY, x, y);

        if (selectedCategory == ModuleCategory.Chat) {
            RoundedUtils.drawRound(x + 110.0f, y + 10.0f, 260.0f, 230.0f, 0.0f, new Color(0, 0, 0, 255));
            RoundedUtils.drawRound(x + 110.0f, y + 240.0f, 260.0f, 15.0f, 0.0f, new Color(25, 25, 25, 255));

            String displayMsg = currentMessage.length() > 40 ? currentMessage.substring(currentMessage.length() - 40) : currentMessage;
            if (chatTyping && cursor) displayMsg += "_";
            FontRegistry.mnstb_16.drawString(displayMsg, x + 115.0f, y + 245.0f, new Color(255, 255, 255, 255).getRGB());

            int chatOffset = 0;
            if (BackendApi.getResponse() != null) {
                JSONObject response = BackendApi.getResponse();
                if (response.has("messages")) {
                    JSONArray messages = response.getJSONArray("messages");
                    for (int i = 0; i < messages.length(); ++i) {
                        JSONObject message = messages.getJSONObject(i);
                        String nick = message.getString("nickname");
                        FontRegistry.mnstb_16.drawString((nick.isEmpty() ? "" : nick + ": ") + message.getString("message"), x + 115.0f, y + 15.0f + chatOffset, new Color(255, 255, 255, 255).getRGB());
                        chatOffset += 8;
                    }
                }
            } else {
                FontRegistry.mnstb_16.drawString("Сервера NeoWare недоступны. Попробуйте позже", x + 115.0f, y + 15.0f + chatOffset, new Color(255, 43, 43, 255).getRGB());
            }

            if (this.timer.hasReached(800.0)) {
                this.timer.reset();
                this.cursor = !this.cursor;
            }
        }

        StencilUtils.uninitStencilBuffer();

        if (this.dragging && GLFW.glfwGetMouseButton(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS) {
            x = mouseX + prevX;
            y = mouseY + prevY;
        } else {
            this.dragging = false;
        }

        if (ClickGuiModule.snow.value && !this.effectList.isEmpty()) {
            this.effectList.forEach(snow -> snow.update(null)); // Pass null or adapt snow.update to not need ScaledResolution
        }

        super.render(context, mouseX, mouseY, delta);
    }

    private void renderModules(int mouseX, int mouseY, float x, float y) {
        ArrayList<Module> allModules = Client.getInstance().moduleManager.getModulesForCategory(selectedCategory);
        int size = allModules.size();
        ArrayList<ArrayList<Module>> columns = new ArrayList<>();
        columns.add(new ArrayList<>(allModules.subList(0, size / 2)));
        columns.add(new ArrayList<>(allModules.subList(size / 2, size)));

        int offset1 = 0;
        for (ArrayList<Module> column : columns) {
            int offset = 0;
            for (Module m : column) {
                float modeHeight = 35.0f;
                if (m.opened) {
                    for (Setting s : m.getSetting()) {
                        if (!s.isVisible()) continue;
                        if (s instanceof BooleanSetting) modeHeight += 14.0f;
                        else if (s instanceof ColorSetting) modeHeight += 39.0f;
                        else if (s instanceof NumberSetting) modeHeight += 28.0f;
                        else if (s instanceof TextSetting) modeHeight += 15.0f;
                        else if (ClickGuiModule.wiki.value && s instanceof InfoSetting) modeHeight += ((InfoSetting) s).getLines().length * 10.0f;
                        else if (s instanceof ThemeSetting) modeHeight += 30.0f;
                        else if (s instanceof ModeSetting) {
                            ModeSetting ms = (ModeSetting) s;
                            modeHeight += 18.0f + (ms.opened ? 9.2f * ms.modes.size() + 10.0f : 0.0f);
                        }
                    }
                }

                RoundedUtils.drawRoundOutline(x + 105.0f + offset1, y + 26.0f + offset + this.animScroll, 115.0f, modeHeight, 3.0f, -0.5f, new Color(10, 10, 10, 158), getC(750));

                if (m.isModuleState()) {
                    FontRegistry.mnstb_16.drawGradientString(m.getModuleName().toUpperCase(), x + 110.0f + offset1, y + 35.0f + offset + this.animScroll, new int[]{getC(0).getRGB(), getC(250).getRGB(), getC(750).getRGB(), getC(1000).getRGB()}, true);
                } else {
                    FontRegistry.mnstb_16.drawString(m.getModuleName().toUpperCase(), x + 110.0f + offset1, y + 35.0f + offset + this.animScroll, new Color(255, 255, 255).getRGB());
                }

                if (m.opened) {
                    int settingOffset = 0;
                    for (Setting setting : m.getSetting()) {
                        if (!setting.isVisible()) continue;
                        if (setting instanceof BooleanSetting) {
                            BooleanSetting bs = (BooleanSetting) setting;
                            FontRegistry.mnstb_14.drawString(bs.name, x + 110.0f + offset1, y + 60.0f + settingOffset + offset + this.animScroll, new Color(136, 154, 167, 255).getRGB());
                            RoundedUtils.drawRound(x + 193.0f + offset1, y + 57.0f + settingOffset + offset + this.animScroll, 18.0f, 10.0f, 2.0f, new Color(18, 23, 43, 255));
                            if (bs.value) RoundedUtils.drawRound(x + 202.0f + offset1, y + 58.0f + settingOffset + offset + this.animScroll, 8.0f, 8.0f, 2.0f, getC(750));
                            else RoundedUtils.drawRound(x + 194.0f + offset1, y + 58.0f + settingOffset + offset + this.animScroll, 8.0f, 8.0f, 2.0f, new Color(100, 100, 100));
                            settingOffset += 14;
                        } else if (setting instanceof NumberSetting) {
                            NumberSetting ns = (NumberSetting) setting;
                            if (ns.pressed) {
                                ns.value = MathHelper.clamp(((float)(mouseX + 51 + 140) - x - 377.0f + offset1) * (ns.max - ns.min) / 75.0f + ns.min, ns.min, ns.max);
                                ns.value = Math.round(ns.value / ns.increment) * ns.increment;
                            }
                            FontRegistry.mnstb_14.drawString(ns.name, x + 110.0f + offset1, y + 59.0f + settingOffset + offset + this.animScroll, new Color(153, 180, 189, 255).getRGB());
                            RoundedUtils.drawRound(x + 110.0f + offset1, y + 60.0f + settingOffset + offset + this.animScroll + 12.0f, 75.0f, 3.0f, 0.0f, getC(750));
                            double widthFormule = ((ns.value) - ns.min) / (ns.max - ns.min) * 75.0;
                            ns.widthAnimated = MathHelper.lerp(ns.widthAnimated, (float) widthFormule, 0.15f);
                            ns.printAnimated = MathHelper.lerp(ns.printAnimated, ns.value, 0.15f);
                            RoundedUtils.drawRound(x + 110.0f + offset1 + ns.widthAnimated, y + 59.0f + settingOffset + offset + this.animScroll + 12.0f, 3.0f, 5.0f, 0.0f, new Color(255, 255, 255, 255));
                            FontRegistry.sfbolt12.drawString(String.valueOf(Math.round(ns.printAnimated / ns.increment) * ns.increment), x + 190.0f + offset1, y + 60.0f + settingOffset + offset + this.animScroll + 12.0f, new Color(255, 255, 255, 255).getRGB());
                            settingOffset += 28;
                        } else if (setting instanceof ColorSetting) {
                            ColorSetting cs = (ColorSetting) setting;
                            FontRegistry.mnstb_14.drawString(cs.name, x + 110.0f + offset1, y + 60.0f + settingOffset + offset + this.animScroll, new Color(153, 180, 189, 255).getRGB());
                            int pickerX = mouseX - (int)(x + 110.0f + offset1);
                            int pickerY = mouseY - (int)(y + 70.0f + settingOffset + offset + this.animScroll);
                            DrawUtils.drawImage(new Identifier("neoware/images/colorpicker.png"), x + 110.0f + offset1, y + 70.0f + settingOffset + offset + this.animScroll, 75.0f, 10.0f, new Color(255, 255, 255));
                            DrawUtils.drawRect(x + 195.0f + offset1, y + 70.0f + settingOffset + offset + this.animScroll, 10.0f, 10.0f, cs.getColorc());
                            if (GLFW.glfwGetMouseButton(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS && pickerX >= 0 && pickerY >= 0 && pickerX < colorpicker.getWidth() && pickerY < colorpicker.getHeight()) {
                                cs.color = getColor(colorpicker, pickerX, pickerY).getRGB();
                                cs.picker = pickerX;
                            }
                            DrawUtils.drawRect(x + 110.0f + offset1 + cs.picker, y + 69.0f + settingOffset + offset + this.animScroll, 2.0f, 12.0f, new Color(255, 255, 255));
                            settingOffset += 39;
                        } else if (setting instanceof TextSetting) {
                            TextSetting ts = (TextSetting) setting;
                            FontRegistry.mnstb_14.drawString(ts.name, x + 110.0f + offset1, y + 60.0f + settingOffset + offset + this.animScroll, new Color(153, 180, 189, 255).getRGB());
                            RoundedUtils.drawRoundOutline(x + 170.0f + offset1, y + 56.0f + settingOffset + offset + this.animScroll, 47.0f, 13.0f, 2.0f, -0.3f, new Color(5, 8, 15), new Color(18, 23, 43, 255));
                            String text = ts.text;
                            FontRegistry.mnstb_14.drawString(text.length() <= 8 ? text + (ts.typing && this.cursor ? "_" : "") : text.substring(text.length() - 9) + (ts.typing && this.cursor ? "_" : ""), x + 173.0f + offset1, y + 60.0f + settingOffset + offset + this.animScroll, ts.typing ? getC(750).getRGB() : new Color(153, 180, 189, 255).getRGB());
                            settingOffset += 15;
                        } else if (setting instanceof ThemeSetting) {
                            ThemeSetting ths = (ThemeSetting) setting;
                            GlowUtils.drawGlowGradientFIX(x + 115.0f + offset1, y + 60.0f + settingOffset + offset + this.animScroll, 95.0f, 25.0f, 2, ths.oneColor.getRGB(), ths.oneColor.getRGB(), ths.twoColor.getRGB(), ths.twoColor.getRGB());
                            settingOffset += 30;
                        } else if (setting instanceof ModeSetting) {
                            ModeSetting ms = (ModeSetting) setting;
                            if (ms.opened) {
                                RoundedUtils.drawRoundOutline(x + 153.0f + offset1, y + 65.0f + settingOffset + offset + this.animScroll, 62.0f, ms.modes.size() * 9.2f + 18.0f, 1.0f, -0.3f, new Color(5, 8, 15), new Color(18, 23, 43));
                                for (int i = 0; i < ms.modes.size(); ++i) {
                                    String mode = ms.modes.get(i);
                                    if (i == ms.index) {
                                        FontRegistry.mnstb_14.drawGradientString(mode, x + 159.0f + offset1, y + 72.0f + settingOffset + offset + this.animScroll + 5.0f + i * 10, new int[]{getC(0).getRGB(), getC(250).getRGB(), getC(750).getRGB(), getC(1000).getRGB()}, true);
                                    } else {
                                        FontRegistry.mnstb_14.drawString(mode, x + 159.0f + offset1, y + 72.0f + settingOffset + offset + this.animScroll + 5.0f + i * 10, new Color(152, 175, 188).getRGB());
                                    }
                                }
                            }
                            FontRegistry.mnstb_14.drawString(ms.name, x + 110.0f + offset1, y + 56.0f + settingOffset + offset + this.animScroll, new Color(153, 180, 189, 255).getRGB());
                            RoundedUtils.drawRoundOutline(x + 153.0f + offset1, y + 52.0f + settingOffset + offset + this.animScroll, 62.0f, 13.0f, 1.0f, -0.3f, new Color(5, 8, 15), new Color(18, 23, 43, 255));
                            String currentMode = ms.modes.get(ms.index);
                            FontRegistry.mnstb_14.drawGradientString(cutString(currentMode), x + 159.0f + offset1, y + 54.0f + settingOffset + offset + this.animScroll + 2.0f, new int[]{getC(0).getRGB(), getC(250).getRGB(), getC(750).getRGB(), getC(1000).getRGB()}, true);
                            FontRegistry.mnstb_14.drawGradientString(ms.opened ? "v" : ">", x + 207.0f + offset1, y + 54.0f + settingOffset + offset + this.animScroll + 2.0f, new int[]{getC(0).getRGB(), getC(250).getRGB(), getC(750).getRGB(), getC(1000).getRGB()}, true);
                            settingOffset += 18.0f + (ms.opened ? ms.modes.size() * 9.2f + 10.0f : 0.0f);
                        } else if (ClickGuiModule.wiki.value && setting instanceof InfoSetting) {
                            InfoSetting info = (InfoSetting) setting;
                            int infoOffset = 0;
                            for (String line : info.getLines()) {
                                FontRegistry.mnstb_10.drawString(line, x + 110.0f + offset1, y + 56.0f + 2.0f + settingOffset + infoOffset + offset + this.animScroll, new Color(230, 230, 230, 255).getRGB());
                                infoOffset += 10;
                            }
                            settingOffset += info.getLines().length * 10.0f;
                        }
                    }
                }
                offset += 50;
            }
            offset1 += 120;
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (!isHovered(mouseX, mouseY, x, y, width, height)) return super.mouseClicked(mouseX, mouseY, button);
        if (isHovered(mouseX, mouseY, x, y, 340.0, 25.0) && button == 0) {
            this.dragging = true;
            prevX = x - (float) mouseX;
            prevY = y - (float) mouseY;
        }

        this.chatTyping = isHovered(mouseX, mouseY, x + 110.0f, y + 240.0f, 260.0, 15.0) && button == 0;

        int offset1 = 0;
        ArrayList<Module> allModules = Client.getInstance().moduleManager.getModulesForCategory(selectedCategory);
        int size = allModules.size();
        ArrayList<ArrayList<Module>> columns = new ArrayList<>();
        columns.add(new ArrayList<>(allModules.subList(0, size / 2)));
        columns.add(new ArrayList<>(allModules.subList(size / 2, size)));

        for (ArrayList<Module> column : columns) {
            int offset = 0;
            for (Module m : column) {
                if (isHovered(mouseX, mouseY, x + 105.0f + offset1, y + 26.0f + offset + this.animScroll, 115.0, 25.0)) {
                    if (button == 0) m.toggle();
                    else if (button == 1 && !m.getModuleCategory().equals(ModuleCategory.Themes)) m.opened = !m.opened;
                }
                if (m.opened) {
                    int settingOffset = 0;
                    for (Setting s : m.getSetting()) {
                        if (!s.isVisible()) continue;
                        if (s instanceof BooleanSetting) {
                            if (isHovered(mouseX, mouseY, x + 193.0f + offset1, y + 57.0f + settingOffset + offset + this.animScroll, 18.0, 10.0)) ((BooleanSetting) s).value = !((BooleanSetting) s).value;
                            settingOffset += 14;
                        } else if (s instanceof NumberSetting) {
                            if (isHovered(mouseX, mouseY, x + 110.0f + offset1, y + 51.0f + settingOffset + offset + this.animScroll + 12.0f, 75.0, 24.0)) ((NumberSetting) s).pressed = true;
                            settingOffset += 28;
                        } else if (s instanceof ColorSetting) {
                            settingOffset += 39;
                        } else if (s instanceof ThemeSetting) {
                            if (isHovered(mouseX, mouseY, x + 105.0f + offset1, y + 26.0f + offset + this.animScroll, 115.0, 65.0) && button == 0) currentTheme = ((ThemeSetting) s).getTheme();
                            settingOffset += 30;
                        } else if (s instanceof TextSetting) {
                            if (isHovered(mouseX, mouseY, x + 140.0f + offset1, y + 60.0f + settingOffset + offset + this.animScroll, 85.0, 13.0)) ((TextSetting) s).typing = !((TextSetting) s).typing;
                            else ((TextSetting) s).typing = false;
                            settingOffset += 15;
                        } else if (s instanceof ModeSetting) {
                            ModeSetting ms = (ModeSetting) s;
                            if (isHovered(mouseX, mouseY, x + 154.0f + offset1, y + 51.0f + settingOffset + offset + this.animScroll, 50.0, 12.0)) ms.opened = !ms.opened;
                            if (ms.opened) {
                                for (int i = 0; i < ms.modes.size(); ++i) {
                                    if (isHovered(mouseX, mouseY, x + 154.0f + offset1, y + 68.0f + settingOffset + offset + this.animScroll + i * 10, 50.0, 10.0)) ms.index = i;
                                }
                            }
                            settingOffset += 18.0f + (ms.opened ? ms.modes.size() * 9.2f + 10.0f : 0.0f);
                        } else if (ClickGuiModule.wiki.value && s instanceof InfoSetting) {
                            settingOffset += ((InfoSetting) s).getLines().length * 10.0f;
                        }
                    }
                }
                offset += 50;
            }
            offset1 += 120;
        }

        int catOffset = 0;
        for (ModuleCategory category : ModuleCategory.values()) {
            if (isHovered(mouseX, mouseY, x - 1.0f, y + 64.0f + catOffset, 80.0, 17.0) && button == 0 && selectedCategory != category) {
                selectedCategory = category;
                if (category == ModuleCategory.Chat) BackendApi.runSync();
                this.openedCategoryAnim = 380.0f;
                this.scroll = 0.0f;
                this.animScroll = 0.0f;
            }
            catOffset += category.getOffset();
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        for (Module m : Client.getInstance().moduleManager.getModulesForCategory(selectedCategory)) {
            for (Setting s : m.getSetting()) {
                if (s.isVisible() && s instanceof NumberSetting) ((NumberSetting) s).pressed = false;
            }
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (isHovered(mouseX, mouseY, x + 80.0f, y, width, height)) {
            this.scroll += verticalAmount * 50.0f;
        }
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.chatTyping) {
            char c = (char) keyCode;
            if (isAllowedCharacter(c)) this.currentMessage += c;
            if (keyCode == 259 && this.currentMessage.length() > 0) this.currentMessage = this.currentMessage.substring(0, this.currentMessage.length() - 1);
            if (Screen.hasControlDown() && keyCode == 86) this.currentMessage += getClipboardString();
            if (keyCode == 257 && !this.currentMessage.isEmpty()) {
                BackendApi.sendMessage(this.currentMessage);
                this.currentMessage = "";
            }
        }

        for (Module m : Client.getInstance().moduleManager.getModulesForCategory(selectedCategory)) {
            for (Setting s : m.getSetting()) {
                if (!s.isVisible() || !(s instanceof TextSetting)) continue;
                TextSetting ts = (TextSetting) s;
                if (ts.typing) {
                    char c = (char) keyCode;
                    if (isAllowedCharacter(c)) ts.text += c;
                    if (keyCode == 259 && ts.text.length() > 0) ts.text = ts.text.substring(0, ts.text.length() - 1);
                    if (Screen.hasControlDown() && keyCode == 86) ts.text += getClipboardString();
                    if (keyCode == 256 || keyCode == 257) ts.typing = false;
                }
            }
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean shouldPause() { return false; }

    public static String cutString(String str) {
        return str.length() > 9 ? str.substring(0, 9) + ".." : str;
    }

    public static boolean isAllowedCharacter(char c) {
        return c >= 32 && c <= 255;
    }

    public static Color getColor(BufferedImage img, int x, int y) {
        int clr = img.getRGB(x, y);
        return new Color((clr >> 16) & 255, (clr >> 8) & 255, clr & 255);
    }

    public static Color getC(int index) {
        return ColorUtils.TwoColorEffect(currentTheme.getOneColor(), currentTheme.getTwoColor(), 5.0, index);
    }

    public boolean isHovered(double mouseX, double mouseY, double x, double y, double width, double height) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }

    @Override
    public void close() {
        this.openedCategoryAnim = 380.0f;
        super.close();
    }

    static {
        selectedCategory = ModuleCategory.Bots;
        x = 65.0f;
        y = 5.0f;
        width = 370.0f;
        height = 265.0f;
        try {
            colorpicker = ImageIO.read(MinecraftClient.getInstance().getResourceManager().getResource(new Identifier("neoware/images/colorpicker.png")).getInputStream());
        } catch (IOException e) { e.printStackTrace(); }
    }
}
