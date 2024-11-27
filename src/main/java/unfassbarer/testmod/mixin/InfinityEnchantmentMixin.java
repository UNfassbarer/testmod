package unfassbarer.testmod.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(InfinityEnchantment.class)
public class InfinityEnchantmentMixin extends Enchantment {

    public InfinityEnchantmentMixin(Enchantment.Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.BREAKABLE, slotTypes);
    }

    private static final net.minecraft.item.Item REQUIRED_ITEM = net.minecraft.item.Items.DIAMOND; // Beispiel: Spieler braucht einen Diamanten

    /**
     * @author GoForceX
     * @reason Make infinity enchantment work with mending under specific conditions.
     */
    @Overwrite
    public boolean canAccept(Enchantment other) {
        if (isUsingAnvilWithRequiredItem()) {
            return this != other; // Erlaubt Kombination nur, wenn Bedingung erfüllt ist
        }
        return super.canAccept(other); // Standardverhalten, wenn Bedingung nicht erfüllt ist
    }

    private boolean isUsingAnvilWithRequiredItem() {
        // Hole den aktuellen Spieler
        PlayerEntity player = net.minecraft.client.MinecraftClient.getInstance().player;
        if (player == null) {
            return false; // Kein Spieler gefunden
        }

        // Prüfe, ob der Spieler einen Amboss verwendet
        if (!(player.currentScreenHandler instanceof AnvilScreenHandler)) {
            return false; // Spieler ist nicht am Amboss
        }

        // Prüfe, ob der Spieler das erforderliche Item im Inventar hat
        for (ItemStack stack : player.getInventory().main) {
            if (stack.isOf(REQUIRED_ITEM)) {
                return true; // Erforderliches Item gefunden
            }
        }

        return false; // Bedingung nicht erfüllt
    }
}