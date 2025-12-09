package net.kuko.fisch.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class FischKeyMappings {
    public static final KeyMapping open = new KeyMapping(
    "key.fisch.open",
    InputConstants.Type.KEYSYM,
    GLFW.GLFW_KEY_K,
    "key.categories.fisch.fisch"
    );
}
