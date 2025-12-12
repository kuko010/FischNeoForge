package net.kuko.fisch.event;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class FischEvents {


    @SubscribeEvent
    public void onLivingJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntity();
        if (!entity.level().isClientSide()) {
            entity.heal(1);
        }
    }

    // When i type psf and then tab, it generates    public static final [Cursor Here]

    public void onTick(EntityTickEvent.Pre event) {
        Entity entity = event.getEntity();
//        if (entity instanceof )


    }

    public void onInteract(PlayerInteractEvent.RightClickItem event) {
        if (!event.getLevel().isClientSide()) {

        }
    }
}
