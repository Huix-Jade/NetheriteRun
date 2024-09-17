package huix.netherite_run.game_objects.creativetab;

import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;
import huix.netherite_run.init.RegistryInit;
import net.minecraft.Item;
import net.minecraft.RegistryDefaulted;

public class NetheriteCreativeTabs extends GlacierCreativeTabs {
    public NetheriteCreativeTabs() {
        super("netherite");
    }

    @Override
    public Item getTabIconItem() {
        return RegistryInit.netherite_coin;
    }
}
