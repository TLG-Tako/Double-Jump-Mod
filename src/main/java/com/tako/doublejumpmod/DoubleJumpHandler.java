package com.tako.doublejumpmod;

import com.tako.doublejumpmod.config.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.WeakHashMap;

@Mod.EventBusSubscriber(modid = DoubleJumpMod.MODID, value = Dist.CLIENT)
public class DoubleJumpHandler {

    private static final WeakHashMap<Player, Boolean> lastJumpingState = new WeakHashMap<>();
    private static final WeakHashMap<Player, Long> cooldowns = new WeakHashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        if (event.player.level().isClientSide()) {
            Player player = event.player;
            Minecraft mc = Minecraft.getInstance();
            Player localPlayer = mc.player;

            // Ensure we're processing only the local client player
            if (player == localPlayer) {
                boolean isJumping = mc.options.keyJump.isDown();

                ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
                int level = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.DOUBLE_JUMP.get(), boots);

                if (level > 0) {
                    long now = System.currentTimeMillis();
                    long cooldownTime = getCooldown(level) * 1000L;
                    long cooldownEnd = cooldowns.getOrDefault(player, 0L);

                    if (isJumping && !lastJumpingState.getOrDefault(player, false)) {
                        if (!player.onGround() && now >= cooldownEnd) {
                            double jumpVelocity = getJumpHeight(level);
                            player.setDeltaMovement(player.getDeltaMovement().x, jumpVelocity, player.getDeltaMovement().z);
                            player.hurtMarked = true; // Sync velocity with client
                            cooldowns.put(player, now + cooldownTime);
                        }
                    }

                    lastJumpingState.put(player, isJumping);
                } else {
                    // Cleanup if enchantment is removed
                    lastJumpingState.remove(player);
                    cooldowns.remove(player);
                }
            }
        }
    }

    private static int getCooldown(int level) {
        return switch (level) {
            case 1 -> ConfigHandler.COMMON.cooldownLevel1.get();
            case 2 -> ConfigHandler.COMMON.cooldownLevel2.get();
            case 3 -> ConfigHandler.COMMON.cooldownLevel3.get();
            default -> 30;
        };
    }

    private static double getJumpHeight(int level) {
        return switch (level) {
            case 1 -> ConfigHandler.COMMON.jumpHeightLevel1.get();
            case 2 -> ConfigHandler.COMMON.jumpHeightLevel2.get();
            case 3 -> ConfigHandler.COMMON.jumpHeightLevel3.get();
            default -> 0.6D;
        };
    }
}
