/*
 * Decompiled with CFR 0.152.
 */
package neo.deobf;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import javax.imageio.ImageIO;

public class ImageUtils {
    public static void saveImage(BufferedImage image, File file) {
        try {
            ImageIO.write((RenderedImage)image, "PNG", file);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    public static String md5(String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            byte[] byArray = array;
            int n = byArray.length;
            for (int i = 0; i < n; ++i) {
                byte b = byArray[i];
                sb.append(Integer.toHexString(b & (255) | 256).substring(1, 3));
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return null;
        }
    }

    public static double calculateDifference(BufferedImage img1, BufferedImage img2) {
        int width = img1.getWidth();
        int height = img1.getHeight();
        int[] pixels1 = new int[width * height];
        int[] pixels2 = new int[width * height];
        img1.getRGB(0, 0, width, height, pixels1, 0, width);
        img2.getRGB(0, 0, width, height, pixels2, 0, width);
        double totalDiff = 0.0;
        for (int i = 0; i < pixels1.length; ++i) {
            int pixel1 = pixels1[i];
            int pixel2 = pixels2[i];
            int r1 = pixel1 >> (16) & (255);
            int g1 = pixel1 >> (8) & (255);
            int b1 = pixel1 & (255);
            int r2 = pixel2 >> (16) & (255);
            int g2 = pixel2 >> (8) & (255);
            int b2 = pixel2 & (255);
            totalDiff += (double)(Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2));
        }
        return totalDiff;
    }

    public static BufferedImage rotateImage(BufferedImage image, double angle) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
        Graphics2D g2d = rotatedImage.createGraphics();
        g2d.rotate(Math.toRadians(angle), (double)w / 2.0, (double)h / 2.0);
        g2d.drawImage((Image)image, 0, 0, null);
        g2d.dispose();
        return rotatedImage;
    }

    public static BufferedImage decodeBase64Image(String base64String) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(base64String);
            return ImageIO.read(new ByteArrayInputStream(imageBytes));
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertToBase64(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage)image, "png", baos);
        byte[] bytes = baos.toByteArray();
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return "data:image/png;base64," + base64;
    }

    public static BufferedImage toMonochrome(BufferedImage bufferedImage) {
        for (int width = 0; width < bufferedImage.getWidth(); ++width) {
            for (int height = 0; height < bufferedImage.getHeight(); ++height) {
                Graphics2D graphics = bufferedImage.createGraphics();
                Color color = new Color(bufferedImage.getRGB(width, height));
                if (color.getRed() > (252) && color.getGreen() > (252) && color.getBlue() > (252)) {
                    graphics.setColor((Color.BLACK));
                    graphics.drawLine(width, height, width, height);
                    continue;
                }
                graphics.setColor((Color.WHITE));
                graphics.drawLine(width, height, width, height);
            }
        }
        return bufferedImage;
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int newWidth) {
        if (originalImage.getWidth() < newWidth) {
            return originalImage;
        }
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        int newHeight = newWidth * originalHeight / originalWidth;
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, 4);
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, 2);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(scaledImage, 0, 0, null);
        g.dispose();
        return resizedImage;
    }

    public static String imageToBase64(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage)image, "png", byteArrayOutputStream);
        return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
    }

    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write((RenderedImage)image, type, bos);
            byte[] imageBytes = bos.toByteArray();
            Base64.Encoder encoder = Base64.getEncoder();
            imageString = encoder.encodeToString(imageBytes);
            bos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static String imageToHash(BufferedImage image) {
        return ImageUtils.md5(ImageUtils.encodeToString(image, "png"));
    }

    public static BufferedImage compareImages(List<BufferedImage> images) {
        BufferedImage first = images.remove(0);
        int width = first.getWidth();
        int height = first.getHeight();
        HashSet<Integer> colors = new HashSet<Integer>();
        for (int y = 0; y < (3); ++y) {
            for (int x = 0; x < (3); ++x) {
                colors.add(first.getRGB(x, y));
            }
        }
        for (BufferedImage image : images) {
            for (int y = 0; y < height; ++y) {
                for (int x = 0; x < width; ++x) {
                    int colorL;
                    int colorF = first.getRGB(x, y);
                    if (!colors.contains(colorF) || colorF == (colorL = image.getRGB(x, y))) continue;
                    first.setRGB(x, y, colorL);
                }
            }
        }
        return first;
    }

    public static void rotateFrame(BufferedImage image, int frameX, int frameY) {
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage((Image)ImageUtils.rotateImage(image.getSubimage(frameX *= 128, frameY *= 128, 128, 128), 90.0), frameX, frameY, null);
        g2d.dispose();
    }

}

