package net.kuko.fisch.registries;

import net.kuko.fisch.Fisch;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ModBlocks {
    DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Fisch.MOD_ID);

//    DeferredBlock<Block> LIGHTING_BLOCK = registerBlock("lighting_block",
//            () -> new LightingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block); // 1
        registerBlockItem(name, toReturn); // 2
        return toReturn; // 3
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties())); // 2
    }

    static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
