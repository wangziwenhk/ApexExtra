package org.thirdTune.apex_extra.items

import net.minecraft.nbt.CompoundTag
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraftforge.common.capabilities.ICapabilityProvider
import org.thirdTune.apex_extra.ModCurios
import top.theillusivec4.curios.api.CuriosApi
import top.theillusivec4.curios.api.SlotContext
import top.theillusivec4.curios.api.type.capability.ICurio
import top.theillusivec4.curios.api.type.capability.ICurioItem


class OctaneBadge : Item(Properties().setNoRepair().stacksTo(1)), ICurioItem {
    companion object {
        // 恢复的冷却时间
        const val cooldown = 30
    }

    // 等待恢复的时间
    var waitTime = 0

    override fun initCapabilities(stack: ItemStack?, nbt: CompoundTag?): ICapabilityProvider {
        return CuriosApi.createCurioProvider(object : ICurio {
            override fun getStack(): ItemStack {
                return stack!!
            }

            override fun curioTick(slotContext: SlotContext) {
                // 生命值恢复
            }
        })
    }

    override fun curioTick(slotContext: SlotContext, stack: ItemStack) {
        if (waitTime == 0) {
            val player = slotContext.entity
            if (player is Player) {
                player.health += 1
            }
            waitTime = cooldown
        } else {
            waitTime--
        }
    }

    override fun canEquip(slotContext: SlotContext, stack: ItemStack): Boolean {
        return true
    }

    override fun canUnequip(slotContext: SlotContext?, stack: ItemStack?): Boolean {
        return true
    }

    override fun onEquip(slotContext: SlotContext?, prevStack: ItemStack?, stack: ItemStack?) {
        super.onEquip(slotContext, prevStack, stack)
    }

    override fun onUnequip(slotContext: SlotContext?, newStack: ItemStack?, stack: ItemStack?) {
        super.onUnequip(slotContext, newStack, stack)
    }


    override fun canEquipFromUse(slotContext: SlotContext?, stack: ItemStack?): Boolean {
        return slotContext!!.identifier() == ModCurios.LEGEND_BADGE_ID
    }
}