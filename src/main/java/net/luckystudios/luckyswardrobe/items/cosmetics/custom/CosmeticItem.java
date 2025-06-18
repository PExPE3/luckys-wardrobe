package net.luckystudios.luckyswardrobe.items.cosmetics.custom;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.items.cosmetics.ModArmorMaterials;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.Nullable;

public class CosmeticItem extends ArmorItem {

    public String COSMETIC_PATH = "textures/entity/";

    public CosmeticItem(ArmorItem.Type type, Item.Properties properties) {
        super(ModArmorMaterials.COSMETIC, type, properties.stacksTo(1));
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        ResourceLocation registryName = BuiltInRegistries.ITEM.getKey(stack.getItem()); // Get the item's registry name

        String itemName = registryName.getPath(); // e.g., "hat", "crown", etc.

        String texturePath = COSMETIC_PATH + itemName;
        if (stack.is(ItemTags.DYEABLE) && layer.dyeable()) {
            return ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, texturePath + "_dye_overlay.png");
        }
        return ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, texturePath + ".png");
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return ItemAttributeModifiers.builder().build();
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        return ItemAttributeModifiers.builder().build();
    }
}