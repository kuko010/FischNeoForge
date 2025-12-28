package net.kuko.fisch.block.entity;

import net.kuko.fisch.Fisch;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Fisch.MOD_ID);

    /**{google:originalQueryForSuggestion}{google:assistedQueryStats}{google:searchFieldtrialParameter}{google:language}{google:prefetchSource}{google:searchClient}{google:sourceId}{google:contextualSearchVersion}ie={inputEncoding}
     *
     * @Depricated
     */
//    public static final Supplier<BlockEntityType<SmartSpawnerBlockEntity>> SMART_SPAWNER_BE =
//            BLOCK_ENTITIES.register("smart_spanwer_be", () -> BlockEntityType.Builder.of(
//                    SmartSpawnerBlockEntity::new, ModBlocks.SMART_SPAWNER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }



}

