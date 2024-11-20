package unfassbarer.testmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
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
                            new StatusEffectInstance(StatusEffects.STRENGTH, 200, 2, false, false, true),
                            new StatusEffectInstance(StatusEffects.SPEED, 200, 2, false, false, true),
                            new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 2, false, false, true)}).build();
    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
                if (hasCorrectArmorOn(ModArmorMaterials.ARDENIMIUM, player)) {
                    spawnArmorParticles(world, player);
                }
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
            if (!hasPlayerEffect) {
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
        ItemStack bootsStack = player.getInventory().getArmorStack(0);
        ItemStack leggingsStack = player.getInventory().getArmorStack(1);
        ItemStack breastplateStack = player.getInventory().getArmorStack(2);
        ItemStack helmetStack = player.getInventory().getArmorStack(3);
        return bootsStack.getItem() instanceof ArmorItem boots && boots.getMaterial() == material &&
                leggingsStack.getItem() instanceof ArmorItem leggings && leggings.getMaterial() == material &&
                breastplateStack.getItem() instanceof ArmorItem breastplate && breastplate.getMaterial() == material &&
                helmetStack.getItem() instanceof ArmorItem helmet && helmet.getMaterial() == material;
    }
    private void spawnArmorParticles(World world, PlayerEntity player) {
        if (!world.isClient) {
            return;
        }
        if (world.random.nextFloat() > 0.15) {
            return;
        }
        Vec3d position = player.getPos();
        int particleCount = 1;
        for (int i = 0; i < particleCount; i++) {
            double offsetX = (world.random.nextDouble() - 0.5) * 2.0;
            double offsetY = world.random.nextDouble() * 2.0;
            double offsetZ = (world.random.nextDouble() - 0.5) * 2.0;
            double velocityX = (world.random.nextDouble() - 0.5) * 0.1;
            double velocityY = (world.random.nextDouble()) * 0.1;
            double velocityZ = (world.random.nextDouble() - 0.5) * 0.1;

            switch (world.random.nextInt(3)) {
                case 0 -> world.addParticle(
                        ParticleTypes.FLAME,
                        position.x + offsetX,
                        position.y + offsetY,
                        position.z + offsetZ,
                        velocityX,
                        velocityY,
                        velocityZ
                );
                case 1 -> world.addParticle(
                        ParticleTypes.SMOKE,
                        position.x + offsetX,
                        position.y + offsetY,
                        position.z + offsetZ,
                        velocityX,
                        velocityY,
                        velocityZ
                );
                case 2 -> world.addParticle(
                        ParticleTypes.ASH,
                        position.x + offsetX,
                        position.y + offsetY,
                        position.z + offsetZ,
                        velocityX,
                        velocityY,
                        velocityZ
                );
            }
        }
    }
}