package com.tako.doublejumpmod;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
        DeferredRegister.create(ForgeRegistries.POTIONS, DoubleJumpMod.MODID);

    public static final RegistryObject<Potion> DOUBLE_JUMP_POTION =
        POTIONS.register("double_jump", () ->
            new Potion(new MobEffectInstance(ModEffects.DOUBLE_JUMP.get(), 3600)));

    public static final RegistryObject<Potion> SPLASH_DOUBLE_JUMP =
        POTIONS.register("splash_double_jump", () ->
            new Potion(new MobEffectInstance(ModEffects.DOUBLE_JUMP.get(), 1800)));
}
