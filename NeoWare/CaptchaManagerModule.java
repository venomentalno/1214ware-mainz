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
package neo.deobf;

import neo.deobf.TextSetting;
import neo.deobf.Setting;
import neo.deobf.ModuleCategory;
import neo.deobf.BooleanSetting;
import neo.deobf.InfoSetting;
import neo.deobf.ModeSetting;
import neo.deobf.NumberSetting;
import neo.deobf.Module;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class CaptchaManagerModule
extends Module {
    private static final InfoSetting saveCaptcha_info;
    public static TextSetting customSite;
    public static NumberSetting locationY;
    public static BooleanSetting nullcordRandom;
    private static final InfoSetting require_info;
    private static final InfoSetting customSite_info;
    public static BooleanSetting saveCaptcha;
    private static final InfoSetting nullcordRandom_info;
    private static final InfoSetting vernet_info;
    public static NumberSetting gifFrames;
    public static TextSetting vernet;
    public static TextSetting apikey;
    private static final InfoSetting solver_info;
    public static ModeSetting require;
    private static final InfoSetting apikey_info;
    private static final InfoSetting gifCaptchaFix_info;
    public static NumberSetting clickDelay;
    private static final InfoSetting manualHelper_info;
    public static BooleanSetting gifCaptchaFix;
    public static BooleanSetting manualHelper;
    public static NumberSetting locationX;
    public static ModeSetting solver;

    public CaptchaManagerModule() {
        super("Captcha Manager", ModuleCategory.Bots);
        Setting[] settings = new Setting[22];
        settings[0] = solver;
        settings[1] = locationX;
        settings[2] = locationY;
        settings[3] = solver_info;
        settings[4] = apikey;
        settings[5] = apikey_info;
        settings[6] = nullcordRandom;
        settings[7] = nullcordRandom_info;
        settings[8] = clickDelay;
        settings[9] = customSite;
        settings[10] = customSite_info;
        settings[11] = vernet;
        settings[12] = vernet_info;
        settings[13] = require;
        settings[14] = require_info;
        settings[15] = manualHelper;
        settings[16] = manualHelper_info;
        settings[17] = gifCaptchaFix;
        settings[18] = gifFrames;
        settings[19] = gifCaptchaFix_info;
        settings[20] = saveCaptcha;
        settings[21] = saveCaptcha_info;
        this.addSetting(settings);
    }

    public void onEnable() {
        super.onEnable();
        this.toggle();
    }
static {
        String[] stringArray = new String[8];
        stringArray[0] = "RuCaptcha";
        stringArray[1] = "CapGuru";
        stringArray[2] = "SimpleOCR";
        stringArray[3] = "CustomAPI";
        stringArray[4] = "NeoAPI";
        stringArray[5] = "NullCordClicks";
        stringArray[6] = "ManualMap";
        stringArray[7] = "None";
        solver = new ModeSetting("Solver", "ManualMap", stringArray);
        locationX = new NumberSetting("Location X", 120.0f, 0.0f, 1200.0f, 2.0f, () -> (solver).is("ManualMap"));
        locationY = new NumberSetting("Location Y", 120.0f, 0.0f, 1200.0f, 2.0f, () -> (solver).is("ManualMap"));
        String[] stringArray2 = new String[14];
        stringArray2[0] = "Виды решения: ";
        stringArray2[1] = " ManualMap - ввод капчи вручную";
        stringArray2[2] = " RuCaptcha, CapGuru - платное";
        stringArray2[3] = "решение капчи.";
        stringArray2[4] = " SimpleOCR - решает простые капчи";
        stringArray2[5] = "содержащие буквы и цифры";
        stringArray2[6] = " CustomAPI - решение через другой";
        stringArray2[7] = "сайт. Сайт должен содержать";
        stringArray2[8] = "эмулятор CapGuru/RuCaptcha";
        stringArray2[9] = " NeoAPI - решение капчи";
        stringArray2[10] = "через ChatGPT";
        stringArray2[11] = " NullCordClicks - Автоповорот";
        stringArray2[12] = "фреймов, либо выбор изображений";
        stringArray2[13] = "по условию (Pick/Rotate)";
        solver_info = new InfoSetting(stringArray2);
        apikey = new TextSetting("API Key", "qwerty123", () -> ((solver).is("RuCaptcha") || (solver).is("CapGuru") || (solver).is("CustomAPI") ? 1 : 0) != 0);
        String[] stringArray3 = new String[2];
        stringArray3[0] = "Ключ для платных сервисов";
        stringArray3[1] = "CaptchaGuru/RuCaptcha Рё CustomAPI";
        apikey_info = new InfoSetting(() -> ((solver).is("CapGuru") || (solver).is("RuCaptcha") || (solver).is("CustomAPI") ? 1 : 0) != 0, stringArray3);
        nullcordRandom = new BooleanSetting("Send Random msg", false, () -> (solver).is("NullCordClicks"));
        String[] stringArray4 = new String[3];
        stringArray4[0] = "Отправлять ли рандомный текст";
        stringArray4[1] = "после прохождения капчи от";
        stringArray4[2] = "NullcordX";
        nullcordRandom_info = new InfoSetting(() -> (solver).is("NullCordClicks"), stringArray4);
        clickDelay = new NumberSetting("Click frame delay", 300.0f, 60.0f, 2000.0f, 10.0f, () -> (solver).is("NullCordClicks"));
        customSite = new TextSetting("API Host", "http://127.0.0.1", () -> (solver).is("CustomAPI"));
        String[] stringArray5 = new String[3];
        stringArray5[0] = "Адрес сайта для решения";
        stringArray5[1] = "Сайт должен содержать эмулятор";
        stringArray5[2] = "CapGuru/RuCaptcha";
        customSite_info = new InfoSetting(() -> (solver).is("CustomAPI"), stringArray5);
        vernet = new TextSetting("Vernet", "15", () -> ((solver).is("CapGuru") || (solver).is("CustomAPI") ? 1 : 0) != 0);
        String[] stringArray6 = new String[3];
        stringArray6[0] = "Указание типа капчи для решения";
        stringArray6[1] = "Нужное вам смотрите на сайте API";
        stringArray6[2] = "Стандартное значение = 14";
        vernet_info = new InfoSetting(() -> ((solver).is("CapGuru") || (solver).is("CustomAPI") ? 1 : 0) != 0, stringArray6);
        String[] stringArray7 = new String[3];
        stringArray7[0] = "0-9";
        stringArray7[1] = "A-Z";
        stringArray7[2] = "0-9, A-Z";
        require = new ModeSetting("Require", "Default", stringArray7);
        String[] stringArray8 = new String[5];
        stringArray8[0] = "Фильтр ответа для капчи: ";
        stringArray8[1] = " Default - Ответ без изменений";
        stringArray8[2] = " 0-9 - Ответ только из цифр";
        stringArray8[3] = " A-Z - Ответ только из букв";
        stringArray8[4] = " 0-9, A-Z - Ответ из букв и цифр";
        require_info = new InfoSetting(stringArray8);
        manualHelper = new BooleanSetting("ManualHelper", true);
        String[] stringArray9 = new String[2];
        stringArray9[0] = "Авто-решение повторяющихся капч";
        stringArray9[1] = "???????????? ? ManualMap";
        manualHelper_info = new InfoSetting(stringArray9);
        gifCaptchaFix = new BooleanSetting("Gif Captcha Fix", false);
        gifFrames = new NumberSetting("Count Frames", 6.0f, 1.0f, 20.0f, 1.0f, () -> ((gifCaptchaFix).value));
        String[] stringArray10 = new String[6];
        stringArray10[0] = "Фиксит отображение GIF";
        stringArray10[1] = "капчи. Будет работать вместе с";
        stringArray10[2] = "ManualMap, NeoAPI и т.д.";
        stringArray10[3] = "Count Frames - кол-во изображений,";
        stringArray10[4] = "которые отвечают за рендер капчи";
        stringArray10[5] = "Больше - лучше, но дольше ждать";
        gifCaptchaFix_info = new InfoSetting(stringArray10);
        saveCaptcha = new BooleanSetting("Save Captcha", true);
        String[] stringArray11 = new String[2];
        stringArray11[0] = "Будет сохранять капчу";
        stringArray11[1] = "при её решении";
        saveCaptcha_info = new InfoSetting(stringArray11);
    }

}

