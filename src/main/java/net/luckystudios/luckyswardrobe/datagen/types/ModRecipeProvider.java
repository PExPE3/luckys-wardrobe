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

        // Hats
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HAT.get())
                .pattern(" # ")
                .pattern("# #")
                .define('#', Items.LEATHER)
                .unlockedBy("has_leather", has(Items.LEATHER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TOP_HAT.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern("# #")
                .define('#', Items.LEATHER)
                .unlockedBy("has_leather", has(Items.LEATHER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SCARF.get())
                .pattern("# #")
                .pattern("###")
                .define('#', Items.WHITE_WOOL)
                .unlockedBy("has_wool", has(Items.WHITE_WOOL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACKSMITH_MASK.get())
                .pattern("#@#")
                .define('#', Items.LEATHER)
                .define('@', Items.IRON_INGOT)
                .unlockedBy("has_wool", has(Items.WHITE_WOOL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHEF_HAT.get())
                .pattern("###")
                .pattern("###")
                .pattern("# #")
                .define('#', Items.WHITE_WOOL)
                .unlockedBy("has_wool", has(Items.WHITE_WOOL)).save(recipeOutput);

        // Professions
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.LEATHER_APRON.get())
                .pattern(" # ")
                .pattern("%#%")
                .define('#', Items.LEATHER)
                .define('%', Items.LEAD)
                .unlockedBy("has_lead", has(Items.LEAD)).save(recipeOutput);

        // Hardened Leather Apron
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HARDENED_LEATHER_APRON.get())
                .pattern("@#@")
                .pattern("%#%")
                .define('#', Items.LEATHER)
                .define('@', Items.IRON_INGOT)
                .define('%', Items.LEAD)
                .unlockedBy("has_lead", has(Items.LEAD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BUTCHERS_APRON.get())
                .pattern(" # ")
                .pattern("%#%")
                .define('#', Items.WHITE_WOOL)
                .define('%', Items.LEAD)
                .unlockedBy("has_lead", has(Items.LEAD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CLERICS_APRON.get())
                .pattern(" # ")
                .pattern("%#%")
                .define('#', Items.PURPLE_WOOL)
                .define('%', Items.LEAD)
                .unlockedBy("has_lead", has(Items.LEAD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FISHING_APRON.get())
                .pattern("@#@")
                .pattern("%#%")
                .define('#', Items.LEATHER)
                .define('@', Items.IRON_NUGGET)
                .define('%', Items.LEAD)
                .unlockedBy("has_lead", has(Items.LEAD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHITON.get())
                .pattern("  #")
                .pattern("%#%")
                .define('#', Items.WHITE_WOOL)
                .define('%', Items.LEAD)
                .unlockedBy("has_lead", has(Items.LEAD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MASONS_APRON.get())
                .pattern(" # ")
                .pattern("%#%")
                .define('#', Items.GRAY_WOOL)
                .define('%', Items.LEAD)
                .unlockedBy("has_lead", has(Items.LEAD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOOL_VEST.get())
                .pattern("# #")
                .pattern("%#%")
                .define('#', Items.WHITE_WOOL)
                .define('%', Items.LEAD)
                .unlockedBy("has_lead", has(Items.LEAD)).save(recipeOutput);

        // Taiga Outfit
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TAIGA_HOOD.get())
                .pattern("#@#")
                .pattern("@#@")
                .define('#', Items.LEATHER)
                .define('@', Items.WHITE_WOOL)
                .unlockedBy("has_lead", has(Items.LEATHER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TAIGA_COAT.get())
                .pattern("@@@")
                .pattern("###")
                .pattern("###")
                .define('#', Items.LEATHER)
                .define('@', Items.WHITE_WOOL)
                .unlockedBy("has_leather", has(Items.LEATHER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TAIGA_PANTS.get())
                .pattern("#%#")
                .pattern("@ @")
                .pattern("@ @")
                .define('#', Items.LEATHER)
                .define('@', Items.BLACK_WOOL)
                .define('%', Items.LEAD)
                .unlockedBy("has_leather", has(Items.LEATHER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TAIGA_BOOTS.get())
                .pattern("# #")
                .pattern("@ @")
                .define('#', Items.LEATHER)
                .define('@', Items.BLACK_WOOL)
                .unlockedBy("has_leather", has(Items.LEATHER)).save(recipeOutput);

        // Snowy Outfit
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SNOWY_HAT.get())
                .pattern("@@@")
                .pattern("# #")
                .define('#', Items.LEATHER)
                .define('@', Items.WHITE_WOOL)
                .unlockedBy("has_wool", has(Items.WHITE_WOOL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SNOWY_HOOD.get())
                .pattern("@@@")
                .pattern("@#@")
                .define('#', Items.LEATHER)
                .define('@', Items.CYAN_WOOL)
                .unlockedBy("has_wool", has(Items.WHITE_WOOL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SNOWY_COAT.get())
                .pattern("###")
                .pattern("@#@")
                .pattern("#@#")
                .define('#', Items.WHITE_WOOL)
                .define('@', Items.CYAN_WOOL)
                .unlockedBy("has_wool", has(Items.WHITE_WOOL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SNOWY_PANTS.get())
                .pattern("@%@")
                .pattern("# #")
                .pattern("@ @")
                .define('#', Items.LEATHER)
                .define('@', Items.BLACK_WOOL)
                .define('%', Items.LEAD)
                .unlockedBy("has_wool", has(Items.WHITE_WOOL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SNOWY_BOOTS.get())
                .pattern("@ @")
                .pattern("# #")
                .define('#', Items.LEATHER)
                .define('@', Items.BLACK_WOOL)
                .unlockedBy("has_wool", has(Items.WHITE_WOOL)).save(recipeOutput);

        // Savanna Outfit
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SAVANNA_FLORAL_CROWN.get())
                .pattern("@@@")
                .define('@', Items.ACACIA_LEAVES)
                .unlockedBy("has_acacia_leaves", has(Items.ACACIA_LEAVES)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SAVANNA_ROBE.get())
                .pattern("@ @")
                .pattern("@@@")
                .pattern("###")
                .define('@', Items.RED_WOOL)
                .define('#', Items.ACACIA_LEAVES)
                .unlockedBy("has_acacia_leaves", has(Items.ACACIA_LEAVES)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SAVANNA_PANTS.get())
                .pattern("#%#")
                .pattern("@ @")
                .pattern("@ @")
                .define('@', Items.WHITE_WOOL)
                .define('#', Items.LEATHER)
                .define('%', Items.IRON_NUGGET)
                .unlockedBy("has_acacia_leaves", has(Items.ACACIA_LEAVES)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SAVANNA_SANDALS.get())
                .pattern("# #")
                .pattern("@ @")
                .define('@', Items.LEATHER)
                .define('#', Items.LEAD)
                .unlockedBy("has_acacia_leaves", has(Items.ACACIA_LEAVES)).save(recipeOutput);

        // Swamp Outfit
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SWAMPY_HAT.get())
                .pattern("@@@")
                .define('@', Items.MANGROVE_LEAVES)
                .unlockedBy("has_mangrove_leaves", has(Items.MANGROVE_LEAVES)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SWAMPY_ROBE.get())
                .pattern("@ @")
                .pattern("@@@")
                .pattern("###")
                .define('@', Items.PURPLE_WOOL)
                .define('#', Items.MANGROVE_LEAVES)
                .unlockedBy("has_mangrove_leaves", has(Items.MANGROVE_LEAVES)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SWAMPY_PANTS.get())
                .pattern("#%#")
                .pattern("$ $")
                .pattern("@ @")
                .define('$', Items.MANGROVE_LEAVES)
                .define('@', Items.BLACK_WOOL)
                .define('#', Items.LEATHER)
                .define('%', Items.IRON_NUGGET)
                .unlockedBy("has_mangrove_leaves", has(Items.MANGROVE_LEAVES)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SWAMPY_SHOES.get())
                .pattern("@ @")
                .pattern("@ @")
                .define('@', Items.BLACK_WOOL)
                .unlockedBy("has_mangrove_leaves", has(Items.MANGROVE_LEAVES)).save(recipeOutput);

        // Jungle Outfit
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.JUNGLE_ROBE.get())
                .pattern("@ @")
                .pattern("@@@")
                .pattern("###")
                .define('@', Items.LEATHER)
                .define('#', Items.JUNGLE_LEAVES)
                .unlockedBy("has_jungle_leaves", has(Items.JUNGLE_LEAVES)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.JUNGLE_PANTS.get())
                .pattern("#@#")
                .pattern("# #")
                .pattern("# #")
                .define('#', Items.LEATHER)
                .define('@', Items.IRON_NUGGET)
                .unlockedBy("has_jungle_leaves", has(Items.JUNGLE_LEAVES)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.JUNGLE_SANDALS.get())
                .pattern("@ @")
                .define('@', Items.LEATHER)
                .unlockedBy("has_jungle_leaves", has(Items.JUNGLE_LEAVES)).save(recipeOutput);

        // Desert Outfit
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DESERT_HAT.get())
                .pattern("@@@")
                .pattern("# #")
                .define('@', Items.WHITE_WOOL)
                .define('#', Items.ORANGE_WOOL)
                .unlockedBy("has_orange_wool", has(Items.ORANGE_WOOL)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DESERT_ROBE.get())
                .pattern("@ @")
                .pattern("@@@")
                .pattern("###")
                .define('@', Items.WHITE_WOOL)
                .define('#', Items.ORANGE_WOOL)
                .unlockedBy("has_orange_wool", has(Items.ORANGE_WOOL)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DESERT_PANTS.get())
                .pattern("#@#")
                .pattern("% %")
                .pattern("% %")
                .define('#', Items.LEATHER)
                .define('@', Items.IRON_NUGGET)
                .define('%', Items.GREEN_WOOL)
                .unlockedBy("has_orange_wool", has(Items.ORANGE_WOOL)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DESERT_SANDALS.get())
                .pattern("% %")
                .pattern("@ @")
                .define('@', Items.LEATHER)
                .define('%', Items.GREEN_WOOL)
                .unlockedBy("has_orange_wool", has(Items.ORANGE_WOOL)).save(recipeOutput);
    }
}
