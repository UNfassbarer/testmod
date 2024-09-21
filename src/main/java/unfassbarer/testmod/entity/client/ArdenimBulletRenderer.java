package unfassbarer.testmod.entity.client;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.entity.custom.ArdenimBulletEntity;

public class ArdenimBulletRenderer extends EntityRenderer<ArdenimBulletEntity> {
    private static final Identifier TEXTURE = new Identifier(Testmod.MOD_ID, "textures/entity/ardenimium_bullet.png");
    public ArdenimBulletRenderer(EntityRendererFactory.Context context) {
        super(context);
    }
    @Override
    public Identifier getTexture(ArdenimBulletEntity entity) {
        return TEXTURE;
    }
}
