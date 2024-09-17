package huix.netherite_run.mixins.item;

import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.ItemArrow;
import net.minecraft.Material;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( ItemArrow.class )
public class ItemArrowMixin {


    @Shadow
    @Final
    @Mutable
    public static Material[] material_types;

    @Inject(method = "<clinit>",at = @At("RETURN"))
    private static void injectClinit(CallbackInfo callbackInfo){
        material_types = new Material[]{Material.flint, Material.obsidian, Material.copper, Material.silver, Material.rusted_iron, Material.gold, Material.iron,
                Material.mithril, Material.adamantium, Material.ancient_metal, NetheriteRunMaterial.netherite};
    }
}
