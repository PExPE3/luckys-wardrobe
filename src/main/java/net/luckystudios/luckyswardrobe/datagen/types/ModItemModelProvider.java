package net.luckystudios.luckyswardrobe.datagen.types;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.items.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LuckysWardrobe.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // Hats
        registerDyedItemWithLayer(ModItems.HAT.get());
        registerDyedItemWithLayer(ModItems.TOP_HAT.get());
        registerDyedItemWithLayer(ModItems.EXPLORERS_HAT.get());
        basicItem(ModItems.FARMER_HAT.get());
        basicItem(ModItems.BLACKSMITH_MASK.get());
        basicItem(ModItems.WITCH_HAT.get());
        basicItem(ModItems.FOX_HAT.get());
        basicItem(ModItems.SNOW_FOX_HAT.get());
        basicItem(ModItems.WOLF_HAT.get());
        basicItem(ModItems.PANDA_HAT.get());
        basicItem(ModItems.BEE_HAT.get());
        basicItem(ModItems.CHEF_HAT.get());
        registerDyedItem(ModItems.SCARF.get());

        // Professions
        basicItem(ModItems.LEATHER_APRON.get());
        basicItem(ModItems.HARDENED_LEATHER_APRON.get());
        basicItem(ModItems.BUTCHERS_APRON.get());
        basicItem(ModItems.CLERICS_APRON.get());
        basicItem(ModItems.FISHING_APRON.get());
        basicItem(ModItems.CHITON.get());
        basicItem(ModItems.MASONS_APRON.get());
        basicItem(ModItems.WOOL_VEST.get());

        registerDyedItemWithLayer(ModItems.TAIGA_HOOD.get());
        registerDyedItemWithLayer(ModItems.TAIGA_COAT.get());
        registerDyedItemWithLayer(ModItems.TAIGA_PANTS.get());
        registerDyedItemWithLayer(ModItems.TAIGA_BOOTS.get());

        registerDyedItemWithLayer(ModItems.SNOWY_HOOD.get());
        registerDyedItemWithLayer(ModItems.SNOWY_HAT.get());
        registerDyedItemWithLayer(ModItems.SNOWY_COAT.get());
        registerDyedItemWithLayer(ModItems.SNOWY_PANTS.get());
        registerDyedItemWithLayer(ModItems.SNOWY_BOOTS.get());

        basicItem(ModItems.SAVANNA_FLORAL_CROWN.get());
        basicItem(ModItems.SAVANNA_ROBE.get());
        basicItem(ModItems.SAVANNA_PANTS.get());
        basicItem(ModItems.SAVANNA_SANDALS.get());

        basicItem(ModItems.SWAMPY_HAT.get());
        basicItem(ModItems.SWAMPY_ROBE.get());
        basicItem(ModItems.SWAMPY_PANTS.get());
        basicItem(ModItems.SWAMPY_SHOES.get());

        basicItem(ModItems.JUNGLE_ROBE.get());
        basicItem(ModItems.JUNGLE_PANTS.get());
        basicItem(ModItems.JUNGLE_SANDALS.get());

        basicItem(ModItems.DESERT_HAT.get());
        basicItem(ModItems.DESERT_ROBE.get());
        basicItem(ModItems.DESERT_PANTS.get());
        basicItem(ModItems.DESERT_SANDALS.get());

        basicItem(ModItems.ENTERTAINERS_HAT.get());
        basicItem(ModItems.ENTERTAINERS_SHIRT.get());
        basicItem(ModItems.ENTERTAINERS_PANTS.get());
        basicItem(ModItems.ENTERTAINERS_SHOES.get());

        // Miscellaneous
        basicItem(ModItems.BROKEN_BARREL.get());
    }

    // This is for items that are completely dyed and don't have a layer that is separate from the dye
    private void registerDyedItem(Item item) {
        withExistingParent(itemName(item), "item/generated")
                .texture("layer0", modLoc("item/" + itemName(item)).toString());
    }

    // This is for items that have a layer that is separate from the dye
    private void registerDyedItemWithLayer(Item item) {
        withExistingParent(itemName(item), "item/generated")
                .texture("layer0", modLoc("item/" + itemName(item)).toString())
                .texture("layer1", modLoc("item/" + itemName(item)) + "_dye_overlay");
    }

    private static String itemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }
}
