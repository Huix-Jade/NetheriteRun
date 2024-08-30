package huix.netherite_run.event;

import com.google.common.eventbus.Subscribe;
import huix.netherite_run.game_objects.achievement.NetheriteAchievement;
import huix.netherite_run.game_objects.item.NetheriteRunItem;
import huix.netherite_run.game_objects.recipe.CraftTableRecipes;
import huix.netherite_run.game_objects.recipe.SmithingRecipeManager;
import huix.netherite_run.game_objects.tileentity.SmithingTableTileEntity;
import net.minecraft.FurnaceRecipes;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.reload.event.*;
import huix.netherite_run.game_objects.block.NetheriteRunBlock;


public class NetheriteRunEvents {

    @Subscribe
    public void onItemRegister(ItemRegistryEvent event){
        NetheriteRunBlock.registerItemBlocks(event);
        NetheriteRunItem.registerItems(event);
    }

    @Subscribe
    public void onRecipeRegister(RecipeRegistryEvent event){
        CraftTableRecipes.registerRecipes(event);
        FurnaceRecipes.smelting().addSmelting(NetheriteRunBlock.ancient_debris.blockID, new ItemStack(NetheriteRunItem.netherite_scrap));
    }

    @Subscribe
    public void onAchievementRegister(AchievementRegistryEvent event){
        NetheriteAchievement.registerAchievements();
    }

    @Subscribe
    public void onTileEntityRegister(TileEntityRegisterEvent event){
        event.register(SmithingTableTileEntity.class, "SmithingTable");
    }
}
