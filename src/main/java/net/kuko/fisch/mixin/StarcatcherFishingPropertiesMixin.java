package net.kuko.fisch.mixin;

import com.wdiscute.starcatcher.registry.fishing.StarcatcherFishingProperties;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StarcatcherFishingProperties.class)
public class StarcatcherFishingPropertiesMixin {

//    @Inject(method = "bootstrap", at = @At("TAIL"))
//    private static void onBootstrapEnd(CallbackInfo ci) {
//        // Your code here runs after the original method finishes
//        System.out.println("StarcatcherFishingProperties.bootstrap() finished!");
//
//        // Example: register another fish
//        registerStarcatcherBucketAndEntity(
//                overworldLakeFish(Items.DIAMOND)
//                        .withSizeAndWeight(FishProperties.sizeWeight(10f, 2, 800, 150))
//        );
//    }
}
