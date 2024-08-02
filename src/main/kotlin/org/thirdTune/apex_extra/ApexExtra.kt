package org.thirdTune.apex_extra

import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext


@Mod(ApexExtra.MOD_ID)
class ApexExtra {
    companion object{
        const val MOD_ID = "apex_extra"
        const val MOD_NAME = "Apex Extra"
    }

    @SubscribeEvent
    fun init(event:FMLCommonSetupEvent){
        val modEventBus = FMLJavaModLoadingContext.get().modEventBus
        RegManager.init()
        ModCreativeTab.init()
        GenData.init()
    }
}