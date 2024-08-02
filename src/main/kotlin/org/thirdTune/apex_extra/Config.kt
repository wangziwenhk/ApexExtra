package org.thirdTune.apex_extra

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import org.thirdTune.apex_extra.RegManager.ITEMS
import org.thirdTune.apex_extra.RegManager.SOUNDS
import org.thirdTune.apex_extra.RegManager.TABS
import org.thirdTune.apex_extra.items.Stim

object RegManager {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, ApexExtra.MOD_ID)
    val SOUNDS: DeferredRegister<SoundEvent> = DeferredRegister.create(Registries.SOUND_EVENT, ApexExtra.MOD_ID)
    val TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ApexExtra.MOD_ID)
    fun init() {
        ITEMS.register(FMLJavaModLoadingContext.get().modEventBus)
        TABS.register(FMLJavaModLoadingContext.get().modEventBus)
        SOUNDS.register(FMLJavaModLoadingContext.get().modEventBus)
    }
}

object ModItems {
    const val STIM_ID = "stim"
    val STIM: RegistryObject<Stim> = ITEMS.register(STIM_ID) { Stim() }
}

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

object ModCreativeTab {
    private val MAIN_TAB: RegistryObject<CreativeModeTab> =
        TABS.register("main_tab") { CreativeModeTab.builder().icon { ItemStack(ModItems.STIM.get()) }.build() }

    // 标签页填充
    private fun buildCreativeTabContent(event: BuildCreativeModeTabContentsEvent) {
        if (event.tab === MAIN_TAB.get()) {
            event.accept(ModItems.STIM.get())
        }
    }
    fun init(){
        FMLJavaModLoadingContext.get().modEventBus.addListener(ModCreativeTab::buildCreativeTabContent)
    }
}
