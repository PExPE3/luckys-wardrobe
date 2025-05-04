package net.luckystudios.luckyswardrobe.items.cosmetics;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

// This item is completely dyed, and doesn't have a layer that is separate from the dye
public class VillagerProfessionArmorItem extends CosmeticArmorItem {

    private final ResourceLocation professionTexture;

    public VillagerProfessionArmorItem(Holder<ArmorMaterial> material, Type type, ResourceLocation professionTexture, Properties properties) {
        super(material, type, properties);
        this.professionTexture = professionTexture;
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        return professionTexture;
    }
}