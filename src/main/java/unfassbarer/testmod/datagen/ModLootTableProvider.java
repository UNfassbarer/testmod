package unfassbarer.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.item.TestModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(TestModBlocks.Ardenim_Block);
        addDrop(TestModBlocks.Smooth_Ardenim_Block);
        addDrop(TestModBlocks.Ardenim_Pillar_Block);
        addDrop(TestModBlocks.Ardenim_Brick_Block);
        addDrop(TestModBlocks.Raw_Ardenim_Block);
        addDrop(TestModBlocks.Ardenim_Ore, ArdenimOre(TestModBlocks.Ardenim_Ore, TestModItems.raw_Ardenim));
        addDrop(TestModBlocks.Ardenim_Egg_Ore, ArdenimEggOre(TestModBlocks.Ardenim_Egg_Ore, Item.fromBlock(TestModBlocks.Ardenimium_Egg)));

        addDrop(TestModBlocks.Ardenim_Stairs);
        addDrop(TestModBlocks.Ardenim_Brick_Stairs);
        addDrop(TestModBlocks.Ardenim_Trapdoor);
        addDrop(TestModBlocks.Ardenim_Wall);
        addDrop(TestModBlocks.Ardenim_Brick_Wall);
        addDrop(TestModBlocks.Ardenim_Fence);
        addDrop(TestModBlocks.Ardenim_Fence_Gate);
        addDrop(TestModBlocks.Ardenim_Button);
        addDrop(TestModBlocks.Ardenim_Pressure_Plate);

        addDrop(TestModBlocks.Ardenim_Glass);
        addDrop(TestModBlocks.Ardenim_Glass_Pane);

        addDrop(TestModBlocks.Ardenim_Door, doorDrops(TestModBlocks.Ardenim_Door));
        addDrop(TestModBlocks.Ardenim_Slab, slabDrops(TestModBlocks.Ardenim_Slab));
        addDrop(TestModBlocks.Ardenim_Brick_Slab, slabDrops(TestModBlocks.Ardenim_Brick_Slab));
        addDrop(TestModBlocks.Nether_Star_Core);
        addDrop(TestModBlocks.Solar_Strabilizer);
        addDrop(TestModBlocks.Ardenimium_Egg);

        addDrop(TestModBlocks.ArdenimiumCrafter);
        addDrop(TestModBlocks.PatternProvider);
        addDrop(TestModBlocks.Ardenimium_Lamp);
    }

    public LootTable.Builder ArdenimOre(Block drop, Item item) {
        return dropsWithSilkTouch(drop, applyExplosionDecay(drop, ItemEntry
                .builder(item)
                .apply(SetCountLootFunction
                        .builder(UniformLootNumberProvider
                                .create(2.0F, 5.0F)))
                .apply(ApplyBonusLootFunction
                        .oreDrops(Enchantments.FORTUNE))));
    }

    public LootTable.Builder ArdenimEggOre(Block drop, Item item) {
        return dropsWithSilkTouch(drop, applyExplosionDecay(drop, ItemEntry
                .builder(item)
                .apply(SetCountLootFunction
                        .builder(BinomialLootNumberProvider.create(1, 0.075F))) // 7,5% Chance für einen Drop
        ));
    }
}
