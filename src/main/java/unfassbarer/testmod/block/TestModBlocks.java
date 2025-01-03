package unfassbarer.testmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.block.custom.*;

public class TestModBlocks {

    public static final Block Ardenim_Block =
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0F, 1.0F).requiresTool());
    public static final Block Smooth_Ardenim_Block =
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0F, 1.0F).requiresTool());
    public static final Block Ardenim_Pillar_Block =
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0F, 1.0F).requiresTool());
    public static final Block Ardenim_Brick_Block =
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0F, 1.0F).requiresTool());
    public static final Block Ardenim_Ore =
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0F, 1.0F).requiresTool());
    public static final Block Ardenim_Egg_Ore =
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0F, 1.0F).requiresTool());
    public static final Block Raw_Ardenim_Block =
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0F, 1.0F).requiresTool());
    public static final Block Ardenim_Stairs =
            new StairsBlock(TestModBlocks.Ardenim_Block.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0F, 1.0F).requiresTool());
    public static final Block Ardenim_Slab =
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0F, 1.0F).requiresTool());
    public static final Block Ardenim_Brick_Stairs =
            new StairsBlock(TestModBlocks.Ardenim_Brick_Block.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0F, 1.0F).requiresTool());
    public static final Block Ardenim_Brick_Slab =
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0F, 1.0F).requiresTool());
    public static final Block Ardenim_Button =
            new ButtonBlock(BlockSetType.IRON, 10, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block Ardenim_Pressure_Plate =
            new PressurePlateBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block Ardenim_Fence =
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block Ardenim_Fence_Gate =
            new FenceGateBlock(WoodType.ACACIA, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block Ardenim_Wall =
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block Ardenim_Brick_Wall =
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final Block Ardenim_Door =
            new DoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque());
    public static final Block Ardenim_Trapdoor =
            new TrapdoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque());
    public static final Block Ardenim_Glass =
            new StainedGlassBlock(DyeColor.WHITE, FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).strength(0.5F, 1.0F).requiresTool().nonOpaque());
    public static final Block Ardenim_Glass_Pane =
            new StainedGlassPaneBlock(DyeColor.WHITE, FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).strength(0.5F, 1.0F).requiresTool().nonOpaque());
    public static final Block ArdenimiumCrafter =
            new ArdenimiumCrafter(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque());
    public static final Block PatternProvider =
            new PatternProvider(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque());
    public static final Block Nether_Star_Core =
            new NetherStarCore(FabricBlockSettings.copy(Blocks.IRON_BLOCK).luminance(state -> 15));
    public static final Block Solar_Strabilizer =
            new SolarStrabilizer(FabricBlockSettings.copy(Blocks.IRON_BLOCK).luminance(state -> 15));
    public static final Block Ardenimium_Egg =
            new ArdenimiumEgg(FabricBlockSettings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.BONE));
    public static final Block Ardenimium_Lamp =
            new ArdenimiumLamp(FabricBlockSettings.copy(Blocks.GLASS));
    public static final Block Moon_Altar =
            new MoonAltar(FabricBlockSettings.copy(Blocks.IRON_BLOCK));

    public static final Block Cutter =
            new Cutter(FabricBlockSettings.copy(Blocks.IRON_BLOCK));

    private static void registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        Registry.register(Registries.BLOCK, new Identifier(Testmod.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Testmod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        registerBlock("ardenim_block", Ardenim_Block);
        registerBlock("raw_ardenim_block", Raw_Ardenim_Block);
        registerBlock("ardenim_ore", Ardenim_Ore);
        registerBlock("ardenim_egg_ore", Ardenim_Egg_Ore);
        registerBlock("smooth_ardenim_block", Smooth_Ardenim_Block);
        registerBlock("ardenim_pillar_block", Ardenim_Pillar_Block);
        registerBlock("ardenim_slab", Ardenim_Slab);
        registerBlock("ardenim_stairs", Ardenim_Stairs);
        registerBlock("ardenim_brick_slab", Ardenim_Brick_Slab);
        registerBlock("ardenim_brick_stairs", Ardenim_Brick_Stairs);
        registerBlock("ardenim_button", Ardenim_Button);
        registerBlock("ardenim_pressure_plate", Ardenim_Pressure_Plate);
        registerBlock("ardenim_fence", Ardenim_Fence);
        registerBlock("ardenim_fence_gate", Ardenim_Fence_Gate);
        registerBlock("ardenim_wall", Ardenim_Wall);
        registerBlock("ardenim_brick_wall", Ardenim_Brick_Wall);
        registerBlock("ardenim_door", Ardenim_Door);
        registerBlock("ardenim_trapdoor", Ardenim_Trapdoor);
        registerBlock("ardenimium_crafter", ArdenimiumCrafter);
        registerBlock("ardenim_brick_block", Ardenim_Brick_Block);
        registerBlock("ardenim_glass", Ardenim_Glass);
        registerBlock("ardenim_glass_pane", Ardenim_Glass_Pane);
        registerBlock("pattern_provider", PatternProvider);
        registerBlock("nether_star_core", Nether_Star_Core);
        registerBlock("solar_stabilizer", Solar_Strabilizer);
        registerBlock("ardenimium_egg", Ardenimium_Egg);
        registerBlock("ardenimium_lamp", Ardenimium_Lamp);
        registerBlock("moon_altar", Moon_Altar);
        registerBlock("ardenim_neon_block", ArdenimNeonBlock.Ardenim_Neon_Block);
        registerBlock("cutter", Cutter);
        Testmod.LOGGER.info("Registering Mod Blocks for " + Testmod.MOD_ID);
    }
}