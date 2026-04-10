package neo.deobf;

import java.util.function.Supplier;

public class Setting {
    public String name;
    public Supplier<Boolean> visible;

    public Setting(String name) {
        this.name = name;
    }

    public void setVisible(Supplier<Boolean> visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible.get();
    }
}
