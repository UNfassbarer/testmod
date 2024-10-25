package unfassbarer.testmod.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(InfinityEnchantment.class)
public class InfinityEnchantmentMixin extends Enchantment {
    public InfinityEnchantmentMixin(Enchantment.Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.BREAKABLE, slotTypes);
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return other instanceof MendingEnchantment ? true : super.canAccept(other);
    }
}