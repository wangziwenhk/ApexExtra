package org.wangziwenhk.apex_extra.gen

import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.LanguageProvider
import org.wangziwenhk.apex_extra.ApexExtra
import org.wangziwenhk.apex_extra.ModCurios
import org.wangziwenhk.apex_extra.ModItems

class ChineseLanguageProvider(gen: PackOutput) : LanguageProvider(gen, ApexExtra.MOD_ID, "zh_cn") {
    override fun addTranslations() {
        addItemTranslations()
    }

    private fun addItemTranslations() {
        // 技能相关
        this.add(ModItems.STIM.get(), "加速激素")
        this.add(ModItems.ALLFATHER_EYE.get(), "众神之眼")
        this.add("item."+ApexExtra.MOD_ID+"."+ ModItems.ALLFATHER_EYE.get().toString()+".effect","侦测到扫描")
        // 装备相关
        this.add(ModItems.SAFE_BOOTS.get(),"安全靴子")
        // 传奇徽章相关
        this.add(ModCurios.OCTANE_BADGE.get(),"动力小子徽章")
        // 插槽相关 (Curios Api)
        this.add("curios.identifier."+ModCurios.LEGEND_BADGE_ID,"传奇徽章")
    }
}