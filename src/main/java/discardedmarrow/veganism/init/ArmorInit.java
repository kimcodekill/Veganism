package discardedmarrow.veganism.init;

import discardedmarrow.veganism.Reference;
import discardedmarrow.veganism.Veganism;
import discardedmarrow.veganism.init.armor.ArmorVeganism;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ArmorInit {
	
	public static final ArmorMaterial cloth = EnumHelper.addArmorMaterial("cloth",Reference.MODID + ":cloth",5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	
	public static Item cloth_helmet, cloth_chestplate, cloth_leggings, cloth_boots;
	
	public static void init() {
		cloth_helmet = new ArmorVeganism("cloth_helmet", cloth, 1, EntityEquipmentSlot.HEAD);
		cloth_chestplate = new ArmorVeganism("cloth_chestplate", cloth, 1, EntityEquipmentSlot.CHEST);
		cloth_leggings = new ArmorVeganism("cloth_leggings", cloth, 2, EntityEquipmentSlot.LEGS);
		cloth_boots = new ArmorVeganism("cloth_boots", cloth, 1, EntityEquipmentSlot.FEET);
	}
	
	public static void register() {
		registerItem(cloth_helmet);
		registerItem(cloth_chestplate);
		registerItem(cloth_leggings);
		registerItem(cloth_boots);
	}
	
	public static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
		item.setCreativeTab(Veganism.veganismtab);
		
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
