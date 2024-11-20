package unfassbarer.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import unfassbarer.testmod.item.TestModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(TestModItems.Ardenim_Helmet, TestModItems.Ardenim_Chestplate, TestModItems.Ardenim_Leggings, TestModItems.Ardenim_Boots)
                .add(TestModItems.Ardenimium_Helmet, TestModItems.Ardenimium_Chestplate, TestModItems.Ardenimium_Leggings, TestModItems.Ardenimium_Boots);
    }
}
