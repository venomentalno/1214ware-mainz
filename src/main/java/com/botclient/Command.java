/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CommandInfo
 *  neo.deobf.ChatUtils
 *  neo.deobf.MinecraftContext
 */
package neo.deobf;

import neo.deobf.CommandInfo;
import neo.deobf.ChatUtils;
import neo.deobf.MinecraftContext;

public abstract class Command
implements MinecraftContext {
    public String name = this.getClass().getAnnotation(CommandInfo.class).name();
    public String description = this.getClass().getAnnotation(CommandInfo.class).description();

    public abstract void execute(String[] var1) throws Exception;

    public abstract void error();

    public void sendMessage(String message) {
        ChatUtils.formatMsg((String)message);
    }
}





