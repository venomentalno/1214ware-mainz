/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.AccountsFile
 *  neo.deobf.CustomFile
 *  net.minecraft.client.Minecraft
 */
package neo.deobf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import neo.deobf.AccountsFile;
import neo.deobf.CustomFile;
import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class FileManager {
    public static final File directory = new File(Minecraft.getMinecraft().gameDir, "/NeoWare/");
    public static ArrayList<CustomFile> files = new ArrayList();

    public void init() throws IOException {
        if (!(directory).exists()) {
            (directory).mkdirs();
        } else {
            this.loadFiles();
        }
    }
public void saveFiles() {
        for (CustomFile f : (files)) {
            try {
                f.saveFile();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public CustomFile getFile(Class<?> clazz) {
        CustomFile file;
        Iterator customFileIterator = (files).iterator();
        do {
            if (customFileIterator.hasNext()) continue;
            return null;
        } while ((file = (CustomFile)customFileIterator.next()).getClass() != clazz);
        return file;
    }

    public void loadFiles() {
        for (CustomFile file : (files)) {
            try {
                if (!CustomFile.access$000((CustomFile)file)) continue;
                file.loadFile();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public FileManager() {
        files.add((CustomFile)new AccountsFile("accounts", true));
    }
}

