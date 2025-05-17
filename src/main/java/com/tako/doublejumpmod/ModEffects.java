package com.tako.doublejumpmod;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
        DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DoubleJumpMod.MODID);
    
    public static final RegistryObject<MobEffect> DOUBLE_JUMP =
        MOB_EFFECTS.register("double_jump", DoubleJumpEffect::new);
}
