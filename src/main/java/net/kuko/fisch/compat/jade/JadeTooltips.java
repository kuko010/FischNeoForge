package net.kuko.fisch.compat.jade;

import net.kuko.fisch.Fisch;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElement;
import snownee.jade.api.ui.IElementHelper;

public enum JadeTooltips {
    INSTANCE;

    public void SmartBlockEntity(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
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
}
