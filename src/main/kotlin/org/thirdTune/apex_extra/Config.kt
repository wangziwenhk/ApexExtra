package org.thirdTune.apex_extra

import net.minecraft.core.registries.Registries
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
    val TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ApexExtra.MOD_ID)

    // 物品
    const val STIM_ID = "stim"
    val STIM: RegistryObject<Stim> = ITEMS.register(STIM_ID) { Stim() }

    // TAB
    val MAIN_TAB: RegistryObject<CreativeModeTab> = TABS.register("main_tab") { CreativeModeTab.builder().icon { ItemStack(STIM.get()) }.build() }
    // 标签页填充
    fun buildCreativeTabContent(event: BuildCreativeModeTabContentsEvent) {
        if (event.tab === MAIN_TAB.get()) {
            event.accept(STIM.get())
        }
    }
}