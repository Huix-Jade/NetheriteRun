package huix.netherite_run.game_objects.achievement;

import huix.netherite_run.init.RegistryInit;
import net.minecraft.Achievement;
import net.minecraft.AchievementList;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class NetheriteAchievement {

    public static Achievement ancient_debris;
    public static Achievement netherite_arroms;
    public static Achievement netherite_hoe;
    public static Achievement netherite_pickaxe;


    public static void registerAchievements() {
        ancient_debris = new Achievement(IdUtil.getNextAchievementID(), "ancient_debris", 5, 11, RegistryInit.ancient_debris,
                AchievementList.portalToNether).registerAchievement();
        netherite_arroms = new Achievement(IdUtil.getNextAchievementID(), "netherite_arroms", 7 , 11, RegistryInit.netherite_chestplate,
                ancient_debris).setSpecial().registerAchievement();
        netherite_hoe = new Achievement(IdUtil.getNextAchievementID(), "netherite_hoe", 7, 13, RegistryInit.netherite_hoe,
                ancient_debris).setSpecial().registerAchievement();
        netherite_pickaxe = new Achievement(IdUtil.getNextAchievementID(), "netherite_pickaxe", 5, 14, RegistryInit.netherite_pickaxe,
                ancient_debris).setSpecial().registerAchievement();

    }
}
