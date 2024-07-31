package org.thirdTune.apex_extra.items

import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class Stim : Item(Properties()) {
    override fun use(world: Level, player: Player, usedHand: InteractionHand): InteractionResultHolder<ItemStack> {
        player.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 2))
        if (!player.isCreative) {
            if (player.health <= 3.0f) {
                player.health = 1.0f
            } else {
                player.health -= 3.0f
            }
        }

        return super.use(world, player, usedHand)
    }
}