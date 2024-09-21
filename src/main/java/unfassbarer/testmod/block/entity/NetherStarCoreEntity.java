package unfassbarer.testmod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.sounds.Sounds;

import java.util.List;

public class NetherStarCoreEntity extends BlockEntity implements Inventory {
    public static final BlockEntityType<NetherStarCoreEntity> TYPE = ModBlockEntities.NETHER_STAR_CORE_ENTITY;
    private static double spiralOffset = 0.0; // Offset for the spiral animation

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public NetherStarCoreEntity(BlockPos pos, BlockState state) {
        super(TYPE, pos, state);
    }

    // Getter for the ItemStack to be rendered
    public ItemStack getRenderStack() {
        return items.get(0); // Assume the first slot contains the item to render
    }

    public static void tick(World world, BlockPos pos, BlockState state, NetherStarCoreEntity entity) {
        if (world.isClient) return;
        applyEffects(world, pos);
        spawnParticleSpiral(world, pos);
        spiralOffset += 0.1; // Increment the offset to create the moving effect
    }

    private static void spawnParticleSpiral(World world, BlockPos pos) {
        if (!(world instanceof ServerWorld serverWorld)) return;
        long timeOfDay = serverWorld.getTimeOfDay();
        boolean isNight = timeOfDay >= 13000 && timeOfDay <= 23000;
        if (isNight && world.getBlockState(pos.down(3)).isOf(TestModBlocks.Solar_Strabilizer)) {
            double radius = 0.75; // Radius der Partikelspirale
            double heightIncrement = 0.1; // Erhöhung der Höhe für die Spirale
            double angleIncrement = Math.PI / 3; // Erhöhung des Winkels für die Rotation
            double spiralHeight = 2.5; // Gesamthöhe der Spirale
            int particleCount = (int) (spiralHeight / heightIncrement); // Anzahl der Partikel für die gesamte Höhe

            // Spielt nur einmal pro Spiralhöhe einen Sound ab
            boolean playSound = false;
            for (int i = 0; i < particleCount; i++) {
                double angle = (i * angleIncrement) + spiralOffset;
                double xOffset = radius * Math.cos(angle);
                double zOffset = radius * Math.sin(angle);
                double yOffset = (heightIncrement * i) % spiralHeight; // Modulo for looping height
                double x = pos.getX() + 0.5 + xOffset;
                double y = pos.getY() - 0.75 + yOffset;
                double z = pos.getZ() + 0.5 + zOffset;

                if (i % (particleCount / 2.5) == 0) { // Spielt den Sound nur alle paar Partikel ab
                    playSound = true;
                }

                serverWorld.spawnParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 1, 0.0, 0.0, 0.0, 0.0);
            }

            if (playSound) {
                serverWorld.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, Sounds.NETHER_STAR_CORE_1, SoundCategory.BLOCKS, 0.3f, 1f);
                serverWorld.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, Sounds.NETHER_STAR_CORE_2, SoundCategory.BLOCKS, 0.3f, 1f);
            }
        }
    }
    private static void applyEffects(World world, BlockPos pos) {
        if (!(world instanceof ServerWorld serverWorld)) return;
        long timeOfDay = serverWorld.getTimeOfDay();
        boolean isNight = timeOfDay >= 13000 && timeOfDay <= 23000;
        if (isNight && world.getBlockState(pos.down(3)).isOf(TestModBlocks.Solar_Strabilizer)) {
            double range = 32;
            Box box = new Box(pos).expand(range).stretch(0.0, serverWorld.getHeight(), 0.0);
            List<PlayerEntity> players = serverWorld.getNonSpectatingEntities(PlayerEntity.class, box);
            for (PlayerEntity player : players) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 0, true, true, true));
            }
        }
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
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeStack(int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        items.set(slot, stack);
    }

    @Override
    public void markDirty() {
        // Optional: custom logic for when the inventory is marked dirty
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        items.clear();
    }
}
