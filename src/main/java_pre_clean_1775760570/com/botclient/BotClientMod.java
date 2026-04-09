package com.botclient;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BotClientMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("botclient");

    @Override
    public void onInitialize() {
        LOGGER.info("BotClient mod loaded!");
    }
}
