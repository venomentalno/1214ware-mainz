/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.MinecraftContext
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.PlayerEntitySP
 *  net.minecraft.client.multiplayer.ClientWorld
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.util.math.Vec3d
 */
package com.botclient;

import com.botclient.MinecraftContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.Box;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class MovementUtils
implements MinecraftContext {

    private static PlayerEntitySP getPlayer() {
        return Minecraft.player;
    }

    private static GameSettings getGameSettings() {
        return Minecraft.gameSettings;
    }

    private static MovementInput getMovementInput(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    private static PlayerEntitySP getPlayer5() {
        return Minecraft.player;
    }

    private static MovementInput getMovementInput2(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    private static MovementInput getMovementInput3(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    private static PlayerEntitySP getPlayer7() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer8() {
        return Minecraft.player;
    }

    public static int getSpeed(Object clamp) {
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean isMoving() {
        int n;
        if ((double)(MovementUtils.getMovementInput8(MovementUtils.getPlayer38()).moveStrafe) == 0.0) {
            if ((double)(MovementUtils.getMovementInput11(MovementUtils.getPlayer32()).moveForward) == 0.0) {
                n = 0;
                return n != 0;
            }
        }
        n = 1;
        return n != 0;
    }

    private static PlayerEntitySP getPlayer9() {
        return Minecraft.player;
    }

    public static float getMoveDirection() {
        double motionX = (MovementUtils.getPlayer46().motionX);
        double motionZ = (MovementUtils.getPlayer63().motionZ);
        float direction = (float)(Math.atan2(motionX, motionZ) / 3.1415926535897931 * 180.0);
        return -direction;
    }

    public static float getMotion() {
        double d = (MovementUtils.getPlayer20().motionX);
        double d2 = d * (MovementUtils.getPlayer17().motionX);
        double d3 = (MovementUtils.getPlayer58().motionZ);
        return (float)Math.sqrt(d2 + d3 * (MovementUtils.getPlayer44().motionZ));
    }

    private static PlayerEntitySP getPlayer10() {
        return Minecraft.player;
    }

    public static void setMotion(double motion) {
        double forward = (MovementUtils.getMovementInput9(MovementUtils.getPlayer14()).moveForward);
        double strafe = (MovementUtils.getMovementInput4(MovementUtils.getPlayer12()).moveStrafe);
        float yaw = (MovementUtils.getPlayer43().rotationYaw);
        if (forward == 0.0 && strafe == 0.0) {
            MovementUtils.getPlayer50().motionX = 0.0;
            MovementUtils.getPlayer40().motionZ = 0.0;
        } else {
            if (forward != 0.0) {
                if (strafe > 0.0) {
                    yaw += (float)(forward > 0.0 ? -45 : 45);
                } else if (strafe < 0.0) {
                    yaw += (float)(forward > 0.0 ? 45 : -45);
                }
                strafe = 0.0;
                if (forward > 0.0) {
                    forward = 1.0;
                } else if (forward < 0.0) {
                    forward = -1.0;
                }
            }
            MovementUtils.getPlayer54().motionX = forward * motion * Math.cos(Math.toRadians(yaw + 90.0f)) + strafe * motion * Math.sin(Math.toRadians(yaw + 90.0f));
            MovementUtils.getPlayer13().motionZ = forward * motion * Math.sin(Math.toRadians(yaw + 90.0f)) - strafe * motion * Math.cos(Math.toRadians(yaw + 90.0f));
        }
    }

    private static PlayerEntitySP getPlayer11() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer12() {
        return Minecraft.player;
    }

    public static double[] forward(double speed) {
        float forward = (MovementUtils.getMovementInput7(MovementUtils.getPlayer11()).moveForward);
        float side = (MovementUtils.getMovementInput14(MovementUtils.getPlayer62()).moveStrafe);
        float f = (MovementUtils.getPlayer24().prevRotationYaw);
        float f2 = (MovementUtils.getPlayer27().rotationYaw);
        float yaw = f + (f2 - (MovementUtils.getPlayer51().prevRotationYaw)) * (mc).getRenderPartialTicks();
        if (forward != 0.0f) {
            if (side > 0.0f) {
                yaw += (float)(forward > 0.0f ? -45 : 45);
            } else if (side < 0.0f) {
                yaw += (float)(forward > 0.0f ? 45 : -45);
            }
            side = 0.0f;
            if (forward > 0.0f) {
                forward = 1.0f;
            } else if (forward < 0.0f) {
                forward = -1.00000048f;
            }
        }
        double sin = Math.sin(Math.toRadians(yaw + 90.0f));
        double cos = Math.cos(Math.toRadians(yaw + 90.0f));
        double posX = (double)forward * speed * cos + (double)side * speed * sin;
        double posZ = (double)forward * speed * sin - (double)side * speed * cos;
        double[] dArray = new double[2];
        dArray[0] = posX;
        dArray[1] = posZ;
        return dArray;
    }

    private static MovementInput getMovementInput4(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    private static PlayerEntitySP getPlayer13() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer14() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer15() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer16() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer17() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer18() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer19() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer20() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer21() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer22() {
        return Minecraft.player;
    }

    private static MovementInput getMovementInput5(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    private static PlayerEntitySP getPlayer23() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer24() {
        return Minecraft.player;
    }

    private static MovementInput getMovementInput6(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    public static float getAllDirection() {
        float rotationYaw = (MovementUtils.getPlayer60().rotationYaw);
        float factor = 0.0f;
        if ((MovementUtils.getMovementInput5(MovementUtils.getPlayer29()).moveForward) > 0.0f) {
            factor = 1.0f;
        }
        if ((MovementUtils.getMovementInput10(MovementUtils.getPlayer52()).moveForward) < 0.0f) {
            factor = -1.00000048f;
        }
        if (factor == 0.0f) {
            if ((MovementUtils.getMovementInput13(MovementUtils.getPlayer55()).moveStrafe) > 0.0f) {
                rotationYaw -= 90.0f;
            }
            if ((MovementUtils.getMovementInput(MovementUtils.getPlayer37()).moveStrafe) < 0.0f) {
                rotationYaw += 90.0f;
            }
        } else {
            if ((MovementUtils.getMovementInput2(MovementUtils.getPlayer25()).moveStrafe) > 0.0f) {
                rotationYaw -= 45.0f * factor;
            }
            if ((MovementUtils.getMovementInput12(MovementUtils.getPlayer18()).moveStrafe) < 0.0f) {
                rotationYaw += 45.0f * factor;
            }
        }
        if (factor < 0.0f) {
            rotationYaw -= 180.0f;
        }
        return (float)Math.toRadians(rotationYaw);
    }

    private static PlayerEntitySP getPlayer25() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer26() {
        return Minecraft.player;
    }

    private static MovementInput getMovementInput7(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    private static PlayerEntitySP getPlayer27() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer28() {
        return Minecraft.player;
    }

    private static MovementInput getMovementInput8(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    public static void setSpeed(double speed) {
        float f = (MovementUtils.getMovementInput6(MovementUtils.getPlayer61()).moveForward);
        float f1 = (MovementUtils.getMovementInput3(MovementUtils.getPlayer45()).moveStrafe);
        float f2 = (MovementUtils.getPlayer8().rotationYaw);
        if (f == 0.0f && f1 == 0.0f) {
            MovementUtils.getPlayer19().motionX = 0.0;
            MovementUtils.player.motionZ = 0.0;
        } else if (f != 0.0f) {
            if (f1 >= 1.0f) {
                f2 += (float)(f > 0.0f ? -35 : 35);
                f1 = 0.0f;
            } else if (f1 <= -1.0f) {
                f2 += (float)(f > 0.0f ? 35 : -35);
                f1 = 0.0f;
            }
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d0 = Math.cos(Math.toRadians(f2 + 90.0f));
        double d1 = Math.sin(Math.toRadians(f2 + 90.0f));
        MovementUtils.getPlayer15().motionX = (double)f * speed * d0 + (double)f1 * speed * d1;
        MovementUtils.getPlayer21().motionZ = (double)f * speed * d1 - (double)f1 * speed * d0;
    }

    private static PlayerEntitySP getPlayer29() {
        return Minecraft.player;
    }

    private static MovementInput getMovementInput9(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    private static PlayerEntitySP getPlayer30() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer31() {
        return Minecraft.player;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean isInLiquid() {
        int n;
        if (!(Minecraft.player).isInWater()) {
            if (!(Minecraft.player).isInLava()) {
                n = 0;
                return n != 0;
            }
        }
        n = 1;
        return n != 0;
    }

    private static PlayerEntitySP getPlayer32() {
        return Minecraft.player;
    }

    private static MovementInput getMovementInput10(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    private static PlayerEntitySP getPlayer33() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer34() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer35() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer36() {
        return Minecraft.player;
    }

    private static MovementInput getMovementInput11(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    private static PlayerEntitySP getPlayer37() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer38() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer39() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer40() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer41() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer43() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer44() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer45() {
        return Minecraft.player;
    }

    public static boolean isBlockAboveHead() {
        double d = (MovementUtils.getPlayer28().posX) - 0.29999999999999999;
        double d2 = (MovementUtils.getPlayer30().posY);
        double d3 = d2 + (double)(Minecraft.player).getEyeHeight();
        double d4 = (MovementUtils.getPlayer5().posZ) + 0.29999999999999999;
        double d5 = (MovementUtils.getPlayer36().posX) + 0.29999999999999999;
        double d6 = (MovementUtils.getPlayer22().posY);
        double d7 = d6 + (!(MovementUtils.getPlayer57().onGround) ? 1.5 : 2.5);
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d, d3, d4, d5, d7, (MovementUtils.getPlayer10().posZ) - 0.29999999999999999);
        ClientWorld worldClient = ((mc).world);
        return (!worldClient.getCollisionBoxes((Entity)(Minecraft.player), axisAlignedBB).isEmpty() ? 1 : 0) != 0;
    }

    private static PlayerEntitySP getPlayer46() {
        return Minecraft.player;
    }

    public static boolean isUnderBedrock() {
        if ((MovementUtils.getPlayer41().posY) <= 3.0) {
            ClientWorld worldClient = ((mc).world);
            Vec3d vec3d = (Minecraft.player).getPositionVector();
            double d = (MovementUtils.getPlayer33().posX);
            double d2 = 0.0;
            HitResult trace = worldClient.rayTraceBlocks(vec3d, new Vec3d(d, d2, (MovementUtils.getPlayer56().posZ)), false, false, false);
            return (trace == null || (trace.typeOfHit) != (HitResult.Type.BLOCK) ? 1 : 0) != 0;
        }
        return false;
    }

    private static PlayerEntitySP getPlayer48() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer49() {
        return Minecraft.player;
    }

    public static void strafe(float speed) {
        if (!MovementUtils.isMoving()) {
            return;
        }
        double yaw = MovementUtils.getAllDirection();
        MovementUtils.getPlayer16().motionX = -Math.sin(yaw) * (double)speed;
        MovementUtils.getPlayer59().motionZ = Math.cos(yaw) * (double)speed;
    }

    private static PlayerEntitySP getPlayer50() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer51() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer52() {
        return Minecraft.player;
    }

    private static MovementInput getMovementInput12(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    private static PlayerEntitySP getPlayer53() {
        return Minecraft.player;
    }

    public static boolean airBlockAboveHead() {
        double d = (MovementUtils.getPlayer26().posX) - 0.29999999999999999;
        double d2 = (MovementUtils.getPlayer34().posY);
        double d3 = d2 + (double)(Minecraft.player).getEyeHeight();
        double d4 = (MovementUtils.getPlayer7().posZ) + 0.29999999999999999;
        double d5 = (MovementUtils.getPlayer39().posX) + 0.29999999999999999;
        double d6 = (MovementUtils.getPlayer31().posY);
        double d7 = d6 + (!(MovementUtils.getPlayer48().onGround) ? 1.5 : 2.5);
        AxisAlignedBB bb = new AxisAlignedBB(d, d3, d4, d5, d7, (MovementUtils.getPlayer23().posZ) - 0.29999999999999999);
        ClientWorld worldClient = ((mc).world);
        return worldClient.getCollisionBoxes((Entity)(Minecraft.player), bb).isEmpty();
    }

    public static void strafe() {
        if ((MovementUtils.getGameSettings().keyBindBack).isKeyDown()) {
            return;
        }
        MovementUtils.strafe(MovementUtils.getSpeed());
    }

    private static PlayerEntitySP getPlayer54() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer55() {
        return Minecraft.player;
    }

    private static MovementInput getMovementInput13(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    public static float getSpeed() {
        double d = (MovementUtils.getPlayer9().motionX);
        double d2 = d * (MovementUtils.getPlayer35().motionX);
        double d3 = (MovementUtils.getPlayer53().motionZ);
        return (float)Math.sqrt(d2 + d3 * (MovementUtils.getPlayer49().motionZ));
    }

    private static MovementInput getMovementInput14(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.movementInput;
    }

    private static PlayerEntitySP getPlayer56() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer57() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer58() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer59() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer60() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer61() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer62() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer63() {
        return Minecraft.player;
    }

}


