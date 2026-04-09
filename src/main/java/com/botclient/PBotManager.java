/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CaptchaManager
 *  neo.deobf.BotTickExecutor
 *  neo.deobf.NickManager
 *  neo.deobf.ProxyManager
 */
package com.botclient;

import com.botclient.CaptchaManager;
import com.botclient.BotTickExecutor;
import com.botclient.NickManager;
import com.botclient.ProxyManager;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PBotManager {
    public final CaptchaManager captchaManager;
    public static PBotManager instance;
    public final NickManager nickManager;
    public final ProxyManager proxyManager;

    public static PBotManager getInstance() {
        return (instance);
    }

    private static NickManager getNickManager(PBotManager instance) {
        return instance.nickManager;
    }

    public PBotManager() {
        instance = this;
        this.proxyManager = new ProxyManager();
        this.nickManager = new NickManager();
        this.captchaManager = new CaptchaManager();
        BotTickExecutor.create();
    }

    private static CaptchaManager getCaptchaManager(PBotManager instance) {
        return instance.captchaManager;
    }

    private static ProxyManager getProxyManager(PBotManager instance) {
        return instance.proxyManager;
    }

    public CaptchaManager getCaptchaManager() {
        return (this.captchaManager);
    }

    public ProxyManager getProxyManager() {
        return (this.proxyManager);
    }

    public NickManager getNickManager() {
        return (this.nickManager);
    }
}

