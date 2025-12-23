package net.kuko.fisch.block.entity;

import com.mojang.serialization.Decoder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class SmartSpawnerBlockEntity extends BlockEntity {
    private static final String experiencePointNBT = "xp";

    public final ItemStackHandler inventory = new ItemStackHandler(3*9) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    public long experiencePoints;

    public SmartSpawnerBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.SMART_SPAWNER_BE.get(), pos, blockState);
    }

    public void drop() {
        SimpleContainer container = new SimpleContainer(inventory.getSlots());
        for (int i = 0; i < inventory.getSlots(); i++) {
            container.setItem(i, inventory.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, container);
    }

    public void dropExperience() {
        while (experiencePoints > 0) {
            int value = ExperienceOrb.getExperienceValue((int) this.experiencePoints);

            double x = this.worldPosition.getX() + 0.5 + (this.level.random.nextDouble() - 0.5);
            double y = this.worldPosition.getY() + 0.5;
            double z = this.worldPosition.getZ() + 0.5 + (this.level.random.nextDouble() - 0.5);

            this.level.addFreshEntity(new ExperienceOrb(this.level, x, y, z, value));
            this.experiencePoints -= value;
        }
    }

    public void addExperience(int amount) {
        this.experiencePoints += amount;
    }
    public void setExperience(int amount) {
        this.experiencePoints = amount;
    }


    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putLong(experiencePointNBT, experiencePoints);
        tag.put("inventory", inventory.serializeNBT(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));
        experiencePoints = tag.getLong(experiencePointNBT);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = super.getUpdateTag(registries);
        tag.putLong(experiencePointNBT, experiencePoints);
        return saveWithoutMetadata(registries);
    }
}
