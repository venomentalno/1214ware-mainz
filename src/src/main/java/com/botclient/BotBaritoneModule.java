package neo.deobf;

public class BotBaritoneModule extends Module {
    public static BooleanSetting autoJump;
    public static BooleanSetting autoSwim;

    static {
        autoJump = new BooleanSetting("AutoJump", true);
        autoSwim = new BooleanSetting("AutoSwim", true);
    }

    public BotBaritoneModule() {
        super("Bot-Baritone", ModuleCategory.Bots);
        addSetting(autoJump, autoSwim);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.toggle();
    }
}
