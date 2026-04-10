/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Client
 *  neo.deobf.ModuleCategory
 *  neo.deobf.ActionRecorderModule
 *  neo.deobf.AutoRegisterModule
 *  neo.deobf.ThemeModule
 *  neo.deobf.Module
 *  neo.deobf.AutoRejoinModule
 *  neo.deobf.BotBaritoneModule
 *  neo.deobf.BotDebugModule
 *  neo.deobf.BotSettingsModule
 *  neo.deobf.CaptchaManagerModule
 *  neo.deobf.WebSolverModule
 *  neo.deobf.ClickGuiModule
 *  neo.deobf.DiscordRPCModule
 *  neo.deobf.ExtraTabModule
 *  neo.deobf.GuiMoveModule
 *  neo.deobf.ItemPhysicsModule
 *  neo.deobf.ItemScrollerModule
 *  neo.deobf.NotificationsModule
 *  neo.deobf.BinocularModule
 *  neo.deobf.FreeCamModule
 *  neo.deobf.NoPushModule
 *  neo.deobf.SprintModule
 *  neo.deobf.TimerModule
 *  neo.deobf.CrosshairModule
 *  neo.deobf.HudModule
 *  neo.deobf.ItemAnimModule
 *  neo.deobf.NoRenderModule
 *  neo.deobf.TracersModule
 *  neo.deobf.WorldModule
 *  neo.deobf.Theme
 */
package neo.deobf;

import java.util.ArrayList;
import java.util.Iterator;
import neo.deobf.Client;
import neo.deobf.ModuleCategory;
import neo.deobf.ActionRecorderModule;
import neo.deobf.AutoRegisterModule;
import neo.deobf.ThemeModule;
import neo.deobf.Module;
import neo.deobf.AutoRejoinModule;
import neo.deobf.BotBaritoneModule;
import neo.deobf.BotDebugModule;
import neo.deobf.BotSettingsModule;
import neo.deobf.CaptchaManagerModule;
import neo.deobf.WebSolverModule;
import neo.deobf.ClickGuiModule;
import neo.deobf.DiscordRPCModule;
import neo.deobf.ExtraTabModule;
import neo.deobf.GuiMoveModule;
import neo.deobf.ItemPhysicsModule;
import neo.deobf.ItemScrollerModule;
import neo.deobf.NotificationsModule;
import neo.deobf.BinocularModule;
import neo.deobf.FreeCamModule;
import neo.deobf.NoPushModule;
import neo.deobf.SprintModule;
import neo.deobf.TimerModule;
import neo.deobf.CrosshairModule;
import neo.deobf.HudModule;
import neo.deobf.ItemAnimModule;
import neo.deobf.NoRenderModule;
import neo.deobf.TracersModule;
import neo.deobf.WorldModule;
import neo.deobf.Theme;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ModuleManager {
    public final ArrayList<Module> modules = new ArrayList();

    public ArrayList<Module> getModules() {
        return (this.modules);
    }

    public void register(Module module) {
        (this.modules).add(module);
    }

    public Module getModule(Class moduleClass) {
        Module module;
        Iterator var2 = (this.modules).iterator();
        do {
            if (var2.hasNext()) continue;
            return null;
        } while ((module = (Module)var2.next()).getClass() != moduleClass);
        return module;
    }

    private static ArrayList getModules(ModuleManager instance) {
        return instance.modules;
    }

    public ModuleManager() {
        this.register((Module)new NoRenderModule());
        this.register((Module)new WorldModule());
        this.register((Module)new ItemScrollerModule());
        this.register((Module)new TracersModule());
        this.register((Module)new TimerModule());
        this.register((Module)new SprintModule());
        this.register((Module)new ItemAnimModule());
        this.register((Module)new NoPushModule());
        this.register((Module)new FreeCamModule());
        this.register((Module)new ItemPhysicsModule());
        this.register((Module)new CrosshairModule());
        this.register((Module)new GuiMoveModule());
        this.register((Module)new ClickGuiModule());
        this.register((Module)new AutoRegisterModule());
        this.register((Module)new CaptchaManagerModule());
        this.register((Module)new BotSettingsModule());
        this.register((Module)new AutoRejoinModule());
        this.register((Module)new BotDebugModule());
        this.register((Module)new ExtraTabModule());
        this.register((Module)new NotificationsModule());
        this.register((Module)new DiscordRPCModule());
        this.register((Module)new ActionRecorderModule());
        this.register((Module)new BinocularModule());
        this.register((Module)new WebSolverModule());
        this.register((Module)new BotBaritoneModule());
        this.register((Module)new HudModule());
        for (Theme theme : Client.getInstance().themeManager.getThemes()) {
            this.register((Module)new ThemeModule(theme.getName(), theme.getOneColor(), theme.getTwoColor()));
        }
    }

    public ArrayList<Module> getModulesForCategory(ModuleCategory category) {
        ArrayList<Module> returned = new ArrayList<Module>();
        for (Module module : (this.modules)) {
            if (module.getModuleCategory() != category) continue;
            returned.add(module);
        }
        return returned;
    }
}

