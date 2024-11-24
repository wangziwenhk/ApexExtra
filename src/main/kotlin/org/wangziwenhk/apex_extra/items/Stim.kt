package org.wangziwenhk.apex_extra.items

import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import org.wangziwenhk.apex_extra.ApexExtra
import org.wangziwenhk.apex_extra.ModSounds

/**
 * 动力小子的兴奋剂
 */
class Stim : Item(Properties()) {
    companion object {
        // 持续时间 (秒)
        const val DURATION = 6

        // 冷却时间 (秒)
        const val COOLDOWN = 6
    }

    override fun use(world: Level, player: Player, usedHand: InteractionHand): InteractionResultHolder<ItemStack> {
        player.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SPEED, DURATION * 20, 3))
        if (!player.isCreative) {
            if (player.health <= 3.0f) {
                player.health = 1.0f
            } else {
                player.health -= 3.0f
            }
        }
        player.cooldowns.addCooldown(this, COOLDOWN * 20)
        // 声音
        world.playSound(
            player, player.blockPosition(),
            SoundEvent.createVariableRangeEvent(ResourceLocation(ApexExtra.MOD_ID, ModSounds.STIM_ACTIVATE_ID)),
            SoundSource.MASTER,
            0.7f,
            1.0f
        )

        return super.use(world, player, usedHand)
    }
}