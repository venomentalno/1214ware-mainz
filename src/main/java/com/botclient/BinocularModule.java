/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.UpdateEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.ModuleCategory
 *  neo.deobf.Module
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.settings.GameOptions
 *  net.minecraft.client.settings.KeyBinding
 *  org.lwjgl.input.Mouse
 */
package com.botclient;

import com.botclient.UpdateEvent;
import com.botclient.EventTarget;
import com.botclient.ModuleCategory;
import com.botclient.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class BinocularModule
extends Module {
    public static float zoom = 4.0f;

    public BinocularModule() {
        super("Binocular", ModuleCategory.Player);
    }

    private static GameOptions getGameOptions() {
        return Minecraft.gameSettings;
    }

    @EventTarget
    public void onEventUpdate(UpdateEvent e) {
        int kek = GLFW.glfwGetScrollCallback;
        if (GameOptions.isKeyDown((KeyBinding)(BinocularModule.getGameOptions().ofKeyBindZoom))) {
            if (kek >= (1)) {
                zoom = (float)((double)(zoom) + (GLFW.glfwGetMouseButton(MinecraftClient.getInstance().getWindow().getHandle(), (int)(2)) ? 8.0 : 0.80000000000000004));
            }
            if (GLFW.glfwGetScrollCallback > kek) {
                zoom = (float)((double)(zoom) - (GLFW.glfwGetMouseButton(MinecraftClient.getInstance().getWindow().getHandle(), (int)(2)) ? 8.0 : 0.80000000000000004));
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

