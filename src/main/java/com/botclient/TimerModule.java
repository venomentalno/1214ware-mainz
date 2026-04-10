/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.PreMotionEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.NumberSetting
 *  neo.deobf.Module
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.Timer
 */
package neo.deobf;

import neo.deobf.PreMotionEvent;
import neo.deobf.EventTarget;
import neo.deobf.Setting;
import neo.deobf.ModuleCategory;
import neo.deobf.NumberSetting;
import neo.deobf.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Timer;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class TimerModule
extends Module {
    public NumberSetting timerAmount = new NumberSetting("Скорость", 2.0f, 1.0f, 10.0f, 1.0f);

    private static Timer getTimer(Minecraft minecraft) {
        return minecraft.timer;
    }

    private static Timer getTimer2(Minecraft minecraft) {
        return minecraft.timer;
    }

    private static NumberSetting getTimerAmount(TimerModule instance) {
        return instance.timerAmount;
    }

    public TimerModule() {
        super("Timer", ModuleCategory.Player);
        Setting[] settings = new Setting[1];
        settings[0] = this.timerAmount;
        this.addSetting(settings);
    }

    private static float getValue(NumberSetting instance) {
        return instance.value;
    }

    public void onDisable() {
        super.onDisable();
        TimerModule.getTimer2((mc)).timerSpeed = 1.0f;
    }

    @EventTarget
    public void onPreUpdate(PreMotionEvent eventPreMotion) {
        TimerModule.getTimer((mc)).timerSpeed = TimerModule.getValue(TimerModule.getTimerAmount(this));
    }

}

