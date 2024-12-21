package unfassbarer.testmod.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import unfassbarer.testmod.fluids.ModFluids;
import unfassbarer.testmod.item.TestModItems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NetherStarTerraformer {
    private static final Map<ItemEntity, Integer> delayMap = new HashMap<>();

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            if (!world.isClient) {
                ServerWorld serverWorld = (ServerWorld) world;

                // Verzögerte Items verarbeiten
                Iterator<Map.Entry<ItemEntity, Integer>> iterator = delayMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<ItemEntity, Integer> entry = iterator.next();
                    ItemEntity originalEntity = entry.getKey();
                    int ticksLeft = entry.getValue() - 1;

                    if (ticksLeft <= 0) {
                        // Neues Item spawnen
                        ItemStack newItemStack = new ItemStack(TestModItems.Modified_Nether_Star);
                        Vec3d spawnPos = originalEntity.getPos();
                        ItemEntity newItemEntity = new ItemEntity(
                                serverWorld,
                                spawnPos.x,
                                spawnPos.y,
                                spawnPos.z,
                                newItemStack
                        );
                        serverWorld.spawnEntity(newItemEntity);
                        iterator.remove(); // Verzögerung entfernen
                    } else {
                        entry.setValue(ticksLeft); // Verzögerung aktualisieren
                    }
                }

                // Neue Nethersterne verarbeiten
                for (ItemEntity itemEntity : world.getEntitiesByType(EntityType.ITEM, item -> true)) {
                    BlockPos pos = itemEntity.getBlockPos();
                    if (world.getBlockState(pos).isOf(ModFluids.ARDENIM_WATER_BLOCK)) {
                        ItemStack stack = itemEntity.getStack();
                        if (stack.getItem() == Items.NETHER_STAR && !delayMap.containsKey(itemEntity)) {
                            delayMap.put(itemEntity, 20); // Verzögerung von 20 Ticks hinzufügen
                            itemEntity.kill(); // Altes Item entfernen
                        }
                    }
                }
            }
        });
    }
}
