package discardedmarrow.veganism.init.armor;

import discardedmarrow.veganism.Veganism;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorVeganism extends ItemArmor {

	public ArmorVeganism(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Veganism.veganismtab);
	}

}
