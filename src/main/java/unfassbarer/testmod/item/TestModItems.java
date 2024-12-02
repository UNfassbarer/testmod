package unfassbarer.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.enchants.FasterReload;
import unfassbarer.testmod.item.custom.GunItem;
import unfassbarer.testmod.item.custom.ModArmorItem;

import java.util.Collections;

public class TestModItems {
    public static final Item Ardenim = registerItem("ardenim",
            new Item(new FabricItemSettings()));
    public static final Item Ardenimium = registerItem("ardenimium",
            new Item(new FabricItemSettings()));
    public static final Item Ardenim_Nugget = registerItem("ardenim_nugget",
            new Item(new FabricItemSettings()));
    public static final Item Ardenimium_Nugget = registerItem("ardenimium_nugget",
            new Item(new FabricItemSettings()));
    public static final Item raw_Ardenim = registerItem("raw_ardenim",
            new Item(new FabricItemSettings()));
    public static final Item Ardenim_apple = registerItem("ardenim_apple",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent
                            .Builder()
                            .hunger(3)
                            .saturationModifier(6).alwaysEdible().meat()
                            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 160), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 160, 2), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 160), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 160, 1), 0.3f)
                            .build())));
    public static final Item Ardenimium_apple = registerItem("ardenimium_apple",
            new EnchantedGoldenAppleItem(new FabricItemSettings()
                    .food(new FoodComponent
                            .Builder()
                            .hunger(6)
                            .saturationModifier(8)
                            .alwaysEdible()
                            .meat()
                            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 320, 2), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 320), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 320, 3), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 320, 3), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 320), 1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 320, 2), 1)
                            .build())));
    public static final Item Ardenim_Pickaxe = registerItem("ardenim_pickaxe",
            new PickaxeItem(ModToolMaterial.ARDENIM, 1, 1, new FabricItemSettings()));
    public static final Item Ardenim_Sword = registerItem("ardenim_sword",
            new SwordItem(ModToolMaterial.ARDENIM, 3, 2, new FabricItemSettings()));
    public static final Item Ardenim_Shovel = registerItem("ardenim_shovel",
            new ShovelItem(ModToolMaterial.ARDENIM, 1, 1, new FabricItemSettings()));
    public static final Item Ardenim_Axe = registerItem("ardenim_axe",
            new AxeItem(ModToolMaterial.ARDENIM, 2, 1, new FabricItemSettings()));
    public static final Item Ardenim_Hoe = registerItem("ardenim_hoe",
            new HoeItem(ModToolMaterial.ARDENIM, 1, 1, new FabricItemSettings()));

    public static final Item Ardenimium_Pickaxe = registerItem("ardenimium_pickaxe",
            new PickaxeItem(ModToolMaterial.ARDENIMIUM, 2, 1.5f, new FabricItemSettings()));
    public static final Item Ardenimium_Sword = registerItem("ardenimium_sword",
            new SwordItem(ModToolMaterial.ARDENIMIUM, 6, 2, new FabricItemSettings()));
    public static final Item Ardenimium_Shovel = registerItem("ardenimium_shovel",
            new ShovelItem(ModToolMaterial.ARDENIMIUM, 2, 1.5f, new FabricItemSettings()));
    public static final Item Ardenimium_Axe = registerItem("ardenimium_axe",
            new AxeItem(ModToolMaterial.ARDENIMIUM, 2.5f, 1, new FabricItemSettings()));
    public static final Item Ardenimium_Hoe = registerItem("ardenimium_hoe",
            new HoeItem(ModToolMaterial.ARDENIMIUM, 2, 1.5f, new FabricItemSettings()));

    public static final Item Ardenim_Helmet = registerItem("ardenim_helmet",
            new ModArmorItem(ModArmorMaterials.ARDENIM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item Ardenim_Chestplate = registerItem("ardenim_chestplate",
            new ArmorItem(ModArmorMaterials.ARDENIM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item Ardenim_Leggings = registerItem("ardenim_leggings",
            new ArmorItem(ModArmorMaterials.ARDENIM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item Ardenim_Boots = registerItem("ardenim_boots",
            new ArmorItem(ModArmorMaterials.ARDENIM, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item Ardenimium_Helmet = registerItem("ardenimium_helmet",
            new ModArmorItem(ModArmorMaterials.ARDENIMIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item Ardenimium_Chestplate = registerItem("ardenimium_chestplate",
            new ArmorItem(ModArmorMaterials.ARDENIMIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item Ardenimium_Leggings = registerItem("ardenimium_leggings",
            new ArmorItem(ModArmorMaterials.ARDENIMIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item Ardenimium_Boots = registerItem("ardenimium_boots",
            new ArmorItem(ModArmorMaterials.ARDENIMIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item Ardenimium_Gun = registerItem("ardenimium_gun",
            new GunItem(new Item.Settings()));
    public static final Item Ardenimium_Bullet = registerItem("ardenimium_bullet",
            new Item(new Item.Settings()));
    public static final Item Ardenimium_Casing = registerItem("ardenimium_casing",
            new Item(new Item.Settings()));

    public static final Item Blank_Pattern = registerItem("blank_pattern",
            new Item(new Item.Settings()));
    public static final Item Sword_Pattern = registerItem("sword_pattern",
            new Item(new Item.Settings()));
    public static final Item Hoe_Pattern = registerItem("hoe_pattern",
            new Item(new Item.Settings()));
    public static final Item Axe_Pattern = registerItem("axe_pattern",
            new Item(new Item.Settings()));
    public static final Item Pickaxe_Pattern = registerItem("pickaxe_pattern",
            new Item(new Item.Settings()));
    public static final Item Shovel_Pattern = registerItem("shovel_pattern",
            new Item(new Item.Settings()));

    public static final Item Helmet_Pattern = registerItem("helmet_pattern",
            new Item(new Item.Settings()));
    public static final Item Chestplate_Pattern = registerItem("chestplate_pattern",
            new Item(new Item.Settings()));
    public static final Item Leggings_Pattern = registerItem("leggings_pattern",
            new Item(new Item.Settings()));
    public static final Item Boots_Pattern = registerItem("boots_pattern",
            new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Testmod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Testmod.LOGGER.info("Registering Mod Items for " + Testmod.MOD_ID);
    }
}