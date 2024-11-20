package unfassbarer.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.block.custom.ArdenimNeonBlock;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(TestModBlocks.Ardenim_Block)
                .add(TestModBlocks.Smooth_Ardenim_Block)
                .add(TestModBlocks.Ardenim_Pillar_Block)
                .add(TestModBlocks.Ardenim_Brick_Block)
                .add(TestModBlocks.Raw_Ardenim_Block)
                .add(TestModBlocks.Ardenim_Ore)
                .add(TestModBlocks.Ardenim_Egg_Ore)
                .add(TestModBlocks.Nether_Star_Core)
                .add(TestModBlocks.Solar_Strabilizer)

                .add(TestModBlocks.Ardenim_Slab)
                .add(TestModBlocks.Ardenim_Stairs)
                .add(TestModBlocks.Ardenim_Brick_Slab)
                .add(TestModBlocks.Ardenim_Brick_Stairs)
                .add(TestModBlocks.Ardenim_Button)
                .add(TestModBlocks.Ardenim_Pressure_Plate)
                .add(TestModBlocks.Ardenim_Fence)
                .add(TestModBlocks.Ardenim_Fence_Gate)
                .add(TestModBlocks.Ardenim_Wall)
                .add(TestModBlocks.Ardenim_Brick_Wall)
                .add(TestModBlocks.Ardenim_Door)
                .add(TestModBlocks.Ardenim_Trapdoor)
                .add(TestModBlocks.Ardenim_Glass)
                .add(TestModBlocks.Ardenim_Glass_Pane)
                .add(TestModBlocks.ArdenimiumCrafter)
                .add(TestModBlocks.PatternProvider)
                .add(TestModBlocks.Ardenimium_Egg)
                .add(TestModBlocks.Ardenimium_Lamp)
                .add(ArdenimNeonBlock.Ardenim_Neon_Block);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(TestModBlocks.Ardenim_Block)
                .add(TestModBlocks.Smooth_Ardenim_Block)
                .add(TestModBlocks.Ardenim_Pillar_Block)
                .add(TestModBlocks.Ardenim_Brick_Block)
                .add(TestModBlocks.Raw_Ardenim_Block)
                .add(TestModBlocks.Ardenim_Ore)
                .add(TestModBlocks.Ardenim_Egg_Ore)
                .add(TestModBlocks.Nether_Star_Core)
                .add(TestModBlocks.Solar_Strabilizer)

                .add(TestModBlocks.Ardenim_Slab)
                .add(TestModBlocks.Ardenim_Stairs)
                .add(TestModBlocks.Ardenim_Brick_Slab)
                .add(TestModBlocks.Ardenim_Brick_Stairs)
                .add(TestModBlocks.Ardenim_Button)
                .add(TestModBlocks.Ardenim_Pressure_Plate)
                .add(TestModBlocks.Ardenim_Fence)
                .add(TestModBlocks.Ardenim_Fence_Gate)
                .add(TestModBlocks.Ardenim_Wall)
                .add(TestModBlocks.Ardenim_Brick_Wall)
                .add(TestModBlocks.Ardenim_Door)
                .add(TestModBlocks.Ardenim_Trapdoor)
                .add(TestModBlocks.Ardenim_Glass)
                .add(TestModBlocks.Ardenim_Glass_Pane)
                .add(TestModBlocks.ArdenimiumCrafter)
                .add(TestModBlocks.Ardenimium_Egg)
                .add(TestModBlocks.PatternProvider)
                .add(TestModBlocks.Ardenimium_Lamp)
                .add(ArdenimNeonBlock.Ardenim_Neon_Block);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(TestModBlocks.Ardenim_Fence);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(TestModBlocks.Ardenim_Fence_Gate);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(TestModBlocks.Ardenim_Wall)
                .add(TestModBlocks.Ardenim_Brick_Wall);
    }
}