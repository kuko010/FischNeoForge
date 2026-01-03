//package net.kuko.fisch.block.depricated.block.renderer;
//
//import com.mojang.blaze3d.vertex.PoseStack;
////import net.kuko.fisch.block.depricated.block.entity.SmartSpawnerBlockEntity;
//import net.minecraft.client.renderer.LightTexture;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
//import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.LightLayer;
//
//public class SmartSpawnerRenderer implements BlockEntityRenderer<SmartSpawnerBlockEntity> {
//
//    public SmartSpawnerRenderer(BlockEntityRendererProvider.Context context) {
//    }
//
//    @Override
//    public void render(SmartSpawnerBlockEntity blockEntity, float partialTick, PoseStack poseStack,
//                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
//
//        BlockPos pos = blockEntity.getBlockPos();
//    }
//
//    private int getLightLevel(Level level, BlockPos pos) {
//        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
//        int sLight = level.getBrightness(LightLayer.SKY, pos);
//        return LightTexture.pack(bLight, sLight);
//    }
//}
