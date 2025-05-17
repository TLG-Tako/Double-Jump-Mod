package com.tako.doublejumpmod;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class DoubleJumpEnchantment extends Enchantment {

    public DoubleJumpEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR, new EquipmentSlot[]{EquipmentSlot.FEET});
    }

    @Override
    public boolean isTreasureOnly() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return true;
    }
}
