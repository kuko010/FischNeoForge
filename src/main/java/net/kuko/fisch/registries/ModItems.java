package net.kuko.fisch.registries;

import net.kuko.fisch.Fisch;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public interface ModItems {
    DeferredRegister.Items ITEMS = DeferredRegister.createItems(Fisch.MOD_ID);


//    DeferredItem<Item> TEST_ITEM = ITEMS.register("test_item",
//            () -> new Item(new Item.Properties()) {
//                @Override
//                public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
//                    Registry<FishProperties> reg = level.registryAccess().registryOrThrow(FischClient.FISH_REGISTRY);
//
//                    for (FishProperties fp : reg) {
//
//                    }
//                    return super.use(level, player, usedHand);
//                }
//            });

    static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
