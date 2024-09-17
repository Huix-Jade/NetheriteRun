package huix.netherite_run.emi;

import com.google.common.collect.Lists;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.handler.StandardRecipeHandler;
import huix.netherite_run.game_objects.inventory.container.SmithingTableContainer;
import huix.netherite_run.init.EMIInit;
import net.minecraft.ContainerWorkbench;
import net.minecraft.Slot;

import java.util.List;

public class SmithingRecipeHandler implements StandardRecipeHandler<SmithingTableContainer> {

    @Override
    public List<Slot> getInputSources(SmithingTableContainer handler) {
        List<Slot> list = Lists.newArrayList();
        for (int i = 1; i < 3; i++) {
            list.add(handler.getSlot(i));
        }
        int invStart = 3;
        for (int i = invStart; i < invStart + 36; i++) {
            list.add(handler.getSlot(i));
        }
        return list;
    }

    @Override
    public List<Slot> getCraftingSlots(SmithingTableContainer handler) {
        List<Slot> list = Lists.newArrayList();
        for (int i = 1; i < 3; i++) {
            list.add(handler.getSlot(i));
        }
        return list;
    }

    @Override
    public boolean supportsRecipe(EmiRecipe emiRecipe) {
        return emiRecipe.getCategory() == EMIInit.SMITHING && emiRecipe.supportsRecipeTree();
    }
}
