package chokemonster.veganism.items;

import net.minecraft.item.Item;

public class FertilizerItem extends Item {
    public FertilizerItem(Properties properties) {
        super(properties);
    }

//	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
//    {
//        ItemStack itemstack = player.getHeldItem(hand);
//
//        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
//        {
//            return EnumActionResult.FAIL;
//        }
//        else
//        {
//        	if (applyFertilizer(itemstack, worldIn, pos, player, hand))
//        	{
//        		if (!worldIn.isRemote)
//        		{
//        			worldIn.playEvent(2005, pos, 0);
//        		}
//        		return EnumActionResult.SUCCESS;
//        	}
//            return EnumActionResult.PASS;
//        }
//    }
//
//	public static boolean applyFertilizer(ItemStack stack, World worldIn, BlockPos target, EntityPlayer player, @javax.annotation.Nullable EnumHand hand)
//    {
//        IBlockState iblockstate = worldIn.getBlockState(target);
//
//        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, target, iblockstate, stack, hand);
//        if (hook != 0) return hook > 0;
//
//        if (iblockstate.getBlock() instanceof IGrowable)
//        {
//            IGrowable igrowable = (IGrowable)iblockstate.getBlock();
//
//            if (igrowable.canGrow(worldIn, target, iblockstate, worldIn.isRemote))
//            {
//                if (!worldIn.isRemote)
//                {
//                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, target, iblockstate))
//                    {
//                        igrowable.grow(worldIn, worldIn.rand, target, iblockstate);
//                    }
//
//                    stack.shrink(1);
//                }
//
//                return true;
//            }
//        }
//
//        return false;
//    }
}
