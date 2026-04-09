/*
 * Decompiled with CFR 0.152.
 */
package com.botclient;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class BotSpammer {
    public static String text;
    public static int delay;
    public static boolean enabled;

    public static boolean isEnabled() {
        return (enabled);
    }

    public static void setEnabled(boolean enabled) {
        enabled = enabled;
    }

    public static void setDelay(int delay) {
        delay = delay;
    }

    public static String getText() {
        return (text);
    }

    public static int getDelay() {
        return (delay);
    }

    public static void setText(String text) {
        text = text;
    }

}

