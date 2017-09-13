package discardedmarrow.veganism.handlers;


import discardedmarrow.veganism.init.ArmorInit;
import discardedmarrow.veganism.init.BlockInit;
import discardedmarrow.veganism.init.BlockSpecialInit;
import discardedmarrow.veganism.init.ItemInit;
import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import scala.collection.immutable.List;

public class RegistryHandler {
	
	public static void Client() {
		RecipeHandler.registerSmelting();
		SeedHandler.registerSeeds();
		
		
	}
	
	public static void Common() {
		BlockInit.init();
		BlockInit.register();
		
		BlockSpecialInit.init();
		BlockSpecialInit.register();
		
		ItemInit.init();
		ItemInit.register();
		
		ArmorInit.init();
		ArmorInit.register();
		
		//TileEntityHandler.registerTileEntity();
	}
}
