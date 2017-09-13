package discardedmarrow.veganism.init;


import discardedmarrow.veganism.Veganism;
import discardedmarrow.veganism.init.blocks.BlockHemp;
import discardedmarrow.veganism.init.blocks.BlockHempTripWire;
import discardedmarrow.veganism.init.blocks.BlockSoyBean;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSpecialInit {
	public static Block hemp_tripwire;
	public static Block soy_beans;
	public static Block hemp_crop;
	
	public static void init() {
		hemp_tripwire = new BlockHempTripWire("hemp_tripwire");
		soy_beans = new BlockSoyBean("soy_beans");
		hemp_crop = new BlockHemp("hemp_crop");
	}
	
	public static void register() {
		registerBlock(hemp_tripwire);
		registerBlock(soy_beans);
		registerBlock(hemp_crop);
		
		createStatemappers();
	}
	
	public static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(Veganism.veganismtab);
		
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void createStatemappers() {
		ModelLoader.setCustomStateMapper(hemp_tripwire, (new StateMap.Builder().ignore(BlockHempTripWire.DISARMED, BlockHempTripWire.POWERED)).build());
		ModelLoader.setCustomStateMapper(hemp_crop, (new StateMap.Builder().ignore(BlockHemp.AGE)).build());
	}
}
