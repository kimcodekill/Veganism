package chokemonster.veganism.armor;

import chokemonster.veganism.Reference;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;

public class ArmorVeganism extends ArmorItem {

    public ArmorVeganism(String name, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties builder) {
        super(materialIn, slot, builder);
        setRegistryName(Reference.MODID, name);
    }

}
