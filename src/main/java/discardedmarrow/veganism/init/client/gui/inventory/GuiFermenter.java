package discardedmarrow.veganism.init.client.gui.inventory;

import discardedmarrow.veganism.Reference;
import discardedmarrow.veganism.init.inventory.ContainerFermenter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiFermenter  extends GuiContainer
{
    private static final ResourceLocation fermenterGuiTextures = 
         new ResourceLocation(Reference.MODID
               +":textures/gui/container/fermenter.png");
    private final InventoryPlayer inventoryPlayer;
    private final IInventory tileFermenter;

    public GuiFermenter(InventoryPlayer parInventoryPlayer, 
          IInventory parInventoryGrinder)
    {
        super(new ContainerFermenter(parInventoryPlayer, 
              parInventoryGrinder));
        inventoryPlayer = parInventoryPlayer;
        tileFermenter = parInventoryGrinder;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = tileFermenter.getDisplayName().getUnformattedText();
        fontRenderer.drawString(s, xSize/2-fontRenderer
              .getStringWidth(s)/2, 6, 4210752);
        fontRenderer.drawString(inventoryPlayer.getDisplayName()
              .getUnformattedText(), 8, ySize - 96 + 2, 4210752);
        drawHoveringText(String.format("X: %1$s Y: %2$s", mouseX-guiLeft, mouseY - guiTop) ,mouseX - guiLeft, mouseY - guiTop);
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, 
          int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(fermenterGuiTextures);
        int marginHorizontal = (width - xSize) / 2;
        int marginVertical = (height - ySize) / 2;
        drawTexturedModalRect(marginHorizontal, marginVertical, 0, 0, 
              xSize, ySize);

        // Draw progress indicator
        int progressLevel = getProgressLevel(24);
        drawTexturedModalRect(marginHorizontal + 79, marginVertical + 34, 
              176, 14, progressLevel + 1, 16);
    }

    private int getProgressLevel(int progressIndicatorPixelWidth)
    {
        int ticksFermentingItemSoFar = tileFermenter.getField(2); 
        int ticksPerItem = tileFermenter.getField(3);
        return ticksPerItem != 0 && ticksFermentingItemSoFar != 0 ? 
              ticksFermentingItemSoFar*progressIndicatorPixelWidth/ticksPerItem 
              : 0;
    }
 }