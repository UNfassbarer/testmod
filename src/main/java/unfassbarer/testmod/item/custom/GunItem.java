package unfassbarer.testmod.item.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import unfassbarer.testmod.enchants.FasterReload;
import unfassbarer.testmod.enchants.ModEnchantments;
import unfassbarer.testmod.entity.custom.ArdenimBulletEntity;
import unfassbarer.testmod.item.TestModItems;
import unfassbarer.testmod.sounds.Sounds;

public class GunItem extends Item {
    private static final int MAX_DAMAGE = 250;

    public GunItem(Settings settings) {
        super(settings.maxDamage(MAX_DAMAGE));
    }

    private void applyRecoil(ClientPlayerEntity player, float recoil, float shake) {
        player.setPitch(player.getPitch() + recoil);
        player.setYaw(player.getYaw() + shake);
    }

    private void scheduleRecoilReset(ClientPlayerEntity player, float recoil, float shake, int duration) {
        MinecraftClient.getInstance().execute(() -> {
            float stepPitch = recoil / duration;
            float stepYaw = shake / duration;

            for (int i = 0; i < duration; i++) {
                try {
                    Thread.sleep(50);
                    float newPitch = player.getPitch() - stepPitch;
                    float newYaw = player.getYaw() - stepYaw;

                    player.setPitch(newPitch);
                    player.setYaw(newYaw);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        int baseCooldown = 15;

        // Überprüfen, ob das Item die FasterReload-Verzauberung hat und die Stufe abfragen
        int reloadLevel = EnchantmentHelper.getLevel(FasterReload.INSTANCE, itemStack);
        if (reloadLevel > 0) {
            baseCooldown = (int)(baseCooldown * (1 - 0.33f * reloadLevel));
        }

        // Setze den Cooldown
        user.getItemCooldownManager().set(this, baseCooldown);

        // Munition prüfen
        boolean hasAmmo = user.getInventory().contains(new ItemStack(TestModItems.Ardenimium_Bullet));
        if (!hasAmmo) {
            if (!world.isClient()) {
                user.sendMessage(Text.literal("No Bullets left!"), true);
            }
            return TypedActionResult.fail(itemStack);
        }

        // Restlicher Code bleibt gleich
        if (world.isClient()) {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player != null) {
                float recoil = -1.5F;
                float shake = (world.random.nextFloat() - 0.5F) * 1.5F;
                applyRecoil(client.player, recoil, shake);
                scheduleRecoilReset(client.player, recoil, shake, 5);
            }
        }

        boolean hasImmeasurableness = EnchantmentHelper.getLevel(ModEnchantments.IMMEASURABLENESS, itemStack) > 0;

        if (!hasImmeasurableness) {
            // Munitionsentfernung
            int ammoCount = user.getInventory().count(TestModItems.Ardenimium_Bullet);
            if (ammoCount > 0) {
                // Entferne eine Munition
                user.getInventory().removeStack(user.getInventory().getSlotWithStack(new ItemStack(TestModItems.Ardenimium_Bullet)), 1);
            }
        }

        int unbreakingLevel = EnchantmentHelper.getLevel(Enchantments.UNBREAKING, itemStack);
        if (unbreakingLevel == 0 || world.random.nextInt(unbreakingLevel + 1) == 0) {
            itemStack.damage(1, user, entity -> entity.sendToolBreakStatus(hand));
        }

        double x = user.getX();
        double y = user.getY() + user.getEyeHeight(EntityPose.STANDING) - 0.5;
        double z = user.getZ();

        // Berechne die Richtung der Waffe
        float pitch = user.getPitch();
        float yaw = user.getYaw();

        // Erstelle die Bullet-Entity
        ArdenimBulletEntity bulletEntity = new ArdenimBulletEntity(user, world);
        bulletEntity.setOwner(user);
        bulletEntity.refreshPositionAndAngles(x, y, z, yaw, pitch);
        bulletEntity.setBulletVelocity(pitch, yaw, 4.0f);

        int devanstationLevel = EnchantmentHelper.getLevel(ModEnchantments.DEVANSTATION, itemStack);
        float bulletDamage = 15.0f + devanstationLevel * 2.0f;
        bulletEntity.setBulletDamage(bulletDamage);

        world.spawnEntity(bulletEntity);

        world.playSound(null, user.getX(), user.getY(), user.getZ(), Sounds.GUN_SHOOT, SoundCategory.PLAYERS, 0.25F, 1.0F);

        return TypedActionResult.pass(itemStack);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.getItem() == TestModItems.Ardenimium_Gun;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }
}