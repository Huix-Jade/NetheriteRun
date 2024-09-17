package huix.netherite_run.init;

import huix.glacier.api.entrypoint.IGameRegistry;
import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;
import huix.glacier.api.extension.item.GlacierItemFishingRod;
import huix.glacier.api.registry.MinecraftRegistry;
import huix.netherite_run.api.SmithingItemIngot;
import huix.netherite_run.api.mite.HatchetItem;
import huix.netherite_run.api.mite.HoeItem;
import huix.netherite_run.api.mite.MattockItem;
import huix.netherite_run.api.mite.ScytheItem;
import huix.netherite_run.game_objects.block.AncientDebrisBlock;
import huix.netherite_run.game_objects.block.SmithingTableBlock;
import huix.netherite_run.game_objects.creativetab.NetheriteCreativeTabs;
import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.*;
import net.xiaoyu233.fml.api.item.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class RegistryInit implements IGameRegistry {
    public static final CreativeTabs netherite = new NetheriteCreativeTabs();

    public static final MinecraftRegistry registry = new MinecraftRegistry("NetheriteRun").initAutoItemRegister();

    public static final Item netherite_scrap = new Item(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite, "netherite_scrap")
            .setXPReward(120).setCreativeTab(netherite);
    public static final ItemIngot netherite_ingot = (ItemIngot)
            new SmithingItemIngot(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCraftingDifficultyAsComponent(100.0F).setCreativeTab(netherite);
    public static final ItemNugget netherite_nugget = (ItemNugget) new NuggetItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);

    public static final ItemArmor netherite_helmet = (ItemHelmet) new ItemHelmet(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite,false).setCreativeTab(netherite);
    public static final ItemArmor netherite_chestplate = (ItemCuirass) new ItemCuirass(IdUtil.getNextItemID(),  NetheriteRunMaterial.netherite, false).setCreativeTab(netherite);
    public static final ItemArmor netherite_leggings = (ItemLeggings) new ItemLeggings(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite,false).setCreativeTab(netherite);
    public static final ItemArmor netherite_boots = (ItemBoots) new ItemBoots(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite, false).setCreativeTab(netherite);

    public static final ItemDagger netherite_dagger = (ItemDagger) new DaggerItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final ItemSword netherite_sword = (ItemSword) new SwordItem(IdUtil.getNextItemID(),  NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final ItemBattleAxe netherite_battle_axe = (ItemBattleAxe) new BattleAxeItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final ItemWarHammer netherite_war_hammer = (ItemWarHammer) new WarHammerItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);

    public static final ItemPickaxe netherite_pickaxe = (ItemPickaxe) new PickaxeItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final ItemAxe netherite_axe = (ItemAxe) new AxeItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final ItemShovel netherite_shovel = (ItemShovel) new ShovelItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final ItemScythe netherite_scythe = (ItemScythe) new ScytheItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final ItemShears netherite_shears = (ItemShears) new ItemShears(IdUtil.getNextItemID(),  NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final ItemMattock netherite_mattock = (ItemMattock) new MattockItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final HoeItem netherite_hoe = (HoeItem) new HoeItem(IdUtil.getNextItemID(),  NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final ItemHatchet netherite_hatchet = (ItemHatchet) new HatchetItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);

    public static final ItemCoin netherite_coin = (ItemCoin) new ItemCoin(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final GlacierItemFishingRod netherite_fish_rod = (GlacierItemFishingRod) new GlacierItemFishingRod(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final ItemArrow netherite_arrow = (ItemArrow) new ItemArrow(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    public static final ItemBow netherite_bow = (ItemBow) new ItemBow(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);


    public static final Block smithing_table = new SmithingTableBlock().setCreativeTab(netherite);
    public static final Block ancient_debris = new AncientDebrisBlock().setCreativeTab(netherite);
    public static final Block netherite_block = new BlockOreStorage(IdUtil.getNextBlockID(), NetheriteRunMaterial.netherite).setCreativeTab(netherite);
    
    @Override
    public void onGameRegistry() {
        registry.registerItemHeatLevel(ancient_debris.blockID, 4);


        registry.registerItem( "netherite_arrow", netherite_arrow).setLowestCraftingDifficultyToProduce(40.0F);
        registry.registerItem( "netherite_coin", netherite_coin).setLowestCraftingDifficultyToProduce(20.0F);
        registry.registerItem( "netherite_fish_rod", netherite_fish_rod).setLowestCraftingDifficultyToProduce(20.0F);
        registry.registerItem( "bows/netherite/", netherite_bow).setUnlocalizedName("netherite_bow").setLowestCraftingDifficultyToProduce(20.0F);

        registry.registerItem( "netherite_scrap", netherite_scrap).setLowestCraftingDifficultyToProduce(20.0F);
        registry.registerItem( "netherite_ingot", netherite_ingot);
        registry.registerItem( "netherite_nugget", netherite_nugget);
        registry.registerItem( "netherite_helmet", netherite_helmet).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_chestplate", netherite_chestplate).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_leggings", netherite_leggings).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_boots", netherite_boots).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_dagger", netherite_dagger).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_sword", netherite_sword).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_battle_axe", netherite_battle_axe).setLowestCraftingDifficultyToProduce(10.0F);

        registry.registerItem( "netherite_war_hammer", netherite_war_hammer).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_axe", netherite_axe).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_pickaxe", netherite_pickaxe).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_shovel", netherite_shovel).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_scythe", netherite_scythe).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_shears", netherite_shears).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_mattock", netherite_mattock).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem( "netherite_hoe", netherite_hoe).setLowestCraftingDifficultyToProduce(10.0F);
        registry.registerItem("netherite_hatchet", netherite_hatchet).setLowestCraftingDifficultyToProduce(10.0F);

        registry.registerBlock(smithing_table,"smithing_table");
        registry.registerBlock(ancient_debris, "ancient_debris");
        registry.registerBlock(netherite_block, "netherite_block");
    }
}
