package discardedmarrow.veganism.handlers;

import discardedmarrow.veganism.Reference;
import discardedmarrow.veganism.init.tileentity.TileEntityFermenter;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityFermenter.class,Reference.MODID + ":tileentityfermenter");
	}
}
