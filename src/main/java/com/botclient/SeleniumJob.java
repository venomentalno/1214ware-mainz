/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.ProxyInfo
 */
package com.botclient;

import com.botclient.ProxyInfo;

public class SeleniumJob {
    public String botName;
    public String url;
    public ProxyInfo proxy;

    public void setProxy(ProxyInfo proxy) {
        this.proxy = proxy;
    }

    public String getUrl() {
        return (this.url);
    }

    private static void setUrl(SeleniumJob dF, String string) {
        dF.url = string;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public ProxyInfo getProxy() {
        return (this.proxy);
    }

    public SeleniumJob(String url, ProxyInfo proxy, String botName) {
        this.url = url;
        this.proxy = proxy;
        this.botName = botName;
    }

    private static ProxyInfo getProxy(SeleniumJob instance) {
        return instance.proxy;
    }

    private static String getUrl(SeleniumJob instance) {
        return instance.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private static void setProxy(SeleniumJob dF, ProxyInfo eq) {
        dF.proxy = eq;
    }

    public String getBotName() {
        return (this.botName);
    }

    private static void setBotName(SeleniumJob dF, String string) {
        dF.botName = string;
    }

    private static String getBotName(SeleniumJob instance) {
        return instance.botName;
    }
}

