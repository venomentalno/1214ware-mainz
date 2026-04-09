/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.TextSetting
 *  neo.deobf.ModeSetting
 *  neo.deobf.BotSettingsModule
 *  neo.deobf.ChatUtils
 *  net.minecraft.client.Minecraft
 */
package com.botclient;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import com.botclient.ModeSetting;
import com.botclient.BotSettingsModule;
import com.botclient.ChatUtils;
import com.botclient.PlaceholderFormatter;
import com.botclient.RandomUtils;
import net.minecraft.client.MinecraftClient;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class NickManager {
    public final ArrayList<String> nickList = new ArrayList();
    public int fileIndex;

    private static ArrayList getNickList(NickManager instance) {
        return instance.nickList;
    }

    public ArrayList<String> getNickList() {
        return (this.nickList);
    }

    public String getBotName() {
        String mode = BotSettingsModule.nickstype.get();
        switch (mode) {
            case "random":
                return "Player_" + RandomUtils.randomNumber((int)(100000));
            case "Custom":
                return PlaceholderFormatter.format((String)(BotSettingsModule.customname.get()));
            case "FromFile":
                if ((this.nickList).size() == 0) {
                    return "empty";
                }
                if (this.fileIndex >= (this.nickList).size()) {
                    this.fileIndex = 0;
                }
                String fromFile = (String)(this.nickList).get(this.fileIndex);
                ++this.fileIndex;
                return fromFile;
            default:
                return RandomUtils.randomString((int)(3));
        }
    }

    public void loadNicks() {
        (this.nickList).clear();
        File nickFile = new File((MinecraftClient.getInstance().gameDir), "/NeoWare/nicks/nicks.txt");
        this.createFile(nickFile.toPath());
        try {
            for (String nick : Files.readAllLines(nickFile.toPath())) {
                if ((nick = nick.replaceAll("[^a-zA-Z0-9_]", "")).length() <= (3) || nick.length() >= (16)) continue;
                (this.nickList).add(nick);
            }
        }
        catch (Exception exception) {
            if (exception instanceof NoSuchFileException) {
                ChatUtils.formatMsg((String)"Файл с названием &d&lnicks.txt &f&lне найден!");
            }
            exception.printStackTrace();
            return;
        }
        ChatUtils.formatMsg((String)("Загружено &d&l" + (this.nickList).size() + " &f&lникнеймов"));
    }

    private void createFile(Path path) {
        try {
            Files.createDirectories(path.getParent(), new FileAttribute[0]);
            if (!path.toFile().exists()) {
                Files.createFile(path, new FileAttribute[0]);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

