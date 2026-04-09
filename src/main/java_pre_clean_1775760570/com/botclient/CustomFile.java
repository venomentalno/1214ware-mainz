/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.FileManager
 */
package com.botclient;

import java.io.File;
import java.io.IOException;
import com.botclient.FileManager;

/*
 * Exception performing whole class analysis ignored.
 */
public abstract class CustomFile {
    public final String name;
    public final File file;
    public final boolean load;

    private boolean loadOnStart() {
        return this.load;
    }

    public abstract void loadFile() throws IOException;

    public final String getName() {
        return this.name;
    }
static boolean access$000(CustomFile x0) {
        return x0.loadOnStart();
    }

    public CustomFile(String name, boolean loadOnStart) {
        this.name = name;
        this.load = loadOnStart;
        this.file = new File(FileManager.directory, name + ".json");
        if (!this.file.exists()) {
            try {
                this.saveFile();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String getName(CustomFile instance) {
        return instance.name;
    }

    private static File getFile(CustomFile instance) {
        return instance.file;
    }

    public abstract void saveFile() throws IOException;

    public final File getFile() {
        return this.file;
    }
}

