package discardedmarrow.veganism.tabs;

import discardedmarrow.veganism.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class VeganismTab extends CreativeTabs {
	public VeganismTab(String label) { 
		super("veganismtab");
	}
	
	public ItemStack getTabIconItem() {
		return new ItemStack (ItemInit.tofu);
	}
	
	
}
