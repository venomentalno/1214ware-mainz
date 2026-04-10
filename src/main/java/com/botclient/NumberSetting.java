/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Setting
 */
package neo.deobf;

import java.util.function.Supplier;
import neo.deobf.Setting;

public class NumberSetting
extends Setting {
    public float max;
    public boolean pressed;
    public float min;
    public float value;
    public float widthAnimated;
    public float printAnimated;
    public float increment;
    public int alphaText;

    public NumberSetting(String name, float value, float min, float max, float increment) {
        super(name);
        this.value = value;
        this.min = min;
        this.max = max;
        this.increment = increment;
        this.setVisible(() -> true);
    }

    public NumberSetting(String name, float value, float min, float max, float increment, Supplier<Boolean> visible) {
        super(name);
        this.value = value;
        this.min = min;
        this.max = max;
        this.increment = increment;
        this.setVisible(visible);
    }

    public void setValueNumber(float value) {
        this.value = value;
    }
}

