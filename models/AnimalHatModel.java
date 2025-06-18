// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class AnimalHatModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "animalhatmodel"), "main");
	private final ModelPart head;
	private final ModelPart swingPart;

	public AnimalHatModel(ModelPart root) {
		this.head = root.getChild("head");
		this.swingPart = this.head.getChild("swingPart");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, -7.0F, -6.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.25F))
		.texOffs(0, 0).addBox(-4.0F, -11.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(0, 28).addBox(-5.0F, -12.5F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(0, 28).mirror().addBox(2.0F, -12.5F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.25F)).mirror(false)
		.texOffs(0, 0).addBox(2.0F, -11.5F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(0, 11).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.75F))
		.texOffs(0, 0).addBox(-4.0F, -8.5F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.75F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition swingPart = head.addOrReplaceChild("swingPart", CubeListBuilder.create().texOffs(24, 11).addBox(-1.0F, -1.0603F, -0.342F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.51F))
		.texOffs(-3, 3).addBox(-1.5F, 5.2397F, -0.842F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 5.0F, 0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}