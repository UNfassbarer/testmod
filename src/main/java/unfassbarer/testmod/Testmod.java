package unfassbarer.testmod;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.block.entity.ModBlockEntities;
import unfassbarer.testmod.entity.ModEntities;
import unfassbarer.testmod.entity.custom.ArdenimiumDragonEntity;
import unfassbarer.testmod.entity.custom.PorcupineEntity;
import unfassbarer.testmod.fluids.ArdenimFluid;
import unfassbarer.testmod.item.ItemGroup;
import unfassbarer.testmod.item.TestModItems;
import unfassbarer.testmod.recipe.ModRecipes;
import unfassbarer.testmod.screen.ModScreenHandlers;
import unfassbarer.testmod.sounds.Sounds;
import unfassbarer.testmod.util.ModLootTableModifiers;
import unfassbarer.testmod.world.gen.ModWorldGeneration;

public class Testmod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static FlowableFluid Still_Ardenim;
	public static FlowableFluid Flowing_Ardenim;
	public static Item Ardenim_Bucket;
	public static Block Ardenim_Fluid_Block;
	@Override
	public void onInitialize() {
		ItemGroup.registerItemGroups();
		TestModItems.registerModItems();
		TestModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipes();
		ModEntities.registerModEntities();
		unfassbarer.testmod.entity.ModEntities.registerModEntities();
		Sounds.registerSounds();
		ModWorldGeneration.generateModWorldGen();
		Still_Ardenim = Registry.register(Registries.FLUID, new Identifier(MOD_ID, "still_ardenim"), new ArdenimFluid.Still());
		Flowing_Ardenim = Registry.register(Registries.FLUID, new Identifier(MOD_ID, "flowing_ardenim"), new ArdenimFluid.Flowing());
		Ardenim_Bucket = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ardenim_bucket"), new BucketItem(Still_Ardenim, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
		Ardenim_Fluid_Block = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ardenim_fluid_block"), new FluidBlock(Still_Ardenim, FabricBlockSettings.copy(Blocks.WATER)) {});
		FabricDefaultAttributeRegistry.register(unfassbarer.testmod.entity.ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
		FabricDefaultAttributeRegistry.register(unfassbarer.testmod.entity.ModEntities.ARDENIMIUM_DRAGON, ArdenimiumDragonEntity.createArdenimiumDragonAttributes());
	}
}