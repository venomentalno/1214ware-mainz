package neo.deobf;

import java.util.function.Supplier;

public class NumberSetting extends Setting {
    public float value;
    public float min;
    public float max;
    public float increment;
    public boolean pressed;
    public float widthAnimated;
    public float printAnimated;
    public int alphaText;

    public NumberSetting(String name, float value, float min, float max, float increment) {
        super(name);
        this.value     = value;
        this.min       = min;
        this.max       = max;
        this.increment = increment;
        setVisible(() -> true);
    }

    public NumberSetting(String name, float value, float min, float max, float increment, Supplier<Boolean> visible) {
        super(name);
        this.value     = value;
        this.min       = min;
        this.max       = max;
        this.increment = increment;
        setVisible(visible);
    }

    public void setValueNumber(float value) {
        this.value = Math.max(min, Math.min(max, value));
    }
}
