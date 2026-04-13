/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.MainMenuScreen
 *  neo.deobf.AltStatus
 *  neo.deobf.AltAccount
 *  neo.deobf.AltLoginThread
 *  neo.deobf.AltManager
 *  neo.deobf.AuthServiceSwitcher
 *  neo.deobf.AddAltScreen
 *  neo.deobf.NeoButton
 *  neo.deobf.AltLoginScreen
 *  neo.deobf.EditAltScreen
 *  neo.deobf.RandomUtils
 *  neo.deobf.ColorUtils
 *  neo.deobf.DrawUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiTextField
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.IImageBuffer
 *  net.minecraft.client.renderer.ImageBufferDownload
 *  net.minecraft.client.renderer.ThreadDownloadImageData
 *  net.minecraft.client.renderer.texture.ITextureObject
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.client.resources.DefaultPlayerSkin
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.Session
 *  net.minecraft.util.StringUtils
 *  net.minecraft.util.text.TextFormatting
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package neo.deobf;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import neo.deobf.MainMenuScreen;
import neo.deobf.AltStatus;
import neo.deobf.AltAccount;
import neo.deobf.AltLoginThread;
import neo.deobf.AltManager;
import neo.deobf.AuthServiceSwitcher;
import neo.deobf.AddAltScreen;
import neo.deobf.NeoButton;
import neo.deobf.AltLoginScreen;
import neo.deobf.EditAltScreen;
import neo.deobf.RandomUtils;
import neo.deobf.ColorUtils;
import neo.deobf.DrawUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;
import net.minecraft.util.StringUtils;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AltManagerScreen
extends GuiScreen {
    public float offset;
    public ResourceLocation resourceLocation;
    public GuiTextField searchField;
    public String status = TextFormatting.DARK_GRAY + "(" + TextFormatting.GRAY + AltManager.registry.size() + TextFormatting.DARK_GRAY + ")";
    public AltLoginThread loginThread;
    public NeoButton remove;
    public NeoButton login;
    public static final AuthServiceSwitcher altService = new AuthServiceSwitcher();
    public AltAccount selectedAlt = null;

    private static Minecraft getMc(AltManagerScreen instance) {
        return instance.mc;
    }

    private void callGetMc12(ResourceLocation resourceLocationIn, String username) {
        TextureManager textureManager = (this.mc).getTextureManager();
        textureManager.getTexture(resourceLocationIn);
        Object[] objectArray = new Object[1];
        objectArray[0] = StringUtils.stripControlCodes((String)username);
        ThreadDownloadImageData textureObject = new ThreadDownloadImageData(null, String.format("https://minotar.net/avatar/%s/64.png", objectArray), DefaultPlayerSkin.getDefaultSkin((UUID)AbstractClientPlayer.getOfflineUUID((String)username)), (IImageBuffer)new ImageBufferDownload());
        textureManager.loadTexture(resourceLocationIn, (ITextureObject)textureObject);
    }

    private static Minecraft getMc2(AltManagerScreen instance) {
        return instance.mc;
    }

    private static Minecraft getMc3(AltManagerScreen instance) {
        return instance.mc;
    }

    private boolean callGetWidth5(double x, double y, double y1) {
        return (x >= (double)((float)(this.width) / 2.0f - 125.0f) && y >= y1 - 4.0 && x <= (double)(this.width) / 1.5 && y <= y1 + 20.0 && x >= 0.0 && y >= 33.0 && x <= (double)(this.width) && y <= (double)((this.height) - (50)) ? 1 : 0) != 0;
    }

    private static float getOffset(AltManagerScreen instance) {
        return instance.offset;
    }

    public void initGui() {
        this.searchField = new GuiTextField(AltManagerScreen.getEventButton(this), AltManagerScreen.getFontRenderer(AltManagerScreen.getMc11(this)), AltManagerScreen.getWidth12(this) / (2) + (116), AltManagerScreen.getHeight6(this) - (22), 72, 16);
        List list = (this.buttonList);
        NeoButton bm = new NeoButton(1, (this.width) / (2) - (122), (this.height) - (48), 60, 20, "Login");
        this.login = bm;
        list.add(bm);
        List list2 = (this.buttonList);
        NeoButton bm2 = new NeoButton(2, (this.width) / (2) + (4) + (77), (this.height) - (48), 40, 20, "Remove");
        this.remove = bm2;
        list2.add(bm2);
        (this.buttonList).add(new NeoButton(3, (this.width) / (2) + (4) - (60), (this.height) - (48), 65, 20, "Add Alt"));
        (this.buttonList).add(new NeoButton(5, (this.width) / (2) + (15), (this.height) - (48), 60, 20, "Random"));
        (this.buttonList).add(new NeoButton(7, (this.width) / (2) - (122), (this.height) - (24), 245, 20, "Back"));
        (this.buttonList).add(new NeoButton(8, (this.width) / (2) + (4) + (124), (this.height) - (25), 60, 20, "Clear All"));
        AltManagerScreen.getLogin4(this).enabled = false;
        AltManagerScreen.getRemove3(this).enabled = false;
    }

    private static Minecraft getMc5(AltManagerScreen instance) {
        return instance.mc;
    }

    private static Minecraft getMc6(AltManagerScreen instance) {
        return instance.mc;
    }

    private static FontRenderer getFontRenderer(Minecraft minecraft) {
        return minecraft.fontRenderer;
    }

    protected void keyTyped(char par1, int par2) {
        (this.searchField).textboxKeyTyped(par1, par2);
        if ((par1 == (9) || par1 == (13)) && (this.searchField).isFocused()) {
            (this.searchField).setFocused((!(this.searchField).isFocused() ? 1 : 0) != 0);
        }
        try {
            super.keyTyped(par1, par2);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static NeoButton getRemove(AltManagerScreen instance) {
        return instance.remove;
    }

    private boolean callGetOffset6(int y) {
        return ((float)y - (this.offset) <= (float)((this.height) - (50)) ? 1 : 0) != 0;
    }

    private static NeoButton getRemove2(AltManagerScreen instance) {
        return instance.remove;
    }

    private static NeoButton getLogin2(AltManagerScreen instance) {
        return instance.login;
    }

    private static TextFormatting getGREEN() {
        return TextFormatting.GREEN;
    }

    public void actionPerformed(GuiButton button) {
        switch ((button.id)) {
            case 0: {
                break;
            }
            case 1: {
                AltLoginThread bc = new AltLoginThread((this.selectedAlt));
                this.loginThread = bc;
                bc.start();
                break;
            }
            case 2: {
                if ((this.loginThread) != null) {
                    this.loginThread = null;
                }
                AltManager.removeAccount((AltAccount)(this.selectedAlt));
                this.status = AltManagerScreen.getGREEN() + "Removed.";
                this.selectedAlt = null;
                break;
            }
            case 3: {
                (this.mc).displayGuiScreen((GuiScreen)new AddAltScreen(this));
                break;
            }
            case 4: {
                (this.mc).displayGuiScreen((GuiScreen)new AltLoginScreen((GuiScreen)this));
                break;
            }
            case 5: {
                String randomName = RandomUtils.randomString((int)RandomUtils.intRandom((int)(5), (int)(10)));
                AltManager.addAccount((AltAccount)new AltAccount(randomName, ""));
                AltManagerScreen.getMc2(this).new Session(randomName, "", "", "mojang") = new Session(randomName, "", "", "mojang");
                break;
            }
            case 6: {
                (this.mc).displayGuiScreen((GuiScreen)new EditAltScreen(this));
                break;
            }
            case 7: {
                (this.mc).displayGuiScreen((GuiScreen)new MainMenuScreen());
                break;
            }
            case 8: {
                AltManager.clearAccounts();
            }
        }
    }

    public void drawScreen(int par1, int par2, float par3) {
        DrawUtils.drawRect((float)0.0f, (float)0.0f, (float)(AltManagerScreen.getMc10(this).displayWidth), (float)(AltManagerScreen.getMc14(this).displayHeight), (Color)new Color(17, 17, 17));
        super.drawScreen(par1, par2, par3);
        if (Mouse.hasWheel()) {
            int wheel = Mouse.getDWheel();
            if (wheel < 0) {
                AltManagerScreen bo = this;
                bo.offset = (float)((double)AltManagerScreen.getOffset7(bo) + 26.0);
                if ((double)(this.offset) < 0.0) {
                    this.offset = 0.0f;
                }
            } else if (wheel > 0) {
                AltManagerScreen bo = this;
                bo.offset = (float)((double)AltManagerScreen.getOffset12(bo) - 26.0);
                if ((double)(this.offset) < 0.0) {
                    this.offset = 0.0f;
                }
            }
        }
        String altName = "Name: " + (AltManagerScreen.getMc5(this).session).getUsername();
        GlStateManager.pushMatrix();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        (Minecraft.getMinecraft().fontRenderer).drawCenteredString(altName, (double)((float)(this.width) / 2.0f), 10.0, -1);
        GlStateManager.pushMatrix();
        DrawUtils.scissorRect((float)0.0f, (float)33.0f, (float)(this.width), (double)((this.height) - (50)));
        GL11.glEnable((int)(3089));
        int y = 38;
        int number = 0;
        Iterator<AltAccount> e = this.getAlts().iterator();
        while (true) {
            String name;
            if (!e.hasNext()) {
                GL11.glDisable((int)(3089));
                GL11.glPopMatrix();
                if ((this.selectedAlt) == null) {
                    AltManagerScreen.getLogin3(this).enabled = false;
                    AltManagerScreen.getRemove2(this).enabled = false;
                } else {
                    AltManagerScreen.getLogin2(this).enabled = true;
                    AltManagerScreen.getRemove(this).enabled = true;
                }
                if (Keyboard.isKeyDown((int)(200))) {
                    AltManagerScreen bo = this;
                    bo.offset = (float)((double)AltManagerScreen.getOffset10(bo) - 26.0);
                } else if (Keyboard.isKeyDown((int)(208))) {
                    AltManagerScreen bo = this;
                    bo.offset = (float)((double)AltManagerScreen.getOffset(bo) + 26.0);
                }
                if ((double)(this.offset) < 0.0) {
                    this.offset = 0.0f;
                }
                return;
            }
            int small = (AltManagerScreen.getMc6(this).displayWidth) < (900) && (AltManagerScreen.getMc3(this).displayHeight) < (900) ? 1 : 0;
            AltAccount alt = e.next();
            if (!this.callGetOffset6(y)) continue;
            ++number;
            String string = name = alt.getMask().equals("") ? alt.getUsername() : alt.getMask();
            if (name.equalsIgnoreCase((AltManagerScreen.getMc(this).session).getUsername())) {
                name = "§a" + name;
            }
            String prefix = alt.getStatus().equals((Object)(AltStatus.Banned)) ? "§c" : (alt.getStatus().equals((Object)(AltStatus.NotWorking)) ? "§m" : "");
            name = prefix + name + "§r ";
            String pass = alt.getPassword().equals("") ? "§cNot License" : "§aLicense";
            String numberP = "§7" + number + ". §f";
            GlStateManager.pushMatrix();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            if ((this.resourceLocation) == null) {
                this.AbstractClientPlayer.getLocationSkin((String)name) = AbstractClientPlayer.getLocationSkin((String)name);
                this.callGetMc12((this.resourceLocation), name);
            } else {
                (this.mc).getTextureManager().bindTexture((this.resourceLocation));
                GlStateManager.enableTexture2D();
                Gui.drawScaledCustomSizeModalRect((int)((int)((float)(this.width) / 2.0f - 110.0f)), (int)((int)((float)y - (this.offset))), (float)8.0f, (float)8.0f, (int)(8), (int)(8), (int)(25), (int)(25), (float)64.0f, (float)64.0f);
            }
            GlStateManager.popMatrix();
            (Minecraft.getMinecraft().fontRenderer).drawString(name, (int)((float)(this.width) / 2.0f - 80.0f), (int)((double)y - (double)(this.offset) + 5.0), -1);
            (Minecraft.getMinecraft().fontRenderer).drawString((alt.getStatus().equals((Object)(AltStatus.NotWorking)) ? "§m" : "") + pass, (int)((float)(this.width) / 2.0f - 80.0f), (int)((double)y - (double)(this.offset) + 15.0), ColorUtils.getColor((int)(110)));
            y += 40;
        }
    }

    private static float getOffset7(AltManagerScreen instance) {
        return instance.offset;
    }

    private static NeoButton getRemove3(AltManagerScreen instance) {
        return instance.remove;
    }

    private static int getWidth12(AltManagerScreen instance) {
        return instance.width;
    }

    private static NeoButton getLogin3(AltManagerScreen instance) {
        return instance.login;
    }

    protected void mouseClicked(int par1, int par2, int par3) {
        (this.searchField).mouseClicked(par1, par2, par3);
        if ((this.offset) < 0.0f) {
            this.offset = 0.0f;
        }
        double y = 38.0f - (this.offset);
        for (AltAccount alt : this.getAlts()) {
            if (this.callGetWidth5(par1, par2, y)) {
                if (alt == (this.selectedAlt)) {
                    this.actionPerformed((GuiButton)(this.login));
                    return;
                }
                this.selectedAlt = alt;
            }
            y += 40.0;
        }
        try {
            super.mouseClicked(par1, par2, par3);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Minecraft getMc10(AltManagerScreen instance) {
        return instance.mc;
    }

    private static Minecraft getMc11(AltManagerScreen instance) {
        return instance.mc;
    }

    private static float getOffset10(AltManagerScreen instance) {
        return instance.offset;
    }

    private static NeoButton getLogin4(AltManagerScreen instance) {
        return instance.login;
    }

    private static int getHeight6(AltManagerScreen instance) {
        return instance.height;
    }

    private List<AltAccount> getAlts() {
        ArrayList<AltAccount> altList = new ArrayList<AltAccount>();
        Iterator iterator = (AltManager.registry).iterator();
        while (iterator.hasNext()) {
            AltAccount alt = (AltAccount)iterator.next();
            if (!(this.searchField).getText().isEmpty() && !alt.getMask().toLowerCase().contains((this.searchField).getText().toLowerCase()) && !alt.getUsername().toLowerCase().contains((this.searchField).getText().toLowerCase())) continue;
            altList.add(alt);
        }
        return altList;
    }

    private static float getOffset12(AltManagerScreen instance) {
        return instance.offset;
    }

    private static int getEventButton(AltManagerScreen instance) {
        return instance.eventButton;
    }

    private static Minecraft getMc14(AltManagerScreen instance) {
        return instance.mc;
    }

}

