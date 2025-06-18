package net.luckystudios.luckyswardrobe.items.cosmetics.custom;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.components.ModDataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class HoodArmorItem extends ArmorItem {

    public String COSMETIC_PATH = "textures/entity/";

    public HoodArmorItem(Properties properties) {
        super(ArmorMaterials.LEATHER, Type.HELMET, properties.stacksTo(1));
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        ResourceLocation registryName = BuiltInRegistries.ITEM.getKey(stack.getItem()); // Get the item's registry name
        String itemName = registryName.getPath(); // e.g., "hat", "crown", etc.

        // Get first word in itemName
        String[] words = itemName.split("_");
        String firstWord = words[0];

        boolean isOpened = Boolean.TRUE.equals(stack.get(ModDataComponents.OPENED));

        String texturePath;
        if (stack.is(ItemTags.DYEABLE) && layer.dyeable()) {
            texturePath = COSMETIC_PATH + firstWord + (isOpened ? "_hood_opened_dye_overlay" : "_hood_dye_overlay");
        } else {
            texturePath = COSMETIC_PATH + firstWord + (isOpened ? "_hood_opened" : "_hood");
        }
        return ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, texturePath + ".png");
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}