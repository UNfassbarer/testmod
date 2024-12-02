package unfassbarer.testmod.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class FasterReload extends Enchantment {
    public static final FasterReload INSTANCE = new FasterReload(Rarity.UNCOMMON, EnchantmentTarget.BREAKABLE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});

    protected FasterReload(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    /**
     * Diese Methode gibt den Modifikator für die Kugelgeschwindigkeit zurück,
     * der vom Enchantment-Level abhängt.
     */
    public double getBulletSpeedModifier(int level) {
        // Der Multiplikator wird mit jedem Level um 50% erhöht (Level 1 = 1x, Level 2 = 1.5x, Level 3 = 2x)
        return 1.0 + 0.5 * level;
    }
}