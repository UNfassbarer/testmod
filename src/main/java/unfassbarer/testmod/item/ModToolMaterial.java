package unfassbarer.testmod.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    ARDENIM(3,900,2,1.5f,15,
            () -> Ingredient.ofItems(TestModItems.Ardenim)),

    ARDENIMIUM(5,2500,20f,5,30,
                    () -> Ingredient.ofItems(TestModItems.Ardenimium));
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngreadient;
    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngreadient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngreadient = repairIngreadient;
    }
    @Override
    public int getDurability() {
        return this.itemDurability;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }
    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }
    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }
    @Override
    public int getEnchantability() {
        return this.enchantability;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngreadient.get();
    }
}
