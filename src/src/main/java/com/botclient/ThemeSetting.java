package neo.deobf;

import java.util.function.Supplier;

public class ThemeSetting extends Setting {
    private Theme value;

    public ThemeSetting(String name, Theme defaultTheme) {
        super(name);
        this.value = defaultTheme;
        setVisible(() -> true);
    }

    public Theme get()                 { return value; }
    public void setTheme(Theme theme)  { this.value = theme; }
}
