/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Render2DEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.ModuleCategory
 *  neo.deobf.Module
 *  neo.deobf.NotificationType
 *  neo.deobf.NotificationEntry
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.settings.GameSettings
 */
package neo.deobf;

import java.util.ArrayList;
import java.util.List;
import neo.deobf.Render2DEvent;
import neo.deobf.EventTarget;
import neo.deobf.ModuleCategory;
import neo.deobf.Module;
import neo.deobf.NotificationType;
import neo.deobf.NotificationEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.settings.GameSettings;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class NotificationsModule
extends Module {
    public static final List<NotificationEntry> notifies = new ArrayList<NotificationEntry>();

    public NotificationsModule() {
        super("Notifications", ModuleCategory.Other);
    }

    public static void render(ScaledResolution res) {
        float yOffset = -24.0f;
        if (((mc).currentScreen) instanceof GuiChat) {
            int i = (NotificationsModule.getGameSettings().guiScale);
            if (i == 0) {
                yOffset -= 26.0f;
            }
            if (i == (2)) {
                yOffset -= 14.0f;
            }
        }
        for (NotificationEntry notify : (notifies)) {
            yOffset -= notify.draw(res, yOffset);
        }
    }

    private static GameSettings getGameSettings() {
        return Minecraft.gameSettings;
    }

    @EventTarget
    public void onUpdate(Render2DEvent event) {
        (notifies).forEach(notify -> notify.updateAnimation());
        (notifies).removeIf(NotificationEntry::updateAnimation);
        NotificationsModule.render(new ScaledResolution(Minecraft.getMinecraft()));
    }

public static void notify(String title, String text, NotificationType type, int second) {
        if ((Minecraft.player) != null) {
            (notifies).add(new NotificationEntry(title, text, type).setMaxTime(second * (30)));
        }
    }
}


