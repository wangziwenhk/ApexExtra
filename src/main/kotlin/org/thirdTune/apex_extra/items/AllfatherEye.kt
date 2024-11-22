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
        const val DURATION: Int = 4

        // 冷却时间 (秒)
        const val COOLDOWN = 30
    }

    // 显示高亮的剩余 Tick
    private var showTime = 0
    override fun use(world: Level, player: Player, usedHand: InteractionHand): InteractionResultHolder<ItemStack> {
        player.cooldowns.addCooldown(this, COOLDOWN * 20)
        for (nearPlayer in player.level()
            .getEntitiesOfClass(Player::class.java, player.boundingBox.inflate(40.0))) {
            if(nearPlayer!=player){
                nearPlayer.addEffect(MobEffectInstance(MobEffects.GLOWING, DURATION * 20, 0))
            }
        }
        showTime = DURATION * 20
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
