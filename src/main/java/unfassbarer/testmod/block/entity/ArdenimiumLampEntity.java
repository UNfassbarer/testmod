package unfassbarer.testmod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.particle.ParticleTypes;
import unfassbarer.testmod.block.custom.ArdenimiumLamp;

public class ArdenimiumLampEntity extends BlockEntity{
    public static final BlockEntityType<ArdenimiumLampEntity> TYPE = ModBlockEntities.ARDENIMIUM_LAMP_ENTITY;
    private static final double[][] PARTICLE_POSITIONS = {
            {0.2, 0.2, 0.2},
            {-0.2, 0.2, 0.2},
            {0.2, -0.2, 0.2},
            {-0.2, -0.2, 0.2},
            {0.2, 0.2, -0.2},
            {-0.2, 0.2, -0.2}
    };
    public ArdenimiumLampEntity(BlockPos pos, BlockState state) {
        super(TYPE, pos, state);
    }
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(9, ItemStack.EMPTY);
    public ItemStack getRenderStack() {
        return items.get(0);
    }
    public static void tick(World world, BlockPos pos, BlockState state, ArdenimiumLampEntity entity) {
        if (state.get(ArdenimiumLamp.LIT)) {
            for (double[] position : PARTICLE_POSITIONS) {
                double offsetX = position[0];
                double offsetY = position[1];
                double offsetZ = position[2];
                double particleX = pos.getX() + 0.5 + offsetX;
                double particleY = pos.getY() + 0.5 + offsetY;
                double particleZ = pos.getZ() + 0.5 + offsetZ;
                world.addParticle(ParticleTypes.GLOW, particleX, particleY, particleZ, 0.0, 0.01, 0.0);
            }
        }
    }
}