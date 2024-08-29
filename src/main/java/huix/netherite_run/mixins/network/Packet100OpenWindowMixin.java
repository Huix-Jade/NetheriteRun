package huix.netherite_run.mixins.network;

import huix.netherite_run.game_objects.tileentity.SmithingTableTileEntity;
import huix.netherite_run.injected_interfaces.IPlayer;
import net.minecraft.EntityClientPlayerMP;
import net.minecraft.Packet100OpenWindow;
import net.minecraft.TileEntity;
import net.minecraft.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( Packet100OpenWindow.class)
public class Packet100OpenWindowMixin {
    @Unique
    private static final int type_smithing_table = 100;

    @Shadow
    public int inventoryType;
    @Shadow
    public int windowId;
    @Shadow
    public int x;
    @Shadow
    public int y;
    @Shadow
    public int z;

    @Inject(method = "hasCoords", at = @At("RETURN"), cancellable = true)
    public void injectInventory(CallbackInfoReturnable<Boolean> cir) {
         if (this.inventoryType == type_smithing_table) {
             cir.setReturnValue(true);
         }
    }

    @Inject(method = "handleOpenWindow", at = @At("HEAD"), cancellable = true)
    public void handleOpenWindow(EntityClientPlayerMP player, CallbackInfo ci) {
        WorldClient world = player.worldObj.getAsWorldClient();
        TileEntity tile_entity = world.getBlockTileEntity(this.x, this.y, this.z);
        if (this.inventoryType == type_smithing_table) {
            SmithingTableTileEntity reforgeTile = (SmithingTableTileEntity) tile_entity;

            player.displayGUISmithing(reforgeTile);
            player.openContainer.windowId = this.windowId;
            ci.cancel();
        }
    }

}
