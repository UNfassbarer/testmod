package unfassbarer.testmod.compat.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.recipe.RecipeEntry;
import unfassbarer.testmod.recipe.PatternProviderRecipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PatternProviderDisplay extends BasicDisplay {
    public PatternProviderDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public PatternProviderDisplay(RecipeEntry<PatternProviderRecipe> recipe) {
        super(getInputList(recipe.value()), List.of(EntryIngredient.of(EntryStacks.of(recipe.value().getResult(null)))));
    }

    private static List<EntryIngredient> getInputList(PatternProviderRecipe recipe) {
        if (recipe == null) return Collections.emptyList();
        List<EntryIngredient> list = new ArrayList<>();
        recipe.getIngredients().forEach(ingredient -> list.add(EntryIngredients.ofIngredient(ingredient)));
        return list;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return PatternProviderCategory.PATTERN_PROVIDING;
    }
}
