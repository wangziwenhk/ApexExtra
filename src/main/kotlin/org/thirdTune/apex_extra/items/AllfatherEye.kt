package org.thirdTune.apex_extra.items

import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import org.thirdTune.apex_extra.ApexExtra

class AllfatherEye : Item(Properties()) {
    // 持续时间 (秒)
    private val duration = 2

    // 冷却时间 (秒)
    private val cooldown = 30

    // 显示高亮的剩余 Tick
    private var showTime = 0
    override fun use(world: Level, player: Player, usedHand: InteractionHand): InteractionResultHolder<ItemStack> {
        player.cooldowns.addCooldown(this, cooldown * 20)
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
        if (showTime == 0) {
            ApexExtra.nearPlayerHighLight = false
        } else {
            showTime--
        }

        super.onInventoryTick(stack, level, player, slotIndex, selectedIndex)
    }
}