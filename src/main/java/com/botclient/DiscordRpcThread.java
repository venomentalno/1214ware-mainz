package com.botclient;

import java.util.Objects;
import net.minecraft.client.MinecraftClient;

public class DiscordRpcThread extends Thread {
    public DiscordRpcThread(DiscordRpcThreadToken x0) {
        this();
    }

    private DiscordRpcThread() {
    }

    @Override
    public void run() {
        this.setName("Discord-RPC");
        try {
            while (true) {
                if (Minecraft.player != null) {
                    String serverState;
                    if (MinecraftClient.getInstance().isSingleplayer()) {
                        serverState = "Singleplayer";
                    } else if ((DiscordRPCModule.hideServer).value) {
                        serverState = "Hidden";
                    } else {
                        serverState = Objects.requireNonNull(MinecraftClient.getInstance().getCurrentServerData()).serverIP;
                    }
                    DiscordRpc.update("Version: " + Client.VERSION_TYPE, "Server: " + serverState);
                } else {
                    DiscordRpc.update("Version: " + Client.VERSION_TYPE, "In MainMenu");
                }
                DiscordRpcLibrary.INSTANCE.Discord_RunCallbacks();
                ThreadUtils.sleep(5000L);
            }
        } catch (Exception exception) {
            DiscordRpc.stopRPC();
            super.run();
        }
    }
}
