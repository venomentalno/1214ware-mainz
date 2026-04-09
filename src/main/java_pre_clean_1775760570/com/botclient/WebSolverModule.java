/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.TextSetting
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.BooleanSetting
 *  neo.deobf.InfoSetting
 *  neo.deobf.ModeSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.Module
 *  neo.deobf.ChatUtils
 */
package com.botclient;

import java.io.File;
import com.botclient.TextSetting;
import com.botclient.Setting;
import com.botclient.ModuleCategory;
import com.botclient.BooleanSetting;
import com.botclient.InfoSetting;
import com.botclient.ModeSetting;
import com.botclient.NumberSetting;
import com.botclient.Module;
import com.botclient.ChatUtils;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class WebSolverModule
extends Module {
    public static NumberSetting openDelay;
    private static final InfoSetting solverType_info;
    public static TextSetting webApi;
    private static final InfoSetting openDelay_info;
    public static TextSetting chromePath;
    private static final InfoSetting useProxy_info;
    public static ModeSetting solverType;
    public static BooleanSetting useProxy;
public WebSolverModule() {
        super("WebSolver", ModuleCategory.Bots);
        Setting[] settings = new Setting[8];
        settings[0] = solverType;
        settings[1] = solverType_info;
        settings[2] = webApi;
        settings[3] = chromePath;
        settings[4] = useProxy;
        settings[5] = useProxy_info;
        settings[6] = openDelay;
        settings[7] = openDelay_info;
        this.addSetting(settings);
    }

    public void onDisable() {
        super.onDisable();
    }

    public void onEnable() {
        if ((solverType).is("Chrome") && !new File((chromePath).get()).exists()) {
            this.setState(false);
            ChatUtils.formatMsg((String)"&cПуть до браузера указан неверно, либо он не существует!");
            return;
        }
        super.onEnable();
    }

    static {
        String[] stringArray = new String[1];
        stringArray[0] = "WebAPI";
        solverType = new ModeSetting("Mode", "Chrome", stringArray);
        String[] stringArray2 = new String[5];
        stringArray2[0] = "WebAPI - Работа GET запросами";
        stringArray2[1] = "для внешних ваших программ";
        stringArray2[2] = "с.м. NeoWareWiki";
        stringArray2[3] = "Chrome - Будет открывать капчу";
        stringArray2[4] = "используя браузер Chrome на пк";
        solverType_info = new InfoSetting(stringArray2);
        webApi = new TextSetting("WebAPI host", "http://127.0.0.1:8080", () -> (solverType).is("WebAPI"));
        chromePath = new TextSetting("Chrome Path", "C:/Program Files/Google/Chrome/Application/chrome.exe", () -> (solverType).is("Chrome"));
        useProxy = new BooleanSetting("Use proxy", true);
        String[] stringArray3 = new String[3];
        stringArray3[0] = "Параметр показывает, будут ли";
        stringArray3[1] = "использоваться прокси от бота";
        stringArray3[2] = "для открытия страницы";
        useProxy_info = new InfoSetting(stringArray3);
        openDelay = new NumberSetting("Open delay", 1000.0f, 100.0f, 8000.0f, 10.0f);
        String[] stringArray4 = new String[3];
        stringArray4[0] = "Установка задержки на открытие";
        stringArray4[1] = "страниц. Не даст открыть все сразу";
        stringArray4[2] = "если зайдет много ботов";
        openDelay_info = new InfoSetting(stringArray4);
    }

}

