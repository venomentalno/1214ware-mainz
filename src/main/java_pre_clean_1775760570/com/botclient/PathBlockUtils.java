/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Vector3i
 *  neo.deobf.PathBlockType
 *  neo.deobf.BlockUtils
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package com.botclient;

import java.util.ArrayList;
import java.util.List;
import javax.vecmath.Vector3i;
import com.botclient.PathBlockType;
import com.botclient.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PathBlockUtils {
    public static List<Integer> blocksAvoid = new ArrayList<Integer>();

    public static boolean canStandOn(Vector3i pos, World world) {
        Vector3i pos0 = new Vector3i((pos.x), (pos.y) - (1), (pos.z));
        int block0 = 1;
        int block1 = 1;
        if (PathBlockUtils.checkBlock(pos0, world) != (PathBlockType.SOLID)) {
            block0 = 0;
        }
        Vector3i pos1 = new Vector3i((pos.x), (pos.y), (pos.z));
        PathBlockType check = PathBlockUtils.checkBlock(pos1, world);
        boolean block1TopSolid = PathBlockUtils.isTopSolid(pos1, world);
        if (!block1TopSolid && check != (PathBlockType.PASSABLE)) {
            block1 = 1;
        } else if (check != (PathBlockType.PASSABLE)) {
            block1 = 0;
        }
        if (!(!block1TopSolid && block1 == 0 || block0 != 0 && block1 != 0)) {
            return false;
        }
        Vector3i pos2 = new Vector3i((pos.x), (pos.y) + (1), (pos.z));
        return (PathBlockUtils.checkBlock(pos2, world) == (PathBlockType.PASSABLE) ? 1 : 0) != 0;
    }

    public static PathBlockType checkBlock(Vector3i pos, World world) {
        Block block = BlockUtils.getBlockByPos((World)world, (BlockPos)BlockUtils.vec3i_toBlockPos((Vector3i)pos));
        if (block == null) {
            return (PathBlockType.PASSABLE);
        }
        if (Block.getIdFromBlock((Block)block) == (144)) {
            return (PathBlockType.SOLID);
        }
        if (Block.getIdFromBlock((Block)block) == (36)) {
            return (PathBlockType.PASSABLE);
        }
        if (Block.getIdFromBlock((Block)block) == (101)) {
            return (PathBlockType.PASSABLE);
        }
        if (Block.getIdFromBlock((Block)block) == (8) || Block.getIdFromBlock((Block)block) == (9)) {
            return (PathBlockType.SOLID);
        }
        if (Block.getIdFromBlock((Block)block) == (198)) {
            return (PathBlockType.SOLID);
        }
        for (Integer id : (blocksAvoid)) {
            int blockId = Block.getIdFromBlock((Block)block);
            if (blockId != id) continue;
            return (PathBlockType.AVOID);
        }
        if (block.isPassable((IBlockAccess)world, BlockUtils.vec3i_toBlockPos((Vector3i)pos))) {
            return (PathBlockType.PASSABLE);
        }
        return (PathBlockType.SOLID);
    }

    public static boolean canMoveToDiagonal(Vector3i startPos, Vector3i endPos, World world) {
        if (PathBlockUtils.canMoveTo(startPos, endPos, world)) {
            boolean res1 = PathBlockUtils.canExistOn(new Vector3i((endPos.x), (endPos.y), (startPos.z)), world);
            boolean res2 = PathBlockUtils.canExistOn(new Vector3i((startPos.x), (endPos.y), (endPos.z)), world);
            boolean res3 = PathBlockUtils.canExistOn(new Vector3i((endPos.x), (startPos.y), (startPos.z)), world);
            boolean res4 = PathBlockUtils.canExistOn(new Vector3i((startPos.x), (startPos.y), (endPos.z)), world);
            int resFinal = 1;
            int ydif = (startPos.y) - (endPos.y);
            for (int y = 0; y <= ydif; ++y) {
                if (PathBlockUtils.checkBlock(new Vector3i((endPos.x), (startPos.y) + y, (endPos.z)), world) == (PathBlockType.PASSABLE)) continue;
                resFinal = 0;
            }
            return (!(!res1 && !res2 || resFinal == 0 || !res3 && !res4) ? 1 : 0) != 0;
        }
        return false;
    }

    static {
        blocksAvoid.add(10);
        blocksAvoid.add(11);
    }

    public static boolean isTopSolid(BlockPos pos, World world) {
        BlockState state = BlockUtils.getBlockStateByPos((World)world, (BlockPos)pos);
        if (state == null) {
            return false;
        }
        return state.isTopSolid();
    }

    public static boolean isTopSolid(Vector3i pos, World world) {
        BlockState state = BlockUtils.getBlockStateByPos((World)world, (BlockPos)BlockUtils.vec3i_toBlockPos((Vector3i)pos));
        if (state == null) {
            return false;
        }
        Block block = BlockUtils.getBlockByPos((World)world, (BlockPos)BlockUtils.vec3i_toBlockPos((Vector3i)pos));
        if (block != null && Block.getIdFromBlock((Block)block) == (109)) {
            return true;
        }
        return state.isTopSolid();
    }

    public static boolean canExistOn(Vector3i pos, World world) {
        Vector3i pos0 = new Vector3i((pos.x), (pos.y), (pos.z));
        Vector3i pos1 = new Vector3i((pos.x), (pos.y) + (1), (pos.z));
        int b0 = PathBlockUtils.checkBlock(pos0, world) == (PathBlockType.PASSABLE) ? 1 : 0;
        int b1 = PathBlockUtils.checkBlock(pos1, world) == (PathBlockType.PASSABLE) ? 1 : 0;
        return (b0 != 0 && b1 != 0 ? 1 : 0) != 0;
    }

    public static boolean canMoveTo(Vector3i startPos, Vector3i endPos, World world) {
        boolean canStandOnEnd = PathBlockUtils.canStandOn(endPos, world);
        if (!canStandOnEnd) {
            return false;
        }
        for (int y = (endPos.y); y <= (startPos.y); ++y) {
            if (PathBlockUtils.checkBlock(new Vector3i((endPos.x), y, (endPos.z)), world) == (PathBlockType.PASSABLE)) continue;
            return false;
        }
        if ((startPos.y) < (endPos.y)) {
            boolean result = PathBlockUtils.canExistOn(new Vector3i((startPos.x), (endPos.y), (startPos.z)), world);
            if (result) {
                int isEndUpPassable;
                Vector3i endPosFloor = endPos.sub(0, 1, 0);
                int n = isEndUpPassable = PathBlockUtils.checkBlock(endPos, world) == (PathBlockType.PASSABLE) ? 1 : 0;
                if (isEndUpPassable == 0) {
                    return false;
                }
                boolean isTopSolidS = PathBlockUtils.isTopSolid(startPos.sub(0, 1, 0), world);
                boolean isTopSolidE = PathBlockUtils.isTopSolid(endPosFloor, world);
                if (!isTopSolidS && !isTopSolidE) {
                    return true;
                }
                if (isTopSolidS && !isTopSolidE) {
                    return true;
                }
                if (!isTopSolidS && isTopSolidE) {
                    return false;
                }
                if (isTopSolidS && isTopSolidE) {
                    return true;
                }
            }
            return result;
        }
        if ((startPos.y) > (endPos.y)) {
            return PathBlockUtils.canExistOn(new Vector3i((endPos.x), (startPos.y), (endPos.z)), world);
        }
        return canStandOnEnd;
    }

}

