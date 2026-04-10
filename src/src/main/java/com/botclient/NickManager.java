package neo.deobf;

import net.minecraft.client.Minecraft;

import java.io.File;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;

public class NickManager {
    public final ArrayList<String> nickList = new ArrayList<>();
    public int fileIndex;

    public String getBotName() {
        String mode = BotSettingsModule.nickstype.get();
        return switch (mode) {
            case "random"   -> "Player_" + RandomUtils.randomNumber(100000);
            case "Custom"   -> PlaceholderFormatter.format(BotSettingsModule.customname.get());
            case "FromFile" -> {
                if (nickList.isEmpty()) yield "empty";
                if (fileIndex >= nickList.size()) fileIndex = 0;
                yield nickList.get(fileIndex++);
            }
            default -> RandomUtils.randomString(3);
        };
    }

    public void loadNicks() {
        nickList.clear();
        // 1.21.4: Minecraft.getMinecraft() → Minecraft.getInstance()
        File nickFile = new File(Minecraft.getInstance().gameDirectory, "/NeoWare/nicks/nicks.txt");
        createFile(nickFile.toPath());
        try {
            for (String nick : Files.readAllLines(nickFile.toPath())) {
                nick = nick.replaceAll("[^a-zA-Z0-9_]", "");
                if (nick.length() <= 3 || nick.length() >= 16) continue;
                nickList.add(nick);
            }
        } catch (Exception e) {
            if (e instanceof NoSuchFileException)
                ChatUtils.formatMsg("Файл с названием &d&lnicks.txt &f&lне найден!");
            e.printStackTrace();
        }
        ChatUtils.formatMsg("Загружено &d&l" + nickList.size() + " &f&lникнеймов");
    }

    private void createFile(Path path) {
        try {
            Files.createDirectories(path.getParent(), new FileAttribute[0]);
            if (!path.toFile().exists()) Files.createFile(path, new FileAttribute[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getNickList() { return nickList; }
}
