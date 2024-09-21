package unfassbarer.testmod.item.custom;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import unfassbarer.testmod.entity.ModEntities;
import unfassbarer.testmod.entity.custom.ArdenimBulletEntity;
import unfassbarer.testmod.item.TestModItems;
import unfassbarer.testmod.sounds.Sounds;

public class GunItem extends Item  {
    private static final int MAX_DAMAGE = 250;
    public GunItem(Settings settings) {
        super(settings.maxDamage(MAX_DAMAGE));
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!user.getInventory().contains(new ItemStack(TestModItems.Ardenimium_Bullet))) {
            user.sendMessage(Text.literal("No Bullets left !"), true);
            return TypedActionResult.fail(itemStack);
        }
        boolean hasINFINITY = EnchantmentHelper.getLevel(Enchantments.INFINITY, itemStack) > 0;
        int unbreakingLevel = EnchantmentHelper.getLevel(Enchantments.UNBREAKING, itemStack);
        boolean hasUnbreaking = unbreakingLevel > 0;
        if (!hasINFINITY) {
            user.getInventory().removeStack(user.getInventory().getSlotWithStack(new ItemStack(TestModItems.Ardenimium_Bullet)), 1);
        }
        int damageAmount = 1;
        if (hasUnbreaking && world.random.nextInt(unbreakingLevel + 1) > 0) {
            damageAmount = 0;
        }
        itemStack.damage(damageAmount, user, entity -> entity.sendToolBreakStatus(hand));
        ArdenimBulletEntity bulletEntity = new ArdenimBulletEntity(ModEntities.ARDENIM_BULLET_ENTITY_TYPE, user, world);
        bulletEntity.setOwner(user);
        bulletEntity.refreshPositionAndAngles(user.getX(), user.getEyeY() - 0.1, user.getZ(), user.getYaw(), user.getPitch());
        bulletEntity.setBulletVelocity(user, user.getPitch(), user.getYaw());
        world.spawnEntity(bulletEntity);
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
        return false;
    }
}
