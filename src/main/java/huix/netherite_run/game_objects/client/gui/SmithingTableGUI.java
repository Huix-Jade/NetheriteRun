package huix.netherite_run.game_objects.client.gui;

import huix.netherite_run.game_objects.inventory.container.SmithingTableContainer;
import huix.netherite_run.game_objects.tileentity.SmithingTableTileEntity;
import net.minecraft.*;
import org.lwjgl.opengl.GL11;

public class SmithingTableGUI extends GuiContainer {

    private static final ResourceLocation smithing_table_gui = new ResourceLocation("textures/gui/smithing_table.png");

    private final SmithingTableTileEntity tileEntity;

    public SmithingTableGUI(EntityPlayer player, SmithingTableTileEntity smithingTableTile) {
        super(new SmithingTableContainer(player, smithingTableTile));

        this.tileEntity = smithingTableTile;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(smithing_table_gui);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        //Args: x, y, u, v, width, height
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        int progress = this.tileEntity.getBuildProgressScaled(24);
        this.drawTexturedModalRect(x + 68, y + 49, 176, 0, progress, 16);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String text = I18n.getString("smithing.update");
        this.fontRenderer.drawString(text, 40, 20, 4210752);
        this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
}
