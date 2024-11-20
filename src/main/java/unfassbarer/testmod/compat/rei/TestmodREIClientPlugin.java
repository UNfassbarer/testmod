package unfassbarer.testmod.compat.rei;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.recipe.ArdenimiumCrafterRecipe;
import unfassbarer.testmod.recipe.PatternProviderRecipe;
import unfassbarer.testmod.screen.ArdenimiumCrafterScreen;
import unfassbarer.testmod.screen.PatternProviderScreen;

public class TestmodREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ArdenimiumCrafterCategory());
        registry.addWorkstations(ArdenimiumCrafterCategory.ARDENIMIUM_CRAFTING, EntryStacks.of(TestModBlocks.ArdenimiumCrafter));

        registry.add(new PatternProviderCategory());
        registry.addWorkstations(PatternProviderCategory.PATTERN_PROVIDING, EntryStacks.of(TestModBlocks.PatternProvider));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(ArdenimiumCrafterRecipe.class, ArdenimiumCrafterRecipe.Type.INSTANCE, ArdenimiumCrafterDisplay::new);
        registry.registerRecipeFiller(PatternProviderRecipe.class, PatternProviderRecipe.Type.INSTANCE, PatternProviderDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), ArdenimiumCrafterScreen.class, ArdenimiumCrafterCategory.ARDENIMIUM_CRAFTING);
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), PatternProviderScreen.class, PatternProviderCategory.PATTERN_PROVIDING);
    }
}