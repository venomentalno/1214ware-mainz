/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Client
 *  neo.deobf.BooleanSetting
 *  neo.deobf.BotDebugModule
 *  neo.deobf.BotRenderUtils
 *  neo.deobf.ChatUtils
 *  net.minecraft.client.Minecraft
 */
package com.botclient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import com.botclient.Client;
import com.botclient.BooleanSetting;
import com.botclient.BotDebugModule;
import com.botclient.BotRenderUtils;
import com.botclient.ChatUtils;
import net.minecraft.client.MinecraftClient;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ScriptManager {
    public boolean active;
    public ScriptEngineManager manager = new ScriptEngineManager();
    public ScriptEngine engine;

    private static void setActive(ScriptManager dB, boolean value) {
        dB.active = value;
    }

    public String invokeMethod0(String method, Object ... args) {
        block5: {
            if ((this.engine) == null || !(this.active)) {
                return "null";
            }
            try {
                Invocable invocable = (Invocable)((Object)(this.engine));
                if (ScriptManager.isFunctionDefined((this.engine), method)) {
                    Object result = invocable.invokeFunction(method, args);
                    return (String)result;
                }
            }
            catch (Exception e) {
                if (!(ScriptManager.getScriptErrors2().value)) break block5;
                ChatUtils.formatMsg((String)("PBotsScriptError: &c" + e));
                StackTraceElement[] stackTraceElementArray = e.getStackTrace();
                int n = stackTraceElementArray.length;
                for (int i = 0; i < n; ++i) {
                    StackTraceElement element = stackTraceElementArray[i];
                    ChatUtils.defaultMsg((String)("&c at &c" + element.toString()));
                }
                e.printStackTrace();
            }
        }
        return null;
    }

    private static ScriptEngineManager getManager(ScriptManager instance) {
        return instance.manager;
    }

    private static BooleanSetting getScriptErrors() {
        return BotDebugModule.scriptErrors;
    }

    private static boolean isFunctionDefined(ScriptEngine engine, String functionName) {
        try {
            engine.eval("var fn = " + functionName + ";");
            return true;
        }
        catch (ScriptException e) {
            return false;
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private static BooleanSetting getScriptErrors2() {
        return BotDebugModule.scriptErrors;
    }

    public boolean isActive() {
        return (this.active);
    }

    public void loadScript(String fileName) {
        block2: {
            try {
                this.engine = ScriptManager.getManager(this).getEngineByName("js");
                (this.engine).put("ScriptAPI", new BotRenderUtils());
                FileReader reader = new FileReader(new File((MinecraftClient.getInstance().gameDir), "/NeoWare/scripts/" + fileName + ".js"));
                (this.engine).eval(reader);
                (Client.getInstance().pBotsScriptManager).invokeMethod("onLoad", new Object[0]);
            }
            catch (FileNotFoundException | ScriptException e) {
                if (!(ScriptManager.getScriptErrors3().value)) break block2;
                e.printStackTrace();
                ChatUtils.formatMsg((String)("PBotsScriptError: " + e));
            }
        }
    }

    private static BooleanSetting getScriptErrors3() {
        return BotDebugModule.scriptErrors;
    }

    private static BooleanSetting getScriptErrors4() {
        return BotDebugModule.scriptErrors;
    }

    public void invokeMethod(String method, Object ... args) {
        block6: {
            if ((this.engine) == null || !(this.active)) {
                return;
            }
            if (!(Client.getInstance().pBotsScriptManager).isActive()) {
                return;
            }
            try {
                Invocable invocable = (Invocable)((Object)(this.engine));
                if (ScriptManager.isFunctionDefined((this.engine), method)) {
                    Object object = invocable.invokeFunction(method, args);
                }
            }
            catch (Exception e) {
                if (!(ScriptManager.getScriptErrors4().value)) break block6;
                ChatUtils.formatMsg((String)("PBotsScriptError: &c" + e));
                StackTraceElement[] stackTraceElementArray = e.getStackTrace();
                int n = stackTraceElementArray.length;
                for (int i = 0; i < n; ++i) {
                    StackTraceElement element = stackTraceElementArray[i];
                    ChatUtils.defaultMsg((String)("&c at &c" + element.toString()));
                }
                e.printStackTrace();
            }
        }
    }

    public boolean invokeCommand(String command, String[] args) {
        if ((this.engine) == null || !(this.active)) {
            return false;
        }
        try {
            Invocable invocable = (Invocable)((Object)(this.engine));
            if (ScriptManager.isFunctionDefined((this.engine), "onCommand_" + command.toLowerCase())) {
                Object[] objectArray = new Object[1];
                objectArray[0] = args;
                Object result = invocable.invokeFunction("onCommand_" + command.toLowerCase(), objectArray);
                return true;
            }
        }
        catch (Exception e) {
            if ((ScriptManager.getScriptErrors().value)) {
                ChatUtils.formatMsg((String)("PBotsScriptError: &c" + e));
                StackTraceElement[] stackTraceElementArray = e.getStackTrace();
                int n = stackTraceElementArray.length;
                for (int i = 0; i < n; ++i) {
                    StackTraceElement element = stackTraceElementArray[i];
                    ChatUtils.defaultMsg((String)("&c at &c" + element.toString()));
                }
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

}

