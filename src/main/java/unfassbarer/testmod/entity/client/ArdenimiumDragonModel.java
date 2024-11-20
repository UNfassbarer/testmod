// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package unfassbarer.testmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import unfassbarer.testmod.entity.animation.ModAnimations;
import unfassbarer.testmod.entity.custom.ArdenimiumDragonEntity;

public class ArdenimiumDragonModel<T extends ArdenimiumDragonEntity> extends SinglePartEntityModel<T> {
    private final ModelPart ArdenimiumDragon;

    public ArdenimiumDragonModel(ModelPart root) {
        this.ArdenimiumDragon = root.getChild("ArdenimiumDragon");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData ArdenimiumDragon = modelPartData.addChild("ArdenimiumDragon", ModelPartBuilder.create(), ModelTransform.pivot(7.0F, 40.0F, 21.0F));

        ModelPartData body = ArdenimiumDragon.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(176, 9).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -46.0F, -27.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData cube_r2 = body.addChild("cube_r2", ModelPartBuilder.create().uv(166, 169).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -45.0F, -16.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData cube_r3 = body.addChild("cube_r3", ModelPartBuilder.create().uv(176, 0).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -44.0F, -6.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData cube_r4 = body.addChild("cube_r4", ModelPartBuilder.create().uv(0, 29).cuboid(-15.0F, -12.0F, -4.0F, 14.0F, 16.0F, 34.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -35.0F, -29.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(150, 169).cuboid(-7.0F, -13.6819F, -43.2023F, 2.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -23.0F, 41.0F, -0.2182F, 0.0F, 0.0F));

        ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(48, 167).cuboid(-8.5F, -39.5896F, -4.4811F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 28.0F, -32.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0175F, 0.0F, 0.0F));

        ModelPartData tail_r2 = tail2.addChild("tail_r2", ModelPartBuilder.create().uv(28, 178).cuboid(-6.5F, -38.969F, 13.1389F, 1.0F, 3.0F, 5.0F, new Dilation(0.0F))
                .uv(154, 157).cuboid(-8.5F, -36.5495F, 11.7179F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 25.0F, -57.0F, 0.0436F, 0.0F, 0.0F));

        ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.0F, 10.0F, 0.0611F, 0.0F, 0.0F));

        ModelPartData tail_r3 = tail3.addChild("tail_r3", ModelPartBuilder.create().uv(52, 179).cuboid(-6.5F, -24.5934F, 37.7137F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -91.0F, -0.2182F, 0.0F, 0.0F));

        ModelPartData tail_r4 = tail3.addChild("tail_r4", ModelPartBuilder.create().uv(130, 157).cuboid(-8.5F, -22.2186F, 39.629F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -94.0F, -0.2618F, 0.0F, 0.0F));

        ModelPartData tail4 = tail3.addChild("tail4", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0175F, 0.0F, 0.0F));

        ModelPartData tail_r5 = tail4.addChild("tail_r5", ModelPartBuilder.create().uv(40, 179).cuboid(-6.5F, -18.6733F, 61.3501F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -23.0F, -116.0F, -0.4363F, 0.0F, 0.0F));

        ModelPartData tail_r6 = tail4.addChild("tail_r6", ModelPartBuilder.create().uv(164, 57).cuboid(-8.5F, -17.7466F, 60.5481F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -22.0F, -116.0F, -0.4363F, 0.0F, 0.0F));

        ModelPartData tail5 = tail4.addChild("tail5", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0349F, 0.0F, 0.0F));

        ModelPartData tail_r7 = tail5.addChild("tail_r7", ModelPartBuilder.create().uv(180, 85).cuboid(-6.5F, -21.3586F, 76.9954F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -33.0F, -133.0F, -0.5236F, 0.0F, 0.0F));

        ModelPartData tail_r8 = tail5.addChild("tail_r8", ModelPartBuilder.create().uv(82, 157).cuboid(-8.5F, -20.3586F, 75.9954F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -32.0F, -133.0F, -0.5236F, 0.0F, 0.0F));

        ModelPartData tail6 = tail5.addChild("tail6", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0524F, 0.0F, 0.0F));

        ModelPartData tail_r9 = tail6.addChild("tail_r9", ModelPartBuilder.create().uv(150, 180).cuboid(-6.5F, -53.5849F, 44.8475F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(72, 169).cuboid(-8.5F, -52.0357F, 44.7266F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.0F, -127.0F, -0.5672F, 0.0F, 0.0F));

        ModelPartData tail7 = tail6.addChild("tail7", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0524F, 0.0F, 0.0F));

        ModelPartData tail_r10 = tail7.addChild("tail_r10", ModelPartBuilder.create().uv(176, 179).cuboid(-6.5F, -52.9591F, 58.7335F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, -141.0F, -0.48F, 0.0F, 0.0F));

        ModelPartData tail_r11 = tail7.addChild("tail_r11", ModelPartBuilder.create().uv(164, 132).cuboid(-8.5F, -51.2948F, 58.8014F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, -142.0F, -0.48F, 0.0F, 0.0F));

        ModelPartData tail8 = tail7.addChild("tail8", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, 0.0175F, 0.0F, 0.0F));

        ModelPartData tail_r12 = tail8.addChild("tail_r12", ModelPartBuilder.create().uv(64, 181).cuboid(-6.5F, -49.8626F, 70.4923F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 10.0F, -153.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData tail_r13 = tail8.addChild("tail_r13", ModelPartBuilder.create().uv(96, 169).cuboid(-8.0F, -48.696F, 70.2161F, 4.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 11.0F, -153.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData tail9 = tail8.addChild("tail9", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, -0.0175F, 0.0F, 0.0F));

        ModelPartData tail_r14 = tail9.addChild("tail_r14", ModelPartBuilder.create().uv(0, 179).cuboid(-6.5F, -38.9682F, 86.5062F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F))
                .uv(164, 18).cuboid(-8.0F, -36.8308F, 86.1279F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 11.0F, -167.0F, -0.2182F, 0.0F, 0.0F));

        ModelPartData tail10 = tail9.addChild("tail10", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, -0.0349F, 0.0F, 0.0F));

        ModelPartData tail_r15 = tail10.addChild("tail_r15", ModelPartBuilder.create().uv(180, 91).cuboid(-6.5F, -25.728F, 66.3736F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(150, 4).cuboid(-7.5F, -24.052F, 62.7897F, 3.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 19.0F, -144.0F, -0.0436F, 0.0F, 0.0F));

        ModelPartData tail11 = tail10.addChild("tail11", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, -0.0524F, 0.0F, 0.0F));

        ModelPartData tail_r16 = tail11.addChild("tail_r16", ModelPartBuilder.create().uv(178, 157).cuboid(-6.5F, -15.7371F, 73.4556F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 20.0F, -152.0F, 0.0436F, 0.0F, 0.0F));

        ModelPartData tail_r17 = tail11.addChild("tail_r17", ModelPartBuilder.create().uv(0, 157).cuboid(-7.5F, -13.507F, 72.5602F, 3.0F, 4.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 19.0F, -153.0F, 0.0436F, 0.0F, 0.0F));

        ModelPartData tail12 = tail11.addChild("tail12", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 10.0F, -0.0524F, 0.0F, 0.0F));

        ModelPartData tail_r18 = tail12.addChild("tail_r18", ModelPartBuilder.create().uv(0, 170).cuboid(-6.5F, -17.6927F, 79.9504F, 1.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 37.0F, -157.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData tail_r19 = tail12.addChild("tail_r19", ModelPartBuilder.create().uv(154, 93).cuboid(-7.0F, -15.117F, 78.7404F, 2.0F, 3.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 36.0F, -158.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData wings = body.addChild("wings", ModelPartBuilder.create(), ModelTransform.of(0.0F, -43.0F, 35.0F, 0.0436F, 0.0F, 0.0F));

        ModelPartData wing1 = wings.addChild("wing1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData wingtip1_r1 = wing1.addChild("wingtip1_r1", ModelPartBuilder.create().uv(0, 0).cuboid(104.9963F, 13.3073F, -55.4584F, 30.0F, 0.0F, 29.0F, new Dilation(0.01F)), ModelTransform.of(-74.0F, -64.0F, -9.0F, -0.0149F, -0.041F, 0.3494F));

        ModelPartData wingtip1_r2 = wing1.addChild("wingtip1_r2", ModelPartBuilder.create().uv(96, 73).cuboid(104.9963F, 12.3073F, -59.4584F, 30.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-74.0F, -64.0F, -7.0F, -0.0149F, -0.041F, 0.3494F));

        ModelPartData wing1_r1 = wing1.addChild("wing1_r1", ModelPartBuilder.create().uv(0, 79).cuboid(19.0339F, 8.6583F, -55.4584F, 30.0F, 0.0F, 28.0F, new Dilation(0.01F)), ModelTransform.of(-26.0F, 1.0F, -6.0F, 0.0218F, -0.0378F, -0.524F));

        ModelPartData wing1_r2 = wing1.addChild("wing1_r2", ModelPartBuilder.create().uv(96, 57).cuboid(19.0339F, 8.6583F, -61.4584F, 30.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 0.0F, -4.0F, 0.0218F, -0.0378F, -0.524F));

        ModelPartData wing2 = wings.addChild("wing2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData wing2_r1 = wing2.addChild("wing2_r1", ModelPartBuilder.create().uv(96, 29).cuboid(58.9661F, 8.6583F, -55.4584F, 30.0F, 0.0F, 28.0F, new Dilation(0.01F)), ModelTransform.of(-84.0F, -54.0F, -2.0F, 0.0218F, 0.0378F, 0.524F));

        ModelPartData wing2_r2 = wing2.addChild("wing2_r2", ModelPartBuilder.create().uv(96, 65).cuboid(58.9661F, 8.6583F, -61.4584F, 30.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-84.0F, -55.0F, 0.0F, 0.0218F, 0.0378F, 0.524F));

        ModelPartData wingtip2_r1 = wing2.addChild("wingtip2_r1", ModelPartBuilder.create().uv(0, 107).cuboid(85.5037F, 13.3073F, -55.4584F, 30.0F, 0.0F, 28.0F, new Dilation(0.01F)), ModelTransform.of(-150.0F, 10.0F, 1.0F, -0.0149F, 0.041F, -0.3494F));

        ModelPartData wingtip2_r2 = wing2.addChild("wingtip2_r2", ModelPartBuilder.create().uv(116, 79).cuboid(85.5037F, 12.3073F, -59.4584F, 30.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-150.0F, 10.0F, 2.0F, -0.0149F, 0.041F, -0.3494F));

        ModelPartData legs = body.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -101.0F, 0.0F));

        ModelPartData rearleg1 = legs.addChild("rearleg1", ModelPartBuilder.create(), ModelTransform.of(16.0F, -8.0F, 42.0F, 0.3054F, 0.0F, 0.0F));

        ModelPartData rearleg1_r1 = rearleg1.addChild("rearleg1_r1", ModelPartBuilder.create().uv(116, 123).cuboid(-4.0F, 39.001F, 24.2617F, 6.0F, 15.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-16.0F, 8.0F, -42.0F, -1.0472F, 0.0F, 0.0F));

        ModelPartData rearlegtip1 = rearleg1.addChild("rearlegtip1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 28.0F, 1.0F, 0.4363F, 0.0F, 0.0F));

        ModelPartData rearlegtip_r1 = rearlegtip1.addChild("rearlegtip_r1", ModelPartBuilder.create().uv(74, 135).cuboid(-4.5F, 27.1073F, -31.8656F, 5.0F, 16.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-15.0F, -20.0F, -43.0F, -0.3927F, 0.0F, 0.0F));

        ModelPartData rearfoot1 = rearlegtip1.addChild("rearfoot1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 32.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData rearfoot_r1 = rearfoot1.addChild("rearfoot_r1", ModelPartBuilder.create().uv(116, 108).cuboid(-3.5F, -1.6937F, -32.0853F, 7.0F, 3.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-17.0F, -52.0F, -42.0F, -1.5272F, 0.0F, 0.0F));

        ModelPartData frontleg1 = legs.addChild("frontleg1", ModelPartBuilder.create(), ModelTransform.of(26.0F, -4.0F, 3.0F, 1.1345F, 0.0F, 0.0F));

        ModelPartData frontleg1_r1 = frontleg1.addChild("frontleg1_r1", ModelPartBuilder.create().uv(26, 135).cuboid(-18.0F, 68.5157F, 11.1877F, 6.0F, 15.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, 4.0F, -2.0F, -1.8326F, 0.0F, 0.0F));

        ModelPartData frontleg1_r2 = frontleg1.addChild("frontleg1_r2", ModelPartBuilder.create().uv(30, 139).cuboid(-18.0F, 82.0F, 12.25F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, 5.0F, -2.0F, -1.8326F, 0.0F, 0.0F));

        ModelPartData frontlegtip1 = frontleg1.addChild("frontlegtip1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 20.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData frontlegtip_r1 = frontlegtip1.addChild("frontlegtip_r1", ModelPartBuilder.create().uv(110, 172).cuboid(-28.5F, 77.3689F, -41.4212F, 12.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -16.0F, -3.0F, -0.829F, 0.0F, 0.0F));

        ModelPartData frontlegtip_r2 = frontlegtip1.addChild("frontlegtip_r2", ModelPartBuilder.create().uv(118, 169).cuboid(-17.5F, 77.3689F, -43.4212F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -16.0F, -2.0F, -0.829F, 0.0F, 0.0F));

        ModelPartData frontfoot1 = frontlegtip1.addChild("frontfoot1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 22.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData frontfoot_r1 = frontfoot1.addChild("frontfoot_r1", ModelPartBuilder.create().uv(128, 145).cuboid(-17.5F, 58.725F, -43.275F, 6.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, -37.0F, -3.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData frontleg = legs.addChild("frontleg", ModelPartBuilder.create(), ModelTransform.of(-12.0F, -4.0F, 2.0F, 1.1345F, 0.0F, 0.0F));

        ModelPartData frontlegtip = frontleg.addChild("frontlegtip", ModelPartBuilder.create(), ModelTransform.of(0.0F, 20.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData frontfoot = frontlegtip.addChild("frontfoot", ModelPartBuilder.create(), ModelTransform.of(0.0F, 23.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData rearleg = legs.addChild("rearleg", ModelPartBuilder.create(), ModelTransform.of(-16.0F, -8.0F, 42.0F, 0.3054F, 0.0F, 0.0F));

        ModelPartData rearleg_r1 = rearleg.addChild("rearleg_r1", ModelPartBuilder.create().uv(0, 135).cuboid(-18.0F, 39.001F, 24.2617F, 6.0F, 15.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(16.0F, 8.0F, -42.0F, -1.0472F, 0.0F, 0.0F));

        ModelPartData rearlegtip = rearleg.addChild("rearlegtip", ModelPartBuilder.create(), ModelTransform.of(0.0F, 28.0F, 1.0F, 0.4363F, 0.0F, 0.0F));

        ModelPartData rearlegtip_r2 = rearlegtip.addChild("rearlegtip_r2", ModelPartBuilder.create().uv(142, 123).cuboid(-17.5F, 27.1073F, -31.8656F, 5.0F, 16.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(16.0F, -20.0F, -43.0F, -0.3927F, 0.0F, 0.0F));

        ModelPartData rearfoot = rearlegtip.addChild("rearfoot", ModelPartBuilder.create(), ModelTransform.of(0.0F, 32.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData rearfoot_r2 = rearfoot.addChild("rearfoot_r2", ModelPartBuilder.create().uv(116, 93).cuboid(-17.5F, -1.6937F, -32.0853F, 7.0F, 3.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(15.0F, -52.0F, -42.0F, -1.5272F, 0.0F, 0.0F));

        ModelPartData frontleg2 = legs.addChild("frontleg2", ModelPartBuilder.create(), ModelTransform.of(14.0F, -4.0F, 3.0F, 1.1345F, 0.0F, 0.0F));

        ModelPartData frontlegtip2 = frontleg2.addChild("frontlegtip2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 20.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData frontfoot2 = frontlegtip2.addChild("frontfoot2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 22.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData frontleg3 = legs.addChild("frontleg3", ModelPartBuilder.create(), ModelTransform.of(14.0F, -4.0F, 3.0F, 1.1345F, 0.0F, 0.0F));

        ModelPartData frontleg1_r3 = frontleg3.addChild("frontleg1_r3", ModelPartBuilder.create().uv(26, 135).cuboid(-18.0F, 68.5157F, 11.1877F, 6.0F, 15.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, 4.0F, -2.0F, -1.8326F, 0.0F, 0.0F));

        ModelPartData frontleg1_r4 = frontleg3.addChild("frontleg1_r4", ModelPartBuilder.create().uv(30, 139).cuboid(-18.0F, 82.0F, 12.25F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, 5.0F, -2.0F, -1.8326F, 0.0F, 0.0F));

        ModelPartData frontlegtip3 = frontleg3.addChild("frontlegtip3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 20.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData frontlegtip_r3 = frontlegtip3.addChild("frontlegtip_r3", ModelPartBuilder.create().uv(110, 172).cuboid(-28.5F, 77.3689F, -41.4212F, 12.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -16.0F, -3.0F, -0.829F, 0.0F, 0.0F));

        ModelPartData frontlegtip_r4 = frontlegtip3.addChild("frontlegtip_r4", ModelPartBuilder.create().uv(118, 169).cuboid(-17.5F, 77.3689F, -43.4212F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -16.0F, -2.0F, -0.829F, 0.0F, 0.0F));

        ModelPartData frontfoot3 = frontlegtip3.addChild("frontfoot3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 22.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData frontfoot_r2 = frontfoot3.addChild("frontfoot_r2", ModelPartBuilder.create().uv(128, 145).cuboid(-17.5F, 58.725F, -43.275F, 6.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, -37.0F, -3.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData head = ArdenimiumDragon.addChild("head", ModelPartBuilder.create().uv(118, 4).cuboid(-7.0F, -57.746F, -68.423F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 3.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData mouth_top = head.addChild("mouth_top", ModelPartBuilder.create().uv(26, 156).cuboid(-6.0F, -54.746F, -75.423F, 6.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(138, 24).cuboid(-5.0F, -55.746F, -74.423F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(146, 24).cuboid(-2.0F, -55.746F, -74.423F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData spike_left = head.addChild("spike_left", ModelPartBuilder.create().uv(118, 24).cuboid(-6.0F, -58.746F, -66.423F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData spike_right = head.addChild("spike_right", ModelPartBuilder.create().uv(128, 24).cuboid(-1.0F, -58.746F, -66.423F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData ears_left = head.addChild("ears_left", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r5 = ears_left.addChild("cube_r5", ModelPartBuilder.create().uv(96, 135).cuboid(-4.5F, 5.0837F, -68.2944F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -98.0F, -13.0F, 0.6109F, 0.0F, 0.0F));

        ModelPartData cube_r6 = ears_left.addChild("cube_r6", ModelPartBuilder.create().uv(154, 24).cuboid(-4.0F, 6.8337F, -68.2944F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -103.0F, -8.0F, 0.6109F, 0.0F, 0.0F));

        ModelPartData ears_right = head.addChild("ears_right", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r7 = ears_right.addChild("cube_r7", ModelPartBuilder.create().uv(166, 0).cuboid(-3.0F, 6.8337F, -68.2944F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -103.0F, -8.0F, 0.6109F, 0.0F, 0.0F));

        ModelPartData cube_r8 = ears_right.addChild("cube_r8", ModelPartBuilder.create().uv(164, 69).cuboid(-3.5F, 5.0837F, -68.2944F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -98.0F, -13.0F, 0.6109F, 0.0F, 0.0F));

        ModelPartData mouth_ground = head.addChild("mouth_ground", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r9 = mouth_ground.addChild("cube_r9", ModelPartBuilder.create().uv(54, 157).cuboid(-6.0F, 39.057F, -58.2627F, 6.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -94.0F, -19.0F, 0.0436F, 0.0F, 0.0F));

        ModelPartData neck = head.addChild("neck", ModelPartBuilder.create(), ModelTransform.of(4.4F, 10.0F, -7.0F, -0.0436F, 0.0F, 0.0F));

        ModelPartData neck1 = neck.addChild("neck1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData neck_r1 = neck1.addChild("neck_r1", ModelPartBuilder.create().uv(166, 179).cuboid(-0.9F, 40.3721F, -82.6318F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -79.0F, 37.0F, -0.3054F, 0.0F, 0.0F));

        ModelPartData neck_r2 = neck1.addChild("neck_r2", ModelPartBuilder.create().uv(24, 166).cuboid(-0.9F, 47.3721F, -84.6318F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -84.0F, 39.0F, -0.3054F, 0.0F, 0.0F));

        ModelPartData neck2 = neck1.addChild("neck2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData neck_r3 = neck2.addChild("neck_r3", ModelPartBuilder.create().uv(180, 109).cuboid(-0.9F, 47.0118F, -59.9953F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -74.0F, 28.0F, -0.5236F, 0.0F, 0.0F));

        ModelPartData neck_r4 = neck2.addChild("neck_r4", ModelPartBuilder.create().uv(164, 120).cuboid(-0.9F, 54.0118F, -61.9953F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -78.0F, 31.0F, -0.5236F, 0.0F, 0.0F));

        ModelPartData neck3 = neck2.addChild("neck3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData neck_r5 = neck3.addChild("neck_r5", ModelPartBuilder.create().uv(180, 97).cuboid(-0.9F, 50.7591F, -36.2211F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -73.0F, 19.0F, -0.7418F, 0.0F, 0.0F));

        ModelPartData neck_r6 = neck3.addChild("neck_r6", ModelPartBuilder.create().uv(106, 157).cuboid(-0.9F, 57.7591F, -38.2211F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -76.0F, 23.0F, -0.7418F, 0.0F, 0.0F));

        ModelPartData neck4 = neck3.addChild("neck4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData neck_r7 = neck4.addChild("neck_r7", ModelPartBuilder.create().uv(160, 145).cuboid(-0.9F, 54.0004F, -79.3111F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -58.0F, 56.0F, -0.5672F, 0.0F, 0.0F));

        ModelPartData neck_r8 = neck4.addChild("neck_r8", ModelPartBuilder.create().uv(180, 103).cuboid(-0.9F, 47.0004F, -77.3111F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -54.0F, 53.0F, -0.5672F, 0.0F, 0.0F));

        ModelPartData neck5 = neck4.addChild("neck5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData neck_r9 = neck5.addChild("neck_r9", ModelPartBuilder.create().uv(154, 107).cuboid(-0.9F, 46.0314F, -84.3943F, 5.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -70.0F, 59.0F, -0.3098F, 0.0F, 0.0F));

        ModelPartData neck_r10 = neck5.addChild("neck_r10", ModelPartBuilder.create().uv(16, 178).cuboid(-0.9F, 37.9759F, -82.2197F, 1.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -73.0F, 55.0F, -0.2182F, 0.0F, 0.0F));
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
    public void setAngles(ArdenimiumDragonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.animateMovement(ModAnimations.ARDENIMIUM_DRAGON_WALK, limbSwing, limbSwingAmount, 8f, 2.5f);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.ATTACK_1, ageInTicks, 6f);
    }
}