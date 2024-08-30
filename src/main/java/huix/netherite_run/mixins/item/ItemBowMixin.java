package huix.netherite_run.mixins.item;

import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ItemBow.class)
public class ItemBowMixin {

    @Shadow
    private Material reinforcement_material;

    @Shadow
    @Final
    @Mutable
    private static Material[] possible_arrow_materials;
    @Shadow
    @Final
    @Mutable
    public static String[] bow_pull_icon_name_array;

    @Inject(method = "<clinit>",at = @At(value = "FIELD", target = "Lnet/minecraft/ItemBow;possible_arrow_materials:[Lnet/minecraft/Material;"
            , ordinal = 0, shift = At.Shift.AFTER))
    private static void injectClinit(CallbackInfo callbackInfo){
        possible_arrow_materials = new Material[]{Material.flint, Material.obsidian, Material.copper, Material.silver, Material.rusted_iron, Material.gold,
                Material.iron, Material.mithril, Material.adamantium, Material.ancient_metal, NetheriteRunMaterial.netherite};
    }

    @Redirect(method = "addInformation", at = @At(value = "INVOKE", target = "Lnet/minecraft/Translator;getFormatted(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;"))
    private String injectAddInfo(String key, Object[] par1ArrayOfObj){
        if (this.reinforcement_material == NetheriteRunMaterial.netherite){
            return Translator.getFormatted(key,50);
        }
        return Translator.getFormatted(key,par1ArrayOfObj);
    }
}
