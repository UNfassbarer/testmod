package unfassbarer.testmod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import unfassbarer.testmod.block.custom.ArdenimiumLamp;

import java.util.List;

public class ArdenimiumLampEntity extends BlockEntity {
    public static final BlockEntityType<ArdenimiumLampEntity> TYPE = ModBlockEntities.ARDENIMIUM_LAMP_ENTITY;
    private static final double[][] PARTICLE_POSITIONS = {
            {0.2, 0.2, 0.2},
            {-0.2, 0.2, 0.2},
            {0.2, -0.2, 0.2},
            {-0.2, -0.2, 0.2},
            {0.2, 0.2, -0.2},
            {-0.2, 0.2, -0.2}
    };
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public ArdenimiumLampEntity(BlockPos pos, BlockState state) {
        super(TYPE, pos, state);
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

            if (!world.isClient) {
                world.playSound(null, pos, SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 0.05f, 0.05f);

                applyEffects(world, pos);
            }
        }
    }

    private static void applyEffects(World world, BlockPos pos) {
        if (!(world instanceof ServerWorld serverWorld)) return;
        double range = 80.0;
        long timeOfDay = serverWorld.getTimeOfDay() % 24000;
        boolean isNight = timeOfDay >= 13000 && timeOfDay <= 23000;

        if (isNight) {
            range *= 1.5;
        }

        Box box = new Box(pos).expand(range);
        List<PlayerEntity> players = serverWorld.getNonSpectatingEntities(PlayerEntity.class, box);

        for (PlayerEntity player : players) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 300, 0, true, true, true));
        }
    }

    public ItemStack getRenderStack() {
        return items.get(0);
    }
}