package unfassbarer.testmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class Cutter extends BlockWithEntity implements BlockEntityProvider {
    public Cutter(Settings settings) {
        super(settings);
    }
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }
    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}