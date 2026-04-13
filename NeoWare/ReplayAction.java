/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.ReplayActionType
 */
package neo.deobf;

import neo.deobf.ReplayActionType;

/*
 * Exception performing whole class analysis ignored.
 */
public class ReplayAction {
    public String message;
    public boolean leftKeyDown;
    public int integer;
    public boolean forwardKeyDown;
    public boolean keyBindSneak;
    public boolean keyBindJump;
    public boolean backKeyDown;
    public boolean rightKeyDown;
    public float pitch;
    public boolean keyBindSprint;
    public float yaw;
    public ReplayActionType actionType;

    public ReplayAction(ReplayActionType actionType, int integer) {
        this.actionType = actionType;
        this.integer = integer;
    }

    public ReplayAction(ReplayActionType actionType, String message) {
        this.actionType = actionType;
        this.message = message;
    }

    public ReplayAction(ReplayActionType actionType, boolean forwardKeyDown, boolean backKeyDown, boolean leftKeyDown, boolean rightKeyDown, float yaw, float pitch, boolean keyBindSneak, boolean keyBindSprint, boolean keyBindJump) {
        this.actionType = actionType;
        this.forwardKeyDown = forwardKeyDown;
        this.backKeyDown = backKeyDown;
        this.leftKeyDown = leftKeyDown;
        this.rightKeyDown = rightKeyDown;
        this.yaw = yaw;
        this.pitch = pitch;
        this.keyBindSneak = keyBindSneak;
        this.keyBindSprint = keyBindSprint;
        this.keyBindJump = keyBindJump;
    }
}





