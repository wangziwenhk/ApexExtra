package org.thirdTune.apex_extra.gen

import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.LanguageProvider
import org.thirdTune.apex_extra.ApexExtra
import org.thirdTune.apex_extra.ModItems

class ChineseLanguageProvider(gen: PackOutput) : LanguageProvider(gen, ApexExtra.MOD_ID, "zh_cn") {
    override fun addTranslations() {
        addItemTranslations()
    }

    private fun addItemTranslations() {
        this.add(ModItems.STIM.get(), "加速激素")
        this.add(ModItems.ALLFATHER_EYE.get(), "众神之眼")
    }
}