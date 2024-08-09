package unfassbarer.testmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import unfassbarer.testmod.item.ModArmorMaterials;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance[]> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance[]>())
                    .put(ModArmorMaterials.ARDENIM, new StatusEffectInstance[]{
                            new StatusEffectInstance(StatusEffects.SPEED, 200, 0, false, false, true)})
                    .put(ModArmorMaterials.ARDENIMIUM, new StatusEffectInstance[]{
                            new StatusEffectInstance(StatusEffects.STRENGTH, 200, 0, false, false, true),
                            new StatusEffectInstance(StatusEffects.SPEED, 200, 0, false, false, true),
                            new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0, false, false, true)}).build();
    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance[]> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance[] mapStatusEffects = entry.getValue();
            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectsForMaterial(player, mapArmorMaterial, mapStatusEffects);
            }
        }
    }
    private void addStatusEffectsForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance[] mapStatusEffects) {
        for (StatusEffectInstance effect : mapStatusEffects) {
            boolean hasPlayerEffect = player.hasStatusEffect(effect.getEffectType());
            if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
                player.addStatusEffect(new StatusEffectInstance(effect));
            }
        }
    }
    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);
        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }
    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem breastplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();
        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}