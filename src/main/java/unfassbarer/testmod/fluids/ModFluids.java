package unfassbarer.testmod.fluids;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
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
import unfassbarer.testmod.Testmod;

public class ModFluids {
     public static final FlowableFluid STILL_ARDENIM_WATER = Registry.register(Registries.FLUID,
            new Identifier(Testmod.MOD_ID, "ardenim_water"), new ArdenimWaterFluid.Still());
    public static final FlowableFluid FLOWING_ARDENIM_WATER = Registry.register(Registries.FLUID,
            new Identifier(Testmod.MOD_ID, "ardenim_soap_water"), new ArdenimWaterFluid.Flowing());

    public static final Block ARDENIM_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Testmod.MOD_ID,
            "ardenim_water_block"), new FluidBlock(ModFluids.STILL_ARDENIM_WATER, FabricBlockSettings.copyOf(Blocks.WATER)
            .replaceable().liquid()));
    public static final Item ARDENIM_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(Testmod.MOD_ID,
            "ardenim_bucket"), new BucketItem(ModFluids.STILL_ARDENIM_WATER,
            new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static void registerFluids() {
        Testmod.LOGGER.info("Registering Fluids for " + Testmod.MOD_ID);
    }
}
