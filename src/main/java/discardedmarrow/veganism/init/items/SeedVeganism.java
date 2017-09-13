package discardedmarrow.veganism.init.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class SeedVeganism extends ItemSeeds {

	public SeedVeganism(String name, Block crops, Block soil) {
		super(crops, soil);
		setRegistryName(name);
		setUnlocalizedName(name);
	}
	
}
