package net.luckystudios.luckyswardrobe.datagen.types.item_tags;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> SNOW_WALKERS = createTag("snow_walkers");

    private static TagKey<Item> createTag(String name) {
        return ItemTags.create(LuckysWardrobe.id(name));
    }
}
