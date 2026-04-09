/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.MinecraftContext
 *  net.minecraft.util.math.MathHelper
 */
package com.botclient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.botclient.MinecraftContext;
import net.minecraft.util.math.MathHelper;

public class MathUtils
implements MinecraftContext {
    public static final float PI2 = (float)Math.PI * 2;
    public static final float PI = (float)Math.PI;

    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }

    public static Double interpolate1(double oldValue, double newValue, double interpolationValue) {
        return oldValue + (newValue - oldValue) * interpolationValue;
    }

    public static double interpolate(double current, double old, double scale) {
        return old + (current - old) * scale;
    }

    public static float calculateGaussianValue(float x, float sigma) {
        double PI = 3.141592653;
        double output = 1.0 / Math.sqrt(2.0 * PI * (double)(sigma * sigma));
        return (float)(output * Math.exp((double)(-(x * x)) / (2.0 * (double)(sigma * sigma))));
    }

    public static int interpolateInt(int oldValue, int newValue, double interpolationValue) {
        return (int)MathUtils.interpolate(oldValue, newValue, (float)interpolationValue);
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, (RoundingMode.HALF_UP));
        return bd.doubleValue();
    }

    public static float rotate(float from, float to, float minstep, float maxstep) {
        float f = MathUtils.wrapDegrees(to - from) * MathUtils.clamp(0.600000024f, 0.0f, 1.0f);
        f = f < 0.0f ? MathUtils.clamp(f, -maxstep, -minstep) : MathUtils.clamp(f, minstep, maxstep);
        if (Math.abs(f) > Math.abs(MathUtils.wrapDegrees(to - from))) {
            return to;
        }
        return from + f;
    }

    public static int getMiddle(int old, int newValue) {
        return (old + newValue) / (2);
    }

    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }

    public static float checkAngle(float one, float two, float three) {
        float f = MathHelper.wrapDegrees((float)(one - two));
        if (f < -three) {
            f = -three;
        }
        if (f >= three) {
            f = three;
        }
        return one - f;
    }

    public static double wrapDegrees(double value) {
        if ((value %= 360.0) >= 180.0) {
            value -= 360.0;
        }
        if (value < -180.0) {
            value += 360.0;
        }
        return value;
    }

    public static Object getRandomInRange(int i, int i1) {
        return null;
    }

    public static float lerp(double start, double end, double step) {
        return (float)(start + (end - start) * step);
    }

    public static float wrapDegrees(float value) {
        if ((value %= 360.0f) >= 180.0f) {
            value -= 360.0f;
        }
        if (value < -180.000031f) {
            value += 360.0f;
        }
        return value;
    }

    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }

    public static float interpolateFloat(float oldValue, float newValue, double interpolationValue) {
        return (float)MathUtils.interpolate(oldValue, newValue, (float)interpolationValue);
    }

    public static int intRandom(int max, int min) {
        return (int)(Math.random() * (double)(max - min)) + min;
    }

    public static long clamp(long value, long min, long max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }

    public static double randomNumber(double max, double min) {
        return Math.random() * (max - min) + min;
    }

    public static short clamp(short value, short min, short max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }
}

