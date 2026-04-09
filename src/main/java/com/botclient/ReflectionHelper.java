/*
 * Decompiled with CFR 0.152.
 */
package com.botclient;

import java.lang.reflect.Field;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ReflectionHelper {
    private String className;
    public Class<?> clazz;

    public void setStaticField(String a2, Object v1) throws NoSuchFieldException, IllegalAccessException {
        Field v2 = (this.clazz).getDeclaredField(a2);
        v2.setAccessible(true);
        Field v3 = Field.class.getDeclaredField("modifiers");
        v3.setAccessible(true);
        v3.setInt(v2, v2.getModifiers() & (-17));
        v2.set(null, v1);
    }

    public ReflectionHelper(String v1) {
        try {
            this.clazz = Class.forName(v1);
        }
        catch (ClassNotFoundException v2) {
            v2.printStackTrace();
        }
    }
}

