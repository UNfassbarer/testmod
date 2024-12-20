package unfassbarer.testmod.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.world.biome.ModBiomes;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule Ardenim_Block = makeStateRule(TestModBlocks.Ardenim_Block);
    private static final MaterialRules.MaterialRule Ardenim_Ore = makeStateRule(TestModBlocks.Ardenim_Ore);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);


        



        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.TEST_BIOME),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, Ardenim_Ore)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, Ardenim_Block)),

                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.TEST_BIOME_2),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, Ardenim_Ore)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, Ardenim_Block)),


                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
