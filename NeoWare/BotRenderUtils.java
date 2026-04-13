/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.PBot
 *  neo.deobf.TranslationMapRu
 *  neo.deobf.ChatUtils
 *  neo.deobf.BlockUtils
 *  neo.deobf.PlaceholderFormatter
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 */
package neo.deobf;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;
import neo.deobf.PBot;
import neo.deobf.TranslationMapRu;
import neo.deobf.ChatUtils;
import neo.deobf.BlockUtils;
import neo.deobf.PlaceholderFormatter;
import net.minecraft.inventory.ClickType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class BotRenderUtils {

    public String stripColor(String input) {
        return PBot.stripColor((String)input);
    }

    public String limitStringLength(String str, int maxLength) {
        if (str.length() > maxLength) {
            return str.substring(0, maxLength);
        }
        return str;
    }

    public int getSword(PBot bot) {
        return BlockUtils.getSword((PBot)bot);
    }

    public PBot[] getBots() {
        PBot[] bots = new PBot[(PBot.bots).size()];
        return (PBot.bots).toArray(bots);
    }

    public float normalizeYaw(float yaw) {
        return BlockUtils.normalizeYaw((float)yaw);
    }

    public boolean hasSword(PBot bot) {
        return BlockUtils.hasSword((PBot)bot);
    }

    public float normalizePitch(float pitch) {
        return BlockUtils.normalizePitch((float)pitch);
    }

    public void sendMessage(String message) {
        ChatUtils.formatMsg((String)message);
    }

    public String translateItemKey(String input) {
        return TranslationMapRu.translate((String)input);
    }

    public float getDistance(PBot pbot, double targetX, double targetY, double targetZ) {
        return BlockUtils.getDistance((PBot)pbot, (double)targetX, (double)targetY, (double)targetZ);
    }

    public double getDistance(double px1, double py1, double pz1, double px2, double py2, double pz2) {
        return BlockUtils.getDistance((double)px1, (double)py1, (double)pz1, (double)px2, (double)py2, (double)pz2);
    }

    public String parsePlaceholders(String message) {
        return PlaceholderFormatter.format((String)message);
    }

    public EnumFacing getEnumFacing(String name) {
        return EnumFacing.byName((String)name);
    }

    public Color getColor(BufferedImage img, int x, int y) {
        int clr = img.getRGB(x, y);
        int red = (clr & (16711680)) >> (16);
        int green = (clr & (65280)) >> (8);
        int blue = clr & (255);
        return new Color(red, green, blue);
    }

    public BlockPos newBlockPos(int x, int y, int z) {
        return new BlockPos(x, y, z);
    }

    public ClickType getClickType(String type) {
        return ClickType.valueOf((String)type);
    }
}



