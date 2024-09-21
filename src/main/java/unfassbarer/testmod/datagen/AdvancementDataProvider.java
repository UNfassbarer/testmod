package unfassbarer.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.item.TestModItems;
import java.util.function.Consumer;

public class AdvancementDataProvider extends FabricAdvancementProvider {

    public AdvancementDataProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry ardenim = Advancement.Builder.create()
                .display(
                        TestModItems.Ardenim,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        new Identifier(Testmod.MOD_ID, "textures/block/smooth_ardenim_block.png"),
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("get_ardenim", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenim))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "ardenim").toString());
        
        AdvancementEntry ardenim_apple = Advancement.Builder.create()
                .parent(ardenim)
                .display(
                        TestModItems.Ardenim_apple,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("get_ardenim_apple", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenim_apple))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "ardenim_apple").toString());

        AdvancementEntry ardenimium_egg = Advancement.Builder.create()
                .parent(ardenim)
                .display(
                        TestModBlocks.Ardenimium_Egg,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("get_ardenimium_egg", InventoryChangedCriterion.Conditions.items(TestModBlocks.Ardenimium_Egg))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "ardenimium_egg").toString());

        AdvancementEntry ardenim_tools = Advancement.Builder.create()
                .parent(ardenim)
                .display(
                        TestModItems.Ardenim_Sword,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("craft_ardenim_shovel", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenim_Shovel))
                .criterion("craft_ardenim_sword",InventoryChangedCriterion.Conditions.items(TestModItems.Ardenim_Sword))
                .criterion("craft_ardenim_hoe", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenim_Hoe))
                .criterion("craft_ardenim_axe", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenim_Axe))
                .criterion("craft_ardenim_pickaxe", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenim_Pickaxe))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "get_ardenim_tools").toString());

        AdvancementEntry ardenim_armor = Advancement.Builder.create()
                .parent(ardenim)
                .display(
                        TestModItems.Ardenim_Chestplate,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("craft_ardenim_helmet", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenim_Helmet))
                .criterion("craft_ardenim_chestplate", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenim_Chestplate))
                .criterion("craft_ardenim_leggings", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenim_Leggings))
                .criterion("craft_ardenim_boots", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenim_Boots))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "get_ardenim_armor").toString());

        AdvancementEntry ardenimium = Advancement.Builder.create()
                .parent(ardenim)
                .display(
                        TestModItems.Ardenimium,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("get_ardenimium", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "get_ardenimium").toString());

        AdvancementEntry ardenimium_apple = Advancement.Builder.create()
                .parent(ardenim_apple)
                .display(
                        TestModItems.Ardenimium_apple,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("get_ardenimium_apple", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_apple))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "ardenimium_apple").toString());

        AdvancementEntry pattern_provider = Advancement.Builder.create()
                .parent(ardenimium)
                .display(
                        TestModBlocks.PatternProvider,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("get_pattern_provider", InventoryChangedCriterion.Conditions.items(TestModBlocks.PatternProvider))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "get_pattern_provider").toString());

        AdvancementEntry ardenimium_crafter = Advancement.Builder.create()
                .parent(pattern_provider)
                .display(
                        TestModBlocks.ArdenimiumCrafter,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("get_ardenimium_crafter", InventoryChangedCriterion.Conditions.items(TestModBlocks.ArdenimiumCrafter))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "get_ardenimium_crafter").toString());

        AdvancementEntry solar_stabilizer_and_nether_star_core = Advancement.Builder.create()
                .parent(ardenimium)
                .display(
                        TestModBlocks.Solar_Strabilizer,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("get_nether_star_core", InventoryChangedCriterion.Conditions.items(TestModBlocks.Nether_Star_Core))
                .criterion("get_solar_stabilizer", InventoryChangedCriterion.Conditions.items(TestModBlocks.Solar_Strabilizer))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "get_solar_stabilizer_and_nether_star_core").toString());

        AdvancementEntry ardenimium_armor = Advancement.Builder.create()
                .parent(ardenimium_crafter)
                .display(
                        TestModItems.Ardenimium_Chestplate,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("craft_ardenimium_helmet", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_Helmet))
                .criterion("craft_ardenimium_chestplate", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_Chestplate))
                .criterion("craft_ardenimium_leggings", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_Leggings))
                .criterion("craft_ardenimium_boots", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_Boots))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "get_ardenimium_armor").toString());

        AdvancementEntry get_ardenimium_gun_and_ardenimium_bullet = Advancement.Builder.create()
                .parent(ardenimium_crafter)
                .display(
                        TestModItems.Ardenimium_Gun,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("get_ardenimium_gun", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_Gun))
                .criterion("get_ardenimium_bullet", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_Bullet))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "get_ardenimium_gun_and_ardenimium_bullet").toString());

        AdvancementEntry ardenimium_tools = Advancement.Builder.create()
                .parent(ardenimium_crafter)
                .display(
                        TestModItems.Ardenimium_Sword,
                        Text.translatable("advancement.testmod.next.title"),
                        Text.translatable("advancement.testmod.next.description"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("craft_ardenimium_sword", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_Sword))
                .criterion("craft_ardenimium_axe", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_Axe))
                .criterion("craft_ardenimium_shovel", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_Shovel))
                .criterion("craft_ardenimium_pickaxe", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_Pickaxe))
                .criterion("craft_ardenimium_hoe", InventoryChangedCriterion.Conditions.items(TestModItems.Ardenimium_Hoe))
                .rewards(AdvancementRewards.Builder.experience(500))
                .build(consumer, new Identifier(Testmod.MOD_ID, "get_ardenimium_tools").toString());
    }
}