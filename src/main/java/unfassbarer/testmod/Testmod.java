package unfassbarer.testmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.block.entity.ModBlockEntities;
import unfassbarer.testmod.enchants.ModEnchantments;
import unfassbarer.testmod.entity.ModEntities;
import unfassbarer.testmod.entity.custom.ArdenimiumDragonEntity;
import unfassbarer.testmod.entity.custom.PorcupineEntity;
import unfassbarer.testmod.event.NetherStarTerraformer;
import unfassbarer.testmod.fluids.ModFluids;
import unfassbarer.testmod.item.ItemGroups;
import unfassbarer.testmod.item.TestModItems;
import unfassbarer.testmod.recipe.ModRecipes;
import unfassbarer.testmod.screen.ModScreenHandlers;
import unfassbarer.testmod.sounds.Sounds;
import unfassbarer.testmod.util.ModLootTableModifiers;
import unfassbarer.testmod.world.gen.ModWorldGeneration;

public class Testmod implements ModInitializer {
    public static final String MOD_ID = "testmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        ItemGroups.registerItemGroups();
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
        ModEnchantments.registerEnchantments();
        ModFluids.registerFluids();
        NetherStarTerraformer.register();
        FabricDefaultAttributeRegistry.register(unfassbarer.testmod.entity.ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
        FabricDefaultAttributeRegistry.register(unfassbarer.testmod.entity.ModEntities.ARDENIMIUM_DRAGON, ArdenimiumDragonEntity.createArdenimiumDragonAttributes());
    }
}