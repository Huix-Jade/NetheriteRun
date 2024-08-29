package huix.netherite_run.mixins.entity.player;

import huix.netherite_run.game_objects.client.gui.SmithingTableGUI;
import huix.netherite_run.game_objects.tileentity.SmithingTableTileEntity;
import huix.netherite_run.injected_interfaces.IPlayer;
import net.minecraft.ClientPlayer;
import net.minecraft.Minecraft;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin( ClientPlayer.class )
public class ClientPlayerMixin implements IPlayer {

    @Shadow
    protected Minecraft mc;

    @Unique
    @Override
    public void displayGUISmithing(SmithingTableTileEntity tileEntity) {
        this.mc.displayGuiScreen(new SmithingTableGUI(ReflectHelper.dyCast(this), tileEntity));
    }
}
