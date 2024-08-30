package huix.netherite_run.init;

import huix.netherite_run.event.NetheriteRunEvents;
import net.fabricmc.api.ModInitializer;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class PostInit implements ModInitializer {

    @Override
    public void onInitialize() {
        MITEEvents.MITE_EVENT_BUS.register(new NetheriteRunEvents());
    }
}
