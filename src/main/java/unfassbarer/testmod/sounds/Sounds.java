package unfassbarer.testmod.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;

public class Sounds {
    public static final SoundEvent GUN_SHOOT = registerSoundEvent("gun_shoot");
    public static final SoundEvent NETHER_STAR_CORE_1 = registerSoundEvent("nether_star_core_1");
    public static final SoundEvent NETHER_STAR_CORE_2 = registerSoundEvent("nether_star_core_2");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(Testmod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        Testmod.LOGGER.info("Registering Sounds for " + Testmod.MOD_ID);
    }
}