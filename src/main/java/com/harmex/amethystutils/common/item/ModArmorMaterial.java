package com.harmex.amethystutils.common.item;

import com.harmex.amethystutils.AmethystUtils;
import com.harmex.amethystutils.common.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    AMETHYST_MKI("amethyst_mki", 9, new int[]{2, 3, 5, 2}, 27,
            SoundEvents.ARMOR_EQUIP_GOLD, 0.0f, 0.0f, () -> {
        return Ingredient.of(ModItems.AMETHYST_INGOT.get());
    }),
    AMETHYST_MKII("amethyst_mkii", 10, new int[]{2, 4, 5, 2}, 28,
            SoundEvents.ARMOR_EQUIP_GOLD, 0.0f, 0.0f, () -> {
        return Ingredient.of(ModBlocks.AMETHYST_INGOT_BLOCK.get());
    })
    ;

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ModArmorMaterial(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
                             SoundEvent sound, float toughness, float knockbackResistance,
                             Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }


    public int getDurabilityForSlot(EquipmentSlot slot) {
        return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.slotProtections[slot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return AmethystUtils.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
