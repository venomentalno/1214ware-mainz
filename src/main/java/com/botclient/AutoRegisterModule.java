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
 *  neo.deobf.Module
 */
package com.botclient;

import com.botclient.TextSetting;
import com.botclient.Setting;
import com.botclient.ModuleCategory;
import com.botclient.BooleanSetting;
import com.botclient.InfoSetting;
import com.botclient.ModeSetting;
import com.botclient.Module;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AutoRegisterModule
extends Module {
    public static TextSetting customPassword;
    public static TextSetting authCommand;
    private static final InfoSetting register_info;
    public static BooleanSetting needLogin;
    public static ModeSetting passwordGenerator;
    public static TextSetting registerCommand;

    public AutoRegisterModule() {
        super("Auto Register", ModuleCategory.Bots);
        Setting[] settings = new Setting[6];
        settings[0] = registerCommand;
        settings[1] = register_info;
        settings[2] = needLogin;
        settings[3] = authCommand;
        settings[4] = passwordGenerator;
        settings[5] = customPassword;
        this.addSetting(settings);
    }

    static {
        registerCommand = new TextSetting("RegCommand", "/register %pass %pass");
        String[] stringArray = new String[1];
        stringArray[0] = "%pass заменяется на пароль";
        register_info = new InfoSetting(stringArray);
        needLogin = new BooleanSetting("NeedLogin", false);
        authCommand = new TextSetting("AuthCommand", "/login %pass", () -> ((needLogin).value));
        String[] stringArray2 = new String[2];
        stringArray2[0] = "custom";
        stringArray2[1] = "nickToPass";
        passwordGenerator = new ModeSetting("Password", "random", stringArray2);
        customPassword = new TextSetting("CustomPass", "qwerty213", () -> (passwordGenerator).is("custom"));
    }
}

