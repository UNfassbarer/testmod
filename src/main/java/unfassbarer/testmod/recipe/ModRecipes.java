package unfassbarer.testmod.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.TestmodInitializer;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(TestmodInitializer.MOD_ID, ArdenimiumCrafterRecipe.Serializer.ID),
                ArdenimiumCrafterRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(TestmodInitializer.MOD_ID, ArdenimiumCrafterRecipe.Type.ID),
                ArdenimiumCrafterRecipe.Type.INSTANCE);
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(TestmodInitializer.MOD_ID, PatternProviderRecipe.Serializer.ID),
                PatternProviderRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(TestmodInitializer.MOD_ID, PatternProviderRecipe.Type.ID),
                PatternProviderRecipe.Type.INSTANCE);
    }
}