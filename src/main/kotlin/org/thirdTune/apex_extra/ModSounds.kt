package org.thirdTune.apex_extra

import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.RegistryObject
import org.thirdTune.apex_extra.ResManager.SOUNDS

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
object ModSounds {
    const val STIM_ACTIVATE_ID = "stim_activate"
    val Stim_Activate_01: RegistryObject<SoundEvent> = SOUNDS.register("stim_activate_01") {
        SoundEvent.createVariableRangeEvent(
            ResourceLocation(ApexExtra.MOD_ID, "sounds/stim_activate_01.ogg")
        )
    }
    val Stim_Activate_02: RegistryObject<SoundEvent> = SOUNDS.register("stim_activate_02") {
        SoundEvent.createVariableRangeEvent(
            ResourceLocation(ApexExtra.MOD_ID, "sounds/stim_activate_02.ogg")
        )
    }
    val Stim_Activate_03: RegistryObject<SoundEvent> = SOUNDS.register("stim_activate_03") {
        SoundEvent.createVariableRangeEvent(
            ResourceLocation(ApexExtra.MOD_ID, "sounds/stim_activate_03.ogg")
        )
    }

}