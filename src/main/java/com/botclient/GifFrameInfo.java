/*
 * Decompiled with CFR 0.152.
 */
package neo.deobf;

/*
 * Exception performing whole class analysis ignored.
 */
public class GifFrameInfo {
    public final int x;
    public final int id;
    public final int y;

    public int getId() {
        return this.id;
    }

    private static int getX(GifFrameInfo instance) {
        return instance.x;
    }

    public GifFrameInfo(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    private static int getId(GifFrameInfo instance) {
        return instance.id;
    }

    private static int getY(GifFrameInfo instance) {
        return instance.y;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }
}

