package huix.netherite_run.game_objects.block;

import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class AncientDebrisBlock extends BlockOre {

    private Icon side_icon;

    private Icon top_icon;

    public AncientDebrisBlock() {
        super(IdUtil.getNextBlockID(), NetheriteRunMaterial.netherite, 4);
        this.setHardness(6.0F);
        this.setResistance(3.0F);
        this.setStepSound(Block.soundStoneFootstep);
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return switch (side) {
            //top
            case 1 -> top_icon;
            //Side
            case 0, 2, 3, 5, 4 -> side_icon;
            default -> super.getIcon(side, metadata);
        };
    }


    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.side_icon = par1IconRegister.registerIcon("ancient_debris_side");
        this.top_icon = par1IconRegister.registerIcon("ancient_debris_top");
    }
}
