package discardedmarrow.veganism.init.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPHVeganism extends Item {

	private Item containerItem;

	public ItemPHVeganism(String name, int maxStackSize) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setMaxStackSize(maxStackSize);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(TextFormatting.GOLD + "THIS ITEM IS A PLACEHOLDER\nAND WILL BE REPLACED");
    }
	
	@Override
	public boolean hasContainerItem() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		// TODO Auto-generated method stub
		return new ItemStack(this.containerItem);
	}
	
	@Override
	public Item setContainerItem(Item containerItem) {
		// TODO Auto-generated method stub
		return this.containerItem = containerItem;
	}
}
