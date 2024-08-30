package huix.netherite_run.init;

import emi.dev.emi.emi.EmiRenderHelper;
import emi.dev.emi.emi.api.EmiEntrypoint;
import emi.dev.emi.emi.api.EmiPlugin;
import emi.dev.emi.emi.api.EmiRegistry;
import emi.dev.emi.emi.api.recipe.EmiRecipe;
import emi.dev.emi.emi.api.recipe.EmiRecipeCategory;
import emi.dev.emi.emi.api.recipe.EmiRecipeSorting;
import emi.dev.emi.emi.api.recipe.VanillaEmiRecipeCategories;
import emi.dev.emi.emi.api.render.EmiRenderable;
import emi.dev.emi.emi.api.stack.EmiStack;
import emi.dev.emi.emi.api.stack.TagEmiIngredient;
import emi.dev.emi.emi.recipe.EmiCookingRecipe;
import emi.dev.emi.emi.recipe.EmiTagRecipe;
import emi.dev.emi.emi.runtime.EmiDrawContext;
import emi.dev.emi.emi.runtime.EmiReloadLog;
import emi.shims.java.net.minecraft.registry.tag.TagKey;
import huix.netherite_run.emi.EmiSmithingRecipe;
import huix.netherite_run.emi.SmithingRecipeHandler;
import huix.netherite_run.game_objects.block.NetheriteRunBlock;
import huix.netherite_run.game_objects.inventory.container.SmithingTableContainer;
import huix.netherite_run.game_objects.recipe.SmithingRecipe;
import huix.netherite_run.game_objects.recipe.SmithingRecipeManager;
import net.minecraft.Block;
import net.minecraft.IRecipe;
import net.minecraft.ItemStack;
import net.minecraft.ResourceLocation;

import java.util.Iterator;
import java.util.function.Supplier;

@EmiEntrypoint
public class EMIInit implements EmiPlugin {
    public static EmiRecipeCategory SMITHING = new EmiRecipeCategory(new ResourceLocation("netherite:smithing"),
            EmiStack.of(NetheriteRunBlock.smithing_table), simplifiedRenderer(240, 240), EmiRecipeSorting.compareOutputThenInput());

    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(SMITHING);
        registry.addWorkstation(SMITHING, EmiStack.of(NetheriteRunBlock.smithing_table));
        registry.addRecipeHandler(SmithingTableContainer.class, new SmithingRecipeHandler());


        for (SmithingRecipe smithingRecipe : SmithingRecipeManager.instance.smithingRecipes) {
            addRecipeSafe(registry, () ->
                    new EmiSmithingRecipe(new ResourceLocation("minecraft", "oven/" + smithingRecipe.getRecipeOutput().itemID),
                            smithingRecipe.recipe_input, smithingRecipe.getRecipeOutput()));
        }

    }

    private static void addRecipeSafe(EmiRegistry registry, Supplier<EmiRecipe> supplier) {
        try {
            registry.addRecipe(supplier.get());
        }
        catch (Throwable e) {
            EmiReloadLog.warn("Exception when parsing EMI recipe (no ID available)");
            EmiReloadLog.error(e);
        }
    }

    private static void addRecipeSafe(EmiRegistry registry, Supplier<EmiRecipe> supplier, IRecipe recipe) {
        try {
            registry.addRecipe(supplier.get());
        }
        catch (Throwable e) {
            EmiReloadLog.warn("Exception when parsing vanilla recipe " + recipe);
            EmiReloadLog.error(e);
        }
    }

    private static EmiRenderable simplifiedRenderer(int u, int v) {
        return (raw, x, y, delta) -> {
            EmiDrawContext context = EmiDrawContext.wrap(raw);
            context.drawTexture(EmiRenderHelper.WIDGETS, x, y, u, v, 16, 16);
        };
    }
}
