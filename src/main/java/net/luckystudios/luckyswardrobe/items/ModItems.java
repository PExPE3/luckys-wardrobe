package net.luckystudios.luckyswardrobe.items;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.items.cosmetics.CosmeticArmorItem;
import net.luckystudios.luckyswardrobe.items.cosmetics.DyeableCosmeticArmorItem;
import net.luckystudios.luckyswardrobe.items.cosmetics.ModArmorMaterials;
import net.luckystudios.luckyswardrobe.items.cosmetics.VillagerProfessionArmorItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LuckysWardrobe.MOD_ID);

    public static final DeferredItem<VillagerProfessionArmorItem> LEATHER_APRON = ITEMS.register("leather_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/leatherworker.png"), new Item.Properties()));

    public static final DeferredItem<VillagerProfessionArmorItem> HARDENED_LEATHER_APRON = ITEMS.register("hardened_leather_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/armorer.png"), new Item.Properties()));

    public static final DeferredItem<VillagerProfessionArmorItem> BUTCHERS_APRON = ITEMS.register("butchers_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/butcher.png"), new Item.Properties()));

    public static final DeferredItem<VillagerProfessionArmorItem> CLERICS_APRON = ITEMS.register("clerics_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/cleric.png"), new Item.Properties()));

    public static final DeferredItem<VillagerProfessionArmorItem> FISHING_APRON = ITEMS.register("fishing_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.LEATHER_COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/fisherman.png"), new Item.Properties()));

    public static final DeferredItem<VillagerProfessionArmorItem> CHITON = ITEMS.register("chiton",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/librarian.png"), new Item.Properties()));

    public static final DeferredItem<VillagerProfessionArmorItem> MASONS_APRON = ITEMS.register("masons_apron",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/mason.png"), new Item.Properties()));

    public static final DeferredItem<VillagerProfessionArmorItem> WOOL_VEST = ITEMS.register("wool_vest",
            () -> new VillagerProfessionArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.CHESTPLATE, ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/shepherd.png"), new Item.Properties()));

    public static final DeferredItem<DyeableCosmeticArmorItem> HAT = ITEMS.register("hat",
            () -> new DyeableCosmeticArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<DyeableCosmeticArmorItem> TOP_HAT = ITEMS.register("top_hat",
            () -> new DyeableCosmeticArmorItem(ModArmorMaterials.DYEABLE_LEATHER_COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<DyeableCosmeticArmorItem> FOX_HAT = ITEMS.register("fox_hat",
            () -> new CosmeticArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<DyeableCosmeticArmorItem> SNOW_FOX_HAT = ITEMS.register("snow_fox_hat",
            () -> new CosmeticArmorItem(ModArmorMaterials.COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<DyeableCosmeticArmorItem> SCARF = ITEMS.register("scarf",
            () -> new CosmeticArmorItem(ModArmorMaterials.DYEABLE_COSMETIC, ArmorItem.Type.HELMET, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
