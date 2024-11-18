package unfassbarer.testmod.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArdenimNeonBlock extends Block {

    public ArdenimNeonBlock(Settings settings) {
        super(settings);
    }

    public static Block Ardenim_Neon_Block =
            new ArdenimNeonBlock(FabricBlockSettings
                    .copy(Blocks.GLASS)
                    .sounds(BlockSoundGroup.GLASS)
                    .luminance((state) -> 15)
                    .strength(0.5f, 0.5f)
                    .emissiveLighting((state, world, pos) -> true)
                    .nonOpaque()
                    .slipperiness(0.9f));
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        applyEffect(world, entity);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        applyEffect(world, entity);
    }

    private void applyEffect(World world, Entity entity) {
        if (!world.isClient && entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 5, 3)); // 5 Sekunden, Stufe 2
        }
    }
}