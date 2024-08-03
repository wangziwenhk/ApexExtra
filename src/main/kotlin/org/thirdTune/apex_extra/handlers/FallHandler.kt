package org.thirdTune.apex_extra.handlers

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.entity.living.LivingFallEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import org.thirdTune.apex_extra.ApexExtra
import org.thirdTune.apex_extra.armors.SafeBoots


@EventBusSubscriber(modid = ApexExtra.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
object FallHandler {
    @SubscribeEvent
    fun onLivingFall(event: LivingFallEvent) {
        // 穿靴子没摔落伤害
        if (event.entity is Player) {
            val player = event.entity as Player
            val boots = player.getItemBySlot(EquipmentSlot.FEET).item
            if(boots is SafeBoots){
                event.isCanceled = true
            }
        }
    }
}