package net.luckystudios.luckyswardrobe.items.cosmetics.models;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import net.luckystudios.luckyswardrobe.LuckysWardrobe;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class HoodModel<T extends Entity> extends HumanoidArmorModel<LivingEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, "taiga_hat"), "main");
	private final ModelPart head;

	public HoodModel(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.51F))
		.texOffs(0, 2).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F))
		.texOffs(0, 34).addBox(-5.0F, -9.0F, -6.0F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 24).addBox(-5.0F, -6.0F, -5.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 24).addBox(3.0F, -6.0F, -5.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 40).addBox(-4.5F, -9.0F, -6.5F, 9.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}