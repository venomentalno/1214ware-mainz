package com.botclient;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ChatUtils implements MinecraftContext {
    public static void formatMsg(String message) {
        if (MinecraftClient.getInstance().inGameHud != null) {
            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(
                Text.of(message.replace("&", "§"))
            );
        }
    }

    public static void defaultMsg(String message) {
        if (MinecraftClient.getInstance().inGameHud != null) {
            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(
                Text.of(message.replace("&", "§"))
            );
        }
    }
}
