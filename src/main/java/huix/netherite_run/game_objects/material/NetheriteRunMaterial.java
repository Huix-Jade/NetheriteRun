package huix.netherite_run.game_objects.material;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.Material;

public class NetheriteRunMaterial {

    public static Material netherite = new MetalMaterials(MetalMaterials.netherite_equipment)
            .setMetal(false)
            .setHarmedByLava(false)
            .setMinHarvestLevel(5);

}
