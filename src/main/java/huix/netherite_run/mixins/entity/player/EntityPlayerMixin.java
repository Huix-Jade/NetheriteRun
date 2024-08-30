package huix.netherite_run.mixins.entity.player;

import huix.netherite_run.game_objects.achievement.NetheriteAchievement;
import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import huix.netherite_run.game_objects.tileentity.SmithingTableTileEntity;
import huix.netherite_run.injected_interfaces.IPlayer;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin( EntityPlayer.class )
public class EntityPlayerMixin implements IPlayer {

    @Unique
    @Override
    public void displayGUISmithing(SmithingTableTileEntity tileEntity) {
    }

    @Shadow
    public InventoryPlayer inventory;

    @Inject(method = "checkForArmorAchievements", at = @At(value = "HEAD"))
    public void injectAchievementForNetheriteArmor(CallbackInfo ci) {
        boolean wearing_full_suit_netherite_plate = true;
        for(int i = 0; i < 4; ++i) {
            if (this.inventory.armorInventory[i] != null && this.inventory.armorInventory[i].getItem() instanceof ItemArmor armor) {
                Material material = armor.getArmorMaterial();
                if (material != NetheriteRunMaterial.netherite) {
                    wearing_full_suit_netherite_plate = false;
                }
            } else {
                wearing_full_suit_netherite_plate = false;
            }
        }

        if (wearing_full_suit_netherite_plate) {
            this.triggerAchievement(NetheriteAchievement.netherite_arroms);
        }
    }

    @Shadow
    public void triggerAchievement(StatBase par1StatBase) {
    }
}
