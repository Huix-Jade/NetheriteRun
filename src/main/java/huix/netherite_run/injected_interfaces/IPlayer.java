package huix.netherite_run.injected_interfaces;

import huix.netherite_run.game_objects.tileentity.SmithingTableTileEntity;

public interface IPlayer {

    default void displayGUISmithing(SmithingTableTileEntity tileEntity){}

}
