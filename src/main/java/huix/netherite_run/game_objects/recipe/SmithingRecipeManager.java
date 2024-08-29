package huix.netherite_run.game_objects.recipe;

import huix.netherite_run.game_objects.item.NetheriteRunItem;
import net.minecraft.Item;
import net.minecraft.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SmithingRecipeManager {

    public static final SmithingRecipeManager instance = new SmithingRecipeManager();

    public List<SmithingRecipe> smithingRecipes = new ArrayList<>();

    private SmithingRecipeManager() {
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_axe),
                new ItemStack(Item.axeMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_battle_axe),
                new ItemStack(Item.battleAxeMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_chestplate),
                new ItemStack(Item.plateMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_dagger),
                new ItemStack(Item.daggerMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_boots),
                new ItemStack(Item.bootsMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_helmet),
                new ItemStack(Item.helmetMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_leggings),
                new ItemStack(Item.legsMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_pickaxe),
                new ItemStack(Item.pickaxeMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_shovel),
                new ItemStack(Item.shovelMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_sword),
                new ItemStack(Item.swordMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_war_hammer),
                new ItemStack(Item.warHammerMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_scythe),
                new ItemStack(Item.scytheMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_mattock),
                new ItemStack(Item.mattockMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_hoe),
                new ItemStack(Item.hoeMithril), new ItemStack(NetheriteRunItem.netherite_ingot));
        this.addSmithingRecipe(new ItemStack(NetheriteRunItem.netherite_hatchet),
                new ItemStack(Item.hatchetMithril), new ItemStack(NetheriteRunItem.netherite_ingot));

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
