/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.MathHelper
 *  org.lwjgl.opengl.GL11
 */
package com.botclient;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.RenderSystem;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AnimationUtils {
    public static double delta;

    public static float animation(float animation, float target, float speedTarget) {
        float dif = (target - animation) / Math.max((float)MinecraftClient.getInstance().getCurrentFps(), 5.0f) * 15.0f;
        if (dif > 0.0f) {
            dif = Math.max(speedTarget, dif);
            dif = Math.min(target - animation, dif);
        } else if (dif < 0.0f) {
            dif = Math.min(-speedTarget, dif);
            dif = Math.max(target - animation, dif);
        }
        return animation + dif;
    }

    public static float Move(float from, float to, float minstep, float maxstep, float factor) {
        float f = (to - from) * MathHelper.clamp((float)factor, (float)0.0f, (float)1.0f);
        f = f < 0.0f ? MathHelper.clamp((float)f, (float)(-maxstep), (float)(-minstep)) : MathHelper.clamp((float)f, (float)minstep, (float)maxstep);
        if (Math.abs(f) > Math.abs(to - from)) {
            return to;
        }
        return from + f;
    }

    public static void scaleAnimation(float x, float y, float scale, Runnable data) {
        RenderSystem.glPushMatrix();
        RenderSystem.glTranslatef((float)x, (float)y, (float)0.0f);
        RenderSystem.glScalef((float)scale, (float)scale, (float)1.0f);
        RenderSystem.glTranslatef((float)(-x), (float)(-y), (float)0.0f);
        data.run();
        RenderSystem.glPopMatrix();
    }

    public static double Interpolate(double start, double end, double step) {
        return start + (end - start) * step;
    }

    public static double animation(double animation, double target, double speedTarget) {
        double dif = (target - animation) / (double)Math.max(MinecraftClient.getInstance().getCurrentFps(), 5) * speedTarget;
        if (dif > 0.0) {
            dif = Math.max(speedTarget, dif);
            dif = Math.min(target - animation, dif);
        } else if (dif < 0.0) {
            dif = Math.min(-speedTarget, dif);
            dif = Math.max(target - animation, dif);
        }
        return animation + dif;
    }

    public static void translateAnimation(float x, float y, Runnable data) {
        RenderSystem.glPushMatrix();
        RenderSystem.glTranslatef((float)x, (float)y, (float)0.0f);
        data.run();
        RenderSystem.glPopMatrix();
    }

    public static float calculateCompensation(float target, float current, float delta, double speed) {
        float diff = current - target;
        if (delta < 1.0f) {
            delta = 1.0f;
        }
        if (delta > 1000.0f) {
            delta = 16.0f;
        }
        double dif = Math.max(speed * (double)delta / 16.666666030883789, 0.5);
        if ((double)diff > speed) {
            float f;
            current = (float)((double)current - dif);
            if (f < target) {
                current = target;
            }
        } else if ((double)diff < -speed) {
            float f;
            current = (float)((double)current + dif);
            if (f > target) {
                current = target;
            }
        } else {
            current = target;
        }
        return current;
    }

    public static float getAnimationState(float animation, float finalState, float speed) {
        float add = (float)((delta) * (double)(speed / 1000.0f));
        animation = animation < finalState ? (animation + add < finalState ? (animation += add) : finalState) : (animation - add > finalState ? (animation -= add) : finalState);
        return animation;
    }
}

