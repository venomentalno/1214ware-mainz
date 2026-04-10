package neo.deobf;

import java.awt.Color;
import java.util.function.Supplier;

public class ColorSetting extends Setting {
    public int color;

    public ColorSetting(String name, Color defaultColor) {
        super(name);
        this.color = defaultColor.getRGB();
        setVisible(() -> true);
    }

    public ColorSetting(String name, Color defaultColor, Supplier<Boolean> visible) {
        super(name);
        this.color = defaultColor.getRGB();
        setVisible(visible);
    }

    public Color getColor()              { return new Color(color, true); }
    public void setColorValue(int color) { this.color = color; }
}
