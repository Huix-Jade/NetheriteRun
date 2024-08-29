package huix.netherite_run.api;

import net.minecraft.Item;
import net.minecraft.ItemIngot;
import net.minecraft.Material;

public class SmithingItemIngot extends ItemIngot implements ISmithing {
    public SmithingItemIngot(int id, Material material) {
        super(id, material);
    }

    @Override
    public String getName() {
        return "Ingot";
    }
}
