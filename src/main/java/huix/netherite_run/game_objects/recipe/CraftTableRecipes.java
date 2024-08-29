package huix.netherite_run.game_objects.recipe;

import huix.netherite_run.game_objects.block.NetheriteRunBlock;
import huix.netherite_run.game_objects.item.NetheriteRunItem;
import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

public class CraftTableRecipes {

    public static void registerRecipes(RecipeRegistryEvent register) {
        register.registerShapedRecipe(new ItemStack(NetheriteRunBlock.smithing_table), false,
                "XX",
                "YY",
                "YY",
                'X', Item.ingotAncientMetal,
                'Y', Block.planks);

        register.registerShapelessRecipe(new ItemStack(NetheriteRunItem.netherite_ingot), false,
                Item.ingotGold, Item.ingotGold, Item.ingotGold,
                Item.ingotGold, NetheriteRunItem.netherite_scrap, NetheriteRunItem.netherite_scrap,
                NetheriteRunItem.netherite_scrap, NetheriteRunItem.netherite_scrap);

        register.registerShapelessRecipe(new ItemStack(NetheriteRunItem.netherite_nugget, 9),
                true, NetheriteRunItem.netherite_ingot);

        register.registerShapelessRecipe(new ItemStack(NetheriteRunItem.netherite_ingot),
                true,
                NetheriteRunItem.netherite_nugget, NetheriteRunItem.netherite_nugget, NetheriteRunItem.netherite_nugget,
                NetheriteRunItem.netherite_nugget, NetheriteRunItem.netherite_nugget, NetheriteRunItem.netherite_nugget,
                NetheriteRunItem.netherite_nugget, NetheriteRunItem.netherite_nugget, NetheriteRunItem.netherite_nugget);

        register.registerShapelessRecipe(new ItemStack(NetheriteRunBlock.netherite_block),true,
                NetheriteRunItem.netherite_ingot, NetheriteRunItem.netherite_ingot, NetheriteRunItem.netherite_ingot,
                NetheriteRunItem.netherite_ingot, NetheriteRunItem.netherite_ingot, NetheriteRunItem.netherite_ingot,
                NetheriteRunItem.netherite_ingot, NetheriteRunItem.netherite_ingot, NetheriteRunItem.netherite_ingot);
    }
}
