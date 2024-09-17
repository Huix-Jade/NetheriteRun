package huix.netherite_run.event;

import com.google.common.eventbus.Subscribe;
import huix.netherite_run.game_objects.achievement.NetheriteAchievement;
import huix.netherite_run.game_objects.recipe.CraftTableRecipes;
import huix.netherite_run.game_objects.tileentity.SmithingTableTileEntity;
import huix.netherite_run.init.RegistryInit;
import net.minecraft.FurnaceRecipes;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.reload.event.*;


public class NetheriteRunEvents {

    @Subscribe
    public void onRecipeRegister(RecipeRegistryEvent event){
        CraftTableRecipes.registerRecipes(event);
        FurnaceRecipes.smelting().addSmelting(RegistryInit.ancient_debris.blockID, new ItemStack(RegistryInit.netherite_scrap));
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
