/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  neo.deobf.Client
 *  neo.deobf.ModuleManager
 *  neo.deobf.ThemeManager
 *  neo.deobf.ModuleCategory
 *  neo.deobf.ClickGuiScreen
 *  neo.deobf.Module
 *  neo.deobf.Theme
 */
package neo.deobf;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import neo.deobf.Client;
import neo.deobf.ModuleManager;
import neo.deobf.ThemeManager;
import neo.deobf.ModuleCategory;
import neo.deobf.ClickGuiScreen;
import neo.deobf.Module;
import neo.deobf.Theme;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ConfigSerializer {

private static ThemeManager getThemeManager(Client instance) {
        return instance.themeManager;
    }

    public static JsonObject save() {
        JsonObject jsonObject = new JsonObject();
        JsonObject modulesObject = new JsonObject();
        for (Module module : (Client.getInstance().moduleManager).getModules()) {
            if (module.getModuleCategory().equals((Object)(ModuleCategory.Themes))) continue;
            modulesObject.add(module.getModuleName(), (JsonElement)module.save());
        }
        jsonObject.add("Features", (JsonElement)modulesObject);
        jsonObject.addProperty("Version", (Client.VERSION_TYPE));
        jsonObject.addProperty("Theme", (ClickGuiScreen.currentTheme) != null ? (ClickGuiScreen.currentTheme).getName() : (Client.getInstance().themeManager).getDefaultTheme().getName());
        return jsonObject;
    }

    public static void load(JsonObject object) {
        block8: {
            try {
                if (object.get("Version") != null) {
                    if (!object.get("Version").getAsString().equals((Client.VERSION_TYPE))) {
                        return;
                    }
                    break block8;
                }
                return;
            }
            catch (Exception exception) {
                return;
            }
        }
        try {
            ClickGuiScreen.currentTheme = ConfigSerializer.getThemeManager(Client.getInstance()).getThemeByName(object.get("Theme").getAsString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (object.has("Features")) {
            JsonObject modulesObject = object.getAsJsonObject("Features");
            for (Module module : (Client.getInstance().moduleManager).getModules()) {
                module.setState(false);
                module.load(modulesObject.getAsJsonObject(module.getModuleName()));
            }
        }
    }

}

