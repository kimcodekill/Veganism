package discardedmarrow.veganism.init.tileentity;

import discardedmarrow.veganism.init.crafting.FermenterRecipes;
import discardedmarrow.veganism.init.inventory.ContainerFermenter;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityFermenter extends TileEntityLockable implements ITickable, ISidedInventory  {
	
	public enum slotEnum
	{
		INPUT_SLOT_LEFT,
		INPUT_SLOT_RIGHT,
		OUTPUT_SLOT
	}
	
	private static final int[] slotsTop = new int[] {
			slotEnum.INPUT_SLOT_LEFT.ordinal(), slotEnum.INPUT_SLOT_RIGHT.ordinal()};
	private static final int[] slotsBottom = new int[] {
	        slotEnum.OUTPUT_SLOT.ordinal()};
	private static final int[] slotsSides = new int[] {};
	private NonNullList<ItemStack> fermenterItemStacks = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
	private int timeCanFerment; 
	private int currentItemFermentTime;
	private int ticksFermentingItemSoFar;
	private int ticksPerItem;
	private String fermenterCustomName;

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return false;
	}
	
	@Override
	public int getSizeInventory() {
		
		return fermenterItemStacks.size();
	}

	@Override
	public boolean isEmpty()
    {
        for (ItemStack itemstack : this.fermenterItemStacks)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

	@Override
	public ItemStack getStackInSlot(int index) {
		
		return fermenterItemStacks.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return fermenterItemStacks.get(index);
//		if (fermenterItemStacks.get(index) != null)
//        {
//            ItemStack itemstack;
//
//            if (fermenterItemStacks.get(index).getCount() <= count)
//            {
//                itemstack = fermenterItemStacks.get(index);
//                fermenterItemStacks.set(index, null);
//                return itemstack;
//            }
//            else
//            {
//                
//            }
//        }
//        else
//        {
//            return null;
//        }
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.fermenterItemStacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		boolean isSameItemStackAlreadyInSlot = stack != null 
	              && stack.isItemEqual(fermenterItemStacks.get(index)) 
	              && ItemStack.areItemStackTagsEqual(stack, 
	                    fermenterItemStacks.get(index));
	        fermenterItemStacks.set(index, stack);

	        if (stack != null && stack.getCount() > getInventoryStackLimit())
	        {
	            stack.setCount(getInventoryStackLimit());
	        }

	        // if input slot, reset the grinding timers
	        if ((index == slotEnum.INPUT_SLOT_LEFT.ordinal() || index == slotEnum.INPUT_SLOT_RIGHT.ordinal()) 
	              && !isSameItemStackAlreadyInSlot)
	        {
	            ticksPerItem = timeToFermentOneItem(stack);
	            ticksFermentingItemSoFar = 0;
	            markDirty();
	        }
	}

	@Override
	public int getInventoryStackLimit() {

		return 64;
	}
	
	public boolean fermentingSomething()
    {
        return true;
    }

	@Override
    public boolean isUsableByPlayer(EntityPlayer playerIn)
    {
        return world.getTileEntity(pos) != this ? false : 
              playerIn.getDistanceSq(pos.getX()+0.5D, pos.getY()+0.5D, 
              pos.getZ()+0.5D) <= 64.0D;
    }

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
		if (stack.getItem() == Items.SUGAR && index == slotEnum.INPUT_SLOT_LEFT.ordinal())
			return true;
		else
		    return index == slotEnum.INPUT_SLOT_RIGHT.ordinal() ? true : false;
        
    }

	@Override
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return timeCanFerment;
            case 1:
                return currentItemFermentTime;
            case 2:
                return ticksFermentingItemSoFar;
            case 3:
                return ticksPerItem;
            default:
                return 0;
        }
    }

	@Override
    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                timeCanFerment = value;
                break;
            case 1:
                currentItemFermentTime = value;
                break;
            case 2:
                ticksFermentingItemSoFar = value;
                break;
            case 3:
                ticksPerItem = value;
                break;
        default:
            break;
        }
    }

	@Override
    public int getFieldCount()
    {
        return 4;
    }

	@Override
	public void clear() {
		for (int i = 0; i < fermenterItemStacks.size(); ++i)
        {
            fermenterItemStacks.set(i, null);
        }
	}

	@Override
    public String getName()
    {
        return hasCustomName() ? fermenterCustomName : "container.fermenter";
    }

	@Override
	public boolean hasCustomName() {
		
		return false;
	}
	
	public void setCustomInventoryName(String CustomName)
    {
        fermenterCustomName = CustomName;
    }
	
	@Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        fermenterItemStacks = NonNullList.<ItemStack>withSize(getSizeInventory(), null);

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbtTagCompound = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbtTagCompound.getByte("Slot");

            if (b0 >= 0 && b0 < fermenterItemStacks.size())
            {
                fermenterItemStacks.set(i, new ItemStack(
                        nbtTagCompound));
            }
        }

        timeCanFerment = compound.getShort("GrindTime");
        ticksFermentingItemSoFar = compound.getShort("CookTime");
        ticksPerItem = compound.getShort("CookTimeTotal");

        if (compound.hasKey("CustomName", 8))
        {
            fermenterCustomName = compound.getString("CustomName");
        }
    }
	
	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setShort("GrindTime", (short)timeCanFerment);
        compound.setShort("CookTime", (short)ticksFermentingItemSoFar);
        compound.setShort("CookTimeTotal", (short)ticksPerItem);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < fermenterItemStacks.size(); ++i)
        {
            if (fermenterItemStacks.get(i) != null)
            {
                NBTTagCompound nbtTagCompound = new NBTTagCompound();
                nbtTagCompound.setByte("Slot", (byte)i);
                fermenterItemStacks.get(i).writeToNBT(nbtTagCompound);
                nbttaglist.appendTag(nbtTagCompound);
            }
        }

        compound.setTag("Items", nbttaglist);

        if (hasCustomName())
        {
            compound.setString("CustomName", fermenterCustomName);
        }
		return compound;
    }
	
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		
		return new ContainerFermenter(playerInventory, this);
	}

	@Override
    public String getGuiID()
    {
        return "veganism:fermenter";
    }

	@Override
    public int[] getSlotsForFace(EnumFacing side)
    {
        return side == EnumFacing.DOWN ? slotsBottom : 
              (side == EnumFacing.UP ? slotsTop : slotsSides);
    }
	
	@Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return isItemValidForSlot(index, itemStackIn);
    }

	@Override
	public boolean canExtractItem(int slotlotIndex, ItemStack stack, EnumFacing facing)
	{
		return true;
	}

	@Override
	public void tick() {
        boolean changedFermentingState = false;

        if (fermentingSomething())
        {
            --timeCanFerment;
        }

        if (!world.isRemote)
        {
            // if something in input slot
            if (fermenterItemStacks.get(slotEnum.INPUT_SLOT_LEFT.ordinal()) != null 
            		&& fermenterItemStacks.get(slotEnum.INPUT_SLOT_RIGHT.ordinal()) != null)
            {                
                 // start grinding
                if (!fermentingSomething() && canFerment())
                {
                     timeCanFerment = 150;
    
                     if (fermentingSomething())
                     {
                         changedFermentingState = true;
                     }
                }

                // continue grinding
                if (fermentingSomething() && canFerment())
                {
                    ++ticksFermentingItemSoFar;
                    
                    // check if completed grinding an item
                    if (ticksFermentingItemSoFar == ticksPerItem)
                    {
                        ticksFermentingItemSoFar = 0;
                        ticksPerItem = timeToFermentOneItem(
                              fermenterItemStacks.get(0));
                        fermentItem();
                        changedFermentingState = true;
                    }
                }
                else
                {
                    ticksFermentingItemSoFar = 0;
                }
            }
        }

        if (changedFermentingState)
        {
            markDirty();
        }
		
	}

	public int timeToFermentOneItem(ItemStack parItemStack)
    {
        return 200;
    }
	
	private void fermentItem() {
		 if (canFerment())
	        {
	            ItemStack itemstack = FermenterRecipes.instance()
	                  .getFermentingResult(fermenterItemStacks.get(
	                        slotEnum.INPUT_SLOT_RIGHT.ordinal()));

	            // check if output slot is empty
	            if (fermenterItemStacks.get(slotEnum.OUTPUT_SLOT.ordinal()) == null)
	            {
	                fermenterItemStacks.set(slotEnum.OUTPUT_SLOT.ordinal(),itemstack.copy());
	            }
	            else if (fermenterItemStacks.get(slotEnum.OUTPUT_SLOT.ordinal())
	                  .getItem() == itemstack.getItem())
	            {
	                fermenterItemStacks.get(slotEnum.OUTPUT_SLOT.ordinal())
	                      .setCount(itemstack.getCount()); 
	            }

	            fermenterItemStacks.get(slotEnum.INPUT_SLOT_RIGHT.ordinal()).setCount(
	            		fermenterItemStacks.get(slotEnum.INPUT_SLOT_RIGHT.ordinal()).getCount()-1);

	            if (fermenterItemStacks.get(slotEnum.INPUT_SLOT_RIGHT.ordinal())
	                  .getCount() <= 0)
	            {
	                fermenterItemStacks.set(slotEnum.INPUT_SLOT_RIGHT.ordinal(), null);
	            }
	        }
	}

	private boolean canFerment() {
		// if nothing in input slot
        if (fermenterItemStacks.get(slotEnum.INPUT_SLOT_LEFT.ordinal()) == null
        		&& fermenterItemStacks.get(slotEnum.INPUT_SLOT_RIGHT.ordinal()) == null)
        {
            return false;
        }
        else // check if it has a grinding recipe
        {
            ItemStack itemStackToOutput = FermenterRecipes.instance()
                  .getFermentingResult(fermenterItemStacks.get(
                        slotEnum.INPUT_SLOT_RIGHT.ordinal()));
            if (itemStackToOutput == null) return false; 
            if (fermenterItemStacks.get(slotEnum.OUTPUT_SLOT.ordinal()) 
                  == null) return true; 
            if (!fermenterItemStacks.get(slotEnum.OUTPUT_SLOT.ordinal())
                 .isItemEqual(itemStackToOutput)) return false; 
            int result = fermenterItemStacks.get(slotEnum.OUTPUT_SLOT.ordinal())
                  .getCount() + itemStackToOutput.getCount();
            return result <= getInventoryStackLimit() 
                  && result <= fermenterItemStacks.get(slotEnum
                        .OUTPUT_SLOT.ordinal()).getMaxStackSize();
        }
	}
}
