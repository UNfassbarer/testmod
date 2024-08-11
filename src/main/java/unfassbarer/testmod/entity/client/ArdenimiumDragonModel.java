// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package unfassbarer.testmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import unfassbarer.testmod.entity.custom.ArdenimiumDragonEntity;

public class ArdenimiumDragonModel<T extends ArdenimiumDragonEntity> extends SinglePartEntityModel<T> {
	private final ModelPart ArdenimiumDragon;

	public ArdenimiumDragonModel(ModelPart root) {
		this.ArdenimiumDragon = root.getChild("ArdenimiumDragon");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData ArdenimiumDragon = modelPartData.addChild("ArdenimiumDragon", ModelPartBuilder.create(), ModelTransform.pivot(7.0F, 44.0F, 21.0F));

		ModelPartData tail = ArdenimiumDragon.addChild("tail", ModelPartBuilder.create().uv(144, 119).cuboid(-7.0F, -13.6819F, -43.2023F, 2.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -21.0F, 40.0F, -0.2618F, 0.0F, 0.0F));

		ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(138, 137).cuboid(-8.5F, -39.5896F, -4.4811F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 28.0F, -32.0F, 0.1745F, 0.0F, 0.0F));

		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0175F, 0.0F, 0.0F));

		ModelPartData tail_r2 = tail2.addChild("tail_r2", ModelPartBuilder.create().uv(21, 54).cuboid(-6.5F, -38.969F, 13.1389F, 1.0F, 3.0F, 5.0F, new Dilation(0.0F))
				.uv(97, 132).cuboid(-8.5F, -36.5495F, 11.7179F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 25.0F, -57.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0175F, 0.0F, 0.0F));

		ModelPartData tail_r3 = tail3.addChild("tail_r3", ModelPartBuilder.create().uv(83, 99).cuboid(-6.5F, -24.5934F, 37.7137F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -91.0F, -0.2182F, 0.0F, 0.0F));

		ModelPartData tail_r4 = tail3.addChild("tail_r4", ModelPartBuilder.create().uv(73, 128).cuboid(-8.5F, -22.2186F, 39.629F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -94.0F, -0.2618F, 0.0F, 0.0F));

		ModelPartData tail4 = tail3.addChild("tail4", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0175F, 0.0F, 0.0F));

		ModelPartData tail_r5 = tail4.addChild("tail_r5", ModelPartBuilder.create().uv(26, 96).cuboid(-6.5F, -18.6733F, 61.3501F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -23.0F, -116.0F, -0.4363F, 0.0F, 0.0F));

		ModelPartData tail_r6 = tail4.addChild("tail_r6", ModelPartBuilder.create().uv(134, 107).cuboid(-8.5F, -17.7466F, 60.5481F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -22.0F, -116.0F, -0.4363F, 0.0F, 0.0F));

		ModelPartData tail5 = tail4.addChild("tail5", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0349F, 0.0F, 0.0F));

		ModelPartData tail_r7 = tail5.addChild("tail_r7", ModelPartBuilder.create().uv(68, 79).cuboid(-6.5F, -21.3586F, 76.9954F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -33.0F, -133.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData tail_r8 = tail5.addChild("tail_r8", ModelPartBuilder.create().uv(122, 41).cuboid(-8.5F, -20.3586F, 75.9954F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -32.0F, -133.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData tail6 = tail5.addChild("tail6", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0524F, 0.0F, 0.0F));

		ModelPartData tail_r9 = tail6.addChild("tail_r9", ModelPartBuilder.create().uv(106, 111).cuboid(-6.5F, -53.5849F, 44.8475F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 139).cuboid(-8.5F, -52.0357F, 44.7266F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.0F, -127.0F, -0.5672F, 0.0F, 0.0F));

		ModelPartData tail7 = tail6.addChild("tail7", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0524F, 0.0F, 0.0F));

		ModelPartData tail_r10 = tail7.addChild("tail_r10", ModelPartBuilder.create().uv(18, 0).cuboid(-6.5F, -52.9591F, 58.7335F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, -141.0F, -0.48F, 0.0F, 0.0F));

		ModelPartData tail_r11 = tail7.addChild("tail_r11", ModelPartBuilder.create().uv(135, 85).cuboid(-8.5F, -51.2948F, 58.8014F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, -142.0F, -0.48F, 0.0F, 0.0F));

		ModelPartData tail8 = tail7.addChild("tail8", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0175F, 0.0F, 0.0F));

		ModelPartData tail_r12 = tail8.addChild("tail_r12", ModelPartBuilder.create().uv(112, 103).cuboid(-6.5F, -49.8626F, 70.4923F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 10.0F, -153.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData tail_r13 = tail8.addChild("tail_r13", ModelPartBuilder.create().uv(58, 140).cuboid(-8.0F, -48.696F, 70.2161F, 4.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 11.0F, -153.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData tail9 = tail8.addChild("tail9", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, -0.0175F, 0.0F, 0.0F));

		ModelPartData tail_r14 = tail9.addChild("tail_r14", ModelPartBuilder.create().uv(0, 96).cuboid(-6.5F, -38.9682F, 86.5062F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F))
				.uv(139, 46).cuboid(-8.0F, -36.8308F, 86.1279F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 11.0F, -167.0F, -0.2182F, 0.0F, 0.0F));

		ModelPartData tail10 = tail9.addChild("tail10", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, -0.0349F, 0.0F, 0.0F));

		ModelPartData tail_r15 = tail10.addChild("tail_r15", ModelPartBuilder.create().uv(72, 57).cuboid(-6.5F, -25.728F, 66.3736F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(119, 93).cuboid(-7.5F, -24.052F, 62.7897F, 3.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 19.0F, -144.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData tail11 = tail10.addChild("tail11", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, -0.0524F, 0.0F, 0.0F));

		ModelPartData tail_r16 = tail11.addChild("tail_r16", ModelPartBuilder.create().uv(19, 37).cuboid(-6.5F, -15.7371F, 73.4556F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 20.0F, -152.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData tail_r17 = tail11.addChild("tail_r17", ModelPartBuilder.create().uv(122, 28).cuboid(-7.5F, -13.507F, 72.5602F, 3.0F, 4.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 19.0F, -153.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData tail12 = tail11.addChild("tail12", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, -0.0524F, 0.0F, 0.0F));

		ModelPartData tail_r18 = tail12.addChild("tail_r18", ModelPartBuilder.create().uv(34, 147).cuboid(-6.5F, -17.6927F, 79.9504F, 1.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 37.0F, -157.0F, 0.1745F, 0.0F, 0.0F));

		ModelPartData tail_r19 = tail12.addChild("tail_r19", ModelPartBuilder.create().uv(54, 121).cuboid(-7.0F, -15.117F, 78.7404F, 2.0F, 3.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 36.0F, -158.0F, 0.1745F, 0.0F, 0.0F));

		ModelPartData legs = ArdenimiumDragon.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -101.0F, 0.0F));

		ModelPartData rearleg1 = legs.addChild("rearleg1", ModelPartBuilder.create(), ModelTransform.of(16.0F, -8.0F, 42.0F, 1.0472F, 0.0F, 0.0F));

		ModelPartData rearleg1_r1 = rearleg1.addChild("rearleg1_r1", ModelPartBuilder.create().uv(64, 99).cuboid(-4.0F, 2.3468F, -47.9691F, 6.0F, 15.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-16.0F, 8.0F, -42.0F, -0.4363F, 0.0F, 0.0F));

		ModelPartData rearlegtip1 = rearleg1.addChild("rearlegtip1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 28.0F, 1.0F, 0.4363F, 0.0F, 0.0F));

		ModelPartData rearlegtip_r1 = rearlegtip1.addChild("rearlegtip_r1", ModelPartBuilder.create().uv(112, 111).cuboid(-4.5F, 36.7403F, -33.131F, 5.0F, 15.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-15.0F, -20.0F, -43.0F, -1.8762F, 0.0F, 0.0F));

		ModelPartData rearfoot1 = rearlegtip1.addChild("rearfoot1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 32.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		ModelPartData rearfoot_r1 = rearfoot1.addChild("rearfoot_r1", ModelPartBuilder.create().uv(26, 99).cuboid(-3.5F, 6.3063F, -97.0853F, 7.0F, 3.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-17.0F, -52.0F, -41.0F, -2.2689F, 0.0F, 0.0F));

		ModelPartData frontleg1 = legs.addChild("frontleg1", ModelPartBuilder.create(), ModelTransform.of(26.0F, -4.0F, 3.0F, 1.1345F, 0.0F, 0.0F));

		ModelPartData frontleg1_r1 = frontleg1.addChild("frontleg1_r1", ModelPartBuilder.create().uv(32, 114).cuboid(-17.0F, 68.5157F, 11.1877F, 5.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, 4.0F, -2.0F, -1.8326F, 0.0F, 0.0F));

		ModelPartData frontlegtip1 = frontleg1.addChild("frontlegtip1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 20.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData frontlegtip_r1 = frontlegtip1.addChild("frontlegtip_r1", ModelPartBuilder.create().uv(96, 144).cuboid(-17.0F, 77.3253F, -42.4222F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -16.0F, -2.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData frontfoot1 = frontlegtip1.addChild("frontfoot1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 22.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		ModelPartData frontfoot_r1 = frontfoot1.addChild("frontfoot_r1", ModelPartBuilder.create().uv(90, 99).cuboid(-17.0F, 60.0F, -42.0F, 6.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, -38.0F, -2.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData frontleg = legs.addChild("frontleg", ModelPartBuilder.create(), ModelTransform.of(-12.0F, -4.0F, 2.0F, 1.1345F, 0.0F, 0.0F));

		ModelPartData frontleg_r1 = frontleg.addChild("frontleg_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-18.0F, 68.5157F, 11.1877F, 6.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, 4.0F, -2.0F, -1.8326F, 0.0F, 0.0F));

		ModelPartData frontlegtip = frontleg.addChild("frontlegtip", ModelPartBuilder.create(), ModelTransform.of(0.0F, 20.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData frontlegtip_r2 = frontlegtip.addChild("frontlegtip_r2", ModelPartBuilder.create().uv(80, 140).cuboid(-17.0F, 77.3253F, -42.4222F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, -16.0F, -2.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData frontfoot = frontlegtip.addChild("frontfoot", ModelPartBuilder.create(), ModelTransform.of(0.0F, 23.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		ModelPartData frontfoot_r2 = frontfoot.addChild("frontfoot_r2", ModelPartBuilder.create().uv(0, 111).cuboid(-18.0F, 59.0F, -42.0F, 6.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, -38.0F, -2.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData rearleg = legs.addChild("rearleg", ModelPartBuilder.create(), ModelTransform.of(-16.0F, -8.0F, 42.0F, 1.0472F, 0.0F, 0.0F));

		ModelPartData rearleg_r1 = rearleg.addChild("rearleg_r1", ModelPartBuilder.create().uv(0, 37).cuboid(-18.0F, 2.3468F, -47.9691F, 6.0F, 15.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(16.0F, 8.0F, -42.0F, -0.4363F, 0.0F, 0.0F));

		ModelPartData rearlegtip = rearleg.addChild("rearlegtip", ModelPartBuilder.create(), ModelTransform.of(0.0F, 28.0F, 1.0F, 0.4363F, 0.0F, 0.0F));

		ModelPartData rearlegtip_r2 = rearlegtip.addChild("rearlegtip_r2", ModelPartBuilder.create().uv(90, 111).cuboid(-17.5F, 36.7403F, -33.131F, 5.0F, 15.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(16.0F, -20.0F, -43.0F, -1.8762F, 0.0F, 0.0F));

		ModelPartData rearfoot = rearlegtip.addChild("rearfoot", ModelPartBuilder.create(), ModelTransform.of(0.0F, 32.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		ModelPartData rearfoot_r2 = rearfoot.addChild("rearfoot_r2", ModelPartBuilder.create().uv(0, 96).cuboid(-17.5F, 6.3063F, -97.0853F, 7.0F, 3.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(15.0F, -52.0F, -41.0F, -2.2689F, 0.0F, 0.0F));

		ModelPartData wings = ArdenimiumDragon.addChild("wings", ModelPartBuilder.create(), ModelTransform.of(0.0F, -43.0F, 35.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData wing1 = wings.addChild("wing1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData wingtip1_r1 = wing1.addChild("wingtip1_r1", ModelPartBuilder.create().uv(0, 0).cuboid(104.9963F, 13.3073F, -55.4584F, 30.0F, 0.0F, 29.0F, new Dilation(0.01F)), ModelTransform.of(-74.0F, -64.0F, -9.0F, -0.0149F, -0.041F, 0.3494F));

		ModelPartData wingtip1_r2 = wing1.addChild("wingtip1_r2", ModelPartBuilder.create().uv(0, 90).cuboid(104.9963F, 12.3073F, -59.4584F, 30.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-74.0F, -64.0F, -7.0F, -0.0149F, -0.041F, 0.3494F));

		ModelPartData wing1_r1 = wing1.addChild("wing1_r1", ModelPartBuilder.create().uv(34, 29).cuboid(19.0339F, 8.6583F, -55.4584F, 30.0F, 0.0F, 28.0F, new Dilation(0.01F)), ModelTransform.of(-26.0F, 1.0F, -6.0F, 0.0218F, -0.0378F, -0.524F));

		ModelPartData wing1_r2 = wing1.addChild("wing1_r2", ModelPartBuilder.create().uv(0, 79).cuboid(19.0339F, 8.6583F, -61.4584F, 30.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 0.0F, -4.0F, 0.0218F, -0.0378F, -0.524F));

		ModelPartData wing2 = wings.addChild("wing2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData wing2_r1 = wing2.addChild("wing2_r1", ModelPartBuilder.create().uv(61, 0).cuboid(58.9661F, 8.6583F, -55.4584F, 30.0F, 0.0F, 28.0F, new Dilation(0.01F)), ModelTransform.of(-84.0F, -54.0F, -2.0F, 0.0218F, 0.0378F, 0.524F));

		ModelPartData wing2_r2 = wing2.addChild("wing2_r2", ModelPartBuilder.create().uv(64, 85).cuboid(58.9661F, 8.6583F, -61.4584F, 30.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-84.0F, -55.0F, 0.0F, 0.0218F, 0.0378F, 0.524F));

		ModelPartData wingtip2_r1 = wing2.addChild("wingtip2_r1", ModelPartBuilder.create().uv(68, 57).cuboid(85.5037F, 13.3073F, -55.4584F, 30.0F, 0.0F, 28.0F, new Dilation(0.01F)), ModelTransform.of(-150.0F, 10.0F, 1.0F, -0.0149F, 0.041F, -0.3494F));

		ModelPartData wingtip2_r2 = wing2.addChild("wingtip2_r2", ModelPartBuilder.create().uv(63, 93).cuboid(85.5037F, 12.3073F, -59.4584F, 30.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-150.0F, 10.0F, 2.0F, -0.0149F, 0.041F, -0.3494F));

		ModelPartData neck = ArdenimiumDragon.addChild("neck", ModelPartBuilder.create(), ModelTransform.of(-0.6F, 8.0F, -4.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData neck_r1 = neck.addChild("neck_r1", ModelPartBuilder.create().uv(82, 57).cuboid(-0.9F, 40.3721F, -82.6318F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -79.0F, 37.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData neck_r2 = neck.addChild("neck_r2", ModelPartBuilder.create().uv(114, 137).cuboid(-0.9F, 47.3721F, -84.6318F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -84.0F, 39.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData neck_r3 = neck.addChild("neck_r3", ModelPartBuilder.create().uv(52, 105).cuboid(-0.9F, 47.0118F, -59.9953F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -74.0F, 28.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData neck_r4 = neck.addChild("neck_r4", ModelPartBuilder.create().uv(17, 134).cuboid(-0.9F, 54.0118F, -61.9953F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -78.0F, 31.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData neck_r5 = neck.addChild("neck_r5", ModelPartBuilder.create().uv(62, 57).cuboid(-0.9F, 50.7591F, -36.2211F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -73.0F, 19.0F, -0.7418F, 0.0F, 0.0F));

		ModelPartData neck_r6 = neck.addChild("neck_r6", ModelPartBuilder.create().uv(127, 125).cuboid(-0.9F, 57.7591F, -38.2211F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -76.0F, 23.0F, -0.7418F, 0.0F, 0.0F));

		ModelPartData neck_r7 = neck.addChild("neck_r7", ModelPartBuilder.create().uv(0, 123).cuboid(-0.9F, 46.0314F, -84.3943F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -70.0F, 59.0F, -0.3098F, 0.0F, 0.0F));

		ModelPartData neck_r8 = neck.addChild("neck_r8", ModelPartBuilder.create().uv(0, 111).cuboid(-0.9F, 37.9759F, -82.2197F, 1.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -73.0F, 55.0F, -0.2182F, 0.0F, 0.0F));

		ModelPartData neck_r9 = neck.addChild("neck_r9", ModelPartBuilder.create().uv(41, 135).cuboid(-0.9F, 54.0004F, -79.3111F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -58.0F, 56.0F, -0.5672F, 0.0F, 0.0F));

		ModelPartData neck_r10 = neck.addChild("neck_r10", ModelPartBuilder.create().uv(78, 79).cuboid(-0.9F, 47.0004F, -77.3111F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -54.0F, 53.0F, -0.5672F, 0.0F, 0.0F));

		ModelPartData body = ArdenimiumDragon.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(149, 0).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -46.0F, -27.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData cube_r2 = body.addChild("cube_r2", ModelPartBuilder.create().uv(18, 146).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -45.0F, -16.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData cube_r3 = body.addChild("cube_r3", ModelPartBuilder.create().uv(149, 9).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -44.0F, -6.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData cube_r4 = body.addChild("cube_r4", ModelPartBuilder.create().uv(0, 29).cuboid(-15.0F, -12.0F, -4.0F, 14.0F, 16.0F, 34.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -35.0F, -29.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData head = ArdenimiumDragon.addChild("head", ModelPartBuilder.create().uv(0, 21).cuboid(-7.0F, -57.746F, -68.423F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
				.uv(139, 37).cuboid(-6.0F, -54.746F, -75.423F, 6.0F, 2.0F, 7.0F, new Dilation(0.0F))
				.uv(0, 103).cuboid(-1.0F, -58.746F, -66.423F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 24).cuboid(-5.0F, -55.746F, -74.423F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(26, 37).cuboid(-2.0F, -55.746F, -74.423F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(90, 99).cuboid(-6.0F, -58.746F, -66.423F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 3.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(21, 17).cuboid(-4.0F, 6.8337F, -68.2944F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 20).cuboid(3.0F, 6.8337F, -68.2944F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -103.0F, -8.0F, 0.6109F, 0.0F, 0.0F));

		ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(52, 96).cuboid(-4.5F, 5.0837F, -68.2944F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F))
				.uv(145, 97).cuboid(2.5F, 5.0837F, -68.2944F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -98.0F, -13.0F, 0.6109F, 0.0F, 0.0F));

		ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(137, 28).cuboid(-6.0F, 39.057F, -58.2627F, 6.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -94.0F, -19.0F, 0.0436F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		ArdenimiumDragon.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart getPart() {
		return ArdenimiumDragon;
	}
	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}