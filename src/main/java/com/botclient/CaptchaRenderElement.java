/*
 * Decompiled with CFR 0.152.
 */
package com.botclient;

import java.awt.image.BufferedImage;

public class CaptchaRenderElement {
    public BufferedImage currentCaptcha;
    public final int y;
    public final int width;
    public final int height;
    public final int x;

    public int getHeight() {
        return (this.height);
    }

    public void render(int mouseX, int mouseY, float partialTicks) {
    }

    public int getX() {
        return (this.x);
    }

    public BufferedImage getCaptcha() {
        return (this.currentCaptcha);
    }

    private static int getX(CaptchaRenderElement instance) {
        return instance.x;
    }

    private static int getHeight(CaptchaRenderElement instance) {
        return instance.height;
    }

    public int getWidth() {
        return (this.width);
    }

    public CaptchaRenderElement(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getY() {
        return (this.y);
    }

    private static int getY(CaptchaRenderElement instance) {
        return instance.y;
    }

    private static int getWidth(CaptchaRenderElement instance) {
        return instance.width;
    }

    public void setCaptcha(BufferedImage currentCaptcha) {
        this.currentCaptcha = currentCaptcha;
    }
}

