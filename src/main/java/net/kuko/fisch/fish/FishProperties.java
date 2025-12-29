package net.kuko.fisch.fish;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public record FishProperties(
        ResourceLocation fish,
        float baseChance,
        boolean bool
)
{

}
