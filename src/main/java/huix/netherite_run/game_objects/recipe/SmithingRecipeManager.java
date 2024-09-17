package huix.netherite_run.game_objects.recipe;

import huix.netherite_run.init.RegistryInit;
import net.minecraft.Item;
import net.minecraft.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SmithingRecipeManager {

    public static final SmithingRecipeManager instance = new SmithingRecipeManager();

    public List<SmithingRecipe> smithingRecipes = new ArrayList<>();

    private SmithingRecipeManager() {
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_axe),
                new ItemStack(Item.axeMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_battle_axe),
                new ItemStack(Item.battleAxeMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_chestplate),
                new ItemStack(Item.plateMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_dagger),
                new ItemStack(Item.daggerMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_boots),
                new ItemStack(Item.bootsMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_helmet),
                new ItemStack(Item.helmetMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_leggings),
                new ItemStack(Item.legsMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_pickaxe),
                new ItemStack(Item.pickaxeMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_shovel),
                new ItemStack(Item.shovelMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_sword),
                new ItemStack(Item.swordMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_war_hammer),
                new ItemStack(Item.warHammerMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_scythe),
                new ItemStack(Item.scytheMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_mattock),
                new ItemStack(Item.mattockMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_hoe),
                new ItemStack(Item.hoeMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_hatchet),
                new ItemStack(Item.hatchetMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_shears),
                new ItemStack(Item.shearsMithril), new ItemStack(RegistryInit.netherite_ingot));

        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_fish_rod),
                new ItemStack(Item.fishingRodMithril), new ItemStack(RegistryInit.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(RegistryInit.netherite_bow),
                new ItemStack(Item.bowMithril), new ItemStack(RegistryInit.netherite_ingot));
    }


    public void addSmithingRecipe(ItemStack recipe_output, Object ... objects) {
        ArrayList<ItemStack> list = new ArrayList<>();
        for (Object o : objects) {
            if (o instanceof ItemStack itemStack) {
                list.add(itemStack);
            }
        }

        this.smithingRecipes.add(new SmithingRecipe(list, recipe_output));
    }

}
