package unfassbarer.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.block.custom.ArdenimNeonBlock;
import unfassbarer.testmod.item.TestModItems;

import java.util.List;

//ardenim (smelting)
public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ARDENIM_SMELTABLES = List.of(
            TestModBlocks.Ardenim_Ore,
            TestModItems.raw_Ardenim);
    private static final List<ItemConvertible> ARDENIM_NUGGET_SMELTABLES = List.of(
            TestModItems.Ardenim_Axe,
            TestModItems.Ardenim_Pickaxe,
            TestModItems.Ardenim_Shovel,
            TestModItems.Ardenim_Sword,
            TestModItems.Ardenim_Hoe,
            TestModItems.Ardenim_Helmet,
            TestModItems.Ardenim_Chestplate,
            TestModItems.Ardenim_Leggings,
            TestModItems.Ardenim_Boots);
    private static final List<ItemConvertible> SMOOTH_ARDENIM_SMELTABLES = List.of(
            TestModBlocks.Ardenim_Block);
    private static final List<ItemConvertible> ARDENIM_PILLAR_SMELTABLES = List.of(
            TestModBlocks.Ardenim_Block);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, ARDENIM_SMELTABLES, RecipeCategory.MISC, TestModItems.Ardenim,
                0.7f, 350, "ardenim");
        offerBlasting(exporter, ARDENIM_SMELTABLES, RecipeCategory.MISC, TestModItems.Ardenim,
                0.7f, 175, "ardenim");

        offerSmelting(exporter, ARDENIM_NUGGET_SMELTABLES, RecipeCategory.MISC, TestModItems.Ardenim_Nugget,
                0.1f, 350, "ardenim");
        offerBlasting(exporter, ARDENIM_NUGGET_SMELTABLES, RecipeCategory.MISC, TestModItems.Ardenim_Nugget,
                0.1f, 175, "ardenim");

        offerSmelting(exporter, SMOOTH_ARDENIM_SMELTABLES, RecipeCategory.MISC, TestModBlocks.Smooth_Ardenim_Block,
                0.1f, 350, "ardenim");
        offerBlasting(exporter, SMOOTH_ARDENIM_SMELTABLES, RecipeCategory.MISC, TestModBlocks.Smooth_Ardenim_Block,
                0.1f, 350, "ardenim");

        offerSmelting(exporter, ARDENIM_PILLAR_SMELTABLES, RecipeCategory.MISC, TestModBlocks.Ardenim_Pillar_Block,
                0.1f, 350, "ardenim");
        offerBlasting(exporter, ARDENIM_PILLAR_SMELTABLES, RecipeCategory.MISC, TestModBlocks.Ardenim_Pillar_Block,
                0.1f, 350, "ardenim");
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Ardenim_Pillar_Block, TestModBlocks.Ardenim_Block, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Smooth_Ardenim_Block, TestModBlocks.Ardenim_Block, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Ardenim_Brick_Block, TestModBlocks.Ardenim_Block, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Ardenim_Wall, TestModBlocks.Ardenim_Block, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Ardenim_Slab, TestModBlocks.Ardenim_Block, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Ardenim_Stairs, TestModBlocks.Ardenim_Block, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Ardenim_Brick_Slab, TestModBlocks.Ardenim_Block, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Ardenim_Brick_Stairs, TestModBlocks.Ardenim_Block, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Ardenim_Brick_Wall, TestModBlocks.Ardenim_Block, 2);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Ardenim_Brick_Wall, TestModBlocks.Ardenim_Brick_Block, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Ardenim_Brick_Slab, TestModBlocks.Ardenim_Brick_Block, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TestModBlocks.Ardenim_Brick_Stairs, TestModBlocks.Ardenim_Brick_Block, 1);
// Custom shapeless recipes
        addShapelessRecipes(exporter);
        //Nether Star Core
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Nether_Star_Core, 1)
                .pattern("GDG")
                .pattern("DND")
                .pattern("GDG")
                .input('D', Items.DIAMOND)
                .input('G', Items.GLOWSTONE_DUST)
                .input('N', Items.NETHER_STAR)
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Nether_Star_Core)));
        //Blank Pattern
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Blank_Pattern, 1)
                .pattern("RGR")
                .pattern("SAS")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('S', Blocks.STONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('A', TestModItems.Ardenimium_Casing)
                .criterion(hasItem(TestModItems.Ardenimium_Casing), conditionsFromItem(TestModItems.Ardenimium_Casing))
                .criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Blank_Pattern)));
        //Ardenimium Casing
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenimium_Casing, 1)
                .pattern("ICI")
                .pattern("CAC")
                .pattern("ICI")
                .input('C', Items.COAL)
                .input('I', Items.IRON_INGOT)
                .input('A', TestModItems.Ardenimium)
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(TestModItems.Ardenimium), conditionsFromItem(TestModItems.Ardenimium))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenimium_Casing)));
        //Solar Strabilizer
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Solar_Strabilizer, 1)
                .pattern("ABA")
                .pattern("BNB")
                .pattern("ABA")
                .input('N', TestModBlocks.Nether_Star_Core)
                .input('B', TestModBlocks.Ardenim_Glass)
                .input('A', TestModItems.Ardenimium_Casing)
                .criterion(hasItem(TestModItems.Ardenimium_Casing), conditionsFromItem(TestModItems.Ardenimium_Casing))
                .criterion(hasItem(TestModBlocks.Ardenim_Glass), conditionsFromItem(TestModBlocks.Ardenim_Glass))
                .criterion(hasItem(TestModBlocks.Nether_Star_Core), conditionsFromItem(TestModBlocks.Nether_Star_Core))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Solar_Strabilizer)));
        //Ardenimium Crafter
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.ArdenimiumCrafter, 1)
                .pattern("ABA")
                .pattern("BNB")
                .pattern("ABA")
                .input('N', TestModBlocks.Nether_Star_Core)
                .input('B', TestModItems.Ardenimium)
                .input('A', TestModItems.Ardenimium_Casing)
                .criterion(hasItem(TestModItems.Ardenimium_Casing), conditionsFromItem(TestModItems.Ardenimium_Casing))
                .criterion(hasItem(TestModItems.Ardenimium), conditionsFromItem(TestModItems.Ardenimium))
                .criterion(hasItem(TestModBlocks.Nether_Star_Core), conditionsFromItem(TestModBlocks.Nether_Star_Core))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.ArdenimiumCrafter)));
        //Pattern Provider
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.PatternProvider, 1)
                .pattern("ABA")
                .pattern("BPB")
                .pattern("ABA")
                .input('P', TestModItems.Blank_Pattern)
                .input('B', TestModItems.Ardenimium)
                .input('A', TestModItems.Ardenimium_Casing)
                .criterion(hasItem(TestModItems.Ardenimium_Casing), conditionsFromItem(TestModItems.Ardenimium_Casing))
                .criterion(hasItem(TestModItems.Ardenimium), conditionsFromItem(TestModItems.Ardenimium))
                .criterion(hasItem(TestModItems.Blank_Pattern), conditionsFromItem(TestModItems.Blank_Pattern))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.PatternProvider)));
        //ardenim Block
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Block, 1)
                .pattern("AA")
                .pattern("AA")
                .input('A', TestModItems.Ardenim)
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Block)));
        //ardenim Helmet
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim_Helmet, 1)
                .pattern("AAA")
                .pattern("ARA")
                .input('A', TestModItems.Ardenim)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim_Helmet)));
        //ardenim Chestplate
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim_Chestplate, 1)
                .pattern("ARA")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', TestModItems.Ardenim)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim_Chestplate)));
        //ardenim Leggins
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim_Leggings, 1)
                .pattern("AAA")
                .pattern("ARA")
                .pattern("A A")
                .input('A', TestModItems.Ardenim)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim_Leggings)));
        //ardenim Boots
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim_Boots, 1)
                .pattern("ARA")
                .pattern("A A")
                .input('A', TestModItems.Ardenim)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim_Boots)));
        //raw ardenim Block
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Raw_Ardenim_Block, 1)
                .pattern("AA")
                .pattern("AA")
                .input('A', TestModItems.raw_Ardenim)
                .criterion(hasItem(TestModItems.raw_Ardenim), conditionsFromItem(TestModItems.raw_Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Raw_Ardenim_Block)));
        //ardenim Brick Block
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Brick_Block, 4)
                .pattern("AA")
                .pattern("AA")
                .input('A', TestModBlocks.Ardenim_Block)
                .criterion(hasItem(TestModBlocks.Ardenim_Block), conditionsFromItem(TestModBlocks.Ardenim_Block))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Brick_Block)));
        //ardenim Apple
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim_apple, 1)
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .input('S', TestModItems.Ardenim_Nugget)
                .input('A', Items.APPLE)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(TestModItems.Ardenim_Nugget), conditionsFromItem(TestModItems.Ardenim_Nugget))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim_apple)));
        //ardenimium Apple
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenimium_apple, 1)
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .input('S', TestModItems.Ardenimium_Nugget)
                .input('A', Items.APPLE)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(TestModItems.Ardenimium_Nugget), conditionsFromItem(TestModItems.Ardenimium_Nugget))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenimium_apple)));
        //Ardenimium
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenimium, 1)
                .pattern("IAI")
                .pattern("ANA")
                .pattern("IAI")
                .input('A', TestModItems.Ardenim)
                .input('N', Items.NETHERITE_INGOT)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenimium)));
        //ardenim Glass
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Glass, 4)
                .pattern(" A ")
                .pattern("AGA")
                .pattern(" A ")
                .input('A', TestModItems.Ardenim)
                .input('G', Items.GLASS)
                .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Glass)));
        //ardenim Glass Pane
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Glass_Pane, 8)
                .pattern("GGG")
                .pattern("GAG")
                .pattern("GGG")
                .input('A', TestModItems.Ardenim)
                .input('G', Items.GLASS_PANE)
                .criterion(hasItem(Items.GLASS_PANE), conditionsFromItem(Items.GLASS_PANE))
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Glass_Pane)));
        //ardenim Sword
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim_Sword, 1)
                .pattern("A")
                .pattern("A")
                .pattern("S")
                .input('S', Items.STICK)
                .input('A', TestModItems.Ardenim)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim_Sword)));
        //ardenim Axe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim_Axe, 1)
                .pattern(" AA")
                .pattern(" SA")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('A', TestModItems.Ardenim)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim_Axe)));
        //ardenim Hoe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim_Hoe, 1)
                .pattern(" AA")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('A', TestModItems.Ardenim)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim_Hoe)));
        //ardenim Shovel
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim_Shovel, 1)
                .pattern(" A ")
                .pattern("ASA")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('A', TestModItems.Ardenim)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim_Shovel)));
        //ardenim Pickaxe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim_Pickaxe, 1)
                .pattern("AAA")
                .pattern("ASA")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('A', TestModItems.Ardenim)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim_Pickaxe)));
        //ardenim Neon Block
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ArdenimNeonBlock.Ardenim_Neon_Block, 1)
                .pattern(" A ")
                .pattern("AGA")
                .pattern(" A ")
                .input('G', Blocks.GLOWSTONE)
                .input('A', TestModBlocks.Ardenim_Glass)
                .criterion(hasItem(Blocks.GLOWSTONE), conditionsFromItem(Blocks.GLOWSTONE))
                .criterion(hasItem(TestModBlocks.Ardenim_Glass), conditionsFromItem(TestModBlocks.Ardenim_Glass))
                .offerTo(exporter, new Identifier(getRecipeName(ArdenimNeonBlock.Ardenim_Neon_Block)));
        //ardenim Slab
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Slab, 6)
                .pattern("AAA")
                .input('A', TestModBlocks.Ardenim_Block)
                .criterion(hasItem(TestModBlocks.Ardenim_Block), conditionsFromItem(TestModBlocks.Ardenim_Block))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Slab)));
        //ardenim Stairs
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Stairs, 4)
                .pattern("  A")
                .pattern(" AA")
                .pattern("AAA")
                .input('A', TestModBlocks.Ardenim_Block)
                .criterion(hasItem(TestModBlocks.Ardenim_Block), conditionsFromItem(TestModBlocks.Ardenim_Block))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Stairs)));
        //ardenim Brick Slab
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Brick_Slab, 6)
                .pattern("AAA")
                .input('A', TestModBlocks.Ardenim_Brick_Block)
                .criterion(hasItem(TestModBlocks.Ardenim_Brick_Block), conditionsFromItem(TestModBlocks.Ardenim_Brick_Block))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Brick_Slab)));
        //ardenim Brick Stairs
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Brick_Stairs, 4)
                .pattern("  A")
                .pattern(" AA")
                .pattern("AAA")
                .input('A', TestModBlocks.Ardenim_Brick_Block)
                .criterion(hasItem(TestModBlocks.Ardenim_Brick_Block), conditionsFromItem(TestModBlocks.Ardenim_Brick_Block))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Brick_Stairs)));
        //Ardenim Pressure Plate
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Pressure_Plate, 1)
                .pattern(" AA")
                .input('A', TestModItems.Ardenim)
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Pressure_Plate)));
        //ardenim Ardenim Fence
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Fence, 3)
                .pattern("ASA")
                .pattern("ASA")
                .input('A', TestModBlocks.Ardenim_Block)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TestModBlocks.Ardenim_Block), conditionsFromItem(TestModBlocks.Ardenim_Block))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Fence)));
        //Ardenim Fence Gate
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Fence_Gate, 1)
                .pattern("SAS")
                .pattern("SAS")
                .input('A', TestModBlocks.Ardenim_Block)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(TestModBlocks.Ardenim_Block), conditionsFromItem(TestModBlocks.Ardenim_Block))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Fence_Gate)));
        //Ardenim Wall
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Wall, 6)
                .pattern("AAA")
                .pattern("AAA")
                .input('A', TestModBlocks.Ardenim_Block)
                .criterion(hasItem(TestModBlocks.Ardenim_Block), conditionsFromItem(TestModBlocks.Ardenim_Block))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Wall)));
        //Ardenim Brick Wall
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Brick_Wall, 6)
                .pattern("AAA")
                .pattern("AAA")
                .input('A', TestModBlocks.Ardenim_Brick_Block)
                .criterion(hasItem(TestModBlocks.Ardenim_Brick_Block), conditionsFromItem(TestModBlocks.Ardenim_Brick_Block))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Brick_Wall)));
        //Ardenim Door
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Door, 3)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .input('A', TestModItems.Ardenim)
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Door)));
        //Ardenim Trap Door
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Trapdoor, 2)
                .pattern("AA")
                .pattern("AA")
                .input('A', TestModItems.Ardenim)
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Trapdoor)));
        //Ardenimium Bullet
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenimium_Bullet, 4)
                .pattern("IAI")
                .pattern("III")
                .input('A', TestModItems.Ardenimium_Nugget)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(TestModItems.Ardenim_Nugget), conditionsFromItem(TestModItems.Ardenim_Nugget))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenimium_Bullet)));
    }

    private void addShapelessRecipes(RecipeExporter exporter) {
        // Ardenim from Nuggets
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim, 1)
                .input(TestModItems.Ardenim_Nugget, 9)
                .criterion(hasItem(TestModItems.Ardenim_Nugget), conditionsFromItem(TestModItems.Ardenim_Nugget))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim) + "_from_nuggets"));
        // Ardenimium from Nuggets
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenimium, 1)
                .input(TestModItems.Ardenimium_Nugget, 9)
                .criterion(hasItem(TestModItems.Ardenimium_Nugget), conditionsFromItem(TestModItems.Ardenimium_Nugget))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenimium) + "_from_nuggets"));
        // Ardenim Nuggets from Ardenim
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenim_Nugget, 9)
                .input(TestModItems.Ardenim)
                .criterion(hasItem(TestModItems.Ardenim), conditionsFromItem(TestModItems.Ardenim))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenim_Nugget) + "_from_ardenim"));
        // Ardenimium Nuggets from Ardenimium
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, TestModItems.Ardenimium_Nugget, 9)
                .input(TestModItems.Ardenimium)
                .criterion(hasItem(TestModItems.Ardenimium), conditionsFromItem(TestModItems.Ardenimium))
                .offerTo(exporter, new Identifier(getRecipeName(TestModItems.Ardenimium_Nugget) + "_from_ardenim"));
        // Ardenim Button from Ardenim Block
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, TestModBlocks.Ardenim_Button, 1)
                .input(TestModBlocks.Ardenim_Block)
                .criterion(hasItem(TestModBlocks.Ardenim_Block), conditionsFromItem(TestModBlocks.Ardenim_Block))
                .offerTo(exporter, new Identifier(getRecipeName(TestModBlocks.Ardenim_Button) + "_from_ardenim"));
    }
}