package huix.netherite_run.game_objects.tileentity;

import com.google.common.collect.Lists;
import huix.netherite_run.game_objects.block.SmithingTableBlock;
import huix.netherite_run.game_objects.recipe.SmithingRecipe;
import huix.netherite_run.game_objects.recipe.SmithingRecipeManager;
import net.minecraft.*;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

public class SmithingTableTileEntity extends TileEntity implements IInventory {

    public ItemStack[] contents = new ItemStack[4];

    public int build_time;

    public SmithingRecipe current_recipe;

    public int getBuildProgressScaled(int scaled) {
        return this.build_time * scaled / 800;
    }

    private void identifyRecipe() {
        if (this.current_recipe == null && this.contents[1] != null) {
            for (SmithingRecipe recipe : SmithingRecipeManager.instance.smithingRecipes) {
                for (ItemStack stack : recipe.recipe_input) {
                    if (ItemStack.areItemStacksEqual(stack, contents[1],
                            true, false, false, true)) {
                        this.current_recipe = recipe;
                        break;
                    }
                 }
            }
        }
    }

    @Override
    public void updateEntity() {
        if (this.contents[1] == null || this.contents[3] != null) {
            this.clearBuildTime();
            return;
        }

        if (this.current_recipe == null)
            this.identifyRecipe();

        if (this.current_recipe != null) {
            if (this.current_recipe.recipe_input.size() - 1 == 1) {
                if (contents[0] != null && contents[2] != null) {
                    this.clearBuildTime();
                    return;
                }
            } else {
                if (contents[0] == null && contents[2] == null) {
                    this.clearBuildTime();
                    return;
                }
            }

            if (this.getRunnableStacks(this.current_recipe).isEmpty()) {
                this.build_time++;
                if (this.build_time == 800) {
                    ItemStack result = this.current_recipe.getRecipeOutput().copy();
                    this.contents[3] = result;
                    this.costItems(this.current_recipe);
                    this.current_recipe = null;
                }
            } else {
                this.clearBuildTime();
            }
        }
    }

    private void clearBuildTime() {
        if (this.build_time != 0)
            this.build_time = 0;
    }

    private List<ItemStack> getRunnableStacks(@Nonnull SmithingRecipe recipe) {
        List<ItemStack> currentStacks = Lists.newArrayList(contents[0], contents[1], contents[2]);
        List<ItemStack> requiredStacks = Lists.newArrayList(recipe.recipe_input);
        requiredStacks.removeIf((req) -> currentStacks.stream().anyMatch((current)
                -> ItemStack.areItemStacksEqual(req, current,
                true, false, false, true) && current.stackSize >= req.stackSize));
        return requiredStacks;
    }

    private void costItems(@Nonnull SmithingRecipe recipe) {
        List<ItemStack> requiredStacks = recipe.recipe_input;

        for (int i = 0; i <= 3; i++) {
            for (ItemStack requiredStack : requiredStacks) {
                if (contents[i] != null && ItemStack.areItemStacksEqual
                        (requiredStack, contents[i], true, false, false, true)) {
                    int resultSize = contents[i].stackSize - requiredStack.stackSize;
                    if (resultSize > 0) {
                        contents[i].setStackSize(resultSize);
                    } else {
                        contents[i] = null;
                    }
                }
            }
        }
    }

    @Override
    public int getSizeInventory() {
        return this.contents.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.contents[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.contents[i] != null) {
            ItemStack itemStack;

            if (this.contents[i].stackSize <= j) {
                itemStack = this.contents[i];
                this.contents[i] = null;
            } else {
                itemStack = this.contents[i].splitStack(j);

                if (this.contents[i].stackSize == 0) {
                    this.contents[i] = null;
                }

            }
            this.onInventoryChanged();
            return itemStack;
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.contents[i] != null) {
            ItemStack stack = this.contents[i];
            this.contents[i] = null;
            return stack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        this.contents[i] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }

        this.onInventoryChanged();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return  entityPlayer.getWorld().getBlock(this.xCoord, this.yCoord, this.zCoord) instanceof SmithingTableBlock
                && entityPlayer.getWorld().getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) instanceof SmithingTableTileEntity
                && entityPlayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }


    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList tagList = par1NBTTagCompound.getTagList("Items");
        this.contents = new ItemStack[this.getSizeInventory()];
        for(int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagAt = (NBTTagCompound)tagList.tagAt(i);
            byte aByte = tagAt.getByte("Slot");
            if (aByte >= 0 && aByte < this.contents.length) {
                this.contents[aByte] = ItemStack.loadItemStackFromNBT(tagAt);
            }
        }

    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagList nbtTagList = new NBTTagList();
        for(int i = 0; i < this.contents.length; ++i) {
            if (this.contents[i] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)i);
                this.contents[i].writeToNBT(var4);
                nbtTagList.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", nbtTagList);
    }

    @Override
    public void openChest() {}

    @Override
    public void closeChest() {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return true;
    }

    @Override
    public void destroyInventory() {
        Arrays.fill(this.contents, null);
    }
}
