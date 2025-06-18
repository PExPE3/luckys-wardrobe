package net.luckystudios.luckyswardrobe;

import net.neoforged.neoforge.common.ModConfigSpec;

public class LuckysWardrobeConfig {
    // === Spec Builders ===
    public static ModConfigSpec COMMON_CONFIG;

    // === CATEGORY MOB CONFIGURATION ===
    public static String MOBS = "mobSpawning";
    public static ModConfigSpec.DoubleValue MODS_SPAWN_COSMETICS_CHANCE;
    public static ModConfigSpec.DoubleValue MODS_DROP_COSMETICS_CHANCE;

    static {
        ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();

        COMMON_BUILDER.comment("Mob Settings").push(MOBS);

        MODS_SPAWN_COSMETICS_CHANCE = COMMON_BUILDER
                .comment("The chance mobs can spawn with cosmetic armor? 0 disables this feature.")
                .defineInRange("mobCosmetics", 0.05, 0.0, 1.0);

        MODS_DROP_COSMETICS_CHANCE = COMMON_BUILDER
                .comment("The chance mobs can drop their cosmetics. 0 disables this feature. Ex. Witches dropping their hats.")
                .defineInRange("mobCosmetics", 0.05, 0.0, 1.0);

        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
