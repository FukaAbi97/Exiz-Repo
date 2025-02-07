package com.fukaabi97

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin
import android.content.Context

@CloudstreamPlugin
class BurningSeriesPlugin : Plugin() {
    override fun load(context: Context) {
        // Alle Provider sollten so registriert werden. Nicht direkt zur Liste hinzufügen!
        registerMainAPI(BurningSeries())
        registerMainAPI(BurningSeriesStream())
    }
}
