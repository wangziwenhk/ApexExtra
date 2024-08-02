package org.thirdTune.apex_extra.gen

import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.LanguageProvider
import org.thirdTune.apex_extra.ApexExtra
import org.thirdTune.apex_extra.ModItems

class EnglishLanguageProvider(gen: PackOutput) : LanguageProvider(gen, ApexExtra.MOD_ID, "en_us") {
    override fun addTranslations() {
        addItemTranslations()
    }

    private fun addItemTranslations() {
        this.add(ModItems.STIM.get(), "Stim")
    }
}