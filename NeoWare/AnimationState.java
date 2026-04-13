/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.MathHelper
 */
package neo.deobf;

import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AnimationState {
    public final double animationSpeed;
    public double animationState;
    public double prevAnimationState;

    public AnimationState() {
        this(0.0);
    }

    private static double getAnimationSpeed(AnimationState instance) {
        return instance.animationSpeed;
    }

    public AnimationState(double animationSpeed) {
        this.animationSpeed = 0.14999999999999999 + animationSpeed;
    }

    private static double getAnimationState(AnimationState instance) {
        return instance.animationState;
    }

    public void reset() {
        this.prevAnimationState = 0.0;
        this.animationState = 0.0;
    }

    public void set(double animation) {
        this.animationState = animation;
        this.prevAnimationState = animation;
    }

    public double dropAnimation(double value) {
        double c1 = 1.7015800000000001;
        double c3 = c1 + 1.0;
        return 1.0 + c3 * Math.pow(value - 1.0, 3.0) + c1 * Math.pow(value - 1.0, 2.0);
    }

    public void update(boolean add) {
        this.prevAnimationState = AnimationState.getAnimationState(this);
        this.animationState = MathHelper.clamp((double)(AnimationState.getAnimationState3(this) + (add ? AnimationState.getAnimationSpeed2(this) : -AnimationState.getAnimationSpeed(this))), (double)0.0, (double)1.0);
    }

    public double createAnimation(double value) {
        return Math.sqrt(1.0 - Math.pow(value - 1.0, 2.0));
    }

    private static double getAnimationState3(AnimationState instance) {
        return instance.animationState;
    }

    private static double getAnimationSpeed2(AnimationState instance) {
        return instance.animationSpeed;
    }

    public double getDrop() {
        return this.dropAnimation((this.prevAnimationState) + ((this.animationState) - (this.prevAnimationState)) * (double)Minecraft.getMinecraft().getRenderPartialTicks());
    }

    public double get() {
        return this.createAnimation((this.prevAnimationState) + ((this.animationState) - (this.prevAnimationState)) * (double)Minecraft.getMinecraft().getRenderPartialTicks());
    }

}

