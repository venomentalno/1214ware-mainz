/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.MinecraftContext
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiIngame
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package neo.deobf;

import neo.deobf.MinecraftContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class ChatUtils
implements MinecraftContext {

    public static void formatMsg(String message) {
        if ((Minecraft.getMinecraft().ingameGUI) != null) {
            (Minecraft.getMinecraft().ingameGUI).getChatGUI().printChatMessage((ITextComponent)new TextComponentString("§d§lNeo§f§lWare §d§l• §f§l" + message.replace("&", "§")));
        }
    }

    public static void defaultMsg(String message) {
        if ((Minecraft.getMinecraft().ingameGUI) != null) {
            (Minecraft.getMinecraft().ingameGUI).getChatGUI().printChatMessage((ITextComponent)new TextComponentString(message.replace("&", "§")));
        }
    }
}

