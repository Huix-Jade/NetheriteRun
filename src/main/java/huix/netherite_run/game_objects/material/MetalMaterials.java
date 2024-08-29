package huix.netherite_run.game_objects.material;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.Material;

public class MetalMaterials extends Material {
    public static final EnumEquipmentMaterial netherite_equipment = ClassTinkerers.getEnum(EnumEquipmentMaterial.class, "netherite");

    public MetalMaterials(EnumEquipmentMaterial enum_crafting_material) {
        super(enum_crafting_material);
    }

    @Override
    public float getDamageVsEntity() {
        if (this == NetheriteRunMaterial.netherite) {
            return 6.5F;
        }
        return super.getDamageVsEntity();
    }
}
