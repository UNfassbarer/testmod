package unfassbarer.testmod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.item.TestModItems;


public class ModLootTableModifiers {
    private static final Identifier Stronghold_ID_1 =
            new Identifier("minecraft", "chests/stronghold_corridor");
    private static final Identifier Stronghold_ID_2 =
            new Identifier("minecraft", "chests/stronghold_crossing");
    private static final Identifier Stronghold_ID_3 =
            new Identifier("minecraft", "chests/stronghold_library");
    private static final Identifier SUSPICIOUS_SAND_ID =
            new Identifier("minecraft", "archaeology/desert_pyramid");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (Stronghold_ID_1.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(TestModItems.Ardenim))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (Stronghold_ID_2.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(TestModItems.Ardenim))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (Stronghold_ID_3.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(TestModItems.Ardenim))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
        //        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
        //            if (SUSPICIOUS_SAND_ID.equals(id)) {
        //               LootPool.Builder poolBuilder = LootPool.builder()
        //                        .rolls(ConstantLootNumberProvider.create(1))
        //                       .conditionally(RandomChanceLootCondition.builder(0.75f)) // 75% chance to drop
        //                       .with(ItemEntry.builder(TestModItems.Raw_Ardenim))
        //                      .with(ItemEntry.builder(TestModBlocks.Raw_Ardenim_Block))
        //                       .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

        //       tableBuilder.pool(poolBuilder.build());
        //    }
        //  });
    }

}
