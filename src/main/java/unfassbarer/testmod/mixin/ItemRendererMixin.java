package unfassbarer.testmod.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.item.TestModItems;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useArdenimSwordModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        if (stack.isOf(TestModItems.Ardenimium_Sword) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Testmod.MOD_ID, "ardenimium_sword_3d", "inventory"));
        }
        if (stack.isOf(TestModItems.Ardenimium_Gun) && renderMode != ModelTransformationMode.GUI) {
             return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Testmod.MOD_ID, "ardenimium_gun_3d", "inventory"));
         }
        if (stack.isOf(TestModItems.Ardenimium_Pickaxe) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Testmod.MOD_ID, "ardenimium_pickaxe_3d", "inventory"));
        }
        if (stack.isOf(TestModItems.Ardenimium_Shovel) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Testmod.MOD_ID, "ardenimium_shovel_3d", "inventory"));
        }
        return value;
    }
}