package unfassbarer.testmod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.block.TestModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<NetherStarCoreEntity> NETHER_STAR_CORE_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Testmod.MOD_ID, "nether_star_core_entity"),
                    FabricBlockEntityTypeBuilder.create(NetherStarCoreEntity::new, TestModBlocks.Nether_Star_Core).build());

    public static final BlockEntityType<ArdenimiumCrafterEntity> ARDENIMIUM_CRAFTER_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Testmod.MOD_ID, "ardenimium_crafter"),
                    FabricBlockEntityTypeBuilder.create(ArdenimiumCrafterEntity::new, TestModBlocks.ArdenimiumCrafter).build());

    public static final BlockEntityType<ArdenimiumEggEntity> ARDENIMIUM_EGG_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Testmod.MOD_ID, "ardenimium_egg_entity"),
                    FabricBlockEntityTypeBuilder.create(ArdenimiumEggEntity::new, TestModBlocks.Ardenimium_Egg).build());

    public static final BlockEntityType<PatternProviderEntity> PATTERN_PROVIDER_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Testmod.MOD_ID, "pattern_providing"),
                    FabricBlockEntityTypeBuilder.create(PatternProviderEntity::new,
                            TestModBlocks.PatternProvider).build());

    public static final BlockEntityType<ArdenimiumLampEntity> ARDENIMIUM_LAMP_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Testmod.MOD_ID, "ardenimium_lamp_entity"),
                    FabricBlockEntityTypeBuilder.create(ArdenimiumLampEntity::new, TestModBlocks.Ardenimium_Lamp).build());

    public static final BlockEntityType<MoonAltarEntity> MOON_ALTAR_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Testmod.MOD_ID, "moon_altar_entity"),
                    FabricBlockEntityTypeBuilder.create(MoonAltarEntity::new,
                            TestModBlocks.Moon_Altar).build());


    public static void registerBlockEntities() {
        Testmod.LOGGER.info("Registering Block Entities for " + Testmod.MOD_ID);
    }
}