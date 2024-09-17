package huix.netherite_run.game_objects.recipe;

import huix.netherite_run.init.RegistryInit;
import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemCoin;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

public class CraftTableRecipes {

    public static void registerRecipes(RecipeRegistryEvent register) {
        register.registerShapedRecipe(new ItemStack(RegistryInit.smithing_table), false,
                "XX",
                "YY",
                "YY",
                'X', Item.ingotAncientMetal,
                'Y', Block.planks);

        register.registerShapedRecipe(new ItemStack(RegistryInit.netherite_arrow), false,
                "Z",
                "X",
                "Y",
                'X', Item.stick,
                'Y', Item.feather,
                'Z', RegistryInit.netherite_nugget);

        register.registerShapelessRecipe(new ItemStack(RegistryInit.netherite_nugget),
                true, RegistryInit.netherite_arrow);

        register.registerShapelessRecipe(new ItemStack(RegistryInit.netherite_ingot), false,
                Item.ingotGold, Item.ingotGold, Item.ingotGold,
                Item.ingotGold, RegistryInit.netherite_scrap, RegistryInit.netherite_scrap,
                RegistryInit.netherite_scrap, RegistryInit.netherite_scrap);

        register.registerShapelessRecipe(new ItemStack(RegistryInit.netherite_nugget, 9),
                true, RegistryInit.netherite_ingot);

        register.registerShapelessRecipe(new ItemStack(RegistryInit.netherite_ingot),
                true,
                RegistryInit.netherite_nugget, RegistryInit.netherite_nugget, RegistryInit.netherite_nugget,
                RegistryInit.netherite_nugget, RegistryInit.netherite_nugget, RegistryInit.netherite_nugget,
                RegistryInit.netherite_nugget, RegistryInit.netherite_nugget, RegistryInit.netherite_nugget);

        register.registerShapelessRecipe(new ItemStack(RegistryInit.netherite_block),true,
                RegistryInit.netherite_ingot, RegistryInit.netherite_ingot, RegistryInit.netherite_ingot,
                RegistryInit.netherite_ingot, RegistryInit.netherite_ingot, RegistryInit.netherite_ingot,
                RegistryInit.netherite_ingot, RegistryInit.netherite_ingot, RegistryInit.netherite_ingot);

        ItemCoin[] itemCoins = new ItemCoin[] {RegistryInit.netherite_coin};

        for (ItemCoin coin : itemCoins) {
            for (int i = 1; i <= 9; ++i) {
                register.registerShapelessRecipe(new ItemStack(coin.getNuggetPeer(), i),
                        true, new ItemStack(coin, i)).difficulty(25F);
            }

            register.registerShapelessRecipe(new ItemStack(coin), false,
                    new ItemStack(coin.getNuggetPeer())).difficulty(100F);
        }
    }
}
