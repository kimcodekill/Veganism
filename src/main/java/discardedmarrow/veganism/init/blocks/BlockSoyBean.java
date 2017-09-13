package discardedmarrow.veganism.init.blocks;

import discardedmarrow.veganism.init.ItemInit;
import net.minecraft.block.BlockCarrot;
import net.minecraft.item.Item;

public class BlockSoyBean extends BlockCarrot {
    
	public BlockSoyBean(String name) {
		setRegistryName(name);
		setUnlocalizedName(name);
	}
	
    protected Item getSeed()
    {
        return ItemInit.soy_bean;
    }

    protected Item getCrop()
    {
        return ItemInit.soy_bean;
    }
}