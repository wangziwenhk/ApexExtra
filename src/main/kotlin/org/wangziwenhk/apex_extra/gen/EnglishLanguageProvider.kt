package org.wangziwenhk.apex_extra.gen

import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.LanguageProvider
import org.wangziwenhk.apex_extra.ApexExtra
import org.wangziwenhk.apex_extra.ModCurios
import org.wangziwenhk.apex_extra.ModItems

class EnglishLanguageProvider(gen: PackOutput) : LanguageProvider(gen, ApexExtra.MOD_ID, "en_us") {
    override fun addTranslations() {
        addItemTranslations()
    }

    private fun addItemTranslations() {
        // 技能相关
        this.add(ModItems.STIM.get(), "Stim")
        this.add(ModItems.ALLFATHER_EYE.get(), "Eye of the Allfather")
        this.add("item."+ApexExtra.MOD_ID+"."+ ModItems.ALLFATHER_EYE.get().toString()+".effect","Scan detected")
        // 装备相关
        this.add(ModItems.SAFE_BOOTS.get(), "Safe Boots")
        // 传奇徽章相关
        this.add(ModCurios.OCTANE_BADGE.get(), "Octane Badges")
        // 插槽相关 (Curios Api)
        this.add("curios.identifier."+ModCurios.LEGEND_BADGE_ID,"传奇徽章")
    }
}