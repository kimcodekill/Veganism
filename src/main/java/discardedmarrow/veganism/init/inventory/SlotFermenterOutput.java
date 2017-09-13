package discardedmarrow.veganism.init.inventory;

import discardedmarrow.veganism.init.crafting.FermenterRecipes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

	public class SlotFermenterOutput  extends Slot
	{
	    /** The player that is using the GUI where this slot resides. */
	    private final EntityPlayer thePlayer;
	    private int numFermenterOutput;

	    public SlotFermenterOutput(EntityPlayer Player, 
	          IInventory IInventory, int SlotIndex, 
	          int XDisplayPosition, int YDisplayPosition)
	    {
	        super(IInventory, SlotIndex, XDisplayPosition, 
	              YDisplayPosition);
	        thePlayer = Player;
	    }

	    @Override
	    public boolean isItemValid(ItemStack stack)
	    {
	        return false; // can't place anything into it
	    }

	    @Override
	    public ItemStack decrStackSize(int Amount)
	    {
	        if (getHasStack())
	        {
	            numFermenterOutput += Math.min(Amount, getStack().getCount());
	        }

	        return super.decrStackSize(Amount);
	    }

	    @Override
	    public ItemStack onTake(EntityPlayer playerIn, ItemStack stack)
	    {
	        onCrafting(stack);
	        return super.onTake(playerIn, stack);
	    }

	    @Override
	    protected void onCrafting(ItemStack ItemStack, int AmountFermented)
	    {
	        numFermenterOutput += AmountFermented;
	        onCrafting(ItemStack);
	    }

	    @Override
	    protected void onCrafting(ItemStack ItemStack)
	    {
	        if (!thePlayer.world.isRemote)
	        {
	            int expEarned = numFermenterOutput;
	            float expFactor = FermenterRecipes.instance()
	                  .getFermentingExperience(ItemStack);

	            if (expFactor == 0.0F)
	            {
	                expEarned = 0;
	            }
	            else if (expFactor < 1.0F)
	            {
	                int possibleExpEarned = MathHelper.floor(
	                      expEarned*expFactor);

	                if (possibleExpEarned < MathHelper.ceil(
	                      expEarned*expFactor) 
	                      && Math.random() < expEarned*expFactor-possibleExpEarned)
	                {
	                    ++possibleExpEarned;
	                }

	                expEarned = possibleExpEarned;
	            }

	            // create experience orbs
	            int expInOrb;
	            while (expEarned > 0)
	            {
	                expInOrb = EntityXPOrb.getXPSplit(expEarned);
	                expEarned -= expInOrb;
	                thePlayer.world.spawnEntity(
	                      new EntityXPOrb(thePlayer.world, thePlayer.posX, 
	                            thePlayer.posY + 0.5D, thePlayer.posZ + 0.5D, 
	                            expInOrb));
	            }
	        }

	        numFermenterOutput = 0;
	    }
	}