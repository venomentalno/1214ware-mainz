/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.BooleanSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.PBot
 *  neo.deobf.PBotPlayer
 *  neo.deobf.PBotClientWorld
 *  neo.deobf.CaptchaManagerModule
 *  neo.deobf.CaptchaPacket
 *  neo.deobf.GifFrameInfo
 *  neo.deobf.ImageUtils
 *  net.minecraft.block.material.MapColor
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.ItemFrameEntity
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemMap
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.NonNullList
 *  net.minecraft.world.World
 *  net.minecraft.world.storage.MapData
 */
package com.botclient;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.botclient.BooleanSetting;
import com.botclient.NumberSetting;
import com.botclient.PBot;
import com.botclient.PBotPlayer;
import com.botclient.PBotClientWorld;
import com.botclient.CaptchaManagerModule;
import com.botclient.CaptchaPacket;
import com.botclient.GifFrameInfo;
import com.botclient.ImageUtils;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemFrameEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class CaptchaDetector {
    private static InventoryPlayer getInventory(PBotPlayer instance) {
        return instance.inventory;
    }

    private static Direction getEAST() {
        return Direction.EAST;
    }

    public static CaptchaPacket getCaptcha(PBot bot) {
        if (bot.world == null) {
            return null;
        }
        int mapItemSlot = bot.getMapSlot();
        if (mapItemSlot != (-1)) {
            Item mapItem = mapItemSlot == (45) ? (bot.player).getHeldItemOffhand().getItem() : ((ItemStack)(CaptchaDetector.getInventory(CaptchaDetector.getPlayer2(bot)).mainInventory).get(mapItemSlot)).getItem();
            ItemMap map = (ItemMap)mapItem;
            MapData mapData = map.getMapData(mapItem.getDefaultInstance(), (World)bot.world);
            BufferedImage captchaFrame = CaptchaDetector.mapToImage(CaptchaDetector.getMapData((mapData.colors)), false);
            return new CaptchaPacket(ImageUtils.imageToHash((BufferedImage)captchaFrame), captchaFrame, new ArrayList(), bot);
        }
        List<Object> frames = (bot.world.loadedEntityList).stream().filter(entity -> (entity instanceof EntityItemFrame && ((entity.getHorizontalFacing().equals((Object)CaptchaDetector.getSOUTH()) && (Entity)CaptchaDetector.getPlayer(bot).getHorizontalFacing().equals((Object)CaptchaDetector.getNORTH2()) || entity.getHorizontalFacing().equals((Object)CaptchaDetector.getWEST()) && (Entity)CaptchaDetector.getPlayer(bot).getHorizontalFacing().equals((Object)CaptchaDetector.getEAST2()) || entity.getHorizontalFacing().equals((Object)CaptchaDetector.getNORTH()) && (Entity)CaptchaDetector.getPlayer(bot).getHorizontalFacing().equals((Object)CaptchaDetector.getSOUTH2()) || entity.getHorizontalFacing().equals((Object)CaptchaDetector.getEAST()) && (Entity)CaptchaDetector.getPlayer(bot).getHorizontalFacing().equals((Object)CaptchaDetector.getWEST2()) ? 1 : 0) != 0) ? 1 : 0) != 0).map(EntityItemFrame.class::cast).collect(Collectors.toList());
        if (frames.size() == 0) {
            frames = (bot.world.loadedEntityList).stream().filter(entity -> entity instanceof EntityItemFrame).map(EntityItemFrame.class::cast).collect(Collectors.toList());
        }
        if (frames.size() > 0) {
            boolean rotation = CaptchaDetector.checkRot(frames);
            double minXZ = 2147483647.0;
            double minY = 2147483647.0;
            double maxXZ = -2147483648.0;
            double maxY = -2147483648.0;
            for (EntityItemFrame entityItemFrame : frames) {
                double frameXZ = rotation ? (entityItemFrame.posZ) : (entityItemFrame.posX);
                double frameY = (entityItemFrame.posY);
                minXZ = Math.min(minXZ, frameXZ);
                minY = Math.min(minY, frameY);
                maxXZ = Math.max(maxXZ, frameXZ);
                maxY = Math.max(maxY, frameY);
            }
            int width = (int)Math.abs(maxXZ - minXZ) + (1);
            int n = (int)Math.abs(maxY - minY) + (1);
            BufferedImage image = new BufferedImage(width * (128), n * (128), 1);
            ArrayList<GifFrameInfo> frameList = new ArrayList<GifFrameInfo>();
            for (EntityItemFrame entityItemFrame : frames) {
                double frameX = rotation ? (entityItemFrame.posZ) - minXZ : (entityItemFrame.posX) - minXZ;
                double frameY = (entityItemFrame.posY) - minY;
                if ((entityItemFrame.rotationYaw) == 0.0f || (entityItemFrame.rotationYaw) == 90.0f) {
                    frameX = (double)width - frameX - 1.0;
                }
                ItemMap map = (ItemMap)entityItemFrame.getDisplayedItem().getItem();
                MapData mapData = map.getMapData(entityItemFrame.getDisplayedItem(), (World)bot.world);
                BufferedImage captchaFrame = CaptchaDetector.mapToImage(CaptchaDetector.getMapData((mapData.colors)), false);
                frameList.add(new GifFrameInfo(entityItemFrame.getEntityId(), (int)((double)width - frameX - 1.0), (int)((double)n - frameY - 1.0)));
                image.createGraphics().drawImage((Image)(entityItemFrame.getRotation() != 0 ? CaptchaDetector.rotateImage(captchaFrame, entityItemFrame.getRotation() * (90)) : captchaFrame), (int)((double)width - frameX - 1.0) * (128), (int)((double)n - frameY - 1.0) * (128), null);
            }
            if ((CaptchaDetector.getGifCaptchaFix().value)) {
                if ((float)(bot.gifExemplars).size() < (CaptchaDetector.getGifFrames().value)) {
                    (bot.gifExemplars).add(image);
                    return null;
                }
                image = ImageUtils.compareImages((List)(bot.gifExemplars));
                (bot.gifExemplars).clear();
            }
            return new CaptchaPacket(ImageUtils.imageToHash((BufferedImage)image), image, frameList, bot);
        }
        return null;
    }

    private static BooleanSetting getGifCaptchaFix() {
        return CaptchaManagerModule.gifCaptchaFix;
    }

    private static PBotPlayer getPlayer(PBot instance) {
        return instance.player;
    }

    private static PBotPlayer getPlayer2(PBot instance) {
        return instance.player;
    }

    private static NumberSetting getGifFrames() {
        return CaptchaManagerModule.gifFrames;
    }

    public static BufferedImage rotateImage(BufferedImage image, int rotate) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage frame = new BufferedImage(height, width, 1);
        Graphics2D g2d = frame.createGraphics();
        g2d.rotate(Math.toRadians(rotate), width / (2), height / (2));
        g2d.drawImage((Image)image, 0, 0, null);
        g2d.dispose();
        return frame;
    }

    private static Direction getSOUTH() {
        return Direction.SOUTH;
    }

    private static Direction getWEST() {
        return Direction.WEST;
    }

    public static boolean checkRot(List<EntityItemFrame> frames) {
        if (frames.size() <= (1)) {
            return true;
        }
        int firstPosX = (int)(frames.get(0).posX);
        for (EntityItemFrame frame : frames) {
            int currentPosX = (int)(frame.posX);
            if (currentPosX == firstPosX) continue;
            return false;
        }
        return true;
    }

    private static Direction getWEST2() {
        return Direction.WEST;
    }

    private static Direction getEAST2() {
        return Direction.EAST;
    }

    private static Direction getNORTH() {
        return Direction.NORTH;
    }

    private static Direction getNORTH2() {
        return Direction.NORTH;
    }

    private static Direction getSOUTH2() {
        return Direction.SOUTH;
    }

    public static int[] getMapData(byte[] data) {
        int a;
        if (data == null) {
            return null;
        }
        int[] arr = new int[data.length];
        int[] colors = new int[arr.length];
        for (a = 0; a < (128); ++a) {
            for (int b = 0; b < (128); ++b) {
                colors[a + b * (128)] = data[a + b * (128)];
            }
        }
        for (a = 0; a < (16384); ++a) {
            int index = colors[a] & (255);
            arr[a] = index / (4) == 0 ? (a + a / (128) & (1)) * (8) + (16) << (24) : (MapColor.COLORS)[index / (4)].getMapColor(index & (3));
            arr[a] = arr[a] | -16777216;
        }
        return arr;
    }

    public static BufferedImage mapToImage(int[] mapTextureData, boolean monochrome) {
        try {
            int[] bandOffsets;
            int width = 128;
            int height = 128;
            byte[] bdata = new byte[65536];
            int byte_index = 0;
            int[] nArray = mapTextureData;
            int n = nArray.length;
            for (int i = 0; i < n; ++i) {
                int color = nArray[i];
                byte r = (byte)(color >> (16) & (255));
                byte g = (byte)(color >> (8) & (255));
                byte b = (byte)(color & (255));
                bdata[byte_index++] = r;
                bdata[byte_index++] = g;
                bdata[byte_index++] = b;
            }
            DataBufferByte buffer = new DataBufferByte(bdata, bdata.length);
            if (!monochrome) {
                int[] nArray2 = new int[3];
                nArray2[0] = 0;
                nArray2[1] = 1;
                nArray2[2] = 2;
                bandOffsets = nArray2;
            } else {
                int[] nArray3 = new int[3];
                nArray3[0] = 0;
                nArray3[1] = 0;
                nArray3[2] = 0;
                bandOffsets = nArray3;
            }
            WritableRaster raster = Raster.createInterleavedRaster(buffer, width, height, (3) * width, 3, bandOffsets, null);
            ColorSpace cs = ColorModel.getRGBdefault().getColorSpace();
            ComponentColorModel cm = new ComponentColorModel(cs, false, true, 1, 0);
            return new BufferedImage(cm, raster, false, null);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

