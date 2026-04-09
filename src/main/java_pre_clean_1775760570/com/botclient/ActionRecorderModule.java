package com.botclient;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;

public class ActionRecorderModule extends Module {
    public final MillisTimer timer = new MillisTimer();
    public static ArrayList<ReplayAction> records;
    public static ModeSetting trigger;
    public static NumberSetting runDelay;
    public static boolean warning;
    public static TextSetting message;

    public ActionRecorderModule() {
        super("ActionRecorder", ModuleCategory.Bots);
        records = new ArrayList<>();
        
        // Settings initialization
        String[] modes = {"onJoin", "onAuth", "onMessage", "onGameGuard"};
        trigger = new ModeSetting("Trigger", "None", modes);
        runDelay = new NumberSetting("Run Delay", 0.0f, 0.0f, 6000.0f, 10.0f);
        message = new TextSetting("Message", "trgr_msg", () -> trigger.is("onMessage"));
        
        this.addSetting(trigger, runDelay, message);
    }

    @EventTarget
    public void onPreMotionEvent(PreMotionEvent event) {
        if (this.timer.hasReached(20.0)) {
            this.timer.reset();
            if (records.size() > 500 && !warning) {
                ChatUtils.formatMsg("&cДолгая запись действий может негативно сказаться на ботах!");
                warning = true;
            }
            
            GameOptions options = MinecraftClient.getInstance().options;
            records.add(new ReplayAction(
                ReplayActionType.KEYBOARD,
                options.keyForward.isPressed(),
                options.keyBack.isPressed(),
                options.keyLeft.isPressed(),
                options.keyRight.isPressed(),
                event.getYaw(),
                event.getPitch(),
                options.keySneak.isPressed(),
                options.keySprint.isPressed(),
                options.keyJump.isPressed()
            ));
        }
    }

    @EventTarget
    public void onMessage(ChatMessageEvent event) {
        String msg = event.getMessage();
        if (!msg.startsWith(".")) {
            records.add(new ReplayAction(ReplayActionType.CHAT, msg));
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        ChatUtils.formatMsg("Запись действий остановлена! Записано " + records.size() + " элементов.");
    }

    @Override
    public void onEnable() {
        super.onEnable();
        records.clear();
        warning = false;
        ChatUtils.formatMsg("Запись действий запущена!");
    }
}
