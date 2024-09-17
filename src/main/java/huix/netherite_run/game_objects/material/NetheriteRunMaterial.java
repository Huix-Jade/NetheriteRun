package huix.netherite_run.game_objects.material;

import com.chocohead.mm.api.ClassTinkerers;
import huix.glacier.api.extension.material.GlacierMaterial;
import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.Material;

public class NetheriteRunMaterial {

    public static Material netherite = new NetheriteMaterial()
            .setMetal(false)
            .setHarmedByLava(false)
            .setMinHarvestLevel(5);

}
