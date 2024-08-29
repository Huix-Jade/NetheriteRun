package huix.netherite_run.game_objects.item;

import huix.netherite_run.api.SmithingItemIngot;
import huix.netherite_run.api.mite.HatchetItem;
import huix.netherite_run.api.mite.HoeItem;
import huix.netherite_run.api.mite.MattockItem;
import huix.netherite_run.api.mite.ScytheItem;
import huix.netherite_run.game_objects.material.NetheriteRunMaterial;
import net.minecraft.*;
import net.xiaoyu233.fml.api.item.*;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class NetheriteRunItem {
    public static final Item netherite_scrap = new Item(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite, "netherite_scrap").setXPReward(120);
    public static final Item netherite_ingot = new SmithingItemIngot(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite).setCraftingDifficultyAsComponent(100.0F);
    public static final ItemNugget netherite_nugget = new NuggetItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite);

    public static final ItemArmor netherite_helmet = new ItemHelmet(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite,false);
    public static final ItemArmor netherite_chestplate = new ItemCuirass(IdUtil.getNextItemID(),  NetheriteRunMaterial.netherite, false);
    public static final ItemArmor netherite_leggings = new ItemLeggings(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite,false);
    public static final ItemArmor netherite_boots = new ItemBoots(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite, false);

    public static final ItemDagger netherite_dagger = new DaggerItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite);
    public static final ItemSword netherite_sword = new SwordItem(IdUtil.getNextItemID(),  NetheriteRunMaterial.netherite);
    public static final ItemBattleAxe netherite_battle_axe = new BattleAxeItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite);
    public static final ItemWarHammer netherite_war_hammer = new WarHammerItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite);

    public static final ItemPickaxe netherite_pickaxe = new PickaxeItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite);
    public static final ItemAxe netherite_axe = new AxeItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite);
    public static final ItemShovel netherite_shovel = new ShovelItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite);
    public static final ItemScythe netherite_scythe = new ScytheItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite);
    public static final ItemShears netherite_shears = new ItemShears(IdUtil.getNextItemID(),  NetheriteRunMaterial.netherite);
    public static final ItemMattock netherite_mattock = new MattockItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite);
    public static final HoeItem netherite_hoe = new HoeItem(IdUtil.getNextItemID(),  NetheriteRunMaterial.netherite);
    public static final ItemHatchet netherite_hatchet = new HatchetItem(IdUtil.getNextItemID(), NetheriteRunMaterial.netherite);


    public static void registerItems(ItemRegistryEvent register) {
        register.register("Netherite Run", "netherite_scrap", netherite_scrap, CreativeTabs.tabMaterials).setLowestCraftingDifficultyToProduce(20.0F);
        register.register("Netherite Run", "netherite_ingot", netherite_ingot);
        register.register("Netherite Run", "netherite_nugget", netherite_nugget);
        register.register("Netherite Run", "netherite_helmet", netherite_helmet).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_chestplate", netherite_chestplate).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_leggings", netherite_leggings).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_boots", netherite_boots).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_dagger", netherite_dagger).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_sword", netherite_sword).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_battle_axe", netherite_battle_axe).setLowestCraftingDifficultyToProduce(10.0F);

        register.register("Netherite Run", "netherite_war_hammer", netherite_war_hammer).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_axe", netherite_axe).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_pickaxe", netherite_pickaxe).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_shovel", netherite_shovel).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_scythe", netherite_scythe).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_shears", netherite_shears).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_mattock", netherite_mattock).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_hoe", netherite_hoe).setLowestCraftingDifficultyToProduce(10.0F);
        register.register("Netherite Run", "netherite_hatchet", netherite_hatchet).setLowestCraftingDifficultyToProduce(10.0F);

    }
}
