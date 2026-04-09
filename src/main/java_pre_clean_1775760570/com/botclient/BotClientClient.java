package com.botclient;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BotClientClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("botclient");

    @Override
    public void onInitializeClient() {
        LOGGER.info("BotClient initialized for 1.21.4!");
    }
}
