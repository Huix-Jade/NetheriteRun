package huix.netherite_run.mixins.entity.player;

import huix.netherite_run.game_objects.inventory.container.SmithingTableContainer;
import huix.netherite_run.game_objects.tileentity.SmithingTableTileEntity;
import huix.netherite_run.injected_interfaces.IPlayer;
import net.minecraft.*;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin( ServerPlayer.class )
public class ServerPlayerMixin extends EntityPlayer {

    @Shadow
    public NetServerHandler playerNetServerHandler;
    @Shadow
    private int currentWindowId;

    public ServerPlayerMixin(World par1World, String par2Str) {
        super(par1World, par2Str);
    }


    @Unique
    @Override
    public void displayGUISmithing(SmithingTableTileEntity tileEntity) {
        this.incrementWindowID();
        this.playerNetServerHandler.sendPacketToPlayer((new Packet100OpenWindow(this.currentWindowId,
                100, tileEntity.getCustomInvName(), tileEntity.getSizeInventory(), tileEntity.hasCustomName())).setCoords(tileEntity));
        this.openContainer = new SmithingTableContainer(this, tileEntity);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.addCraftingToCrafters(ReflectHelper.dyCast(ServerPlayer.class, this));
    }

    @Shadow
    private void incrementWindowID(){
    }

    @Shadow
    public INetworkManager getNetManager() {
        return null;
    }

    @Shadow
    public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
    }

    @Shadow
    public boolean canCommandSenderUseCommand(int i, String string) {
        return false;
    }

    @Shadow
    public ChunkCoordinates getPlayerCoordinates() {
        return null;
    }
}
