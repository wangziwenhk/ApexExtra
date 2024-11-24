package org.wangziwenhk.apex_extra

import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.wangziwenhk.apex_extra.ResManager.ITEMS
import org.wangziwenhk.apex_extra.ResManager.SOUNDS
import org.wangziwenhk.apex_extra.ResManager.TABS
import org.wangziwenhk.apex_extra.handlers.FallHandler


@Mod(ApexExtra.MOD_ID)
class ApexExtra {
    companion object {
        const val MOD_ID = "apex_extra"
        const val MOD_NAME = "Apex Extra"
    }

    init {
        init()
    }

    private fun init() {
        ModCreativeTab.init()
        FMLJavaModLoadingContext.get().modEventBus.register(GenData)
        MinecraftForge.EVENT_BUS.register(FallHandler)
        ITEMS.register(FMLJavaModLoadingContext.get().modEventBus)
        TABS.register(FMLJavaModLoadingContext.get().modEventBus)
        SOUNDS.register(FMLJavaModLoadingContext.get().modEventBus)
    }
}