/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Setting
 *  neo.deobf.Theme
 */
package neo.deobf;

import java.awt.Color;
import neo.deobf.Setting;
import neo.deobf.Theme;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ThemeSetting
extends Setting {
    public Color oneColor;
    public Color twoColor;

    public void setOneColor(Color oneColor) {
        this.oneColor = oneColor;
    }

    private static void setOneColor(ThemeSetting bB, Color color) {
        bB.oneColor = color;
    }

    public Color getOneColor() {
        return (this.oneColor);
    }

    public void setTwoColor(Color twoColor) {
        this.twoColor = twoColor;
    }

    private static void setTwoColor(ThemeSetting bB, Color color) {
        bB.twoColor = color;
    }

    public Theme getTheme() {
        return new Theme((this.name), this.getOneColor(), this.getTwoColor());
    }

    private static Color getOneColor(ThemeSetting instance) {
        return instance.oneColor;
    }

    public ThemeSetting(String name, Color one, Color two) {
        super(name);
        this.oneColor = one;
        this.twoColor = two;
        this.setVisible(() -> true);
    }

    public Color getTwoColor() {
        return (this.twoColor);
    }

    private static Color getTwoColor(ThemeSetting instance) {
        return instance.twoColor;
    }
}

