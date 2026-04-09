/*
 * Decompiled with CFR 0.152.
 */
package com.botclient;

import java.awt.Color;

public class Theme {
    public Color twoColor;
    public String name;
    public Color oneColor;

    public Theme(String name, Color oneColor, Color twoColor) {
        this.name = name;
        this.oneColor = oneColor;
        this.twoColor = twoColor;
    }

    private static String getName(Theme instance) {
        return instance.name;
    }

    private static Color getTwoColor(Theme instance) {
        return instance.twoColor;
    }

    public String getName() {
        return (this.name);
    }

    private static void setOneColor(Theme eA, Color color) {
        eA.oneColor = color;
    }

    private static void setName(Theme eA, String string) {
        eA.name = string;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTwoColor(Color twoColor) {
        this.twoColor = twoColor;
    }

    public Color getTwoColor() {
        return (this.twoColor);
    }

    private static void setTwoColor(Theme eA, Color color) {
        eA.twoColor = color;
    }

    private static Color getOneColor(Theme instance) {
        return instance.oneColor;
    }

    public Color getOneColor() {
        return (this.oneColor);
    }

    public void setOneColor(Color oneColor) {
        this.oneColor = oneColor;
    }
}

