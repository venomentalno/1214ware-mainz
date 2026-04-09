/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  neo.deobf.ConfigSerializer
 *  net.minecraft.client.Minecraft
 *  org.apache.commons.io.FileUtils
 */
package com.botclient;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;
import com.botclient.ConfigSerializer;
import net.minecraft.client.MinecraftClient;
import org.apache.commons.io.FileUtils;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class ConfigManager {
    public ConfigManager() {
        this.loadConfig("default");
    }

    public static String readUsingFiles(File file) {
        try {
            return new String(Files.readAllBytes(file.toPath()));
        }
        catch (IOException e) {
            return null;
        }
    }

    public void saveConfig(String name) {
        try {
            FileUtils.writeByteArrayToFile((File)new File((MinecraftClient.getInstance().gameDir), "/NeoWare/configs/" + name + ".cfg"), (byte[])ConfigSerializer.save().toString().getBytes((StandardCharsets.UTF_8)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadConfig(String name) {
        try {
            ConfigSerializer.load((JsonObject)new JsonParser().parse(Objects.requireNonNull(ConfigManager.readUsingFiles(new File((MinecraftClient.getInstance().gameDir), "/NeoWare/configs/" + name + ".cfg")))).getAsJsonObject());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

