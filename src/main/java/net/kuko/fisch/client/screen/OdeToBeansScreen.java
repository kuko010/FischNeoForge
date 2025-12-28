package net.kuko.fisch.client.screen;

import net.kuko.fisch.U;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.WorldlyContainer;

public class OdeToBeansScreen extends Screen {
    public OdeToBeansScreen() {
        super(Component.literal("Ode To Beans"));
    }
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        int baseSize = 150; // Base width and height
        int x = (this.width - baseSize) / 2;
        int y = (this.height - baseSize) / 2;

        int glowThickness = 4; // How thick the neon glow is

        int neonColor = U.ARGBtoInt(240, 79, 62, 189);
        int baseColor = U.ARGBtoInt(240, 79, 143, 252);

        guiGraphics.fill(x, y, x + baseSize, y + baseSize, baseColor);
        drawGlow(guiGraphics, x, y, baseSize, glowThickness, neonColor);

        super.render(guiGraphics, mouseX, mouseY, delta);
    }
//

    private void drawGlow(GuiGraphics g, int x, int y, int size, int thickness, int color) {
        g.fill(x - thickness, y - thickness, x + size + thickness, y, color); // top
        g.fill(x - thickness, y + size, x + size + thickness, y + size + thickness, color); // bottom
        g.fill(x - thickness, y, x, y + size, color); // left
        g.fill(x + size, y, x + size + thickness, y + size, color); // right
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }

    @Override
    public void onClose() {
        assert this.getMinecraft().level != null;
        if (this.getMinecraft().level.isClientSide) {
            this.minecraft.setScreen(null);
        }
    }
}
