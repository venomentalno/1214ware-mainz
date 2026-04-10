package neo.deobf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;

public class ModeSetting extends Setting {
    public boolean opened;
    public int index;
    public String currentMode;
    public final ArrayList<String> modes = new ArrayList<>();

    public ModeSetting(String name, String defaultMode, String... modes) {
        super(name);
        this.modes.add(defaultMode);
        this.modes.addAll(Arrays.asList(modes));
        this.currentMode = defaultMode;
        setVisible(() -> true);
    }

    public ModeSetting(String name, String defaultMode, Supplier<Boolean> visible, String... modes) {
        super(name);
        this.modes.add(defaultMode);
        this.modes.addAll(Arrays.asList(modes));
        this.currentMode = defaultMode;
        setVisible(visible);
    }

    public String get() {
        return modes.get(index);
    }

    public boolean is(String mode) {
        return get().equalsIgnoreCase(mode);
    }

    public void setListMode(String selected) {
        this.currentMode = selected;
        this.index       = modes.indexOf(currentMode);
        if (this.index < 0) this.index = 0;
    }

    public String getMode() { return currentMode; }
    public void setCurrentMode(String mode) { this.currentMode = mode; }
}
