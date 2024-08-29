package huix.netherite_run.mixins.item;

import huix.netherite_run.game_objects.item.NetheriteRunItem;
import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.ItemNugget;
import net.minecraft.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemNugget.class)
public class ItemNuggetMixin {

    @Inject(method = "getForMaterial", cancellable = true, at = @At("HEAD"))
    public void injectNetheriteNugget(Material material, CallbackInfoReturnable<ItemNugget> cir) {
        if (material == NetheriteRunMaterial.netherite){
            cir.setReturnValue(NetheriteRunItem.netherite_nugget);
        }
    }
}
