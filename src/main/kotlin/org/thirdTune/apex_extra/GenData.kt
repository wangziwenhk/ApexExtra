package org.thirdTune.apex_extra

import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import org.thirdTune.apex_extra.gen.*

@EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
object GenData {
    @SubscribeEvent
    fun onGenData(event: GatherDataEvent) {
        val gen = event.generator
        val packOutput = gen.packOutput
        val helper = event.existingFileHelper
        gen.addProvider(event.includeClient(), EnglishLanguageProvider(packOutput))
        gen.addProvider(event.includeClient(), ChineseLanguageProvider(packOutput))
        gen.addProvider(event.includeClient(), ModelProvider(packOutput, helper))
        gen.addProvider(event.includeClient(), SoundProvider(packOutput, helper))
        gen.addProvider(event.includeClient(), CuriosProvider(packOutput, helper, event.lookupProvider))
    }
}