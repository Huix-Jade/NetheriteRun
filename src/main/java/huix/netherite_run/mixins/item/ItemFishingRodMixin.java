package huix.netherite_run.mixins.item;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.Share;
import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.Icon;
import net.minecraft.ItemFishingRod;
import net.minecraft.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( ItemFishingRod.class )
public class ItemFishingRodMixin {
    @Shadow
    private Material hook_material;
    @Shadow
    private Icon[] uncastIcons;

    @Inject(method = "<init>",at = @At("RETURN"))
    private void injectInit(int par1, Material hook_material, CallbackInfo ci){
        this.uncastIcons = new Icon[10];
    }

    @Inject(method = "getMaterialOrdinal",at = @At("HEAD"), cancellable = true)
    private void injectGetMaterialOrdinal(CallbackInfoReturnable<Integer> cir){
        if (this.hook_material == NetheriteRunMaterial.netherite) {
            cir.setReturnValue(9);
        }
    }

    @Inject(method = "getMaterialByOrdinal",at = @At("HEAD"), cancellable = true)
    private void injectGetMaterialByOrdinal(CallbackInfoReturnable<Material> cir, @Local(argsOnly = true) int ordinal){
        if (ordinal == 9) {
            cir.setReturnValue(NetheriteRunMaterial.netherite);
        }
    }

}
