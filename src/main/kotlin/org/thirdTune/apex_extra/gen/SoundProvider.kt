package org.thirdTune.apex_extra.gen

import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.common.data.SoundDefinitionsProvider
import org.thirdTune.apex_extra.ApexExtra
import org.thirdTune.apex_extra.ModSounds

class SoundProvider(gen: PackOutput, helper: ExistingFileHelper) :
    SoundDefinitionsProvider(gen, ApexExtra.MOD_ID, helper) {
    override fun registerSounds() {
        this.add(
            ModSounds.STIM_ACTIVATE_ID, definition().with(
                sound(ModSounds.Stim_Activate_01.id),
                sound(ModSounds.Stim_Activate_02.id),
                sound(ModSounds.Stim_Activate_03.id),
            ).subtitle("Stim activate")
        )
    }
}