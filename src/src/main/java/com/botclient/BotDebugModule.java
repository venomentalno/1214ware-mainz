package neo.deobf;

public class BotDebugModule extends Module {
    public static BooleanSetting connecting;
    public static BooleanSetting chat;
    public static BooleanSetting captcha;
    public static BooleanSetting internalErrors;
    public static BooleanSetting rejoin;
    public static BooleanSetting chunkCache;
    public static BooleanSetting baritoneDebug;
    public static BooleanSetting notifications;
    public static BooleanSetting mouseclicks;
    public static BooleanSetting scriptErrors;
    public static BooleanSetting disconnect;

    static {
        chat          = new BooleanSetting("Chat",            true);
        disconnect    = new BooleanSetting("Disconnect",      true);
        rejoin        = new BooleanSetting("Rejoin",          false);
        connecting    = new BooleanSetting("Connecting",      true);
        mouseclicks   = new BooleanSetting("MouseClicks",     true);
        notifications = new BooleanSetting("Notifications",   true);
        scriptErrors  = new BooleanSetting("ScriptErrors",    true);
        internalErrors= new BooleanSetting("InternalErrors",  false);
        chunkCache    = new BooleanSetting("Chunk Cache",     false);
        baritoneDebug = new BooleanSetting("Baritone Debug",  false);
        captcha       = new BooleanSetting("Captcha answers", true);
    }

    public BotDebugModule() {
        super("Bot Debug", ModuleCategory.Bots);
        addSetting(chat, connecting, disconnect, rejoin, mouseclicks,
                notifications, scriptErrors, internalErrors, chunkCache,
                baritoneDebug, captcha);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.toggle();
    }
}
