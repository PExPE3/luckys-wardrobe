package net.luckystudios.luckyswardrobe.datagen.types;

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.luckystudios.luckyswardrobe.items.ModItems;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class ModAdvancmentProvider implements AdvancementProvider.AdvancementGenerator
{
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {
        AdvancementHolder selfExpression = Advancement.Builder.advancement()
                .display(ModItems.HAT,
                        Component.translatable("advancement.luckysarmory.heavy_iron_armor.title"),
                        Component.translatable("advancement.luckysarmory.heavy_iron_armor.description"),
                        ResourceLocation.withDefaultNamespace("textures/gui/advancements/backgrounds/stone.png"),
                        AdvancementType.TASK, true, true, false)
                .addCriterion(
                        "hat",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ModItems.HAT
                        )
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .rewards(AdvancementRewards.Builder.experience(10))
                .save(consumer, getNameId("self_expression")); // all lowercase and valid
    }

    private String getNameId(String id) {
        return LuckysWardrobe.MOD_ID + ":" + id;
    }
}