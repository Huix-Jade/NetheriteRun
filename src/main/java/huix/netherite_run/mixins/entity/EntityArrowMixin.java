package huix.netherite_run.mixins.entity;

import huix.netherite_run.game_objects.item.NetheriteRunItem;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin( EntityArrow.class )
public class EntityArrowMixin {

    @Shadow
    public Entity shootingEntity;

    @Shadow
    public ItemStack getLauncher() {
        return null;
    }

    @ModifyVariable(method = "setThrowableHeading", at = @At("HEAD"), argsOnly = true, name = "velocity", ordinal = 3)
    private float applyVibraniumBowVelocity(float velocity){
        ItemStack launcher = this.getLauncher();
        if (launcher != null && launcher.getItem() == NetheriteRunItem.netherite_bow && this.shootingEntity instanceof EntityPlayer) {
            return velocity * 1.5F;
        }
        return velocity;
    }
}
