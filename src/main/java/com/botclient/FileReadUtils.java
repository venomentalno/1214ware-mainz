/*
 * Decompiled with CFR 0.152.
 */
package com.botclient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileReadUtils {
    public static String readUsingFiles(File file) {
        try {
            return new String(Files.readAllBytes(file.toPath()));
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}



