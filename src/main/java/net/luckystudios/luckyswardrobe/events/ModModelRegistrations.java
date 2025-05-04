package net.luckystudios.luckyswardrobe.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

public class ModModelRegistrations {

    public static void registerCosmeticModel(RegisterClientExtensionsEvent event, Item item, ModelLayerLocation layer) {
        event.registerItem(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
                ModelPart part = Minecraft.getInstance().getEntityModels().bakeLayer(layer);
                return new HumanoidModel<>(part);
            }
        }, item);
    }

    public static void registerHatModel(RegisterClientExtensionsEvent event, Item item, ModelLayerLocation layer, int defaultColor) {
        event.registerItem(new IClientItemExtensions() {

            @Override
            @OnlyIn(Dist.CLIENT)
            public int getDefaultDyeColor(ItemStack stack) {
                return stack.is(ItemTags.DYEABLE) ? FastColor.ARGB32.opaque(DyedItemColor.getOrDefault(stack, defaultColor)) : 0xFFFFFFFF;
            }

            @Override
            @OnlyIn(Dist.CLIENT)
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
                ModelPart part = Minecraft.getInstance().getEntityModels().bakeLayer(layer);
                return new HumanoidModel<>(part);
            }
        }, item);
    }

    // A very complex method, definitely can use some clean up.
    public static void registerModelWithSwing(RegisterClientExtensionsEvent event, Item item, ModelLayerLocation layer, boolean isHead) {
        event.registerItem(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
                ModelPart part = Minecraft.getInstance().getEntityModels().bakeLayer(layer);
                return new HumanoidModel<>(part);
            }

            @Override
            @OnlyIn(Dist.CLIENT)
            public void setupModelAnimations(LivingEntity entity, ItemStack stack, EquipmentSlot slot, Model model, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
                if (entity instanceof AbstractClientPlayer abstractClientPlayer) {
                    if (model instanceof HumanoidModel<?> humanoidModel) {
                        ModelPart swing = isHead ? humanoidModel.getHead().getChild("swingPart") : humanoidModel.body.getChild("swingPart");
                        double d0 = Mth.lerp(partialTick, abstractClientPlayer.xCloakO, abstractClientPlayer.xCloak) - Mth.lerp(partialTick, entity.xo, entity.getX());
                        double d1 = Mth.lerp(partialTick, abstractClientPlayer.yCloakO, abstractClientPlayer.yCloak) - Mth.lerp(partialTick, entity.yo, entity.getY());
                        double d2 = Mth.lerp(partialTick, abstractClientPlayer.zCloakO, abstractClientPlayer.zCloak) - Mth.lerp(partialTick, entity.zo, entity.getZ());

                        float yaw = Mth.rotLerp(partialTick, entity.yBodyRotO, entity.yBodyRot);
                        double sin = Math.sin(Math.toRadians(yaw));
                        double cos = -Math.cos(Math.toRadians(yaw));

                        float verticalMotion = (float) d1 * 10.0F;
                        verticalMotion = Mth.clamp(verticalMotion, -6.0F, 32.0F);

                        float forwardMotion = (float) (d0 * sin + d2 * cos) * 100.0F;
                        forwardMotion = Mth.clamp(forwardMotion, 0.0F, 150.0F);

                        float bob = Mth.lerp(partialTick, abstractClientPlayer.oBob, abstractClientPlayer.bob);
                        float walk = Mth.lerp(partialTick, entity.walkDistO, entity.walkDist);
                        verticalMotion += Mth.sin(walk * 6.0F) * 32.0F * bob;

                        if (entity.isCrouching()) {
                            verticalMotion += 25.0F;
                        }

                        float degrees = 20.0F + forwardMotion / 2.0F + verticalMotion;
                        swing.xRot = degrees * ((float) Math.PI / 180F);
                        swing.yRot = 0.0F;
                    }
                }
            }
        }, item);
    }
}
