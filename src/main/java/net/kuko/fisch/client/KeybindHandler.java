package net.kuko.fisch.client;


import net.kuko.fisch.Fisch;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@EventBusSubscriber(modid = Fisch.MOD_ID, value = Dist.CLIENT)
public class KeybindHandler {
    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(FischKeyMappings.open);
        Fisch.LOGGER.info("Keybinds for fisch has been registered");
    }

    public static void KeyBindingCode(ClientTickEvent.Post event) {
        while (FischKeyMappings.open.consumeClick()) {
            // Execute logic to perform on click here
            Fisch.LOGGER.info("Clicked");
        }
    }
}
