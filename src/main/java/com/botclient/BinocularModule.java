/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.UpdateEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.ModuleCategory
 *  neo.deobf.Module
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.KeyBinding
 *  org.lwjgl.input.Mouse
 */
package neo.deobf;

import neo.deobf.UpdateEvent;
import neo.deobf.EventTarget;
import neo.deobf.ModuleCategory;
import neo.deobf.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Mouse;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class BinocularModule
extends Module {
    public static float zoom = 4.0f;

    public BinocularModule() {
        super("Binocular", ModuleCategory.Player);
    }

    private static GameSettings getGameSettings() {
        return Minecraft.gameSettings;
    }

    @EventTarget
    public void onEventUpdate(UpdateEvent e) {
        int kek = Mouse.getDWheel();
        if (GameSettings.isKeyDown((KeyBinding)(BinocularModule.getGameSettings().ofKeyBindZoom))) {
            if (kek >= (1)) {
                zoom = (float)((double)(zoom) + (Mouse.isButtonDown((int)(2)) ? 8.0 : 0.80000000000000004));
            }
            if (Mouse.getDWheel() > kek) {
                zoom = (float)((double)(zoom) - (Mouse.isButtonDown((int)(2)) ? 8.0 : 0.80000000000000004));
            }
            if ((zoom) < 2.0f) {
                zoom = 2.0f;
            }
            if ((zoom) > 350.0f) {
                zoom = 350.0f;
            }
        }
    }

    public void onDisable() {
        super.onDisable();
        zoom = 4.0f;
    }

    public void onEnable() {
        super.onEnable();
    }
}

