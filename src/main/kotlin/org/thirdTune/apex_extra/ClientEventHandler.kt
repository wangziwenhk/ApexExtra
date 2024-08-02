package org.thirdTune.apex_extra

import net.minecraft.client.Minecraft
import net.minecraft.world.entity.player.Player
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.event.TickEvent.ClientTickEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = ApexExtra.MOD_ID, value = [Dist.CLIENT])
class ClientEventHandler {
    companion object {
        var nearPlayerHighLight = false
    }

    @SubscribeEvent
    fun onClientTick(event: ClientTickEvent) {
        val mc = Minecraft.getInstance()
        val player = mc.player ?: return
        if (nearPlayerHighLight) {
            for (nearPlayer in player.level()
                .getEntitiesOfClass(Player::class.java, player.boundingBox.inflate(10.0))) {
                if (nearPlayer != player) {
                    nearPlayer.setGlowingTag(true)
                }
            }
        }
    }
}