package neo.deobf;

import net.minecraft.client.Minecraft;

import java.io.File;
import java.io.IOException;

public abstract class CustomFile {
    private final String name;
    private final boolean loadOnStart;

    public CustomFile(String name, boolean loadOnStart) {
        this.name        = name;
        this.loadOnStart = loadOnStart;
    }

    public File getFile() {
        return new File(Minecraft.getInstance().gameDirectory, "NeoWare/" + name);
    }

    public boolean isLoadOnStart() { return loadOnStart; }
    public String  getName()       { return name;        }

    public abstract void loadFile() throws IOException;
    public abstract void saveFile() throws IOException;
}
