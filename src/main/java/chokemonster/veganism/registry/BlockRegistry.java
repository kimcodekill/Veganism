package chokemonster.veganism.registry;

import chokemonster.veganism.Reference;
import chokemonster.veganism.blocks.HempBaleBlock;
import chokemonster.veganism.blocks.HempBlock;
import chokemonster.veganism.blocks.HempTopBlock;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {
    @SubscribeEvent
    public static void onBlockRegistry(final RegistryEvent.Register<Block> event) {

        event.getRegistry().registerAll(
                new HempBlock().setRegistryName(Reference.MODID, "hemp_block"),
                new HempTopBlock().setRegistryName(Reference.MODID, "hemp_top_block"),
                new HempBaleBlock().setRegistryName(Reference.MODID, "hemp_bale")
        );
    }
}
