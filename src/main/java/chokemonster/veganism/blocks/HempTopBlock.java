package chokemonster.veganism.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

public class HempTopBlock extends HempBlock {

    @Override
    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if (!state.isValidPosition(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        }
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Block block = worldIn.getBlockState(pos.down()).getBlock();
        if (block == chokemonster.veganism.blocks.Blocks.hemp_block) {
            return true;
        }
        return false;
    }
}
