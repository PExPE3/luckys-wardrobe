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
import net.minecraft.world.entity.LivingEntity;

public class ScarfModel<T extends LivingEntity> extends HumanoidArmorModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(LuckysWardrobe.MOD_ID, "scarf"), "main");
	private final ModelPart head;
	private final ModelPart swingPart;

	public ScarfModel(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
		this.swingPart = this.head.getChild("swingPart");
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

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition swingPart = head.addOrReplaceChild("swingPart", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, -2.0F, 4.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r1 = swingPart.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(5.0F, -2.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 13).addBox(-1.0F, -2.0F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}