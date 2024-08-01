package org.thirdTune.apex_extra

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import org.thirdTune.apex_extra.items.Stim


object Config {
    // 注册器
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, ApexExtra.MOD_ID)
    val TABS: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ApexExtra.MOD_ID)
    val SOUNDS: DeferredRegister<SoundEvent> = DeferredRegister.create(Registries.SOUND_EVENT,ApexExtra.MOD_ID)

    // 物品
    const val STIM_ID = "stim"
    val STIM: RegistryObject<Stim> = ITEMS.register(STIM_ID) { Stim() }

    // 音效
    val Stim_Activate_1P_01: RegistryObject<SoundEvent> = SOUNDS.register("stim_activate_1p_01") {
        SoundEvent.createVariableRangeEvent(
            ResourceLocation(ApexExtra.MOD_ID, "sounds/stim_activate_1p_01.ogg")
        )
    }
    val Stim_Activate_1P_02: RegistryObject<SoundEvent> = SOUNDS.register("stim_activate_1p_02") {
        SoundEvent.createVariableRangeEvent(
            ResourceLocation(ApexExtra.MOD_ID, "sounds/stim_activate_1p_02.ogg")
        )
    }
    val Stim_Activate_1P_03: RegistryObject<SoundEvent> = SOUNDS.register("stim_activate_1p_03") {
        SoundEvent.createVariableRangeEvent(
            ResourceLocation(ApexExtra.MOD_ID, "sounds/stim_activate_1p_03.ogg")
        )
    }

    // TAB
    val MAIN_TAB: RegistryObject<CreativeModeTab> = TABS.register("main_tab") { CreativeModeTab.builder().icon { ItemStack(STIM.get()) }.build() }
    // 标签页填充
    fun buildCreativeTabContent(event: BuildCreativeModeTabContentsEvent) {
        if (event.tab === MAIN_TAB.get()) {
            event.accept(STIM.get())
        }
    }
}
