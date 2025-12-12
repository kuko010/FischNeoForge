package net.kuko.fisch.event;

import net.kuko.fisch.Fisch;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber(modid = Fisch.MOD_ID)
public class FischEvents {
    public static void onTick(EntityTickEvent.Pre event) {
        Entity entity = event.getEntity();
    }

    public static void onInteract(PlayerInteractEvent.RightClickItem event) {
    }
}
