package huix.netherite_run.game_objects.material;

import huix.glacier.api.extension.material.*;
import huix.netherite_run.init.RegistryInit;
import net.minecraft.*;

public class NetheriteMaterial extends GlacierMaterial implements
        IArmorMaterial, IArrowMaterial, IBowMaterial, ICoinMaterial, IComboMaterial, IToolMaterial, IRepairableMaterial {

    public NetheriteMaterial() {
        super(EnumNetheriteMaterial.netherite);
    }


    @Override
    public float getDamageVsEntity() {
        return 6.5F;
    }

    @Override
    public int getProtection() {
        return 12;
    }

    @Override
    public float getChanceOfRecovery() {
        return 1.0F;
    }

    @Override
    public int velocityBonus() {
        return 50;
    }

    @Override
    public int maxDamage() {
        return 256;
    }

    @Override
    public int getExperienceValue() {
        return 12500;
    }

    @Override
    public ItemCoin getForInstance() {
        return RegistryInit.netherite_coin;
    }

    @Override
    public Item getNuggetPeer() {
        return RegistryInit.netherite_nugget;
    }

    @Override
    public ItemNugget getNugget() {
        return RegistryInit.netherite_nugget;
    }

    @Override
    public ItemIngot getIngot() {
        return RegistryInit.netherite_ingot;
    }

    @Override
    public float getHarvestEfficiency() {
        return 3.3F;
    }

    @Override
    public Item getRepairItem() {
        return RegistryInit.netherite_nugget;
    }
}
