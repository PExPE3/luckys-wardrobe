package net.luckystudios.luckyswardrobe.items.cosmetics.custom;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.items.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

// This item is completely dyed, and doesn't have a layer that is separate from the dye
public class OutfitArmorItem extends ArmorItem {

    public String COSMETIC_PATH = "textures/entity/cosmetic/";

    public OutfitArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
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
        return ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, texturePath + ".png");
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
//        return stack.is(ModItems.TAIGA_BOOTS);
        return false;
    }
}