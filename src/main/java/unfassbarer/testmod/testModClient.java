package unfassbarer.testmod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.block.entity.ModBlockEntities;
import unfassbarer.testmod.block.entity.renderer.ArdenimiumCrafterEntityRenderer;
import unfassbarer.testmod.block.entity.renderer.PatternProviderEntityRenderer;
import unfassbarer.testmod.entity.client.*;
import unfassbarer.testmod.item.guns.entity.ArdenimBulletEntityRenderer;
import unfassbarer.testmod.item.guns.entity.ModEntities;
import unfassbarer.testmod.screen.ArdenimiumCrafterScreen;
import unfassbarer.testmod.screen.PatternProviderScreen;
import unfassbarer.testmod.screen.ModScreenHandlers;
import unfassbarer.testmod.tooltip.ModTooltipManager;

public class testModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModTooltipManager.registerTooltips();
        EntityRendererRegistry.register(ModEntities.ARDENIM_BULLET_ENTITY_TYPE, ArdenimBulletEntityRenderer::new);
        // Setze den RenderLayer für die Ardenim-Door auf Cutout (für transparente Texturen)
        BlockRenderLayerMap.INSTANCE.putBlock(TestModBlocks.Ardenim_Door, RenderLayer.getCutout());
        // Setze den RenderLayer für die Ardenim-Trapdoor auf Cutout (für transparente Texturen)
        BlockRenderLayerMap.INSTANCE.putBlock(TestModBlocks.Ardenim_Trapdoor, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(TestModBlocks.Ardenim_Glass, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(TestModBlocks.Ardenim_Glass_Pane, RenderLayer.getTranslucent());

        HandledScreens.register(ModScreenHandlers.ARDENIMIUM_CRAFTER_SCREEN_HANDLER, ArdenimiumCrafterScreen::new);
        BlockEntityRendererFactories.register(ModBlockEntities.ARDENIMIUM_CRAFTER_ENTITY, ArdenimiumCrafterEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.PATTERN_PROVIDER_SCREEN_HANDLER, PatternProviderScreen::new);
        BlockEntityRendererFactories.register(ModBlockEntities.PATTERN_PROVIDER_ENTITY, PatternProviderEntityRenderer::new);

        EntityRendererRegistry.register(unfassbarer.testmod.entity.ModEntities.PORCUPINE, PorcupineRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);

        EntityRendererRegistry.register(unfassbarer.testmod.entity.ModEntities.ARDENIMIUM_DRAGON, ArdenimiumDragonRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ARDENIMIUM_DRAGON, ArdenimiumDragonModel::getTexturedModelData);
    }
}