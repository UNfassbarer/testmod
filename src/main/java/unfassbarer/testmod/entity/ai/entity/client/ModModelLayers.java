package unfassbarer.testmod.entity.ai.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(new Identifier(Testmod.MOD_ID, "porcupine"), "main");
}
