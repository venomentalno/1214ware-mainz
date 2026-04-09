package com.botclient;

import java.awt.image.BufferedImage;

public class GifFrameInfo {
    private final BufferedImage image;
    private final int x;
    private final int y;
    private final int delay;
    
    public GifFrameInfo(BufferedImage image, int x, int y, int delay) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.delay = delay;
    }
    
    public BufferedImage getImage() {
        return this.image;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getDelay() {
        return this.delay;
    }
}