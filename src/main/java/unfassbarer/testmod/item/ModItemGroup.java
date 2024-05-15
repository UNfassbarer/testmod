package unfassbarer.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.block.testModBlocks;

import static unfassbarer.testmod.item.testModItems.MOD_ID;

public class ModItemGroup {
    static ItemGroup Ardenim;
    public static final RegistryKey<ItemGroup> ARDENIM = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "group"));
    public static void registerItemGroups() {
        Ardenim = FabricItemGroup.builder()
                .displayName(Text.literal(MOD_ID))
                .icon(() -> new ItemStack(testModItems.raw_Ardenim)).entries(((displayContext, entries) -> {
                    entries.add(testModItems.Ardenim);
                    entries.add(testModBlocks.Ardenim_Block);
                    entries.add(testModItems.Ardenim_apple);
                    entries.add(testModItems.raw_Ardenim);

                }))
                .build();
        Registry.register(Registries.ITEM_GROUP,ARDENIM, Ardenim);
    }
}