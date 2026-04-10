package neo.deobf;

public class BotController {
    public final PBot pbot;
    public final PathFinder pathFinder;
    public BotTask botFunction;

    public BotController(PBot pbot) {
        this.pbot       = pbot;
        this.pathFinder = new PathFinder(pbot);
    }

    public void onUpdate() {
        if (!pbot.isOnline()) return;

        // auto-swim
        if (pbot.player.isInWater() && BotBaritoneModule.autoSwim.value) {
            pbot.mc.gameSettings.keyBindJump = true;
        }

        // auto-jump on horizontal collision
        if (BotBaritoneModule.autoJump.value
                && pbot.player.horizontalCollision
                && pbot.mc.gameSettings.keyBindForward) {
            pbot.jump();
        }

        if (botFunction != null) {
            botFunction.onUpdate();
        }

        if (pathFinder != null) {
            try {
                pathFinder.pathFindWalk();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setBotFunction(BotTask botFunction) {
        if (this.botFunction != null) this.botFunction.onFinish();
        this.botFunction = botFunction;
        if (botFunction != null) botFunction.init();
    }

    public PathFinder getPathFinder() { return pathFinder; }
}
