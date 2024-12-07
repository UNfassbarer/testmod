package unfassbarer.testmod.item.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import unfassbarer.testmod.enchants.FasterReload;
import unfassbarer.testmod.entity.ModEntities;
import unfassbarer.testmod.entity.custom.ArdenimBulletEntity;
import unfassbarer.testmod.item.TestModItems;
import unfassbarer.testmod.sounds.Sounds;

public class GunItem extends Item {
    private static final int MAX_DAMAGE = 250;

    public GunItem(Settings settings) {
        super(settings.maxDamage(MAX_DAMAGE));
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

        // Überprüfen, ob noch Munition (Ardenimium Bullet) vorhanden ist
        if (!user.getInventory().contains(new ItemStack(TestModItems.Ardenimium_Bullet))) {
            user.sendMessage(Text.literal("No Bullets left!"), true);
            return TypedActionResult.fail(itemStack);
        }
        if (world.isClient()) {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player != null) {
                // Rückstoß initialisieren
                float recoil = -1.5F; // Vertikaler Rückstoß
                float shake = (world.random.nextFloat() - 0.5F) * 1.5F; // Seitliche Schwankung

                // Rückstoß anwenden
                client.player.setPitch(client.player.getPitch() + recoil);
                client.player.setYaw(client.player.getYaw() + shake);

                // Rückkehr zur Ausgangsposition starten
                scheduleRecoilReset(client.player, recoil, shake, 5); // Dauer: 5 Ticks
            }
        }


        // Überprüfen, ob das Enchantment "Infinity" vorhanden ist (optional)
        boolean hasINFINITY = EnchantmentHelper.getLevel(Enchantments.INFINITY, itemStack) > 0;

        // Überprüfen, ob das Enchantment "Unbreaking" vorhanden ist
        int unbreakingLevel = EnchantmentHelper.getLevel(Enchantments.UNBREAKING, itemStack);
        boolean hasUnbreaking = unbreakingLevel > 0;

        // Wenn Infinity nicht vorhanden ist, entferne eine Kugel aus dem Inventar
        if (!hasINFINITY) {
            user.getInventory().removeStack(user.getInventory().getSlotWithStack(new ItemStack(TestModItems.Ardenimium_Bullet)), 1);
        }

        // Berechne die Schadenshöhe basierend auf Unbreaking
        int damageAmount = 1;
        if (hasUnbreaking && world.random.nextInt(unbreakingLevel + 1) > 0) {
            damageAmount = 0;
        }
        itemStack.damage(damageAmount, user, entity -> entity.sendToolBreakStatus(hand));

        // Berechne die Bullet-Geschwindigkeit basierend auf dem Enchantment-Level von FasterReload
        int reloadLevel = EnchantmentHelper.getLevel(FasterReload.INSTANCE, itemStack); // Verwende FasterReload.INSTANCE anstelle von Class
        double speedModifier = FasterReload.INSTANCE.getBulletSpeedModifier(reloadLevel);  // Nutze die Methode der Instanz
        double bulletSpeed = 4.0f * speedModifier;  // Basisgeschwindigkeit (4.0f) multipliziert mit dem Modifier

        // Erstelle die Bullet-Entity und setze die Geschwindigkeit
        ArdenimBulletEntity bulletEntity = new ArdenimBulletEntity(ModEntities.ARDENIM_BULLET_ENTITY, user, world);
        bulletEntity.setOwner(user);
        bulletEntity.refreshPositionAndAngles(user.getX(), user.getEyeY() - 0.1, user.getZ(), user.getYaw(), user.getPitch());
        bulletEntity.setBulletVelocity(user, user.getPitch(), user.getYaw(), bulletSpeed);  // Setze die Geschwindigkeit der Kugel

        // Spawne die Bullet-Entity in der Welt
        world.spawnEntity(bulletEntity);

        // Spiele den Schuss-Sound ab
        world.playSound(null, user.getX(), user.getY(), user.getZ(), Sounds.GUN_SHOOT, SoundCategory.PLAYERS, 0.25F, 1.0F);

        return TypedActionResult.success(itemStack);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.getItem() == TestModItems.Ardenimium_Gun;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        // Erlaube, das "FasterReload"-Enchantment auf diesem Item zu verzaubern
        return true;
    }
}