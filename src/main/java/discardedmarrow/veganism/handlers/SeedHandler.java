package discardedmarrow.veganism.handlers;

import discardedmarrow.veganism.init.ItemInit;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class SeedHandler {
	
	public static void registerSeeds() {
		MinecraftForge.addGrassSeed(new ItemStack(ItemInit.soy_bean), 5);
	}
}
