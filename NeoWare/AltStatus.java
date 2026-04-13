package neo.deobf;

import net.minecraft.util.text.TextFormatting;

public enum AltStatus {
    Working(TextFormatting.GREEN + "Working"),
    Banned(TextFormatting.RED + "Banned"),
    Unchecked(TextFormatting.YELLOW + "Unchecked"),
    NotWorking(TextFormatting.RED + "Not Working");

    public final String formatted;

    AltStatus(String formatted) {
        this.formatted = formatted;
    }

    public String toFormatted() {
        return this.formatted;
    }
}
