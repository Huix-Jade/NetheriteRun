package huix.netherite_run.mixins.entity;

import com.google.common.collect.Lists;
import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.ArrayList;
import java.util.List;

@Mixin( EntityLivingBase.class )
public class EntityLivingBaseMixin {


    @Unique
    @Final
    public List<ItemStack> getArmors() {
        ArrayList<ItemStack> armors = Lists.newArrayList();
        for (int i = 0; i <= 4; i++) {
            if (this.getCurrentItemOrArmor(i) != null) {
                armors.add(this.getCurrentItemOrArmor(i));
            }
        }

        return armors;
    }

    @Redirect(method = "knockBack(Lnet/minecraft/Entity;FDD)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/AttributeInstance;getAttributeValue()D"))
    private double injectKnockbackResistanceToKnockBack(AttributeInstance instance) {
        double result = this.getEntityAttributeValue(SharedMonsterAttributes.knockbackResistance);
        for (ItemStack armor : this.getArmors()) {
            if (armor.getMaterialForRepairs() == NetheriteRunMaterial.netherite)
                result+=0.1D;
        }

        return result;
    }

    @Redirect(method = "setBeenAttacked", at = @At(value = "INVOKE", target = "Lnet/minecraft/AttributeInstance;getAttributeValue()D"))
    private double injectKnockbackResistanceToSetBeenAttacked(AttributeInstance instance) {
        double result = this.getEntityAttributeValue(SharedMonsterAttributes.knockbackResistance);
        for (ItemStack armor : this.getArmors()) {
            if (armor.getMaterialForRepairs() == NetheriteRunMaterial.netherite)
                result+=0.1D;
        }

        return result;
    }

    @Shadow
    public double getEntityAttributeValue(Attribute attribute) {
        return 0;
    }

    @Shadow
    public ItemStack getCurrentItemOrArmor(int i) {
        return null;
    }
}
