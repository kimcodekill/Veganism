package discardedmarrow.veganism.proxy;

import discardedmarrow.veganism.Veganism;
import discardedmarrow.veganism.handlers.GuiHandler;
import discardedmarrow.veganism.handlers.RegistryHandler;
import net.minecraft.client.main.Main;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		RegistryHandler.Common();
	}
	
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(Veganism.instance, new GuiHandler());
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
