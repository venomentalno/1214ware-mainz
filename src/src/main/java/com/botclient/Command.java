package neo.deobf;

public abstract class Command implements MinecraftContext {
    public final String name        = getClass().getAnnotation(CommandInfo.class).name();
    public final String description = getClass().getAnnotation(CommandInfo.class).description();

    public abstract void execute(String[] args) throws Exception;
    public abstract void error();

    public void sendMessage(String message) {
        ChatUtils.formatMsg(message);
    }
}
