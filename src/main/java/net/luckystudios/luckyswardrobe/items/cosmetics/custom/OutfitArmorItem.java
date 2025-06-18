package net.luckystudios.luckyswardrobe.items.cosmetics.custom;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.datagen.types.item_tags.ModItemTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

// This item is completely dyed, and doesn't have a layer that is separate from the dye
public class OutfitArmorItem extends ArmorItem {

    public String COSMETIC_PATH = "textures/entity/";

    public OutfitArmorItem(Type type, Properties properties) {
        super(ArmorMaterials.LEATHER, type, properties.stacksTo(1));
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        ResourceLocation registryName = BuiltInRegistries.ITEM.getKey(stack.getItem()); // Get the item's registry name

        String itemName = registryName.getPath(); // e.g., "hat", "crown", etc.

        // Get first word in itemName
        String[] words = itemName.split("_");
        String firstWord = words[0];

        String texturePath;
        if (slot == EquipmentSlot.HEAD) {
            texturePath = COSMETIC_PATH + firstWord + "_head";
        } else {
            texturePath = COSMETIC_PATH + firstWord + "_outfit";
        }

        if (stack.is(ItemTags.DYEABLE) && layer.dyeable()) {
            return ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, texturePath + "_dye_overlay.png");
        }

        return ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, texturePath + ".png");
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return stack.is(ModItemTags.SNOW_WALKERS);
    }
}