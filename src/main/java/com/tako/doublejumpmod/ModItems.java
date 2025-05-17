package com.tako.doublejumpmod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DoubleJumpMod.MODID);

    public static final RegistryObject<Item> DOUBLE_JUMP_BOOK = ITEMS.register("double_jump_book",
            () -> Items.ENCHANTED_BOOK); // You can customize this further if needed

    public static final RegistryObject<Item> DOUBLE_JUMP_POTION = ITEMS.register("double_jump_potion",
            () -> new PotionItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SPLASH_DOUBLE_JUMP_POTION = ITEMS.register("splash_double_jump_potion",
            () -> new PotionItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
