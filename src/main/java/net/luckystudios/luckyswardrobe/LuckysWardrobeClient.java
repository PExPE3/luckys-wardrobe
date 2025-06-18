package net.luckystudios.luckyswardrobe;

import net.luckystudios.luckyswardrobe.client.ModModelRegistrations;
import net.luckystudios.luckyswardrobe.items.ModItems;
import net.luckystudios.luckyswardrobe.items.cosmetics.models.*;
import net.luckystudios.luckyswardrobe.items.cosmetics.renderers.CosmeticRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(LuckysWardrobe.MOD_ID)
public class LuckysWardrobeClient {
    @EventBusSubscriber(modid = LuckysWardrobe.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            var entityModels = Minecraft.getInstance().getEntityModels();

            CuriosRendererRegistry.register(ModItems.HAT.get(), () -> new CosmeticRenderer<>(new HatModel<>(entityModels.bakeLayer(HatModel.LAYER_LOCATION)), LuckysWardrobe.id("textures/entity/hat.png")));
            CuriosRendererRegistry.register(ModItems.TOP_HAT.get(), () -> new CosmeticRenderer<>(new TallHatModel<>(entityModels.bakeLayer(TallHatModel.LAYER_LOCATION)), LuckysWardrobe.id("textures/entity/top_hat.png")));
            CuriosRendererRegistry.register(ModItems.EXPLORERS_HAT.get(), () -> new CosmeticRenderer<>(new HatModel<>(entityModels.bakeLayer(HatModel.LAYER_LOCATION)), LuckysWardrobe.id("textures/entity/explorers_hat.png")));
            CuriosRendererRegistry.register(ModItems.WITCH_HAT.get(), () -> new CosmeticRenderer<>(new WitchHatModel<>(entityModels.bakeLayer(WitchHatModel.LAYER_LOCATION)), LuckysWardrobe.id("textures/entity/witch_hat.png")));
            CuriosRendererRegistry.register(ModItems.FOX_HAT.get(), () -> new CosmeticRenderer<>(new AnimalHatModel<>(entityModels.bakeLayer(AnimalHatModel.LAYER_LOCATION)), LuckysWardrobe.id("textures/entity/fox_hat.png")));
            CuriosRendererRegistry.register(ModItems.SNOW_FOX_HAT.get(), () -> new CosmeticRenderer<>(new AnimalHatModel<>(entityModels.bakeLayer(AnimalHatModel.LAYER_LOCATION)), LuckysWardrobe.id("textures/entity/snow_fox_hat.png")));
            CuriosRendererRegistry.register(ModItems.SCARF.get(), () -> new CosmeticRenderer<>(new ScarfModel<>(entityModels.bakeLayer(ScarfModel.LAYER_LOCATION)), LuckysWardrobe.id("textures/entity/scarf.png")));

            CuriosRendererRegistry.register(ModItems.LEATHER_APRON.get(), () -> new CosmeticRenderer<>(new ProfessionBody<>(entityModels.bakeLayer(ProfessionBody.LAYER_LOCATION)), ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/leatherworker.png")));
            CuriosRendererRegistry.register(ModItems.HARDENED_LEATHER_APRON.get(), () -> new CosmeticRenderer<>(new ProfessionBody<>(entityModels.bakeLayer(ProfessionBody.LAYER_LOCATION)), ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/armorer.png")));
            CuriosRendererRegistry.register(ModItems.BUTCHERS_APRON.get(), () -> new CosmeticRenderer<>(new ProfessionBody<>(entityModels.bakeLayer(ProfessionBody.LAYER_LOCATION)), ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/butcher.png")));
            CuriosRendererRegistry.register(ModItems.CLERICS_APRON.get(), () -> new CosmeticRenderer<>(new ProfessionBody<>(entityModels.bakeLayer(ProfessionBody.LAYER_LOCATION)), ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/cleric.png")));
            CuriosRendererRegistry.register(ModItems.FISHING_APRON.get(), () -> new CosmeticRenderer<>(new ProfessionBody<>(entityModels.bakeLayer(ProfessionBody.LAYER_LOCATION)), ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/fisherman.png")));
            CuriosRendererRegistry.register(ModItems.CHITON.get(), () -> new CosmeticRenderer<>(new ProfessionBody<>(entityModels.bakeLayer(ProfessionBody.LAYER_LOCATION)), ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/librarian.png")));
            CuriosRendererRegistry.register(ModItems.MASONS_APRON.get(), () -> new CosmeticRenderer<>(new ProfessionBody<>(entityModels.bakeLayer(ProfessionBody.LAYER_LOCATION)), ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/mason.png")));
            CuriosRendererRegistry.register(ModItems.WOOL_VEST.get(), () -> new CosmeticRenderer<>(new ProfessionBody<>(entityModels.bakeLayer(ProfessionBody.LAYER_LOCATION)), ResourceLocation.withDefaultNamespace("textures/entity/villager/profession/shepherd.png")));
        }

        // Copied from ItemColors.class
        @SubscribeEvent(priority = EventPriority.NORMAL)
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        renderItemColor(event, DyedItemColor.LEATHER_COLOR, true, ModItems.TAIGA_HOOD);
        renderItemColor(event, DyedItemColor.LEATHER_COLOR, true, ModItems.TAIGA_COAT);
        renderItemColor(event, DyedItemColor.LEATHER_COLOR, true, ModItems.TAIGA_PANTS);
        renderItemColor(event, DyedItemColor.LEATHER_COLOR, true, ModItems.TAIGA_BOOTS);
        renderItemColor(event, DyedItemColor.LEATHER_COLOR, true, ModItems.SNOWY_HAT);
        renderItemColor(event, DyedItemColor.LEATHER_COLOR, true, ModItems.SNOWY_HOOD);
        renderItemColor(event, DyedItemColor.LEATHER_COLOR, true, ModItems.SNOWY_COAT);
        renderItemColor(event, DyedItemColor.LEATHER_COLOR, true, ModItems.SNOWY_PANTS);
        renderItemColor(event, DyedItemColor.LEATHER_COLOR, true, ModItems.SNOWY_BOOTS);
        renderItemColor(event, DyeColor.WHITE.getTextureDiffuseColor(), true, ModItems.HAT);
        renderItemColor(event, DyedItemColor.LEATHER_COLOR, true, ModItems.TOP_HAT);
        renderItemColor(event, DyeColor.WHITE.getTextureDiffuseColor(), true, ModItems.EXPLORERS_HAT);
        renderItemColor(event, DyeColor.WHITE.getTextureDiffuseColor(), false, ModItems.SCARF);
        }

        private static void renderItemColor(RegisterColorHandlersEvent.Item event, int color, boolean isLayered, ItemLike... items) {
            event.register(
                    (stack, layer) -> {
                        if (isLayered && layer != 1) return -1;

                        DyedItemColor dyedColor = stack.get(DataComponents.DYED_COLOR);
                        if (dyedColor == null) return color;

                        int rgb = dyedColor.rgb();
                        int r = (rgb >> 16) & 0xFF;
                        int g = (rgb >> 8) & 0xFF;
                        int b = rgb & 0xFF;

                        // Boost the vibrancy (increase each channel by 20%, capped at 255)
                        r = Math.min((int) (r * 1.2f), 255);
                        g = Math.min((int) (g * 1.2f), 255);
                        b = Math.min((int) (b * 1.2f), 255);

                        int boostedRgb = (r << 16) | (g << 8) | b;

                        return FastColor.ARGB32.opaque(boostedRgb);
                    },
                    items
            );
        }

        @SubscribeEvent
        public static void registerItemExtensions(RegisterClientExtensionsEvent event) {

            // Hats
            ModModelRegistrations.registerCosmeticModel(event, ModItems.HAT.get(), HatModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.TOP_HAT.get(), TallHatModel.LAYER_LOCATION, DyedItemColor.LEATHER_COLOR);
            ModModelRegistrations.registerCosmeticModel(event, ModItems.EXPLORERS_HAT.get(), HatModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.FARMER_HAT.asItem(), FarmerHatModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.BLACKSMITH_MASK.asItem(), HatModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.CHEF_HAT.asItem(), ChefHatModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.WITCH_HAT.get(), WitchHatModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerModelWithSwing(event, ModItems.FOX_HAT.get(), AnimalHatModel.LAYER_LOCATION, true, 20, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerModelWithSwing(event, ModItems.SNOW_FOX_HAT.get(), AnimalHatModel.LAYER_LOCATION, true, 20, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerModelWithSwing(event, ModItems.WOLF_HAT.get(), AnimalHatModel.LAYER_LOCATION, true, 20, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerModelWithSwing(event, ModItems.PANDA_HAT.get(), AnimalHatModel.LAYER_LOCATION, true, 20, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.BEE_HAT.get(), BeeHatModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.SCARF.get(), ScarfModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());

            // Professions
            ModModelRegistrations.registerCosmeticModel(event, ModItems.LEATHER_APRON.get(), ProfessionBody.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.HARDENED_LEATHER_APRON.get(), ProfessionBody.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.BUTCHERS_APRON.get(), ProfessionBody.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.CLERICS_APRON.get(), ProfessionBody.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.FISHING_APRON.get(), ProfessionBody.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.CHITON.get(), ProfessionBody.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.MASONS_APRON.get(), ProfessionBody.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.WOOL_VEST.get(), ProfessionBody.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());

            // Outfits
            ModModelRegistrations.registerCosmeticModel(event, ModItems.TAIGA_HOOD.get(), HoodModel.LAYER_LOCATION, DyedItemColor.LEATHER_COLOR);
            ModModelRegistrations.registerModelWithSwing(event, ModItems.TAIGA_COAT.get(), BodyModel.LAYER_LOCATION, false, 0, DyedItemColor.LEATHER_COLOR);
            ModModelRegistrations.registerCosmeticModel(event, ModItems.TAIGA_PANTS.get(), PantsModel.LAYER_LOCATION, DyedItemColor.LEATHER_COLOR);
            ModModelRegistrations.registerCosmeticModel(event, ModItems.TAIGA_BOOTS.get(), ShoesModel.LAYER_LOCATION, DyedItemColor.LEATHER_COLOR);

            ModModelRegistrations.registerCosmeticModel(event, ModItems.SNOWY_HAT.get(), TallHatModel.LAYER_LOCATION, DyedItemColor.LEATHER_COLOR);
            ModModelRegistrations.registerCosmeticModel(event, ModItems.SNOWY_HOOD.get(), HoodModel.LAYER_LOCATION, DyedItemColor.LEATHER_COLOR);
            ModModelRegistrations.registerModelWithSwing(event, ModItems.SNOWY_COAT.get(), BodyModel.LAYER_LOCATION, false, 0, DyedItemColor.LEATHER_COLOR);
            ModModelRegistrations.registerCosmeticModel(event, ModItems.SNOWY_PANTS.get(), PantsModel.LAYER_LOCATION, DyedItemColor.LEATHER_COLOR);
            ModModelRegistrations.registerCosmeticModel(event, ModItems.SNOWY_BOOTS.get(), ShoesModel.LAYER_LOCATION, DyedItemColor.LEATHER_COLOR);

            ModModelRegistrations.registerCosmeticModel(event, ModItems.SAVANNA_FLORAL_CROWN.get(), TallHatModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.SAVANNA_ROBE.get(), BodyModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.SAVANNA_PANTS.get(), PantsModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.SAVANNA_SANDALS.get(), ShoesModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());

            ModModelRegistrations.registerCosmeticModel(event, ModItems.SWAMPY_HAT.get(), HatModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.SWAMPY_ROBE.get(), BodyModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.SWAMPY_PANTS.get(), PantsModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.SWAMPY_SHOES.get(), ShoesModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());

            ModModelRegistrations.registerCosmeticModel(event, ModItems.JUNGLE_ROBE.get(), BodyModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.JUNGLE_PANTS.get(), PantsModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.JUNGLE_SANDALS.get(), ShoesModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());

            ModModelRegistrations.registerCosmeticModel(event, ModItems.DESERT_HAT.get(), TallHatModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.DESERT_ROBE.get(), BodyModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.DESERT_PANTS.get(), PantsModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.DESERT_SANDALS.get(), ShoesModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());

            ModModelRegistrations.registerCosmeticModel(event, ModItems.ENTERTAINERS_HAT.get(), EntertainersHatModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.ENTERTAINERS_SHIRT.get(), BodyModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.ENTERTAINERS_PANTS.get(), EntertainersPantsModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
            ModModelRegistrations.registerCosmeticModel(event, ModItems.ENTERTAINERS_SHOES.get(), ShoesModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());

            ModModelRegistrations.registerCosmeticModel(event, ModItems.BROKEN_BARREL.get(), BrokenBarrelModel.LAYER_LOCATION, DyeColor.WHITE.getTextureDiffuseColor());
        }

        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

            // Hats
            event.registerLayerDefinition(HatModel.LAYER_LOCATION, HatModel::createBodyLayer);
            event.registerLayerDefinition(TallHatModel.LAYER_LOCATION, TallHatModel::createBodyLayer);
            event.registerLayerDefinition(FarmerHatModel.LAYER_LOCATION, FarmerHatModel::createBodyLayer);
            event.registerLayerDefinition(ChefHatModel.LAYER_LOCATION, ChefHatModel::createBodyLayer);
            event.registerLayerDefinition(WitchHatModel.LAYER_LOCATION, WitchHatModel::createBodyLayer);
            event.registerLayerDefinition(AnimalHatModel.LAYER_LOCATION, AnimalHatModel::createBodyLayer);
            event.registerLayerDefinition(BeeHatModel.LAYER_LOCATION, BeeHatModel::createBodyLayer);
            event.registerLayerDefinition(ScarfModel.LAYER_LOCATION, ScarfModel::createBodyLayer);

            // Professions
            event.registerLayerDefinition(ProfessionBody.LAYER_LOCATION, ProfessionBody::createBodyLayer);

            // Outfits
            event.registerLayerDefinition(HoodModel.LAYER_LOCATION, HoodModel::createBodyLayer);
            event.registerLayerDefinition(BodyModel.LAYER_LOCATION, BodyModel::createBodyLayer);
            event.registerLayerDefinition(PantsModel.LAYER_LOCATION, PantsModel::createBodyLayer);
            event.registerLayerDefinition(ShoesModel.LAYER_LOCATION, ShoesModel::createBodyLayer);
            event.registerLayerDefinition(EntertainersHatModel.LAYER_LOCATION, EntertainersHatModel::createBodyLayer);
            event.registerLayerDefinition(EntertainersPantsModel.LAYER_LOCATION, EntertainersPantsModel::createBodyLayer);

            // Misc
            event.registerLayerDefinition(BrokenBarrelModel.LAYER_LOCATION, BrokenBarrelModel::createBodyLayer);
        }
    }
}