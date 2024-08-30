package huix.netherite_run.emi;

import com.google.common.collect.Lists;
import emi.dev.emi.emi.EmiPort;
import emi.dev.emi.emi.api.recipe.EmiRecipe;
import emi.dev.emi.emi.api.recipe.EmiRecipeCategory;
import emi.dev.emi.emi.api.stack.EmiIngredient;
import emi.dev.emi.emi.api.stack.EmiStack;
import emi.dev.emi.emi.api.widget.WidgetHolder;
import emi.shims.java.com.unascribed.retroemi.RetroEMI;
import emi.shims.java.net.minecraft.client.gui.tooltip.TooltipComponent;
import huix.netherite_run.init.EMIInit;
import net.minecraft.ItemStack;
import net.minecraft.ResourceLocation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmiSmithingRecipe implements EmiRecipe {
	private final ResourceLocation id;
	protected final List<EmiIngredient> input;
	private final EmiStack output;

	public EmiSmithingRecipe(ResourceLocation id, List<ItemStack> input, ItemStack output) {
		this.id = id;
		this.input = input.stream().map(RetroEMI::wildcardIngredient).collect(Collectors.toList());
		this.output = EmiStack.of(output);
	}
	
	@Override
	public EmiRecipeCategory getCategory() {
		return EMIInit.SMITHING;
	}
	
	@Override
	public ResourceLocation getId() {
		return id;
	}
	
	@Override
	public List<EmiIngredient> getInputs() {
		return input;
	}
	
	@Override
	public List<EmiStack> getOutputs() {
		return List.of(output);
	}
	
	@Override
	public int getDisplayWidth() {
		return 120;
	}
	
	@Override
	public int getDisplayHeight() {
		return 30;
	}
	
	@Override
	public void addWidgets(WidgetHolder widgets) {
		int i = 0;
		for (EmiIngredient ingredient : input) {
			widgets.addSlot(ingredient, 10 + i, 5).recipeContext(this);
			i+=20;
		}

		if (this.input.size() == 2)
			widgets.addSlot(EmiStack.EMPTY, 50, 5).recipeContext(this);

		widgets.addFillingArrow(72, 6, 50 * 800).tooltip((mx, my)
				-> List.of(TooltipComponent.of(EmiPort.ordered(EmiPort.translatable("emi.smithing.time", 800 / 20)))));
		widgets.addSlot(output, 100, 5).recipeContext(this);
	}
}
