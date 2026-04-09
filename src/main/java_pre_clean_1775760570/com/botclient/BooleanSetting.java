/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Setting
 */
package com.botclient;

import java.util.function.Supplier;
import com.botclient.Setting;

public class BooleanSetting
extends Setting {
    public boolean value;
    public double animation;

    public BooleanSetting(String name, boolean value, Supplier<Boolean> visible) {
        super(name);
        this.value = value;
        this.setVisible(visible);
    }

    public BooleanSetting(String name, boolean value) {
        super(name);
        this.value = value;
        this.setVisible(() -> true);
    }

    public void setBoolValue(boolean value) {
        this.value = value;
    }
}

