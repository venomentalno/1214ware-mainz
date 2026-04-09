/*
 * Decompiled with CFR 0.152.
 */
package com.botclient;

import java.util.function.Supplier;

public class Setting {
    public String name;
    public Supplier<Boolean> visible;

    public void setVisible(Supplier<Boolean> visible) {
        this.visible = visible;
    }

    private static void setVisible(Setting bC, Supplier supplier) {
        bC.visible = supplier;
    }

    public boolean isVisible() {
        return (Boolean)(this.visible).get();
    }

    public Setting(String name) {
        this.name = name;
    }
}

