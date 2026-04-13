/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.EventTarget
 *  neo.deobf.EventBus
 *  neo.deobf.PacketReceiveEvent
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.network.play.server.SPacketSetExperience
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  net.minecraft.network.play.server.SPacketUpdateBossInfo
 *  net.minecraft.util.math.MathHelper
 */
package neo.deobf;

import java.sql.Timestamp;
import java.util.Arrays;
import neo.deobf.EventTarget;
import neo.deobf.EventBus;
import neo.deobf.PacketReceiveEvent;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.network.play.server.SPacketSetExperience;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.network.play.server.SPacketUpdateBossInfo;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class TickRateTracker {
    public static int nextIndex;
    public static final float[] tickRates;
    public static long millis;
    public static long timeLastTimeUpdate;

    @EventTarget
    public void onReceivePacket(PacketReceiveEvent event) {
        if (event.getPacket() instanceof SPacketTimeUpdate || event.getPacket() instanceof SPacketChat || event.getPacket() instanceof SPacketSetExperience || event.getPacket() instanceof SPacketUpdateBossInfo) {
            millis = new Timestamp(System.currentTimeMillis()).getTime();
            TickRateTracker.onTimeUpdate();
        }
    }

    public static float getTickRate() {
        float numTicks = 0.0f;
        float sumTickRates = 0.0f;
        float[] arrayOfFloat = (tickRates);
        int i = arrayOfFloat.length;
        int b = 0;
        while (b < i) {
            float tickRate = arrayOfFloat[b];
            if (tickRate > 0.0f) {
                sumTickRates += tickRate;
                numTicks += 1.0f;
            }
            b = (byte)(b + (1));
        }
        return MathHelper.clamp((float)(sumTickRates / numTicks), (float)0.0f, (float)20.0f);
    }

    private static void onTimeUpdate() {
        if ((timeLastTimeUpdate) != -1L) {
            float timeElapsed = (float)(System.currentTimeMillis() - (timeLastTimeUpdate)) / 1000.0f;
            (tickRates)[(nextIndex) % (tickRates).length] = MathHelper.clamp((float)(20.0f / timeElapsed), (float)0.0f, (float)20.0f);
            nextIndex = (nextIndex) + (1);
        }
        timeLastTimeUpdate = System.currentTimeMillis();
    }

    public static long getLagPackets() {
        return new Timestamp(System.currentTimeMillis()).getTime() - (millis);
    }

    static {
        tickRates = new float[20];
    }

    public static String getLagFormatColor() {
        long lagms = TickRateTracker.getLagPackets();
        if (lagms < 900L) {
            return "§a§l";
        }
        if (lagms > 900L && lagms < 1400L) {
            return "§6§l";
        }
        return "§c§l";
    }

    public static void init() {
        nextIndex = 0;
        timeLastTimeUpdate = -1L;
        Arrays.fill((tickRates), 0.0f);
        EventBus.register((Object)new TickRateTracker());
    }

}

