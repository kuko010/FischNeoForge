package net.kuko.fisch.datagen;


import net.kuko.fisch.Fisch;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Fisch.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//        blockWithItem(ModBlocks.BISMUTH_BLOCK);
//
//        blockWithItem(ModBlocks.BISMUTH_ORE);
//        blockWithItem(ModBlocks.BISMUTH_DEEPSLATE_ORE);
//
//        blockWithItem(ModBlocks.MAGIC_BLOCK);
//        blockWithItem(ModBlocks.SMART_SPAWNER);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
