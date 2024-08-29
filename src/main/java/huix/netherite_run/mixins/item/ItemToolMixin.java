package huix.netherite_run.mixins.item;

import huix.netherite_run.game_objects.item.NetheriteRunItem;
import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.ItemTool;
import net.minecraft.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( ItemTool.class )
public class ItemToolMixin {

    @Shadow
    private Material effective_material;
    @Inject(method = "getMaterialHarvestEfficiency", at = @At("HEAD"), cancellable = true)
    public void injectNetheriteHarvestEfficiency(CallbackInfoReturnable<Float> cir) {
        if (this.effective_material == NetheriteRunMaterial.netherite) {
            cir.setReturnValue(3.3F);
        }
    }
}
