package org.thirdTune.apex_extra

import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.thirdTune.apex_extra.gen.ChineseLanguageProvider
import org.thirdTune.apex_extra.gen.EnglishLanguageProvider
import org.thirdTune.apex_extra.gen.ModelProvider
import org.thirdTune.apex_extra.gen.SoundProvider

object GenData {
    fun init(){
        FMLJavaModLoadingContext.get().modEventBus.addListener(GenData::onGenData)
    }

    private fun onGenData(event: GatherDataEvent) {
        val gen = event.generator
        val packOutput = gen.packOutput
        val helper = event.existingFileHelper
        gen.addProvider(event.includeClient(), EnglishLanguageProvider(packOutput))
        gen.addProvider(event.includeClient(), ChineseLanguageProvider(packOutput))
        gen.addProvider(event.includeClient(), ModelProvider(packOutput, helper))
        gen.addProvider(event.includeClient(), SoundProvider(packOutput, helper))
    }
}