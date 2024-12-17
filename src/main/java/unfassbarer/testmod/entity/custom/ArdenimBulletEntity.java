package unfassbarer.testmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import unfassbarer.testmod.entity.ModEntities;
import unfassbarer.testmod.item.TestModItems;

public class ArdenimBulletEntity extends ThrownItemEntity {
    private float damage;  // Dynamischer Schaden, der durch Sharpness beeinflusst wird

    // Konstruktoren
    public ArdenimBulletEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ArdenimBulletEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.ARDENIM_BULLET_ENTITY, livingEntity, world);
    }

    // Methode zum Erstellen des Spawn-Pakets
    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    // Standard-Item für diese Kugel
    @Override
    protected Item getDefaultItem() {
        return TestModItems.Ardenimium_Bullet;
    }

    // Behandelt die Kollision mit einem Block
    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte) 3);
        }
        this.discard();
        super.onBlockHit(blockHitResult);
    }

    // Behandelt die Kollision mit einer Entität
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity targetEntity = entityHitResult.getEntity();
        targetEntity.damage(this.getDamageSources().thrown(this, this.getOwner()), this.damage);
    }

    // Behandelt die Kollision allgemein
    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, (byte) 3);
            this.discard();
        }
    }

    // Fügt Partikel hinzu (nur clientseitig)
    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient && this.age % 2 == 0) { // Partikel nur clientseitig erzeugen
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(),
                    this.getVelocity().x * 0.1, this.getVelocity().y * 0.1, this.getVelocity().z * 0.1);
        }
    }

    // Setzt die Geschwindigkeit der Kugel basierend auf dem Blickwinkel des Spielers
    public void setBulletVelocity(float pitch, float yaw, double speed) {
        double velocityX = -Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
        double velocityY = -Math.sin(Math.toRadians(pitch));
        double velocityZ = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
        this.setVelocity(velocityX, velocityY, velocityZ, (float) speed, 0.0F); // Keine Streuung
    }

    // Methode zum Setzen des dynamischen Schadens
    public void setBulletDamage(float damage) {
        this.damage = damage;
    }
}