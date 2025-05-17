package com.tako.doublejumpmod;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class DoubleJumpEffect extends MobEffect {
    public DoubleJumpEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x98D982); // green color for the effect
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // You can tweak this to make something happen every tick.
        return true;
    }
}
