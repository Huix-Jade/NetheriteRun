package huix.netherite_run.mixins.entity.player;

import huix.netherite_run.game_objects.tileentity.SmithingTableTileEntity;
import huix.netherite_run.injected_interfaces.IPlayer;
import net.minecraft.Entity;
import net.minecraft.EntityPlayer;
import net.minecraft.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin( EntityPlayer.class )
public class EntityPlayerMixin implements IPlayer {

    @Unique
    @Override
    public void displayGUISmithing(SmithingTableTileEntity tileEntity) {
    }

}
