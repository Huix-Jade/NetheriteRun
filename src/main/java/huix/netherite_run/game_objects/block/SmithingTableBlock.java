package huix.netherite_run.game_objects.block;

import huix.netherite_run.game_objects.tileentity.SmithingTableTileEntity;
import huix.netherite_run.injected_interfaces.IPlayer;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class SmithingTableBlock extends Block implements ITileEntityProvider {

    private Icon side_icon;
    private Icon top_icon;
    private Icon bottom_icon;
    private Icon front_icon;

    protected SmithingTableBlock() {
        super(IdUtil.getNextBlockID(), Material.anvil, new BlockConstants());
        this.setMaxStackSize(1);
        this.setHardness(BlockHardness.planks);
        this.setResistance(10.0F);
        this.setStepSound(Block.soundWoodFootstep);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new SmithingTableTileEntity();
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int block_id, int metadata) {
        super.breakBlock(world, x, y, z, block_id, metadata);
        SmithingTableTileEntity tileEntity = (SmithingTableTileEntity) world.getBlockTileEntity(x, y, z);
        if (tileEntity != null) {
            for (int j = 0; j < tileEntity.getSizeInventory(); ++j) {
                ItemStack stackInSlot = tileEntity.getStackInSlot(j);

                if (stackInSlot != null) {
                    float var10 = world.rand.nextFloat() * 0.8F + 0.1F;
                    float var11 = world.rand.nextFloat() * 0.8F + 0.1F;
                    float var12 = world.rand.nextFloat() * 0.8F + 0.1F;

                    while (stackInSlot.stackSize > 0) {
                        int i = world.rand.nextInt(21) + 10;

                        if (i > stackInSlot.stackSize) {
                            i = stackInSlot.stackSize;
                        }

                        stackInSlot.stackSize -= i;
                        EntityItem entityItem = new EntityItem(world, (float)x + var10, (float)y + var11,
                                (float)z + var12, new ItemStack(stackInSlot.itemID, i, stackInSlot.getItemSubtype()));

                        if (stackInSlot.isItemDamaged()) {
                            entityItem.getEntityItem().setItemDamage(stackInSlot.getItemDamage());
                        }

                        if (stackInSlot.getItem().hasQuality()) {
                            entityItem.getEntityItem().setQuality(stackInSlot.getQuality());
                        }

                        if (stackInSlot.hasTagCompound()) {
                            entityItem.getEntityItem().setTagCompound((NBTTagCompound)stackInSlot.getTagCompound().copy());
                        }

                        float var15 = 0.05F;
                        entityItem.motionX = (float)world.rand.nextGaussian() * var15;
                        entityItem.motionY = (float)world.rand.nextGaussian() * var15 + 0.2F;
                        entityItem.motionZ = (float)world.rand.nextGaussian() * var15;
                        world.spawnEntityInWorld(entityItem);
                    }
                }
            }

            world.func_96440_m(x, y, z, metadata);
        }
        world.removeBlockTileEntity(x, y, z);
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return switch (side) {
            //top
            case 1 -> this.top_icon;
            //bottom
            case 0 -> this.bottom_icon;
            case 2 -> this.front_icon;
            //Side
            case 3, 5, 4 -> this.side_icon;
            default -> super.getIcon(side, metadata);
        };
    }


    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.side_icon = par1IconRegister.registerIcon("smithing_table/smithing_table_side");
        this.top_icon = par1IconRegister.registerIcon("smithing_table/smithing_table_top");
        this.bottom_icon = par1IconRegister.registerIcon("smithing_table/smithing_table_bottom");
        this.front_icon = par1IconRegister.registerIcon("smithing_table/smithing_table_front");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, EnumFace face, float offset_x, float offset_y, float offset_z) {
        if (!world.isAirOrPassableBlock(x, y + 1, z, false)) {
            return false;
        } else {
            if (player.onServer()) {
                SmithingTableTileEntity tile_entity = (SmithingTableTileEntity) world.getBlockTileEntity(x, y, z);
                if (tile_entity != null) {
                    player.displayGUISmithing(tile_entity);
                }
            }

            return true;
        }
    }
}
