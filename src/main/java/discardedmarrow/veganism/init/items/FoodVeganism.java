package discardedmarrow.veganism.init.items;

import net.minecraft.item.ItemFood;

public class FoodVeganism extends ItemFood {
	public FoodVeganism(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
