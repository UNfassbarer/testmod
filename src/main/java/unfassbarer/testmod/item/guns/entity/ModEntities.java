package unfassbarer.testmod.item.guns.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;

public class ModEntities {
    public static final EntityType<ArdenimBulletEntity> ARDENIM_BULLET_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(Testmod.MOD_ID, "ardenim_bullet"),  // Verwenden Sie den Entity-Namen und nicht den Texturpfad
            FabricEntityTypeBuilder.<ArdenimBulletEntity>create()
                    .entityFactory(ArdenimBulletEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(80).trackedUpdateRate(3) // Tracking-Parameter
                    .build()
    );
    public static void registerEntities() {
        // Platzhaltermethode, um sicherzustellen, dass diese Klasse geladen wird und die statischen Initialisierer ausgeführt werden
    }
}
