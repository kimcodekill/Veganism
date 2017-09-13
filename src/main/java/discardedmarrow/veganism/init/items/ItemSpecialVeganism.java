package discardedmarrow.veganism.init.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockSpecial;

public class ItemSpecialVeganism extends ItemBlockSpecial {
	
	/**
     * @param name Unique registry name
     * @param block Block to be placed
     */
	public ItemSpecialVeganism(String name, Block block) {
		super(block);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
