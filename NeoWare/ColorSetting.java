/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Setting
 */
package neo.deobf;

import java.awt.Color;
import java.util.function.Supplier;
import neo.deobf.Setting;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ColorSetting
extends Setting {
    public int color;
    public int picker;

    public void setColorValue(int color) {
        this.color = color;
    }

    public int getColorValue() {
        return (this.color);
    }

    public ColorSetting(String name, int color) {
        super(name);
        this.color = color;
        this.setVisible(() -> true);
    }

    public void setPicker(int picker) {
        this.picker = picker;
    }

    private static void setPicker(ColorSetting bw, int n) {
        bw.picker = n;
    }

    public ColorSetting(String name, int color, Supplier<Boolean> visible) {
        super(name);
        this.color = color;
        this.setVisible(visible);
    }

    public int getPicker() {
        return (this.picker);
    }

    public Color getColorc() {
        return new Color((this.color));
    }

    private static int getPicker(ColorSetting instance) {
        return instance.picker;
    }
}

