package com.botclient;

public enum AltStatus {
    PENDING("Pending"),
    LOGGED_IN("Logged In"),
    WORKING("Working"),
    BANNED("Banned"),
    UNCHECKED("Unchecked"),
    NOT_WORKING("Not Working");

    private final String displayName;

    AltStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
