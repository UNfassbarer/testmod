package unfassbarer.testmod.tooltip;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.item.TestModItems;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.minecraft.item.Item.fromBlock;

public class ModTooltipManager implements ClientModInitializer {
    private static final Map<Item, String> ITEM_TOOLTIP = new HashMap<>();
    static {
        ITEM_TOOLTIP.put(TestModItems.Ardenimium_Gun, "seems that here is some ammo required ... ");
        ITEM_TOOLTIP.put(TestModItems.Ardenim_apple, "Another apple ?");
        ITEM_TOOLTIP.put(TestModItems.Ardenimium_apple, "Wow, better than the Enchanted Golden Apple ?");
        ITEM_TOOLTIP.put(fromBlock(TestModBlocks.Ardenimium_Egg), "It likes it warm and cuddly");
        ITEM_TOOLTIP.put(fromBlock(TestModBlocks.Nether_Star_Core), "Needs to be placed 2 blocks above the Solar Stabilizer");
        ITEM_TOOLTIP.put(fromBlock(TestModBlocks.Ardenim_Ore), "Found only in the End!");
        ITEM_TOOLTIP.put(fromBlock(TestModBlocks.Ardenim_Egg_Ore), "Maybe you will be able to free a secret?");
        ITEM_TOOLTIP.put(fromBlock(TestModBlocks.Solar_Strabilizer), "Use in combination with a star to control the night");
        ITEM_TOOLTIP.put(fromBlock(TestModBlocks.ArdenimiumCrafter), "Better crafting to create powerful Items");
        ITEM_TOOLTIP.put(fromBlock(TestModBlocks.PatternProvider), "Craft patterns for your tools");
    }
    @Override
    public void onInitializeClient() {
        registerTooltips();
    }
    public static void registerTooltips() {
        ItemTooltipCallback.EVENT.register((stack, context, lines) -> {
            addCustomTooltip(stack.getItem(), lines);
        });
    }
    private static void addCustomTooltip(Item item, List<Text> tooltip) {
        if (ITEM_TOOLTIP.containsKey(item)) {
            String tooltipText = ITEM_TOOLTIP.get(item);
            tooltip.add(Text.literal(tooltipText).formatted(Formatting.GRAY));
        }
    }
}