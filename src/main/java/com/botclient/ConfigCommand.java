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
package neo.deobf;

import java.io.File;
import neo.deobf.CommandInfo;
import neo.deobf.Command;
import neo.deobf.Client;
import neo.deobf.CommandChatListener;
import neo.deobf.ChatUtils;
import neo.deobf.ConfigManager;
import net.minecraft.client.Minecraft;

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
                    if (!new File((Minecraft.getMinecraft().gameDir), "/NeoWare/configs/" + args[1] + ".cfg").exists()) {
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

