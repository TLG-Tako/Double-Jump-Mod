package com.tako.doublejumpmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHandler {

    public static final ForgeConfigSpec COMMON_CONFIG;
    public static final Common COMMON;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        COMMON = new Common(builder);
        COMMON_CONFIG = builder.build();
    }

    public static class Common {
        public final ForgeConfigSpec.IntValue cooldownLevel1;
        public final ForgeConfigSpec.IntValue cooldownLevel2;
        public final ForgeConfigSpec.IntValue cooldownLevel3;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("Double Jump Cooldowns");

            cooldownLevel1 = builder
                .comment("Cooldown in seconds for Double Jump level 1")
                .defineInRange("cooldownLevel1", 30, 1, 120);

            cooldownLevel2 = builder
                .comment("Cooldown in seconds for Double Jump level 2")
                .defineInRange("cooldownLevel2", 15, 1, 120);

            cooldownLevel3 = builder
                .comment("Cooldown in seconds for Double Jump level 3")
                .defineInRange("cooldownLevel3", 5, 1, 120);

            builder.pop();
        }
    }
}
