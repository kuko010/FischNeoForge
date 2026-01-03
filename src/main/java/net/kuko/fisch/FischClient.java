package net.kuko.fisch;

import com.mojang.brigadier.CommandDispatcher;
import net.kuko.fisch.compat.ldlib2.screen.ExampleScreen;
import net.kuko.fisch.fishentry.FishProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.kuko.fisch.U.rl;

@Mod(value = Fisch.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Fisch.MOD_ID, value = Dist.CLIENT)
public class FischClient {


    // Because of Fish Entry
    public static final ResourceKey<Registry<FishProperties>> FISH_REGISTRY =
            ResourceKey.createRegistryKey(rl("fish"));

    // Because of Fish Entry
    @SubscribeEvent
    public static void addRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(
                FISH_REGISTRY,
                FishProperties.CODEC,
                FishProperties.CODEC,
                builder -> builder.maxId(256)
        );


    }


    @SubscribeEvent
    public static void onRegisterClientCommands(RegisterClientCommandsEvent event) {
        if (ModList.get().isLoaded("ldlib2")) {
            CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

            // Register your client command
            dispatcher.register(
                    Commands.literal("cgui")
                            .then(Commands.literal("open")
                                    .executes(context -> {
                                        Minecraft minecraft = Minecraft.getInstance();
                                        if (minecraft != null) {
                                            minecraft.execute(() -> minecraft.setScreen(new ExampleScreen()));
                                        }
                                        return 1;
                                    })
                            )
            );
        }
    }






    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        Fisch.LOGGER.info("HELLO FROM CLIENT SETUP");
        Fisch.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

        //ClientCommandRegistrationEvent
    }


    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
//        event.registerBlockEntityRenderer(ModBlockEntities.SMART_SPAWNER_BE.get(), SmartSpawnerRenderer::new);
    }

    @SubscribeEvent // on the game event bus only on the physical client
    public static void onClientTick(ClientTickEvent.Post event) {
//        KeybindHandler.KeyBindingCode(event);
    }

    public FischClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
