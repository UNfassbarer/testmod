package unfassbarer.testmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.entity.custom.ArdenimiumDragonEntity;

public class ArdenimiumDragonRenderer extends MobEntityRenderer<ArdenimiumDragonEntity, ArdenimiumDragonModel<ArdenimiumDragonEntity>> {
    private static final Identifier TEXTURE = new Identifier(Testmod.MOD_ID, "textures/entity/ardenimium_dragon.png");

    public ArdenimiumDragonRenderer(EntityRendererFactory.Context context) {
        super(context, new ArdenimiumDragonModel<>(context.getPart(ModModelLayers.ARDENIMIUM_DRAGON)), 0.6f);
    }

    @Override
    public Identifier getTexture(ArdenimiumDragonEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(ArdenimiumDragonEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}