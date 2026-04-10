package neo.deobf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private final List<CustomFile> files = new ArrayList<>();

    public void register(CustomFile file) {
        files.add(file);
    }

    public void init() throws IOException {
        for (CustomFile file : files) {
            if (file.isLoadOnStart()) {
                try {
                    if (file.getFile().exists()) file.loadFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveAll() {
        for (CustomFile file : files) {
            try {
                file.saveFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<CustomFile> getFiles() { return files; }
}
