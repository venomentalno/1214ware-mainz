/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Setting
 */
package com.botclient;

import java.util.function.Supplier;
import com.botclient.Setting;

public class InfoSetting
extends Setting {
    public String[] lines;

    public InfoSetting(String ... lines) {
        super("");
        this.lines = lines;
        this.setVisible(() -> true);
    }

    public InfoSetting(Supplier<Boolean> visible, String ... lines) {
        super("");
        this.lines = lines;
        this.setVisible(visible);
    }

    private static String[] getLines(InfoSetting instance) {
        return instance.lines;
    }
public String[] getLines() {
        return (this.lines);
    }
}

