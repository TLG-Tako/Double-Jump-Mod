package com.tako.doublejumpmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = DoubleJumpMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DoubleJumpMod.MODID);

    public static final RegistryObject<CreativeModeTab> TAKOS_TAB = TABS.register("tako_tab", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.DOUBLE_JUMP_BOOK.get()))
                    .title(Component.translatable("itemGroup.tako_tab"))
                    .displayItems((params, output) -> {
                        // Add the enchantment book
                        output.accept(ModItems.DOUBLE_JUMP_BOOK.get());

                        // Add Double Jump Potion with its effect
                        ItemStack jumpPotion = new ItemStack(ModItems.DOUBLE_JUMP_POTION.get());
                        PotionUtils.setPotion(jumpPotion, ModPotions.DOUBLE_JUMP_POTION.get());
                        output.accept(jumpPotion);

                        // Add Splash Double Jump Potion with its effect
                        ItemStack splashPotion = new ItemStack(ModItems.SPLASH_DOUBLE_JUMP_POTION.get());
                        PotionUtils.setPotion(splashPotion, ModPotions.SPLASH_DOUBLE_JUMP.get());
                        output.accept(splashPotion);
                    })
                    .build()
    );

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
