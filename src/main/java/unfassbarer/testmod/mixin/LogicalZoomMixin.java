package unfassbarer.testmod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.client.render.GameRenderer;
import unfassbarer.testmod.testModClient;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public class LogicalZoomMixin {

    @Inject(method = "getFov(Lnet/minecraft/client/render/Camera;FZ)D", at = @At("RETURN"), cancellable = true)
    public void getZoomLevel(CallbackInfoReturnable<Double> callbackInfo) {
        if(testModClient.isZooming()) {
            double fov = callbackInfo.getReturnValue();
            callbackInfo.setReturnValue(fov * testModClient.zoomLevel);
        }

        testModClient.manageSmoothCamera();
    }
}