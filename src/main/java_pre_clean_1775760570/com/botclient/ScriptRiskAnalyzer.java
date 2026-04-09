/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.ScriptRiskLevel
 */
package com.botclient;

import com.botclient.ScriptRiskLevel;

public class ScriptRiskAnalyzer {
    public static final String[] warns;

    private static boolean a(String s) {
        String[] stringArray = (warns);
        int n = stringArray.length;
        for (int i = 0; i < n; ++i) {
            String b = stringArray[i];
            if (!s.contains(b.toLowerCase())) continue;
            return true;
        }
        return false;
    }

    public static ScriptRiskLevel check(String script) {
        String s = script.toLowerCase();
        if (ScriptRiskAnalyzer.a(s)) {
            return (ScriptRiskLevel.WARNING);
        }
        return (ScriptRiskLevel.NORMAL);
    }

    static {
        String[] stringArray = new String[27];
        stringArray[0] = "(function(_0x";
        stringArray[1] = "(!![]";
        stringArray[2] = "var _0x";
        stringArray[3] = "if (_0x";
        stringArray[4] = "_0x";
        stringArray[5] = ": function() {};";
        stringArray[6] = "![]";
        stringArray[7] = "waitFor";
        stringArray[8] = "[_0x";
        stringArray[9] = "urn new java";
        stringArray[10] = "++])";
        stringArray[11] = "== _0x";
        stringArray[12] = "('0x";
        stringArray[13] = "return _0x";
        stringArray[14] = "runtime";
        stringArray[15] = "drop";
        stringArray[16] = ".jar";
        stringArray[17] = ".exe";
        stringArray[18] = "==',";
        stringArray[19] = "FileUtils";
        stringArray[20] = ";(functio";
        stringArray[21] = "getRuntime";
        stringArray[22] = "windows";
        stringArray[23] = "linux";
        stringArray[24] = "macos";
        stringArray[25] = "new File";
        stringArray[26] = "ProcessBuilder";
        warns = stringArray;
    }

}

