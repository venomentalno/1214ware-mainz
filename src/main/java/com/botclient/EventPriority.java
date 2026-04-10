/*
 * Decompiled with CFR 0.152.
 */
package neo.deobf;

public class EventPriority {
    public static final byte MEDIUM = 2;
    public static final byte LOWEST = 4;
    public static final byte[] VALUE_ARRAY;
    public static final byte HIGHEST = 0;
    public static final byte HIGH = 1;
    public static final byte LOW = 3;

    static {
        byte[] byArray = new byte[5];
        byArray[0] = 0;
        byArray[1] = 1;
        byArray[2] = 2;
        byArray[3] = 3;
        byArray[4] = 4;
        VALUE_ARRAY = byArray;
    }
}



