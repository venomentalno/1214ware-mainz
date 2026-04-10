/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.PreMotionEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.TextSetting
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.ReplayAction
 *  neo.deobf.ReplayActionType
 *  neo.deobf.ModeSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.Module
 *  neo.deobf.ChatUtils
 *  neo.deobf.MillisTimer
 *  neo.deobf.ChatMessageEvent
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.KeyBinding
 */
package neo.deobf;

import java.util.ArrayList;
import neo.deobf.PreMotionEvent;
import neo.deobf.EventTarget;
import neo.deobf.TextSetting;
import neo.deobf.Setting;
import neo.deobf.ModuleCategory;
import neo.deobf.ReplayAction;
import neo.deobf.ReplayActionType;
import neo.deobf.ModeSetting;
import neo.deobf.NumberSetting;
import neo.deobf.Module;
import neo.deobf.ChatUtils;
import neo.deobf.MillisTimer;
import neo.deobf.ChatMessageEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ActionRecorderModule
extends Module {
    public final MillisTimer timer = new MillisTimer();
    public static ArrayList<ReplayAction> records;
    public static ModeSetting trigger;
    public static NumberSetting runDelay;
    public static boolean warning;
    public static TextSetting message;

    public ActionRecorderModule() {
        super("ActionRecorder", ModuleCategory.Bots);
        Setting[] settings = new Setting[3];
        settings[0] = trigger;
        settings[1] = runDelay;
        settings[2] = message;
        this.addSetting(settings);
        records = new ArrayList();
    }

    private static GameSettings getGameSettings() {
        return Minecraft.gameSettings;
    }

static {
        String[] stringArray = new String[4];
        stringArray[0] = "onJoin";
        stringArray[1] = "onAuth";
        stringArray[2] = "onMessage";
        stringArray[3] = "onGameGuard";
        trigger = new ModeSetting("Trigger", "None", stringArray);
        runDelay = new NumberSetting("Run Delay", 0.0f, 0.0f, 6000.0f, 10.0f);
        message = new TextSetting("Message", "trgr_msg", () -> (trigger).is("onMessage"));
    }

    private static GameSettings getGameSettings2() {
        return Minecraft.gameSettings;
    }

    @EventTarget
    public void onPreMotionEvent(PreMotionEvent event) {
        if ((this.timer).hasReached(20.0)) {
            (this.timer).reset();
            if ((records).size() > (500) && !(warning)) {
                ChatUtils.formatMsg((String)"&cДолгая запись действий может негативно сказаться на ботах!");
                warning = true;
            }
            (records).add(new ReplayAction((ReplayActionType.KEYBOARD), (ActionRecorderModule.getGameSettings7().keyBindForward).isKeyDown(), (ActionRecorderModule.getGameSettings5().keyBindBack).isKeyDown(), (ActionRecorderModule.getGameSettings6().keyBindLeft).isKeyDown(), (ActionRecorderModule.getGameSettings4().keyBindRight).isKeyDown(), event.getYaw(), event.getPitch(), (ActionRecorderModule.getGameSettings2().keyBindSneak).isKeyDown(), (ActionRecorderModule.getGameSettings().keyBindSprint).isKeyDown(), (ActionRecorderModule.getGameSettings3().keyBindJump).isKeyDown()));
        }
    }

    @EventTarget
    public void onMessage(ChatMessageEvent event) {
        String msg = event.getMessage();
        if (!msg.startsWith(".")) {
            (records).add(new ReplayAction((ReplayActionType.CHAT), msg));
        }
    }

    private static GameSettings getGameSettings3() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings4() {
        return Minecraft.gameSettings;
    }

    public void onDisable() {
        super.onDisable();
        ChatUtils.formatMsg((String)("Запись действий остановлена! Записано " + (records).size() + " элементов."));
    }

    private static GameSettings getGameSettings5() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings6() {
        return Minecraft.gameSettings;
    }

    private static GameSettings getGameSettings7() {
        return Minecraft.gameSettings;
    }

    public void onEnable() {
        super.onEnable();
        (records).clear();
        warning = false;
        ChatUtils.formatMsg((String)"Запись действий запущена!");
    }

}

