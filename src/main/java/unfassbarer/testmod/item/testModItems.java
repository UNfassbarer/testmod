package unfassbarer.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.block.testModBlocks;

public class testModItems {
    public static final Item Ardenim = registerItem("ardenim",
            new Item(new FabricItemSettings()));
    public static final Item raw_Ardenim = registerItem("raw_ardenim",
            new Item(new FabricItemSettings()));
    public static final Item Ardenim_apple = registerItem("ardenim_apple",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(6).alwaysEdible().meat().statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 160), 1).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 160, 2), 0.2f).statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 160), 1).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 160, 1), 0.3f).build())));

    public static final String MOD_ID = "testmod";

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Testmod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {

    }
    public static void registerModItems() {
        Testmod.LOGGER.info("Registering Mod Items for" + Testmod.MOD_ID);
        addItemsToItemGroup();
    }
}