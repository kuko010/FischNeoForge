package net.kuko.fisch.registries;

import net.kuko.fisch.Fisch;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public interface ModItems {
    DeferredRegister.Items ITEMS = DeferredRegister.createItems(Fisch.MOD_ID);



    static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
