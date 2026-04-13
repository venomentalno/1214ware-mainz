/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.client.renderer.vertex.VertexFormat
 *  net.minecraft.util.ChatAllowedCharacters
 *  org.lwjgl.opengl.GL11
 */
package neo.deobf;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ChatAllowedCharacters;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class GuiPasswordField
extends Gui {
    public int enabledColor;
    public final FontRenderer fontRenderer;
    public boolean enableBackgroundDrawing;
    public String text;
    private final int disabledColor = 0x707070;
    public final int height;
    private final boolean isEnabled = 1;
    public int maxStringLength;
    public final int xPos;
    public int cursorPosition;
    public int selectionEnd;
    public boolean field_73823_s;
    public boolean isFocused;
    public boolean canLoseFocus;
    public final int yPos;
    public int field_73816_n;
    public final int width;
    public int cursorCounter;

    public String getSelectedtext() {
        int var1 = (this.cursorPosition) < (this.selectionEnd) ? (this.cursorPosition) : (this.selectionEnd);
        int var2 = (this.cursorPosition) < (this.selectionEnd) ? (this.selectionEnd) : (this.cursorPosition);
        return (this.text).substring(var1, var2);
    }

    private static void setEnableBackgroundDrawing(GuiPasswordField bq, boolean value) {
        bq.enableBackgroundDrawing = value;
    }

    private static int getMaxStringLength(GuiPasswordField instance) {
        return instance.maxStringLength;
    }

    public int func_73798_a(int par1, int par2, boolean par3) {
        int var4 = par2;
        int var5 = par1 < 0 ? 1 : 0;
        int var6 = Math.abs(par1);
        for (int var7 = 0; var7 < var6; ++var7) {
            if (var5 == 0) {
                int var8 = (this.text).length();
                var4 = (this.text).indexOf(32, var4);
                if (var4 == (-1)) {
                    var4 = var8;
                    continue;
                }
                while (par3 && var4 < var8 && (this.text).charAt(var4) == (32)) {
                    ++var4;
                }
                continue;
            }
            while (par3 && var4 > 0 && (this.text).charAt(var4 - (1)) == (32)) {
                --var4;
            }
            while (var4 > 0 && (this.text).charAt(var4 - (1)) != (32)) {
                --var4;
            }
        }
        return var4;
    }

    private static int getSelectionEnd(GuiPasswordField instance) {
        return instance.selectionEnd;
    }

    private static String getText(GuiPasswordField instance) {
        return instance.text;
    }

    public void func_73784_d(int par1) {
        this.setCursorPosition((this.selectionEnd) + par1);
    }

    private static void setCanLoseFocus(GuiPasswordField bq, boolean value) {
        bq.canLoseFocus = value;
    }

    private static String getText2(GuiPasswordField instance) {
        return instance.text;
    }

    private static int getCursorPosition(GuiPasswordField instance) {
        return instance.cursorPosition;
    }

    private static int getWidth(GuiPasswordField instance) {
        return instance.width;
    }

    public GuiPasswordField(FontRenderer par1FontRenderer, int par2, int par3, int par4, int par5) {
        this.disabledColor = 7368816;
        this.text = "";
        this.maxStringLength = 50;
        this.isFocused = 0;
        this.enableBackgroundDrawing = 1;
        this.canLoseFocus = 1;
        this.field_73816_n = 0;
        this.cursorPosition = 0;
        this.selectionEnd = 0;
        this.enabledColor = 14737632;
        this.field_73823_s = 1;
        this.fontRenderer = par1FontRenderer;
        this.xPos = par2;
        this.yPos = par3;
        this.width = par4;
        this.height = par5;
    }

    public void func_73794_g(int par1) {
        this.enabledColor = par1;
    }

    private static void setMaxStringLength(GuiPasswordField bq, int n) {
        bq.maxStringLength = n;
    }

    public void drawTextBox() {
        if (this.func_73778_q()) {
            if (this.getEnableBackgroundDrawing()) {
                GuiPasswordField.drawRect((int)((this.xPos) - (1)), (int)((this.yPos) - (1)), (int)((this.xPos) + (this.width) + (1)), (int)((this.yPos) + (this.height) + (1)), (int)(-6250336));
                GuiPasswordField.drawRect((int)(this.xPos), (int)(this.yPos), (int)((this.xPos) + (this.width)), (int)((this.yPos) + (this.height)), (int)(-16777216));
            }
            ((Object)((Object)this)).getClass();
            int var1 = (this.enabledColor);
            int var2 = (this.cursorPosition) - (this.field_73816_n);
            int var3 = (this.selectionEnd) - (this.field_73816_n);
            String var4 = (this.fontRenderer).trimStringToWidth((this.text).substring((this.field_73816_n)), this.getWidth());
            int var5 = var2 >= 0 && var2 <= var4.length() ? 1 : 0;
            int var6 = (this.isFocused) && (this.cursorCounter) / (6) % (2) == 0 && var5 != 0 ? 1 : 0;
            int var7 = (this.enableBackgroundDrawing) ? (this.xPos) + (4) : (this.xPos);
            int var8 = (this.enableBackgroundDrawing) ? (this.yPos) + ((this.height) - (8)) / (2) : (this.yPos);
            int var9 = var7;
            if (var3 > var4.length()) {
                var3 = var4.length();
            }
            if (var4.length() > 0) {
                if (var5 != 0) {
                    var4.substring(0, var2);
                }
                var9 = (Minecraft.getMinecraft().fontRenderer).drawStringWithShadow((this.text).replaceAll("(?s).", "*"), (float)var7, (float)var8, var1);
            }
            int var10 = (this.cursorPosition) < (this.text).length() || (this.text).length() >= this.getMaxStringLength() ? 1 : 0;
            int var11 = var9;
            if (var5 == 0) {
                var11 = var2 > 0 ? var7 + (this.width) : var7;
            } else if (var10 != 0) {
                var11 = var9 - (1);
                --var9;
            }
            if (var4.length() > 0 && var5 != 0 && var2 < var4.length()) {
                (Minecraft.getMinecraft().fontRenderer).drawStringWithShadow(var4.substring(var2), (float)var9, (float)var8, var1);
            }
            if (var6 != 0) {
                if (var10 != 0) {
                    Gui.drawRect((int)var11, (int)(var8 - (1)), (int)(var11 + (1)), (int)(var8 + (1) + (GuiPasswordField.getFontRenderer9(this).FONT_HEIGHT)), (int)(-3092272));
                } else {
                    (Minecraft.getMinecraft().fontRenderer).drawStringWithShadow("_", (float)var11, (float)var8, var1);
                }
            }
            if (var3 != var2) {
                int var12 = var7 + (this.fontRenderer).getStringWidth(var4.substring(0, var3));
                this.drawCursorVertical(var11, var8 - (1), var12 - (1), var8 + (1) + (GuiPasswordField.getFontRenderer11(this).FONT_HEIGHT));
            }
        }
    }

    private static String getText6(GuiPasswordField instance) {
        return instance.text;
    }

    public void setCanLoseFocus(boolean par1) {
        this.canLoseFocus = par1;
    }

    public int getNthWordFromCursor(int par1) {
        return this.getNthWordFromPos(par1, this.getCursorPosition());
    }

    public void setCursorPositionEnd() {
        this.setCursorPosition((this.text).length());
    }

    private static void setCursorPosition(GuiPasswordField bq, int n) {
        bq.cursorPosition = n;
    }

    private static void setText(GuiPasswordField bq, String string) {
        bq.text = string;
    }

    private static int getField_73816_n7(GuiPasswordField instance) {
        return instance.field_73816_n;
    }

    public boolean getEnableBackgroundDrawing() {
        return (this.enableBackgroundDrawing);
    }

    public String getText() {
        return (this.text).replaceAll(" ", "");
    }

    public boolean isFocused() {
        return (this.isFocused);
    }

    public void deleteFromCursor(int par1) {
        if ((this.text).length() != 0) {
            if ((this.selectionEnd) != (this.cursorPosition)) {
                this.writeText("");
            } else {
                int var2 = par1 < 0 ? 1 : 0;
                int var3 = var2 != 0 ? (this.cursorPosition) + par1 : (this.cursorPosition);
                int var4 = var2 != 0 ? (this.cursorPosition) : (this.cursorPosition) + par1;
                String var5 = "";
                if (var3 >= 0) {
                    var5 = (this.text).substring(0, var3);
                }
                if (var4 < (this.text).length()) {
                    var5 = var5 + (this.text).substring(var4);
                }
                this.text = var5;
                if (var2 != 0) {
                    this.func_73784_d(par1);
                }
            }
        }
    }

    private static boolean getEnableBackgroundDrawing(GuiPasswordField instance) {
        return instance.enableBackgroundDrawing;
    }

    private static FontRenderer getFontRenderer4(GuiPasswordField instance) {
        return instance.fontRenderer;
    }

    public void updateCursorCounter() {
        GuiPasswordField bq = this;
        bq.cursorCounter = GuiPasswordField.getCursorCounter2(bq) + (1);
    }

    private static int getField_73816_n12(GuiPasswordField instance) {
        return instance.field_73816_n;
    }

    public int getMaxStringLength() {
        return (this.maxStringLength);
    }

    public void mouseClicked(int par1, int par2, int par3) {
        int var4;
        int n = var4 = par1 >= (this.xPos) && par1 < (this.xPos) + (this.width) && par2 >= (this.yPos) && par2 < (this.yPos) + (this.height) ? 1 : 0;
        if ((this.canLoseFocus)) {
            ((Object)((Object)this)).getClass();
            this.setFocused((var4 != 0 ? 1 : 0) != 0);
        }
        if ((this.isFocused) && par3 == 0) {
            int var5 = par1 - (this.xPos);
            if ((this.enableBackgroundDrawing)) {
                var5 -= 4;
            }
            String var6 = (this.fontRenderer).trimStringToWidth((this.text).substring((this.field_73816_n)), this.getWidth());
            this.setCursorPosition((this.fontRenderer).trimStringToWidth(var6, var5).length() + (this.field_73816_n));
        }
    }

    private static FontRenderer getFontRenderer9(GuiPasswordField instance) {
        return instance.fontRenderer;
    }

    public void writeText(String par1Str) {
        int var8;
        String var2 = "";
        String var3 = ChatAllowedCharacters.filterAllowedCharacters((String)par1Str);
        int var4 = (this.cursorPosition) < (this.selectionEnd) ? (this.cursorPosition) : (this.selectionEnd);
        int var5 = (this.cursorPosition) < (this.selectionEnd) ? (this.selectionEnd) : (this.cursorPosition);
        int var6 = (this.maxStringLength) - (this.text).length() - (var4 - (this.selectionEnd));
        int var7 = 0;
        if ((this.text).length() > 0) {
            var2 = var2 + (this.text).substring(0, var4);
        }
        if (var6 < var3.length()) {
            var2 = var2 + var3.substring(0, var6);
            var8 = var6;
        } else {
            var2 = var2 + var3;
            var8 = var3.length();
        }
        if ((this.text).length() > 0 && var5 < (this.text).length()) {
            var2 = var2 + (this.text).substring(var5);
        }
        this.text = var2.replaceAll(" ", "");
        this.func_73784_d(var4 - (this.selectionEnd) + var8);
    }

    public void setCursorPosition(int par1) {
        this.cursorPosition = par1;
        int var2 = (this.text).length();
        if ((this.cursorPosition) < 0) {
            this.cursorPosition = 0;
        }
        if ((this.cursorPosition) > var2) {
            this.cursorPosition = var2;
        }
        this.func_73800_i((this.cursorPosition));
    }

    private void drawCursorVertical(int par1, int par2, int par3, int par4) {
        int var5;
        if (par1 < par3) {
            var5 = par1;
            par1 = par3;
            par3 = var5;
        }
        if (par2 < par4) {
            var5 = par2;
            par2 = par4;
            par4 = var5;
        }
        Tessellator var6 = Tessellator.getInstance();
        BufferBuilder var7 = var6.getBuffer();
        GL11.glColor4f((float)0.0f, (float)0.0f, (float)255.0f, (float)255.0f);
        GL11.glDisable((int)(3553));
        GL11.glEnable((int)(3058));
        GL11.glLogicOp((int)(5387));
        var7.begin(7, (DefaultVertexFormats.POSITION));
        var7.pos((double)par1, (double)par4, 0.0).endVertex();
        var7.pos((double)par3, (double)par4, 0.0).endVertex();
        var7.pos((double)par3, (double)par2, 0.0).endVertex();
        var7.pos((double)par1, (double)par2, 0.0).endVertex();
        var6.draw();
        GL11.glDisable((int)(3058));
        GL11.glEnable((int)(3553));
    }

    public int getCursorPosition() {
        return (this.cursorPosition);
    }

    private static int getField_73816_n13(GuiPasswordField instance) {
        return instance.field_73816_n;
    }

    public boolean textboxKeyTyped(char par1, int par2) {
        ((Object)((Object)this)).getClass();
        if ((this.isFocused)) {
            switch (par1) {
                case '\u0001': {
                    this.setCursorPositionEnd();
                    this.func_73800_i(0);
                    return true;
                }
                case '\u0003': {
                    GuiScreen.setClipboardString((String)this.getSelectedtext());
                    return true;
                }
                case '\u0016': {
                    this.writeText(GuiScreen.getClipboardString());
                    return true;
                }
                case '\u0018': {
                    GuiScreen.setClipboardString((String)this.getSelectedtext());
                    this.writeText("");
                    return true;
                }
            }
            switch (par2) {
                case 14: {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.func_73779_a(-1);
                    } else {
                        this.deleteFromCursor(-1);
                    }
                    return true;
                }
                case 199: {
                    if (GuiScreen.isShiftKeyDown()) {
                        this.func_73800_i(0);
                    } else {
                        this.setCursorPositionZero();
                    }
                    return true;
                }
                case 203: {
                    if (GuiScreen.isShiftKeyDown()) {
                        if (GuiScreen.isCtrlKeyDown()) {
                            this.func_73800_i(this.getNthWordFromPos(-1, this.getSelectionEnd()));
                        } else {
                            this.func_73800_i(this.getSelectionEnd() - (1));
                        }
                    } else if (GuiScreen.isCtrlKeyDown()) {
                        this.setCursorPosition(this.getNthWordFromCursor(-1));
                    } else {
                        this.func_73784_d(-1);
                    }
                    return true;
                }
                case 205: {
                    if (GuiScreen.isShiftKeyDown()) {
                        if (GuiScreen.isCtrlKeyDown()) {
                            this.func_73800_i(this.getNthWordFromPos(1, this.getSelectionEnd()));
                        } else {
                            this.func_73800_i(this.getSelectionEnd() + (1));
                        }
                    } else if (GuiScreen.isCtrlKeyDown()) {
                        this.setCursorPosition(this.getNthWordFromCursor(1));
                    } else {
                        this.func_73784_d(1);
                    }
                    return true;
                }
                case 207: {
                    if (GuiScreen.isShiftKeyDown()) {
                        this.func_73800_i((this.text).length());
                    } else {
                        this.setCursorPositionEnd();
                    }
                    return true;
                }
                case 211: {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.func_73779_a(1);
                    } else {
                        this.deleteFromCursor(1);
                    }
                    return true;
                }
            }
            if (ChatAllowedCharacters.isAllowedCharacter((char)par1)) {
                this.writeText(Character.toString(par1));
                return true;
            }
            return false;
        }
        return false;
    }

    private static FontRenderer getFontRenderer11(GuiPasswordField instance) {
        return instance.fontRenderer;
    }

    public void func_73800_i(int par1) {
        int var2 = (this.text).length();
        if (par1 > var2) {
            par1 = var2;
        }
        if (par1 < 0) {
            par1 = 0;
        }
        this.selectionEnd = par1;
        if ((this.fontRenderer) != null) {
            if ((this.field_73816_n) > var2) {
                this.field_73816_n = var2;
            }
            int var3 = this.getWidth();
            String var4 = (this.fontRenderer).trimStringToWidth((this.text).substring((this.field_73816_n)), var3);
            int var5 = var4.length() + (this.field_73816_n);
            if (par1 == (this.field_73816_n)) {
                GuiPasswordField bq = this;
                bq.field_73816_n = GuiPasswordField.getField_73816_n16(bq) - GuiPasswordField.getFontRenderer4(this).trimStringToWidth(GuiPasswordField.getText2(this), var3, true).length();
            }
            if (par1 > var5) {
                GuiPasswordField bq = this;
                bq.field_73816_n = GuiPasswordField.getField_73816_n13(bq) + (par1 - var5);
            } else if (par1 <= (this.field_73816_n)) {
                GuiPasswordField bq = this;
                bq.field_73816_n = GuiPasswordField.getField_73816_n12(bq) - (GuiPasswordField.getField_73816_n7(this) - par1);
            }
            if ((this.field_73816_n) < 0) {
                this.field_73816_n = 0;
            }
            if ((this.field_73816_n) > var2) {
                this.field_73816_n = var2;
            }
        }
    }

    public int getNthWordFromPos(int par1, int par2) {
        return this.func_73798_a(par1, this.getCursorPosition(), true);
    }

    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }

    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width) - (8) : (this.width);
    }

    public boolean func_73778_q() {
        return (this.field_73823_s);
    }

    public int getSelectionEnd() {
        return (this.selectionEnd);
    }

    public void setFocused(boolean par1) {
        if (par1 && !(this.isFocused)) {
            this.cursorCounter = 0;
        }
        this.isFocused = par1;
    }

    public void func_73790_e(boolean par1) {
        this.field_73823_s = par1;
    }

    public void setMaxStringLength(int par1) {
        this.maxStringLength = par1;
        if ((this.text).length() > par1) {
            this.text = GuiPasswordField.getText6(this).substring(0, par1);
        }
    }

    private static int getMaxStringLength4(GuiPasswordField instance) {
        return instance.maxStringLength;
    }

    public void func_73779_a(int par1) {
        if ((this.text).length() != 0) {
            if ((this.selectionEnd) != (this.cursorPosition)) {
                this.writeText("");
            } else {
                this.deleteFromCursor(this.getNthWordFromCursor(par1) - (this.cursorPosition));
            }
        }
    }

    private static int getCursorCounter2(GuiPasswordField instance) {
        return instance.cursorCounter;
    }

    public void setEnableBackgroundDrawing(boolean par1) {
        this.enableBackgroundDrawing = par1;
    }

    public void setText(String par1Str) {
        if (par1Str.length() > (this.maxStringLength)) {
            this.text = par1Str.substring(0, GuiPasswordField.getMaxStringLength4(this));
        } else {
            this.text = par1Str;
        }
        this.setCursorPositionEnd();
    }

    private static int getField_73816_n16(GuiPasswordField instance) {
        return instance.field_73816_n;
    }
}

