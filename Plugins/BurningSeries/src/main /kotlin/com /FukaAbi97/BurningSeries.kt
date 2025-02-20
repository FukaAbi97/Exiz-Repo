package com.fukaabi97.burningseries

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.extractors.*
import org.jsoup.Jsoup

class BurningSeries : MainAPI() {
    override var name = "BurningSeries"
    override var mainUrl = "https://bs.to"
    override var lang = "de"
    override val supportedTypes = setOf(TvType.TvSeries)

    override suspend fun search(query: String): List<SearchResponse> {
        val doc = Jsoup.connect("$mainUrl/?s=$query").get()
        val results = mutableListOf<SearchResponse>()

        for (element in doc.select("div.series a")) {
            val title = element.text()
            val url = element.attr("href")
            results.add(TvSeriesSearchResponse(title, "$mainUrl$url", this.name))
        }
        return results
    }
}
