package huix.netherite_run.mixins.item;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.Share;
import huix.netherite_run.game_objects.item.NetheriteRunItem;
import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.Item;
import net.minecraft.ItemCoin;
import net.minecraft.Material;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( ItemCoin.class )
public class ItemCoinMixin extends Item {

    @Inject(method = "getExperienceValue",at = @At("HEAD"), cancellable = true)
    private void injectGetExperienceValue(CallbackInfoReturnable<Integer> cir){
        Material material = this.getExclusiveMaterial();
        if (material == NetheriteRunMaterial.netherite) {
            cir.setReturnValue(12500);
        }
    }

    @Inject(method = "getForMaterial",at = @At("HEAD"), cancellable = true)
    private static void injectGetForMaterial(Material material, CallbackInfoReturnable<ItemCoin> cir) {
        if (material == NetheriteRunMaterial.netherite) {
            cir.setReturnValue(NetheriteRunItem.netherite_coin);
        }
    }

    @Inject(method = "getNuggetPeer",at = @At(value = "INVOKE", target = "Lnet/minecraft/ItemCoin;getExclusiveMaterial()Lnet/minecraft/Material;",
            shift = At.Shift.AFTER), cancellable = true)
    private void injectGetNuggetPeer(CallbackInfoReturnable<Item> cir){
        Material material = this.getExclusiveMaterial();
        if (material == NetheriteRunMaterial.netherite) {
            cir.setReturnValue(NetheriteRunItem.netherite_nugget);
        }
    }

}
