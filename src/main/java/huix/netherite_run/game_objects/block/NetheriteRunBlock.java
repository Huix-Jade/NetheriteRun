package huix.netherite_run.game_objects.block;

import huix.netherite_run.game_objects.item.NetheriteRunItem;
import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.Block;
import net.minecraft.BlockOreStorage;
import net.minecraft.CreativeTabs;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class NetheriteRunBlock {

    public static Block smithing_table = new SmithingTableBlock().setCreativeTab(CreativeTabs.tabDecorations);

    public static Block ancient_debris = new AncientDebrisBlock();
    public static final BlockOreStorage netherite_block = new BlockOreStorage(IdUtil.getNextBlockID(), NetheriteRunMaterial.netherite);

    public static void registerItemBlocks(ItemRegistryEvent register) {
        register.registerItemBlock("Netherite Run", "smithing_table", smithing_table);
        register.registerItemBlock("Netherite Run", "ancient_debris", ancient_debris);
        register.registerItemBlock("Netherite Run", "netherite_block", netherite_block);
    }
}
