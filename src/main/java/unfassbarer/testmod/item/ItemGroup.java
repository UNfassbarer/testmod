package unfassbarer.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.block.TestModBlocks;

public class ItemGroup  {
public static final net.minecraft.item.ItemGroup ARDENIM_GROUP = Registry.register(Registries.ITEM_GROUP,
        new Identifier(Testmod.MOD_ID, "ardenim"),
        FabricItemGroup.builder().displayName(Text.translatable("Testmod"))
                .icon(() -> new ItemStack(TestModItems.Ardenim)).entries((displayContext, entries) -> {

                    entries.add(TestModItems.Ardenim);
                    entries.add(TestModBlocks.Ardenim_Block);
                    entries.add(TestModBlocks.Smooth_Ardenim_Block);
                    entries.add(TestModBlocks.Ardenim_Pillar_Block);
                    entries.add(TestModBlocks.Ardenim_Brick_Block);
                    entries.add(TestModItems.Ardenim_apple);
                    entries.add(TestModItems.Ardenimium_apple);
                    entries.add(TestModItems.raw_Ardenim);
                    entries.add(TestModBlocks.Ardenim_Ore);
                    entries.add(TestModBlocks.Ardenim_Egg_Ore);
                    entries.add(TestModItems.Ardenim_Nugget);
                    entries.add(TestModItems.Ardenim_Pickaxe);
                    entries.add(TestModItems.Ardenim_Axe);
                    entries.add(TestModItems.Ardenim_Shovel);
                    entries.add(TestModItems.Ardenim_Hoe);
                    entries.add(TestModItems.Ardenim_Sword);
                    entries.add(TestModItems.Ardenimium_Pickaxe);
                    entries.add(TestModItems.Ardenimium_Axe);
                    entries.add(TestModItems.Ardenimium_Shovel);
                    entries.add(TestModItems.Ardenimium_Hoe);
                    entries.add(TestModItems.Ardenimium_Sword);
                    entries.add(TestModBlocks.Ardenim_Stairs);
                    entries.add(TestModBlocks.Ardenim_Slab);
                    entries.add(TestModBlocks.Ardenim_Brick_Stairs);
                    entries.add(TestModBlocks.Ardenim_Brick_Slab);
                    entries.add(TestModBlocks.Ardenim_Button);
                    entries.add(TestModBlocks.Ardenim_Pressure_Plate);
                    entries.add(TestModBlocks.Ardenim_Fence);
                    entries.add(TestModBlocks.Ardenim_Fence_Gate);
                    entries.add(TestModBlocks.Ardenim_Wall);
                    entries.add(TestModBlocks.Ardenim_Brick_Wall);
                    entries.add(TestModBlocks.Ardenim_Door);
                    entries.add(TestModBlocks.Ardenim_Trapdoor);
                    entries.add(TestModBlocks.ArdenimiumCrafter);
                    entries.add(TestModBlocks.Ardenim_Glass);
                    entries.add(TestModBlocks.Ardenim_Glass_Pane);
                    entries.add(TestModBlocks.Nether_Star_Core);
                    entries.add(TestModBlocks.Solar_Strabilizer);

                    entries.add(TestModItems.Ardenim_Helmet);
                    entries.add(TestModItems.Ardenim_Chestplate);
                    entries.add(TestModItems.Ardenim_Leggings);
                    entries.add(TestModItems.Ardenim_Boots);
                    entries.add(TestModItems.Ardenimium_Helmet);
                    entries.add(TestModItems.Ardenimium_Chestplate);
                    entries.add(TestModItems.Ardenimium_Leggings);
                    entries.add(TestModItems.Ardenimium_Boots);
                    entries.add(TestModItems.Ardenimium);
                    entries.add(TestModItems.Ardenimium_Nugget);
                    entries.add(TestModItems.Ardenimium_Gun);
                    entries.add(TestModItems.Ardenimium_Bullet);
                    entries.add(TestModItems.Ardenimium_Casing);

                    entries.add(TestModItems.Blank_Pattern);
                    entries.add(TestModItems.Sword_Pattern);
                    entries.add(TestModItems.Hoe_Pattern);
                    entries.add(TestModItems.Axe_Pattern);
                    entries.add(TestModItems.Pickaxe_Pattern);
                    entries.add(TestModItems.Shovel_Pattern);
                    entries.add(TestModItems.Helmet_Pattern);
                    entries.add(TestModItems.Chestplate_Pattern);
                    entries.add(TestModItems.Leggings_Pattern);
                    entries.add(TestModItems.Boots_Pattern);
                    entries.add(TestModBlocks.Ardenimium_Egg);
                    entries.add(Testmod.Ardenim_Bucket);
                    entries.add(TestModBlocks.PatternProvider);

                }).build());
public static void registerItemGroups() {
    Testmod.LOGGER.info("Registering Item Group for " + Testmod.MOD_ID);
}
}