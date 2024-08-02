package org.thirdTune.apex_extra.gen

import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.common.data.ExistingFileHelper
import org.thirdTune.apex_extra.ApexExtra
import org.thirdTune.apex_extra.ModItems

class ModelProvider(gen: PackOutput, helper: ExistingFileHelper) :
    ItemModelProvider(gen, ApexExtra.MOD_ID, helper) {
    override fun registerModels() {
        this.singleTexture(
            ModItems.STIM_ID, ResourceLocation("item/generated"), "layer0",
            ResourceLocation(ApexExtra.MOD_ID, "item/${ModItems.STIM_ID}")
        )
    }
}