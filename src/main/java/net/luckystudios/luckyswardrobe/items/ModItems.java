package net.luckystudios.luckyswardrobe.items;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.components.ModDataComponents;
import net.luckystudios.luckyswardrobe.items.cosmetics.custom.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LuckysWardrobe.MOD_ID);

    // Hats
    public static final DeferredItem<Item> HAT = ITEMS.register("hat",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<CosmeticItem> TOP_HAT = ITEMS.register("top_hat",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<CosmeticItem> EXPLORERS_HAT = ITEMS.register("explorers_hat",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<CosmeticItem> FARMER_HAT = ITEMS.register("farmer_hat",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<CosmeticItem> BLACKSMITH_MASK = ITEMS.register("blacksmith_mask",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<CosmeticItem> WITCH_HAT = ITEMS.register("witch_hat",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<CosmeticItem> FOX_HAT = ITEMS.register("fox_hat",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<CosmeticItem> SNOW_FOX_HAT = ITEMS.register("snow_fox_hat",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<CosmeticItem> WOLF_HAT = ITEMS.register("wolf_hat",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<CosmeticItem> PANDA_HAT = ITEMS.register("panda_hat",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<CosmeticItem> BEE_HAT = ITEMS.register("bee_hat",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<CosmeticItem> CHEF_HAT = ITEMS.register("chef_hat",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<CosmeticItem> SCARF = ITEMS.register("scarf",
            () -> new CosmeticItem(ArmorItem.Type.HELMET, new Item.Properties()));

    // Villager profession cosmetics
    public static final DeferredItem<VillagerProfessionArmorItem> LEATHER_APRON = ITEMS.register("leather_apron",
            () -> new VillagerProfessionArmorItem(ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/leatherworker.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> HARDENED_LEATHER_APRON = ITEMS.register("hardened_leather_apron",
            () -> new VillagerProfessionArmorItem(ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/armorer.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> BUTCHERS_APRON = ITEMS.register("butchers_apron",
            () -> new VillagerProfessionArmorItem(ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/butcher.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> CLERICS_APRON = ITEMS.register("clerics_apron",
            () -> new VillagerProfessionArmorItem(ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/cleric.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> FISHING_APRON = ITEMS.register("fishing_apron",
            () -> new VillagerProfessionArmorItem(ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/fisherman.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> CHITON = ITEMS.register("chiton",
            () -> new VillagerProfessionArmorItem(ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/librarian.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> MASONS_APRON = ITEMS.register("masons_apron",
            () -> new VillagerProfessionArmorItem(ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/mason.png"), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<VillagerProfessionArmorItem> WOOL_VEST = ITEMS.register("wool_vest",
            () -> new VillagerProfessionArmorItem(ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/shepherd.png"), new Item.Properties().stacksTo(1)));

    // Clothing
    public static final DeferredItem<OutfitArmorItem> TAIGA_HOOD = ITEMS.register("taiga_hood",
            () -> new OutfitArmorItem(ArmorItem.Type.HELMET, new Item.Properties().component(ModDataComponents.OPENED, false)));
    public static final DeferredItem<OutfitArmorItem> TAIGA_COAT = ITEMS.register("taiga_coat",
            () -> new OutfitArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> TAIGA_PANTS = ITEMS.register("taiga_pants",
            () -> new OutfitArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> TAIGA_BOOTS = ITEMS.register("taiga_boots",
            () -> new OutfitArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<HoodArmorItem> SNOWY_HOOD = ITEMS.register("snowy_hood",
            () -> new HoodArmorItem(new Item.Properties().component(ModDataComponents.OPENED, false)));
    public static final DeferredItem<OutfitArmorItem> SNOWY_HAT = ITEMS.register("snowy_hat",
            () -> new OutfitArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SNOWY_COAT = ITEMS.register("snowy_coat",
            () -> new OutfitArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SNOWY_PANTS = ITEMS.register("snowy_pants",
            () -> new OutfitArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SNOWY_BOOTS = ITEMS.register("snowy_boots",
            () -> new OutfitArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<OutfitArmorItem> DESERT_HAT = ITEMS.register("desert_hat",
            () -> new OutfitArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> DESERT_ROBE = ITEMS.register("desert_robe",
            () -> new OutfitArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> DESERT_PANTS = ITEMS.register("desert_pants",
            () -> new OutfitArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> DESERT_SANDALS = ITEMS.register("desert_sandals",
            () -> new OutfitArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<OutfitArmorItem> SAVANNA_FLORAL_CROWN = ITEMS.register("savanna_floral_crown",
            () -> new OutfitArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SAVANNA_ROBE = ITEMS.register("savanna_robe",
            () -> new OutfitArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SAVANNA_PANTS = ITEMS.register("savanna_pants",
            () -> new OutfitArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SAVANNA_SANDALS = ITEMS.register("savanna_sandals",
            () -> new OutfitArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<OutfitArmorItem> JUNGLE_ROBE = ITEMS.register("jungle_robe",
            () -> new OutfitArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> JUNGLE_PANTS = ITEMS.register("jungle_pants",
            () -> new OutfitArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> JUNGLE_SANDALS = ITEMS.register("jungle_sandals",
            () -> new OutfitArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<OutfitArmorItem> SWAMPY_HAT = ITEMS.register("swampy_hat",
            () -> new OutfitArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SWAMPY_ROBE = ITEMS.register("swampy_robe",
            () -> new OutfitArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SWAMPY_PANTS = ITEMS.register("swampy_pants",
            () -> new OutfitArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<OutfitArmorItem> SWAMPY_SHOES = ITEMS.register("swampy_shoes",
            () -> new OutfitArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<OutfitArmorItem> ENTERTAINERS_HAT = ITEMS.register("entertainers_hat",
            () -> new OutfitArmorItem(ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<OutfitArmorItem> ENTERTAINERS_SHIRT = ITEMS.register("entertainers_shirt",
            () -> new OutfitArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<OutfitArmorItem> ENTERTAINERS_PANTS = ITEMS.register("entertainers_pants",
            () -> new OutfitArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<OutfitArmorItem> ENTERTAINERS_SHOES = ITEMS.register("entertainers_shoes",
            () -> new OutfitArmorItem(ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.UNCOMMON)));

    // Miscellaneous items
    public static final DeferredItem<CosmeticItem> BROKEN_BARREL = ITEMS.register("broken_barrel",
            () -> new CosmeticItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
