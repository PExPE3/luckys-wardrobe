package net.luckystudios.luckyswardrobe.items.cosmetics.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CosmeticRenderer<T extends LivingEntity> implements ICurioRenderer {

    private final HumanoidModel<T> model;
    private final ResourceLocation texture;

    public CosmeticRenderer(HumanoidModel<T> model, ResourceLocation texture) {
        this.model = model;
        this.texture = texture;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends LivingEntity, M extends EntityModel<E>> void render(
            ItemStack stack, SlotContext slotContext,
            PoseStack poseStack, RenderLayerParent<E, M> parent,
            MultiBufferSource buffer, int light,
            float limbSwing, float limbSwingAmount,
            float partialTicks, float ageInTicks,
            float netHeadYaw, float headPitch) {

        E entity = (E) slotContext.entity();
        // Copy poses from parent to custom model
        model.prepareMobModel((T) entity, limbSwing, limbSwingAmount, partialTicks);
        model.setupAnim((T) entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        parent.getModel().copyPropertiesTo((HumanoidModel<E>) model);

        poseStack.pushPose();
        poseStack.translate(0, 0, 0);

        if (stack.is(ItemTags.DYEABLE)) {
            // Append "_dye_overlay" to a texture path
            ResourceLocation dyeTexture = LuckysWardrobe.id(texture.getPath().replace(".png", "_dye_overlay.png"));
            RenderType dyeRenderType = model.renderType(dyeTexture);
            VertexConsumer dyeConsumer = ItemRenderer.getFoilBuffer(buffer, dyeRenderType, false, stack.hasFoil());
            model.renderToBuffer(poseStack, dyeConsumer, light, OverlayTexture.NO_OVERLAY, DyedItemColor.getOrDefault(stack, 0xFFFFFFFF));
        }

        RenderType renderType = model.renderType(texture);
        VertexConsumer vertexBuilder = ItemRenderer.getFoilBuffer(buffer, renderType, false, stack.hasFoil());

        model.renderToBuffer(poseStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY);

        poseStack.popPose();
    }
}

