package net.luckystudios.luckyswardrobe.datagen.types.entity_tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

// Copied from EntityTypeTags
public class ModEntityTypeTags {

    public static final TagKey<EntityType<?>> WEAR_COSMETICS = create("wear_cosmetics");

    private static TagKey<EntityType<?>> create(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace(name));
    }
}