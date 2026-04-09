package com.botclient;

import net.minecraft.util.Formatting;

public enum AltStatus {
    Working(Formatting.GREEN + "Working"),
    Banned(Formatting.RED + "Banned"),
    Unchecked(Formatting.YELLOW + "Unchecked"),
    NotWorking(Formatting.RED + "Not Working");

    public final String formatted;

    AltStatus(String formatted) {
        this.formatted = formatted;
    }

    public String toFormatted() {
        return this.formatted;
    }
}
