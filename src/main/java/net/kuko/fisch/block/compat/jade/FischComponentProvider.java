package net.kuko.fisch.block.compat.jade;

import net.kuko.fisch.Fisch;
import net.kuko.fisch.block.entity.SmartSpawnerBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElement;
import snownee.jade.api.ui.IElementHelper;

public enum  FischComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        // First get the block entity from the accessor, THEN check if it's a SmartSpawnerBlockEntity
        if (blockAccessor.getServerData().contains("fisch.spawner.xp"))
        {
            IElementHelper elements = IElementHelper.get();
            IElement icon = elements.item(new ItemStack(Items.EXPERIENCE_BOTTLE), 0.5f)
                    .translate(new Vec2(0,-1.5f));
            tooltip.add(Component.empty());


            tooltip.append(icon);
            tooltip.append(Component.translatable(
                    Fisch.MOD_ID + ".smart_spawner.jade.xp",
                    blockAccessor.getServerData().getLong("fisch.spawner.xp")
            ));

        }
    }

    @Override
    public ResourceLocation getUid() {
        return FischPlugin.ExperiencePoints;
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        // Get the block entity from the accessor, then check if it's a SmartSpawnerBlockEntity
        if (blockAccessor.getBlockEntity() instanceof SmartSpawnerBlockEntity entity) {
            compoundTag.putLong("fisch.spawner.xp", entity.experiencePoints);
        }
    }
}
