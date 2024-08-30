package huix.netherite_run.init;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.EnumQuality;
import net.xiaoyu233.fml.util.EnumExtends;

public class PreInit implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        EnumExtends.EQUIPMENT_MATERIAL.addEnum("netherite", ()->new Object[]{128.0F, 100, EnumQuality.legendary, "netherite"});
    }
}
