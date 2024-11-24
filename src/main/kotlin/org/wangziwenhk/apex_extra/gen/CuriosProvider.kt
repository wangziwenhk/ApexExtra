package org.wangziwenhk.apex_extra.gen

import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.ExistingFileHelper
import org.wangziwenhk.apex_extra.ApexExtra
import org.wangziwenhk.apex_extra.ModCurios
import top.theillusivec4.curios.api.CuriosDataProvider
import top.theillusivec4.curios.api.type.capability.ICurio
import java.util.concurrent.CompletableFuture


class CuriosProvider(
    gen: PackOutput,
    helper: ExistingFileHelper,
    registries: CompletableFuture<HolderLookup.Provider>
) : CuriosDataProvider(ApexExtra.MOD_ID, gen, helper, registries) {

    override fun generate(registries: HolderLookup.Provider?, fileHelper: ExistingFileHelper?) {
        this.createSlot(ModCurios.LEGEND_BADGE_ID)
            .addCosmetic(false)
            .order(1)
            .dropRule(ICurio.DropRule.ALWAYS_KEEP)
            .replace(false)
            .size(1)

        this.createEntities("player")
            .addPlayer()
            .addSlots(ModCurios.LEGEND_BADGE_ID)
            .replace(true)

        // 注册完东西要往这里面添加
        // data/curios/tags/items/legend_badge.json
    }
}