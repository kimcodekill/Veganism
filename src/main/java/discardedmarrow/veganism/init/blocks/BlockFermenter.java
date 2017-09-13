package discardedmarrow.veganism.init.blocks;

import discardedmarrow.veganism.Veganism;
import discardedmarrow.veganism.init.tileentity.TileEntityFermenter;
import discardedmarrow.veganism.init.util.EnumGui;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockFermenter extends BlockContainer {
	private boolean hasTileEntity;

	public BlockFermenter(String name,float hardness,float resistance, Material material, SoundType soundtype) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setHardness(hardness);
		setSoundType(soundtype);
	}
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            playerIn.openGui(Veganism.instance, 
                  EnumGui.FERMENTER.ordinal(), 
                  worldIn, 
                  pos.getX(), 
                  pos.getY(), 
                  pos.getZ()); 
        }
        
        return true;
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityFermenter();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!hasTileEntity)
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityFermenter)
            {
                InventoryHelper.dropInventoryItems(worldIn, pos, 
                      (TileEntityFermenter)tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }
		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
}
