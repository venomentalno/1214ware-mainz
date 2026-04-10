package neo.deobf;

import java.util.function.Supplier;

public class BooleanSetting extends Setting {
    public boolean value;
    public double animation;

    public BooleanSetting(String name, boolean value) {
        super(name);
        this.value = value;
        setVisible(() -> true);
    }

    public BooleanSetting(String name, boolean value, Supplier<Boolean> visible) {
        super(name);
        this.value = value;
        setVisible(visible);
    }

    public void setBoolValue(boolean value) {
        this.value = value;
    }
}
