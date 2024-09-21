package unfassbarer.testmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ArdenimBulletEntity extends ThrownItemEntity {
    private static final float BULLET_DAMAGE = 15.0f;
    private static final double BULLET_SPEED = 4.0f;
    public ArdenimBulletEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
        this.setNoGravity(true);
    }
    public ArdenimBulletEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world) {
        super(entityType, livingEntity, world);
        this.setNoGravity(true);
    }
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity targetEntity = entityHitResult.getEntity();
        float damageAmount = BULLET_DAMAGE;
        targetEntity.damage(this.getDamageSources().thrown(this, this.getOwner()), damageAmount);
    }
    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (this.getWorld().isClient && this.age % 0.5 == 0) {
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY()+0.25, this.getZ(),
                    this.getVelocity().x * 0.1, this.getVelocity().y * 0.1, this.getVelocity().z * 0.1);
            // Send status update to clients
            this.getWorld().sendEntityStatus(this, (byte) 3);
            // Remove the entity
            this.discard();
        }
    }
    @Override
    protected Item getDefaultItem() {
        return null;
    }
    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient && this.age % 2 == 0) { // Partikel nur bei jedem 2. Tick erzeugen
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(),
                    this.getVelocity().x * 0.1, this.getVelocity().y * 0.1, this.getVelocity().z * 0.1);
        }
    }
    public void setBulletVelocity(LivingEntity shooter, float pitch, float yaw) {
        double velocityX = -Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
        double velocityY = -Math.sin(Math.toRadians(pitch));
        double velocityZ = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
        this.setVelocity(velocityX, velocityY, velocityZ, (float) BULLET_SPEED, 1.0F);
    }
}
