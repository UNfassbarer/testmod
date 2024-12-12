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
        // Neue Thread-Logik für Rückkehr
        new Thread(() -> {
            try {
                float stepPitch = recoil / duration; // Pro-Tick-Wert für Pitch
                float stepYaw = shake / duration;   // Pro-Tick-Wert für Yaw

                for (int i = 0; i < duration; i++) {
                    Thread.sleep(50); // Wartezeit zwischen den Änderungen (50ms = 1 Tick)
                    float newPitch = player.getPitch() - stepPitch;
                    float newYaw = player.getYaw() - stepYaw;

                    MinecraftClient.getInstance().execute(() -> {
                        player.setPitch(newPitch);
                        player.setYaw(newYaw);
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        // Basis-Cooldown von 15
        int baseCooldown = 15;

        // Überprüfen, ob das Item die FasterReload-Verzauberung hat und die Stufe abfragen
        int reloadLevel = EnchantmentHelper.getLevel(FasterReload.INSTANCE, itemStack);
        if (reloadLevel > 0) {
            // Je nach Stufe der Verzauberung den Cooldown verringern
            baseCooldown = (int)(baseCooldown * (1 - 0.33f * reloadLevel)); // 10% schnellere Ladezeit pro Level
        }

        // Setze den Cooldown für das Item
        user.getItemCooldownManager().set(this, baseCooldown);

        // Munition prüfen
        ItemStack ammoStack = new ItemStack(TestModItems.Ardenimium_Bullet);
        if (!user.getInventory().contains(ammoStack)) {
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
            int slot = user.getInventory().getSlotWithStack(ammoStack);
            if (slot >= 0) {
                user.getInventory().removeStack(slot, 1);
            }
        }

        int unbreakingLevel = EnchantmentHelper.getLevel(Enchantments.UNBREAKING, itemStack);
        if (unbreakingLevel == 0 || world.random.nextInt(unbreakingLevel + 1) == 0) {
            itemStack.damage(1, user, entity -> entity.sendToolBreakStatus(hand));
        }

        double x = user.getX();
        double y = user.getY() + user.getEyeHeight(EntityPose.STANDING) - 0.5;
        double z = user.getZ();


        // Berechne die Richtung der Waffe (basierend auf der Blickrichtung des Spielers)
        float pitch = user.getPitch();
        float yaw = user.getYaw();

        // Erstelle die Bullet-Entity an der Position der Waffe
        ArdenimBulletEntity bulletEntity = new ArdenimBulletEntity(user, world);
        bulletEntity.setOwner(user);
        bulletEntity.refreshPositionAndAngles(x, y, z, yaw, pitch);
        bulletEntity.setBulletVelocity(pitch, yaw, 4.0f);  // Geschwindigkeit setzen
        world.spawnEntity(bulletEntity);

        world.playSound(null, user.getX(), user.getY(), user.getZ(), Sounds.GUN_SHOOT, SoundCategory.PLAYERS, 0.25F, 1.0F);

        return TypedActionResult.pass(itemStack);
    }




    @Override
    public boolean isEnchantable(ItemStack stack) {
        // Erlaubt Verzauberbarkeit über die Verzauberungstabelle
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