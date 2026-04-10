package neo.deobf;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.ChatFormatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Module {
    public static final String[] noDebugModules = {
        "ClickGui", "DiscordRPC", "BotBaritoneSettings", "Bot Debug", "BotSettings", "Captcha Manager"
    };

    // 1.21.4: Minecraft.getMinecraft() → Minecraft.getInstance()
    public static Minecraft mc = Minecraft.getInstance();

    public final String         moduleName;
    public final ModuleCategory moduleCategory;
    public boolean              moduleState;
    public int                  moduleKey;
    public boolean              opened = true;
    public String               suffix;
    public List<Setting>        settingList = new ArrayList<>();

    public Module(String name, ModuleCategory category) {
        this.moduleName     = name;
        this.moduleCategory = category;
        this.moduleKey      = 0;
    }

    public void addSetting(Setting... settings) {
        settingList.addAll(Arrays.asList(settings));
    }

    public void toggle() {
        moduleState = !moduleState;
        if (moduleState) onEnable(); else onDisable();
    }

    public void setState(boolean state) {
        if (state) EventBus.register(this); else EventBus.unregister(this);
        this.moduleState = state;
    }

    public void onEnable() {
        try {
            if (Client.getInstance().configManager != null)
                Client.getInstance().configManager.saveConfig("default");
        } catch (Exception ignored) {}
        if (Arrays.stream(noDebugModules).noneMatch(moduleName::equals)
                && !moduleCategory.equals(ModuleCategory.Themes)) {
            // 1.21.4: TextFormatting → ChatFormatting
            NotificationsModule.notify("Module Debug",
                    moduleName + " was " + ChatFormatting.GREEN + "enabled!",
                    NotificationType.SUCCESS, 4);
        }
        EventBus.register(this);
    }

    public void onDisable() {
        try {
            if (Client.getInstance().configManager != null)
                Client.getInstance().configManager.saveConfig("default");
        } catch (Exception ignored) {}
        if (Arrays.stream(noDebugModules).noneMatch(moduleName::equals)
                && !moduleCategory.equals(ModuleCategory.Themes)) {
            NotificationsModule.notify("Module Debug",
                    moduleName + " was " + ChatFormatting.RED + "disabled!",
                    NotificationType.SUCCESS, 4);
        }
        EventBus.unregister(this);
    }

    public JsonObject save() {
        JsonObject obj  = new JsonObject();
        obj.addProperty("state",    moduleState);
        obj.addProperty("keyIndex", moduleKey);
        JsonObject props = new JsonObject();
        for (Setting s : settingList) {
            if (s instanceof BooleanSetting b) props.addProperty(s.name, b.value);
            else if (s instanceof ModeSetting m) props.addProperty(s.name, m.get());
            else if (s instanceof NumberSetting n) props.addProperty(s.name, n.value);
            else if (s instanceof ColorSetting c) props.addProperty(s.name, c.color);
            else if (s instanceof TextSetting t) props.addProperty(s.name, t.get());
            obj.add("Settings", props);
        }
        return obj;
    }

    public void load(JsonObject object) {
        if (object == null) return;
        if (object.has("state"))    setState(object.get("state").getAsBoolean());
        if (object.has("keyIndex")) setBind(object.get("keyIndex").getAsInt());
        JsonObject props = object.getAsJsonObject("Settings");
        if (props == null) return;
        for (Setting s : settingList) {
            if (!props.has(s.name)) continue;
            if (s instanceof BooleanSetting b) b.setBoolValue(props.get(s.name).getAsBoolean());
            else if (s instanceof ModeSetting m) m.setListMode(props.get(s.name).getAsString());
            else if (s instanceof NumberSetting n) n.setValueNumber(props.get(s.name).getAsFloat());
            else if (s instanceof ColorSetting c) c.setColorValue(props.get(s.name).getAsInt());
            else if (s instanceof TextSetting t) t.setTextValue(props.get(s.name).getAsString());
        }
    }

    public boolean isModuleState()    { return moduleState; }
    public String  getModuleName()    { return moduleName; }
    public ModuleCategory getModuleCategory() { return moduleCategory; }
    public List<Setting>  getSetting(){ return settingList; }
    public int getBind()              { return moduleKey; }
    public void setBind(int bind)     { this.moduleKey = bind; }
    public String getSuffix()         { return suffix == null ? moduleName : suffix; }
    public void setSuffix(String s)   { this.suffix = moduleName + " " + s; }
}
