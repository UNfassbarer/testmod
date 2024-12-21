package unfassbarer.testmod.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
// import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import unfassbarer.testmod.fluids.ModFluids;
import unfassbarer.testmod.item.TestModItems;

public class NetherStarTerraformer {
    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            if (!world.isClient) {
                for (ItemEntity itemEntity : world.getEntitiesByType(EntityType.ITEM, item -> true)) {
                    BlockPos pos = itemEntity.getBlockPos();
                    if (world.getBlockState(pos).isOf(ModFluids.ARDENIM_WATER_BLOCK)) {
                        ItemStack stack = itemEntity.getStack();
                        if (stack.getItem() == Items.NETHER_STAR) {
                            world.playSound(
                                    null,
                                    pos,
                                    SoundEvents.BLOCK_BEACON_POWER_SELECT,
                                    SoundCategory.BLOCKS,
                                    1.0F,
                                    1.0F
                            );
                            ItemStack newItemStack = new ItemStack(TestModItems.Modified_Nether_Star);
                            itemEntity.kill();
                            ItemEntity newItemEntity = new ItemEntity(
                                    world,
                                    itemEntity.getX(),
                                    itemEntity.getY() - 0.5,
                                    itemEntity.getZ(),
                                    newItemStack
                            );
                            world.spawnEntity(newItemEntity);
                           /* for (int i = 0; i < 10; i++) {
                                world.addParticle(
                                        ParticleTypes.GLOW,
                                        newItemEntity.getX() + (world.random.nextDouble() - 0.5),
                                        newItemEntity.getY() + 0.5 + (world.random.nextDouble() * 0.5),
                                        newItemEntity.getZ() + (world.random.nextDouble() - 0.5),
                                        0.0,
                                        0.01 + (world.random.nextDouble() * 0.02),
                                        0.0
                                );
                            } */
                        }
                    }
                }
            }
        });
    }
}
