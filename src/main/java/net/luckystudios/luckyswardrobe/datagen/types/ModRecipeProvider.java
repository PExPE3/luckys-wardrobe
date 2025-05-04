package net.luckystudios.luckyswardrobe.datagen.types;

import net.luckystudios.luckyswardrobe.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        // Leather Apron
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LEATHER_APRON.get())
                .pattern(" # ")
                .pattern("###")
                .define('#', Items.LEATHER)
                .unlockedBy("has_leather", has(Items.LEATHER)).save(recipeOutput);

        // Hardened Leather Apron
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HARDENED_LEATHER_APRON.get())
                .pattern("@#@")
                .pattern("###")
                .define('#', Items.LEATHER)
                .define('@', Items.IRON_INGOT)
                .unlockedBy("has_gold", has(Items.IRON_INGOT)).save(recipeOutput);

        // Hat
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HAT.get())
                .pattern(" # ")
                .pattern("# #")
                .define('#', Items.LEATHER)
                .unlockedBy("has_leather", has(Items.LEATHER)).save(recipeOutput);
    }
}
