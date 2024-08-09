package unfassbarer.testmod.block.custom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class SolarStrabilizer extends Block {
    public static final VoxelShape SHAPE = VoxelShapes.cuboid(0.01, 0.01, 0.01, 0.99, 0.99, 0.99);
    public SolarStrabilizer(Settings settings) {
        super(settings);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}