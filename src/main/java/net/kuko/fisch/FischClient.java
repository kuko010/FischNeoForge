package net.kuko.fisch;

import net.kuko.fisch.block.entity.ModBlockEntities;
import net.kuko.fisch.block.renderer.SmartSpawnerRenderer;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Fisch.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Fisch.MOD_ID, value = Dist.CLIENT)
public class FischClient {
    public FischClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent // on the game event bus only on the physical client
    public static void onClientTick(ClientTickEvent.Post event) {
//        KeybindHandler.KeyBindingCode(event);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        Fisch.LOGGER.info("HELLO FROM CLIENT SETUP");
        Fisch.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());


    }
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.SMART_SPAWNER_BE.get(), SmartSpawnerRenderer::new);
    }
}
