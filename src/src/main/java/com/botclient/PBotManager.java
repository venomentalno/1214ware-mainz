package neo.deobf;

public class PBotManager {
    public static PBotManager instance;
    public final ProxyManager   proxyManager;
    public final NickManager    nickManager;
    public final CaptchaManager captchaManager;

    public PBotManager() {
        instance        = this;
        proxyManager    = new ProxyManager();
        nickManager     = new NickManager();
        captchaManager  = new CaptchaManager();
        BotTickExecutor.create();
    }

    public static PBotManager getInstance()        { return instance;       }
    public ProxyManager   getProxyManager()        { return proxyManager;   }
    public NickManager    getNickManager()         { return nickManager;    }
    public CaptchaManager getCaptchaManager()      { return captchaManager; }
}
