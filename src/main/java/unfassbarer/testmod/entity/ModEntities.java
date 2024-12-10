package unfassbarer.testmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.entity.custom.ArdenimBulletEntity;
import unfassbarer.testmod.entity.custom.ArdenimiumDragonEntity;
import unfassbarer.testmod.entity.custom.PorcupineEntity;

public class ModEntities {
    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(Testmod.MOD_ID, "porcupine"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PorcupineEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static final EntityType<ArdenimiumDragonEntity> ARDENIMIUM_DRAGON = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(Testmod.MOD_ID, "ardenimium_dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ArdenimiumDragonEntity::new)
                    .dimensions(EntityDimensions.fixed(2.75f, 2.75f)).build());


    public static final EntityType<ArdenimBulletEntity> ARDENIM_BULLET_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Testmod.MOD_ID, "dice_projectile"),
            FabricEntityTypeBuilder.<ArdenimBulletEntity>create(SpawnGroup.MISC, ArdenimBulletEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static void registerModEntities() {
        Testmod.LOGGER.info("Registering Entities for " + Testmod.MOD_ID);
    }
}