package org.wangziwenhk.apex_extra.items

import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class AllfatherEye : Item(Properties().stacksTo(1).setNoRepair()) {
    companion object {
        // 持续时间 (秒)
        const val DURATION: Int = 4

        // 冷却时间 (秒)
        const val COOLDOWN = 30

        // 高亮范围
        const val HIGH_LIGHT_RANGE = 30.0

        // 收到被侦测消息的范围
        const val INFO_RANGE = 50.0
    }

    override fun use(world: Level, player: Player, usedHand: InteractionHand): InteractionResultHolder<ItemStack> {
        // 设置冷却时间
        player.cooldowns.addCooldown(this, COOLDOWN * 20)

        // 打高亮
        for (nearPlayer in player.level()
            .getEntitiesOfClass(Player::class.java, player.boundingBox.inflate(HIGH_LIGHT_RANGE))) {
            if (nearPlayer != player) {
                // 如果是队友就不要打上高亮
                if (nearPlayer.team == player.team && nearPlayer.team!!.name != "") {
                    continue
                }
                nearPlayer.addEffect(MobEffectInstance(MobEffects.GLOWING, DURATION * 20, 0))
            }
        }

        for (nearPlayer in player.level()
            .getEntitiesOfClass(Player::class.java, player.boundingBox.inflate(INFO_RANGE))) {
            // 如果不是队友就发消息提示被侦测到
            if (nearPlayer.team != player.team) {
                nearPlayer.displayClientMessage(Component.translatable("item.apex_extra.allfather_eye.effect"), false)
            }
        }
        return super.use(world, player, usedHand)
    }

}
