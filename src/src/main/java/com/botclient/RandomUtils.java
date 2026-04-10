package neo.deobf;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static int intRandom(int min, int max) {
        if (min >= max) return min;
        return min + RANDOM.nextInt(max - min);
    }

    public static String randomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) sb.append(chars.charAt(RANDOM.nextInt(chars.length())));
        return sb.toString();
    }

    public static String randomNumber(int digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits; i++) sb.append(RANDOM.nextInt(10));
        return sb.toString();
    }
}
