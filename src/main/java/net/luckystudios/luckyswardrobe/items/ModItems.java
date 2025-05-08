package net.luckystudios.luckyswardrobe.items;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.components.ModDataComponents;
import net.luckystudios.luckyswardrobe.items.cosmetics.custom.*;
import net.luckystudios.luckyswardrobe.items.cosmetics.ModArmorMaterials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LuckysWardrobe.MOD_ID);

    // Villager profession cosmetics
    public static final DeferredItem<VillagerProfessionArmorItem> LEATHER_APRON = ITEMS.register("leather_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/leatherworker.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> HARDENED_LEATHER_APRON = ITEMS.register("hardened_leather_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/armorer.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> BUTCHERS_APRON = ITEMS.register("butchers_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/butcher.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> CLERICS_APRON = ITEMS.register("clerics_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/cleric.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> FISHING_APRON = ITEMS.register("fishing_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/fisherman.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> CHITON = ITEMS.register("chiton",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/librarian.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> MASONS_APRON = ITEMS.register("masons_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/mason.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> WOOL_VEST = ITEMS.register("wool_vest",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/shepherd.png"), new Item.Properties().stacksTo(1)));

    // Clothing
    public static final DeferredItem<DyeableOutfitArmorItem> TAIGA_HOOD = ITEMS.register("taiga_hood",
            () -> new DyeableOutfitArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.HELMET, new Item.Properties().component(ModDataComponents.OPENED, false)));
    public static final DeferredItem<DyeableOutfitArmorItem> TAIGA_COAT = ITEMS.register("taiga_coat",
            () -> new DyeableOutfitArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<DyeableOutfitArmorItem> TAIGA_PANTS = ITEMS.register("taiga_pants",
            () -> new DyeableOutfitArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<DyeableOutfitArmorItem> TAIGA_BOOTS = ITEMS.register("taiga_boots",
            () -> new DyeableOutfitArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<DyeableHoodArmorItem> SNOWY_HOOD = ITEMS.register("snowy_hood",
            () -> new DyeableHoodArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.HELMET, new Item.Properties().component(ModDataComponents.OPENED, false)));
    public static final DeferredItem<DyeableOutfitArmorItem> SNOWY_HAT = ITEMS.register("snowy_hat",
            () -> new DyeableOutfitArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<DyeableOutfitArmorItem> SNOWY_COAT = ITEMS.register("snowy_coat",
            () -> new DyeableOutfitArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<DyeableOutfitArmorItem> SNOWY_PANTS = ITEMS.register("snowy_pants",
            () -> new DyeableOutfitArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<DyeableOutfitArmorItem> SNOWY_BOOTS = ITEMS.register("snowy_boots",
            () -> new DyeableOutfitArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<OutfitArmorItem> SAVANNA_FLORAL_CROWN = ITEMS.register("savanna_floral_crown",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SAVANNA_ROBE = ITEMS.register("savanna_robe",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SAVANNA_PANTS = ITEMS.register("savanna_pants",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SAVANNA_SANDALS = ITEMS.register("savanna_sandals",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<OutfitArmorItem> SWAMPY_HAT = ITEMS.register("swampy_hat",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SWAMPY_ROBE = ITEMS.register("swampy_robe",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SWAMPY_PANTS = ITEMS.register("swampy_pants",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SWAMPY_SHOES = ITEMS.register("swampy_shoes",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<OutfitArmorItem> JUNGLE_ROBE = ITEMS.register("jungle_robe",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> JUNGLE_PANTS = ITEMS.register("jungle_pants",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> JUNGLE_SANDALS = ITEMS.register("jungle_sandals",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<OutfitArmorItem> DESERT_HAT = ITEMS.register("desert_hat",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> DESERT_ROBE = ITEMS.register("desert_robe",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> DESERT_PANTS = ITEMS.register("desert_pants",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> DESERT_SANDALS = ITEMS.register("desert_sandals",
            () -> new OutfitArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Hats
    public static final DeferredItem<DyeableCosmeticArmorItem> BLACKSMITH_MASK = ITEMS.register("blacksmith_mask",
            () -> new DyeableCosmeticArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<DyeableCosmeticArmorItem> FARMER_HAT = ITEMS.register("farmer_hat",
            () -> new DyeableCosmeticArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<DyeableCosmeticArmorItem> HAT = ITEMS.register("hat",
            () -> new DyeableCosmeticArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<DyeableCosmeticArmorItem> TOP_HAT = ITEMS.register("top_hat",
            () -> new DyeableCosmeticArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<DyeableCosmeticArmorItem> EXPLORERS_HAT = ITEMS.register("explorers_hat",
            () -> new DyeableCosmeticArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<CosmeticArmorItem> WITCH_HAT = ITEMS.register("witch_hat",
            () -> new CosmeticArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<CosmeticArmorItem> FOX_HAT = ITEMS.register("fox_hat",
            () -> new CosmeticArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<CosmeticArmorItem> SNOW_FOX_HAT = ITEMS.register("snow_fox_hat",
            () -> new CosmeticArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<DyeableCosmeticArmorItem> SCARF = ITEMS.register("scarf",
            () -> new DyeableCosmeticArmorItem(ModArmorMaterials.DYEABLE_COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
