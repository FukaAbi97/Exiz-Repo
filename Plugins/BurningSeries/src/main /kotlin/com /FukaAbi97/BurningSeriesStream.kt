package com.fukaabi97

import com.lagradost.cloudstream3.LoadResponse
import com.lagradost.cloudstream3.TvType

class BurningSeriesStream : BurningSeries() {
    override var mainUrl = "https://burningseries.to"
    override var name = "BurningSeries"
    override val supportedTypes = setOf(
        TvType.Movie,
        TvType.TvSeries,
    )

    override suspend fun load(url: String): LoadResponse? {
        return super.load(url).apply { this?.type = TvType.TvSeries }
    }
}
