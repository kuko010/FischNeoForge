//package net.kuko.fisch.depricated.block.custom;
//
//import com.mojang.serialization.MapCodec;
//import net.kuko.fisch.block.entity.ModBlockEntities;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.ItemInteractionResult;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.*;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityTicker;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.phys.BlockHitResult;
//import net.minecraft.world.phys.shapes.CollisionContext;
//import net.minecraft.world.phys.shapes.VoxelShape;
//import org.jetbrains.annotations.Nullable;
//
//public class SmartSpawner extends BaseEntityBlock {
//    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);
//    public static final MapCodec<SmartSpawner> CODEC = simpleCodec(SmartSpawner::new);
//
//    public SmartSpawner(Properties properties) {
//        super(properties);
//    }
//
//    @Override
//    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
//        return SHAPE;
//    }
//
//    @Override
//    protected RenderShape getRenderShape(BlockState state) {
//        return RenderShape.MODEL;
//    }
//    @Override
//    protected MapCodec<? extends BaseEntityBlock> codec() {
//        return CODEC;
//    }
//
//
//    @Override
//    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
//        if (!level.isClientSide) {
//            BlockEntity entity = level.getBlockEntity(pos);
//            if (entity instanceof SmartSpawnerBlockEntity blockEntity)  {
//                blockEntity.drop();
//                blockEntity.dropExperience();
//            }
//        }
//        super.onRemove(state, level, pos, newState, movedByPiston);
//    }
//
//    @Override
//    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level,
//                                              BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
//        if (!level.isClientSide) {
//            BlockEntity entity = level.getBlockEntity(pos);
//            if (stack.is(Items.CARROT)) {
//                if (entity instanceof SmartSpawnerBlockEntity blockEntity) {
//                    blockEntity.setExperience(1000);
//                    return ItemInteractionResult.SUCCESS;
//                }
//            }
//            if (stack.is(Items.IRON_INGOT)) {
//                if (entity instanceof SmartSpawnerBlockEntity blockEntity) {
//                    blockEntity.addExperience(5);
//                    return ItemInteractionResult.SUCCESS;
//                }
//            }
//        }
//        return ItemInteractionResult.FAIL;
//    }
//
//    /* BLOCK ENTITY */
//    @Override
//    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return new SmartSpawnerBlockEntity(pos, state);
//    }
//    @Override
//    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
//        return createTickerHelper(
//                        type,
//                        ModBlockEntities.SMART_SPAWNER_BE.get(),
//                        SmartSpawnerBlockEntity::tick
//                );}
//
//
////    @Override
////    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
////        if (level.isClientSide) return;
////        if (level.getBlockEntity(pos) instanceof SmartSpawnerBlockEntity entity) {
////            entity.addExperience(5);
////
////        }
////    }
//}
