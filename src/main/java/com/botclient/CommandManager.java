/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Command
 *  neo.deobf.CommandChatListener
 *  neo.deobf.BotsCommand
 *  neo.deobf.ChatUtils
 *  neo.deobf.ConfigCommand
 *  neo.deobf.CrashCommand
 *  neo.deobf.GetIPCommand
 *  neo.deobf.HelpCommand
 *  neo.deobf.PluginsCommand
 *  neo.deobf.SetPrefixCommand
 *  neo.deobf.EventBus
 */
package com.botclient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.botclient.Command;
import com.botclient.CommandChatListener;
import com.botclient.BotsCommand;
import com.botclient.ChatUtils;
import com.botclient.ConfigCommand;
import com.botclient.CrashCommand;
import com.botclient.GetIPCommand;
import com.botclient.HelpCommand;
import com.botclient.PluginsCommand;
import com.botclient.SetPrefixCommand;
import com.botclient.EventBus;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class CommandManager {
    public final ArrayList<Command> commands = new ArrayList();

    private static ArrayList getCommands(CommandManager instance) {
        return instance.commands;
    }

    public List<Command> getCommands() {
        return (this.commands);
    }

    public void execute(String args) {
        args = args.substring(1);
        String[] arguments = args.split(" ");
        for (Command cmd : (this.commands)) {
            if (!(cmd.name).trim().equalsIgnoreCase(arguments[0].trim())) continue;
            String[] argss = Arrays.copyOfRange(arguments, 1, arguments.length);
            try {
                cmd.execute(argss);
            }
            catch (Exception e) {
                e.printStackTrace();
                cmd.error();
            }
            return;
        }
        ChatUtils.formatMsg((String)"Команда не найдена!");
    }

    public CommandManager() {
        EventBus.register((Object)new CommandChatListener(this));
        this.commands.add((Command)new HelpCommand());
        this.commands.add((Command)new CrashCommand());
        this.commands.add((Command)new GetIPCommand());
        this.commands.add((Command)new SetPrefixCommand());
        this.commands.add((Command)new ConfigCommand());
        this.commands.add((Command)new BotsCommand());
        this.commands.add((Command)new PluginsCommand());
    }

}

