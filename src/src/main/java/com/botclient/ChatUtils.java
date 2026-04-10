package neo.deobf;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class ChatUtils {

    /** Send a coloured message to the local player's chat HUD. */
    public static void formatMsg(String msg) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null) {
            // Replace legacy § colour codes – they still work in Component.literal
            mc.gui.getChat().addMessage(Component.literal(colorize(msg)));
        }
    }

    public static void defaultMsg(String msg) {
        formatMsg(msg);
    }

    /** Translate & colour codes: & → § */
    private static String colorize(String input) {
        return input.replace('&', '§');
    }
}
