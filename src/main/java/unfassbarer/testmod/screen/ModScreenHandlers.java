package unfassbarer.testmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;

public class ModScreenHandlers {
    public static void registerScreenHandlers() {
        Testmod.LOGGER.info("Registering Screen Handlers for {}", Testmod.MOD_ID);
    }    public static final ScreenHandlerType<ArdenimiumCrafterScreenHandler> ARDENIMIUM_CRAFTER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Testmod.MOD_ID, "ardenimium_crafting"),
                    new ExtendedScreenHandlerType<>(ArdenimiumCrafterScreenHandler::new));

    public static final ScreenHandlerType<PatternProviderScreenHandler> PATTERN_PROVIDER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Testmod.MOD_ID, "pattern_providing"),
                    new ExtendedScreenHandlerType<>(PatternProviderScreenHandler::new));

    public static final ScreenHandlerType<MoonAltarScreenHandler> MOON_ALTAR_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Testmod.MOD_ID, "mooning"),
                    new ExtendedScreenHandlerType<>(MoonAltarScreenHandler::new));

}
