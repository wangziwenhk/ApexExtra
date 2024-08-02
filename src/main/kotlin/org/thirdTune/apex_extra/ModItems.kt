package org.thirdTune.apex_extra

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.RegistryObject
import org.thirdTune.apex_extra.ResManager.ITEMS
import org.thirdTune.apex_extra.items.Stim

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
object ModItems {
    const val STIM_ID = "stim"
    val STIM: RegistryObject<Stim> = ITEMS.register(STIM_ID) { Stim() }
}