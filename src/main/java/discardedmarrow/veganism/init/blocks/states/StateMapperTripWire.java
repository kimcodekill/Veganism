package discardedmarrow.veganism.init.blocks.states;

import discardedmarrow.veganism.init.blocks.BlockHempTripWire;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class StateMapperTripWire extends StateMapperBase
{
	
    protected ModelResourceLocation getModelResourceLocation(IBlockState state)
    {
    	IBlockState blockState = (new BlockStateContainer(new BlockHempTripWire(""), new IProperty[] {BlockHempTripWire.ATTACHED, BlockHempTripWire.NORTH, BlockHempTripWire.EAST, BlockHempTripWire.WEST, BlockHempTripWire.SOUTH})).getBaseState();
    	
        return new ModelResourceLocation(Block.REGISTRY.getNameForObject(blockState.getBlock()), this.getPropertyString(blockState.getProperties()));
    }
}