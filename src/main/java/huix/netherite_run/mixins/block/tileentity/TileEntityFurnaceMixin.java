package huix.netherite_run.mixins.block.tileentity;

import huix.netherite_run.init.RegistryInit;
import net.minecraft.TileEntityFurnace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( TileEntityFurnace.class )
public class TileEntityFurnaceMixin {
//    @Inject(method = "getHeatLevelRequired", at = @At("HEAD"), cancellable = true)
//    private static void getHeatLevelRequired(int item_id, CallbackInfoReturnable<Integer> cir) {
//        if (item_id == RegistryInit.ancient_debris.blockID) {
//            cir.setReturnValue(4);
//        }
//    }
}
