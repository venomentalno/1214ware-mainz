/*
 * Decompiled with CFR 0.152.
 */
package com.botclient;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    public static String findStringByRegex(String text, Pattern regex) {
        Matcher match = regex.matcher(text);
        if (match.find()) {
            return text.substring(match.start(), match.end());
        }
        return null;
    }

    public static List<String> findStringsByRegex(String text, Pattern regex) {
        ArrayList<String> strings = new ArrayList<String>();
        Matcher match = regex.matcher(text);
        while (match.find()) {
            strings.add(text.substring(match.start(), match.end()));
        }
        return strings;
    }
}





