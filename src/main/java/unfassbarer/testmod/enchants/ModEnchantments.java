package unfassbarer.testmod.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;

public class ModEnchantments {
    public static final Enchantment FASTER_RELOAD = FasterReload.INSTANCE;
    public static final Enchantment IMMEASURABLENESS = Immeasurableness.INSTANCE;
    public static final Enchantment DEVANSTATION = Devastation.INSTANCE;

    public static void registerEnchantments() {
    Registry.register(Registries.ENCHANTMENT, new Identifier(Testmod.MOD_ID, "faster_reload"), FASTER_RELOAD);
    Registry.register(Registries.ENCHANTMENT, new Identifier(Testmod.MOD_ID, "immeasurableness"), IMMEASURABLENESS);
    Registry.register(Registries.ENCHANTMENT, new Identifier(Testmod.MOD_ID, "devastation"), DEVANSTATION);
    }
}
