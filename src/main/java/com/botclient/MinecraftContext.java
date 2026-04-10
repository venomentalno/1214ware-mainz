/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 */
package neo.deobf;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public interface MinecraftContext {
    public static final Minecraft mc = Minecraft.getMinecraft();
    public static final Random random = new Random();
    public static final ScaledResolution sr = new ScaledResolution(mc);
}



