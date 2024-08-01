package org.thirdTune.apex_extra.items

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
import org.thirdTune.apex_extra.ApexExtra
import org.thirdTune.apex_extra.Config


class Stim : Item(Properties()) {
    private var soundTime = 0
    override fun use(world: Level, player: Player, usedHand: InteractionHand): InteractionResultHolder<ItemStack> {
        player.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 3))
        if (!player.isCreative) {
            if (player.health <= 3.0f) {
                player.health = 1.0f
            } else {
                player.health -= 3.0f
            }
        }
        player.cooldowns.addCooldown(this,120)
        // 声音
        world.playSound(
            player, player.blockPosition(),
            SoundEvent.createVariableRangeEvent(ResourceLocation(ApexExtra.MOD_ID, Config.STIM_ACTIVATE_ID)),
            SoundSource.MASTER,
            0.8f,
            1.0f
        )

        return super.use(world, player, usedHand)
    }
}