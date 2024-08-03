package org.thirdTune.apex_extra

import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.registries.RegistryObject
import org.thirdTune.apex_extra.ResManager.TABS

@Mod.EventBusSubscriber(modid = ApexExtra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object ModCreativeTab {
    private val MAIN_TAB: RegistryObject<CreativeModeTab> =
        TABS.register("main_tab") { CreativeModeTab.builder().icon { ItemStack(ModItems.STIM.get()) }.build() }

    private fun buildCreativeTabContent(event: BuildCreativeModeTabContentsEvent) {
        if (event.tab === MAIN_TAB.get()) {
            event.accept(ModItems.STIM.get())
            event.accept(ModItems.ALLFATHER_EYE.get())
            event.accept(ModItems.SAFE_BOOTS.get())
        }
    }

    fun init() {
        FMLJavaModLoadingContext.get().modEventBus.addListener(ModCreativeTab::buildCreativeTabContent)
    }
}
