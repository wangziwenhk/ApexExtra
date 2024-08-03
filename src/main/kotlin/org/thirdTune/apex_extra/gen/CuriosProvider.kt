package org.thirdTune.apex_extra.gen

import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.ExistingFileHelper
import org.thirdTune.apex_extra.ApexExtra
import org.thirdTune.apex_extra.ModCurios
import top.theillusivec4.curios.api.CuriosDataProvider
import top.theillusivec4.curios.api.type.capability.ICurio
import java.util.concurrent.CompletableFuture


class CuriosProvider(
    gen: PackOutput,
    helper: ExistingFileHelper,
    registries: CompletableFuture<HolderLookup.Provider>
) : CuriosDataProvider(ApexExtra.MOD_ID, gen, helper, registries) {

    override fun generate(registries: HolderLookup.Provider?, fileHelper: ExistingFileHelper?) {
        this.createSlot(ModCurios.LEGEND_BADGE_ID).replace(true).order(1).dropRule(ICurio.DropRule.ALWAYS_KEEP)
    }
}