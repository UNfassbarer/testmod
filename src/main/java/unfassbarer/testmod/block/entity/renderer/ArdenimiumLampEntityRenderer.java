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
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.block.entity.ArdenimiumLampEntity;

public class ArdenimiumLampEntityRenderer implements BlockEntityRenderer<ArdenimiumLampEntity> {
    private static final float DAY_ROTATION_SPEED = 2.0f;
    private static final float NIGHT_ROTATION_SPEED = 32.0f;

    public ArdenimiumLampEntityRenderer(BlockEntityRendererFactory.Context context) {
    }
    @Override
    public void render(ArdenimiumLampEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = entity.getRenderStack().isEmpty() ? new ItemStack(Items.NETHER_STAR) : entity.getRenderStack();

        World world = entity.getWorld();
        long time = world.getTime(); // Aktuelle Spielzeit
        float rotationSpeed = getRotationSpeed(world, entity.getPos()); // RotationSpeed basierend auf Tageszeit und Bedingung
        float rotation = (time + tickDelta) * rotationSpeed % 360; // Rotationsgeschwindigkeit
        matrices.push();
        matrices.translate(0.5f, 0.5f, 0.5f); // In die Mitte des Blocks verschieben
        matrices.scale(0.4f, 0.4f, 0.4f); // Die Größe des Objekts anpassen
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation)); // Drehung um die Y-Achse hinzufügen
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90)); // Optionale Z-Achsen-Drehung
        itemRenderer.renderItem(stack, ModelTransformationMode.GUI, getLightLevel(world, entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, world, 1);
        matrices.pop();
    }
    // Methode, um das Lichtlevel an der Blockposition abzurufen
    private int getLightLevel(@NotNull World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
    // Methode zur Bestimmung der Rotationsgeschwindigkeit basierend auf der Tageszeit und dem Solar Stabilizer
    private float getRotationSpeed(World world, BlockPos corePos) {
        long timeOfDay = world.getTimeOfDay();
        BlockPos stabilizerPos = corePos.down(3); // Position 3 Blöcke unter dem Nether Star Core
        // Überprüfe, ob sich an der Position ein Solar Stabilizer befindet
        boolean hasSolarStabilizer = world.getBlockState(stabilizerPos).getBlock() == TestModBlocks.Solar_Strabilizer;
        // Rotationsgeschwindigkeit basierend auf Tageszeit und ob der Solar Stabilizer vorhanden ist
        return (timeOfDay >= 12000 && timeOfDay < 24000 && hasSolarStabilizer) ? NIGHT_ROTATION_SPEED : DAY_ROTATION_SPEED;
    }
}