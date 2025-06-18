package net.luckystudios.luckyswardrobe.datagen.types.entity_tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public ModEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        super.addTags(provider);

        tag(ModEntityTypeTags.WEAR_COSMETICS)
                .add(EntityType.ZOMBIE)
                .add(EntityType.SKELETON)
                .add(EntityType.STRAY)
                .add(EntityType.HUSK)
                .add(EntityType.DROWNED)
        ;
    }
}
