package unfassbarer.testmod.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(new Identifier(Testmod.MOD_ID, "porcupine"), "main");
    public static final EntityModelLayer ARDENIMIUM_DRAGON =
            new EntityModelLayer(new Identifier(Testmod.MOD_ID, "ardenimium_dragon"), "main");

    public static final EntityModelLayer ARDENIMIUM_BULLET =
            new EntityModelLayer(new Identifier(Testmod.MOD_ID, "ardenimium_bullet"), "main");


}
