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
 */
package com.botclient;

import com.botclient.TextSetting;
import com.botclient.Setting;
import com.botclient.ModuleCategory;
import com.botclient.BooleanSetting;
import com.botclient.InfoSetting;
import com.botclient.ModeSetting;
import com.botclient.NumberSetting;
import com.botclient.Module;

public class BotSettingsModule
extends Module {
    public static BooleanSetting RPskip;
    public static BooleanSetting pingServer;
    public static TextSetting customname;
    public static BooleanSetting botsTabPrefix;
    private static final InfoSetting gameguard_info;
    private static final InfoSetting joinfixer_info;
    public static ModeSetting nickstype;
    private static final InfoSetting cacheAfter_info;
    public static NumberSetting cacheAfter;
    private static final InfoSetting useProxy_info;
    public static NumberSetting botsPerProxy;
    public static BooleanSetting gameguard;
    public static BooleanSetting removebadproxy;
    public static ModeSetting antibot;
    public static BooleanSetting useProxy;
    public static BooleanSetting webSkipper;
    public static ModeSetting gameguardBlock;
    private static final InfoSetting customname_info;
    private static final InfoSetting pingServer_info;
    public static BooleanSetting joinFixer;
    private static final InfoSetting botsPerProxy_info;
    public static NumberSetting joinFixerDelay;

    public void onEnable() {
        super.onEnable();
        this.toggle();
    }

    public BotSettingsModule() {
        super("BotSettings", ModuleCategory.Bots);
        Setting[] settings = new Setting[22];
        settings[0] = nickstype;
        settings[1] = customname;
        settings[2] = customname_info;
        settings[3] = antibot;
        settings[4] = gameguard;
        settings[5] = gameguardBlock;
        settings[6] = gameguard_info;
        settings[7] = removebadproxy;
        settings[8] = webSkipper;
        settings[9] = joinFixer;
        settings[10] = joinFixerDelay;
        settings[11] = joinfixer_info;
        settings[12] = RPskip;
        settings[13] = botsTabPrefix;
        settings[14] = useProxy;
        settings[15] = useProxy_info;
        settings[16] = pingServer;
        settings[17] = pingServer_info;
        settings[18] = cacheAfter;
        settings[19] = cacheAfter_info;
        settings[20] = botsPerProxy;
        settings[21] = botsPerProxy_info;
        this.addSetting(settings);
    }

    static {
        String[] stringArray = new String[3];
        stringArray[0] = "Random";
        stringArray[1] = "Custom";
        stringArray[2] = "FromFile";
        nickstype = new ModeSetting("Nick", "NeoWare", stringArray);
        String[] stringArray2 = new String[6];
        stringArray2[0] = "WellMore";
        stringArray2[1] = "MultyBypass";
        stringArray2[2] = "KeyboardClick";
        stringArray2[3] = "MathClick";
        stringArray2[4] = "AnvilRename";
        stringArray2[5] = "TabCaptcha";
        antibot = new ModeSetting("Bypass", "None", stringArray2);
        gameguard = new BooleanSetting("GameGuard Bypass", false);
        String[] stringArray3 = new String[14];
        stringArray3[0] = "orange";
        stringArray3[1] = "magenta";
        stringArray3[2] = "yellow";
        stringArray3[3] = "white";
        stringArray3[4] = "pink";
        stringArray3[5] = "gray";
        stringArray3[6] = "silver";
        stringArray3[7] = "cyan";
        stringArray3[8] = "purple";
        stringArray3[9] = "blue";
        stringArray3[10] = "brown";
        stringArray3[11] = "green";
        stringArray3[12] = "red";
        stringArray3[13] = "black";
        gameguardBlock = new ModeSetting("Block", "lime", () -> ((gameguard).value), stringArray3);
        String[] stringArray4 = new String[1];
        stringArray4[0] = "GameGuard - зеленые кнопки и т.д";
        gameguard_info = new InfoSetting(stringArray4);
        customname = new TextSetting("Custom nick", "Player_%n", () -> (nickstype).is("Custom"));
        String[] stringArray5 = new String[6];
        stringArray5[0] = "Плейсхолдеры: ";
        stringArray5[1] = "%n - Рандомные 6 цифр";
        stringArray5[2] = "%s - Рандомные 6 букв";
        stringArray5[3] = "%players - Рандомный ник из таба";
        stringArray5[4] = "%swear - Рандомная провокация";
        stringArray5[5] = "и т.д.";
        customname_info = new InfoSetting(stringArray5);
        removebadproxy = new BooleanSetting("Remove Bad Proxy", false);
        webSkipper = new BooleanSetting("Web Skipper", false);
        joinFixer = new BooleanSetting("Join Fixer", false);
        joinFixerDelay = new NumberSetting("Delay", 200.0f, 10.0f, 1000.0f, 10.0f, () -> ((joinFixer).value));
        String[] stringArray6 = new String[4];
        stringArray6[0] = "Меняет прокси бота при таймауте";
        stringArray6[1] = "подключения к серверу";
        stringArray6[2] = "Delay - Задержка смены прокси";
        stringArray6[3] = "и перезахода на сервер";
        joinfixer_info = new InfoSetting(stringArray6);
        RPskip = new BooleanSetting("ResourcePack skip", true);
        botsTabPrefix = new BooleanSetting("Bots TAB prefix", true);
        useProxy = new BooleanSetting("Use Proxy", true);
        String[] stringArray7 = new String[6];
        stringArray7[0] = "Настройка использования прокси";
        stringArray7[1] = "? ?????. ???? ????????? - ????";
        stringArray7[2] = "????? ???????? ??? ??????, ??";
        stringArray7[3] = "если забанят одного по IP, кикнет";
        stringArray7[4] = "всех в том числе и вас!";
        stringArray7[5] = "Не рекомендуется использовать!";
        useProxy_info = new InfoSetting(stringArray7);
        pingServer = new BooleanSetting("Ping Server", false);
        String[] stringArray8 = new String[4];
        stringArray8[0] = "При включении бот будет пинговать";
        stringArray8[1] = "сервер перед заходом. При этом";
        stringArray8[2] = "оно добавит пару секунд перед";
        stringArray8[3] = "заходом бота на сервер!";
        pingServer_info = new InfoSetting(stringArray8);
        cacheAfter = new NumberSetting("Cache world after", 1.0f, 0.0f, 10.0f, 1.0f);
        String[] stringArray9 = new String[7];
        stringArray9[0] = "Установка номера мира, после";
        stringArray9[1] = "которого чанки начинают";
        stringArray9[2] = "кэшироваться у бота.";
        stringArray9[3] = "0 - Кэшировать всегда";
        stringArray9[4] = "1 - Кэшировать после антибота";
        stringArray9[5] = "остальные значения мало где";
        stringArray9[6] = "требуются";
        cacheAfter_info = new InfoSetting(stringArray9);
        botsPerProxy = new NumberSetting("Bots per 1 proxy", 1.0f, 1.0f, 50.0f, 1.0f);
        String[] stringArray10 = new String[2];
        stringArray10[0] = "Установка количества ботов";
        stringArray10[1] = "на заход с 1 прокси";
        botsPerProxy_info = new InfoSetting(stringArray10);
    }

}

