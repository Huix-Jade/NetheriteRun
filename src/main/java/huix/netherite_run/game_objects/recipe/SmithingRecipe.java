package huix.netherite_run.game_objects.recipe;

import net.minecraft.ItemStack;

import java.util.List;

public class SmithingRecipe {
    public final List<ItemStack> recipe_input;
    private final ItemStack recipe_output;

    public SmithingRecipe(List<ItemStack> recipe_input, ItemStack recipe_output) {
        this.recipe_input = recipe_input;
        this.recipe_output = recipe_output;
    }


    public ItemStack getRecipeOutput() {
        return !this.recipe_input.isEmpty() ? this.recipe_output : null;
    }

    @Override
    public String toString() {
        return "SmithingRecipe {" + "recipe_input=" + recipe_input + ", recipe_output=" + recipe_output + '}';
    }
}
