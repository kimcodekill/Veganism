package discardedmarrow.veganism.init.inventory;

import discardedmarrow.veganism.init.tileentity.TileEntityFermenter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;

public class ContainerFermenter extends Container{

	private final IInventory tileFermenter;
    private final int sizeInventory;
    private int ticksFermentingItemSoFar;
    private int ticksPerItem;
    private int timeCanFerment;

	
	public ContainerFermenter(InventoryPlayer playerInventory, IInventory inventory) {        
        tileFermenter = inventory;
        sizeInventory = tileFermenter.getSizeInventory();
        addSlotToContainer(new Slot(tileFermenter, 
              TileEntityFermenter.slotEnum.INPUT_SLOT_LEFT.ordinal(), 47, 16));
        addSlotToContainer(new Slot(tileFermenter, 
                TileEntityFermenter.slotEnum.INPUT_SLOT_RIGHT.ordinal(), 113, 16));
        addSlotToContainer(new SlotFermenterOutput(playerInventory.player, 
              tileFermenter, TileEntityFermenter.slotEnum.OUTPUT_SLOT.ordinal(), 
              80, 51));
        
        // add player inventory slots
        // note that the slot numbers are within the player inventory so can 
        // be same as the tile entity inventory
        int i;
        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                addSlotToContainer(new Slot(playerInventory, j+i*9+9, 
                8+j*18, 84+i*18));
            }
        }

        // add hotbar slots
        for (i = 0; i < 9; ++i)
        {
            addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 
            142));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}

}
