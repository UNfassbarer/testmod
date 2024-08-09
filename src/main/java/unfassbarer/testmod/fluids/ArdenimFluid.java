package unfassbarer.testmod.fluids;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import unfassbarer.testmod.Testmod;

public abstract class ArdenimFluid extends TestModFluid {
    @Override
    public Fluid getStill() {
        return Testmod.Still_Ardenim;
    }
    @Override
    public Fluid getFlowing() {
        return Testmod.Flowing_Ardenim;
    }
    @Override
    public Item getBucketItem() {
        return Testmod.Ardenim_Bucket;
    }
    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return Testmod.Ardenim_Fluid_Block.getDefaultState().with(Properties.LEVEL_15, FlowableFluid.getBlockStateLevel(fluidState));
    }
    public static class Flowing extends ArdenimFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }
        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }
        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }
    public static class Still extends ArdenimFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }
        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}