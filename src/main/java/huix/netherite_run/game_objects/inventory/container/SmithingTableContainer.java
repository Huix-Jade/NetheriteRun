package huix.netherite_run.game_objects.inventory.container;

import huix.netherite_run.api.ISmithing;
import huix.netherite_run.game_objects.inventory.slot.SmithingSlot;
import huix.netherite_run.game_objects.tileentity.SmithingTableTileEntity;
import net.minecraft.*;

public class SmithingTableContainer extends Container {

    private final SmithingTableTileEntity tableTileEntity;

    public SmithingTableContainer(EntityPlayer player, SmithingTableTileEntity smithingTableTile) {
        super(player);
        this.tableTileEntity = smithingTableTile;

        this.addSlotToContainer(new Slot(smithingTableTile, 0, 8, 48));
        this.addSlotToContainer(new Slot(smithingTableTile, 1, 26, 48) {
            public boolean isItemValid(ItemStack par1ItemStack) {
                return par1ItemStack.getItem() instanceof ItemTool || par1ItemStack.getItem() instanceof ItemArmor;
            }
        });
        this.addSlotToContainer(new Slot(smithingTableTile, 2, 44, 48){
            public boolean isItemValid(ItemStack par1ItemStack) {
                return par1ItemStack.getItem() instanceof ISmithing;
            }
        });

        this.addSlotToContainer(new SmithingSlot(player, smithingTableTile, 3, 98, 48));


        int i;
        for (int j = 0; j < 3; ++j) {
            for (i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(player.inventory, i + j * 9 + 9, 8 + i * 18, 84 + j * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
        }
    }

    public int getSmithingItemSlotIndex() {
        return 2;
    }

    public int getToolItemSlotIndex(){
        return 1;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            ItemStack[] slots = this.tableTileEntity.contents;
            if (index < slots.length){
                if (!this.mergeItemStack(itemstack1, slots.length, this.inventorySlots.size(), false)){
                    return null;
                }

                slot.onSlotChanged();
            } else {
                if (itemstack1.getItem() instanceof ItemTool || itemstack1.getItem() instanceof ItemArmor){
                    if (!this.mergeItemStack(itemstack1, this.getToolItemSlotIndex(),this.getToolItemSlotIndex() + 1,false)){
                        if (!this.mergeItemStack(itemstack1,0, slots.length,false)){
                            return null;
                        }

                        slot.onSlotChanged();
                    }
                } else if (itemstack1.getItem() instanceof ISmithing){
                    if (!this.mergeItemStack(itemstack1, this.getSmithingItemSlotIndex(), this.getSmithingItemSlotIndex() + 1,false)){
                        if (!this.mergeItemStack(itemstack1,0, slots.length,false)){
                            return null;
                        }

                        slot.onSlotChanged();
                    }
                } else {
                    if (!this.mergeItemStack(itemstack1,0, slots.length,false)){
                        return null;
                    }

                    slot.onSlotChanged();
                }
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.tableTileEntity.isUseableByPlayer(entityPlayer);
    }
}
