package org.wangziwenhk.apex_extra

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.RegistryObject
import org.wangziwenhk.apex_extra.ResManager.ITEMS
import org.wangziwenhk.apex_extra.items.OctaneBadge

@Mod.EventBusSubscriber(modid = ApexExtra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object ModCurios {
    const val LEGEND_BADGE_ID = "legend_badge"

    const val OCTANE_BADGE_ID = "octane_badge"
    val OCTANE_BADGE: RegistryObject<OctaneBadge> = ITEMS.register(OCTANE_BADGE_ID) { OctaneBadge() }
}