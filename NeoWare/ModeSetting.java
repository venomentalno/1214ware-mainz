/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Setting
 */
package neo.deobf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;
import neo.deobf.Setting;

public class ModeSetting
extends Setting {
    public boolean opened;
    public int index;
    public String currentMode;
    public ArrayList<String> modes = new ArrayList();

    public void setCurrentMode(String currentMode) {
        this.currentMode = currentMode;
    }

    public String getMode() {
        return (this.currentMode);
    }

    private static void setCurrentMode(ModeSetting by, String string) {
        by.currentMode = string;
    }

    public String get() {
        return (String)(this.modes).get((this.index));
    }

    private static ArrayList getModes(ModeSetting instance) {
        return instance.modes;
    }

    public ModeSetting(String name, String defaultMode, Supplier<Boolean> visible, String ... modes) {
        super(name);
        this.modes.add(defaultMode);
        this.modes.addAll(Arrays.asList(modes));
        this.currentMode = defaultMode;
        this.setVisible(visible);
    }

    public void setListMode(String selected) {
        this.currentMode = selected;
        this.index = ModeSetting.getModes(this).indexOf(ModeSetting.getCurrentMode(this));
    }

    public ModeSetting(String name, String defaultMode, String ... modes) {
        super(name);
        this.modes.add(defaultMode);
        this.modes.addAll(Arrays.asList(modes));
        this.currentMode = defaultMode;
        this.setVisible(() -> true);
    }

    private static String getCurrentMode(ModeSetting instance) {
        return instance.currentMode;
    }

    public boolean is(String mode) {
        return this.get().equalsIgnoreCase(mode);
    }

}

