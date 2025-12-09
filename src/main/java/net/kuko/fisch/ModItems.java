package net.kuko.fisch;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Fisch.MOD_ID);




    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
