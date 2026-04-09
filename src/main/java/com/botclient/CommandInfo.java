/*
 * Decompiled with CFR 0.152.
 */
package com.botclient;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface CommandInfo {
    public String name();

    public String description();
}





