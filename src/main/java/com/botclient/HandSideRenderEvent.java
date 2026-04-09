/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Event
 *  net.minecraft.util.Arm
 */
package com.botclient;

import com.botclient.Event;
import net.minecraft.util.Arm;

public class ArmRenderEvent
implements Event {
    public final Arm enumArm;

    public ArmRenderEvent(Arm enumArm) {
        this.enumArm = enumArm;
    }

    public Arm getArm() {
        return (this.enumArm);
    }

    private static Arm getArm(ArmRenderEvent instance) {
        return instance.enumArm;
    }
}

