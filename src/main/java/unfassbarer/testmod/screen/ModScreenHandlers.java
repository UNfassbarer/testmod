package unfassbarer.testmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.TestmodInitializer;

public class ModScreenHandlers {
    public static void registerScreenHandlers() {
        TestmodInitializer.LOGGER.info("Registering Screen Handlers for {}", TestmodInitializer.MOD_ID);
    }    public static final ScreenHandlerType<ArdenimiumCrafterScreenHandler> ARDENIMIUM_CRAFTER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(TestmodInitializer.MOD_ID, "ardenimium_crafting"),
                    new ExtendedScreenHandlerType<>(ArdenimiumCrafterScreenHandler::new));

    public static final ScreenHandlerType<PatternProviderScreenHandler> PATTERN_PROVIDER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(TestmodInitializer.MOD_ID, "gem_polishing"),
                    new ExtendedScreenHandlerType<>(PatternProviderScreenHandler::new));


}
