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
package com.botclient;

import java.util.ArrayList;
import java.util.Iterator;
import com.botclient.Client;
import com.botclient.ModuleCategory;
import com.botclient.ActionRecorderModule;
import com.botclient.AutoRegisterModule;
import com.botclient.ThemeModule;
import com.botclient.Module;
import com.botclient.AutoRejoinModule;
import com.botclient.BotBaritoneModule;
import com.botclient.BotDebugModule;
import com.botclient.BotSettingsModule;
import com.botclient.CaptchaManagerModule;
import com.botclient.WebSolverModule;
import com.botclient.ClickGuiModule;
import com.botclient.DiscordRPCModule;
import com.botclient.ExtraTabModule;
import com.botclient.GuiMoveModule;
import com.botclient.ItemPhysicsModule;
import com.botclient.ItemScrollerModule;
import com.botclient.NotificationsModule;
import com.botclient.BinocularModule;
import com.botclient.FreeCamModule;
import com.botclient.NoPushModule;
import com.botclient.SprintModule;
import com.botclient.TimerModule;
import com.botclient.CrosshairModule;
import com.botclient.HudModule;
import com.botclient.ItemAnimModule;
import com.botclient.NoRenderModule;
import com.botclient.TracersModule;
import com.botclient.WorldModule;
import com.botclient.Theme;

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

