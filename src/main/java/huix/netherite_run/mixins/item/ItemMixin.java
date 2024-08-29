package huix.netherite_run.mixins.item;

import huix.netherite_run.game_objects.item.NetheriteRunItem;
import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.Item;
import net.minecraft.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( Item.class )
public class ItemMixin {

    @Inject(method = "getRepairItem", at = @At("HEAD"), cancellable = true)
    public void injectVibraniumRepair(CallbackInfoReturnable<Item> cir) {
        if (this.getMaterialForRepairs() == NetheriteRunMaterial.netherite) cir.setReturnValue(NetheriteRunItem.netherite_nugget);
    }

    @Shadow
    public Material getMaterialForRepairs() {
        return null;
    }
}
