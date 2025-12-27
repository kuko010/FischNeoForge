package net.kuko.fisch.compat.jade;

import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class FischPlugin implements IWailaPlugin {
    public static final ResourceLocation ExperiencePoints = ResourceLocation.parse("fisch:experience_points");


    @Override
    public void register(IWailaCommonRegistration registration) {
//        registration.registerBlockDataProvider(FischComponentProvider.INSTANCE, SmartSpawnerBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
//        registration.registerBlockComponent(FischComponentProvider.INSTANCE, SmartSpawner.class);
    }
}
