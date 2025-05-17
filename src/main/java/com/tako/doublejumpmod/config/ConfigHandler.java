package com.tako.doublejumpmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHandler {

    public static final ForgeConfigSpec COMMON_CONFIG;
    public static final Common COMMON;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        COMMON = new Common(builder);
        COMMON_CONFIG = builder.build();
    }

    public static class Common {

        public final ForgeConfigSpec.IntValue cooldownLevel1;
        public final ForgeConfigSpec.IntValue cooldownLevel2;
        public final ForgeConfigSpec.IntValue cooldownLevel3;

        public final ForgeConfigSpec.DoubleValue jumpHeightLevel1;
        public final ForgeConfigSpec.DoubleValue jumpHeightLevel2;
        public final ForgeConfigSpec.DoubleValue jumpHeightLevel3;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("Double Jump Settings");

            // Cooldowns
            cooldownLevel1 = builder
                .comment("Cooldown in seconds for Double Jump level 1")
                .defineInRange("cooldownLevel1", 30, 1, 120);

            cooldownLevel2 = builder
                .comment("Cooldown in seconds for Double Jump level 2")
                .defineInRange("cooldownLevel2", 15, 1, 120);

            cooldownLevel3 = builder
                .comment("Cooldown in seconds for Double Jump level 3")
                .defineInRange("cooldownLevel3", 5, 1, 120);

            // Jump Heights
            jumpHeightLevel1 = builder
                .comment("Vertical jump boost (Y velocity) for level 1")
                .defineInRange("jumpHeightLevel1", 0.6D, 0.1D, 3.0D);

            jumpHeightLevel2 = builder
                .comment("Vertical jump boost (Y velocity) for level 2")
                .defineInRange("jumpHeightLevel2", 0.9D, 0.1D, 3.0D);

            jumpHeightLevel3 = builder
                .comment("Vertical jump boost (Y velocity) for level 3")
                .defineInRange("jumpHeightLevel3", 1.2D, 0.1D, 3.0D);

            builder.pop();
        }
    }
}
