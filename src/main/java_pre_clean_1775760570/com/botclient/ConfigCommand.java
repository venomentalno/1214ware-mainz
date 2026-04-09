/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CommandInfo
 *  neo.deobf.Command
 *  neo.deobf.Client
 *  neo.deobf.CommandChatListener
 *  neo.deobf.ChatUtils
 *  neo.deobf.ConfigManager
 *  net.minecraft.client.Minecraft
 */
package com.botclient;

import java.io.File;
import com.botclient.CommandInfo;
import com.botclient.Command;
import com.botclient.Client;
import com.botclient.CommandChatListener;
import com.botclient.ChatUtils;
import com.botclient.ConfigManager;
import net.minecraft.client.MinecraftClient;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@CommandInfo(name="cfg", description="Загрузка конфига для клиента.")
public class ConfigCommand
extends Command {
    public void error() {
        ChatUtils.formatMsg((String)((CommandChatListener.PREFIX) + "cfg <load/save> <configname> - Загрузка конфига для клиента."));
    }

    public void execute(String[] args) throws Exception {
        if (args.length != 0) {
            if (args.length == (2)) {
                if (args[0].equalsIgnoreCase("load")) {
                    if (!new File((MinecraftClient.getInstance().gameDir), "/NeoWare/configs/" + args[1] + ".cfg").exists()) {
                        ChatUtils.formatMsg((String)("Конфиг " + args[1] + " не найден!"));
                    } else {
                        (Client.getInstance().configManager).loadConfig(args[1]);
                        ChatUtils.formatMsg((String)("Конфиг " + args[1] + " успешно загружен!"));
                    }
                }
                if (args[0].equalsIgnoreCase("save")) {
                    ChatUtils.formatMsg((String)("Конфиг " + args[1] + " успешно сохранен!"));
                    (Client.getInstance().configManager).saveConfig(args[1]);
                }
            } else {
                this.error();
            }
        } else {
            this.error();
        }
    }
}

