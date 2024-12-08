package unfassbarer.testmod.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;

public class Sounds {
    public static SoundEvent GUN_SHOOT = create("gun_shoot");
    public static SoundEvent NETHER_STAR_CORE_1 = create("nether_star_core_1");
    public static SoundEvent NETHER_STAR_CORE_2 = create("nether_star_core_2");

    private static SoundEvent create(String name) {
        Identifier id = new Identifier(Testmod.MOD_ID, name);
        SoundEvent sound = SoundEvent.of(id);
        Registry.register(Registries.SOUND_EVENT, id, sound);
        return sound;
    }

    public static void registerSounds() {
        Testmod.LOGGER.info("Registering Sounds for " + Testmod.MOD_ID);
    }
}
