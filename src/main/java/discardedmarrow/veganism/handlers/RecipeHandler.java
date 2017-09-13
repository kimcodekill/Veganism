package discardedmarrow.veganism.handlers;

import discardedmarrow.veganism.init.ItemInit;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	public static void registerSmelting() {
		GameRegistry.addSmelting(ItemInit.tofu, new ItemStack(ItemInit.cooked_tofu), 10);
	}
}
