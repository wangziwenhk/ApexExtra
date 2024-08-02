package org.thirdTune.apex_extra

import net.minecraft.client.Minecraft
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.TickEvent

object ClientHandler {
    var nearPlayerHighLight = false
    fun onClientTick(event: TickEvent.ClientTickEvent) {
        if(event.phase != TickEvent.Phase.START)return
        val mc = Minecraft.getInstance()
        val player = mc.player
        if (nearPlayerHighLight) {
            for (nearPlayer in player!!.level()
                .getEntitiesOfClass(Player::class.java, player.boundingBox.inflate(10.0))) {
                if (nearPlayer != player) {
                    nearPlayer.setGlowingTag(true)
                }
            }
        }
    }
}