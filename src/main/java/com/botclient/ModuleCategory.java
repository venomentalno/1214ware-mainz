package neo.deobf;

import java.awt.Color;

public enum ModuleCategory {
    Render(20, new Color(110, 254, 102, 255), "e"),
    Player(20, new Color(96, 237, 164, 255), "h"),
    Other(20, new Color(164, 127, 192, 255), "k"),
    Bots(90, new Color(240, 60, 60, 255), "i"),
    Chat(20, new Color(139, 15, 241, 255), "n"),
    Themes(20, new Color(241, 117, 15, 255), "r");

    private final int offset;
    private final Color color;
    private final String icon;

    ModuleCategory(int offset, Color color, String icon) {
        this.offset = offset;
        this.color = color;
        this.icon = icon;
    }

    public int getOffset() {
        return this.offset;
    }

    public Color getColor() {
        return this.color;
    }

    public String getIcon() {
        return this.icon;
    }
}
