package net.kuko.fisch.compat.ldlib2.screen;


import com.lowdragmc.lowdraglib2.gui.ui.ModularUI;
import net.kuko.fisch.compat.ldlib2.modulars.ModularScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ExampleScreen extends Screen {
    public ExampleScreen() {
        super(Component.literal("example"));
    }


    @Override
    protected void init() {
        super.init();
        ModularUI modularUI = ModularScreens.createUI();
        modularUI.setScreenAndInit(this);
        this.addRenderableWidget(modularUI.getWidget());
    }


    @Override
    public void onClose() {
        assert this.getMinecraft().level != null;
        if (this.getMinecraft().level.isClientSide) {
            this.minecraft.setScreen(null);
        }
    }
}
