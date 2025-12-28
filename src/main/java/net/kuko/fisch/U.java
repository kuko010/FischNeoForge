package net.kuko.fisch;

import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

public class U {
    public static ResourceLocation rl(String s) {
        return ResourceLocation.fromNamespaceAndPath(Fisch.MOD_ID, s);
    }

    /*
     Method copied from Kapitencraft's kap_lib
     Adapted for compatibility with this project.
     */
    /**
     * merge the given r, g, b and a values into a packed integer
     */
    public static int ARGBtoInt(int a, int r, int g, int b) {
        int returnable = (a << 8) + r;
        returnable = (returnable << 8) + g;
        return (returnable << 8) + b;
    }

    @Nullable
    public static Method getMethodByName(String className, String methodName) {
        try { // "net.minecraft.resources.ResourceLocation"
            Class<?> clazz = Class.forName(className);
            for (Method method : clazz.getMethods()) {
                if (method.getName().equals(methodName)) {
                    return method;
                }
            }
        } catch (ClassNotFoundException e) {
            Fisch.LOGGER.error("Reflection failed", e);
        }
        return null;
    }
}

