package org.thirdTune.apex_extra

import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.common.data.LanguageProvider
import net.minecraftforge.common.data.SoundDefinitionsProvider
import net.minecraftforge.data.event.GatherDataEvent

object GenData {
    fun onGenData(event: GatherDataEvent) {
        val gen = event.generator
        val packOutput = gen.packOutput
        val helper = event.existingFileHelper
        gen.addProvider(event.includeClient(), EnglishLanguageProvider(packOutput))
        gen.addProvider(event.includeClient(), ChineseLanguageProvider(packOutput))
        gen.addProvider(event.includeClient(), ModelProvider(packOutput, helper))
        gen.addProvider(event.includeClient(), SoundProvider(packOutput,helper))
    }

    class EnglishLanguageProvider(gen: PackOutput) : LanguageProvider(gen, ApexExtra.MOD_ID, "en_us") {
        override fun addTranslations() {
            addItemTranslations()
        }
        private fun addItemTranslations(){
            this.add(Config.STIM.get(), "Stim")
        }
    }

    class ChineseLanguageProvider(gen: PackOutput) : LanguageProvider(gen, ApexExtra.MOD_ID, "zh_cn") {
        override fun addTranslations() {
            addItemTranslations()
        }
        private fun addItemTranslations(){
            this.add(Config.STIM.get(), "加速激素")
        }
    }

    class ModelProvider(gen: PackOutput, helper: ExistingFileHelper) :
        ItemModelProvider(gen, ApexExtra.MOD_ID, helper) {
        override fun registerModels() {
            this.singleTexture(
                Config.STIM_ID, ResourceLocation("item/generated"), "layer0",
                ResourceLocation(ApexExtra.MOD_ID, "item/${Config.STIM_ID}")
            )
        }
    }

    class SoundProvider(gen: PackOutput, helper: ExistingFileHelper) :
        SoundDefinitionsProvider(gen,ApexExtra.MOD_ID,helper) {
        override fun registerSounds() {
            this.add("stim_activate", definition().with(
                sound(Config.Stim_Activate_1P_01.id),
                sound(Config.Stim_Activate_1P_02.id),
                sound(Config.Stim_Activate_1P_03.id),
            ).subtitle("Stim activate"))
        }
    }
}