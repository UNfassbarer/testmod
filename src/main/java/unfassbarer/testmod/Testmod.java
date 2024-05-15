package unfassbarer.testmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unfassbarer.testmod.block.testModBlocks;
import unfassbarer.testmod.item.ModItemGroup;
import unfassbarer.testmod.item.testModItems;
import unfassbarer.testmod.mixin.ExampleMixin;

public class Testmod implements ModInitializer {
	public static final String MOD_ID;
    static {
        MOD_ID = "testmod";
    }
    public static final Logger LOGGER = LoggerFactory.getLogger("testmod");
	@Override
	public void onInitialize() {
		// Item category
		ModItemGroup.registerItemGroups();

		//register Items
		testModItems.registerModItems();

		//register Blocks
		testModBlocks.registerModBlocks();

	}
}