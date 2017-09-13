package discardedmarrow.veganism.init.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;

public class ItemBucketSoyMilk extends ItemBucketMilk {
	
	public ItemBucketSoyMilk(String name) {
		setRegistryName(name);
		setUnlocalizedName(name);
		setContainerItem(Item.getByNameOrId("minecraft:bucket"));
	}
}
