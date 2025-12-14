package net.kuko.fisch;

import net.kuko.fisch.block.ModBlocks;
import net.kuko.fisch.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(Fisch.MOD_ID)
public class Fisch {
    public static final String MOD_ID = "fisch";
    public static final Logger LOGGER = LogUtils.getLogger();


    public Fisch(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        /*
         Generator for Enchanting language:
             Generator for Lorem Ipsum: https://www.lipsum.com/
             Convert it with: https://cryptii.com/pipes/alphabetical-substitution
             Replace "ciphertext alphabet" with ""
         Enjoy.
         */

        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }


    public static ResourceLocation rl(String s) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, s);
    }

}
