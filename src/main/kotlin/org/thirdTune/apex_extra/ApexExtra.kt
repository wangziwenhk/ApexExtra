package org.thirdTune.apex_extra

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext


@Mod(ApexExtra.MOD_ID)
class ApexExtra {
    companion object{
        const val MOD_ID = "apex_extra"
    }

    init {
        val modEventBus = FMLJavaModLoadingContext.get().modEventBus
        Config.ITEMS.register(modEventBus)
        Config.TABS.register(modEventBus)
        Config.SOUNDS.register(modEventBus)
        modEventBus.addListener(Config::buildCreativeTabContent)

        modEventBus.addListener(GenData::onGenData)
    }

}