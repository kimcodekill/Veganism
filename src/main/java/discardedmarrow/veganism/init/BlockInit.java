package discardedmarrow.veganism.init;


import discardedmarrow.veganism.Veganism;
import discardedmarrow.veganism.init.blocks.BlockFermenter;
import discardedmarrow.veganism.init.blocks.BlockVeganism;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockInit {
	
	public static Block tofu_block;
	public static Block fermenter;
	
	public static void init() {
		tofu_block = new BlockVeganism("tofu_block",1.0f, 1.0f, Material.SPONGE,SoundType.SLIME);
		fermenter = new BlockFermenter("fermenter", 1.0f, 1.0f, Material.WOOD, SoundType.WOOD);
	}
	
	public static void register() {
		registerBlock(tofu_block);
		registerBlock(fermenter);
	}
	
	public static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(Veganism.veganismtab);
		
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
		item.setCreativeTab(Veganism.veganismtab);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
