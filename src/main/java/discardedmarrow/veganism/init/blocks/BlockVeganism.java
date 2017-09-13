package discardedmarrow.veganism.init.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockVeganism extends Block {
	public BlockVeganism(String name, float hardness, float resistance, Material material,SoundType soundtype) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
		setSoundType(soundtype);
	}
}
