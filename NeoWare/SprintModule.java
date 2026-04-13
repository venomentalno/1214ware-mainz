/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.UpdateEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.ModuleCategory
 *  neo.deobf.Module
 *  neo.deobf.MovementUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 */
package neo.deobf;

import neo.deobf.UpdateEvent;
import neo.deobf.EventTarget;
import neo.deobf.ModuleCategory;
import neo.deobf.Module;
import neo.deobf.MovementUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class SprintModule
extends Module {

    public void onDisable() {
        (Minecraft.player).setSprinting(false);
        super.onDisable();
    }

    @EventTarget
    public void onUpdate(UpdateEvent eventUpdate) {
        if ((Minecraft.player).getFoodStats().getFoodLevel() / (2) > (3)) {
            (Minecraft.player).setSprinting(MovementUtils.isMoving());
        }
    }

    public SprintModule() {
        super("Sprint", ModuleCategory.Player);
    }
}

