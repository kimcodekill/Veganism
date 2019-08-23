package chokemonster.veganism.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class HempBlock extends SugarCaneBlock {
    public HempBlock() {
        super(Properties.from(Blocks.SUGAR_CANE));
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState soil = worldIn.getBlockState(pos.down());
        if (soil.canSustainPlant(worldIn, pos.down(), Direction.UP, this)) return true;
        Block block = worldIn.getBlockState(pos.down()).getBlock();
        if (block == this) {
            return true;
        } else {
            if (block == Blocks.FARMLAND) {
                return true;
            }
            return false;
        }
    }

    @Override
    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if (!state.isValidPosition(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        } else if (worldIn.isAirBlock(pos.up())) {
            int i;
            for (i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i) {
                ;
            }

            if (i < 2) {
                int j = state.get(AGE);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
                    if (j == 15) {
                        worldIn.setBlockState(pos.up(), chokemonster.veganism.blocks.Blocks.hemp_top_block.getDefaultState());
                        worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 4);
                    } else {
                        worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(j + 1)), 4);
                    }
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
        }

    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.Crop;
    }
}