package net.luckystudios.luckyswardrobe.datagen.types;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, LuckysWardrobe.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.DYEABLE)
                .add(ModItems.TAIGA_HOOD.get())
                .add(ModItems.HAT.get())
                .add(ModItems.TOP_HAT.get())
                .add(ModItems.SCARF.get())
        ;
    }
}
