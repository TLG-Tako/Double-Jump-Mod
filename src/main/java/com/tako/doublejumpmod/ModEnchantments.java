package com.tako.doublejumpmod;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DoubleJumpMod.MODID);

    public static final RegistryObject<Enchantment> DOUBLE_JUMP =
            ENCHANTMENTS.register("double_jump", DoubleJumpEnchantment::new);
}
