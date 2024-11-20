package unfassbarer.testmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import unfassbarer.testmod.block.entity.ArdenimiumLampEntity;
import unfassbarer.testmod.block.entity.ModBlockEntities;

public class ArdenimiumLamp extends BlockWithEntity {
    public static final BooleanProperty LIT = BooleanProperty.of("lit");
    public static final VoxelShape SHAPE = Block.createCuboidShape(5, 0, 5, 11, 14, 11);
    public static final MapCodec<ArdenimiumLamp> CODEC = ArdenimiumLamp.createCodec(ArdenimiumLamp::new);

    public ArdenimiumLamp(AbstractBlock.Settings settings) {
        super(settings.luminance(state -> state.get(LIT) ? 15 : 0));
        this.setDefaultState(this.stateManager.getDefaultState().with(LIT, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(LIT, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (!world.isClient) {
            boolean shouldBeLit = world.isReceivingRedstonePower(pos);
            if (state.get(LIT) != shouldBeLit) {
                world.setBlockState(pos, state.with(LIT, shouldBeLit), 3);
                if (world instanceof ServerWorld) {
                    world.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if (shouldBeLit) {
                        double centerX = pos.getX() + 0.5;
                        double centerY = pos.getY() + 0.5;
                        double centerZ = pos.getZ() + 0.5;
                        ((ServerWorld) world).spawnParticles(ParticleTypes.END_ROD, centerX, centerY, centerZ, 10, 0.2, 0.2, 0.2, 0.0);
                    }
                }
                world.updateNeighbors(pos, this);
            }
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(LIT) && !world.isReceivingRedstonePower(pos)) {
            world.setBlockState(pos, state.with(LIT, false), 3);
            world.updateNeighbors(pos, this);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ArdenimiumLampEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.ARDENIMIUM_LAMP_ENTITY, ArdenimiumLampEntity::tick);
    }
}