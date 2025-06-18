package net.luckystudios.luckyswardrobe.items.cosmetics;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final Holder<ArmorMaterial> COSMETIC = register("cosmetic",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                // Increased protection values by 1 and body by 3
            }),
            SoundEvents.ARMOR_EQUIP_LEATHER,
            9,
            0.0f,
            0.0f,
            () -> Items.LEATHER,
            List.of(
                    new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, "leather"), "", false),
                    new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, "leather"), "_overlay", true)
            )
    );

//    public static final Holder<ArmorMaterial> DYEABLE_LEATHER_COSMETIC = register("dyeable_leather_cosmetic",
//            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
//                // Increased protection values by 1 and body by 3
////                attribute.put(ArmorItem.Type.BOOTS, 0);
////                attribute.put(ArmorItem.Type.LEGGINGS, 0);
////                attribute.put(ArmorItem.Type.CHESTPLATE, 0);
////                attribute.put(ArmorItem.Type.HELMET, 0);
////                attribute.put(ArmorItem.Type.BODY, 0);
//            }),
//            SoundEvents.ARMOR_EQUIP_LEATHER,
//            9,
//            0.0f,
//            0.0f,
//            () -> Items.LEATHER,
//            List.of(
//                    new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, "leather"), "", false),
//                    new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, "leather"), "_overlay", true)
//            )
//    );

    public static final CauldronInteraction DYED_ARMOR_ITEM = (state, level, pos, player, hand, stack) -> {
        ItemStack result = stack.copy();
        result.set(DataComponents.DYED_COLOR, new DyedItemColor(DyeColor.WHITE.getTextureDiffuseColor(), false));
        level.setBlock(pos, state.setValue(LayeredCauldronBlock.LEVEL, 1), 3);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state));
        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
        }
        if (!player.getInventory().add(result)) {
            player.drop(result, false);
        }
        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    };

    private static Holder<ArmorMaterial> register(
            String name,
            EnumMap<ArmorItem.Type, Integer> typeProtection,
            Holder<SoundEvent> equipSound,
            int enchantability,
            float toughness,
            float knockbackResistance,
            Supplier<Item> repairIngredient) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(repairIngredient.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }

    private static Holder<ArmorMaterial> register(
            String name,
            EnumMap<ArmorItem.Type, Integer> typeProtection,
            Holder<SoundEvent> equipSound,
            int enchantability,
            float toughness,
            float knockbackResistance,
            Supplier<Item> repairIngredient,
            List<ArmorMaterial.Layer> layers) {

        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(repairIngredient.get());

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}