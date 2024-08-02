package org.thirdTune.apex_extra

import net.minecraft.core.registries.Registries
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
object ResManager {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, ApexExtra.MOD_ID)
    val SOUNDS: DeferredRegister<SoundEvent> = DeferredRegister.create(Registries.SOUND_EVENT, ApexExtra.MOD_ID)
    val TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ApexExtra.MOD_ID)
}