package unfassbarer.testmod.world.biome;

import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.world.biome.surface.ModMaterialRules;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(Testmod.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Testmod.MOD_ID, ModMaterialRules.makeRules());
    }
}
