package neo.deobf;

// 1.21.4: net.minecraft.util.MathHelper → net.minecraft.util.Mth  (kept in MathUtils so callers don't change)
import net.minecraft.util.Mth;

public class MathUtils {

    public static float lerp(float a, float b, float t) {
        return a + (b - a) * t;
    }

    public static double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }

    public static float clamp(float val, float min, float max) {
        return Mth.clamp(val, min, max);
    }

    public static double clamp(double val, double min, double max) {
        return Mth.clamp(val, min, max);
    }

    public static int clamp(int val, int min, int max) {
        return Mth.clamp(val, min, max);
    }

    public static float wrapDegrees(float deg) {
        return Mth.wrapDegrees(deg);
    }

    public static double wrapDegrees(double deg) {
        return Mth.wrapDegrees(deg);
    }

    public static float sqrt(float val) {
        return Mth.sqrt(val);
    }

    public static int floor(double val) {
        return Mth.floor(val);
    }

    public static int ceil(double val) {
        return Mth.ceil(val);
    }

    public static boolean isInRange(double val, double min, double max) {
        return val >= min && val <= max;
    }
}
