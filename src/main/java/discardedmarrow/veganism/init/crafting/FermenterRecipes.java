package discardedmarrow.veganism.init.crafting;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import net.minecraft.item.ItemStack;

public class FermenterRecipes {
	 private static final FermenterRecipes FERMENTING_BASE = new FermenterRecipes();
	 private final Map<ItemStack, ItemStack> fermentingList = Maps.<ItemStack, ItemStack>newHashMap();
	public static FermenterRecipes instance()
    {
        return FERMENTING_BASE;
    }

	public ItemStack getFermentingResult(ItemStack itemStack) {
		for (Entry<ItemStack, ItemStack> entry : this.fermentingList.entrySet())
        {
            if (this.compareItemStacks(itemStack, entry.getKey()))
            {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

	public float getFermentingExperience(ItemStack parItemStack) {
		// TODO Auto-generated method stub
		return 0;
	}
}
