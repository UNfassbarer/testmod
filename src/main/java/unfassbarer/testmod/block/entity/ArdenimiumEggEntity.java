package unfassbarer.testmod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.joml.Vector3f;
import unfassbarer.testmod.entity.ModEntities;
import unfassbarer.testmod.entity.custom.ArdenimiumDragonEntity;

import java.util.Random;

public class ArdenimiumEggEntity extends BlockEntity implements Inventory {
    public static final BlockEntityType<ArdenimiumEggEntity> TYPE = ModBlockEntities.ARDENIMIUM_EGG_ENTITY;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(9, ItemStack.EMPTY);
    private final Random random = new Random();
    private int tickCounter = 0;
    private int soundTickCounter = 0;
    private int countdownTimer = -1;

    public ArdenimiumEggEntity(BlockPos pos, BlockState state) {
        super(TYPE, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ArdenimiumEggEntity entity) {
        if (world.isClient) return;
        if (isMagmaBlockBelow(world, pos)) {
            if (entity.countdownTimer == -1) {
                entity.countdownTimer = entity.random.nextInt(21) + 20 * 20;
            }
            spawnParticlesAroundBlock(world, pos);
            spawnCentralParticles(world, pos);
            entity.tickCounter++;
            entity.soundTickCounter++;
            if (entity.tickCounter >= 3) {
                playFirstSound(world, pos);
                entity.tickCounter = 0;
            }
            if (entity.soundTickCounter >= 30) {
                playRandomTurtleSound(world, pos, entity.random);
                entity.soundTickCounter = 0;
            }
            if (entity.countdownTimer > 0) {
                entity.countdownTimer--;
            } else if (entity.countdownTimer == 0) {
                // spawnDragon(world, pos);
                displayComingSoonMessage(world, pos);
                removeEgg(world, pos);
                entity.countdownTimer = -1;
            }
        } else {
            entity.countdownTimer = -1;
        }
    }

    private static boolean isMagmaBlockBelow(World world, BlockPos pos) {
        BlockState belowState = world.getBlockState(pos.down());
        return belowState.isOf(Blocks.MAGMA_BLOCK);
    }

    private static void spawnParticlesAroundBlock(World world, BlockPos pos) {
        if (!(world instanceof ServerWorld serverWorld)) return;

        double centerX = pos.getX() + 0.5;
        double centerY = pos.getY() + 0.5;
        double centerZ = pos.getZ() + 0.5;
        double radius = 0.5; // Radius um den Block herum
        Vector3f yellow = new Vector3f(1.0F, 1.0F, 0.0F); // Gelb
        DustParticleEffect particle = new DustParticleEffect(yellow, 1.0F);

        for (double angle = 0; angle < 2 * Math.PI; angle += Math.PI / 4) {
            double xOffset = radius * Math.cos(angle);
            double zOffset = radius * Math.sin(angle);
            double x = centerX + xOffset;
            double z = centerZ + zOffset;
            serverWorld.spawnParticles(particle, x, centerY, z, 1, 0.0, 0.0, 0.0, 0.0);
        }
    }

    private static void spawnCentralParticles(World world, BlockPos pos) {
        if (!(world instanceof ServerWorld serverWorld)) return;

        double centerX = pos.getX() + 0.5;
        double centerY = pos.getY() + 0.5;
        double centerZ = pos.getZ() + 0.5;
        Vector3f yellow = new Vector3f(1.0F, 1.0F, 0.0F);
        DustParticleEffect particle = new DustParticleEffect(yellow, 1.0F);

        serverWorld.spawnParticles(particle, centerX, centerY, centerZ, 5, 0.2, 0.2, 0.2, 0.0);
    }

    private static void playFirstSound(World world, BlockPos pos) {
        if (world instanceof ServerWorld) {
            world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 1.0F);
        }
    }

    private static void playRandomTurtleSound(World world, BlockPos pos, Random random) {
        if (world instanceof ServerWorld) {
            SoundCategory category = SoundCategory.BLOCKS;
            float volume = 1.0F;
            float pitch = 1.0F;

            switch (random.nextInt(3)) {
                case 0 -> world.playSound(null, pos, SoundEvents.ENTITY_TURTLE_EGG_BREAK, category, volume, pitch);
                case 1 -> world.playSound(null, pos, SoundEvents.ENTITY_TURTLE_EGG_CRACK, category, volume, pitch);
                case 2 -> world.playSound(null, pos, SoundEvents.ENTITY_TURTLE_EGG_HATCH, category, volume, pitch);
            }
        }
    }

    private static void removeEgg(World world, BlockPos pos) {
        world.removeBlock(pos, false);

    }

    private static void spawnDragon(World world, BlockPos pos) {
        ArdenimiumDragonEntity ardenimium_dragon = new ArdenimiumDragonEntity(ModEntities.ARDENIMIUM_DRAGON, world);
        ardenimium_dragon.setBaby(true);
        ardenimium_dragon.refreshPositionAndAngles(pos.getX() + 1, pos.getY(), pos.getZ() + 0.5, world.random.nextFloat() * 360F, 0);
        world.spawnEntity(ardenimium_dragon);
    }

    private static void displayComingSoonMessage(World world, BlockPos pos) {
        if (!(world instanceof ServerWorld serverWorld)) return;

        serverWorld.getPlayers(player -> player.squaredDistanceTo(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) < 164)
                .forEach(player -> player.sendMessage(Text.keybind("Coming Soon...").formatted(Formatting.GOLD), true));
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : items) {
            if (!itemStack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return items.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int count) {
        ItemStack stack = items.get(slot);
        if (stack.isEmpty()) {
            return ItemStack.EMPTY;
        } else {
            return stack.split(count);
        }
    }

    @Override
    public ItemStack removeStack(int slot) {
        return items.remove(slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        items.set(slot, stack);
    }

    @Override
    public void markDirty() {
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return world != null && pos.isWithinDistance(player.getBlockPos(), 8.0);
    }

    @Override
    public void clear() {
        items.clear();
    }
}