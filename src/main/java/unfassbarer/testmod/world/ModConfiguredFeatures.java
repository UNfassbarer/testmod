package unfassbarer.testmod.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.block.TestModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_ARDENIM_ORE_KEY = registerKey("ardenim_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_EGG_ORE_KEY = registerKey("egg_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);
        List<OreFeatureConfig.Target> endArdenimOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, TestModBlocks.Ardenim_Ore.getDefaultState()));
        register(context, END_ARDENIM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endArdenimOres, 8));
        List<OreFeatureConfig.Target> endArdenimEggOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, TestModBlocks.Ardenim_Egg_Ore.getDefaultState()));
        register(context, END_EGG_ORE_KEY, Feature.ORE, new OreFeatureConfig(endArdenimEggOres, 3));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Testmod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
