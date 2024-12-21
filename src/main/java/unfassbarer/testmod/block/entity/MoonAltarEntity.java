package unfassbarer.testmod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import unfassbarer.testmod.recipe.PatternProviderRecipe;

import java.util.Optional;

public class MoonAltarEntity extends BlockEntity {
    private static final int INPUT_SLOT = 0;

    public MoonAltarEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MOON_ALTAR_ENTITY, pos, state);
    }


    private void craftItem() {
        Optional<RecipeEntry<PatternProviderRecipe>> recipe = getCurrentRecipe();
        this.removeStack(INPUT_SLOT, 1);
        this.removeStack(PATTERN_SLOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
    }

    public ItemStack getRenderStack() {
        return this.getStack(inventory).isEmpty() ? ItemStack.EMPTY : this.getStack(inventory);
    }

    public static void tick(World world, BlockPos pos, BlockState state, MoonAltarEntity blockEntity) {
        // Hier könnte Logik für Tick-basierte Aktualisierungen kommen (optional)
    }
}
