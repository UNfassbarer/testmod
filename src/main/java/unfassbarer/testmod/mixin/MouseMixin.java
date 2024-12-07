package unfassbarer.testmod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Mouse;
import unfassbarer.testmod.testmod;

@Mixin(Mouse.class)
public class MouseMixin
{
    @Inject(at = @At("RETURN"), method = "onMouseScroll(JDD)V")
    private void onOnMouseScroll(long window, double horizontal,
                                 double vertical, CallbackInfo ci)
    {
        testmod.INSTANCE.onMouseScroll(vertical);
    }
}