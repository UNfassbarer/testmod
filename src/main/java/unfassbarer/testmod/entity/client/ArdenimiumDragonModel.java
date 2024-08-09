package unfassbarer.testmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import unfassbarer.testmod.entity.custom.ArdenimiumDragonEntity;

public class ArdenimiumDragonModel<T extends ArdenimiumDragonEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bb_main;
	public ArdenimiumDragonModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 62).cuboid(-6.0F, -53.0F, -55.0F, 12.0F, 5.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 152).cuboid(-8.0F, -60.0F, -41.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F))
		.uv(40, 62).cuboid(-5.0F, -64.0F, -35.0F, 2.0F, 4.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 6).cuboid(-5.0F, -55.0F, -53.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 62).cuboid(3.0F, -64.0F, -35.0F, 2.0F, 4.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(3.0F, -55.0F, -53.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(133, 188).cuboid(-20.0F, 1.0F, 40.0F, 8.0F, 24.0F, 10.0F, new Dilation(0.0F))
		.uv(97, 188).cuboid(12.0F, 1.0F, 40.0F, 8.0F, 24.0F, 10.0F, new Dilation(0.0F))
		.uv(253, 158).cuboid(-15.0F, 8.0F, -9.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F))
		.uv(46, 193).cuboid(-16.0F, 25.0F, -18.0F, 8.0F, 4.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 253).cuboid(9.0F, 8.0F, -9.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F))
		.uv(169, 188).cuboid(8.0F, 25.0F, -18.0F, 8.0F, 4.0F, 16.0F, new Dilation(0.0F))
		.uv(44, 213).cuboid(-5.0F, -11.0F, 34.0F, 10.0F, 10.0F, 12.0F, new Dilation(0.0F))
		.uv(30, 231).cuboid(-1.0F, -15.0F, 36.0F, 2.0F, 4.0F, 8.0F, new Dilation(0.0F))
		.uv(210, 142).cuboid(-5.0F, -10.0F, 45.0F, 10.0F, 10.0F, 12.0F, new Dilation(0.0F))
		.uv(174, 230).cuboid(-1.0F, -14.0F, 47.0F, 2.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head_r1 = bb_main.addChild("head_r1", ModelPartBuilder.create().uv(195, 213).cuboid(-8.0F, -17.0F, -74.0F, 3.0F, 5.0F, 18.0F, new Dilation(0.0F))
		.uv(70, 217).cuboid(-23.0F, -17.0F, -74.0F, 3.0F, 5.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(14.0F, -82.0F, 37.0F, 0.5672F, 0.0F, 0.0F));

		ModelPartData rearfoot_r1 = bb_main.addChild("rearfoot_r1", ModelPartBuilder.create().uv(45, 168).cuboid(-25.0F, 52.0F, 26.0F, 12.0F, 6.0F, 19.0F, new Dilation(0.0F))
		.uv(0, 184).cuboid(-57.0F, 52.0F, 26.0F, 12.0F, 6.0F, 19.0F, new Dilation(0.0F)), ModelTransform.of(35.0F, -27.0F, 2.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData rearleg_r1 = bb_main.addChild("rearleg_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-22.0F, -7.0F, 34.0F, 12.0F, 19.0F, 12.0F, new Dilation(0.0F))
		.uv(0, 31).cuboid(-54.0F, -7.0F, 34.0F, 12.0F, 19.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(32.0F, 35.0F, 19.0F, 1.1345F, 0.0F, 0.0F));

		ModelPartData tail_r1 = bb_main.addChild("tail_r1", ModelPartBuilder.create().uv(88, 168).cuboid(-1.0F, -21.0F, 168.0F, 2.0F, 2.0F, 13.0F, new Dilation(0.0F))
		.uv(0, 103).cuboid(-3.0F, -19.0F, 166.0F, 6.0F, 4.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 30.0F, -22.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData tail_r2 = bb_main.addChild("tail_r2", ModelPartBuilder.create().uv(168, 88).cuboid(-1.0F, -22.0F, 158.0F, 2.0F, 3.0F, 12.0F, new Dilation(0.0F))
		.uv(201, 192).cuboid(-3.5F, -19.0F, 156.0F, 7.0F, 5.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 15.0F, -23.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData tail_r3 = bb_main.addChild("tail_r3", ModelPartBuilder.create().uv(196, 88).cuboid(-1.0F, -23.0F, 148.0F, 2.0F, 4.0F, 10.0F, new Dilation(0.0F))
		.uv(223, 222).cuboid(-4.0F, -19.0F, 146.0F, 8.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.0F, -23.0F, -0.2182F, 0.0F, 0.0F));

		ModelPartData tail_r4 = bb_main.addChild("tail_r4", ModelPartBuilder.create().uv(220, 88).cuboid(-1.0F, -23.0F, 138.0F, 2.0F, 4.0F, 10.0F, new Dilation(0.0F))
		.uv(112, 222).cuboid(-4.0F, -19.0F, 136.0F, 8.0F, 7.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, -22.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData tail_r5 = bb_main.addChild("tail_r5", ModelPartBuilder.create().uv(33, 125).cuboid(-1.0F, -23.0F, 128.0F, 2.0F, 4.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.0F, -21.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData tail_r6 = bb_main.addChild("tail_r6", ModelPartBuilder.create().uv(143, 230).cuboid(-4.5F, -19.0F, 126.0F, 9.0F, 7.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.0F, -21.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData tail_r7 = bb_main.addChild("tail_r7", ModelPartBuilder.create().uv(94, 222).cuboid(-1.0F, -23.0F, 118.0F, 2.0F, 4.0F, 9.0F, new Dilation(0.0F))
		.uv(169, 208).cuboid(-4.5F, -19.0F, 116.0F, 9.0F, 9.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.0F, -19.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData tail_r8 = bb_main.addChild("tail_r8", ModelPartBuilder.create().uv(36, 0).cuboid(-1.0F, -23.0F, 108.0F, 2.0F, 4.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 231).cuboid(-4.5F, -19.0F, 106.0F, 9.0F, 10.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -30.0F, -16.0F, -0.48F, 0.0F, 0.0F));

		ModelPartData tail_r9 = bb_main.addChild("tail_r9", ModelPartBuilder.create().uv(244, 88).cuboid(-1.0F, -23.0F, 98.0F, 2.0F, 4.0F, 9.0F, new Dilation(0.0F))
		.uv(0, 125).cuboid(-5.0F, -19.0F, 96.0F, 10.0F, 10.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -23.0F, -19.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData tail_r10 = bb_main.addChild("tail_r10", ModelPartBuilder.create().uv(36, 31).cuboid(-1.0F, -23.0F, 88.0F, 2.0F, 4.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 209).cuboid(-5.0F, -19.0F, 86.0F, 10.0F, 10.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.5F, -21.0F, -0.2182F, 0.0F, 0.0F));

		ModelPartData tail_r11 = bb_main.addChild("tail_r11", ModelPartBuilder.create().uv(32, 209).cuboid(-1.0F, -23.0F, 78.0F, 2.0F, 4.0F, 8.0F, new Dilation(0.0F))
		.uv(210, 120).cuboid(-5.0F, -19.0F, 76.0F, 10.0F, 10.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, -20.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData frontleg1_r1 = bb_main.addChild("frontleg1_r1", ModelPartBuilder.create().uv(42, 235).cuboid(8.0F, -4.0F, -2.0F, 8.0F, 20.0F, 8.0F, new Dilation(0.0F))
		.uv(187, 236).cuboid(-16.0F, -4.0F, -2.0F, 8.0F, 20.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0F, 4.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData wingtip1_r1 = bb_main.addChild("wingtip1_r1", ModelPartBuilder.create().uv(0, 0).cuboid(68.0F, -18.25F, 4.0F, 56.0F, 0.0F, 56.0F, new Dilation(0.01F)), ModelTransform.of(-10.0F, -56.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		ModelPartData wingtip1_r2 = bb_main.addChild("wingtip1_r2", ModelPartBuilder.create().uv(168, 72).cuboid(68.0F, -21.0F, 0.0F, 56.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -55.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		ModelPartData wing1_r1 = bb_main.addChild("wing1_r1", ModelPartBuilder.create().uv(0, 112).cuboid(11.5F, -19.0F, 4.0F, 52.5F, 0.0F, 56.0F, new Dilation(0.01F))
		.uv(162, 104).cuboid(11.5F, -23.0F, -2.0F, 52.5F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 6.5F, 0.0F, 0.0F, 0.0F, -0.4363F));

		ModelPartData wingtip_r1 = bb_main.addChild("wingtip_r1", ModelPartBuilder.create().uv(0, 56).cuboid(-124.0F, -19.0F, 4.0F, 56.0F, 0.0F, 56.0F, new Dilation(0.01F))
		.uv(168, 80).cuboid(-124.0F, -21.0F, 0.0F, 56.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, -55.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		ModelPartData wing_r1 = bb_main.addChild("wing_r1", ModelPartBuilder.create().uv(112, 0).cuboid(-64.5F, -19.0F, 4.0F, 52.5F, 0.0F, 56.0F, new Dilation(0.01F))
		.uv(168, 56).cuboid(-64.5F, -23.0F, -4.0F, 52.5F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.4363F));

		ModelPartData body_r1 = bb_main.addChild("body_r1", ModelPartBuilder.create().uv(24, 253).cuboid(-1.0F, -29.0F, 38.0F, 2.0F, 9.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 9.0F, -10.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData body_r2 = bb_main.addChild("body_r2", ModelPartBuilder.create().uv(247, 250).cuboid(-1.0F, -28.0F, 18.0F, 2.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, -7.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData body_r3 = bb_main.addChild("body_r3", ModelPartBuilder.create().uv(144, 250).cuboid(-1.0F, -31.0F, -2.0F, 2.0F, 11.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, -6.0F, -0.2618F, 0.0F, 0.0F));

		ModelPartData jaw_r1 = bb_main.addChild("jaw_r1", ModelPartBuilder.create().uv(0, 83).cuboid(-6.0F, -3.0F, -88.0F, 12.0F, 4.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -48.0F, 33.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData neck_r1 = bb_main.addChild("neck_r1", ModelPartBuilder.create().uv(231, 188).cuboid(-5.0F, -12.0F, -58.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, 11.0F, -0.7418F, 0.0F, 0.0F));

		ModelPartData neck_r2 = bb_main.addChild("neck_r2", ModelPartBuilder.create().uv(30, 103).cuboid(-1.0F, -20.0F, -49.0F, 2.0F, 8.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 12.0F, 19.0F, -0.6109F, 0.0F, 0.0F));

		ModelPartData neck_r3 = bb_main.addChild("neck_r3", ModelPartBuilder.create().uv(74, 240).cuboid(-5.0F, -12.0F, -48.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, 6.0F, -0.7418F, 0.0F, 0.0F));

		ModelPartData neck_r4 = bb_main.addChild("neck_r4", ModelPartBuilder.create().uv(172, 255).cuboid(-1.0F, -20.0F, -36.0F, 2.0F, 8.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, -4.0F, -0.8727F, 0.0F, 0.0F));

		ModelPartData neck_r5 = bb_main.addChild("neck_r5", ModelPartBuilder.create().uv(219, 242).cuboid(-5.0F, -12.0F, -38.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -2.0F, -0.8727F, 0.0F, 0.0F));

		ModelPartData neck_r6 = bb_main.addChild("neck_r6", ModelPartBuilder.create().uv(258, 233).cuboid(-1.0F, -20.0F, -29.0F, 2.0F, 8.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -27.0F, -8.0F, -0.6109F, 0.0F, 0.0F));

		ModelPartData neck_r7 = bb_main.addChild("neck_r7", ModelPartBuilder.create().uv(244, 132).cuboid(-5.0F, -12.0F, -28.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -2.0F, -0.7418F, 0.0F, 0.0F));

		ModelPartData neck_r8 = bb_main.addChild("neck_r8", ModelPartBuilder.create().uv(253, 208).cuboid(-1.0F, -21.0F, -18.0F, 2.0F, 9.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -24.0F, -18.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData neck_r9 = bb_main.addChild("neck_r9", ModelPartBuilder.create().uv(104, 250).cuboid(-5.0F, -12.0F, -18.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		ModelPartData body_r4 = bb_main.addChild("body_r4", ModelPartBuilder.create().uv(119, 125).cuboid(-12.0F, -18.0F, -8.0F, 24.0F, 20.0F, 43.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 512, 512);
	}


	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return bb_main;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}