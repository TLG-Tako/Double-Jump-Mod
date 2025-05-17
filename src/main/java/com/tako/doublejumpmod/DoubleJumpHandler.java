package com.tako.doublejumpmod;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.MinecraftForge;

import java.util.WeakHashMap;

@Mod.EventBusSubscriber(modid = DoubleJumpMod.MODID, value = Dist.CLIENT)
public class DoubleJumpHandler {

    private static final WeakHashMap<Player, Boolean> lastJumpingState = new WeakHashMap<>();
    private static final WeakHashMap<Player, Long> cooldowns = new WeakHashMap<>();

    public DoubleJumpHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings("deprecation")
	@SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        if (event.player.level().isClientSide()) {
            Player player = event.player;
            Minecraft mc = Minecraft.getInstance();
            Player localPlayer = mc.player;

            // We only track the local client player because input is only available there
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
                            // Perform double jump
                            player.setDeltaMovement(player.getDeltaMovement().x, 0.6D, player.getDeltaMovement().z);
                            player.hurtMarked = true; // Make sure velocity syncs to client

                            cooldowns.put(player, now + cooldownTime);
                        }
                    }

                    lastJumpingState.put(player, isJumping);
                } else {
                    lastJumpingState.remove(player);
                    cooldowns.remove(player);
                }
            }
        }
    }

    private static int getCooldown(int level) {
        return switch (level) {
            case 1 -> 30;
            case 2 -> 15;
            case 3 -> 5;
            default -> 30;
        };
    }
}
