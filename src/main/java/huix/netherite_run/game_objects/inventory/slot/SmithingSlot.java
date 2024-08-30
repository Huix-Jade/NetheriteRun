package huix.netherite_run.game_objects.inventory.slot;

import huix.netherite_run.api.ISmithing;
import huix.netherite_run.game_objects.achievement.NetheriteAchievement;
import huix.netherite_run.game_objects.item.NetheriteRunItem;
import net.minecraft.EntityPlayer;
import net.minecraft.IInventory;
import net.minecraft.ItemStack;
import net.minecraft.Slot;

public class SmithingSlot extends Slot {
    private final EntityPlayer thePlayer;

    public SmithingSlot(EntityPlayer player, IInventory inventory, int slot_index, int display_x, int display_y) {
        super(inventory, slot_index, display_x, display_y);
        this.thePlayer = player;
    }

    @Override
    protected void onCrafting(ItemStack par1ItemStack, int par2) {
        this.onCrafting(par1ItemStack);
    }

    @Override
    protected void onCrafting(ItemStack par1ItemStack) {
        if (par1ItemStack.getItem() == NetheriteRunItem.netherite_hoe) {
            this.thePlayer.addStat(NetheriteAchievement.netherite_hoe, 1);
        }

        if (par1ItemStack.getItem() == NetheriteRunItem.netherite_pickaxe) {
            this.thePlayer.addStat(NetheriteAchievement.netherite_pickaxe, 1);
        }
    }

    @Override
    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {
        this.onCrafting(par2ItemStack);
        super.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
    }

    @Override
    public boolean isItemValid(ItemStack par1ItemStack) {
        return false;
    }


}
