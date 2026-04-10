/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.florianmichael.viamcp.ViaMCP
 *  neo.deobf.ProxySettingsScreen
 *  neo.deobf.SplashProgressRenderer
 *  neo.deobf.PBotManager
 *  neo.deobf.CommandManager
 *  neo.deobf.ModuleManager
 *  neo.deobf.ThemeManager
 *  neo.deobf.FileManager
 *  neo.deobf.ClickGuiScreen
 *  neo.deobf.Module
 *  neo.deobf.WebSolverModule
 *  neo.deobf.HudModule
 *  neo.deobf.ScriptManager
 *  neo.deobf.TranslationMapRu
 *  neo.deobf.SeleniumManager
 *  neo.deobf.ConfigManager
 *  neo.deobf.Theme
 *  neo.deobf.DiscordRpc
 *  neo.deobf.TickRateTracker
 */
package neo.deobf;

import de.florianmichael.viamcp.ViaMCP;
import java.io.IOException;
import java.io.PrintStream;
import neo.deobf.ProxySettingsScreen;
import neo.deobf.SplashProgressRenderer;
import neo.deobf.PBotManager;
import neo.deobf.CommandManager;
import neo.deobf.ModuleManager;
import neo.deobf.ThemeManager;
import neo.deobf.FileManager;
import neo.deobf.ClickGuiScreen;
import neo.deobf.Module;
import neo.deobf.WebSolverModule;
import neo.deobf.HudModule;
import neo.deobf.ScriptManager;
import neo.deobf.TranslationMapRu;
import neo.deobf.SeleniumManager;
import neo.deobf.ConfigManager;
import neo.deobf.Theme;
import neo.deobf.DiscordRpc;
import neo.deobf.TickRateTracker;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Client {
    public PBotManager botManager;
    public CommandManager commandManager;
    public ThemeManager themeManager;
    public static String VERSION_TYPE = "2.1.2";
    public SeleniumManager seleniumManager;
    public ConfigManager configManager;
    public FileManager fileManager;
    public ScriptManager pBotsScriptManager;
    public static Client instance;
    public ModuleManager moduleManager;

    public void startClient() {
        long mls = System.currentTimeMillis();
        instance = this;
        DiscordRpc.init();
        TickRateTracker.init();
        TranslationMapRu.register();
        ProxySettingsScreen.loadConfig();
        this.commandManager = new CommandManager();
        SplashProgressRenderer.setProgress((int)(2));
        this.themeManager = new ThemeManager();
        this.moduleManager = new ModuleManager();
        this.configManager = new ConfigManager();
        (this.moduleManager).getModule(WebSolverModule.class).setState(false);
        (this.moduleManager).getModule(HudModule.class).setState(true);
        this.fileManager = new FileManager();
        SplashProgressRenderer.setProgress((int)(3));
        this.pBotsScriptManager = new ScriptManager();
        this.seleniumManager = new SeleniumManager();
        (this.seleniumManager).init();
        SplashProgressRenderer.setProgress((int)(4));
        try {
            (this.fileManager).init();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        ViaMCP.create();
        (ViaMCP.INSTANCE).initAsyncSlider();
        SplashProgressRenderer.setProgress((int)(5));
        this.botManager = new PBotManager();
        if ((ClickGuiScreen.currentTheme) == null) {
            ClickGuiScreen.currentTheme = Client.getThemeManager(Client.getInstance()).getDefaultTheme();
        }
        (System.out).println("NeoWare Instance started! - " + (System.currentTimeMillis() - mls) + "ms");
    }

    public static Client getInstance() {
        return (instance);
    }

    private static ThemeManager getThemeManager(Client instance) {
        return instance.themeManager;
    }

    public void keyPress(int key) {
        for (Module module : (this.moduleManager).getModules()) {
            if ((module.moduleKey) != key) continue;
            module.toggle();
        }
    }

}

