package net.luckystudios.luckyswardrobe.items.cosmetics;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

// This item is completely dyed, and doesn't have a layer that is separate from the dye
public class CosmeticArmorItem extends DyeableCosmeticArmorItem {

    public CosmeticArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        ResourceLocation registryName = BuiltInRegistries.ITEM.getKey(stack.getItem()); // Get the item's registry name

        String itemName = registryName.getPath(); // e.g., "hat", "crown", etc.

        String texturePath = COSMETIC_PATH + itemName;

        return ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, texturePath + ".png");
    }

}