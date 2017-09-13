package discardedmarrow.veganism.init;

import discardedmarrow.veganism.Veganism;
import discardedmarrow.veganism.init.items.FoodVeganism;
import discardedmarrow.veganism.init.items.ItemBucketSoyMilk;
import discardedmarrow.veganism.init.items.ItemFertilizer;
import discardedmarrow.veganism.init.items.ItemPHVeganism;
import discardedmarrow.veganism.init.items.ItemSpecialVeganism;
import discardedmarrow.veganism.init.items.ItemVeganism;
import discardedmarrow.veganism.init.items.SeedVeganism;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemInit {
	
	public static Item tofu;
	public static Item cooked_tofu;
	public static Item hemp;
	public static Item hemp_string;
	public static Item hemp_cloth;
	public static Item soy_bean;
	public static Item bucket_soy_milk;
	public static Item hemp_seed;
	public static Item fertilizer;
	
	public static Item press_item;
	public static Item fermenter_item;
	
	public static void init() {
		tofu = new FoodVeganism("tofu",3 , 0.5f, false);
		cooked_tofu = new FoodVeganism("cooked_tofu",5, 1f, false);
		hemp = new ItemSpecialVeganism("hemp", BlockSpecialInit.hemp_crop);
		hemp_string = new ItemSpecialVeganism("hemp_string", BlockSpecialInit.hemp_tripwire);
		hemp_cloth = new ItemVeganism("hemp_cloth");
		soy_bean = new SeedVeganism("soy_bean", BlockSpecialInit.soy_beans, Blocks.FARMLAND);
		bucket_soy_milk = new ItemBucketSoyMilk("bucket_soy_milk");
		fertilizer = new ItemFertilizer("fertilizer");
		
		press_item = new ItemPHVeganism("press_item", 1);
		fermenter_item = new ItemPHVeganism("fermenter_item", 1);
	}
	
	public static void register() {
		registerItem(tofu);
		registerItem(cooked_tofu);
		registerItem(hemp);
		registerItem(hemp_string);
		registerItem(hemp_cloth);
		registerItem(soy_bean);
		registerItem(bucket_soy_milk);
		registerItem(fertilizer);
		
		registerItem(press_item);
		press_item.setContainerItem(press_item);
		registerItem(fermenter_item);
		fermenter_item.setContainerItem(fermenter_item);
	}
	
	public static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
		item.setCreativeTab(Veganism.veganismtab);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
