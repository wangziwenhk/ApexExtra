package org.thirdTune.apex_extra

import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.thirdTune.apex_extra.ResManager.ITEMS
import org.thirdTune.apex_extra.ResManager.SOUNDS
import org.thirdTune.apex_extra.ResManager.TABS


@Mod(ApexExtra.MOD_ID)
class ApexExtra {
    companion object{
        const val MOD_ID = "apex_extra"
        const val MOD_NAME = "Apex Extra"
    }
    init{
        init()
    }

    private fun init() {
        ModCreativeTab.init()
        GenData.init()
        ITEMS.register(FMLJavaModLoadingContext.get().modEventBus)
        TABS.register(FMLJavaModLoadingContext.get().modEventBus)
        SOUNDS.register(FMLJavaModLoadingContext.get().modEventBus)
        MinecraftForge.EVENT_BUS.addListener(ClientHandler::onClientTick)
    }
}