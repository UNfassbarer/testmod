package unfassbarer.testmod;

import dev.architectury.platform.Mod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.block.custom.ArdenimNeonBlock;
import unfassbarer.testmod.block.entity.ModBlockEntities;
import unfassbarer.testmod.block.entity.renderer.ArdenimiumCrafterEntityRenderer;
import unfassbarer.testmod.block.entity.renderer.ArdenimiumLampEntityRenderer;
import unfassbarer.testmod.block.entity.renderer.NetherStarCoreEntityRenderer;
import unfassbarer.testmod.block.entity.renderer.PatternProviderEntityRenderer;
import unfassbarer.testmod.entity.ModEntities;
import unfassbarer.testmod.entity.client.*;
import unfassbarer.testmod.fluids.ModFluids;
import unfassbarer.testmod.item.TestModItems;
import unfassbarer.testmod.screen.ArdenimiumCrafterScreen;
import unfassbarer.testmod.screen.ModScreenHandlers;
import unfassbarer.testmod.screen.PatternProviderScreen;
import unfassbarer.testmod.tooltip.ModTooltipManager;

public class testModClient implements ClientModInitializer {

    private static boolean currentlyZoomed;
    private static KeyBinding keyBinding;
    private static boolean originalSmoothCameraEnabled;
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public static final double zoomLevel = 0.23;

    @Override
    public void onInitializeClient() {
        keyBinding = new KeyBinding(
                "key.logical_zoom.zoom",
                InputUtil.Type.MOUSE,
                GLFW.GLFW_MOUSE_BUTTON_LEFT,
                "category.logical_zoom.zoom"
        );
        currentlyZoomed = false;
        originalSmoothCameraEnabled = false;

        KeyBindingHelper.registerKeyBinding(keyBinding);

        ModTooltipManager.registerTooltips();
        BlockRenderLayerMap.INSTANCE.putBlock(TestModBlocks.Ardenim_Door,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TestModBlocks.Ardenim_Trapdoor,RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(TestModBlocks.Ardenim_Glass,RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(TestModBlocks.Ardenim_Glass_Pane,RenderLayer.getTranslucent());

        HandledScreens.register(ModScreenHandlers.ARDENIMIUM_CRAFTER_SCREEN_HANDLER,ArdenimiumCrafterScreen::new);
        BlockEntityRendererFactories.register(ModBlockEntities.ARDENIMIUM_CRAFTER_ENTITY,ArdenimiumCrafterEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.PATTERN_PROVIDER_SCREEN_HANDLER,PatternProviderScreen::new);
        BlockEntityRendererFactories.register(ModBlockEntities.PATTERN_PROVIDER_ENTITY,PatternProviderEntityRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.NETHER_STAR_CORE_ENTITY,NetherStarCoreEntityRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.ARDENIMIUM_LAMP_ENTITY,ArdenimiumLampEntityRenderer::new);

        EntityRendererRegistry.register(ModEntities.PORCUPINE,PorcupineRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE,PorcupineModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ARDENIMIUM_DRAGON,ArdenimiumDragonRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ARDENIMIUM_DRAGON,ArdenimiumDragonModel::getTexturedModelData);

        BlockRenderLayerMap.INSTANCE.putBlock(ArdenimNeonBlock.Ardenim_Neon_Block,RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.ARDENIM_BULLET_ENTITY,FlyingItemEntityRenderer::new);
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_ARDENIM_WATER, ModFluids.FLOWING_ARDENIM_WATER,
                SimpleFluidRenderHandler.coloredWater(0xD0A038));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_ARDENIM_WATER, ModFluids.FLOWING_ARDENIM_WATER);
    }

    public static boolean isZooming() {
        return keyBinding.isPressed() && isHoldingGun();
    }

    private static boolean isHoldingGun() {
        return mc.player != null && (
                mc.player.getMainHandStack().getItem() == TestModItems.Ardenimium_Gun ||
                        mc.player.getOffHandStack().getItem() == TestModItems.Ardenimium_Gun
        );
    }



    public static void manageSmoothCamera() {
        if (zoomStarting()) {
            zoomStarted();
            enableSmoothCamera();
        }

        if (zoomStopping()) {
            zoomStopped();
            resetSmoothCamera();
        }
    }

    private static boolean isSmoothCamera() {
        return mc.options.smoothCameraEnabled;
    }

    private static void enableSmoothCamera() {
        mc.options.smoothCameraEnabled = true;
    }

    private static void disableSmoothCamera() {
        mc.options.smoothCameraEnabled = false;
    }

    private static boolean zoomStarting() {
        return isZooming() && !currentlyZoomed;
    }

    private static boolean zoomStopping() {
        return !isZooming() && currentlyZoomed;
    }

    private static void zoomStarted() {
        originalSmoothCameraEnabled = isSmoothCamera();
        currentlyZoomed = true;
    }

    private static void zoomStopped() {
        currentlyZoomed = false;
    }

    private static void resetSmoothCamera() {
        if (originalSmoothCameraEnabled) {
            enableSmoothCamera();
        } else {
            disableSmoothCamera();
        }
    }
}