package net.luckystudios.luckyswardrobe.items.cosmetics.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.Nullable;

// This item is completely dyed, and doesn't have a layer that is separate from the dye
public class VillagerProfessionArmorItem extends CosmeticItem {

    private final ResourceLocation professionTexture;

    public VillagerProfessionArmorItem(ResourceLocation professionTexture, Properties properties) {
        super(Type.CHESTPLATE, properties);
        this.professionTexture = professionTexture;
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        return professionTexture;
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