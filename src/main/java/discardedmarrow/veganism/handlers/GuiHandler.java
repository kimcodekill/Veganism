package discardedmarrow.veganism.handlers;

import discardedmarrow.veganism.init.client.gui.inventory.GuiFermenter;
import discardedmarrow.veganism.init.inventory.ContainerFermenter;
import discardedmarrow.veganism.init.util.EnumGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, 
          World world, int x, int y, int z) 
    { 
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        if (tileEntity != null)
        {
            if (ID == EnumGui.FERMENTER.ordinal())
            {
                return new ContainerFermenter(player.inventory, (IInventory)tileEntity);
            }   
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, 
          World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        if (tileEntity != null)
        {
            if (ID == EnumGui.FERMENTER.ordinal())
            {
                return new GuiFermenter(player.inventory, 
                      (IInventory)tileEntity);
            }
        }
        return null;
    }
}