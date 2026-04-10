package neo.deobf;

import net.minecraft.client.Minecraft;
import java.util.Random;

// 1.21.4: Minecraft.getMinecraft() → Minecraft.getInstance()
//         ScaledResolution removed – use Minecraft.getInstance().getWindow() instead
public interface MinecraftContext {
    Minecraft mc     = Minecraft.getInstance();
    Random    random = new Random();
}
