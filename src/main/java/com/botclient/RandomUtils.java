/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.MinecraftContext
 */
package neo.deobf;

import java.util.Random;
import neo.deobf.MinecraftContext;

public class RandomUtils
implements MinecraftContext {
    public static String randomStringByPattern(int length, String pattern) {
        Random random = new Random();
        StringBuilder randomWord = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            int index = random.nextInt(pattern.length());
            char randomChar = pattern.charAt(index);
            randomWord.append(randomChar);
        }
        return randomWord.toString();
    }

    public static int getIntRandom(int endnumber) {
        return (int)(Math.random() * (double)endnumber + 1.0);
    }

    public static double getRandom(int endnumber) {
        return Math.random() * (double)endnumber + 1.0;
    }

    public static String randomNumber(int length) {
        StringBuilder builder = new StringBuilder();
        char[] buffer = "1234567890".toCharArray();
        for (int i = 0; i < length; ++i) {
            Random rand = new Random();
            char[] cArray = new char[1];
            cArray[0] = buffer[rand.nextInt(buffer.length)];
            String s = new String(cArray);
            builder.append(rand.nextBoolean() ? s : s.toUpperCase());
        }
        return builder.toString();
    }

    public static int intRandom(int min, int max) {
        return (int)(Math.random() * (double)(max - min)) + min;
    }
public static String randomChineseString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; ++i) {
            int codePoint = (19968) + random.nextInt(20992);
            sb.append(Character.toChars(codePoint));
        }
        return sb.toString();
    }

    public static double getDoubleRandom2(double endnumber) {
        return Math.random() * endnumber + 1.0;
    }

    public static String randomString(int length) {
        StringBuilder builder = new StringBuilder();
        char[] buffer = "qwertyuiopasdfghjklzxcvbnm1234567890".toCharArray();
        for (int i = 0; i < length; ++i) {
            Random rand = new Random();
            char[] cArray = new char[1];
            cArray[0] = buffer[rand.nextInt(buffer.length)];
            String s = new String(cArray);
            builder.append(rand.nextBoolean() ? s : s.toUpperCase());
        }
        return builder.toString();
    }

    public static double getDoubleRandom(int endnumber) {
        return Math.random() * (double)endnumber + 1.0;
    }

    public static float floatRandom(float min, float max) {
        return (float)((double)min + (double)(max - min) * Math.random());
    }
}



