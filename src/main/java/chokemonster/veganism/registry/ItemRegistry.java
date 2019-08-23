package chokemonster.veganism.registry;

import chokemonster.veganism.Reference;
import chokemonster.veganism.blocks.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {
    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new BlockNamedItem(Blocks.hemp_block, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Reference.MODID, "hemp_seeds"),
                new BlockItem(Blocks.hemp_bale, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(Blocks.hemp_bale.getRegistryName()),
                new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Reference.MODID, "hemp"),
                new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Reference.MODID, "hemp_fiber"),
                new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Reference.MODID, "hemp_fabric")
        );
    }
}
