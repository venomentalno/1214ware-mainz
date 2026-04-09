/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Structure
 */
package com.botclient;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class DiscordRichPresence
extends Structure {
    public String joinSecret;
    public String button_label_2;
    public String spectateSecret;
    public String largeImageText;
    public String matchSecret;
    public String state;
    public String smallImageText;
    public String partyId;
    public int partyMax;
    public long startTimestamp;
    public String button_label_1;
    public String button_url_2;
    public String partyPrivacy;
    public int instance;
    public String largeImageKey;
    public String button_url_1;
    public String smallImageKey;
    public int partySize;
    public long endTimestamp;
    public String details;
protected List<String> getFieldOrder() {
        String[] stringArray = new String[20];
        stringArray[0] = "state";
        stringArray[1] = "details";
        stringArray[2] = "startTimestamp";
        stringArray[3] = "endTimestamp";
        stringArray[4] = "largeImageKey";
        stringArray[5] = "largeImageText";
        stringArray[6] = "smallImageKey";
        stringArray[7] = "smallImageText";
        stringArray[8] = "partyId";
        stringArray[9] = "partySize";
        stringArray[10] = "partyMax";
        stringArray[11] = "partyPrivacy";
        stringArray[12] = "matchSecret";
        stringArray[13] = "joinSecret";
        stringArray[14] = "spectateSecret";
        stringArray[15] = "button_label_1";
        stringArray[16] = "button_url_1";
        stringArray[17] = "button_label_2";
        stringArray[18] = "button_url_2";
        stringArray[19] = "instance";
        return Arrays.asList(stringArray);
    }

    public DiscordRichPresence() {
        this.setStringEncoding("UTF-8");
    }
}



