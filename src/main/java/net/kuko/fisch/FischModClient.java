package net.kuko.fisch;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = FischMod.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = FischMod.MOD_ID, value = Dist.CLIENT)
public class FischModClient {
    public FischModClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        FischMod.LOGGER.info("HELLO FROM CLIENT SETUP");
        FischMod.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
}
