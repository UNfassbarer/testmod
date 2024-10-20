package unfassbarer.testmod.block.entity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.block.entity.ArdenimiumLampEntity;

public class ArdenimiumLampEntityRenderer implements BlockEntityRenderer<ArdenimiumLampEntity> {
    private static final float DAY_ROTATION_SPEED = 2.0f;
    private static final float NIGHT_ROTATION_SPEED = 20.0f;
    private static final int SEA_LANTERN_COUNT = 8; // Anzahl der Sea Lanterns
    private static final double DEGREE_INCREMENT = 360.0 / SEA_LANTERN_COUNT; // Gradinkrement zwischen den Lanterns

    public ArdenimiumLampEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(ArdenimiumLampEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack netherStarStack = entity.getRenderStack().isEmpty() ? new ItemStack(Items.NETHER_STAR) : entity.getRenderStack();
        ItemStack seaLanternStack = new ItemStack(TestModBlocks.Ardenim_Glass);

        World world = entity.getWorld();
        long time = world.getTime();
        BlockPos pos = entity.getPos();
        // Überprüfen, ob ein Redstone-Signal anliegt
        boolean isPowered = world.isReceivingRedstonePower(pos);
        // Berechne die Rotationsgeschwindigkeit nur, wenn das Redstone-Signal anliegt
        float rotationSpeed = 0;
        float rotation = 0;
        if (isPowered) {
            rotationSpeed = getRotationSpeed(world, pos);
            rotation = ((time + tickDelta) * rotationSpeed) % 360;

            // Render den Nether Star in der Mitte, nur wenn Redstone aktiv ist
            matrices.push();
            matrices.translate(0.475f, 0.8f, 0.5075f); // Position leicht angepasst
            matrices.scale(0.1f, 0.1f, 0.1f); // Skalierung des Nether Stars
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation)); // Rotation um die Y-Achse
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90)); // Optionale Z-Achsen-Rotation
            itemRenderer.renderItem(netherStarStack, ModelTransformationMode.GUI, getLightLevel(world, pos), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, world, 1);
            matrices.pop();

            // Render Sea Lanterns nur, wenn das Redstone-Signal anliegt
            renderSeaLanterns(entity, time, tickDelta, matrices, vertexConsumers, seaLanternStack, rotation);
        }
    }
    private void renderSeaLanterns(ArdenimiumLampEntity entity, long time, float tickDelta, MatrixStack matrices,
                                   VertexConsumerProvider vertexConsumers, ItemStack seaLanternStack,
                                   float rotation) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        // Radius des Kreises, auf dem sich die Sea Lanterns befinden
        float seaLanternRadius = 0.5f;
        // Bestimme die aktuelle Position der Sea Lanterns basierend auf der Zeit und der Rotation
        // Jede Sea Lantern ist um DEGREE_INCREMENT Grad versetzt
        for (int i = 0; i < SEA_LANTERN_COUNT; i++) {
            double angle = Math.toRadians((i * DEGREE_INCREMENT) + rotation); // Berechne den Winkel für jede Lantern

            // Berechne die Position jeder Sea Lantern basierend auf dem Winkel
            double lanternX = 0.5 + seaLanternRadius * MathHelper.cos((float) angle);
            double lanternZ = 0.5 + seaLanternRadius * MathHelper.sin((float) angle);

            matrices.push();
            matrices.translate(lanternX, 0.5f, lanternZ); // Positioniere die Sea Lantern
            matrices.scale(0.125f, 0.125f, 0.125f); // Skalierung der Sea Lantern
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation)); // Rotation um die Y-Achse
            itemRenderer.renderItem(seaLanternStack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
            matrices.pop();
        }
    }

    /**
     * Methode, um das Lichtlevel an der Blockposition abzurufen.
     */
    private int getLightLevel(@NotNull World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }

    /**
     * Methode zur Bestimmung der Rotationsgeschwindigkeit basierend auf der Tageszeit und dem Ardenim Block.
     */
    private float getRotationSpeed(World world, BlockPos corePos) {
        long timeOfDay = world.getTimeOfDay();
        BlockPos ardenimBlockPos = corePos.down(1); // Position 1 Block unter dem Nether Star Core

        // Überprüfe, ob sich an der Position ein Ardenim Block befindet
        boolean hasArdenimBlock = world.getBlockState(ardenimBlockPos).getBlock() == TestModBlocks.Ardenim_Block;

        // Rotationsgeschwindigkeit basierend auf Tageszeit und ob der Ardenim Block vorhanden ist
        return (timeOfDay >= 12000 && timeOfDay < 24000 && hasArdenimBlock) ? NIGHT_ROTATION_SPEED : DAY_ROTATION_SPEED;
    }
}
