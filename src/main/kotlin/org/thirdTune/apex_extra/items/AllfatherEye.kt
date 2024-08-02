package org.thirdTune.apex_extra.items

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
        const val duration: Int = 4

        // 冷却时间 (秒)
        const val cooldown = 30
    }

    // 显示高亮的剩余 Tick
    private var showTime = 0
    override fun use(world: Level, player: Player, usedHand: InteractionHand): InteractionResultHolder<ItemStack> {
        player.cooldowns.addCooldown(this, cooldown * 20)
        for (nearPlayer in player.level()
            .getEntitiesOfClass(Player::class.java, player.boundingBox.inflate(10.0))) {
            nearPlayer.addEffect(MobEffectInstance(MobEffects.GLOWING, duration * 20, 0))
        }
        showTime = duration * 20
        return super.use(world, player, usedHand)
    }

    override fun onInventoryTick(
        stack: ItemStack?,
        level: Level?,
        player: Player?,
        slotIndex: Int,
        selectedIndex: Int
    ) {
        if (showTime != 0) {
            showTime--
        }

        super.onInventoryTick(stack, level, player, slotIndex, selectedIndex)
    }
}