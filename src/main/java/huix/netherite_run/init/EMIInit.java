package huix.netherite_run.init;

import dev.emi.emi.EmiRenderHelper;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.EmiRecipeSorting;
import dev.emi.emi.api.render.EmiRenderable;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.runtime.EmiDrawContext;
import dev.emi.emi.runtime.EmiReloadLog;
import huix.netherite_run.emi.EmiSmithingRecipe;
import huix.netherite_run.emi.SmithingRecipeHandler;
import huix.netherite_run.game_objects.inventory.container.SmithingTableContainer;
import huix.netherite_run.game_objects.recipe.SmithingRecipe;
import huix.netherite_run.game_objects.recipe.SmithingRecipeManager;
import net.minecraft.IRecipe;
import net.minecraft.ResourceLocation;

import java.util.function.Supplier;

@EmiEntrypoint
public class EMIInit implements EmiPlugin {
    public static EmiRecipeCategory SMITHING = new EmiRecipeCategory(new ResourceLocation("netherite:smithing"),
            EmiStack.of(RegistryInit.smithing_table), simplifiedRenderer(240, 240), EmiRecipeSorting.compareOutputThenInput());

    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(SMITHING);
        registry.addWorkstation(SMITHING, EmiStack.of(RegistryInit.smithing_table));
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
