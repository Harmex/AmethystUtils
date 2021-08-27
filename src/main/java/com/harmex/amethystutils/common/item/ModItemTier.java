package com.harmex.amethystutils.common.item;

import com.harmex.amethystutils.common.block.ModBlocks;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements Tier {
    AMETHYST_MKI(0, 131, 12.0f, 1.0f, 23, () -> {
        return Ingredient.of(ModItems.AMETHYST_INGOT.get());
    }),
    AMETHYST_MKII(1, 250, 12.0f, 2.0f, 24, () -> {
        return Ingredient.of(ModBlocks.AMETHYST_INGOT_BLOCK.get());
    })
    ;

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModItemTier(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
