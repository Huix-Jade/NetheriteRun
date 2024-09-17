package huix.netherite_run.mixins.item;

import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemArmor.class)
public class ItemArmorMixin {
    @Shadow
    protected Material effective_material;

    @Inject(method = "addInformation", at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z", ordinal = 1, shift = At.Shift.AFTER))
    public void injectKnockbackResistanceInfo(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot, CallbackInfo ci) {
        if (this.effective_material == NetheriteRunMaterial.netherite){
            info.add(EnumChatFormatting.BLUE + Translator.getFormatted("item.tooltip.knockbackBonus",
                    new Object[]{StringHelper.formatFloat(1, 1, 1)}));
        }
    }
}
