/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  neo.deobf.TextSetting
 *  neo.deobf.Setting
 *  neo.deobf.Client
 *  neo.deobf.ModuleCategory
 *  neo.deobf.BooleanSetting
 *  neo.deobf.ColorSetting
 *  neo.deobf.ModeSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.NotificationType
 *  neo.deobf.NotificationsModule
 *  neo.deobf.ConfigManager
 *  neo.deobf.EventBus
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.Formatting
 */
package com.botclient;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.botclient.TextSetting;
import com.botclient.Setting;
import com.botclient.Client;
import com.botclient.ModuleCategory;
import com.botclient.BooleanSetting;
import com.botclient.ColorSetting;
import com.botclient.ModeSetting;
import com.botclient.NumberSetting;
import com.botclient.NotificationType;
import com.botclient.NotificationsModule;
import com.botclient.ConfigManager;
import com.botclient.EventBus;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Module {
    public static final String[] noDebugModules;
    public String suffix;
    public final ModuleCategory moduleCategory;
    public final String moduleName;
    public static MinecraftClient mc;
    public boolean moduleState;
    public int moduleKey;
    public boolean opened = 1;
    public List<Setting> settingList = new ArrayList<Setting>();

    public boolean isModuleState() {
        return (this.moduleState);
    }

    private static String getModuleName(Module instance) {
        return instance.moduleName;
    }

    static {
        mc = MinecraftClient.getInstance();
        String[] stringArray = new String[6];
        stringArray[0] = "ClickGui";
        stringArray[1] = "DiscordRPC";
        stringArray[2] = "BotBaritoneSettings";
        stringArray[3] = "Bot Debug";
        stringArray[4] = "BotSettings";
        stringArray[5] = "Captcha Manager";
        noDebugModules = stringArray;
    }

    private static void setSuffix(Module instance, String string) {
        instance.suffix = string;
    }

    public void setBind(int bind) {
        this.moduleKey = bind;
    }

    public String getModuleName() {
        return (this.moduleName);
    }

    private static ModuleCategory getModuleCategory(Module instance) {
        return instance.moduleCategory;
    }

    private static String getModuleName2(Module instance) {
        return instance.moduleName;
    }

    public String getSuffix() {
        return (this.suffix) == null ? (this.moduleName) : (this.suffix);
    }

    public void addSetting(Setting ... setting) {
        (this.settingList).addAll(Arrays.asList(setting));
    }

    public void toggle() {
        this.moduleState = (!Module.getModuleState3(this) ? 1 : 0) != 0;
        if ((this.moduleState)) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }
public void load(JsonObject object) {
        if (object != null) {
            if (object.has("state")) {
                this.setState(object.get("state").getAsBoolean());
            }
            if (object.has("keyIndex")) {
                this.setBind(object.get("keyIndex").getAsInt());
            }
            for (Setting set : this.getSetting()) {
                JsonObject propertiesObject = object.getAsJsonObject("Settings");
                if (set == null || propertiesObject == null || !propertiesObject.has((set.name))) continue;
                if (set instanceof BooleanSetting) {
                    ((BooleanSetting)set).setBoolValue(propertiesObject.get((set.name)).getAsBoolean());
                    continue;
                }
                if (set instanceof ModeSetting) {
                    ((ModeSetting)set).setListMode(propertiesObject.get((set.name)).getAsString());
                    continue;
                }
                if (set instanceof NumberSetting) {
                    ((NumberSetting)set).setValueNumber(propertiesObject.get((set.name)).getAsFloat());
                    continue;
                }
                if (set instanceof ColorSetting) {
                    ((ColorSetting)set).setColorValue(propertiesObject.get((set.name)).getAsInt());
                    continue;
                }
                if (!(set instanceof TextSetting)) continue;
                ((TextSetting)set).setTextValue(propertiesObject.get((set.name)).getAsString());
            }
        }
    }

    public int getBind() {
        return (this.moduleKey);
    }

    private static String getSuffix(Module instance) {
        return instance.suffix;
    }

    public List<Setting> getSetting() {
        return (this.settingList);
    }

    public void onDisable() {
        try {
            if ((Client.getInstance().configManager) != null) {
                (Client.getInstance().configManager).saveConfig("default");
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (Arrays.stream((noDebugModules)).noneMatch((this.moduleName)::equals) && !(this.moduleCategory).equals((Object)(ModuleCategory.Themes))) {
            NotificationsModule.notify((String)"Module Debug", (String)((this.moduleName) + " was " + (Formatting.RED) + "disabled!"), (NotificationType)(NotificationType.SUCCESS), (int)(4));
        }
        EventBus.unregister((Object)this);
    }

    public JsonObject save() {
        JsonObject object = new JsonObject();
        object.addProperty("state", Boolean.valueOf(this.isModuleState()));
        object.addProperty("keyIndex", (Number)this.getBind());
        JsonObject propertiesObject = new JsonObject();
        for (Setting set : this.getSetting()) {
            if (this.getSetting() != null) {
                if (set instanceof BooleanSetting) {
                    propertiesObject.addProperty((set.name), Boolean.valueOf(((BooleanSetting)set.value)));
                } else if (set instanceof ModeSetting) {
                    propertiesObject.addProperty((set.name), ((ModeSetting)set).get());
                } else if (set instanceof NumberSetting) {
                    propertiesObject.addProperty((set.name), (Number)Float.valueOf(((NumberSetting)set.value)));
                } else if (set instanceof ColorSetting) {
                    propertiesObject.addProperty((set.name), (Number)((ColorSetting)set.color));
                } else if (set instanceof TextSetting) {
                    propertiesObject.addProperty((set.name), ((TextSetting)set).get());
                }
            }
            object.add("Settings", (JsonElement)propertiesObject);
        }
        return object;
    }

    public void setState(boolean moduleState) {
        if (moduleState) {
            EventBus.register((Object)this);
        } else {
            EventBus.unregister((Object)this);
        }
        this.moduleState = moduleState;
    }

    public Module(String name, ModuleCategory category) {
        this.moduleCategory = category;
        this.moduleName = name;
        this.moduleKey = 0;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
        this.suffix = Module.getModuleName2(this) + " " + suffix;
    }

    public void onEnable() {
        try {
            if ((Client.getInstance().configManager) != null) {
                (Client.getInstance().configManager).saveConfig("default");
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (Arrays.stream((noDebugModules)).noneMatch((this.moduleName)::equals) && !(this.moduleCategory).equals((Object)(ModuleCategory.Themes))) {
            NotificationsModule.notify((String)"Module Debug", (String)((this.moduleName) + " was " + (Formatting.GREEN) + "enabled!"), (NotificationType)(NotificationType.SUCCESS), (int)(4));
        }
        EventBus.register((Object)this);
    }

    public ModuleCategory getModuleCategory() {
        return (this.moduleCategory);
    }

    private static boolean getModuleState3(Module instance) {
        return instance.moduleState;
    }
}

