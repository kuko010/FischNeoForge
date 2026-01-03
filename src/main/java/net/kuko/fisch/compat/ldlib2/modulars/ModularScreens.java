package net.kuko.fisch.compat.ldlib2.modulars;

import com.lowdragmc.lowdraglib2.gui.texture.SpriteTexture;
import com.lowdragmc.lowdraglib2.gui.ui.ModularUI;
import com.lowdragmc.lowdraglib2.gui.ui.UI;
import com.lowdragmc.lowdraglib2.gui.ui.UIElement;
import com.lowdragmc.lowdraglib2.gui.ui.data.Horizontal;
import com.lowdragmc.lowdraglib2.gui.ui.elements.Button;
import com.lowdragmc.lowdraglib2.gui.ui.elements.Label;
import com.lowdragmc.lowdraglib2.gui.ui.styletemplate.Sprites;
import com.lowdragmc.lowdraglib2.utils.XmlUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.w3c.dom.Element;

import static net.kuko.fisch.U.rl;

public class ModularScreens {
    private static ModularUI createModularUI() {
        // create a root element
        var root = new UIElement();//
        root.addChildren(
                // add a label to display text
                new Label().setText("My First UI")
                        // center align text
                        .textStyle(textStyle -> textStyle.textAlignHorizontal(Horizontal.CENTER)),
                // add a button with text
                new Button().setText("Click Me!"),
                // add an element to display an image based on a resource location
                new UIElement().layout(layout -> layout.width(80).height(80))
                        .style(style -> style.background(
                                SpriteTexture.of("ldlib2:textures/gui/icon.png"))
                        )
        ).style(style -> style.background(Sprites.BORDER)); // set a background for the root element
        // set padding and gap for children elements
        root.layout(layout -> layout.paddingAll(7).gapAll(5));
        // create a UI
        var ui = UI.of(root);
        // return a modular UI for runtime instance
        return ModularUI.of(ui);
    }

    private static ModularUI createModularXML() {
        ResourceLocation screen = rl("modular_ui/main.xml");
        var xml = XmlUtils.loadXml(screen);
        if (xml != null) {
            var ui = UI.of(xml);
            return ModularUI.of(ui);
        }

        return null;
    }


    public static ModularUI createUI() {
        var root = new UIElement();//
        root.addChildren(
                new Label().setText(Component.translatable("fisch.modular_ui.main.headline"))
                        .textStyle(textStyle -> textStyle.textAlignHorizontal(Horizontal.CENTER))
        );
        return ModularUI.of(UI.of(root));
    }
}
