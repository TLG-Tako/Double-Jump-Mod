package com.tako.doublejumpmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.tako.doublejumpmod.config.ConfigHandler;

@Mod(DoubleJumpMod.MODID)
public class DoubleJumpMod {
    public static final String MODID = "doublejumpmod";

    public DoubleJumpMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register your deferred registers here
        ModItems.register(modEventBus);
        ModEnchantments.ENCHANTMENTS.register(modEventBus);
        ModEffects.MOB_EFFECTS.register(modEventBus);
        ModPotions.POTIONS.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        // Register event handlers on the Forge event bus
        MinecraftForge.EVENT_BUS.register(DoubleJumpHandler.class);

        // Register your config file so Forge loads it
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_CONFIG);
    }
}
