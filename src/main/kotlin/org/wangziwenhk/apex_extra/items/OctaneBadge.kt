package org.wangziwenhk.apex_extra.items

import net.minecraft.nbt.CompoundTag
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraftforge.common.capabilities.ICapabilityProvider
import org.wangziwenhk.apex_extra.ModCurios
import top.theillusivec4.curios.api.CuriosApi
import top.theillusivec4.curios.api.SlotContext
import top.theillusivec4.curios.api.type.capability.ICurio
import top.theillusivec4.curios.api.type.capability.ICurioItem

class OctaneBadge : Item(Properties().stacksTo(1).defaultDurability(0)), ICurioItem {
    companion object {
        // 恢复的冷却时间
        const val COOLDOWN = 15
    }

    // 等待恢复的时间
    private var waitTime = 0

    override fun initCapabilities(stack: ItemStack, nbt: CompoundTag?): ICapabilityProvider {
        return CuriosApi.createCurioProvider(object : ICurio {
            override fun getStack(): ItemStack = stack

            override fun curioTick(slotContext: SlotContext) {
                if (waitTime > 0) {
                    waitTime--
                    return
                }

                val entity = slotContext.entity
                if (entity is Player) {
                    // 恢复生命值，确保不超过最大生命值
                    val newHealth = (entity.health + 1).coerceAtMost(entity.maxHealth)
                    if (newHealth > entity.health) {
                        entity.health = newHealth
                        waitTime = COOLDOWN * 20
                    }
                }
            }

            override fun canEquip(slotContext: SlotContext?): Boolean {
                return true
            }

            override fun onEquip(slotContext: SlotContext?, prevStack: ItemStack?) {
                super.onEquip(slotContext, prevStack)
            }

            override fun canUnequip(slotContext: SlotContext?): Boolean {
                return true
            }

            override fun onUnequip(slotContext: SlotContext?, newStack: ItemStack?) {
                super.onUnequip(slotContext, newStack)
            }

            override fun canEquipFromUse(slotContext: SlotContext?): Boolean {
                return slotContext?.identifier() == ModCurios.LEGEND_BADGE_ID
            }
        })
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