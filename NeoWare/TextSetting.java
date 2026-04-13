/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Setting
 */
package neo.deobf;

import java.util.function.Supplier;
import neo.deobf.Setting;

public class TextSetting
extends Setting {
    public String text;
    public boolean typing;

    public void setTextValue(String txt) {
        this.text = txt;
    }

    public String get() {
        return (this.text);
    }

    public TextSetting(String name, String text, Supplier<Boolean> visible) {
        super(name);
        this.text = text;
        this.setVisible(visible);
    }

    public TextSetting(String name, String text) {
        super(name);
        this.text = text;
        this.setVisible(() -> true);
    }
}

