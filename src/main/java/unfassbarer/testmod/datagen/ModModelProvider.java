package unfassbarer.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.item.TestModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool Ardenim = blockStateModelGenerator.registerCubeAllModelTexturePool(TestModBlocks.Ardenim_Block);
        BlockStateModelGenerator.BlockTexturePool Brick = blockStateModelGenerator.registerCubeAllModelTexturePool(TestModBlocks.Ardenim_Brick_Block);
        blockStateModelGenerator.registerSimpleCubeAll(TestModBlocks.Raw_Ardenim_Block);
        blockStateModelGenerator.registerSimpleCubeAll(TestModBlocks.Ardenim_Ore);
        blockStateModelGenerator.registerSimpleCubeAll(TestModBlocks.Ardenim_Egg_Ore);
        blockStateModelGenerator.registerLog(TestModBlocks.Ardenim_Pillar_Block)
                .log(TestModBlocks.Ardenim_Pillar_Block);
        blockStateModelGenerator.registerSimpleCubeAll(TestModBlocks.Smooth_Ardenim_Block);
        blockStateModelGenerator.registerDoor(TestModBlocks.Ardenim_Door);
        blockStateModelGenerator.registerTrapdoor(TestModBlocks.Ardenim_Trapdoor);
        blockStateModelGenerator.registerSimpleCubeAll(TestModBlocks.Ardenim_Glass);
        blockStateModelGenerator.registerSimpleState(TestModBlocks.ArdenimiumCrafter);
        blockStateModelGenerator.registerSimpleState(TestModBlocks.PatternProvider);
        blockStateModelGenerator.registerSimpleState(TestModBlocks.Nether_Star_Core);
        blockStateModelGenerator.registerSimpleState(TestModBlocks.Solar_Strabilizer);
        blockStateModelGenerator.registerSimpleState(TestModBlocks.Ardenimium_Egg);
        blockStateModelGenerator.registerSimpleState(TestModBlocks.Ardenimium_Lamp);

        Ardenim.stairs(TestModBlocks.Ardenim_Stairs);
        Ardenim.slab(TestModBlocks.Ardenim_Slab);
        Ardenim.button(TestModBlocks.Ardenim_Button);
        Ardenim.pressurePlate(TestModBlocks.Ardenim_Pressure_Plate);
        Ardenim.fence(TestModBlocks.Ardenim_Fence);
        Ardenim.fenceGate(TestModBlocks.Ardenim_Fence_Gate);
        Ardenim.wall(TestModBlocks.Ardenim_Wall);

        Brick.stairs(TestModBlocks.Ardenim_Brick_Stairs);
        Brick.slab(TestModBlocks.Ardenim_Brick_Slab);
        Brick.wall(TestModBlocks.Ardenim_Brick_Wall);
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(TestModItems.Ardenim, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Ardenimium, Models.GENERATED);

        itemModelGenerator.register(TestModItems.Ardenim_apple, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Ardenimium_apple, Models.GENERATED);
        itemModelGenerator.register(TestModItems.raw_Ardenim, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Ardenim_Nugget, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Ardenimium_Nugget, Models.GENERATED);

        itemModelGenerator.register(TestModItems.Ardenim_Axe, Models.HANDHELD);
        itemModelGenerator.register(TestModItems.Ardenim_Hoe, Models.HANDHELD);
        itemModelGenerator.register(TestModItems.Ardenim_Shovel, Models.HANDHELD);
        itemModelGenerator.register(TestModItems.Ardenim_Pickaxe, Models.HANDHELD);
        itemModelGenerator.register(TestModItems.Ardenim_Sword, Models.HANDHELD);

        itemModelGenerator.register(TestModItems.Ardenimium_Hoe, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) TestModItems.Ardenim_Helmet));
        itemModelGenerator.registerArmor(((ArmorItem) TestModItems.Ardenim_Chestplate));
        itemModelGenerator.registerArmor(((ArmorItem) TestModItems.Ardenim_Leggings));
        itemModelGenerator.registerArmor(((ArmorItem) TestModItems.Ardenim_Boots));

        itemModelGenerator.registerArmor(((ArmorItem) TestModItems.Ardenimium_Helmet));
        itemModelGenerator.registerArmor(((ArmorItem) TestModItems.Ardenimium_Chestplate));
        itemModelGenerator.registerArmor(((ArmorItem) TestModItems.Ardenimium_Leggings));
        itemModelGenerator.registerArmor(((ArmorItem) TestModItems.Ardenimium_Boots));

        itemModelGenerator.register(TestModItems.Ardenimium_Gun, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Ardenimium_Bullet, Models.GENERATED);

        itemModelGenerator.register(TestModItems.Blank_Pattern,Models.GENERATED);
        itemModelGenerator.register(TestModItems.Shovel_Pattern, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Sword_Pattern, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Hoe_Pattern, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Axe_Pattern, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Pickaxe_Pattern, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Helmet_Pattern, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Chestplate_Pattern, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Leggings_Pattern, Models.GENERATED);
        itemModelGenerator.register(TestModItems.Boots_Pattern, Models.GENERATED);

        itemModelGenerator.register(Testmod.Ardenim_Bucket, Models.GENERATED);
    }
}
