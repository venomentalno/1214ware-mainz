package neo.deobf;

import java.util.function.Supplier;

public class TextSetting extends Setting {
    private String value;

    public TextSetting(String name, String defaultValue) {
        super(name);
        this.value = defaultValue;
        setVisible(() -> true);
    }

    public TextSetting(String name, String defaultValue, Supplier<Boolean> visible) {
        super(name);
        this.value = defaultValue;
        setVisible(visible);
    }

    public String get()                  { return value;  }
    public void setTextValue(String val) { this.value = val; }
}
