package net.kuko.fisch.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class FischKeyMappings {
    public static final KeyMapping open = new KeyMapping(
    "key.fisch.open", // Will be localized using this translation key
    InputConstants.Type.KEYSYM, // Default mapping is on the keyboard
    GLFW.GLFW_KEY_K, // Default key is P
    "key.categories.fisch.fisch" // Mapping will be in the misc category
    );
}
