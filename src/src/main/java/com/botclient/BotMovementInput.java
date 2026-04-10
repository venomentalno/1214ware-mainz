package neo.deobf;

import net.minecraft.client.player.Input;

/**
 * 1.21.4: MovementInput was replaced by Input.
 * We extend Input and drive it from BotKeyState.
 */
public class BotMovementInput extends Input {
    public final BotKeyState gameSettings;

    public BotMovementInput(BotKeyState gameSettings) {
        this.gameSettings = gameSettings;
    }

    /** Called every tick by PBotPlayer.aiStep() – mirrors 1.12.2 updatePlayerMoveState(). */
    public void tick(boolean slowDown, float strafe) {
        this.jumping = gameSettings.keyBindJump;
        this.shiftKeyDown = gameSettings.keyBindSneak;

        float fwd = 0.0f;
        float str = 0.0f;

        if (gameSettings.keyBindForward) { fwd += 1.0f; this.forwardImpulse =  1.0f; } else { this.forwardImpulse = 0.0f; }
        if (gameSettings.keyBindBack)    { fwd -= 1.0f; this.forwardImpulse = -1.0f; }
        if (gameSettings.keyBindLeft)    { str += 1.0f; this.leftImpulse    =  1.0f; } else { this.leftImpulse    = 0.0f; }
        if (gameSettings.keyBindRight)   { str -= 1.0f; this.leftImpulse    = -1.0f; }

        if (gameSettings.keyBindSneak) {
            str *= 0.3f;
            fwd *= 0.3f;
        }

        this.forwardImpulse = fwd;
        this.leftImpulse    = str;
    }
}
