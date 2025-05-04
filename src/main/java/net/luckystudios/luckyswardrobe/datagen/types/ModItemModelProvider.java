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
        basicItem(ModItems.LEATHER_APRON.get());
        basicItem(ModItems.HARDENED_LEATHER_APRON.get());
        basicItem(ModItems.BUTCHERS_APRON.get());
        basicItem(ModItems.CLERICS_APRON.get());
        basicItem(ModItems.FISHING_APRON.get());
        basicItem(ModItems.CHITON.get());
        basicItem(ModItems.MASONS_APRON.get());
        basicItem(ModItems.WOOL_VEST.get());
        registerDyedItemWithLayer(ModItems.HAT.get());
        registerDyedItemWithLayer(ModItems.TOP_HAT.get());
        basicItem(ModItems.FOX_HAT.get());
        basicItem(ModItems.SNOW_FOX_HAT.get());
        registerDyedItem(ModItems.SCARF.get());
    }

    // This is for items that are completely dyed, and don't have a layer that is separate from the dye
    private void registerDyedItem(Item item) {
        withExistingParent(itemName(item), "item/generated")
                .texture("layer0", modLoc("item/" + itemName(item)).toString());
    }

    // This is for items that have a layer that is separate from the dye
    private void registerDyedItemWithLayer(Item item) {
        withExistingParent(itemName(item), "item/generated")
                .texture("layer0", modLoc("item/" + itemName(item)).toString())
                .texture("layer1", modLoc("item/" + itemName(item)).toString() + "_dye_overlay");
    }

    private static String itemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }
}
