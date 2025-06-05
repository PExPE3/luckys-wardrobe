package net.luckystudios.luckyswardrobe.items.cosmetics.custom;

import io.wispforest.accessories.api.AccessoryItem;
import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.Nullable;

public class CosmeticArmorItem extends AccessoryItem {

    public String COSMETIC_PATH = "textures/entity/cosmetic/";

    public CosmeticArmorItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        ResourceLocation registryName = BuiltInRegistries.ITEM.getKey(stack.getItem()); // Get the item's registry name

        String itemName = registryName.getPath(); // e.g., "hat", "crown", etc.

        String texturePath = COSMETIC_PATH + itemName;
        return ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, texturePath + ".png");
    }

}