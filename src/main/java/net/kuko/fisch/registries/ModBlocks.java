package net.kuko.fisch.registries;

import net.kuko.fisch.Fisch;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ModBlocks {
    DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Fisch.MOD_ID);

    /**
     * @Depricated
     */
//    public static final DeferredBlock<Block> SMART_SPAWNER = registerBlock("smart_spawner",
//            () -> new SmartSpawner(BlockBehaviour.Properties.ofFullCopy(Blocks.SPAWNER).noOcclusion()));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
