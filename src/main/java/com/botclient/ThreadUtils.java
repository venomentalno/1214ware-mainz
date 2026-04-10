/*
 * Decompiled with CFR 0.152.
 */
package neo.deobf;

public class ThreadUtils {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}



