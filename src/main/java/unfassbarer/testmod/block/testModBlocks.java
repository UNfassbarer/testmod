package unfassbarer.testmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;

public class testModBlocks {

    public static final Block Ardenim_Block = registerBlock("ardenim_block",
            new Block(FabricBlockSettings.create().strength(4)));
    public static final Block Raw_Ardenim_Block = registerBlock("raw_ardenim_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Testmod.MOD_ID, name), block);
    }


    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Testmod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Testmod.LOGGER.info("Registering Mod Blocks for" + Testmod.MOD_ID);
    }
}
