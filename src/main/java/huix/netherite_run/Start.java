package huix.netherite_run;

import huix.netherite_run.event.NetheriteRunEvents;
import net.fabricmc.api.ModInitializer;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class Start implements ModInitializer {

    @Override
    public void onInitialize() {
        MITEEvents.MITE_EVENT_BUS.register(new NetheriteRunEvents());
    }
}
