package unfassbarer.testmod.item.guns.entity;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;

public class ArdenimBulletEntityRenderer extends EntityRenderer<ArdenimBulletEntity> {
    private static final Identifier TEXTURE = new Identifier(Testmod.MOD_ID, "textures/entity/ardenimium_bullet.png");
    public ArdenimBulletEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }
    @Override
    public Identifier getTexture(ArdenimBulletEntity entity) {
        return TEXTURE;
    }
}
